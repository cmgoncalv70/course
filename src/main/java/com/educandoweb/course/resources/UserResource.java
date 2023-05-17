package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

//To test the REST
//Para definir que a classe é um recurso web implementado por um controlador REST usar a annotation abaixo
@RestController
//tem que dar nome ao recurso
@RequestMapping(value="/users")
public class UserResource {

	//metodo que será um endpoint para acessar os usuarios
	//ResponseEntity é um tipo de retorno especifico do spring para retornar requisições web
	//O tipo de resposta será a classe User
	//Para indicar que esse metodo responde á requisição do tipo get do http, usar a anotação GetMapping.
	@GetMapping
	public ResponseEntity<User> findAll() {
		User u = new User(1L,"Maria","maria@gmail.com","9999999","12345");
		return ResponseEntity.ok().body(u);
		
	}
}
