package com.trabalho.restaurante.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Endereco {
    private int numero;
    private String rua;
    private String bairro;
    private String cidade;
    private int cep;


    public String toString() {
        return "Cep: " + cep +
                "\nCidade: " + cidade +
                "\nBairro: " + bairro +
                "\nRua: " + rua +
                "\nNúmero: " + numero;
    }
}
