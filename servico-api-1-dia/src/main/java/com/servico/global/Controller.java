package com.servico.global;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@Autowired
	private ServicoRepository repository;
	
	@GetMapping("/servicos")
	public List<ServicoModel> pegarTodos(){
		return repository.findAll();
	}
	
	@PostMapping("/servicos")
	public ServicoModel criar (@RequestBody ServicoModel model) {
		repository.save(model);
		return model;
	}
	
	@GetMapping ("/servico/nome/{nome}")
	public List<ServicoModel> buscaPorNome(@PathVariable String nome){
		return repository.findByNome(nome);
	}
	
	@PutMapping ServicoModel atualizar(@PathVariable Long id, @RequestBody ServicoModel model) {
		model.setId(id);
		repository.save(model);
		return model;
	}
	@DeleteMapping("/Servico/{id}") 
		public String remover (@PathVariable long id) {
			repository.deleteById(id);
			return "sucesso";
		}
}
