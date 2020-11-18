create database locadora2;
use locadora2;

create table Filme (
	id_filme int(11) auto_increment primary key,
	titulo varchar(50),
    duracao int(11),
    imagem3d tinyint(1),
    dublado tinyint(1),
    sinopse varchar(500),
    categoria varchar(20)
);

create table Cliente (
	id_cliente int(5) auto_increment primary key,
    nome varchar(60),
    cpf int(12),
	usuario varchar(45),
    senha varchar(200),
    endereco varchar(150)
);
