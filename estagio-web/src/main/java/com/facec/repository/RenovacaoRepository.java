package com.facec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.facec.model.Cnh;
import com.facec.model.Renovacao;

public interface RenovacaoRepository extends JpaRepository<Renovacao, Long>{
	
	List<Renovacao> findByCnh(Cnh cnh);

}
