package br.com.jarvis.plusoft.model;

import br.com.jarvis.plusoft.dto.clienteDto.AtualizacaoCliente;
import br.com.jarvis.plusoft.dto.clienteDto.CadastroClienteDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_PL_CLIENTE")
@SequenceGenerator(name = "seq_cliente", sequenceName = "SEQ_TB_PL_CLIENTE", allocationSize = 1)
public class Cliente implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq_cliente")
    @Column(name = "ID_CLIENTE", length = 8)
    private Long id;

    @Column(name = "NM_CLIENTE", length = 100,nullable = false)
    private String nome;

    @Column(name = "NM_SOBRENOME", length = 100,nullable = false)
    private String sobrenome;

    @Column(name = "DS_EMAIL", length = 100,nullable = false, unique = true)
    private String email;

    @Column(name = "DS_SENHA",nullable = false)
    private String password;



    @Column(name = "NR_CPF", length = 11, nullable = false, unique = true)
    private String cpf;

    @Column(name = "DT_NASCIMENTO",nullable = false )
    private LocalDate dataNascimento;

    @Column(name = "NR_RG", length = 9, nullable = false ,unique = true)
    private  String rg;





    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Telefone> telefones;


        @ManyToMany(mappedBy = "clientes")
        private List<Produto>produtos;

    public Cliente(@NotBlank(message = "Nome é obrigatório") @Size(max = 100, message = "o nome deve ter no máximo 100 caracteres") String nome, @NotBlank(message = "Sobrenome é obrigatório") @Size(max = 100, message = "o Sobrenome deve ter no máximo 100 caracteres") String sobrenome, @NotBlank(message = "Email é obrigatório") @Size(max = 100, message = "o email deve ter no máximo 100 caracteres") String email, String encode, @NotBlank(message = "CPF é obrigatório") @Size(max = 11, min = 11, message = "CPF deve ter no máximo 11 números") String cpf, @Past LocalDate localDate, @NotBlank(message = "RG é obrigatório") @Size(max = 9, min = 9, message = "RG deve ter no máximo 9 números") String rg) {
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.email = email;
    this.password = encode;
    this.cpf = cpf;
    this.dataNascimento = localDate;
    this.rg = rg;

    }


    public void atualizarCliente(AtualizacaoCliente dto) {
        if(dto.nome() != null)
            nome = dto.nome();
        if(dto.sobrenome() != null)
            sobrenome = dto.sobrenome();
        if(dto.email() != null)
            email = dto.email();
        if (dto.cpf() != null)
            cpf = dto.cpf();
        if (dto.dataNascimento() != null)
            dataNascimento = dto.dataNascimento();
        if (dto.rg() != null)
            rg = dto.rg();

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
