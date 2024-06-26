package br.com.jarvis.plusoft.model;

import br.com.jarvis.plusoft.dto.emailDto.AtualizarEmail;
import br.com.jarvis.plusoft.dto.emailDto.NovoEmailDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_PL_EMAIL")
public class Email {
    @Id
    @GeneratedValue
    @Column(name = "ID_EMAIL", length = 8 )
    private Long id;

    @Column(name = "NM_EMAIL", length = 22 ,nullable = false , unique = true)
    private String email;

    @Column(name = "DS_EMAIL", length = 30 ,nullable = false)
    private  String dadosEmail;

    @Column(name = "ST_EMAIL", length = 30 ,nullable = false)
    private  String statusEmail;


    @ManyToOne()
    @JoinColumn(name = "ID_CLIENTE" , nullable = false)
    private Cliente cliente;

    public Email(NovoEmailDto novoEmailDto, Cliente cliente) {
        email = novoEmailDto.email();
        dadosEmail = novoEmailDto.dadosEmail();
        statusEmail = novoEmailDto.statusEmail();
        this.cliente = cliente;

    }






    public void atualizacaoEmail(AtualizarEmail dto) {
        if(dto.email() != null)
            email = dto.email();
        if(dto.dadosEmail() != null)
            dadosEmail = dto.dadosEmail();
        if (dto.statusEmail() != null)
            statusEmail = dto.statusEmail();
    }
}
