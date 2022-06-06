/**
 * Controller class is meant accept HTTP methods like: Get, Post, Put, Delete
 * We will use Postman app to send HTTP methods(Get,Post,Put,Delete) and those requests will be mapped to methods inside this class
 * Controller is the API layer
 * Postman ---> Controller
 */

package com.project1aws.training.revature.controller;

import com.project1aws.training.revature.annotations.Authorized;
import com.project1aws.training.revature.model.Item;
import com.project1aws.training.revature.model.Role;
import com.project1aws.training.revature.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    // Adds an item
    // http://localhost:8090/items/addItem
    @Authorized(allowedRoles = {Role.ADMIN})
    @PostMapping("/addItem")
    public ResponseEntity<String> addItem(@RequestBody Item item) {
        return itemService.addItem(item);
    }

    // Delete existing item
    // http://localhost:8090/items/deleteItem
    @Authorized(allowedRoles = {Role.ADMIN})
    @DeleteMapping("/deleteItem/{itemId}")
    public ResponseEntity<String> deleteItem(@PathVariable("itemId") int itemId) {
        return itemService.deleteItem(itemId);
    }

    // 4.Get all items
    // http://localhost:8090/items/getItems
    @Authorized(allowedRoles = {Role.ADMIN, Role.CUSTOMER})
    @GetMapping("/getItems")
    public List<Item> getItems() {
        return itemService.getItems();
    }

    // http://localhost:8090/items/addStock
    @Authorized(allowedRoles = {Role.ADMIN})
    @PostMapping("/addStock")
    public ResponseEntity<String> addStock(@RequestBody Item item) {
        return itemService.addStock(item);
    }
}
