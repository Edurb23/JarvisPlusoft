package br.com.jarvis.plusoft.dto.telefoneDto;

import br.com.jarvis.plusoft.dto.clienteDto.DetalhesClienteDto;
import br.com.jarvis.plusoft.model.Telefone;

public record ListagemTelefoneDto(Long id  , String numeroTelefone, String ddd, String operadora, DetalhesClienteDto detalhesClienteDto) {
    public ListagemTelefoneDto(Telefone telefone){
        this(telefone.getId(), telefone.getNumeroTelefone(), telefone.getDdd(), telefone.getOperadora(), new DetalhesClienteDto(telefone.getCliente()));
    }
}

