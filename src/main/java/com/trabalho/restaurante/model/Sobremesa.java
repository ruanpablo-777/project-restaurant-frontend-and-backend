package com.trabalho.restaurante.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sobremesa extends Pratos{
    private boolean temAcucar;
    private double peso;

    public Sobremesa(String nome, double preco, String descricao, boolean temAcucar, double peso) {
        super(nome, preco, descricao);
        this.temAcucar = temAcucar;
        this.peso = peso;
    }
}
