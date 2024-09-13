package br.com.jarvis.plusoft.controllers;

import br.com.jarvis.plusoft.dto.clienteDto.AtualizacaoCliente;
import br.com.jarvis.plusoft.dto.clienteDto.CadastroClienteDto;
import br.com.jarvis.plusoft.dto.clienteDto.DetalhesClienteDto;
import br.com.jarvis.plusoft.dto.clienteDto.ListagemClienteDtO;
import br.com.jarvis.plusoft.dto.enderecolDto.DetalhesEndereco;
import br.com.jarvis.plusoft.dto.enderecolDto.NovoEnderecoDto;
import br.com.jarvis.plusoft.dto.telefoneDto.DetalhesTelefoneDto;
import br.com.jarvis.plusoft.dto.telefoneDto.NovoTelefoneDto;
import br.com.jarvis.plusoft.model.EnderecoCliente;
import br.com.jarvis.plusoft.model.Telefone;
import br.com.jarvis.plusoft.repository.*;
import br.com.jarvis.plusoft.model.Cliente;
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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("cliente")
@Tag(name = "Cliente", description = "Operações relacionadas a Model Cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private TelefoneRepository telefoneRepository;


    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping
    @Operation(summary = "GET de Cliente/Usuario",
            description = "Puxa a lista de clientes um Cliente/Usuario")
    @ApiResponses({@ApiResponse(responseCode = "201", description = "Clientes achado Sucesso", content =
    @Content(schema = @Schema(implementation = ListagemClienteDtO.class), mediaType = "application/json")),
            @ApiResponse(responseCode = "403", description = "Não Autorizado ou Token Inválido", content =
                    { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")})
    public ResponseEntity<List<ListagemClienteDtO>> get(Pageable pageable){
        var ListagemCliente = clienteRepository.findAll().stream().map(ListagemClienteDtO::new).toList();
        return ok(ListagemCliente);
    }

    @GetMapping("{id}")
    @Operation(summary = "Get de Cliente/Usuario",
            description = "Puxa um Cliente/Usuario pelo id")
    @Parameters({
            @Parameter(name="id", description = "Pesquisa cliente por id", required = true)
    })

    @ApiResponses({@ApiResponse(responseCode = "201", description = "Cliente achado Sucesso", content =
    @Content(schema = @Schema(implementation = DetalhesClienteDto.class), mediaType = "application/json")),
            @ApiResponse(responseCode = "403", description = "Não Autorizado ou Token Inválido", content =
                    { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")})
    public  ResponseEntity<DetalhesClienteDto> get(@PathVariable("id") Long id){
        var clientes = clienteRepository.getReferenceById(id);
        return ok(new DetalhesClienteDto(clientes));
    }

    @PostMapping("register")
    @Transactional
    @Operation(summary = "Cadastro de Cliente/Usuario",
            description = "Cadastra um Cliente/Usuario")
    @ApiResponses({@ApiResponse(responseCode = "201", description = "Cadastro com Sucesso", content =
    @Content(schema = @Schema(implementation = DetalhesClienteDto.class), mediaType = "application/json")),
            @ApiResponse(responseCode = "403", description = "Não Autorizado ou Token Inválido", content =
                    { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")})

    public ResponseEntity<DetalhesClienteDto> create(@RequestBody @Valid CadastroClienteDto dto, UriComponentsBuilder builder){
        var cliente = new Cliente(dto.nome(), dto.sobrenome(),dto.email(), passwordEncoder.encode(dto.password()), dto.cpf(), dto.dataNascimento(), dto.rg());
        clienteRepository.save(cliente);
        var uri = builder.path("/cliente/id").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesClienteDto(cliente));
    }


    // TELEFONE
    @PostMapping("{id}/telefone")
    @Transactional
    @Parameters({
            @Parameter(name="id", description = "Adiciona o id do cliente relacionado ao telefone", required = true)
    })

    @Operation(summary = "Cadastro de Telefone",
            description = "Cadastra um telefone do cliente")
    @ApiResponses({@ApiResponse(responseCode = "201", description = "Cadastro com Sucesso", content =
    @Content(schema = @Schema(implementation = DetalhesTelefoneDto.class), mediaType = "application/json")),
            @ApiResponse(responseCode = "403", description = "Não Autorizado ou Token Inválido", content =
                    { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")})

    public ResponseEntity<DetalhesTelefoneDto> post(@PathVariable("id") Long id,
                                                    @RequestBody @Valid NovoTelefoneDto dto,
                                                    UriComponentsBuilder uriBuilder){
        var cliente = clienteRepository.getReferenceById(id);
        var telefone = new Telefone(dto, cliente);
        telefoneRepository.save(telefone);
        var uri = uriBuilder.path("telefone/{id}").buildAndExpand(telefone.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesTelefoneDto(telefone));

    }

    //Endereço
    @PostMapping("{id}/endereco")
    @Transactional
    @Parameters({
            @Parameter(name="id", description = "Adiciona o id do cliente relacionado ao endereço", required = true)
    })

    @Operation(summary = "Cadastro de Endereço",
            description = "Cadastra um endereço do cliente")
    @ApiResponses({@ApiResponse(responseCode = "201", description = "Cadastro com Sucesso", content =
    @Content(schema = @Schema(implementation = DetalhesEndereco.class), mediaType = "application/json")),
            @ApiResponse(responseCode = "403", description = "Não Autorizado ou Token Inválido", content =
                    { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")})


    public ResponseEntity<DetalhesEndereco> post(@PathVariable("id") Long id,
                                                 @RequestBody @Valid NovoEnderecoDto dto,
                                                 UriComponentsBuilder uriBuilder){
        var cliente = clienteRepository.getReferenceById(id);
        var endereco = new EnderecoCliente(dto, cliente);
        enderecoRepository.save(endereco);
        var uri = uriBuilder.path("endereco/{id}").buildAndExpand(endereco.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesEndereco(endereco));


    }


    @PutMapping("{idCliente}/produto/{idProduto}")
    @Transactional
    @Parameters({
            @Parameter(name="id", description = "Adiciona o id do cliente relacionado ao endereço", required = true)
    })

    @Operation(summary = "Cadastro da tabela Produto Cliente",
            description = "Cadastra um o id que faz a relação entre Produto e Cliente")
    @ApiResponses({@ApiResponse(responseCode = "201", description = "Cadastro com Sucesso", content =
    @Content(schema = @Schema(implementation = DetalhesClienteDto.class), mediaType = "application/json")),
            @ApiResponse(responseCode = "403", description = "Não Autorizado ou Token Inválido", content =
                    { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")})
    public ResponseEntity<DetalhesClienteDto> put(@PathVariable("idCliente") Long idCliente, @PathVariable("idProduto") Long idProduto){
        var cliente = clienteRepository.getReferenceById(idCliente);
        var produto = produtoRepository.getReferenceById(idProduto);
        produto.getClientes().add(cliente);
        return ResponseEntity.ok().body(new DetalhesClienteDto(cliente));
    }





    @PutMapping("{id}")
    @Transactional
    @Operation(summary = "Atualizar Cliente/Usuario",
            description = "Atualiza um Cliente/Usuario pelo id")
    @Parameters({
            @Parameter(name="id", description = "Pesquisa cliente por id", required = true)
    })

    @ApiResponses({@ApiResponse(responseCode = "201", description = "Cliente atualizado Sucesso", content =
    @Content(schema = @Schema(implementation = ListagemClienteDtO.class), mediaType = "application/json")),
            @ApiResponse(responseCode = "403", description = "Não Autorizado ou Token Inválido", content =
                    { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")})
    public ResponseEntity<ListagemClienteDtO> put(@PathVariable("id") Long id,
                                                  @RequestBody AtualizacaoCliente dto){
        var cliente = clienteRepository.getReferenceById(id);
        cliente.atualizarCliente(dto);
        return ResponseEntity.ok(new ListagemClienteDtO(cliente));
    }




    @DeleteMapping("{id}")
    @Transactional
    @Hidden
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        clienteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
