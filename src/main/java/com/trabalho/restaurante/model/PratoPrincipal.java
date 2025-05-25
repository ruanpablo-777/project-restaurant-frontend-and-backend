package com.trabalho.restaurante.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
public class PratoPrincipal extends Pratos{
    private String acompanhamento;
    private boolean isVegan;

    public PratoPrincipal(int id, String nome, double preco, String acompanhamento, boolean isVegan) {
        super(id, nome, preco);
        this.acompanhamento = acompanhamento;
        this.isVegan = isVegan;
    }

    public PratoPrincipal(String nome, double preco, String acompanhamento, boolean isVegan) {
        super(nome, preco);
        this.acompanhamento = acompanhamento;
        this.isVegan = isVegan;
    }
}
