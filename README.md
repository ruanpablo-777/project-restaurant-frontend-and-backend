
# Sistema de Gerenciamento de Restaurante

##  Descrição do Projeto

Este projeto consiste no desenvolvimento de uma aplicação Java para o gerenciamento de um restaurante, abrangendo operações relacionadas a clientes, pedidos, pratos e bebidas. A arquitetura está baseada no padrão MVC (Model-View-Controller), utilizando Java e bibliotecas padrão para acesso e manipulação de dados.

A aplicação foi implementada com foco na modularização, extensibilidade e separação de responsabilidades, proporcionando facilidade na manutenção e evolução do sistema.

##  Tecnologias Utilizadas

- Java 17
- JDBC (Java Database Connectivity)
- MySQL / PostgreSQL
- Maven
- Postman (para testes de API)

##  Estrutura de Pacotes

com.trabalho.restaurante
├── controller         → Camada de controle, gerenciamento de rotas e requisições.
├── model              → Definição das entidades de negócio.
├── model.db           → Implementação do acesso aos dados (DAO).
└── RestauranteApplication.java → Classe principal para inicialização da aplicação.

##  Mapeamento das Classes

###  Model

#### Bebida.java
Representa uma bebida disponível no restaurante.

**Atributos:**
- `id`: identificador único.
- `nome`: nome da bebida.
- `preco`: valor unitário.

#### Cliente.java
Define as informações dos clientes.

**Atributos:**
- `id`: identificador único.
- `nome`: nome completo.
- `telefone`: contato do cliente.
- `endereco`: referência à classe `Endereco`.

#### Endereco.java
Define os atributos relacionados ao endereço.

**Atributos:**
- `rua`
- `numero`
- `cidade`
- `estado`
- `cep`

#### PratoPrincipal.java, Sobremesa.java, Pratos.java
Classes representando os diferentes tipos de pratos ofertados.

**Atributos comuns:**
- `id`
- `nome`
- `descricao`
- `preco`

#### Restaurante.java
Informações gerais sobre o restaurante.

**Atributos:**
- `nome`
- `endereco`
- `lista de pratos`
- `lista de bebidas`

###  DAO (Data Access Object)

As classes do pacote `model.db` implementam o padrão DAO, realizando as operações CRUD diretamente no banco de dados.

**Exemplos:**
- **BebidaDAO.java** → inserção, remoção, atualização e consulta de bebidas.
- **ClienteDAO.java** → gerencia o ciclo de vida dos clientes.
- **ConexaoDB.java** → classe responsável pela conexão com o banco de dados.

###  Controller

Responsáveis por intermediar as requisições entre a camada de visualização (usuário) e as regras de negócio.

**Exemplos:**
- **BebidaController.java** → gerenciamento das operações sobre bebidas.
- **ClienteController.java** → registro, atualização e consulta de clientes.
- **CarrinhoController.java** → controle de itens adicionados ao carrinho de compra.
- **ComidaController.java** → manipulação das informações relacionadas aos pratos principais.
- **EnderecoController.java** → gestão dos endereços vinculados aos clientes.

##  Modelo Entidade-Relacionamento (ER)

[Cliente]───(1:N)───[Endereco]

[Cliente]───(N:N)───[Pratos]
                   |
                   └─[Bebida]

[Restaurante]───(1:N)───[Pratos]
                 └─(1:N)───[Bebida]

**Relacionamentos:**
- Um cliente pode ter vários endereços.
- Um cliente pode realizar múltiplos pedidos contendo diferentes pratos e bebidas.
- O restaurante mantém um cardápio com diversas bebidas e pratos.

##  Manual do Usuário

###  Cadastro de Cliente

**Classe:** `ClienteController`

**Método:**

```java
public void cadastrarCliente(Cliente cliente)
```

**Exemplo de uso:**

```java
Cliente cliente = new Cliente("João", "99999-9999", endereco);
clienteController.cadastrarCliente(cliente);
```

###  Listagem de Bebidas

**Classe:** `BebidaController`

**Método:**

```java
public List<Bebida> listarBebidas()
```

**Exemplo:**

```java
List<Bebida> bebidas = bebidaController.listarBebidas();
bebidas.forEach(System.out::println);
```

###  Adicionar Prato ao Carrinho

**Classe:** `CarrinhoController`

**Método:**

```java
public void adicionarPratoAoCarrinho(PratoPrincipal prato)
```

**Exemplo:**

```java
PratoPrincipal prato = new PratoPrincipal("Feijoada", "Tradicional", 35.0);
carrinhoController.adicionarPratoAoCarrinho(prato);
```

##  Configuração e Execução

1. **Clonar o Repositório:**

```bash
git clone <url-do-repositorio>
```

2. **Configurar o Banco de Dados:**

- Criar banco de dados MySQL ou PostgreSQL.
- Atualizar informações de acesso no arquivo `ConexaoDB.java`.

3. **Compilar e Executar:**

```bash
mvn clean install
mvn exec:java -Dexec.mainClass="com.trabalho.restaurante.RestauranteApplication"
```

##  Requisitos

- Java JDK 17+
- Maven 3.6+
- Banco de dados relacional (MySQL ou PostgreSQL)

