package com.project2aws.training.revature.services;

import com.project2aws.training.revature.model.Item;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ItemService {
    public boolean itemExists(int itemId);
    public ResponseEntity<String> addItem(Item item);
    ResponseEntity<String> deleteItem(int itemId);
    public List<Item> getItems();
    public ResponseEntity<String> addStock(Item item);


}
