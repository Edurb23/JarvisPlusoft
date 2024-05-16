package br.com.jarvis.plusoft.dto.telefoneDto;

import br.com.jarvis.plusoft.model.Cliente;
import br.com.jarvis.plusoft.model.Telefone;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DetalhesTelefoneDto(Long id , String numeroTelefone, String ddd, String operadora)
{

    public DetalhesTelefoneDto(Telefone telefone){
        this(telefone.getId(), telefone.getNumeroTelefone(), telefone.getDdd(), telefone.getOperadora());
    }


}
