package com.trabalho.restaurante.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pratos {
    private int id;
    private String nome;
    private double preco;
    private String imagens;
    private double avaliacao;

    public Pratos(int id, String nome, double preco, String imagens, double avaliacao) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.imagens = imagens;
        this.avaliacao = avaliacao;
    }

    public Pratos(String nome, double preco, String imagens, double avaliacao) {
        this.nome = nome;
        this.preco = preco;
        this.imagens = imagens;
        this.avaliacao = avaliacao;
    }

    public String descricao() {
        return  nome + " custa: R$"+preco;
    }
}
