package br.com.jarvis.plusoft.dto.clienteDto;

import br.com.jarvis.plusoft.dto.emailDto.NovoEmailDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CadastroClienteDto(
        @NotBlank(message = "Nome é obrigatório")
        @Size(max = 100, message = "o nome deve ter no máximo 100 caracteres")
        String nome ,
        @NotBlank(message = "CPF é obrigatório")
        @Size(max = 11, min = 11, message = "CPF deve ter no máximo 11 números")
        String cpf,

        @Past
        LocalDate dataNascimento,
        @NotBlank(message = "RG é obrigatório")
        @Size(max = 9, min = 9, message = "RG deve ter no máximo 9 números")
        String rg,
        @NotBlank(message = "Senha é obrigatório")
        String senha






)
{ }
