package br.com.gerenciar.vinho.repository;

import br.com.gerenciar.vinho.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VendaRepository extends JpaRepository<Venda,Long> {

    @Query("SELECT v FROM Venda v where v.idUsuario= :id ")
    public List<Venda> findVendaByIdUsuario(@Param("id") Long id);

}

