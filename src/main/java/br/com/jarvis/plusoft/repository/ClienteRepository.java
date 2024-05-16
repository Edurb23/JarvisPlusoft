package br.com.jarvis.plusoft.repository;

import br.com.jarvis.plusoft.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

   // @Query("select r.cliente c where c.nome like %:nome%")
  //  Page<Cliente> buscarPorNome(String nome , Pageable pageable);




}
