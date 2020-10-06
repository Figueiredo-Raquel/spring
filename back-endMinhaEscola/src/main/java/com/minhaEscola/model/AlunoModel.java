package com.minhaEscola.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_aluno") // dando nome a tabela.
public class AlunoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // indicando uma chave primaria.
	private  long idAluno;
    
	@NotNull
	@Size(max = 255)
	private String nomeAluno;

	private boolean matriculadoAluno;
	

	public long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(long idAluno) {
		this.idAluno = idAluno;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public boolean isMatriculadoAluno() {
		return matriculadoAluno;
	}

	public void setMatriculadoAluno(boolean matriculadoAluno) {
		this.matriculadoAluno = matriculadoAluno;
	}

}
