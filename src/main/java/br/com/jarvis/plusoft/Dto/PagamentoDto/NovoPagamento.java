package br.com.jarvis.plusoft.Dto.PagamentoDto;

import java.time.LocalDate;

public record NovoPagamento(
        String nome,
        Long numero,
        String descricao,
        LocalDate data
)
{ }
