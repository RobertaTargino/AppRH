
-- Teste do AppRH
-- Login: teste
-- Senha: teste123
-- Perfil: ADMIN
-- Senha armazenada com BCrypt

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
