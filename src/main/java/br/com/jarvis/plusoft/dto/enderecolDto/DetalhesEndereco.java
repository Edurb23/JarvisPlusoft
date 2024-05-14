package br.com.jarvis.plusoft.dto.enderecolDto;

import br.com.jarvis.plusoft.model.EnderecoCliente;

public record DetalhesEndereco(Long id , String nomeRua, String numeroResidencia, String nomeBairro) {
    public DetalhesEndereco(EnderecoCliente enderecoCliente){
        this(enderecoCliente.getId(), enderecoCliente.getNomeRua(), enderecoCliente.getNumeroResidencia(), enderecoCliente.getNomeBairro());
    }
}
