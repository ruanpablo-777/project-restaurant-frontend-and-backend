package com.trabalho.restaurante.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sobremesa extends Pratos{
    private boolean temAcucar;
    private double peso;
    private String imagens;
    private double avaliacao;


    public Sobremesa(int id, String nome, double preco, boolean temAcucar, double peso, String imagens, double avaliacao) {
        super(id, nome, preco);
        this.temAcucar = temAcucar;
        this.peso = peso;
        this.imagens = imagens;
        this.avaliacao = avaliacao;

    }

    public Sobremesa(String nome, double preco, boolean temAcucar, double peso, String imagens, double avaliacao) {
        super(nome, preco);
        this.temAcucar = temAcucar;
        this.peso = peso;
        this.imagens = imagens;
        this.avaliacao = avaliacao;

    }
}