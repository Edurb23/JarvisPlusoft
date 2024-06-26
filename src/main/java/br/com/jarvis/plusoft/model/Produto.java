package br.com.jarvis.plusoft.model;

import br.com.jarvis.plusoft.dto.produtoDto.AtualizacaoPrdotuo;
import br.com.jarvis.plusoft.dto.produtoDto.CadastroProdutoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "TB_PL_PRODUTO")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "seq_produto", sequenceName = "seq_tb_pl_produto", allocationSize = 1)
public class Produto {

    @Id
    @Column(name = "ID_PRODUTO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produto")
    private Long id;

    @Column(name =  "NM_PRODUTO", length = 150, nullable = false)
    private String nomeProduto;

    @Column(name = "DS_CATEGORIA", length = 150, nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoriaProduto categoriaProduto;


    @Column(name = "NR_TAMANHO", length = 25, nullable = false)
    @Enumerated(EnumType.STRING)
    private TamanhoProduto tamanhoProduto;

    @Column(name = "NR_PRECO", precision = 10)
    private Double preco;


    @Column(name = "DS_PRODUTO", length = 150)
    private  String descricao;


    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private List<Pagamento> pagamentos;


    @ManyToMany
    @JoinTable(name = "TB_PL_CLIENTE_PRODUTO",
               joinColumns = @JoinColumn(name = "ID_PRODUTO"),
                inverseJoinColumns =  @JoinColumn(name = "ID_CLIENTE"))
    private List<Cliente> clientes;




    public Produto(CadastroProdutoDto cadastroProdutoDto) {
        nomeProduto = cadastroProdutoDto.nomeProduto();
        categoriaProduto = cadastroProdutoDto.categoriaProduto();
        tamanhoProduto = cadastroProdutoDto.tamanhoProduto();
        preco = cadastroProdutoDto.preco();
        descricao =cadastroProdutoDto.descricao();
    }

    public void atualizarProduto(AtualizacaoPrdotuo dto) {
        if(dto.nomeProduto() != null)
            nomeProduto = dto.nomeProduto();
        if(dto.categoriaProduto() != null)
            categoriaProduto = dto.categoriaProduto();
        if(dto.tamanhoProduto() != null)
            tamanhoProduto = dto.tamanhoProduto();
        if(dto.preco() != null)
            preco = dto.preco();
        if(dto.descricao() != null)
            descricao = dto.descricao();
    }
}
