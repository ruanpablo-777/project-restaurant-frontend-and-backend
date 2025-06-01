package com.trabalho.restaurante.controller;

import com.trabalho.restaurante.model.PratoPrincipal;
import com.trabalho.restaurante.model.Sobremesa;
import com.trabalho.restaurante.model.db.PPrincipalDAO;
import com.trabalho.restaurante.model.db.SobremesaDAO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class PratoPrincipalController {
    @GetMapping("/pratoprincipal")
    public List<PratoPrincipal> enviaPratoPrincipal() throws SQLException, ClassNotFoundException {
        PPrincipalDAO pprincipalDAO = new PPrincipalDAO();
        List<PratoPrincipal> listaPratoPrincipal = pprincipalDAO.selecionarAll();

        return listaPratoPrincipal;
    }

    @GetMapping("/Pratos/{id}")
    public PratoPrincipal pegarPratoPorId(@PathVariable int id) throws SQLException, ClassNotFoundException {
        PPrincipalDAO principalDAO = new PPrincipalDAO();
        PratoPrincipal pegarPrato = principalDAO.selecionarById(id);
        return pegarPrato;
    }

    @GetMapping("/Pratos/{id}/descricao")
    public String pegarDescricaoPorId(@PathVariable int id) throws SQLException,ClassNotFoundException {
        PPrincipalDAO pprincipalDAO = new PPrincipalDAO();
        PratoPrincipal pegarPrato = pprincipalDAO.selecionarById(id);
        String descricao = pegarPrato.descricao();
        return descricao;
    }
}