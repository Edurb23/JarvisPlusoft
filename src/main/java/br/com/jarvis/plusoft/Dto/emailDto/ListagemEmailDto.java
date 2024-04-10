package br.com.jarvis.plusoft.Dto.emailDto;

import br.com.jarvis.plusoft.model.Email;

public record ListagemEmailDto(Long id, String email , String dadosEmail, String statusEmail) {

    public ListagemEmailDto(Email email){
        this(email.getId(), email.getEmail(), email.getDadosEmail(), email.getStatusEmail() );
    }
}
