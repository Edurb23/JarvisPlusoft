package br.com.jarvis.plusoft.controllers;

import br.com.jarvis.plusoft.dto.pagamentoDto.DetalhesPagamento;
import br.com.jarvis.plusoft.dto.pagamentoDto.ListagemPagamentoDto;

import br.com.jarvis.plusoft.dto.pagamentoDto.NovoPagamento;
import br.com.jarvis.plusoft.repository.PagamentoRepository;
import br.com.jarvis.plusoft.model.Pagamento;
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
public class PagamentoController {
    @Autowired
    private PagamentoRepository pagamentoRepository;


    @GetMapping
    public ResponseEntity<List<ListagemPagamentoDto>> get(Pageable pageable){
        var ListagemPagamento = pagamentoRepository.findAll().stream().map(ListagemPagamentoDto::new).toList();
        return ok(ListagemPagamento);
    }

    @GetMapping("{id}")
    public  ResponseEntity<ListagemPagamentoDto> get(@PathVariable("id") Long id){
        var pagamentos = pagamentoRepository.getReferenceById(id);
        return ok(new ListagemPagamentoDto(pagamentos));
    }



    @DeleteMapping("{id}")
    @Transactional
    public  ResponseEntity<Void> delete(@PathVariable("id") Long id){
        pagamentoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
