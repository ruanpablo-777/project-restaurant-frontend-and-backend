package com.trabalho.restaurante.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
public class PratoPrincipal extends Pratos{
    private String acompanhamento;
    private boolean isVegan;
    private String imagens;
    private double avaliacao;


    public PratoPrincipal(int id, String nome, double preco, String acompanhamento, boolean isVegan, String imagens, double avaliacao) {
        super(id, nome, preco);
        this.acompanhamento = acompanhamento;
        this.isVegan = isVegan;
        this.imagens = imagens;
        this.avaliacao = avaliacao;

    }

    public PratoPrincipal(String nome, double preco, String acompanhamento, boolean isVegan, String imagens, double avaliacao) {
        super(nome, preco);
        this.acompanhamento = acompanhamento;
        this.isVegan = isVegan;
        this.imagens = imagens;
        this.avaliacao = avaliacao;

    }
}