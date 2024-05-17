package br.com.jarvis.plusoft.dto.produtoDto;

import br.com.jarvis.plusoft.model.CategoriaProduto;
import br.com.jarvis.plusoft.model.TamanhoProduto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AtualizacaoPrdotuo(

        @NotBlank(message = "Nome do produto é obrigatório")
        @Size(max = 150, message = "o nome do produto deve ter no máximo 150 caracteres")
        String nomeProduto,
        @NotBlank(message = "Categoria do produto é obrigatório")
        CategoriaProduto categoriaProduto,
        @NotBlank(message = "Tamanho  é obrigatório")
        TamanhoProduto tamanhoProduto,
        @NotBlank(message = "Preco é obrigatório")
        Double preco,

        @NotBlank(message = "Descrição do produto é obrigatório")
        @Size(max = 250, message = "Descrição do produto deve ter no máximo 250 caracteres")
        String descricao)
{
}
