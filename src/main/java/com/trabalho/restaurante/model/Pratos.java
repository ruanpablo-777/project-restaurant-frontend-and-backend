package com.trabalho.restaurante.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pratos {
    int id;
    String nome;
    double preco;

    public Pratos(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Pratos(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public void descricao() {
        System.out.println("O(a) " + nome + " custa: R$"+preco);
    }
}
