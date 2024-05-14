package br.com.jarvis.plusoft.repository;

import br.com.jarvis.plusoft.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
