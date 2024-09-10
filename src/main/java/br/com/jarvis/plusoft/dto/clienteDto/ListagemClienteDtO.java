package br.com.jarvis.plusoft.dto.clienteDto;


import br.com.jarvis.plusoft.model.Cliente;

import java.time.LocalDate;

public record ListagemClienteDtO(Long id, String nome, String sobrenome, String email, String cpf, String rg, LocalDate datanascimento) {

    public ListagemClienteDtO(Cliente cliente){
        this(cliente.getId(), cliente.getNome(),cliente.getSobrenome(), cliente.getEmail(), cliente.getCpf(), cliente.getRg(),cliente.getDataNascimento());
    }

}
