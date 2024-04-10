package br.com.jarvis.plusoft.Dto.telefoneDto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record NovoTelefoneDto(
        @NotNull(message = "numero de telefone é obrigatorio")
        @Size(max = 11, message = "numero de telefone nao pode ter mais que 11 digitos")
        @Size( min = 11 , message = "numero de telefone nao pode ter menos que 11 digitos")
        String numeroTelefone,
        @NotNull(message = "numero de DDD é obrigatorio")
        @Size(max = 3, message = "numero de DDD nao pode ter mais que 11 digitos")
        @Size( min = 3 , message = "numero de DDD nao pode ter menos que 11 digitos")
        String ddd,

        @NotNull(message = "operadora é obrigatorio")
        String operadora
)
{
}
