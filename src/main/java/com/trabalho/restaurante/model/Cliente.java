package com.trabalho.restaurante.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.stream.Stream;

@Getter
@Setter
@AllArgsConstructor
public class Cliente {
    int id;
    String nome;
    int idade;
    String email;
    String senha;
    Endereco endereco;

    public Cliente(String nome, int idade, String email, String senha, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
    }
}
