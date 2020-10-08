package org.lojadegamer;

import java.util.List;
import org.lojadegamer.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long>{

	public List<CategoriaModel> findAllByGeneroContainingIgnoreCase(String genero);

}
