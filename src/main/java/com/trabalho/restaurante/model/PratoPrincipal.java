package com.trabalho.restaurante.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
public class PratoPrincipal extends Pratos{
    private String tipoCarne;
    private boolean isVegan;

    public PratoPrincipal(String nome, double preco, String descricao, String tipoCarne, boolean isVegan) {
        super(nome, preco, descricao);
        this.tipoCarne = tipoCarne;
        this.isVegan = isVegan;
    }
}
