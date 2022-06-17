package com.project1.training.revature.dao;

import com.project1.training.revature.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDAO extends JpaRepository<Item, Integer> {
}
