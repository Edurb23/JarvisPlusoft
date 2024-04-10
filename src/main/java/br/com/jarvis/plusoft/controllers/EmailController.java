package br.com.jarvis.plusoft.controllers;

import br.com.jarvis.plusoft.Dto.emailDto.AtualizarEmail;
import br.com.jarvis.plusoft.Dto.emailDto.DetalhesEmailDto;
import br.com.jarvis.plusoft.Dto.emailDto.ListagemEmailDto;
import br.com.jarvis.plusoft.Dto.emailDto.NovoEmailDto;
import br.com.jarvis.plusoft.Repository.EmailRepository;
import br.com.jarvis.plusoft.model.Email;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("email")
public class EmailController {

    @Autowired
    private EmailRepository emailRepository;

    @GetMapping
    public ResponseEntity<List<ListagemEmailDto>> get(Pageable pageable){
        var ListagemEmail = emailRepository.findAll().stream().map(ListagemEmailDto::new).toList();
        return ok(ListagemEmail);

    }

    @GetMapping("{id}")
    public  ResponseEntity<ListagemEmailDto> get(@PathVariable("id") Long id){
        var email = emailRepository.getReferenceById(id);
        return ok(new ListagemEmailDto(email));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesEmailDto> post(@RequestBody NovoEmailDto novoEmailDto, UriComponentsBuilder uriComponentsBuilder){
        var email = new Email(novoEmailDto);
        emailRepository.save(email);
        var uri = uriComponentsBuilder.path("email/{id}").buildAndExpand(email.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesEmailDto(email));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<ListagemEmailDto> put(@PathVariable("id") Long id,
                                                @RequestBody AtualizarEmail dto){
        var email = emailRepository.getReferenceById(id);
        email.atualizacaoEmail(dto);
        return ResponseEntity.ok(new ListagemEmailDto(email));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        emailRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
