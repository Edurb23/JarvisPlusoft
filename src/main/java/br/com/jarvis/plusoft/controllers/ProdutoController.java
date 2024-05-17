package br.com.jarvis.plusoft.controllers;

import br.com.jarvis.plusoft.dto.pagamentoDto.DetalhesPagamento;
import br.com.jarvis.plusoft.dto.pagamentoDto.NovoPagamento;
import br.com.jarvis.plusoft.dto.produtoDto.AtualizacaoPrdotuo;
import br.com.jarvis.plusoft.dto.produtoDto.CadastroProdutoDto;
import br.com.jarvis.plusoft.dto.produtoDto.DetalhesProdutoDto;
import br.com.jarvis.plusoft.dto.produtoDto.ListagemProdutoDto;
import br.com.jarvis.plusoft.model.Pagamento;
import br.com.jarvis.plusoft.repository.PagamentoRepository;
import br.com.jarvis.plusoft.repository.ProdutoRepository;
import br.com.jarvis.plusoft.model.Produto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private PagamentoRepository pagamentoRepository;


    @GetMapping
    public ResponseEntity<List<ListagemProdutoDto>> get(Pageable pageable){
        var ListagemProduto = produtoRepository.findAll().stream().map(ListagemProdutoDto::new).toList();
        return ok(ListagemProduto);

    }

    @GetMapping("{id}")
    public ResponseEntity<ListagemProdutoDto> get(@PathVariable("id") Long id){
        var produtos = produtoRepository.getReferenceById(id);
        return ok(new ListagemProdutoDto(produtos));
    }


    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesProdutoDto> post(@RequestBody CadastroProdutoDto cadastroProdutoDto, UriComponentsBuilder uriComponentsBuilder){
        var produtos = new Produto(cadastroProdutoDto);
        produtoRepository.save(produtos);
        var uri = uriComponentsBuilder.path("/produto/{id}").buildAndExpand(produtos.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesProdutoDto(produtos));

    }


    // PAGEMENTO
    @PostMapping("{id}/pagamento")
    @Transactional
    public ResponseEntity<DetalhesPagamento> post(@PathVariable("id") Long id,
                                                  @RequestBody @Valid NovoPagamento dto,
                                                  UriComponentsBuilder uriBuilder){
        var produto = produtoRepository.getReferenceById(id);
        var pagamento = new Pagamento(dto, produto);
        pagamentoRepository.save(pagamento);
        var uri = uriBuilder.path("pagamento/{id}").buildAndExpand(pagamento.getId()).toUri();
        return  ResponseEntity.created(uri).body(new DetalhesPagamento(pagamento));

    }


    @PutMapping("{id}")
    @Transactional
    public  ResponseEntity<ListagemProdutoDto> put(@PathVariable("id") Long id,
                                                   @RequestBody AtualizacaoPrdotuo dto){
        var produtos = produtoRepository.getReferenceById(id);
        produtos.atualizarProduto(dto);
        return ResponseEntity.ok(new ListagemProdutoDto(produtos));

    }


}
