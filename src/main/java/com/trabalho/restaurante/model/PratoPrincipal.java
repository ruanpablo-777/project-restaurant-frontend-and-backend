package com.trabalho.restaurante.model;

public class PratoPrincipal extends Comida {

    public PratoPrincipal(int id, String nome, String descricao, double preco, String tipo, String imagens) {
        super(id, nome, descricao, preco, tipo, imagens);
    }

    public PratoPrincipal(String nome, String descricao, double preco, String tipo, String imagens) {
        super(0,nome, descricao, preco, tipo, imagens);
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("Prato Principal: " + nome + " - " + descricao + " - R$" + preco);
    }
}
