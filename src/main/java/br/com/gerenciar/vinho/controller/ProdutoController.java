package br.com.gerenciar.vinho.controller;


import br.com.gerenciar.vinho.dto.ProdutoDto;
import br.com.gerenciar.vinho.server.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping()
    public List<ProdutoDto> listarTodos() {
        return produtoService.obterTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDto> obterPorId(@PathVariable @NotNull Long id) {
        ProdutoDto dto = produtoService.obterPorId(id);
        return  ResponseEntity.ok(dto);
    }


    @PostMapping()
    public ResponseEntity<ProdutoDto> incluirProduto(@RequestBody  ProdutoDto produtoDto){
        ProdutoDto obj = produtoService.incluirProduto(produtoDto);
        return ResponseEntity.ok(obj);
    }

    @PutMapping()
    public ResponseEntity<ProdutoDto> entradaProduto(@RequestBody ProdutoDto produtoDto) {
        ProdutoDto dto = produtoService.entradaDeProduto(produtoDto);
        return  ResponseEntity.ok(dto);
    }

}
