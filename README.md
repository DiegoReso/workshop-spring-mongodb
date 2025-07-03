# Spring Boot & MongoDB Exercises API

[![Licença MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5.3-blue.svg?logo=spring-boot&logoColor=white)](https://spring.io/projects/spring-boot)
[![MongoDB](https://img.shields.io/badge/MongoDB-6.0+-green.svg?logo=mongodb&logoColor=white)](https://www.mongodb.com)

Uma aplicação de exemplo desenvolvida com **Spring Boot** para explorar e praticar a integração com o **MongoDB**, focando em modelagem de dados NoSQL, consultas avançadas e conversão de DTOs.

---

## Visão Geral

Este projeto serve como um ambiente prático para exercícios de Spring Boot com MongoDB. Ele demonstra:

* **Modelagem de Documentos:** Como representar entidades como `User`, `Post` e `Comment` no MongoDB.
* **Relacionamentos Flexíveis:** Uso de **aninhamento (embedding)** para dados frequentemente acessados juntos (ex: autor em post, comentários em post) e **referências (`@DBRef`)** para relações "um-para-muitos" com carregamento lazy (ex: posts de um usuário).
* **Consultas Avançadas:** Implementação de endpoints RESTful com consultas complexas que filtram dados por múltiplos critérios (período de data, texto, autores, etc.).
* **Conversão DTO <-> Domínio:** Melhores práticas para mapear objetos entre DTOs e entidades de domínio usando Streams API e construtores específicos.

---

## Tecnologias Utilizadas

* ⚪ **Spring Boot**: Framework para construção rápida de aplicações Java.
* ⚪ **Spring Data MongoDB**: Abstração para interação fácil com o MongoDB.
* ⚪ **MongoDB**: Banco de dados NoSQL orientado a documentos.
* ⚪ **Lombok**: Redução de boilerplate code.
* ⚪ **Maven**: Ferramenta de automação de build.

---

## Como Iniciar o Projeto

Siga os passos abaixo para configurar e rodar a API localmente:
#### A API estará disponível em `http://localhost:8080`

#### Properties

spring.data.mongodb.uri=mongodb://localhost:27017/workshop_mongodb
logging.level.org.springframework.data.mongodb.core.MongoTemplate=DEBUG
logging.level.org.springframework.data.mongodb.core.MongoAction=DEBUG


### Pré-requisitos:

* Java 21
* Maven
* MongoDB
* Sua IDE favorita (IntelliJ IDEA, VS Code, Eclipse)

---

## Estrutura de Dados e Relacionamentos

Este projeto explora as seguintes modelagens e relações:

* User: Um documento raiz (@Document(collection = "user")).
  - Pode conter uma lista de Posts referenciados via @DBRef para demonstrar a relação um-para-muitos com carregamento lazy.

* Post: Um documento raiz (@Document(collection = "post")).
  - Contém um objeto User aninhado (author) representando o autor do post, para acesso rápido aos detalhes do autor.
  - Contém uma lista de Comments aninhados (comments), onde cada Comment por sua vez tem um User aninhado (author do comentário).

* Comment: Um documento raiz @Document(collection = "comment")).
  - Possui campos como id, text, date e um User author (também aninhado) que representa o autor do comentário.

---

## API Endpoints Principais

#### Usuários (`/users`)

* **GET** `/users`: Lista todos os usuários cadastrados.
* **GET** `/users/{id}`: Busca um usuário específico pelo ID.
* **POST** `/users`: Insere um novo usuário no sistema.
* **PUT** `/users/{id}`: Atualiza os dados de um usuário existente.
* **DELETE** `/users/{id}`: Remove permanentemente um usuário.

#### Posts (`/posts`)

* **GET** `/posts`: Lista todos os posts cadastrados.
* **GET** `/posts/{id}`: Busca um post específico pelo ID.
* **GET** `/posts/commentsearch?comment={text}`: Busca posts onde qualquer comentário contém o texto fornecido (case-insensitive).
* **GET** `/posts/titlesearch?title={text}`: Busca posts por título (case-insensitive).
* **GET** `/posts/authorsearch?author={text}`: Busca posts por autor (case-insensitive).
* **GET** `/posts/fullsearch?text={text}&minDate={YYYY-MM-DD}&maxDate={YYYY-MM-DD}`: Busca abrangente de posts por:
  - Texto (no título, corpo ou comentários) - (case-insensitive)
  - Data mínima (opcional)
  - Data máxima (opcional)
* **POST** `/posts`: Cria um novo post no sistema.
* **PUT** `/posts/{id}`: Atualiza o conteúdo de um post existente.
* **DELETE** `/posts/{id}`: Remove permanentemente um post.


## Exemplo da resposta DTO de um Post.

```json
{
    "id": "6866c586af718188363e948c",
    "date": "2024-07-01T00:00:00.000+00:00",
    "title": "Titulo 2 do joao",
    "body": "Corpo do segundo post do jaozeira.",
    "author": {
        "id": "6865b152c9c79d98e9090812",
        "name": "João Comentador",
        "email": "joao.com@example.com"
    },
    "comments": [
        {
            "id": "60d5f4f8b4e4a7b7c8d9r012",
            "text": "Claro e informativo, adorei",
            "date": "2024-07-01T00:00:00.000+00:00",
            "author": {
                "id": "6866c535af718188363e948b",
                "name": "João Comentador",
                "email": "joao.com@example.com"
            }
        }
    ]
}
