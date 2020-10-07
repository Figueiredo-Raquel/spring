package org.generation.blogPessoal2.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity // Estou dizendo que essa class é uma entidade.
@Table(name = "postagem") // Criando a tabela e dando o nome.
public class Postagem2 {

	@Id // colocando que ele é um id.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Estou gerando valores é dizendo que esse id e uma primare
														// key.
	private long id;

	@NotNull // Estou dizendo que o campo nao pode ficar vazio.
	@Size(min = 5, max = 100) // Estou informando a quantidade de caracter que quero como titulo.
	private String titulo;

	@NotNull // Estou dizendo que o campo nao pode ficar vazio.
	@Size(min = 10, max = 500) // Estou informando a quantidade de caracter que quero como texto.
	private String texto;

	@Temporal(TemporalType.TIMESTAMP) // Estou informando que estou trabalhando com o tempo,na hora em que for escrita
										// a postagem.
	private Date data = new java.sql.Date(System.currentTimeMillis());

	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

}
