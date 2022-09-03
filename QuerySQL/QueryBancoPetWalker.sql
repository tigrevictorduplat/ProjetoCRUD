create database if not exists  PetWalker;
use PetWalker;
create table if not exists tb_Dono(
	idDono smallint auto_increment primary key,
    nomeDono varchar(50) not null,
    enderecoDono varchar(50) not null
);

create table if not exists tb_PET (
idPET smallint auto_increment primary key,
idDono smallint not null,
idadePET int not null,
nomePET varchar(50) not null,
tipoPET varchar(50) not null,
descricaoPET varchar(50) not null,
comidaFavoritaPET varchar(50)
);

alter table tb_PET
add constraint fk_idDono foreign key (idDono) references tb_Dono(idDono);

create table if not exists tb_Servico (
idServico smallint auto_increment primary key,
idPET smallint not null,
valorServico double not null,
dataServico date not null,
tipoServico varchar(50)
);

alter table tb_Servico
add constraint fk_idPET foreign key (idPET) references tb_PET(idPET);

insert tb_Dono (nomeDono, enderecoDono) values
("José", "Rua A, Casa 01"),
("João Paulo", "Rua B, Casa 10");

insert into tb_PET (idDono, idadePET, nomePET, tipoPET, descricaoPET, comidaFavoritaPET)
values
(1,4,"Flocos","Gatinho","Branco com Manchas Pretas","Whiskas Atum"),
(2,6,"Coragem","Cachorrinho","Golden Retriever Laranja","Ossinho Defumado");

insert into tb_Servico (idPET,valorServico, dataServico,tipoServico) values 
(2,50,"2022-09-15","Babá"),
(2,25,"2022-09-05","Passear"),
(1,100,"2022-09-04","Adestrar");

select * from tb_Dono;
select * from tb_PET;
select * from tb_Servico;

create view vw_Dono_PET_Servico as
select
D.nomeDono as 'Nome do Dono',
P.nomePET as 'Nome do PET',
P.tipoPET as 'Tipo do PET',
P.descricaoPET as 'Descrição',
S.valorServico as 'Preço do Serviço',
S.dataServico as 'Data Marcada',
S.tipoServico as 'Serviço Prestado'
from tb_Dono as D , tb_PET as P, tb_Servico as S
where D.idDono = P.idDono and
P.idPET = S.idPET;

select * from vw_Dono_PET_Servico;