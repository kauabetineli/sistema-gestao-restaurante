CREATE SCHEMA restaurante;
USE restaurante;
-- Tabela 'mesas'
CREATE TABLE mesas (
mesa_id INT PRIMARY KEY AUTO_INCREMENT,
numero INT NOT NULL,
capacidade INT NOT NULL,
status VARCHAR(20) DEFAULT 'disponível'
);
-- Tabela 'clientes'
CREATE TABLE clientes (
cliente_id INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(100) NOT NULL,
telefone VARCHAR(15),
email VARCHAR(50)
);
-- Tabela 'reservas'
CREATE TABLE reservas (
reserva_id INT PRIMARY KEY AUTO_INCREMENT,
cliente_id INT,
mesa_id INT,
data_reserva DATE NOT NULL,
hora_reserva TIME NOT NULL,
status VARCHAR(20) DEFAULT 'confirmada',
FOREIGN KEY (cliente_id) REFERENCES clientes(cliente_id),
FOREIGN KEY (mesa_id) REFERENCES mesas(mesa_id)
);