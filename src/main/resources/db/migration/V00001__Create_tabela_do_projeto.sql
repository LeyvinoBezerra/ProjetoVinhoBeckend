CREATE SEQUENCE public.sq_usuario MINVALUE 1 START 1;
CREATE SEQUENCE public.sq_produto MINVALUE 1 START 1;
CREATE SEQUENCE public.sq_venda MINVALUE 1 START 1;


CREATE TABLE public.usuario (
	id bigint NOT NULL,
	nome varchar(255) NOT NULL,
	email varchar(500) NOT NULL,
	data_hora TIMESTAMP,
    tipo_usuario varchar(255) NOT NULL,
	login varchar(255) NOT NULL,
	senha varchar(255) NOT NULL,
	CONSTRAINT pk_usuario PRIMARY KEY (id)
);

CREATE TABLE public.produto (
	id bigint NOT NULL,
	nome varchar(255) NOT null,
	descricao varchar(500) NOT null,
	id_usuario bigint NOT NULL,
	data_hora TIMESTAMP,
    quantidade int8 NOT NULL,
	CONSTRAINT pk_produto PRIMARY KEY (id),
	CONSTRAINT produto_fk FOREIGN KEY (id_usuario) REFERENCES public.usuario(id)
);


CREATE TABLE public.venda (
	id bigint NOT NULL,
	data_hora TIMESTAMP,
	id_usuario bigint NOT NULL,
	CONSTRAINT pk_venda PRIMARY KEY (id),
	CONSTRAINT venda_fk FOREIGN KEY (id_usuario) REFERENCES public.usuario(id)
);

