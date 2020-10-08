package org.lojadegamer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_usuario")
public class UsuarioModel {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long id;
     
	 @NotNull
	 @Size(max = 500)
	 private String nome;

	 @NotNull
     @Size(max = 500)
	 private String email; 

	 @NotNull
     @Size(max = 500)
	 private String senha;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
