package br.com.jarvis.plusoft.repository;

import br.com.jarvis.plusoft.model.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
}
