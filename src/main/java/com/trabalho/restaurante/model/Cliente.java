package com.trabalho.restaurante.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Cliente {
    String nome;
    int idade;
    String cpf;
    Endereco endereco;
    int numeroDoPedido;
}
