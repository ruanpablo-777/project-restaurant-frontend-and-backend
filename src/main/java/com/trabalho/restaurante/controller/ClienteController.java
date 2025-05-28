package com.trabalho.restaurante.controller;

import com.trabalho.restaurante.model.Sobremesa;
import com.trabalho.restaurante.model.db.SobremesaDAO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ClienteController {
    @PostMapping("/cadastro")
    public List<Sobremesa> recebeCadastro() throws SQLException, ClassNotFoundException {
        SobremesaDAO sobremesaDAO = new SobremesaDAO();
        List<Sobremesa> listasobremesa = sobremesaDAO.selecionarAll();

        return listasobremesa;
    }
    @PostMapping("/login")
    public List<Sobremesa> recebeCliente() throws SQLException, ClassNotFoundException {
        SobremesaDAO sobremesaDAO = new SobremesaDAO();
        List<Sobremesa> listasobremesa = sobremesaDAO.selecionarAll();

        return listasobremesa;
    }
}
