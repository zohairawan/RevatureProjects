/**
 * Controller class is meant accept HTTP methods like: Get, Post, Put, Delete
 * We will use Postman app to send HTTP methods(Get,Post,Put,Delete) and those requests will be mapped to methods inside this class
 * Controller is the API layer
 * Postman ---> Controller
 */

package com.project1aws.training.revature.controller;

import com.project1aws.training.revature.annotations.Authorized;
import com.project1aws.training.revature.model.LoginTemplate;
import com.project1aws.training.revature.model.Role;
import com.project1aws.training.revature.model.User;
import com.project1aws.training.revature.services.AuthorizationService;
import com.project1aws.training.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthorizationService authorizationService;

    // 1.Register new users
    // localhost:8090/users/registerUser
    @Authorized(allowedRoles = {Role.ADMIN})
    @PostMapping("/registerUser")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    // 2. Login users
    // localhost:8090/users/login
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginTemplate loginTemplate) {
        return ResponseEntity.ok(userService.login(loginTemplate.getUsername(), loginTemplate.getPassword()));
    }

    // 2. Logout users
    // localhost:8090/users/logout
    @PostMapping("/logout")
    public ResponseEntity<Void> logout() {
        userService.logout();
        return ResponseEntity.accepted().build();
    }

    // 3.Get all users
    // localhost:8090/users/getUsers
    @Authorized(allowedRoles = {Role.ADMIN})
    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    // Add item(s) to cart
    // localhost:8090/users/addItemToCart/
    @PutMapping("/addItemToCart/{id}")
    public ResponseEntity<String> addItemToCart(@RequestBody User newUser, @PathVariable("id") int id) {
        return userService.addItemToCart(newUser, id);
    }

    // Delete existing user
    // localhost:8090/users/deleteUser
    @Authorized(allowedRoles = {Role.ADMIN})
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") int userId) {return userService.deleteUser(userId);}

//    @Authorized(allowedRoles = {Role.ADMIN})
//    @GetMapping
//    public ResponseEntity<List<User>> findAll() {
//
//        return ResponseEntity.ok(userService.findAll());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<User> findById(@PathVariable("id") int id) {
//        authorizationService.guardByUserId(id);
//
//        return ResponseEntity.ok(userService.findById(id));
//    }
//
//    @PostMapping
//    public ResponseEntity<User> insert(@RequestBody User u) {
//
//        return ResponseEntity.accepted().body(userService.insert(u));
//    }
//
//
//    @PutMapping
//    @Authorized(allowedRoles = {Role.ADMIN, Role.CUSTOMER})
//    public ResponseEntity<User> update(@RequestBody User u) {
//        authorizationService.guardByUserId(u.getUserId());
//        // We will also check if this resource belongs to the User, even if they pass the @Authorized annotation
//
//        return ResponseEntity.accepted().body(userService.update(u));
//    }
//
//    // localhost:8089/users/tufail/deleteUser/
//    @Authorized(allowedRoles = {Role.ADMIN})
//    @DeleteMapping("/tufail/deleteUser/{id}")
//    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
//        if(userService.delete(id)) {
//            return ResponseEntity.accepted().build();
//        }
//
//        return ResponseEntity.noContent().build();
//    }
}
