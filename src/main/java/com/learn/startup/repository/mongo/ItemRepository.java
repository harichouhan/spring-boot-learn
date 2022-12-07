package com.learn.startup.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.learn.startup.model.mongo.GroceryItem;

@Repository
public interface ItemRepository extends MongoRepository<GroceryItem, Long> {
    
//    @Query("{name:'?0'}")
//    GroceryItem findItemByName(String name);
//    
//    @Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
//    List<GroceryItem> findAll(String category);
//    
//    public long count();

}