package com.project1aws.training.revature.dao;

import com.project1aws.training.revature.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDAO extends JpaRepository<Cart, Integer> {
}
