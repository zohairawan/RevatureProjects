/**
 * Controller ---> Service
 */

package com.project1.training.revature.services;

import com.project1.training.revature.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    User login(String username, String password);
    void logout();
    public boolean userExists(int userId);
    public ResponseEntity<String> registerUser(User user);
    public ResponseEntity<String> addItemToCart(User newUser, int id);
    public ResponseEntity<String> deleteUser(int userId);
    public List<User> getUsers();

    List<User> findAll();
    User findById(int id);
    User insert(User u);
    User update(User u);
    boolean delete(int id);
}
