package br.com.gerenciar.vinho.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
@Entity
@Data
@Table(name = "venda", schema = "public")
@SequenceGenerator(name = "public.sq_venda", sequenceName = "public.sq_venda", allocationSize = 1)
@NoArgsConstructor
public class Venda implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "public.sq_venda")
    @Column(name = "id", columnDefinition = "NUMERIC", length = 22)
    private Long id;

    @Column(name = "data_hora")
    private LocalDate dataHora;

//    @ManyToMany (fetch=FetchType.LAZY)
//    @JoinTable(name = "venda_produto"
//            ,joinColumns=@JoinColumn(name="id_venda")
//            ,inverseJoinColumns=@JoinColumn(name="id_produto"))
//    private List<Produto> lstProduto;

//    @OneToMany (fetch=FetchType.LAZY)
//    @JoinTable(name = "venda_produto")
//    private List<VendaProduto> lstVendaProduto;

    @Column(name = "id_usuario")
    private Long idUsuario;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id", insertable=false, updatable=false)
    private Usuario usuario;

}
