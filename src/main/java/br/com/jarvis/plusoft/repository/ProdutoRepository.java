package br.com.jarvis.plusoft.repository;

import br.com.jarvis.plusoft.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
