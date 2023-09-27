package br.com.gerenciar.vinho.server;


import br.com.gerenciar.vinho.dto.ProdutoDto;
import br.com.gerenciar.vinho.model.Produto;
import br.com.gerenciar.vinho.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<ProdutoDto> obterTodos(){
        return produtoRepository.findAll().stream()
                .map(p -> modelMapper.map(p, ProdutoDto.class))
                .collect(Collectors.toList());
    }

    public ProdutoDto obterPorId(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        return modelMapper.map(produto, ProdutoDto.class);
    }

    @Transactional
    public ProdutoDto incluirProduto(ProdutoDto produtoDto){
        Produto produto =  modelMapper.map(produtoDto, Produto.class);
        produto = produtoRepository.save(produto);
        return modelMapper.map(produto, ProdutoDto.class);
    }

    @Transactional
    public ProdutoDto entradaDeProduto(ProdutoDto produtoDto) {
        Optional<Produto> produto = produtoRepository.findById(produtoDto.getId());
        produto.get().setQuantidade(produto.get().getQuantidade() + produtoDto.getQuantidade());
        produtoRepository.save(produto.get());
        return modelMapper.map(produto, ProdutoDto.class);
    }

}
