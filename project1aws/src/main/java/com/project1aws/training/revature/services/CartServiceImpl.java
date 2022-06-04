package com.project1aws.training.revature.services;

import com.project1aws.training.revature.dao.CartDAO;
import com.project1aws.training.revature.model.Cart;
import com.project1aws.training.revature.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    CartDAO cartDAO;

    // Get all carts
    public List<Cart> getCarts() {
        return cartDAO.findAll();
    }
    //additemtocart setting cart to user
    //createCart(can do in user)
}
