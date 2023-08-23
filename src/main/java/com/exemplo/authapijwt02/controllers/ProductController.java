package com.exemplo.authapijwt02.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.exemplo.authapijwt02.entities.product.Product;
import com.exemplo.authapijwt02.repositories.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;

	@GetMapping
	public List<Product> listar() {		
		return productRepository.findAll();	
	}
	
	@PostMapping
	//@ResponseStatus(HttpStatus.CREATED)	//para retornar 201 - Created
	public Product adicionar(@RequestBody Product product) {		
		return productRepository.save(product);	
	}
}
