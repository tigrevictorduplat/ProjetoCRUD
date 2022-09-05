create database if not exists  bancoescola;
use bancoescola;

create table if not exists tb_Pessoa(
	CPF varchar(11) primary key,
    idFuncao smallint not null,
    nomePessoa varchar(50) not null,
    enderecoPessoa varchar(50) not null
);

create table if not exists tb_Funcao (
idFuncao smallint auto_increment primary key,
nomeFuncao varchar(50) not null,
salarioFuncao double
);

alter table tb_Pessoa
add constraint fk_idFuncao foreign key (idFuncao) references tb_Funcao(idFuncao);

insert into tb_Funcao (nomeFuncao)
values
("Estudante");

insert into tb_Funcao (nomeFuncao, salarioFuncao)
values
("Professor",5000 );


insert tb_Pessoa (CPF, idFuncao, nomePessoa, enderecoPessoa) values
("10011001101", 1 ,"Ronaldo", "Rua X, Casa 1"),
("26713418745",1,"Maria Clara",  "Rua X, Casa 2"),
("84065284719",2,"Laura Freitas",  "Rua N, Casa 001");

select * from tb_Pessoa;
select * from tb_Funcao;

create view vw_PessoaFuncao as
select
P.nomePessoa as 'Nome',
P.CPF,
F.nomeFuncao as 'Função',
P.enderecoPessoa as 'Endereço',
F.salarioFuncao as 'Salário'
from tb_Pessoa as P, tb_Funcao as F
where P.idFuncao = F.idFuncao 
order by 'Nome';
 
select * from vw_PessoaFuncao;