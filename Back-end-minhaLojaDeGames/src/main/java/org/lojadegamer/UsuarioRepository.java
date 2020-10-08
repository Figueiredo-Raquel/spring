package org.lojadegamer;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel,Long> {

	public List<UsuarioModel> findAllByNomeContainingIgnoreCase(String nome);
}
