package br.com.jarvis.plusoft.Dto.telefoneDto;

import br.com.jarvis.plusoft.model.Telefone;

public record DetalhesTelefoneDto(Long id , String numeroTelefone, String ddd, String operadora) {

    public DetalhesTelefoneDto(Telefone telefone){
        this(telefone.getId(), telefone.getNumeroTelefone(), telefone.getDdd(), telefone.getOperadora());
    }

}
