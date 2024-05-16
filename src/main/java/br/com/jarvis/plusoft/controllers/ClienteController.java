package br.com.jarvis.plusoft.controllers;

import br.com.jarvis.plusoft.dto.clienteDto.AtualizacaoCliente;
import br.com.jarvis.plusoft.dto.clienteDto.CadastroClienteDto;
import br.com.jarvis.plusoft.dto.clienteDto.DetalhesClienteDto;
import br.com.jarvis.plusoft.dto.clienteDto.ListagemClienteDtO;
import br.com.jarvis.plusoft.dto.emailDto.DetalhesEmailDto;
import br.com.jarvis.plusoft.dto.emailDto.NovoEmailDto;
import br.com.jarvis.plusoft.dto.enderecolDto.DetalhesEndereco;
import br.com.jarvis.plusoft.dto.enderecolDto.NovoEnderecoDto;
import br.com.jarvis.plusoft.dto.telefoneDto.DetalhesTelefoneDto;
import br.com.jarvis.plusoft.dto.telefoneDto.NovoTelefoneDto;
import br.com.jarvis.plusoft.model.Email;
import br.com.jarvis.plusoft.model.EnderecoCliente;
import br.com.jarvis.plusoft.model.Telefone;
import br.com.jarvis.plusoft.repository.ClienteRepository;
import br.com.jarvis.plusoft.model.Cliente;
import br.com.jarvis.plusoft.repository.EmailRepository;
import br.com.jarvis.plusoft.repository.ProdutoRepository;
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
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public ResponseEntity<List<ListagemClienteDtO>> get(Pageable pageable){
        var ListagemCliente = clienteRepository.findAll().stream().map(ListagemClienteDtO::new).toList();
        return ok(ListagemCliente);
    }

    @GetMapping("{id}")
    public  ResponseEntity<ListagemClienteDtO> get(@PathVariable("id") Long id){
        var clientes = clienteRepository.getReferenceById(id);
        return ok(new ListagemClienteDtO(clientes));
    }

  //  @GetMapping("por-nome")
  //  public ResponseEntity<Page<DetalhesClienteDto>> get(@RequestParam("nome") String nome, Pageable pageable){
  ///      var  page = clienteRepository.buscarPorNome(nome, pageable).map(DetalhesClienteDto::new);
   //     return ResponseEntity.ok(page);
   // }

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesClienteDto> create(@RequestBody @Valid CadastroClienteDto dto, UriComponentsBuilder builder){
        var cliente = new Cliente(dto);
        clienteRepository.save(cliente);
        var url = builder.path("cliente/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(url).body(new DetalhesClienteDto(cliente));
    }

    /// EMAIL ///
    @PostMapping("{id}/email")
    @Transactional
    public ResponseEntity<DetalhesEmailDto> post(@PathVariable("id") Long id,
                                                 @RequestBody @Valid NovoEmailDto dto,
                                                 UriComponentsBuilder uriBuilder){
        var cliente = clienteRepository.getReferenceById(id);
        var email = new Email(dto, cliente);
        emailRepository.save(email);
        var uri = uriBuilder.path("email/{id}").buildAndExpand(email.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesEmailDto(email));
    }

    // TELEFONE
    @PostMapping("{id}/telefone")
    @Transactional
    public ResponseEntity<DetalhesTelefoneDto> post(@PathVariable("id") Long id,
                                                    @RequestBody @Valid NovoTelefoneDto dto,
                                                    UriComponentsBuilder uriBuilder){
        var cliente = clienteRepository.getReferenceById(id);
        var telefone = new Telefone(dto, cliente);
        var uri = uriBuilder.path("telefone/{id}").buildAndExpand(telefone.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesTelefoneDto(telefone));

    }

    //Endereço
    @PostMapping("{id}/endereco")
    @Transactional
    public ResponseEntity<DetalhesEndereco> post(@PathVariable("id") Long id,
                                                 @RequestBody @Valid NovoEnderecoDto dto,
                                                 UriComponentsBuilder uriBuilder){
        var cliente = clienteRepository.getReferenceById(id);
        var endereco = new EnderecoCliente(dto, cliente);
        var uri = uriBuilder.path("endereco/{id}").buildAndExpand(endereco.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesEndereco(endereco));


    }
    @PutMapping("{idCliente}/produto/{idProduto}")
    @Transactional
    public ResponseEntity<DetalhesClienteDto> put(@PathVariable("idCliente") Long idCliente, @PathVariable("idProduto") Long idProduto){
        var cliente = clienteRepository.getReferenceById(idCliente);
        var produto = produtoRepository.getReferenceById(idProduto);
        produto.getClientes().add(cliente);
        return ResponseEntity.ok().body(new DetalhesClienteDto(cliente));
    }





    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<ListagemClienteDtO> put(@PathVariable("id") Long id,
                                                  @RequestBody AtualizacaoCliente dto){
        var cliente = clienteRepository.getReferenceById(id);
        cliente.atualizarAluno(dto);
        return ResponseEntity.ok(new ListagemClienteDtO(cliente));
    }




    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        clienteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
