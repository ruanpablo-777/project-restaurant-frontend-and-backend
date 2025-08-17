package com.trabalho.restaurante.model;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
//@AllArgsConstructor
public class Cliente {
    private int id;
    private String nome;
    private int idade;
    private String email;
    private String senha;
    private Endereco endereco;

    public Cliente(int id ,String nome, int idade, String email, String senha, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
    }

    public Cliente(String nome, int idade, String email) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;

    }

    public Cliente () {}
}
