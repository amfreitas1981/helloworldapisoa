
# HelloWorld API SOA

![Build Status](https://img.shields.io/badge/build-passing-brightgreen)
![Coverage](https://img.shields.io/badge/coverage-100%25-success)
![Java](https://img.shields.io/badge/java-17-blue)
![License](https://img.shields.io/badge/license-MIT-blue.svg)
![Version](https://img.shields.io/badge/version-1.0.0-brightgreen)



## Descrição
A HelloWorld API é uma aplicação simples desenvolvida em Java com Spring Boot. Ela oferece uma estrutura básica de API REST com funcionalidades para criar e buscar dados de pessoas. A API permite que o usuário adicione uma pessoa pelo nome e retorne uma mensagem de boas-vindas personalizada, para testar requisições REST SOA.

## Estrutura do Projeto

O projeto é composto pelos seguintes arquivos principais:

- **HelloWorldApplication.java**: Classe principal da aplicação, que contém o método `main` para iniciar o Spring Boot.
- **HelloWorldController.java**: Controlador REST que gerencia os endpoints `POST` e `GET` para adicionar e buscar pessoas.
- **Pessoa.java**: Classe modelo representando uma pessoa, com um único atributo `nome`.
- **Response.java**: Classe modelo que encapsula a resposta enviada pelo endpoint `POST`.
- **application.properties**: Arquivo de configuração da aplicação, definindo porta do servidor e nome da aplicação.

## Configuração

A aplicação utiliza as seguintes configurações padrão definidas no arquivo `application.properties`:

```properties
server.port=9000
spring.application.name=helloworld
```

A API será executada na porta 9000.

## Endpoints

### 1. POST `/hello`
Endpoint para adicionar uma pessoa e retornar uma mensagem de boas-vindas.

- **Requisição**:
    - **Body** (JSON):
      ```json
      {
        "nome": "NomeDaPessoa"
      }
      ```

- **Resposta**:
    - **Status**: 200 OK
    - **Body** (JSON):
      ```json
      {
        "mensagem": "Ola NomeDaPessoa"
      }
      ```

### 2. GET `/hello/{nome}`
Endpoint para buscar uma pessoa pelo nome e retornar uma saudação.

- **Parâmetro**:
    - `nome` (string): Nome da pessoa a ser buscada.

- **Resposta**:
    - **Status**: 200 OK
    - **Body**: `Olaa NomeDaPessoa` (se a pessoa for encontrada)
    - **Body**: `Pessoa não encontrada` (se a pessoa não for encontrada)

## Estrutura das Classes

### HelloWorldApplication
A classe `HelloWorldApplication` inicializa a aplicação Spring Boot.

### HelloWorldController
A classe `HelloWorldController` contém a lógica para gerenciar o armazenamento e a recuperação das pessoas.

- **Atributos**:
    - `Map<String, Pessoa> pessoas`: Armazena as pessoas adicionadas, com o nome como chave.

- **Métodos**:
    - `welcome(Pessoa pessoa)`: Método `POST` para adicionar uma pessoa.
    - `welcomeName(String nome)`: Método `GET` para buscar uma pessoa pelo nome.

### Pessoa
A classe `Pessoa` representa o modelo de dados de uma pessoa, com os métodos `getNome` e `setNome`.

### Response
A classe `Response` representa o modelo de resposta, contendo uma mensagem de saudação, com os métodos `getMensagem` e `setMensagem`.
