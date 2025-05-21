package com.trabalho.restaurante.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
public class PratoPrincipal extends Pratos{
    private String acompanhamento;
    private boolean isVegan;

    public PratoPrincipal(String nome, double preco, String descricao, String acompanhamento, boolean isVegan) {
        super(nome, preco, descricao);
        this.acompanhamento = acompanhamento;
        this.isVegan = isVegan;
    }
}
