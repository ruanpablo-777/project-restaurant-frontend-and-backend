package com.trabalho.restaurante.controller;

import com.trabalho.restaurante.model.Endereco;
import com.trabalho.restaurante.model.db.ClienteDAO;
import com.trabalho.restaurante.model.db.EnderecoDAO;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.Map;

@RestController
public class EnderecoController {
    @GetMapping("/endereco")
    public ResponseEntity<?> buscarEndereco(HttpSession session) {
        int clienteId = (int) session.getAttribute("clienteId");

        if (clienteId == -1) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of(
                    "status", "error",
                    "message", "Usuário não está logado"
            ));
        }

        try {
            ClienteDAO dao = new ClienteDAO();
            EnderecoDAO enderecoDAO = new EnderecoDAO();
            Endereco endereco = enderecoDAO.selecionar(dao.selecionarID(clienteId).getEndereco().getId());

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
}
