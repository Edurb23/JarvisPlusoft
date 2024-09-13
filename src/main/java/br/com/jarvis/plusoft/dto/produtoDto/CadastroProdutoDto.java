package br.com.jarvis.plusoft.dto.produtoDto;

import br.com.jarvis.plusoft.model.CategoriaProduto;
import br.com.jarvis.plusoft.model.TamanhoProduto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
@Schema(description = "Informações para cadastro de Produtos")
public record CadastroProdutoDto(

        @NotBlank(message = "Nome do produto é obrigatório")
        @Size(max = 150, message = "o nome do produto deve ter no máximo 150 caracteres")
        @Schema(description = "Nome do Produto")
        String nomeProduto,

        @NotBlank(message = "Categoria do produto é obrigatório")
        @Schema(description = "Nome do Produto",  enumAsRef = true )
        CategoriaProduto categoriaProduto,
        @NotBlank(message = "Tamanho  é obrigatório")
        @Schema(description = "Nome do Produto", enumAsRef = true )
        TamanhoProduto tamanhoProduto,
        @NotBlank(message = "Preco é obrigatório")
        @Schema(description = "Preço do Produto")
        Double preco,

        @NotBlank(message = "Descrição do produto é obrigatório")
        @Schema(description = "Descrição do Produto")
        @Size(max = 250, message = "Descrição do produto deve ter no máximo 250 caracteres")
        String descricao
)
{
}
