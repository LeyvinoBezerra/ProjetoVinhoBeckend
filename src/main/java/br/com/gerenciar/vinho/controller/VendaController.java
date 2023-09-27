package br.com.gerenciar.vinho.controller;


import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerenciar.vinho.dto.VendaDto;
import br.com.gerenciar.vinho.server.VendaService;

@RestController
@RequestMapping("/venda")
public class VendaController<vendaDto> {

    @Autowired
    VendaService vendaService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping()
    public List<VendaDto> listarTodos() {
//        List<VendaDto> lstVendaDto = vendaService.obterTodos();
//        lstVendaDto.forEach( v ->
//                {
//                    v.getUsuario().setLogin("");
//                    v.getUsuario().setSenha("");
//                });
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendaDto> obterVedasDetalheById(@PathVariable @NotNull Long id) {
        VendaDto vendaDto = vendaService.obterVendaDetalheById(id);
        return  ResponseEntity.ok(vendaDto);
    }


    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<VendaDto>> obterVendaUsuarioPorId(@PathVariable @NotNull Long id) {
        List<VendaDto> dto = vendaService.obterVendaPorIdUsuario(id);
        return ResponseEntity.ok(dto) ;
    }

    @PostMapping()
    public ResponseEntity<String> realizarVenda(@RequestBody VendaDto vendaDto ){

        String retorno = vendaService.realizarVenda(vendaDto);

        return ResponseEntity.ok(retorno);

    }

}
