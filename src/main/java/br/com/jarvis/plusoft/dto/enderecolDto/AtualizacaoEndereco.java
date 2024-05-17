package br.com.jarvis.plusoft.dto.enderecolDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AtualizacaoEndereco(

        @NotBlank(message = "Nome da rua é obrigatório")
        @Size(max = 50, message = "o nome deve ter no máximo 50 caracteres")
        String nomeRua,

        @NotBlank(message = "Numero da residencia é obrigatório")
        @Size(max = 50, message = "o nome deve ter no máximo 50 caracteres")
        String numeroResidencia,

        @NotBlank(message = "Nome do bairro é obrigatório")
        @Size(max = 50, message = "o nome deve ter no máximo 50 caracteres")
        String nomeBairro)
{
}
