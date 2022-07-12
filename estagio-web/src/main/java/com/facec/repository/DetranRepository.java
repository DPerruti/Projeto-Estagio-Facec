package com.facec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.facec.model.Detran;

public interface DetranRepository extends JpaRepository<Detran, Long>{
	
	List<Detran> findByNome(String nome);
	
	@Query("select d from Detran d where d.nome like :nome")
	List<Detran> queryByNome(@Param("nome") String nome);
	
	List<Detran> findByNomeContaining(String consultar);
	
}
