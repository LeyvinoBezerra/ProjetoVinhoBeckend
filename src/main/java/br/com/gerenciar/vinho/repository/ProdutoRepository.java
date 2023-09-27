package br.com.gerenciar.vinho.repository;

import br.com.gerenciar.vinho.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository <Produto, Long>{
}
