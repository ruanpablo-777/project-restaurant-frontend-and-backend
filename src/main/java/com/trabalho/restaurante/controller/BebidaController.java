package com.trabalho.restaurante.controller;

import com.trabalho.restaurante.model.Bebida;
import com.trabalho.restaurante.model.db.BebidaDAO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class BebidaController {
    @GetMapping("/bebida")
    public List<Bebida> enviaBebida() throws SQLException, ClassNotFoundException {
        BebidaDAO bebidaDAO = new BebidaDAO();
        List<Bebida> listabebida = bebidaDAO.selecionarAll();

        return listabebida;
    }

    @GetMapping("/Bebidas/{id}")
    public Bebida pegarBedidaPorId(@PathVariable int id) throws SQLException,ClassNotFoundException {
        BebidaDAO bebidaDAO = new BebidaDAO();
        Bebida pegarBebida = bebidaDAO.selecionarById(id);
        return pegarBebida;
    }

    @GetMapping("/Bebidas/{id}/descricao")
    public String pegarDescricaoPorId(@PathVariable int id) throws SQLException,ClassNotFoundException {
        BebidaDAO bebidaDAO = new BebidaDAO();
        Bebida pegarBebida = bebidaDAO.selecionarById(id);
        String descricao = pegarBebida.descricao();
        return descricao;
    }
}
