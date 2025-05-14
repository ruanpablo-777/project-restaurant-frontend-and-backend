package com.trabalho.restaurante.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bebida extends Pratos{
    private boolean isAlcoolica;
    private int volume;

    public Bebida(String nome, double preco, String descricao, boolean isAlcoolica, int volume) {
        super(nome, preco, descricao);
        this.isAlcoolica = isAlcoolica;
        this.volume = volume;
    }
}
