package com.trabalho.restaurante.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteWeb {

    @GetMapping("/teste")
    public String teste() {
        return "Testado";
    }
}
