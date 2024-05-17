package br.com.jarvis.plusoft.dto.clienteDto;

import br.com.jarvis.plusoft.dto.emailDto.DetalhesEmailDto;
import br.com.jarvis.plusoft.model.Cliente;
import br.com.jarvis.plusoft.model.Email;

import java.time.LocalDate;
import java.util.List;

public record DetalhesClienteDto(Long id, String nome, String cpf, String rg, LocalDate datanascimento , String senha) {

    public DetalhesClienteDto(Cliente cliente){
        this(cliente.getId(), cliente.getNome(),cliente.getCpf(), cliente.getRg(), cliente.getDataNascimento(), cliente.getSenha());
    }

}
