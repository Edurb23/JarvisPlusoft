package br.com.jarvis.plusoft.dto.emailDto;

import br.com.jarvis.plusoft.dto.clienteDto.DetalhesClienteDto;
import br.com.jarvis.plusoft.model.Email;

public record ListagemEmailDto(Long id, String email , String dadosEmail, String statusEmail, DetalhesClienteDto detalhesClienteDto) {

    public ListagemEmailDto(Email email){
        this(email.getId(), email.getEmail(), email.getDadosEmail(), email.getStatusEmail(), new DetalhesClienteDto(email.getCliente()) );
    }
}
