package br.com.jarvis.plusoft.dto.pagamentoDto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record NovoPagamento(
        @NotNull(message = "Nome do cartão é obrigatorio")
        String nome,

        @NotNull(message = "Nome do cartão é obrigatorio")
        Long numero,

        @NotNull(message = "Nome do cartão é obrigatorio")
        String descricao,

        LocalDate data
)
{ }
