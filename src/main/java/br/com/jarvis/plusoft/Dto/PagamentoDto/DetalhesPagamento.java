package br.com.jarvis.plusoft.Dto.PagamentoDto;

import br.com.jarvis.plusoft.model.Pagamento;

import java.time.LocalDate;

public record DetalhesPagamento(Long id, String nome, Long numero, String descricao, LocalDate data) {
    public DetalhesPagamento(Pagamento pagamento){
        this(pagamento.getId(), pagamento.getNome(),pagamento.getNumero(), pagamento.getDescricao(), pagamento.getData());
    }
}
