/**
 * Service ---> ServiceImpl
 */

package com.project1aws.training.revature.services;

import com.project1aws.training.revature.dao.UserDAO;
import com.project1aws.training.revature.exceptions.UserNotFoundException;
import com.project1aws.training.revature.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private HttpServletRequest req;
    @Autowired
    private UserDAO userDAO;

    public boolean userExists(int userId) {
        LOGGER.info("Checking if user exists started");
        if(userDAO.existsById(userId)) {
            LOGGER.info("User: " + userId + " does exist");
        }
        else {
            LOGGER.warn("User: " + userId + " does not exist");
        }
        return userDAO.existsById(userId);
    }

    public User login(String username, String password) {
        User exists = userDAO.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(String.format("No User with username = %s", username)));
        HttpSession session = req.getSession();
        session.setAttribute("currentUser", exists);
        return exists;
    }

    public void logout() {
        HttpSession session = req.getSession(false);
        if(session == null) {
            // No one was logged in
            return;
        }
        session.invalidate();
    }

    // 1.Register new users
    public ResponseEntity<String> registerUser(User user) {
        LOGGER.info("Registering user started execution");
        ResponseEntity responseEntity;
        if(userExists(user.getUserId())) {
            LOGGER.warn("User: " + user.getUserId() + " already exists");
            return new ResponseEntity<String>("Can't register user because they're already registered", HttpStatus.CONFLICT);
        }
        else {
            userDAO.save(user);
            LOGGER.info("User: " + user.getUserId() + " saved successfully");
            return new ResponseEntity<String>("Registered user: " + user + " successfully", HttpStatus.OK);
        }
    }

    public ResponseEntity<String> addItemToCart(User updatedUser, int id) {
        LOGGER.info("Adding item(s) to cart started execution");
        ResponseEntity responseEntity;
        User currentUser = userDAO.getReferenceById(id);
        if(userExists(currentUser.getUserId())) {
            currentUser.setUsername(updatedUser.getUsername());
            currentUser.setCart(updatedUser.getCart());
            userDAO.save(currentUser);
            LOGGER.info("Item(s) added to cart successfully");
            return new ResponseEntity<String>("Item(s) added to cart successfully", HttpStatus.OK);
        }
        else {
            LOGGER.warn("User: " + currentUser.getUserId() + " does not exist");
            return new ResponseEntity<String>("User: " + currentUser.getUserId() + " does not exist", HttpStatus.NOT_FOUND);
        }
    }

    // Delete user
    public ResponseEntity<String> deleteUser(int userId) {
        LOGGER.info("Delete user started execution");
        ResponseEntity responseEntity;
        if(userExists(userId)) {
            userDAO.deleteById(userId);
            LOGGER.info("User: " + userId + " deleted successfully");
            return new ResponseEntity<String>("User: " + userId + " deleted successfully", HttpStatus.OK);
        }
        else {
            LOGGER.warn("User: " + userId + " does not exist, delete unsuccessful");
            return new ResponseEntity<String> ("User: " + userId + " does not exist, delete unsuccessful", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    public List<User> getUsers() {
        return userDAO.findAll();
    }

    public List<User> findAll() {
        return userDAO.findAll();
    }

    public User findById(int id) {
        return userDAO.findById(id)
                .orElseThrow(() -> new UserNotFoundException(String.format("No user with id = %d", id)));
    }

    public User insert(User u) {
        if(u.getUserId() != 0) {
            // This should be a custom exception class instead
            throw new RuntimeException("User ID must be zero to create a new User");
        }
        userDAO.save(u); // Modify the user with the new ID
        return u;
    }

    public User update(User u) {
        if(!userDAO.existsById(u.getUserId())) {
            throw new RuntimeException("User must already exist to update");
        }
        userDAO.save(u);
        HttpSession session = req.getSession(false); // They must have already been logged in, because we had our guard method
        User sessionUser = (User) session.getAttribute("currentUser");

        // If a User updated themselves, update the information in the session
        if(sessionUser.getUserId() == u.getUserId()) {
            session.setAttribute("currentUser", u);
        }
        return u;
    }

    public boolean delete(int id) {
        if(!userDAO.existsById(id)) {
            return false;
        }
        userDAO.deleteById(id);
        return true;
    }
}