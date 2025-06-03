# CRIAÇÃO DO BANCO DE DADOS
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

CREATE TABLE comida (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(255),
    preco DECIMAL(10,2) NOT NULL,
    tipo ENUM('pratoPrincipal', 'bebida', 'sobremesa') NOT NULL,
    isAlcoolica BOOLEAN DEFAULT NULL,     -- Só para bebidas
    volume VARCHAR(50) DEFAULT NULL,       -- Só para bebidas
    acompanhamento VARCHAR(100) DEFAULT NULL,  -- Opicional
    isVegan BOOLEAN DEFAULT NULL           -- Opicional
);

INSERT INTO comida (nome, descricao, preco, tipo, isAlcoolica, volume) VALUES
('Cerveja', 'Cerveja gelada', 8.00, 'bebida', TRUE, '600ml'),
('Bife Acebolado', 'Bife com cebola', 25.00, 'pratoPrincipal', NULL, NULL),
('Pudim', 'Pudim de leite condensado', 10.00, 'sobremesa', NULL, NULL);

INSERT INTO comida (nome, descricao, preco, tipo, isAlcoolica, volume) VALUES
('Suco', 'Suco de Laranja', 3.00, 'bebida', false, '500ml'),
('Frango', 'Frango Empanado', 25.00, 'pratoPrincipal', NULL, NULL),
('Açai', 'Açai com leite condensado e banana', 15.00, 'sobremesa', NULL, NULL);

update comida
set imagens = 'https://i.pinimg.com/736x/3d/7e/0e/3d7e0ef489331b95e653239334b12e9e.jpg'
where id = 1;

update comida
set imagens = 'https://i.pinimg.com/736x/9e/c8/68/9ec86885e9dc5f96466a2b9228b87253.jpg'
where id = 4;

update comida
set imagens = 'https://i.pinimg.com/736x/bb/39/2a/bb392a7fa2c9cfc34146a171581501c1.jpg'
where id = 6;


select * from comida;
