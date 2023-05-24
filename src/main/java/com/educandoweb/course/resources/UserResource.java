package com.educandoweb.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;

//To test the REST
//Para definir que a classe é um recurso web implementado por um controlador REST usar a annotation abaixo
@RestController
//tem que dar nome ao recurso
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service;

	//metodo que será um endpoint para acessar os usuarios
	//ResponseEntity é um tipo de retorno especifico do spring para retornar requisições web
	//O tipo de resposta será a classe User
	//Para indicar que esse metodo responde á requisição do tipo get do http, usar a anotação GetMapping.
	@GetMapping	//retorna todos os usuarios
	public ResponseEntity<List<User>> findAll() {	
		List<User> list = service.findAll();				
		return ResponseEntity.ok().body(list);		
	}
	
	@GetMapping(value = "/{id}")	//retorna um usuario especifico
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);		
	}
}
