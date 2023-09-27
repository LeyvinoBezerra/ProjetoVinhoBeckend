package br.com.gerenciar.vinho.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDto  {

    private Long id;

    private String nome;

    private String descricao;

    private Long idUsuario;

    private LocalDate dataHora;

    private Integer quantidade;
}
