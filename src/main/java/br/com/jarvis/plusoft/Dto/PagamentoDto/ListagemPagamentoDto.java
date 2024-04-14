package br.com.jarvis.plusoft.Dto.PagamentoDto;

import br.com.jarvis.plusoft.Dto.produtoDto.ListagemProdutoDto;
import br.com.jarvis.plusoft.model.Pagamento;

import java.time.LocalDate;

public record ListagemPagamentoDto(Long id, String nome, Long numero, String descricao, LocalDate data) {

    public ListagemPagamentoDto(Pagamento pagamento){
        this(pagamento.getId(), pagamento.getNome(),pagamento.getNumero(), pagamento.getDescricao(), pagamento.getData());
    }


}
