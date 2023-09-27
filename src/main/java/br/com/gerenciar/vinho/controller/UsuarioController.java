package br.com.gerenciar.vinho.controller;


import br.com.gerenciar.vinho.dto.UsuarioDto;
import br.com.gerenciar.vinho.server.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public List<UsuarioDto> listarTodos() {
        return usuarioService.obterTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> obterPorId(@PathVariable @NotNull Long id) {
        UsuarioDto dto = usuarioService.obterPorId(id);
        return  ResponseEntity.ok(dto);
    }
}
