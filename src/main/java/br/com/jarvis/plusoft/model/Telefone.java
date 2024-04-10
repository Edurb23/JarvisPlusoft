package br.com.jarvis.plusoft.model;


import br.com.jarvis.plusoft.Dto.telefoneDto.AtualizacaoTelefone;
import br.com.jarvis.plusoft.Dto.telefoneDto.NovoTelefoneDto;
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
@Table(name = "TB_PL_TELEFONE")
public class Telefone {
    @Id
    @GeneratedValue
    @Column(name="ID_TELEFONE", length = 8)
    private Long id;

    @Column(name = "NR_TELEFONE", length = 11, nullable = false, unique = true)
    private String numeroTelefone;

    @Column(name = "DDD_TELEFONE", length = 2, nullable = false)
    private String ddd;

    @Column(name = "DS_TELEFONE", length = 30, nullable = false)
    private String operadora;


    public Telefone(NovoTelefoneDto novoTelefoneDto) {
        numeroTelefone = novoTelefoneDto.numeroTelefone();
        ddd = novoTelefoneDto.ddd();
        operadora = novoTelefoneDto.operadora();
    }



    public void atualizarTelefone(AtualizacaoTelefone dto) {
        if(dto.numeroTelefone() != null)
            numeroTelefone = dto.numeroTelefone();
        if(dto.ddd() != null)
            ddd = dto.ddd();
        if(dto.operadora() != null)
            operadora = dto.operadora();
    }
}
