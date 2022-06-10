package com.project2aws.training.revature.dao;

import com.project2aws.training.revature.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDAO extends JpaRepository<Item, Integer> {
}
