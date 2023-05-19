package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.services.OrderService;

//To test the REST
//Para definir que a classe é um recurso web implementado por um controlador REST usar a annotation abaixo
@RestController
//tem que dar nome ao recurso
@RequestMapping(value="/orders")
public class OrderResource {
	
	@Autowired
	private OrderService service;

	//metodo que será um endpoint para acessar os usuarios
	//ResponseEntity é um tipo de retorno especifico do spring para retornar requisições web
	//O tipo de resposta será a classe Order
	//Para indicar que esse metodo responde á requisição do tipo get do http, usar a anotação GetMapping.
	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> list = service.findAll();				
		return ResponseEntity.ok().body(list);		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
