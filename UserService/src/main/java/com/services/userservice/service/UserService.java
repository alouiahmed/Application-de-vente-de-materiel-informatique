package com.services.userservice.service;

import java.util.List;
import com.services.userservice.entity.User;


public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User getUserByName(String userName);
    User saveUser(User user);
	User updateUser(Long id, User newUser);
	String deleteUser(Long id);
}
