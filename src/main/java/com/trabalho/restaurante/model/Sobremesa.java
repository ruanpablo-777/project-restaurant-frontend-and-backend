package com.trabalho.restaurante.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sobremesa extends Pratos{
    private boolean temAcucar;
    private double peso;

    public Sobremesa(int id, String nome, double preco, boolean temAcucar, double peso) {
        super(id, nome, preco);
        this.temAcucar = temAcucar;
        this.peso = peso;
    }

    public Sobremesa(String nome, double preco, boolean temAcucar, double peso) {
        super(nome, preco);
        this.temAcucar = temAcucar;
        this.peso = peso;
    }
}
