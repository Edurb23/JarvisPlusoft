package br.com.jarvis.plusoft.Repository;

import br.com.jarvis.plusoft.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
