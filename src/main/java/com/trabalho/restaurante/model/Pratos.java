package com.trabalho.restaurante.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
public class Pratos {
    String nome;
    double preco;
    String descricao;

    public Pratos(String nome, double preco, String descricao) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }

    public void descricao() {
        System.out.println("O(a) " + nome + " custa: R$"+preco);
    }
}
