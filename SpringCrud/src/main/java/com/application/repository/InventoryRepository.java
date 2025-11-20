package com.application.repository;
 


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.entity.Product;

@Repository
public interface InventoryRepository extends JpaRepository<Product, Integer> {
	
//	as a programmer we can write required methods with logic for save, read, update, delete
//	as a programmer no nee to write any code because we using jpa repository 
//	2 options are there 1) is crud repository 2) is Jpa repository
//	1.. handel only basic transation with db(crud)
//	2.. handles some extra transations like triggers indexing etc..
//	 so for that we choose Jpa(2)
	
//	after extending that Jpa we need to provide 2 things
//	 1.. is entity class name or bean calls name
//	 2.. thing is we need to provide primary key or(@id) data type 
//	in my case it's int . but here we write Integer.
//	 note:-- order of import statements are important some time it may lead to error

}
