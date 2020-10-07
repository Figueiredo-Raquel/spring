package org.generation.blogPessoal2.controller;

import java.util.List;

import org.generation.blogPessoal2.model.Postagem2;
import org.generation.blogPessoal2.repository.Postagem2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Informando que essa classe se trata de um controller.
@RequestMapping("/postagens") // Definindo por qual uri que essa classe sera chamada, toda vez que chamar
								// /postagens essa classe sera chamada.
@CrossOrigin("*") // Essa classe aceita requisiçao de qualquer origem.
public class Postagem2Controller {

	@Autowired // Vai instanciar a class repository dentro dessa interface,para que a
				// postagemrepository seja acessado apartir do controller.
	private Postagem2Repository repository; // Estamos chamando nossa class repository

	@GetMapping //GET metodo de busca. Toda vez que alguem chamar o get /postagens ele vai disparar esse metodo.
	public ResponseEntity<List<Postagem2>> GetAll() {
		return ResponseEntity.ok(repository.findAll());// estamos dando a informaçao que vai aparecer na tela como OK quando estiver tudo certo.
	}

	@GetMapping("/{id}") //GET metodo de busca. Ja estamos passando o paremetro que vai usar para buscar id.
	public ResponseEntity<Postagem2> GetById(@PathVariable long id) {// o valor que vai entrar dentro do id vai ser uma
																		// variavel do caminho da uri.
		return repository.findById(id) // injetando o repositorio na busca pelo id.
				.map(resp -> ResponseEntity.ok(resp)) // retorna a postagem .
				.orElse(ResponseEntity.notFound().build());//caso exista erro ele vai responder com um notfound.
	}
	
	@GetMapping("/titulo/{titulo}")//GET metodo de busca passando parametro para que o back entenda o que estamos fazendo e ele vai chamar por qualquer palavra dentro do meu titulo.
	public ResponseEntity<List<Postagem2>>GetByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));//passamos o parametro que criamos na interface repository
	}
	 @PostMapping // para fazer postagens . nao passa o id .
	 public ResponseEntity<Postagem2> post(@RequestBody Postagem2 postagem){
		 return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));//vai criar um post,mostrar a body e salvar.
	 }
	 
	 @PutMapping //para modificarv ou atualizar, passar o id .
	 public ResponseEntity<Postagem2> put(@RequestBody Postagem2 postagem){
		 return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));//vai criar um post,mostrar a body e salvar.
	 }
	 @DeleteMapping("/{id}") // excluir um dado por id
	 public void delete(@PathVariable long id) {
		 repository.deleteById(id);
	 }

}
