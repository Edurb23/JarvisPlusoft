package br.com.jarvis.plusoft.controllers;

import br.com.jarvis.plusoft.dto.clienteDto.DetalhesClienteDto;
import br.com.jarvis.plusoft.dto.pagamentoDto.DetalhesPagamento;
import br.com.jarvis.plusoft.dto.pagamentoDto.ListagemPagamentoDto;

import br.com.jarvis.plusoft.dto.pagamentoDto.NovoPagamento;
import br.com.jarvis.plusoft.repository.PagamentoRepository;
import br.com.jarvis.plusoft.model.Pagamento;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("pagamento")
@Tag(name = "Pagamento", description = "Operações relacionadas a Model Pagamento")
public class PagamentoController {
    @Autowired
    private PagamentoRepository pagamentoRepository;


    @GetMapping
    @Operation(summary = "GET de Pagamentos",
            description = "Puxa a lista de pagamentos feitos no site")
    @ApiResponses({@ApiResponse(responseCode = "201", description = "Pagamentos achado Sucesso", content =
    @Content(schema = @Schema(implementation = DetalhesClienteDto.class), mediaType = "application/json")),
            @ApiResponse(responseCode = "403", description = "Não Autorizado ou Token Inválido", content =
                    { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")})
    public ResponseEntity<List<ListagemPagamentoDto>> get(Pageable pageable){
        var ListagemPagamento = pagamentoRepository.findAll().stream().map(ListagemPagamentoDto::new).toList();
        return ok(ListagemPagamento);
    }

    @GetMapping("{id}")
    @Operation(summary = "Get de Pagamentos",
            description = "Puxa um Pagamentos pelo id")
    @Parameters({
            @Parameter(name="id", description = "Pesquisa pagamento por id", required = true)
    })

    @ApiResponses({@ApiResponse(responseCode = "201", description = "Pagamentos achado Sucesso", content =
    @Content(schema = @Schema(implementation = DetalhesClienteDto.class), mediaType = "application/json")),
            @ApiResponse(responseCode = "403", description = "Não Autorizado ou Token Inválido", content =
                    { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")})
    public  ResponseEntity<ListagemPagamentoDto> get(@PathVariable("id") Long id){
        var pagamentos = pagamentoRepository.getReferenceById(id);
        return ok(new ListagemPagamentoDto(pagamentos));
    }



    @DeleteMapping("{id}")
    @Transactional
    @Hidden
    public  ResponseEntity<Void> delete(@PathVariable("id") Long id){
        pagamentoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
