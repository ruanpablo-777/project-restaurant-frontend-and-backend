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
alter table bebida add column imagens varchar(255);
update bebida
set imagens = 'https://i.pinimg.com/736x/9e/c8/68/9ec86885e9dc5f96466a2b9228b87253.jpg'
where id = 1;
INSERT INTO bebida (nome, preco, isAlcoolica, volume, acompanhamento, isVegan, imagens) VALUES
('Refrigerante Guaraná', 6.50, false, '350ml', 'Batata frita', true, 'https://i.pinimg.com/736x/39/31/63/3931637bb5aceba1f4aea2ad126248e4.jpg'),
('Cerveja Corona', 8.00, true, '600ml', 'Porção de amendoim', true, 'https://i.pinimg.com/736x/07/d6/ff/07d6ff7cf764838c9074bfcb50a6725e.jpg'),
('Vinho Tinto Seco', 25.00, true, '750ml', 'Tábua de frios', false, 'https://i.pinimg.com/736x/44/9b/4d/449b4d0186602b22e923c271b23d0755.jpg'),
('Suco de Morango', 9.00, false, '500ml', 'Pão de queijo', false, 'https://i.pinimg.com/736x/48/18/e5/4818e51392e79d1f754fdb90495571ef.jpg');


select * from bebida;

-- Tabela pratoPrincipal
CREATE TABLE pratoPrincipal (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(200),
    preco DECIMAL(10,2) NOT NULL
);

ALTER TABLE bebida
ADD COLUMN avaliacao FLOAT CHECK (avaliacao >= 1 AND avaliacao <= 5);

UPDATE bebida SET avaliacao = 4.2 WHERE id = 1;
UPDATE bebida SET avaliacao = 3.6 WHERE id = 2;
UPDATE bebida SET avaliacao = 2.5 WHERE id = 3;
UPDATE bebida SET avaliacao = 5.0 WHERE id = 4;
UPDATE bebida SET avaliacao = 1.7 WHERE id = 5;



alter table pratoprincipal
add column imagens varchar(255);
select  * from pratoprincipal; 
INSERT INTO pratoprincipal (nome, preco, acompanhamento, isVegan, imagens) values
('Bife Acebolado', '20.00', 'Arroz , Feijão, Salada', false, 'https://i.pinimg.com/736x/9e/e2/69/9ee2691d4d30ab3143e1785456a88c51.jpg'),
('Frango Empanado', '15.00', 'Arroz , Feijão, Salada', false, 'https://i.pinimg.com/736x/f0/11/0b/f0110b07a520c5fba692d9475cc40962.jpg'),
('Salada', '10.00', 'Arroz , Feijão', true, 'https://i.pinimg.com/736x/4a/82/6d/4a826d70d3f474bc8731e0c0baa1e115.jpg'),
('Contra Filé', '25.00', 'Arroz , Feijão, Salada, macarrão', false, 'https://i.pinimg.com/736x/a8/d0/96/a8d0964e5b32a5ee255d6fdfa95728f5.jpg');

update pratoprincipal
set imagens  = 'https://i.pinimg.com/736x/7b/2e/59/7b2e5988db5797f6aa846285c37ce968.jpg'
where id = 1;

ALTER TABLE pratoprincipal
ADD COLUMN avaliacao FLOAT CHECK (avaliacao >= 1 AND avaliacao <= 5);

-- Atualizando avaliações com valores decimais
UPDATE pratoprincipal SET avaliacao = 4.5 WHERE id = 1;
UPDATE pratoprincipal SET avaliacao = 3.8 WHERE id = 2;
UPDATE pratoprincipal SET avaliacao = 2.9 WHERE id = 3;
UPDATE pratoprincipal SET avaliacao = 5.0 WHERE id = 4;
UPDATE pratoprincipal SET avaliacao = 1.5 WHERE id = 5;





-- Tabela sobremesa
CREATE TABLE sobremesa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(200),
    preco DECIMAL(10,2) NOT NULL
);
INSERT INTO sobremesa (nome, preco, temAcucar, peso, imagens) VALUES
('Bolo de Chocolate', 12.00, true, '150g', 'https://i.pinimg.com/736x/69/b4/a8/69b4a80990779a1c3f529ee371d68c27.jpg'),
('Torta de Limão', 10.50, true, '120g', 'https://i.pinimg.com/736x/e7/17/80/e717802a74baded680c31e6d24f384b2.jpg'),
('Salada de Frutas', 8.00, false, '200g', 'https://i.pinimg.com/736x/9d/37/06/9d370686708722f8b2eabc2d7afa4d1e.jpg'),
('Pudim de Leite', 9.00, true, '130g', 'https://i.pinimg.com/736x/88/c3/e9/88c3e9b62a3af5a6e978ee0955016fff.jpg'),
('Mousse de Maracujá', 8.50, true, '100g', 'https://i.pinimg.com/736x/a5/50/8c/a5508c3e5ec8ddb4bf7a64972fbb925e.jpg');
ALTER TABLE sobremesa
ADD COLUMN avaliacao FLOAT CHECK (avaliacao >= 1 AND avaliacao <= 5);
UPDATE sobremesa SET avaliacao = 4.7 WHERE id = 1;
UPDATE sobremesa SET avaliacao = 3.5 WHERE id = 2;
UPDATE sobremesa SET avaliacao = 2.8 WHERE id = 3;
UPDATE sobremesa SET avaliacao = 5.0 WHERE id = 4;
UPDATE sobremesa SET avaliacao = 4.9 WHERE id = 5;

alter table sobremesa 
drop column descricao;
select * from sobremesa;

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

ALTER TABLE endereco
ADD COLUMN estado VARCHAR(255);

select * from cliente;

select * from comida;

select * from endereco;

