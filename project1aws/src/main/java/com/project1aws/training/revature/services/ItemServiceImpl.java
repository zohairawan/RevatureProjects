/**
 * Service ---> ServiceImpl
 */

package com.project1aws.training.revature.services;

import com.project1aws.training.revature.dao.ItemDAO;
import com.project1aws.training.revature.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemServiceImpl.class);
    @Autowired
    ItemDAO itemDAO;

    @Override
    public boolean itemExists(int itemId) {
        LOGGER.info("Checking if item exists started execution");
        if(itemDAO.existsById(itemId)) {
            LOGGER.info("Item: " + itemId + " does exist");
        }
        else {
            LOGGER.warn("Item: " + itemId + " does not exist");
        }
        return itemDAO.existsById(itemId);
    }

    // Adds an item
    public ResponseEntity<String> addItem(Item item) {
        LOGGER.info("Adding item started execution");
        ResponseEntity responseEntity;
        if(itemExists(item.getItemId())) {
            LOGGER.warn("Item: " + item.getItemId() + " already exists");
            return new ResponseEntity<String>("Cannot add item, already exists. You can increase item stock however", HttpStatus.CONFLICT);
        }
        else {
            itemDAO.save(item);
            LOGGER.info("Item: " + item.getItemId() + " added successfully");
            return new ResponseEntity<String>("Item: " + item + " added successfully", HttpStatus.OK);
        }
    }

    // Deletes an Item
    @Override
    public ResponseEntity<String> deleteItem(int itemId) {
        LOGGER.info("Deleting item started execution");
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
        LOGGER.trace("TRACE - Get item started execution");
        LOGGER.debug("DEBUG - Get item started execution");
        LOGGER.info("INFO - Get item started execution");
        LOGGER.warn("WARN - Get item started execution");
        LOGGER.error("ERROR - Get item started execution");
        return itemDAO.findAll();
    }

    //Increases stock of item
    public ResponseEntity<String> addStock(Item item) {
        LOGGER.info("Adding item stock started execution");
        ResponseEntity responseEntity;
        if(itemExists(item.getItemId())) {
            itemDAO.save(item);
            LOGGER.info("Item " + item.getItemId() + " stock added successfully");
            return new ResponseEntity<String>("Item: " + item.getItemId() + " stock added successfully", HttpStatus.OK);
        }
        else {
            LOGGER.warn("Item " + item.getItemId() + " does not exist");
            return new ResponseEntity<String>("Item: " + item.getItemId() + " does not exist", HttpStatus.NOT_FOUND);
        }
    }
}
