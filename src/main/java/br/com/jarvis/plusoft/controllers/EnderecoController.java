package br.com.jarvis.plusoft.controllers;

import br.com.jarvis.plusoft.dto.clienteDto.DetalhesClienteDto;
import br.com.jarvis.plusoft.dto.enderecolDto.AtualizacaoEndereco;
import br.com.jarvis.plusoft.dto.enderecolDto.DetalhesEndereco;
import br.com.jarvis.plusoft.dto.enderecolDto.ListagemEnderecoDto;
import br.com.jarvis.plusoft.dto.enderecolDto.NovoEnderecoDto;
import br.com.jarvis.plusoft.repository.ClienteRepository;
import br.com.jarvis.plusoft.repository.EnderecoRepository;
import br.com.jarvis.plusoft.model.EnderecoCliente;
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
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("endereco")
@Tag(name = "Endereço", description = "Operações relacionadas a Model Endereço")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    @Operation(summary = "GET de Endereços",
            description = "Puxa a lista de endereços cadastrados")
    @ApiResponses({@ApiResponse(responseCode = "201", description = "Endereços achados Sucesso", content =
    @Content(schema = @Schema(implementation = ListagemEnderecoDto.class), mediaType = "application/json")),
            @ApiResponse(responseCode = "403", description = "Não Autorizado ou Token Inválido", content =
                    { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")})
    public ResponseEntity<List<ListagemEnderecoDto>> get(Pageable pageable){
        var ListagemEndereco = enderecoRepository.findAll().stream().map(ListagemEnderecoDto::new).toList();
        return ok(ListagemEndereco);
    }

    @GetMapping("{id}")
    @Operation(summary = "Get de Endereço",
            description = "Puxa um Endereço pelo id")
    @Parameters({
            @Parameter(name="id", description = "Pesquisa endereço por id", required = true)
    })

    @ApiResponses({@ApiResponse(responseCode = "201", description = "Endereço achado Sucesso", content =
    @Content(schema = @Schema(implementation = DetalhesEndereco.class), mediaType = "application/json")),
            @ApiResponse(responseCode = "403", description = "Não Autorizado ou Token Inválido", content =
                    { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")})
    public  ResponseEntity<ListagemEnderecoDto> get(@PathVariable("id") Long id){
        var endereco = enderecoRepository.getReferenceById(id);
        return ok(new ListagemEnderecoDto(endereco));
    }





    @PutMapping("{id}")
    @Transactional
    @Operation(summary = "Atualizar Endereço",
            description = "Atualiza um Endereço pelo id")
    @Parameters({
            @Parameter(name="id", description = "Pesquisa Endereço por id", required = true)
    })

    @ApiResponses({@ApiResponse(responseCode = "201", description = "Endereço atualizado Sucesso", content =
    @Content(schema = @Schema(implementation = DetalhesEndereco.class), mediaType = "application/json")),
            @ApiResponse(responseCode = "403", description = "Não Autorizado ou Token Inválido", content =
                    { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")})
    public  ResponseEntity<ListagemEnderecoDto> put(@PathVariable("id") Long id,
                                                    @RequestBody AtualizacaoEndereco dto){
        var endereco = enderecoRepository.getReferenceById(id);
        endereco.atualizarendereco(dto);
        return ResponseEntity.ok(new ListagemEnderecoDto(endereco));
    }

    @DeleteMapping("{id}")
    @Transactional
    @Hidden
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        enderecoRepository.deleteById(id);
        return  ResponseEntity.noContent().build();
    }

}
