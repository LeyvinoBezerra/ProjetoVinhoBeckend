
insert into usuario values ( NEXTVAL('public.sq_usuario'), 'Tadeu', 'tadeu@cobradev.com', current_date, 'ADMINISTRADOR', 'tadeu','123456');
insert into usuario values ( NEXTVAL('public.sq_usuario'), 'Leyvino', 'leyvino@cobradev.com', current_date, 'ADMINISTRADOR', 'leyvino','123456');
insert into usuario values ( NEXTVAL('public.sq_usuario'), 'Fernando', 'fernando@cobradev.com', current_date, 'USUARIO', 'fernando','123456');

INSERT INTO public.acesso(id, descricao) VALUES (1, 'ROLE_ADMIN');
INSERT INTO public.acesso(id, descricao) VALUES (2, 'ROLE_USUARIO');

UPDATE public.usuario
SET senha = '$2a$10$412e3JHYSMxcTx19/83NYOYhTvXGkNnzBYo7iNgnK.LqgyySpk6mG'
WHERE id = 1;

INSERT INTO public.usuarios_acesso(usuario_id, acesso_id) VALUES (1, 1);


