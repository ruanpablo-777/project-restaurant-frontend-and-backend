package com.trabalho.restaurante.controller;

import com.trabalho.restaurante.model.Sobremesa;
import com.trabalho.restaurante.model.db.SobremesaDAO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class SobremesaController {
    @GetMapping("/sobremesa")
    public List<Sobremesa> enviasobremesa() throws SQLException, ClassNotFoundException {
        SobremesaDAO sobremesaDAO = new SobremesaDAO();
        List<Sobremesa> listasobremesa = sobremesaDAO.selecionarAll();

        return listasobremesa;
    }

    @GetMapping("/Sobremesas/{id}")
    public Sobremesa pegarSobremesaPorId(@PathVariable int id) throws SQLException, ClassNotFoundException {
        SobremesaDAO sobremesaDAO = new SobremesaDAO();
        Sobremesa pegarSobremesa = sobremesaDAO.selecionarById(id);
        return pegarSobremesa;
    }
}