package com.servico.demo;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

	@Autowired
	private ServicoRepository repository;

	@GetMapping("/servicos")
	public List<ServicoModel> pegarTodos() {
          return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ServicoModel> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<>>GetByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	// requerer a resposta, save
	@PostMapping ("/servicos")
	public ServicoModel criar(@RequestBody ServicoModel model) {
		repository.save(model);
		return model;
	}
	
	@GetMapping("servico/nome/{nome}")
	public List<ServicoModel> buscarPorNome(@PathVariable String nome){
		return repository.findBynome(nome);
	}
	
	@DeleteMapping("/servicos/{id}")
	public String remover(@PathVariable Long id) {	
		repository.deleteById(id);
	return "sucesso";
	}
	
	


	
	
	
}
