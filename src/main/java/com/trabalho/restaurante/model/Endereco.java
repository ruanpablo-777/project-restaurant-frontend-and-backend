package com.trabalho.restaurante.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Endereco {
    private int id;
    private String numero;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    public Endereco() {
    }

    public Endereco(int id, String numero, String rua, String bairro, String cidade, String estado, String cep) {
        this.id = id;
        this.numero = numero;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "Cep: " + cep +
                "\nCidade: " + cidade +
                "\nBairro: " + bairro +
                "\nRua: " + rua +
                "\nNúmero: " + numero;
    }
}
