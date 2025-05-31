package com.trabalho.restaurante.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sobremesa extends Pratos{
    private boolean temAcucar;
    private double peso;
    private String imagens;

    public Sobremesa(int id, String nome, double preco, boolean temAcucar, double peso, String imagens) {
        super(id, nome, preco);
        this.temAcucar = temAcucar;
        this.peso = peso;
        this.imagens = imagens;
    }

    public Sobremesa(String nome, double preco, boolean temAcucar, double peso, String imagens) {
        super(nome, preco);
        this.temAcucar = temAcucar;
        this.peso = peso;
        this.imagens = imagens;
    }
}