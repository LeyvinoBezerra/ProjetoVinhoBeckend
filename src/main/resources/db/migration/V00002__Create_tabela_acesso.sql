CREATE SEQUENCE public.sq_acesso MINVALUE 1 START 1;

CREATE TABLE acesso (
    id bigint NOT NULL,
    descricao character varying(255) NOT NULL,
    CONSTRAINT pk_acesso PRIMARY KEY (id)
);

CREATE TABLE usuarios_acesso (
    usuario_id bigint NOT NULL,
    acesso_id bigint NOT NULL,
    CONSTRAINT acesso_fk FOREIGN KEY (acesso_id) REFERENCES public.acesso(id),
    CONSTRAINT usuario_fk FOREIGN KEY (usuario_id) REFERENCES public.usuario(id)
);

