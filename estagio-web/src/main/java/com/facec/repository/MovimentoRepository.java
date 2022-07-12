package com.facec.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.facec.model.Cliente;
import com.facec.model.Movimento;

public interface MovimentoRepository extends JpaRepository<Movimento, Long>{
	
	List<Movimento> findByCliente(Cliente cliente);
	
	List<Movimento> findByClienteContaining(String consultar);

	@Query("select m from Movimento m where m.cliente = ?1 and m.dataMovimento <= ?2")
	List<Movimento> querySaldo(Cliente cliente, LocalDateTime dataSaldo);
	
	@Query("select m from Movimento m where m.cliente = ?1 and m.dataMovimento >= ?2 and m.dataMovimento <= ?3")
	List<Movimento> queryExtrato(Cliente cliente, LocalDateTime dataInicio, LocalDateTime dataFim);
}
