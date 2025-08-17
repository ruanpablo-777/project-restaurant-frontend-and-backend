package com.trabalho.restaurante.controller;

import com.trabalho.restaurante.model.Bebida;
import com.trabalho.restaurante.model.Restaurante;
import com.trabalho.restaurante.model.db.BebidaDAO;
import com.trabalho.restaurante.model.db.RestauranteDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class RestauranteController {

    @GetMapping("/Restaurante/{id}")
    public Restaurante pegarRestaurantePorId(@PathVariable int id) throws SQLException,ClassNotFoundException {
        RestauranteDAO restauranteDAO = new RestauranteDAO();
        Restaurante pegarRestaurante = restauranteDAO.selecionar(id);
        return pegarRestaurante;
    }
}
