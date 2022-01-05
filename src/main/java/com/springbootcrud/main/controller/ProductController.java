package com.springbootcrud.main.controller;

import java.awt.PageAttributes.MediaType;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprinbootcrud.main.response.ResponseHandler;
import com.springboot.main.entity.Product;
import com.springbootcrud.main.service.ProductService;

@RestController
@RequestMapping("/api")
@Component
public class ProductController {
	  
	  @Autowired
	  private ProductService productService;
	  
	  @Autowired
	  private Environment env;
	  
		
	  @GetMapping("/products")
		public ResponseEntity<Object> getAllProduct() {
		  LocalDateTime startTime = LocalDateTime.now();
			try {
	             List<Product> result = (productService.getAllProduct());
	             LocalDateTime endtime = LocalDateTime.now();
				return ResponseHandler.generateResponse(env.getProperty("message.1"), HttpStatus.OK, result, startTime ,endtime);
			}  catch (Exception e) 
			{
				LocalDateTime endtime = LocalDateTime.now();
	            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null, startTime, endtime);
	        }
			
		}

	
		@GetMapping("/products/{id}")
	     public ResponseEntity<Object> getProductById(@PathVariable long id) {
			LocalDateTime startTime = LocalDateTime.now();
			try {
	             Product result = (productService.getProductById(id));
	             LocalDateTime endtime = LocalDateTime.now();
				return ResponseHandler.generateResponse(env.getProperty("C001"), HttpStatus.OK, result, startTime ,endtime);
			}  catch (Exception e) 
			{
				LocalDateTime endtime = LocalDateTime.now();
	            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null, startTime, endtime);
	        }
		
	}

	@PostMapping("/products")
	public ResponseEntity<Object> createProduct(@RequestBody Product product) {
		LocalDateTime startTime = LocalDateTime.now();
		try {
             Product result = productService.createProduct(product);
             LocalDateTime endtime = LocalDateTime.now();
			return ResponseHandler.generateResponse(env.getProperty("C002"), HttpStatus.OK, result, startTime ,endtime);
		}  catch (Exception e) 
		{
			LocalDateTime endtime = LocalDateTime.now();
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null, startTime, endtime);
        }
		
	}

	@PutMapping("/products/{id}")
	public ResponseEntity<Object> updateProduct(@PathVariable long id, @RequestBody Product product) {
		LocalDateTime startTime = LocalDateTime.now();
		try {
		product.setId(id);
		Product result = (this.productService.updateProduct(product));
		LocalDateTime endtime = LocalDateTime.now();
		return ResponseHandler.generateResponse(env.getProperty("C003"), HttpStatus.OK, result, startTime ,endtime);
		}  catch (Exception e) 
		{
			LocalDateTime endtime = LocalDateTime.now();
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null, startTime, endtime);
        }
	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable long id) {
		LocalDateTime startTime = LocalDateTime.now();
		try {
             Optional<Product> result = this.productService.deleteProduct(id);
             LocalDateTime endtime = LocalDateTime.now();
			return ResponseHandler.generateResponse(env.getProperty("C004"), HttpStatus.OK, result, startTime ,endtime);
		}  catch (Exception e) 
		{
			LocalDateTime endtime = LocalDateTime.now();
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null, startTime, endtime);
        }
	
	}
		
}

