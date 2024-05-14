package br.com.jarvis.plusoft.repository;

import br.com.jarvis.plusoft.model.EnderecoCliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<EnderecoCliente, Long> {
}
