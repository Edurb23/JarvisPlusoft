package br.com.jarvis.plusoft.Dto.produtoDto;

import br.com.jarvis.plusoft.model.CategoriaProduto;
import br.com.jarvis.plusoft.model.TamanhoProduto;

public record AtualizacaoPrdotuo(String nomeProduto, CategoriaProduto categoriaProduto, TamanhoProduto tamanhoProduto, Double preco, String descricao) {
}
