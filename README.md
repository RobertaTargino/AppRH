# AppRH

O AppRH é um sistema de recursos humanos desenvolvido para a disciplina de Desenvolvimento de Sistemas Corporativos, do curso de Sistemas para Internet da UERN.
O sistema permite cadastrar e listar funcionários, além de controlar o acesso por meio de login.
## Como executar

1. Acesse o repositorio desse arquivo.
2. Clique em Code e depois em Download ZIP.
3. Extraia o arquivo baixado.
4. Abra o Eclipse e selecione File > Import.
5. Escolha Maven > Existing Maven Projects e clique em Next.
6. Selecione a pasta extraída que contém o arquivo `pom.xml` e clique em Finish.

## Criar o banco de dados
1. Abra o MySQL Client ou MariaDB Client.
2. Informe a senha configurada durante a instalação do MariaDB.
3. Execute o comando:

```sql
CREATE DATABASE apprh;
```

4. Selecione o banco:

```sql
USE apprh;
```

O MariaDB deve estar configurado na porta 3307.

## Configurar e iniciar o sistema

1. No Eclipse, acesse Run > Run Configurations.
2. Selecione a configuração da classe `ApprhApplication`.
3. Na aba Environment, clique em Add.
4. Em Name, digite `DB_PASSWORD`.
5. Em Value, informe a senha do MariaDB.
6. Clique em Apply e execute a aplicação.

Aguarde a inicialização para que as tabelas sejam criadas no banco de dados.

## Criar usuário para o primeiro acesso

Volte ao MariaDB Client e execute:

```sql
USE apprh;

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

Esse comando cadastra o usuário necessário para entrar no sistema.
## Acessar o AppRH

Abra http://localhost:8080/login.html

**Usuário:** teste
**Senha:** teste123

Após o login, será possível cadastrar e listar funcionários.
Observação: o MariaDB utiliza a porta 3307 e o AppRH utiliza a porta 8080.
