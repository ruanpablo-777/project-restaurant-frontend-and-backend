package com.trabalho.restaurante.controller;

import com.trabalho.restaurante.model.db.ComidaDAO;
import com.trabalho.restaurante.model.Comida;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ComidaController {

    @GetMapping("/cardapio")
    public List<Comida> listarComidas() {
        ComidaDAO dao = new ComidaDAO();
        return dao.listarTodas();
    }
}
