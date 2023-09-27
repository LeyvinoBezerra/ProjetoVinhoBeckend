package br.com.gerenciar.vinho.repository;

import br.com.gerenciar.vinho.model.VendaProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VendaProdutoRepository extends JpaRepository<VendaProduto,Long> {

    @Query("SELECT vp FROM VendaProduto vp " +
            "INNER JOIN FETCH vp.produto p " +
            "INNER JOIN FETCH vp.venda v " +
            "INNER JOIN FETCH v.usuario u "+
            "WHERE vp.idVenda = :id")
    public List<VendaProduto> findByVendaDetalheById(@Param("id") Long id);


    @Query("SELECT vp FROM VendaProduto vp " +
            "INNER JOIN FETCH vp.produto p " +
            "INNER JOIN FETCH vp.venda v " +
            "INNER JOIN FETCH v.usuario u "+
            "WHERE v.idUsuario = :id")
    public List<VendaProduto> findByVendaUsarioPorId(@Param("id") Long id);


}


