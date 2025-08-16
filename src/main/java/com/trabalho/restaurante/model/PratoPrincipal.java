package com.trabalho.restaurante.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
public class PratoPrincipal extends Pratos{
    private String acompanhamento;
    private boolean isVegan;



    public PratoPrincipal(int id, String nome, double preco, String acompanhamento, boolean isVegan, String imagens, double avaliacao) {
        super(id, nome, preco, imagens, avaliacao);
        this.acompanhamento = acompanhamento;
        this.isVegan = isVegan;
    }

    public PratoPrincipal(String nome, double preco, String acompanhamento, boolean isVegan, String imagens, double avaliacao) {
        super(nome, preco, imagens, avaliacao);
        this.acompanhamento = acompanhamento;
        this.isVegan = isVegan;
    }
    
    @Override
    public String descricao() {
        return String.format(
                "%s %s\n" +
                        "Uma opção %s, preparada com ingredientes selecionados e servida com %s.\n" +
                        "Ideal para quem busca sabor e qualidade em cada detalhe do prato.\n" +
                        "Preço: R$ %.2f\n",
                this.getNome(),
                isVegan ? "(Vegano)" : "",
                isVegan ? "leve e sustentável" : "clássica e saborosa",
                acompanhamento.toLowerCase(),
                this.getPreco()
        );
    }
}