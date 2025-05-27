package com.trabalho.restaurante.model;

public class Bebida extends Comida {
    private boolean isAlcoolica;
    private String volume;

    public Bebida(int id, String nome, String descricao, double preco, boolean isAlcoolica, String volume, String tipo, String imagens) {
        super(id, nome, descricao, preco, tipo, imagens);
        this.isAlcoolica = isAlcoolica;
        this.volume = volume;
    }

    public Bebida(String nome, String descricao, double preco, boolean isAlcoolica, String volume, String tipo, String imagens) {
        super(0,nome, descricao, preco, tipo, imagens);
        this.isAlcoolica = isAlcoolica;
        this.volume = volume;

    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("Bebida: " + nome + " - " + descricao + " - " + volume +
                (isAlcoolica ? " (Alcoólica)" : " (Não alcoólica)") + " - R$" + preco);
    }

    // Getters e Setters específicos
    public boolean isAlcoolica() {
        return isAlcoolica;
    }

    public void setAlcoolica(boolean alcoolica) {
        isAlcoolica = alcoolica;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }
}
