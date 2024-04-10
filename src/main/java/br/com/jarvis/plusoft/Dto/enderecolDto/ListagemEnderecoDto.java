package br.com.jarvis.plusoft.Dto.enderecolDto;

import br.com.jarvis.plusoft.model.EnderecoCliente;

public record ListagemEnderecoDto(Long id , String nomeRua, String numeroResidencia, String nomeBairro) {

    public ListagemEnderecoDto(EnderecoCliente enderecoCliente){
        this(enderecoCliente.getId(), enderecoCliente.getNomeRua(), enderecoCliente.getNumeroResidencia(), enderecoCliente.getNomeBairro());
    }
}
