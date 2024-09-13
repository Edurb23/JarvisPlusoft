package br.com.jarvis.plusoft.dto.pagamentoDto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Schema(description = "Informações para cadastro de Pagamento")
public record NovoPagamento(
        @NotNull(message = "Nome do cartão é obrigatorio")
        @Schema(description = "Nome do titular do cartao")
        String nome,

        @NotNull(message = "Nome do cartão é obrigatorio")
        @Schema(description = "Numero do cartao")
        Long numero,

        @NotNull(message = "descrição é obrigatorio")
        @Schema(description = "descrição do cartao")
        String descricao,

        LocalDate data
)
{ }
