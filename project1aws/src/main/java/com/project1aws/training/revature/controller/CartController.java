package com.project1aws.training.revature.controller;

import com.project1aws.training.revature.annotations.Authorized;
import com.project1aws.training.revature.model.Cart;
import com.project1aws.training.revature.model.Role;
import com.project1aws.training.revature.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("carts")
public class CartController {
    @Autowired
    CartService cartService;

    // Get all carts
    // http://localhost:8089/carts/getCarts
    @Authorized(allowedRoles = {Role.ADMIN, Role.CUSTOMER})
    @GetMapping("/getCarts")
    public List<Cart> getCarts(){return cartService.getCarts();}
}
