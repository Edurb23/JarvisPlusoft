package br.com.jarvis.plusoft.model;

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
@Table(name = "TB_PL_CLIENTE_PRODUTO")
public class ClienteProduto {
    @Id
    @GeneratedValue
    @Column(name = "ID_CLIENTE_PRODUTO", length = 8)
    private Long id;
    @Column(name = "DT_INICIO", nullable = false)
    private LocalDate inicio;
    @Column(name = "DT_FIM", nullable = false)
    private LocalDate fim;
}
