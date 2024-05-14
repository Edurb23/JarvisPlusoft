package br.com.jarvis.plusoft.repository;

import br.com.jarvis.plusoft.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
