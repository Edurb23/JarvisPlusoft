package br.com.jarvis.plusoft.model;

import br.com.jarvis.plusoft.dto.pagamentoDto.NovoPagamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_PL_PAGAMENTO")
public class Pagamento {

    @Id
    @GeneratedValue
    @Column(name = "ID_PAGAMENTO")
    private Long id;

    @Column(name = "NM_CARTAO", length = 100, nullable = false)
    private String nome;
    @Column(name = "NR_CARTAO", length = 50, nullable = false)
    private Long numero;
    @Column(name = "DES_DESC_CARTAO", length = 100, nullable = false)
    private String descricao;
    @Column(name = "DT_INICIO")
    private LocalDate data;


    @ManyToOne()
    @JoinColumn(name = "ID_PRODUTO", nullable = false)
    private  Produto produto;


    public Pagamento(NovoPagamento novoPagamento, Produto produto) {
        nome = novoPagamento.nome();
        numero = novoPagamento.numero();
        descricao = novoPagamento.descricao();
        data = novoPagamento.data();
        this.produto = produto;
    }
}
