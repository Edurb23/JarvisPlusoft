package br.com.jarvis.plusoft.Repository;

import br.com.jarvis.plusoft.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
