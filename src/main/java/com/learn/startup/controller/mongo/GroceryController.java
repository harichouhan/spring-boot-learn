package com.learn.startup.controller.mongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.startup.model.mongo.GroceryItem;
import com.learn.startup.repository.mongo.ItemRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@SecurityRequirement(name = "bearer-key") 
public class GroceryController {
	
	
	    @Autowired
	    private ItemRepository repo;
	  
	    @PostMapping("/addGrocery")
	    public String saveBook(@RequestBody GroceryItem groceryItem){
	        repo.save(groceryItem);
	        
	        return "Added Successfully";
	    }
	  
	    @GetMapping("/findAll")
	    public List<GroceryItem> getBooks() {
	        
	        return repo.findAll();
	    }
	  
	    @DeleteMapping("/delete/{id}")
	    public String deleteBook(@PathVariable Long id){
	        repo.deleteById(id);
	        
	        return "Deleted Successfully";
	    }

}
