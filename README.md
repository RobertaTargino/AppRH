# AppRH

O AppRH é um sistema de recursos humanos desenvolvido para a disciplina de Desenvolvimento de Sistemas Corporativos, do curso de Sistemas para Internet da UERN.
O sistema permite cadastrar e listar funcionários, cadastrar usuários e controlar o acesso por meio de login.

Tecnologias utilizadas: Java, Spring Boot, MariaDB, HTML, CSS e JavaScript.

## Como executar

1. Acesse o repositório https://github.com/RobertaTargino/AppRH.
2. Clique em Code e depois em Download ZIP.
3. Extraia o arquivo baixado.
4. Abra o Eclipse e selecione File > Import.
5. Escolha Maven > Existing Maven Projects e clique em Next.
6. Clique em Browse e selecione a pasta extraída que contém o arquivo `pom.xml`.
7. Clique em Finish e aguarde o Eclipse carregar o projeto.
8. Crie um banco de dados chamado `apprh` no MariaDB.
9. Configure a senha do banco de dados no Eclipse, acessando Run > Run Configurations > Environment e adicionando a variável `DB_PASSWORD`.
10. Execute a classe `ApprhApplication.java`.
11. Após iniciar a aplicação, execute o arquivo `teste.sql` no MariaDB para cadastrar o usuário de teste.
12. Acesse http://localhost:8080/login.html.

## Primeiro acesso

Usuário: teste
Senha: teste123
Após o login, será possível cadastrar e listar funcionários.

## Erros comuns

### Erro de conexão com o banco de dados

Verifique se o MariaDB está iniciado, se o banco `apprh` foi criado e se a senha configurada na variável `DB_PASSWORD` está correta. Confira também se o MariaDB utiliza a porta 3307.

### Usuário ou senha inválidos

Verifique se o arquivo `teste.sql` foi executado corretamente no banco `apprh`. Esse arquivo cadastra o usuário necessário para o primeiro acesso.

### Erro 404 ao acessar o sistema

Verifique se a aplicação está em execução no Eclipse. Se estiver desligada, execute novamente a classe `ApprhApplication.java`.

### Porta 8080 em uso

Verifique se outra aplicação está utilizando a porta 8080. Encerre o processo que está ocupando a porta antes de iniciar o AppRH.

### Erros relacionados ao Lombok

O projeto utiliza Lombok para gerar métodos automaticamente. Caso o Eclipse apresente erros nos métodos `get` e `set`, verifique se o Lombok está configurado corretamente na IDE e se as dependências Maven foram carregadas.

### Erros ao importar o projeto

Verifique se a pasta selecionada contém o arquivo `pom.xml`. No Eclipse, clique com o botão direito no projeto e selecione Maven > Update Project para atualizar as dependências.

## Observação

O MariaDB utiliza a porta 3307 e a aplicação utiliza a porta 8080.
