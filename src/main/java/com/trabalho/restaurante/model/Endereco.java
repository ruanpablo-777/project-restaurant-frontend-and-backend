package com.trabalho.restaurante.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Endereco {
    private int id;
    private int numero;
    private String rua;
    private String bairro;
    private String cidade;
    private int cep;

    public Endereco(int id, int numero, String rua, String bairro, String cidade, int cep) {
        this.id = id;
        this.numero = numero;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
    }

    public String toString() {
        return "Cep: " + cep +
                "\nCidade: " + cidade +
                "\nBairro: " + bairro +
                "\nRua: " + rua +
                "\nNúmero: " + numero;
    }
}
