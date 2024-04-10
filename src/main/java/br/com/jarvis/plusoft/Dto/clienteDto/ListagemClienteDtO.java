package br.com.jarvis.plusoft.Dto.clienteDto;

import br.com.jarvis.plusoft.model.Cliente;

import java.time.LocalDate;

public record ListagemClienteDtO(Long id, String nome, String cpf, String rg,LocalDate datanascimento, String senha) {

    public ListagemClienteDtO(Cliente cliente){
        this(cliente.getId(), cliente.getNome(),cliente.getCpf(), cliente.getRg(),cliente.getDataNascimento(), cliente.getSenha());
    }

}
