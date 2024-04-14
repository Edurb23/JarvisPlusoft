package br.com.jarvis.plusoft.Dto.telefoneDto;

import br.com.jarvis.plusoft.model.Telefone;

public record ListagemTelefoneDto(Long id  , String numeroTelefone, String ddd, String operadora) {
    public ListagemTelefoneDto(Telefone telefone){
        this(telefone.getId(), telefone.getNumeroTelefone(), telefone.getDdd(), telefone.getOperadora());
    }
}
