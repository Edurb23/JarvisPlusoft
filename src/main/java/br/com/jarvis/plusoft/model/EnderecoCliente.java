package br.com.jarvis.plusoft.model;

import br.com.jarvis.plusoft.dto.enderecolDto.AtualizacaoEndereco;
import br.com.jarvis.plusoft.dto.enderecolDto.NovoEnderecoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "TB_PL_ENDERECO_CLIENTE")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoCliente {
    @Id
    @GeneratedValue
    @Column(name = "ID_ENDERECO_CLIENTE" , length = 8 )
    private Long id;

    @Column(name = "NM_RUA", length = 50 ,nullable = false)
    private  String nomeRua;

    @Column(name = "NR_RESIDENCIA", length = 50 ,nullable = false)
    private  String numeroResidencia;

    @Column(name = "NM_BAIRRO", length = 30 ,nullable = false)
    private String nomeBairro;

    @OneToOne
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;


    public EnderecoCliente(NovoEnderecoDto novoEnderecoDto, Cliente cliente) {
        nomeRua = novoEnderecoDto.nomeRua();
        numeroResidencia = novoEnderecoDto.numeroResidencia();
        nomeBairro = novoEnderecoDto.nomeBairro();
        this.cliente = cliente;
    }





    public void atualizarendereco(AtualizacaoEndereco dto) {
        if(dto.nomeRua() != null)
            nomeRua = dto.nomeRua();
        if(dto.numeroResidencia() != null)
            numeroResidencia = dto.numeroResidencia();
        if(dto.nomeBairro() != null)
            nomeBairro = dto.nomeBairro();

    }
}
