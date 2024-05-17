package br.com.jarvis.plusoft.dto.pagamentoDto;

import br.com.jarvis.plusoft.dto.produtoDto.DetalhesProdutoDto;
import br.com.jarvis.plusoft.model.Pagamento;

import java.time.LocalDate;

public record ListagemPagamentoDto(Long id, String nome, Long numero, String descricao, LocalDate data, DetalhesProdutoDto detalhesProdutoDto) {

    public ListagemPagamentoDto(Pagamento pagamento){
        this(pagamento.getId(), pagamento.getNome(),pagamento.getNumero(), pagamento.getDescricao(), pagamento.getData(), new DetalhesProdutoDto(pagamento.getProduto()) );
    }


}
