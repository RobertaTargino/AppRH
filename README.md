**AppRH**

O AppRH é um sistema de recursos humanos desenvolvido com base no projeto TransCarga, disponibilizado pelo professor na disciplina de Desenvolvimento de Sistemas Corporativos. Utilizei parte do código e fiz adaptações para o meu projeto.
O sistema permite cadastrar e listar funcionários, além de controlar o acesso por meio de login.

Abaixo, deixarei orientações para realizar o download e a execução do sistema em sua máquina.

**Requisitos**

- Java JDK 25;
- Eclipse IDE;
- MariaDB configurado na porta 3307.

**Como executar**

1. Acesse o repositório deste projeto.
2. Clique em Code e depois em Download ZIP.
3. Extraia o arquivo baixado.
4. Abra o Eclipse e selecione File > Import.
5. Escolha Maven > Existing Maven Projects e clique em Next.
6. Selecione a pasta extraída que contém o arquivo pom.xml e clique em Finish.

**Configurar o Java**

1. No Eclipse, acesse Window > Preferences.
2. Selecione Java > Installed JREs.
3. Verifique se o Java 25 está configurado.
4. Caso não esteja, clique em Add > Standard VM e selecione a pasta de instalação do JDK 25.
5. Marque o Java 25 e clique em Apply and Close.

**Criar o banco de dados**

1. Abra o MySQL Client ou MariaDB Client.
2. Informe a senha configurada durante a instalação do MariaDB.
3. Execute o comando:

**CREATE DATABASE apprh;**

4. Selecione o banco:

**USE apprh;**


O MariaDB deve estar configurado na porta 3307.

**Configurar e iniciar o sistema**

1. No Eclipse, acesse Run > Run Configurations.
2. Selecione ou crie a configuração de execução da classe ApprhApplication.
3. Na aba JRE, verifique se o Java 25 está selecionado.
4. Na aba Environment, clique em Add.
5. Em Name, digite DB_PASSWORD.
6. Em Value, informe a senha do MariaDB.
7. Clique em Apply e depois em Run.

Aguarde a inicialização da aplicação para que as tabelas sejam criadas automaticamente no banco de dados.

**Criar usuário para o primeiro acesso**

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

Esse comando cadastra o usuário de teste necessário para entrar no sistema.

**Acessar o AppRH**

Abra o endereço:

http://localhost:8080/login.html

Usuário: teste

Senha: teste123

Após o login, será possível cadastrar e listar funcionários.

Observação: o MariaDB utiliza a porta 3307 e o AppRH utiliza a porta 8080.
