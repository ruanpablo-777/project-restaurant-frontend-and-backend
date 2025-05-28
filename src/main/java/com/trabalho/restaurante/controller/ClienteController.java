package com.trabalho.restaurante.controller;

import com.trabalho.restaurante.model.Cliente;
import com.trabalho.restaurante.model.Endereco;
import com.trabalho.restaurante.model.db.ClienteDAO;
import com.trabalho.restaurante.model.db.ConexaoDB;
import com.trabalho.restaurante.model.db.EnderecoDAO;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

@RestController
@RequestMapping("/cliente")

public class ClienteController {

    // 🔸 Cadastrar Cliente
    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarCliente(@RequestBody Cliente cliente) {
        try {
            // Cadastrar endereço primeiro
            Endereco endereco = cliente.getEndereco();
            EnderecoDAO enderecoDAO = new EnderecoDAO();
            int idEndereco = enderecoDAO.inserir(endereco);

            endereco.setId(idEndereco);
            cliente.setEndereco(endereco);

            // Cadastrar cliente
            ClienteDAO clienteDAO = new ClienteDAO();
            int idCliente = clienteDAO.inserir(cliente);

            return ResponseEntity.ok(Map.of(
                    "status", "success",
                    "message", "Cliente cadastrado com sucesso",
                    "idCliente", idCliente
            ));

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                    "status", "error",
                    "message", "Erro ao cadastrar cliente: " + e.getMessage()
            ));
        }
    }

    // 🔸 Login com sessão
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Cliente request, HttpSession session) {
        try (Connection conexao = ConexaoDB.getConexao()) {
            ClienteDAO dao = new ClienteDAO(conexao);
            Cliente cliente = dao.login(request.getEmail(), request.getSenha());

            if (cliente != null) {
                session.setAttribute("clienteId", cliente.getId());
                session.setAttribute("nome", cliente.getNome());

                return ResponseEntity.ok(Map.of(
                        "status", "success",
                        "message", "Login realizado com sucesso",
                        "nome", cliente.getNome()
                ));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of(
                        "status", "error",
                        "message", "Email ou senha incorretos"
                ));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "status", "error",
                    "message", "Erro no servidor: " + e.getMessage()
            ));
        }
    }

    // 🔸 Buscar endereço do cliente logado
    @GetMapping("/endereco")
    public ResponseEntity<?> buscarEndereco(HttpSession session) {
        Long clienteId = (Long) session.getAttribute("clienteId");

        if (clienteId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of(
                    "status", "error",
                    "message", "Usuário não está logado"
            ));
        }

        try (Connection conexao = ConexaoDB.getConexao()) {
            ClienteDAO dao = new ClienteDAO(conexao);
            Endereco endereco = dao.buscarEnderecoPorClienteId(clienteId);

            if (endereco != null) {
                return ResponseEntity.ok(Map.of(
                        "status", "success",
                        "endereco", endereco
                ));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
                        "status", "error",
                        "message", "Endereço não encontrado"
                ));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "status", "error",
                    "message", "Erro no servidor: " + e.getMessage()
            ));
        }
    }

    @PostMapping("/comprar")
    public ResponseEntity<?> comprar(HttpSession session) {
        Object idObj = session.getAttribute("clienteId");
        Long clienteId = null;

        if (idObj instanceof Integer) {
            clienteId = ((Integer) idObj).longValue();
        } else if (idObj instanceof Long) {
            clienteId = (Long) idObj;
        }

        if (clienteId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of(
                    "status", "error",
                    "message", "Usuário não está logado"
            ));
        }

        try (Connection conexao = ConexaoDB.getConexao()) {
            ClienteDAO dao = new ClienteDAO(conexao);
            Endereco endereco = dao.buscarEnderecoPorClienteId(clienteId);

            if (endereco == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
                        "status", "error",
                        "message", "Endereço não encontrado"
                ));
            }

            return ResponseEntity.ok(Map.of(
                    "status", "success",
                    "message", "Compra realizada com sucesso",
                    "enderecoEntrega", endereco
            ));

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "status", "error",
                    "message", "Erro no servidor: " + e.getMessage()
            ));
        }
    }


    // 🔸 Logout
    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok(Map.of(
                "status", "success",
                "message", "Logout realizado com sucesso"
        ));
    }
}
