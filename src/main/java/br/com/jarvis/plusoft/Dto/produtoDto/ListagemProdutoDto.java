package br.com.jarvis.plusoft.Dto.produtoDto;

import br.com.jarvis.plusoft.model.CategoriaProduto;
import br.com.jarvis.plusoft.model.Produto;
import br.com.jarvis.plusoft.model.TamanhoProduto;

public record ListagemProdutoDto(Long id, String nomeProduto, CategoriaProduto categoriaProduto, TamanhoProduto tamanhoProduto, Double preco, String descricao) {

    public ListagemProdutoDto(Produto produto){
        this(produto.getId(),produto.getNomeProduto(), produto.getCategoriaProduto(), produto.getTamanhoProduto(), produto.getPreco(), produto.getDescricao());
    }

}
