package org.generation.blogPessoal2.repository;

import java.util.List;

import org.generation.blogPessoal2.model.Postagem2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Informando que se trata de um repositorio.
public interface Postagem2Repository extends JpaRepository<Postagem2, Long>{ //Estou herdando da classe model postagem.                       

	public List<Postagem2> findAllByTituloContainingIgnoreCase(String titulo);// ele vai fazer uma lista de tudo que esta dentro de titulo ignorando maiusculo e minusculo.
}
