package br.com.gerenciar.vinho.dto;

import br.com.gerenciar.vinho.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendaDto {

    private Long id;

    private LocalDate dataHora;

    private Usuario usuario;

    private Long idUsuario;

    private List<VendaProdutoDto> lstVendaProdutoDto = new ArrayList<>();

}

