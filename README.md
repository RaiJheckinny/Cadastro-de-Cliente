# Cadastro-de-Cliente
Projeto Cliente - Sistema de Gerenciamento de Clientes
Tecnologias Utilizadas
Java: 17
Spring Boot: Framework para desenvolvimento de aplicações Java.
PostgreSQL: Banco de dados relacional.
Docker: Plataforma para criação e gerenciamento de contêineres.
Thymeleaf: Motor de templates para renderização de páginas HTML.
Como Executar o Projeto

1. Iniciar o Banco de Dados
  Certifique-se de estar na raiz do projeto, onde está localizado o arquivo docker-compose.yml. Em seguida, execute:
  docker-compose up -d

2. Compilar e Executar o Projeto
  Navegue para o diretório onde o arquivo ClienteApplication.java está localizado:
  cd src/main/java/br/com/raijheckinny
  
  Compile o projeto com Maven:
  ./mvnw clean package
  
  Execute a aplicação Spring Boot:
  ./mvnw spring-boot:run

Detalhes das Rotas
O projeto possui as seguintes rotas para interação com a aplicação:

Formulário de Cadastro de Cliente

  URL: /cliente/form
  Método HTTP: GET
  Descrição: Exibe um formulário para o usuário inserir os dados de um novo cliente. Quando o formulário é enviado, os dados são enviados para a rota de salvamento.
  Salvar Cliente
  
  URL: /cliente/save
  Método HTTP: POST
  Descrição: Recebe os dados do cliente do formulário e salva as informações no banco de dados. Após o salvamento, o usuário é redirecionado para a página de listagem de clientes.
  Listagem de Clientes
  
  URL: /cliente/list
  Método HTTP: GET
  Descrição: Exibe uma lista de todos os clientes cadastrados. Os dados são recuperados do banco de dados e apresentados em uma tabela.
  Excluir Cliente
  
  URL: /cliente/remover/{id}
  Método HTTP: GET
  Descrição: Remove um cliente específico do banco de dados baseado no id fornecido. Após a exclusão, o usuário é redirecionado para a página de listagem de clientes.
  Editar Cliente
  
  URL: /cliente/editar/{id}
  Método HTTP: GET
  Descrição: Exibe um formulário pré-preenchido com os dados do cliente selecionado para edição. Após a edição e envio do formulário, as alterações são salvas no banco de dados.

Tecnologias Gerais do Projeto

  HTML: Linguagem de marcação usada para estruturar o conteúdo das páginas web.
  CSS: Folhas de estilo usadas para estilizar o conteúdo HTML.
  JavaScript: Linguagem de programação para adicionar interatividade às páginas web.
  Spring Boot: Framework Java para facilitar a configuração e desenvolvimento de aplicações.
  Thymeleaf: Motor de templates que integra o Spring Boot para renderização de páginas HTML dinâmicas.
  PostgreSQL: Sistema de gerenciamento de banco de dados usado para armazenar dados da aplicação.
  Docker: Ferramenta para criar e gerenciar contêineres, facilitando a configuração do ambiente de desenvolvimento e produção.
