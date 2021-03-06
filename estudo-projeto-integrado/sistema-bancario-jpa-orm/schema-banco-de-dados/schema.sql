CREATE DATABASE IF NOT EXISTS bancojpa;
USE bancojpa;

CREATE TABLE IF NOT EXISTS conta (
    id INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,
    matricula VARCHAR(6) NOT NULL,
    nome VARCHAR(40) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    email VARCHAR(25) NOT NULL,
    senha VARCHAR(20) NOT NULL,
    saldo DOUBLE NOT NULL
);

CREATE TABLE IF NOT EXISTS operacao (
    id INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,
    matricula_conta VARCHAR(6) NOT NULL,
    email_conta VARCHAR(40) NOT NULL,
    tipo CHAR(1) NOT NULL,
    valor DOUBLE NOT NULL
);

CREATE TABLE IF NOT EXISTS transacoes (
    id INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,
    matricula_conta_realizou VARCHAR(6) NOT NULL,
    email_conta_realizou VARCHAR(40) NOT NULL,
    matricula_conta_recebeu VARCHAR(6) NOT NULL,
    email_conta_recebeu VARCHAR(40) NOT NULL,
    valor DOUBLE NOT NULL
);