package com.application.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestMapping;

import com.application.entity.Product;
import com.application.repository.InventoryRepository;


// the purpose of service layer is to write the business logic
@Service
public class InventoryService {

//	 the service layer need to connect to repository layer
//	no need to worry about all the configurations
//	 we just add repository dependency
	
//	just import that 

	
//	without autowried we can perform by using constructor
	
	// this annotations used to inject dependency in SpringBoot	
	@Autowired 
 private InventoryRepository repository;
	
//instead of writing all fields in the product call just import the product class
	
//	method to insert product
	public Product insert(Product p ) {
	Product p1 = repository.save(p); 
		return p1;
	}
	
	
//	/method to read all products
	public List<Product> read(Product p) {
		List<Product> all = repository.findAll();
		return all;
	}
	
//	method to delete a product
//	no bases of primary key we can perform delete operation here 
//	we know after delete nothing to display
	public void delete(int id ) {
		repository.deleteById(id);
	}
	
	
//	method for update
	public Product update(int id, Product np) {
		
		Optional<Product> temp = repository.findById(id);
		
		 if(temp.isPresent()) {
			 Product op = temp.get();
			 op.setpName(np.getpName());
			 op.setpCost(np.getpCost());
			 op.setpQty(np.getpQty());
			 
			return repository.save(op);
		 }else {
			  throw new RuntimeException("Product not Found");
		 }
	}

//	
////	read only one product
//	public Optional<Product> readone(int id, Product p) {
//		Optional<Product> one = repository.findById(id);
//		return one;
//	}
//	
//	
	
}
