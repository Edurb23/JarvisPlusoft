package br.com.jarvis.plusoft.model;

import br.com.jarvis.plusoft.dto.telefoneDto.AtualizacaoTelefone;
import br.com.jarvis.plusoft.dto.telefoneDto.NovoTelefoneDto;
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
@SequenceGenerator(name = "seq_telefone", sequenceName = "SEQ_TB_PL_TELEFONE", allocationSize = 1)
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq_telefone")
    @Column(name="ID_TELEFONE", length = 8)
    private Long id;

    @Column(name = "NR_TELEFONE", length = 11, nullable = false, unique = true)
    private String numeroTelefone;

    @Column(name = "DDD_TELEFONE", length = 2, nullable = false)
    private String ddd;

    @Column(name = "DS_TELEFONE", length = 30, nullable = false)
    private String operadora;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE", nullable = false)
    private Cliente cliente;

    public Telefone(NovoTelefoneDto novoTelefoneDto, Cliente cliente) {
        this.numeroTelefone = novoTelefoneDto.numeroTelefone();
        this.ddd = novoTelefoneDto.ddd();
        this.operadora = novoTelefoneDto.operadora();
        this.cliente = cliente;
    }

    public void atualizarTelefone(AtualizacaoTelefone dto) {
        if (dto.numeroTelefone() != null) {
            this.numeroTelefone = dto.numeroTelefone();
        }
        if (dto.ddd() != null) {
            this.ddd = dto.ddd();
        }
        if (dto.operadora() != null) {
            this.operadora = dto.operadora();
        }
    }
}
