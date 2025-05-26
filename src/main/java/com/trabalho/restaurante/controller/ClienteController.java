package com.trabalho.restaurante.controller;

import com.trabalho.restaurante.model.Cliente;
import com.trabalho.restaurante.model.Endereco;
import com.trabalho.restaurante.model.db.ClienteDAO;
import com.trabalho.restaurante.model.db.EnderecoDAO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Map;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "*")
public class ClienteController {

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarCliente(@RequestBody Cliente cliente) {
        try {
            // 1. Cadastrar endereço primeiro
            Endereco endereco = cliente.getEndereco();
            EnderecoDAO enderecoDAO = new EnderecoDAO();
            int idEndereco = enderecoDAO.inserir(endereco);

            // Atualiza o id do endereço no objeto cliente
            endereco.setId(idEndereco);
            cliente.setEndereco(endereco);

            // 2. Cadastrar cliente com o endereço já cadastrado
            ClienteDAO clienteDAO = new ClienteDAO();
            int idCliente = clienteDAO.inserir(cliente);

            // Retorna JSON com sucesso e id do cliente
            return ResponseEntity.ok(Map.of(
                    "status", "success",
                    "message", "Cliente cadastrado com sucesso",
                    "idCliente", idCliente
            ));

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();

            // Retorna JSON de erro com status 400 Bad Request
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                    "status", "error",
                    "message", "Erro ao cadastrar cliente: " + e.getMessage()
            ));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginCliente(@RequestBody Map<String, String> loginData) {
        String email = loginData.get("email");
        String senha = loginData.get("senha");

        try {
            ClienteDAO clienteDAO = new ClienteDAO();
            Cliente cliente = clienteDAO.selecionarEmail(email);

            if (cliente != null && cliente.getSenha().equals(senha)) {
                return ResponseEntity.ok("Login bem-sucedido!");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou senha incorretos.");
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro no servidor.");
        }
    }

}
