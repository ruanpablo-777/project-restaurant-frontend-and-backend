package com.trabalho.restaurante.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    private Integer id;
    private String nome;
    private Integer idade;
    private String email;
    private String senha;
    private Endereco endereco;

    public Cliente(Integer id, String nome, String email, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
    }
}
