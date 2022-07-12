package com.facec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.facec.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{

	List<Veiculo> findByChassiContaining(String consultar);
	
	List<Veiculo> findByModeloContaining(String consultarModelo);
	
	@Query("select v from Veiculo v where v.chassi like :chassi")
	List<Veiculo> queryByChassi(@Param("chassi") String chassi);
	

}
