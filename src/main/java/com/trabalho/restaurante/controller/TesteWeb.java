package com.trabalho.restaurante.controller;

import com.trabalho.restaurante.model.Cliente;
import com.trabalho.restaurante.model.Endereco;
import com.trabalho.restaurante.model.db.EnderecoDAO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class TesteWeb {

    @GetMapping("/teste")
    public String teste() {
        return "Testado";
    }

    @GetMapping("/cliente")
    public Cliente enviaCliente() throws SQLException, ClassNotFoundException {
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        Endereco endereco = enderecoDAO.selecionar(1);
        Cliente cliente1 = new Cliente("cliente1", 18, "email@email.com", "1234",endereco);

        return cliente1;
    }
}
