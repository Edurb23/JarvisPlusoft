package br.com.jarvis.plusoft.controllers;

import br.com.jarvis.plusoft.Dto.clienteDto.AtualizacaoCliente;
import br.com.jarvis.plusoft.Dto.clienteDto.CadastroClienteDto;
import br.com.jarvis.plusoft.Dto.clienteDto.DetalhesClienteDto;
import br.com.jarvis.plusoft.Dto.clienteDto.ListagemClienteDtO;
import br.com.jarvis.plusoft.Repository.ClienteRepository;
import br.com.jarvis.plusoft.model.Cliente;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesClienteDto> post (@RequestBody CadastroClienteDto cadastroClienteDto, UriComponentsBuilder uriComponentsBuilder) {
        var cliente = new Cliente(cadastroClienteDto);
        clienteRepository.save(cliente);
        var uri = uriComponentsBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesClienteDto(cliente));
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
