package br.com.jarvis.plusoft.repository;

import br.com.jarvis.plusoft.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

   // @Query("from Produto c where c.nomeProduto like %:nomeProduto%")
  // Page<Produto> buscarProdutoNome(String nomeProduto , Pageable pageable);



}
