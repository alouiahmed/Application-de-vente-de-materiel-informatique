package com.services.userservice.service;

import com.services.userservice.entity.User;
import com.services.userservice.entity.UserRole;
import com.services.userservice.entity.UserDetails;
import com.services.userservice.repository.UserDetailsRepository;
import com.services.userservice.repository.UserRepository;
import com.services.userservice.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;
    
    @Autowired
	private UserDetailsRepository userDetailsRepository;
	

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    
    @Override
    public User getUserById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public User getUserByName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public User saveUser(User user) {
        user.setActive(1);
        //UserRole role = userRoleRepository.findUserRoleByRoleName("ROLE_USER");
        //user.setRole(role);
        return userRepository.save(user);
    }
    
    @Override
    public User updateUser(Long id, User newUser) {
    	if (userRepository.findById(id).isPresent()) {
    		User existingUser = userRepository.findById(id).get();
    		existingUser.setUserName(newUser.getUserName());
    		existingUser.setUserPassword(newUser.getUserPassword());
    		existingUser.setActive(newUser.getActive());
    		newUser.getUserDetails().setFirstName(newUser.getUserDetails().getFirstName());
    		newUser.getUserDetails().setLastName(newUser.getUserDetails().getLastName());
    		newUser.getUserDetails().setEmail(newUser.getUserDetails().getEmail());
    		newUser.getUserDetails().setPhoneNumber(newUser.getUserDetails().getPhoneNumber());
    		newUser.getUserDetails().setStreet(newUser.getUserDetails().getStreet());
    		newUser.getUserDetails().setStreetNumber(newUser.getUserDetails().getStreetNumber());
    		newUser.getUserDetails().setZipCode(newUser.getUserDetails().getZipCode());
    		newUser.getUserDetails().setLocality(newUser.getUserDetails().getLocality());
    		newUser.getUserDetails().setCountry(newUser.getUserDetails().getCountry());
    		existingUser.setUserDetails(newUser.getUserDetails());
    		newUser.getRole().setRoleName(newUser.getRole().getRoleName());
    		existingUser.setRole(newUser.getRole());
    		
    		return userRepository.save(existingUser);
    	} else
    		return null;
    		
    		
    	}
    
    @Override
    public String deleteUser(Long id) {
    	if (userRepository.findById(id).isPresent()) {
    		userRepository.deleteById(id);
    		return "user deleted";
    	} else
    		return "user not deleted";
    	}
    
    
}

