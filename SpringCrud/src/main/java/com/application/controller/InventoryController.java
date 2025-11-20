package com.application.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.entity.Product;
import com.application.service.InventoryService;
//import com.application.service.List;

@RestController
@RequestMapping("/app") //Main url
public class InventoryController {
	
//	the controller need service dependency
	
	
//	the purpouse of the controller is to develop webservices/restfull api
//	REST(representational state transfer)
//	the restapi also methods only
	
	@Autowired
	private InventoryService service;
	
//	webservices/REST  API
//	1..websevices for insert
	
//	this is the webservice method part
	@PostMapping("/insert") //sub url....
	public ResponseEntity<Product> savaData(@RequestBody Product p) {
	Product p1 = service.insert(p);
	return ResponseEntity.ok(p1);
	}
	
//2..webservices for read all products
	@GetMapping("/readall")
	public List<Product> readAll() {
		List<Product> all =service.read(null);
		return all;
	}
	
	
//	3..webservice for deleting one product
	@DeleteMapping("/delete/{id}")
	public void deleteone(@PathVariable int id) {
		service.delete(id);
	}
	
//4..updating one product
	@PutMapping("/update/{id}")
	public Product updateone(@PathVariable int id,@RequestBody Product pd) {
		Product updateProduct = service.update(id, pd);
		return updateProduct;
	}
//	
////	5..reading one record
//	@GetMapping("readone/{id}")
//	public Optional<Product> readone(int id , Product p) {
//		Optional<Product> one = service.readone(id, p);
//		return one;
//	}

}
