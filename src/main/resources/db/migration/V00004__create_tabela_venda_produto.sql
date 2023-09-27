CREATE SEQUENCE public.sq_venda_produto MINVALUE 1 START 1;

CREATE TABLE public.venda_produto (
	id int8 NOT NULL,
	id_produto int8 NOT NULL,
	id_venda int8 NOT NULL,
	quantidade int8 NOT NULL,
	CONSTRAINT pk_venda_produto PRIMARY KEY (id),
	CONSTRAINT produto_vendaproduto_fk FOREIGN KEY (id_produto) REFERENCES public.produto(id),
	CONSTRAINT venda_vendaproduto_fk FOREIGN KEY (id_venda) REFERENCES public.venda(id)
);

INSERT INTO public.produto values (NEXTVAL('public.sq_produto'), 'CERVEJA ANTARTICA 600ML','CERVEJA ANTARTICA ORIGINAL 600ML PURO MALTE', 1,	current_date,	100);
INSERT INTO public.produto values (NEXTVAL('public.sq_produto'), 'CERVEJA BRAHMA 600ML'   ,'CERVEJA BRAHMA 600ML DUPLO MALTE'           , 1,	current_date,	100);
INSERT INTO public.produto values (NEXTVAL('public.sq_produto'), 'CERVEJA HEINEKEN 600ML' ,'CERVEJA HEINEKEN 600ML LARGE PURO MALTE'    , 1,	current_date,	100);

insert into venda values (NEXTVAL('public.sq_venda'),current_date,2);

insert into venda_produto values (NEXTVAL('public.sq_venda_produto'),3,1,10);
insert into venda_produto values (NEXTVAL('public.sq_venda_produto'),2,1,5);
insert into venda_produto values (NEXTVAL('public.sq_venda_produto'),1,1,6);