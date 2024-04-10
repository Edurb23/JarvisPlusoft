package br.com.jarvis.plusoft.Dto.emailDto;

import br.com.jarvis.plusoft.model.Email;

public record DetalhesEmailDto(Long id, String email , String dadosEmail, String statusEmail) {

    public DetalhesEmailDto(Email email){
        this(email.getId(), email.getEmail(), email.getDadosEmail(), email.getStatusEmail() );
    }
}
