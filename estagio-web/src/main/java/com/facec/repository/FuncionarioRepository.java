package com.facec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.facec.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
	
	List<Funcionario> findByNome(String nome);
	
	
	@Query("select f from Funcionario f where f.nome like :nome")
	List<Funcionario> queryByNome(@Param("nome") String nome);

	List<Funcionario> findByNomeContaining(String consultar);
	
}
