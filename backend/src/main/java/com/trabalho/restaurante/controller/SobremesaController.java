package com.trabalho.restaurante.controller;

import com.trabalho.restaurante.model.Bebida;
import com.trabalho.restaurante.model.Sobremesa;
import com.trabalho.restaurante.model.db.BebidaDAO;
import com.trabalho.restaurante.model.db.SobremesaDAO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
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

    @GetMapping("/Sobremesas/descricao/{id}")
    public String pegarDescricaoPorId(@PathVariable int id) throws SQLException,ClassNotFoundException {
        SobremesaDAO sobremesaDAO = new SobremesaDAO();
        Sobremesa pegarSobremesa = sobremesaDAO.selecionarById(id);
        String descricao = pegarSobremesa.descricao();
        return descricao;
    }
}