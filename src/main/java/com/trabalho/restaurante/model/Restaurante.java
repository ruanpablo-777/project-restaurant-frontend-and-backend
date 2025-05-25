package com.trabalho.restaurante.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Restaurante {
    String nome;
    int avaliacao;
    Endereco endereco;
}
