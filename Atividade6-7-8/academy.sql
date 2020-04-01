create table aluno(
  pkidaluno serial primary key,
  nome varchar(197),
  email varchar(80),
  tel bigint,
  rua varchar(80),
  numrua varchar(6),
  sexo varchar(9),
  atv varchar(10)
);

create table login(
  pkidlogin serial primary key,
  usuario varchar(20),
  senha varchar(20)
);
select * from aluno
drop table aluno