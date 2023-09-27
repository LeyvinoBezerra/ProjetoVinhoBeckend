package br.com.gerenciar.vinho.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
@Entity
@Data
@Table(name = "produto", schema = "public")
@SequenceGenerator(name = "public.sq_produto", sequenceName = "public.sq_produto", allocationSize = 1)
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "public.sq_produto")
    @Column(name = "id", columnDefinition = "NUMERIC", length = 22)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "dataHora")
    private LocalDate dataHora;

    @Column(name = "quantidade")
    private Integer quantidade;

}
