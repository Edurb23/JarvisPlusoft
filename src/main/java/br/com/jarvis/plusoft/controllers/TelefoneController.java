package br.com.jarvis.plusoft.controllers;

import br.com.jarvis.plusoft.dto.clienteDto.DetalhesClienteDto;
import br.com.jarvis.plusoft.dto.telefoneDto.AtualizacaoTelefone;
import br.com.jarvis.plusoft.dto.telefoneDto.DetalhesTelefoneDto;
import br.com.jarvis.plusoft.dto.telefoneDto.ListagemTelefoneDto;
import br.com.jarvis.plusoft.dto.telefoneDto.NovoTelefoneDto;
import br.com.jarvis.plusoft.repository.ClienteRepository;
import br.com.jarvis.plusoft.repository.TelefoneRepository;
import br.com.jarvis.plusoft.model.Telefone;
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
@RequestMapping("telefone")
@Tag(name = "Telefone", description = "Operações relacionadas a Model Telefone")
public class TelefoneController {

    @Autowired
    private TelefoneRepository telefoneRepository;


    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    @Operation(summary = "GET de Telefones",
            description = "Puxa a lista de Telefones")
    @ApiResponses({@ApiResponse(responseCode = "201", description = "Telefones achado Sucesso", content =
    @Content(schema = @Schema(implementation = ListagemTelefoneDto.class), mediaType = "application/json")),
            @ApiResponse(responseCode = "403", description = "Não Autorizado ou Token Inválido", content =
                    { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")})
    public ResponseEntity<List<ListagemTelefoneDto>> get(Pageable pageable){
        var ListagemTelefone = telefoneRepository.findAll().stream().map(ListagemTelefoneDto::new).toList();
        return ok(ListagemTelefone);
    }

    @GetMapping("{id}")
    @Operation(summary = "Get de Telefone",
            description = "Puxa um Telefone")
    @Parameters({
            @Parameter(name="id", description = "Pesquisa Telefone por id", required = true)
    })

    @ApiResponses({@ApiResponse(responseCode = "201", description = "Telefone achado Sucesso", content =
    @Content(schema = @Schema(implementation = DetalhesTelefoneDto.class), mediaType = "application/json")),
            @ApiResponse(responseCode = "403", description = "Não Autorizado ou Token Inválido", content =
                    { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")})
    public ResponseEntity<ListagemTelefoneDto> get(@PathVariable("id") Long id){
        var telefone = telefoneRepository.getReferenceById(id);
        return ok(new ListagemTelefoneDto(telefone));
    }


    @PutMapping("{id}")
    @Transactional
    @Operation(summary = "Atualizar Telefone",
            description = "Atualiza um Telefone pelo id")
    @Parameters({
            @Parameter(name="id", description = "Pesquisa Telefone por id", required = true)
    })

    @ApiResponses({@ApiResponse(responseCode = "201", description = "Telefone atualizado Sucesso", content =
    @Content(schema = @Schema(implementation = DetalhesTelefoneDto.class), mediaType = "application/json")),
            @ApiResponse(responseCode = "403", description = "Não Autorizado ou Token Inválido", content =
                    { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")})
    public  ResponseEntity<ListagemTelefoneDto> put(@PathVariable("id") Long id,
                                                    @RequestBody AtualizacaoTelefone dto){
        var telefone = telefoneRepository.getReferenceById(id);
        telefone.atualizarTelefone(dto);
        return ResponseEntity.ok(new ListagemTelefoneDto(telefone));

    }

    @DeleteMapping("{id}")
    @Transactional
    @Hidden
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        telefoneRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
