create database cadastro;

use cadastro;

create table info(
	id int primary key auto_increment not null,
	nomeUsuario varchar(30),
    senhaUsuario varchar(30)
);

select * from info;
