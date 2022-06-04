/**
 * Service ---> ServiceImpl
 */

package com.project1aws.training.revature.services;

import com.project1aws.training.revature.dao.ItemDAO;
import com.project1aws.training.revature.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    ItemDAO itemDAO;

    @Override
    public boolean itemExists(int itemId) {
        return itemDAO.existsById(itemId);
    }

    // Adds an item
    public ResponseEntity<String> addItem(Item item) {
        ResponseEntity responseEntity;
        if(itemExists(item.getItemId())) {
            return new ResponseEntity<String>("Cannot add item, already exists. You can increase item stock however", HttpStatus.CONFLICT);
        }
        else {
            itemDAO.save(item);
            return new ResponseEntity<String>("Item: " + item + " added successfully", HttpStatus.OK);
        }
    }

    // Deletes an Item
    @Override
    public ResponseEntity<String> deleteItem(int itemId) {
        ResponseEntity responseEntity;
        if(itemExists(itemId)) {
            itemDAO.deleteById(itemId);
            return new ResponseEntity<String>("Item deleted successfully", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<String> ("Item does not exist, delete unsuccessful", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    // Get all items
    public List<Item> getItems() {
        return itemDAO.findAll();
    }

    //Increases stock of item
    public Item addStock(Item item) {
        if(itemExists(item.getItemId())) {
            itemDAO.save(item);
            return item;
        }
        else {
            System.out.println("Item does not exist");
            return null;
        }
    }
}
