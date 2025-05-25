package com.trabalho.restaurante.model;

import com.trabalho.restaurante.model.db.EnderecoDAO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Restaurante {
    int id;
    String nome;
    int avaliacao;
    Endereco endereco;

    public Restaurante(String nome, int avaliacao, Endereco endereco) {
        this.nome = nome;
        this.avaliacao = avaliacao;
        this.endereco = endereco;
    }
}
