package br.com.jarvis.plusoft.repository;

import br.com.jarvis.plusoft.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {


    UserDetails findByEmail(String email);


}
