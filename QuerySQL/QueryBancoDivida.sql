create database if not exists  BancoDivida;
use BancoDivida;
create table if not exists tb_Pessoa(
	idPessoa smallint auto_increment primary key,
    Nome varchar(50) not null,
    Saldo double(6,2) not null,
    Filiacao varchar(50) not null, 
    Limite double(6,2) not null,
    CreditoPrazo int default 0
);

create table if not exists tb_Divida (
idDivida smallint auto_increment primary key,
idPessoa smallint,
Valor double(6,2) not null,
DataOperacao date not null,
PrazoDevolucao int not null,
MotivoEmprestimo varchar(50) default "Necessidade"
);

alter table tb_Divida
add constraint fk_idPessoa foreign key (idPessoa) references tb_Pessoa(idPessoa);

insert tb_Pessoa (Nome, Saldo, Filiacao, Limite, CreditoPrazo) values ("Luis Fernando", -70, "Irmao",0,10);
insert into tb_Divida (idPessoa, Valor, DataOperacao, PrazoDevolucao, MotivoEmprestimo)
values
(1, 50, "2022-08-29", 6,"Cinema"),
(1, 20, "2022-08-30", 4,"Almoço");

select * from tb_Pessoa;
select * from tb_Divida;

create view vw_PessoaDivida as
select D.idDivida as 'ID', P.Nome,
D.Valor as 'R$',
 P.Filiacao as 'Filiação',
D.PrazoDevolucao as 'Prazo de Devolução',
D.DataOperacao as 'Data da Operação'
from tb_divida as D , tb_pessoa as P
where D.idPessoa = P.idPessoa;

select * from vw_PessoaDivida;

insert tb_Pessoa (Nome, Saldo, Filiacao, Limite, CreditoPrazo) values ("Augusto Barros", -100, "IFBA",0,2);
insert into tb_Divida (idPessoa, Valor, DataOperacao, PrazoDevolucao, MotivoEmprestimo)
values
(2, 50, "2022-09-01", 3,"Necessidade"),
(2, 50, "2022-08-31", 8,"Uniforme");

select * from vw_PessoaDivida;