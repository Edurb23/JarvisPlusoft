package br.com.jarvis.plusoft.Dto.produtoDto;

import br.com.jarvis.plusoft.model.CategoriaProduto;
import br.com.jarvis.plusoft.model.Produto;

public record DetalhesProdutoDto(Long id, String nomeProduto, CategoriaProduto categoriaProduto, String tamanhoProduto, Double preco, String descricao) {

    public DetalhesProdutoDto(Produto produto){
        this(produto.getId(),produto.getNomeProduto(), produto.getCategoriaProduto(), produto.getTamanhoProduto(), produto.getPreco(), produto.getDescricao());
    }

}
