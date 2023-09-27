package br.com.gerenciar.vinho.dto;


import br.com.gerenciar.vinho.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendaProdutoDto {

    private Long id;

    private Long idProduto;

    private Produto produto;

    private Long idVenda;

    private Integer quantidade;
}
