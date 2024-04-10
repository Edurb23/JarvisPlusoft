package br.com.jarvis.plusoft.controllers;

import br.com.jarvis.plusoft.Dto.enderecolDto.AtualizacaoEndereco;
import br.com.jarvis.plusoft.Dto.enderecolDto.DetalhesEndereco;
import br.com.jarvis.plusoft.Dto.enderecolDto.ListagemEnderecoDto;
import br.com.jarvis.plusoft.Dto.enderecolDto.NovoEnderecoDto;
import br.com.jarvis.plusoft.Repository.EnderecoRepository;
import br.com.jarvis.plusoft.model.EnderecoCliente;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("endereco")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping
    public ResponseEntity<List<ListagemEnderecoDto>> get(Pageable pageable){
        var ListagemEndereco = enderecoRepository.findAll().stream().map(ListagemEnderecoDto::new).toList();
        return ok(ListagemEndereco);
    }

    @GetMapping("{id}")
    public  ResponseEntity<ListagemEnderecoDto> get(@PathVariable("id") Long id){
        var endereco = enderecoRepository.getReferenceById(id);
        return ok(new ListagemEnderecoDto(endereco));
    }

    @PostMapping
    @Transactional
    public  ResponseEntity<DetalhesEndereco> post(@RequestBody NovoEnderecoDto novoEnderecoDto, UriComponentsBuilder uriComponentsBuilder) {
        var endereco = new EnderecoCliente(novoEnderecoDto);
        enderecoRepository.save(endereco);
        var uri = uriComponentsBuilder.path("endereco/{id}").buildAndExpand(endereco.getId()).toUri();
        return  ResponseEntity.created(uri).body(new DetalhesEndereco(endereco));
    }

    @PutMapping("{id}")
    @Transactional
    public  ResponseEntity<ListagemEnderecoDto> put(@PathVariable("id") Long id,
                                                    @RequestBody AtualizacaoEndereco dto){
        var endereco = enderecoRepository.getReferenceById(id);
        endereco.atualizarendereco(dto);
        return ResponseEntity.ok(new ListagemEnderecoDto(endereco));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        enderecoRepository.deleteById(id);
        return  ResponseEntity.noContent().build();
    }

}
