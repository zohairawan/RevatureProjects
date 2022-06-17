package com.project1.training.revature.dao;

import com.project1.training.revature.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserDAO extends JpaRepository<User, Integer> {
    public Optional<User> findByUsername(String username);
}
