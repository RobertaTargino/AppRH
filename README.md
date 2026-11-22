# AppRH

O AppRH é um sistema de recursos humanos desenvolvido para a disciplina de Desenvolvimento de Sistemas Corporativos, do curso de Sistemas para Internet da UERN.
O sistema permite cadastrar e listar funcionários.

## Tecnologias utilizadas

Java 25, Spring Boot 4.1.2, MariaDB, Maven, Lombok, HTML, CSS e JavaScript.

## Como executar
### 1. Baixar o projeto

1. Baixe o projeto pelo GitHub.
2. Extraia o arquivo ZIP.
3. Abra o Eclipse.
4. Selecione File > Import > Maven > Existing Maven Projects.
5. Selecione a pasta que contém o arquivo `pom.xml`.
6. Clique em Finish e aguarde o carregamento das dependências.

### 2. Configurar o banco de dados

Instale o MariaDB utilizando a porta 3307.
Abra o MySQL Client ou MariaDB Client e execute:

```sql
CREATE DATABASE IF NOT EXISTS apprh;
```

### 3. Configurar a conexão
No Eclipse, abra o arquivo `src/main/resources/application.properties` e confira as configurações:

```properties
spring.datasource.url=jdbc:mariadb://localhost:3307/apprh
spring.datasource.username=${DB_USERNAME:root}
spring.datasource.password=${DB_PASSWORD}
spring.jpa.hibernate.ddl-auto=update
server.port=8080
```

Para configurar a senha do banco de dados no Eclipse:

1. Acesse Run > Run Configurations.
2. Selecione a configuração da classe `ApprhApplication`.
3. Abra a aba Environment.
4. Clique em Add.
5. Em Name, informe `DB_PASSWORD`.
6. Em Value, informe a senha configurada no MariaDB.
7. Clique em Apply.

### 4. Iniciar a aplicação

Execute a classe `ApprhApplication.java` utilizando a configuração que contém a variável `DB_PASSWORD`.
Aguarde a inicialização do Spring Boot. As tabelas serão criadas ou atualizadas automaticamente pelo Hibernate.

## Primeiro acesso
Para acessar o sistema pela primeira vez, é necessário cadastrar um usuário no banco de dados.
Após iniciar a aplicação, abra o MySQL Client ou MariaDB Client e execute:

```sql
USE apprh;
```

Em seguida, execute o arquivo `teste.sql` disponibilizado no projeto ou utilize o comando:

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

Esse comando cadastra um usuário de teste com perfil ADMIN. A senha é armazenada utilizando BCrypt.
Para verificar o cadastro, execute:

```sql
SELECT username, role FROM users;
```

## Acessar o sistema

Abra o navegador e acesse:

http://localhost:8080/login.html

Utilize as seguintes credenciais:

- Usuário: `teste`
- Senha: `teste123`

Após realizar o login, será possível acessar as funcionalidades do sistema, incluindo o cadastro e a listagem de funcionários.

## Observações

- O MariaDB utiliza a porta 3307.
- A aplicação utiliza a porta 8080.
- O usuário de teste precisa ser cadastrado no banco antes do primeiro login.
- O projeto utiliza Lombok, que pode exigir configuração adicional no Eclipse para o reconhecimento dos métodos gerados.

## Teste de execução
O projeto foi baixado e executado em outro computador. Após configurar o MariaDB, criar o banco de dados e cadastrar o usuário de teste, a aplicação iniciou e o login foi realizado com sucesso.
