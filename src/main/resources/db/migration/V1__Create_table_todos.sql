create table todos(
	id bigint not null auto_increment,
	nome varchar(100) not null,
	descricao varchar(100) not null,
	prioridade int (20) not null,
	realizado varchar(100) not null,
	primary key(id)
);