package com.trabalho.restaurante.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bebida extends Pratos{
    private boolean isAlcoolica;
    private String volume;
    private String imagens;

    public Bebida(int id, String nome, double preco, boolean isAlcoolica, String volume, String imagens) {
        super(id, nome, preco);
        this.isAlcoolica = isAlcoolica;
        this.volume = volume;
        this.imagens = imagens;
    }

    public Bebida(String nome, double preco, boolean isAlcoolica, String volume, String imagens) {
        super(nome, preco);
        this.isAlcoolica = isAlcoolica;
        this.volume = volume;
        this.imagens = imagens;
    }
}