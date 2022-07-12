package com.facec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.facec.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
List<Cliente> findByNome(String nome);

	
	@Query("select c from Cliente c where c.nome like :nome")
	List<Cliente> queryByNome(@Param("nome") String nome);

	List<Cliente> findByNomeContaining(String consultar);
	

}
