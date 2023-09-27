package br.com.gerenciar.vinho.dto;

import br.com.gerenciar.vinho.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {

    private Long id;

    private String nome;

    private String email;

    private LocalDate dataHora;

    private String tipoUsuario;

    private String login;

    private String senha;


}
