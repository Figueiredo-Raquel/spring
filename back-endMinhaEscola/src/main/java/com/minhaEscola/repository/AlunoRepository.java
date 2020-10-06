package com.minhaEscola.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minhaEscola.model.AlunoModel;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoModel, Long>{
 
	public List<AlunoModel> findAllByNomeAlunoContainingIgnoreCase(String nomeAluno);
	
}
