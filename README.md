#CRIAÇÃO DO BANCO DE DADOS

-- Criar o banco de dados
CREATE DATABASE testeendereco;
USE testeendereco;

-- Tabela endereco
CREATE TABLE endereco (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cep VARCHAR(10) NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    bairro VARCHAR(100) NOT NULL,
    rua VARCHAR(100) NOT NULL,
    numero VARCHAR(10) NOT NULL
);

-- Tabela cliente
CREATE TABLE cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    idade INT NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(100) NOT NULL,
    endereco_id INT,
    FOREIGN KEY (endereco_id) REFERENCES endereco(id)
);

-- Tabela bebida
CREATE TABLE bebida (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    isAcoolica BOOLEAN,         -- Da primeira query INSERT
    volume VARCHAR(50),         -- Da primeira query INSERT
    acompanhamento VARCHAR(100), -- Da segunda query INSERT
    isVegan BOOLEAN              -- Da segunda query INSERT
);

-- Tabela pratoPrincipal
CREATE TABLE pratoPrincipal (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(200),
    preco DECIMAL(10,2) NOT NULL
);

-- Tabela sobremesa
CREATE TABLE sobremesa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(200),
    preco DECIMAL(10,2) NOT NULL
);

-- Tabela restaurante
CREATE TABLE restaurante (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    avaliacao DECIMAL(3,2) NOT NULL,  -- Avaliação como 4.5, 5.0, etc.
    endereco_id INT,
    FOREIGN KEY (endereco_id) REFERENCES endereco(id)
);



select * from cliente;
