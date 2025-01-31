# Cadastro-de-Cliente
Sistema de Gerenciamento de Clientes desenvolvido em Java com Spring Boot.

## Tecnologias Utilizadas

- **Java**: 17
- **Spring Boot**: Framework para desenvolvimento de aplicações Java.
- **PostgreSQL**: Banco de dados relacional.
- **Docker**: Plataforma para criação e gerenciamento de contêineres.
- **Thymeleaf**: Motor de templates para renderização de páginas HTML.

## Endpoints

### Formulário de Cadastro de Cliente
- **URL**: `/cliente/form`
- **Método HTTP**: `GET`
- **Descrição**: Exibe um formulário para o usuário inserir os dados de um novo cliente.

### Salvar Cliente
- **URL**: `/cliente/save`
- **Método HTTP**: `POST`
- **Descrição**: Recebe os dados do cliente e os salva no banco de dados.

### Listagem de Clientes
- **URL**: `/cliente/list`
- **Método HTTP**: `GET`
- **Descrição**: Exibe uma lista de todos os clientes cadastrados.

### Excluir Cliente
- **URL**: `/cliente/remover/{id}`
- **Método HTTP**: `GET`
- **Descrição**: Remove um cliente específico baseado no ID.

### Editar Cliente
- **URL**: `/cliente/editar/{id}`
- **Método HTTP**: `GET`
- **Descrição**: Exibe um formulário para editar os dados de um cliente.
