package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.services.ProductService;

//To test the REST
//Para definir que a classe é um recurso web implementado por um controlador REST usar a annotation abaixo
@RestController
//tem que dar nome ao recurso
@RequestMapping(value="/products")
public class ProductResource {
	
	@Autowired
	private ProductService service;

	//metodo que será um endpoint para acessar os usuarios
	//ResponseEntity é um tipo de retorno especifico do spring para retornar requisições web
	//O tipo de resposta será a classe Product
	//Para indicar que esse metodo responde á requisição do tipo get do http, usar a anotação GetMapping.
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = service.findAll();				
		return ResponseEntity.ok().body(list);		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
