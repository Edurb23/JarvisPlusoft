package br.com.jarvis.plusoft.dto.enderecolDto;

import br.com.jarvis.plusoft.dto.clienteDto.DetalhesClienteDto;
import br.com.jarvis.plusoft.model.EnderecoCliente;

public record ListagemEnderecoDto(Long id , String nomeRua, String numeroResidencia, String nomeBairro, DetalhesClienteDto detalhesClienteDto) {

    public ListagemEnderecoDto(EnderecoCliente enderecoCliente){
        this(enderecoCliente.getId(), enderecoCliente.getNomeRua(), enderecoCliente.getNumeroResidencia(), enderecoCliente.getNomeBairro(), new DetalhesClienteDto(enderecoCliente.getCliente()));
    }
}
