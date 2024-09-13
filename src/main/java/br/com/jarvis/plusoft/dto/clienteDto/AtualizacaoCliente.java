package br.com.jarvis.plusoft.dto.clienteDto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Schema(description = "Informações para Atualizar Cliente")
public record AtualizacaoCliente(
        @NotBlank(message = "Nome é obrigatório")
        @Size(max = 100, message = "o nome deve ter no máximo 100 caracteres")
        @Schema(description = "Nome do Cliente")
        String nome ,
        @NotBlank(message = "Sobrenome é obrigatório")
        @Size(max = 100, message = "o Sobrenome deve ter no máximo 100 caracteres")
        @Schema(description = "Sobrenome do Cliente")
        String sobrenome ,
        @NotBlank(message = "Email é obrigatório")
        @Size(max = 100, message = "o email deve ter no máximo 100 caracteres")
        @Schema(description = "Email do Cliente")
        String email ,
        @NotBlank(message = "CPF é obrigatório")
        @Size(max = 11, min = 11, message = "CPF deve ter no máximo 11 números")
        @Schema(description = "CPF do Cliente")
        String cpf,

        @Past
        @Schema(description = "Data de Nascimento do Cliente")
        LocalDate dataNascimento,

        @NotBlank(message = "RG é obrigatório")
        @Size(max = 9, min = 9, message = "RG deve ter no máximo 9 números")
        @Schema(description = "RG do Cliente")
        String rg
)
{ }
