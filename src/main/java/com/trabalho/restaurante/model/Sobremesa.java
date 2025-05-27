package com.trabalho.restaurante.model;

public class Sobremesa extends Comida {

    public Sobremesa(int id, String nome, String descricao, double preco, String tipo, String imagens) {
        super(id, nome, descricao, preco, tipo, imagens);
    }

    public Sobremesa(String nome, String descricao, double preco, String tipo, String imagens) {
        super(0, nome, descricao, preco, tipo, imagens);
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("Sobremesa: " + nome + " - " + descricao + " - R$" + preco);
    }
}
