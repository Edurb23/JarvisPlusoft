package br.com.jarvis.plusoft.controllers;

import br.com.jarvis.plusoft.dto.telefoneDto.AtualizacaoTelefone;
import br.com.jarvis.plusoft.dto.telefoneDto.DetalhesTelefoneDto;
import br.com.jarvis.plusoft.dto.telefoneDto.ListagemTelefoneDto;
import br.com.jarvis.plusoft.dto.telefoneDto.NovoTelefoneDto;
import br.com.jarvis.plusoft.repository.ClienteRepository;
import br.com.jarvis.plusoft.repository.TelefoneRepository;
import br.com.jarvis.plusoft.model.Telefone;
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
public class TelefoneController {

    @Autowired
    private TelefoneRepository telefoneRepository;


    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public ResponseEntity<List<ListagemTelefoneDto>> get(Pageable pageable){
        var ListagemTelefone = telefoneRepository.findAll().stream().map(ListagemTelefoneDto::new).toList();
        return ok(ListagemTelefone);
    }

    @GetMapping("{id}")
    public ResponseEntity<ListagemTelefoneDto> get(@PathVariable("id") Long id){
        var telefone = telefoneRepository.getReferenceById(id);
        return ok(new ListagemTelefoneDto(telefone));
    }


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






    @PutMapping("{id}")
    @Transactional
    public  ResponseEntity<ListagemTelefoneDto> put(@PathVariable("id") Long id,
                                                    @RequestBody AtualizacaoTelefone dto){
        var telefone = telefoneRepository.getReferenceById(id);
        telefone.atualizarTelefone(dto);
        return ResponseEntity.ok(new ListagemTelefoneDto(telefone));

    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        telefoneRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
