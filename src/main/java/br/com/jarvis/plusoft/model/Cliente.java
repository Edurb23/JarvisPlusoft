package br.com.jarvis.plusoft.model;

import br.com.jarvis.plusoft.dto.clienteDto.AtualizacaoCliente;
import br.com.jarvis.plusoft.dto.clienteDto.CadastroClienteDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_PL_CLIENTE")
@SequenceGenerator(name = "seq_cliente", sequenceName = "SEQ_TB_PL_CLIENTE", allocationSize = 1)
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq_cliente")
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


    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
     private List<Email> emails;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Telefone> telefones;






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
