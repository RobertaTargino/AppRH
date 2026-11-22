AppRH — Sistema de Recursos Humanos

O AppRH é um sistema web desenvolvido para a disciplina Desenvolvimento de Sistemas Corporativos, do curso de Sistemas para Internet da UERN.
O sistema permite cadastrar e listar funcionários.

Tecnologias utilizadas no projeto.

Java 25
Spring Boot 4.1.2
MariaDB
Maven
HTML, CSS e JavaScript
Lombok

## Como executar

 1. Baixar e importar o projeto

1. Baixe o projeto pelo GitHub.
2. Extraia o arquivo ZIP.
3. Abra o Eclipse.
4. Selecione File → Import → Maven → Existing Maven Projects.
5. Selecione a pasta que contém o arquivo `pom.xml`.
6. Clique em **Finish** e aguarde o carregamento das dependências.

 2. Configurar o banco de dados

Instale o MariaDB e configure a conexão com a porta **3307**.
Abra o MySQL Client ou MariaDB Client e execute:

```sql
CREATE DATABASE IF NOT EXISTS apprh;
```

O banco de dados será utilizado para armazenar os usuários e funcionários cadastrados.

3. Configurar a conexão no Eclipse
Abra o arquivo `src/main/resources/application.properties` e confira:

```properties
spring.datasource.url=jdbc:mariadb://localhost:3307/apprh
spring.datasource.username=${DB_USERNAME:root}
spring.datasource.password=${DB_PASSWORD}
spring.jpa.hibernate.ddl-auto=update
server.port=8080
```

Para informar a senha do MariaDB:

1. No Eclipse, acesse **Run → Run Configurations**.
2. Selecione a configuração da classe `ApprhApplication`.
3. Abra a aba **Environment**.
4. Clique em **Add**.
5. Em **Name**, informe `DB_PASSWORD`.
6. Em **Value**, informe a senha do MariaDB.
7. Clique em **Apply**.

A senha do banco não deve ser publicada no GitHub.
Primeiro acesso — Cadastro do usuário de teste

**IMPORTANTE: Em uma instalação nova, é necessário cadastrar um usuário no banco de dados antes de conseguir entrar no sistema e acessar o cadastro de funcionários.**

Após iniciar a aplicação pela primeira vez, abra o MySQL Client ou MariaDB Client e selecione o banco:

```sql
USE apprh;
```

Execute o arquivo `teste.sql`, disponibilizado no projeto, ou utilize o comando abaixo:

```sql
INSERT INTO users (username, password, role)
VALUES (
    'teste',
    '$2a$12$MDo5RkUEND8Jfo1NMyp83O9.594DUgU/vKqwB2v6ePBJ2q2mnyRie',
    'ADMIN'
)
ON DUPLICATE KEY UPDATE
    password = VALUES(password),
    role = VALUES(role);
```

O comando cadastra um usuário de demonstração com senha armazenada utilizando BCrypt.

Para verificar se o usuário foi cadastrado:

```sql
SELECT username, role FROM users;
```

Credenciais para acessar o sistema

| Campo | Informação |
|---|---|
| Usuário | `teste` |
| Senha | `teste123` |

Após cadastrar o usuário, acesse:

http://localhost:8080/login.html

Entre com as credenciais acima. Depois do login, será possível acessar as funcionalidades disponíveis, incluindo o cadastro e a listagem de funcionários.

## Observações

- O MariaDB utiliza a porta **3307**.
- O AppRH utiliza a porta **8080**.
- O usuário de demonstração deve ser utilizado apenas para testes locais.
- O projeto utiliza Lombok. Algumas instalações do Eclipse podem precisar da integração do Lombok para reconhecer automaticamente os métodos `get` e `set`.

## Teste em outro computador
O projeto foi baixado e executado em outro computador, com instalação do MariaDB, criação do banco `apprh` e cadastro do usuário de demonstração.
Após essas configurações, foi possível iniciar o AppRH e realizar o login com sucesso.
