package br.com.jarvis.plusoft.dto.pagamentoDto;

import java.time.LocalDate;

public record NovoPagamento(
        String nome,
        Long numero,
        String descricao,
        LocalDate data
)
{ }
