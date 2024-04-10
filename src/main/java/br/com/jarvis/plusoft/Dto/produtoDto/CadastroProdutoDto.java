package br.com.jarvis.plusoft.Dto.produtoDto;

import br.com.jarvis.plusoft.model.CategoriaProduto;

public record CadastroProdutoDto(String nomeProduto, CategoriaProduto categoriaProduto, String tamanhoProduto, Double preco, String descricao) {
}
