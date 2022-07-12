package com.facec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.facec.model.Cnh;

public interface CnhRepository extends JpaRepository<Cnh, Long>{
	
	List<Cnh> findByNome(String nome);
	
	@Query("select h from Cnh h where h.nome like :nome")
	List<Cnh> queryByNome(@Param("nome") String nome);
}
