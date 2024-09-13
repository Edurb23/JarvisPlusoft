package br.com.jarvis.plusoft.dto.enderecolDto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
@Schema(description = "Informações para cadastro de Endereço")
public record NovoEnderecoDto(
        @NotBlank(message = "Nome da rua é obrigatório")
        @Size(max = 50, message = "o nome deve ter no máximo 50 caracteres")
        @Schema(description = "Nome da rua")
        String nomeRua,
        @NotBlank(message = "Numero da residencia é obrigatório")
        @Size(max = 50, message = "o nome deve ter no máximo 50 caracteres")
        @Schema(description = "Numero da Residencia")
        String numeroResidencia,
        @NotBlank(message = "Nome do bairro é obrigatório")
        @Size(max = 50, message = "o nome deve ter no máximo 50 caracteres")
        @Schema(description = "Nome do Bairro")
        String nomeBairro
)
{
}

