package com.trabalho.restaurante.model;

import com.trabalho.restaurante.model.db.EnderecoDAO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Restaurante {
    private int id;
    private String nome;
    private int avaliacao;
    private Endereco endereco;

    public Restaurante(String nome, int avaliacao, Endereco endereco) {
        this.nome = nome;
        this.avaliacao = avaliacao;
        this.endereco = endereco;
    }
}
