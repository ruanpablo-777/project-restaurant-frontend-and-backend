package com.trabalho.restaurante.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bebida extends Pratos{
    private boolean isAlcoolica;
    private int volume;

    public Bebida(int id, String nome, double preco, boolean isAlcoolica, int volume) {
        super(id, nome, preco);
        this.isAlcoolica = isAlcoolica;
        this.volume = volume;
    }

    public Bebida(String nome, double preco, boolean isAlcoolica, int volume) {
        super(nome, preco);
        this.isAlcoolica = isAlcoolica;
        this.volume = volume;
    }
}
