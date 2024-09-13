package br.com.jarvis.plusoft.dto.clienteDto;


import br.com.jarvis.plusoft.model.Cliente;

import java.time.LocalDate;

public record DetalhesClienteDto(Long id, String nome, String sobrenome, String email, String password, String cpf, String rg, LocalDate datanascimento) {

    public DetalhesClienteDto(Cliente cliente){
        this(cliente.getId(), cliente.getNome(),cliente.getSobrenome(), cliente.getEmail(), cliente.getPassword() ,cliente.getCpf(), cliente.getRg(), cliente.getDataNascimento());
    }

}