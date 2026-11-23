**AppRH**
O AppRH é um sistema de recursos humanos, ele foi desenvolvido tem como base o projeto TransCarga, que foi disponibilizado pelo professor na matéria Desenvolvimento de Sistemas Corporativos, usei parte do código e fiz adaptações para o meu projeto. O sistema permite cadastrar e listar funcionários, além de controlar o acesso por meio de login.
Abaixo deixarei orientações para a realização do download e execução do sistema na sua maquina.

**Como executar**
1 Acesse o repositório desse arquivo.
2 Clique em Code e depois em Download ZIP.
3 Extraia o arquivo baixado.
4 Abra o Eclipse e selecione File > Import.
5 Escolha Maven > Projetos Maven Existentes e clique em Próximo.
6 Selecione a pasta extraída que contém o arquivo pom.xmle clique em Concluir.

**Criar o banco de dados**
Abra o MySQL Client ou MariaDB Client.
Informe a senha configurada durante a instalação do MariaDB.
Execute o comando:
`CREATE DATABASE apprh;`
Selecione o banco:
`USE apprh;`
O MariaDB deve estar configurado na porta 3307.

Configurar e iniciar o sistema
No Eclipse, acesse Executar > Configurações de Execução.
Selecione a configuração da classe ApprhApplication.
Na aba Ambiente, clique em Adicionar.
Em Nome, digite DB_PASSWORD.
Em Value, informe a senha do MariaDB.
Clique em Apply e execute uma aplicação.
Mantenha a inicialização para que as tabelas sejam criadas no banco de dados.

Criar usuário para o primeiro acesso
Volte ao Cliente MariaDB e execute:


`USE apprh;`

`INSERT INTO users (username, password, role)
VALUES (
    'teste',
    '$2a$12$MDo5RkUEND8Jfo1NMyp83O9.594DUgU/vKqwB2v6ePBJ2q2mnyRie',
    'ADMIN'
)
ON DUPLICATE KEY UPDATE
    password = VALUES(password),
    role = VALUES(role);`
    
Esse comando cadastra o usuário necessário para entrar no sistema.

Acessar o AppRH
Abra http://localhost:8080/login.html

Usuário:teste 
Senha: teste123

Após o login, será possível cadastrar e listar funcionários. Observação: o MariaDB utiliza a porta 3307 e o AppRH utiliza a porta 8080.
