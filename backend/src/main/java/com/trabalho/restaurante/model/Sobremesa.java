package com.trabalho.restaurante.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sobremesa extends Pratos{
    private boolean temAcucar;
    private double peso;


    public Sobremesa(int id, String nome, double preco, boolean temAcucar, double peso, String imagens, double avaliacao) {
        super(id, nome, preco, imagens, avaliacao);
        this.temAcucar = temAcucar;
        this.peso = peso;

    }

    public Sobremesa(String nome, double preco, boolean temAcucar, double peso, String imagens, double avaliacao) {
        super(nome, preco, imagens, avaliacao);
        this.temAcucar = temAcucar;
        this.peso = peso;

    }


    @Override
    public String descricao() {
        return String.format(
                "%s %s\n" +
                        "Delicie-se com esta sobremesa %s, feita com ingredientes de alta qualidade e apresentada com um toque artesanal.\n" +
                        "Com aproximadamente %.0f gramas, ela é perfeita para encerrar sua refeição com equilíbrio e sofisticação.\n" +
                        "%s\n" +
                        "Preço: R$ %.2f\n",
                this.getNome(),
                temAcucar ? "" : "(Sem Açúcar)",
                temAcucar ? "doce e envolvente" : "leve e sem adição de açúcares, ideal para paladares mais delicados",
                peso,
                temAcucar
                        ? "Uma escolha que agrada aos amantes de sabores intensos e tradicionais."
                        : "Indicada para quem busca uma opção mais saudável, sem abrir mão do prazer.",
                this.getPreco()
        );
    }
}