package br.com.jarvis.plusoft.model;

import br.com.jarvis.plusoft.Dto.produtoDto.AtualizacaoPrdotuo;
import br.com.jarvis.plusoft.Dto.produtoDto.CadastroProdutoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "TB_PL_PRODUTO")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue
    @Column(name = "ID_PRODUTO")
    private Long id;

    @Column(name =  "NM_PRODUTO", length = 150, nullable = false)
    private String nomeProduto;

    @Column(name = "DS_CATEGORIA", length = 150, nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoriaProduto categoriaProduto;


    @Column(name = "NR_TAMANHO", length = 25, nullable = false)
    private String tamanhoProduto;

    @Column(name = "NR_PRECO", precision = 10)
    private Double preco;


    @Column(name = "DS_PRODUTO", length = 150)
    private  String descricao;

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
