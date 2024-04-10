package br.com.jarvis.plusoft.model;

import br.com.jarvis.plusoft.Dto.clienteDto.AtualizacaoCliente;
import br.com.jarvis.plusoft.Dto.clienteDto.CadastroClienteDto;
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
@Table(name = "TB_PL_CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue
    @Column(name = "ID_CLIENTE", length = 8)
    private Long id;

    @Column(name = "NM_CLIENTE", length = 100,nullable = false)
    private String nome;

    @Column(name = "NR_CPF", length = 11, nullable = false, unique = true)
    private String cpf;

    @Column(name = "DT_NASCIMENTO",nullable = false )
    private LocalDate dataNascimento;

    @Column(name = "NR_RG", length = 9, nullable = false ,unique = true)
    private  String rg;

    @Column(name = "CD_SENHA", length = 150, nullable = false)
    private String senha;

    public Cliente(CadastroClienteDto cadastroClienteDto) {
        nome = cadastroClienteDto.nome();
        cpf  = cadastroClienteDto.cpf();
        dataNascimento = cadastroClienteDto.dataNascimento();
        rg = cadastroClienteDto.rg();
        senha = cadastroClienteDto.senha();
    }

    public void atualizarAluno(AtualizacaoCliente dto) {
        if(dto.nome() != null)
            nome = dto.nome();
        if (dto.cpf() != null)
            cpf = dto.cpf();
        if (dto.dataNascimento() != null)
            dataNascimento = dto.dataNascimento();
        if (dto.rg() != null)
            rg = dto.rg();
        if (dto.senha() != null)
            senha = dto.senha();
    }
}
