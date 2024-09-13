package br.com.jarvis.plusoft.controllers;

import br.com.jarvis.plusoft.dto.clienteDto.DetalhesClienteDto;
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
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Produto", description = "Operações relacionadas a Model Produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private PagamentoRepository pagamentoRepository;


    @GetMapping
    @Operation(summary = "GET de Produtos ",
            description = "Puxa a lista de Produtos")
    @ApiResponses({@ApiResponse(responseCode = "201", description = "Produtos achado Sucesso", content =
    @Content(schema = @Schema(implementation = ListagemProdutoDto.class), mediaType = "application/json")),
            @ApiResponse(responseCode = "403", description = "Não Autorizado ou Token Inválido", content =
                    { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")})
    public ResponseEntity<List<ListagemProdutoDto>> get(Pageable pageable){
        var ListagemProduto = produtoRepository.findAll().stream().map(ListagemProdutoDto::new).toList();
        return ok(ListagemProduto);

    }

    @GetMapping("{id}")
    @Operation(summary = "Get de Produto",
            description = "Puxa um Produto pelo id")
    @Parameters({
            @Parameter(name="id", description = "Pesquisa Produto por id", required = true)
    })

    @ApiResponses({@ApiResponse(responseCode = "201", description = "Cliente achado Sucesso", content =
    @Content(schema = @Schema(implementation = DetalhesProdutoDto.class), mediaType = "application/json")),
            @ApiResponse(responseCode = "403", description = "Não Autorizado ou Token Inválido", content =
                    { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")})
    public ResponseEntity<ListagemProdutoDto> get(@PathVariable("id") Long id){
        var produtos = produtoRepository.getReferenceById(id);
        return ok(new ListagemProdutoDto(produtos));
    }


    @PostMapping
    @Transactional
    @Operation(summary = "Cadastro de Produtos",
            description = "Cadastra um Produtos")
    @ApiResponses({@ApiResponse(responseCode = "201", description = "Cadastro com Sucesso", content =
    @Content(schema = @Schema(implementation = DetalhesProdutoDto.class), mediaType = "application/json")),
            @ApiResponse(responseCode = "403", description = "Não Autorizado ou Token Inválido", content =
                    { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")})

    public ResponseEntity<DetalhesProdutoDto> post(@RequestBody CadastroProdutoDto cadastroProdutoDto, UriComponentsBuilder uriComponentsBuilder){
        var produtos = new Produto(cadastroProdutoDto);
        produtoRepository.save(produtos);
        var uri = uriComponentsBuilder.path("/produto/{id}").buildAndExpand(produtos.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesProdutoDto(produtos));

    }


    // PAGEMENTO
    @PostMapping("{id}/pagamento")
    @Transactional
    @Parameters({
            @Parameter(name="id", description = "Adiciona o id do produto relacionado ao pagamento", required = true)
    })

    @Operation(summary = "Cadastro de Pagamento",
            description = "Cadastra um Pagemento de uma compra")
    @ApiResponses({@ApiResponse(responseCode = "201", description = "Cadastro com Sucesso", content =
    @Content(schema = @Schema(implementation = DetalhesPagamento.class), mediaType = "application/json")),
            @ApiResponse(responseCode = "403", description = "Não Autorizado ou Token Inválido", content =
                    { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")})

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
    @Operation(summary = "Atualizar Produto",
            description = "Atualiza u mProduto pelo id")
    @Parameters({
            @Parameter(name="id", description = "PesquisaProduto por id", required = true)
    })

    @ApiResponses({@ApiResponse(responseCode = "201", description = "Produto atualizado Sucesso", content =
    @Content(schema = @Schema(implementation = DetalhesProdutoDto.class), mediaType = "application/json")),
            @ApiResponse(responseCode = "403", description = "Não Autorizado ou Token Inválido", content =
                    { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")})
    public  ResponseEntity<ListagemProdutoDto> put(@PathVariable("id") Long id,
                                                   @RequestBody AtualizacaoPrdotuo dto){
        var produtos = produtoRepository.getReferenceById(id);
        produtos.atualizarProduto(dto);
        return ResponseEntity.ok(new ListagemProdutoDto(produtos));

    }


    @DeleteMapping("{id}")
    @Hidden
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        produtoRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }


}
