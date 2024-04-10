package br.com.jarvis.plusoft.Repository;

import br.com.jarvis.plusoft.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository <Email, Long> {

}
