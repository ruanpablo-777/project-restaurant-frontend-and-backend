//package com.trabalho.restaurante.controller;
//
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//public class ComidaController {
//
//    @GetMapping("/cardapio")
//    public ListComida> listarComidas() {
//        ComidaDAO dao = new ComidaDAO();
//        return dao.listarTodas();
//    }
//
//    @GetMapping("/comidas/{id}")
//    public  Comida buscarPorId(@PathVariable int id) {
//        ComidaDAO dao = new ComidaDAO();
//        return dao.buascarPorId(id);
//    }
//}
