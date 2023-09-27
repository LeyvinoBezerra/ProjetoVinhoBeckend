package br.com.gerenciar.vinho.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "venda_produto", schema = "public")
@SequenceGenerator(name = "public.sq_venda_produto", sequenceName = "public.sq_venda_produto", allocationSize = 1)
public class VendaProduto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "public.sq_venda_produto")
    @Column(name = "id", columnDefinition = "NUMERIC", length = 22)
    private Long id;

    @Column(name = "id_produto")
    private Long idProduto;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id_produto", referencedColumnName = "id", insertable=false, updatable=false)
    private Produto produto;

    @Column(name = "id_venda")
    private Long idVenda;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id_venda", referencedColumnName = "id", insertable=false, updatable=false)
    private Venda venda;

    @Column(name = "quantidade")
    private Integer quantidade;

}
