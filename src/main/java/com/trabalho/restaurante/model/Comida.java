package com.trabalho.restaurante.model;

public abstract class Comida {
    protected int id;
    protected String nome;
    protected String descricao;
    protected double preco;
    protected String tipo;
    protected String imagens;

    public Comida(int id, String nome, String descricao, double preco, String tipo, String imagens) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.tipo = tipo;
        this.imagens = imagens;
    }

    public Comida(String nome, String descricao, double preco, String tipo, String imagens) {
        this(0, nome, descricao, preco, tipo, imagens);
    }

    public abstract void mostrarDetalhes();

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getImagens() {return imagens;}
    public void setImagens(String imagens) { this.imagens = imagens;}
}
