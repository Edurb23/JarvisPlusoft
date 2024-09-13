package br.com.jarvis.plusoft.dto.telefoneDto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
@Schema(description = "Informações para atualizar telefones")
public record AtualizacaoTelefone(
        @NotNull(message = "numero de telefone é obrigatorio")
        @Size(max = 11, message = "numero de telefone nao pode ter mais que 11 digitos")
        @Size( min = 11 , message = "numero de telefone nao pode ter menos que 11 digitos")
        @Schema(description = "Numero de telofone")
        String numeroTelefone,
        @NotNull(message = "numero de DDD é obrigatorio")
        @Size(max = 3, message = "numero de DDD nao pode ter mais que 3 digitos")
        @Size( min = 2 , message = "numero de DDD nao pode ter menos que 2 digitos")
        @Schema(description = "Numero de ddd")
        String ddd,

        @NotNull(message = "operadora é obrigatorio")
        @Schema(description = "Nome da operadora")
        String operadora
) {
}