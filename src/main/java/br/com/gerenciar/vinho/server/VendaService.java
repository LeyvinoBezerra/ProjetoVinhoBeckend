package br.com.gerenciar.vinho.server;


import br.com.gerenciar.vinho.dto.UsuarioDto;
import br.com.gerenciar.vinho.dto.VendaDto;
import br.com.gerenciar.vinho.dto.VendaProdutoDto;
import br.com.gerenciar.vinho.model.Produto;
import br.com.gerenciar.vinho.model.Usuario;
import br.com.gerenciar.vinho.model.Venda;
import br.com.gerenciar.vinho.model.VendaProduto;
import br.com.gerenciar.vinho.repository.ProdutoRepository;
import br.com.gerenciar.vinho.repository.VendaProdutoRepository;
import br.com.gerenciar.vinho.repository.VendaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.*;

@Service
public class VendaService {

    @Autowired
    private VendaProdutoRepository vendaProdutoRepository;

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    ProdutoRepository produtoRepository;



    public VendaDto obterVendaDetalheById(Long id) {
        List<VendaProduto> lstVendaProduto = vendaProdutoRepository.findByVendaDetalheById(id);

        VendaDto vendaDto =  new VendaDto();
        vendaDto.setId(lstVendaProduto.get(0).getVenda().getId());
        vendaDto.setDataHora(lstVendaProduto.get(0).getVenda().getDataHora());
        vendaDto.setUsuario(modelMapper.map(lstVendaProduto.get(0).getVenda().getUsuario(), Usuario.class));
        vendaDto.getUsuario().setSenha("");
        vendaDto.getUsuario().setLogin("");

        lstVendaProduto.forEach( v -> {
            vendaDto.getLstVendaProdutoDto().add(modelMapper.map(v, VendaProdutoDto.class));
        });

        return vendaDto;
    }

    public List<VendaDto> obterVendaPorIdUsuario(Long id) {
        List<Venda> lstVenda = vendaRepository.findVendaByIdUsuario(id);
        List<VendaProduto> lstVendaProduto = vendaProdutoRepository.findByVendaUsarioPorId(id);
        List<VendaDto> lstVendaDto = new ArrayList<>();

        lstVenda.forEach( v -> {
            List<VendaProdutoDto> lstVendaProdutoDto = new ArrayList<>();
            lstVendaProduto.forEach( vp -> {
                if(vp.getIdVenda().equals(v.getId())){
                    VendaProdutoDto vendaProdutoDto =  new VendaProdutoDto();
                    vendaProdutoDto.setId(vp.getId());
                    vendaProdutoDto.setIdProduto(vp.getIdProduto());
                    vendaProdutoDto.setIdVenda(vp.getIdVenda());
                    vendaProdutoDto.setProduto(vp.getProduto());
                    vendaProdutoDto.setQuantidade(vp.getQuantidade());
                    lstVendaProdutoDto.add(vendaProdutoDto);
                }
            });
            VendaDto vendaDto = new VendaDto();
            vendaDto.setId(v.getId());
            vendaDto.setIdUsuario(v.getIdUsuario());
            vendaDto.setDataHora(v.getDataHora());
            vendaDto.setUsuario(v.getUsuario());
            vendaDto.setLstVendaProdutoDto(lstVendaProdutoDto);
            lstVendaDto.add(vendaDto);

        });

        return lstVendaDto;
    }

    @Transactional
    public String realizarVenda(VendaDto vendaDto) {
        Venda venda = new Venda();
        venda.setIdUsuario(vendaDto.getIdUsuario());
        venda.setDataHora(LocalDate.now());
        Venda retornoVenda = vendaRepository.saveAndFlush(venda);

        vendaDto.getLstVendaProdutoDto().forEach( vp -> {
            vp.setIdVenda(retornoVenda.getId());
            vendaProdutoRepository.saveAndFlush( modelMapper.map(vp, VendaProduto.class));

            Optional<Produto> produto = produtoRepository.findById(vp.getIdProduto());
            produto.get().setQuantidade(produto.get().getQuantidade() - vp.getQuantidade());
            produtoRepository.save(modelMapper.map(produto.get(),Produto.class));
        });
        return "Venda Realizada com sucesso!";
    }

}
