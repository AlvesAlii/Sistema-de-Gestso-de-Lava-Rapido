-- tabela de clientes
CREATE DATABASE IF NOT EXISTS lavarapido;
USE lavarapido;

-- Tabela de clientes
CREATE TABLE IF NOT EXISTS clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(100),
    Cpf VARCHAR(11) UNIQUE,
    Telefone VARCHAR(11) ,
    Email VARCHAR(100),
    Placa VARCHAR(10),
    Servico VARCHAR(15)
);


-- INSERT INTO clientes (Nome, Cpf, Telefone, Email, Placa, Servico) VALUES 
-- ('Alison', '00000000000', '12981126408', 'alisonalves@gmail.com' , 'ghj1321', 'detalhada'),
-- ('Maria', '11111111111', '11515484421', 'mariafernanda@gmail.com', 'ndz6719', 'completa');

select * from clientes;
