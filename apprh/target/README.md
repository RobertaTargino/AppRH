# AppRH

O AppRH é um sistema de recursos humanos que desenvolvi para a atividade de Desenvolvimento de Sistemas Corporativos.

O sistema permite cadastrar e listar funcionários, além de cadastrar usuários e controlar o acesso por meio de login, com os perfis ADMIN e USER.

Tecnologias utilizadas
Java 25, Spring Boot 4.1.2, MariaDB, Maven, HTML, CSS e JavaScript.

 Como executar
1. Baixar o projeto e abrir no Eclipse.
2. Criar um banco de dados chamado `apprh` no MariaDB.
3. Configurar a conexão no `application.properties`, incluindo a senha pela variável `DB_PASSWORD`.
4. Executar a classe `ApprhApplication.java`.
5. Acessar `http://localhost:8080/login.html`.

Observação: utilizei a porta 3307 para o MariaDB e a porta 8080 para a aplicação.
