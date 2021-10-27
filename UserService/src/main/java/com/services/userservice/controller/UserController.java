package com.services.userservice.controller;


import com.services.userservice.entity.User;
import com.services.userservice.http.header.HeaderGenerator;
import com.services.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private HeaderGenerator headerGenerator;
    
    private String title="Hello, I'm the user Microservice";
    
    @RequestMapping("/hello")
    public String sayHello() {
    	System.out.println(title);
    	return title;
    }
    
    @GetMapping (value = "/users")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users =  userService.getAllUsers();
        if(!users.isEmpty()) {
        	return new ResponseEntity<List<User>>(
        		users,
        		headerGenerator.getHeadersForSuccessGetMethod(),
        		HttpStatus.OK);
        }
        return new ResponseEntity<List<User>>(
        		headerGenerator.getHeadersForError(),
        		HttpStatus.NOT_FOUND);
    }

    @GetMapping (value = "/users", params = "name")
    public ResponseEntity<User> getUserByName(@RequestParam("name") String userName){
    	User user = userService.getUserByName(userName);
    	if(user != null) {
    		return new ResponseEntity<User>(
    				user,
    				headerGenerator.
    				getHeadersForSuccessGetMethod(),
    				HttpStatus.OK);
    	}
        return new ResponseEntity<User>(
        		headerGenerator.getHeadersForError(),
        		HttpStatus.NOT_FOUND);
    }

    @GetMapping (value = "/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        User user = userService.getUserById(id);
        if(user != null) {
    		return new ResponseEntity<User>(
    				user,
    				headerGenerator.
    				getHeadersForSuccessGetMethod(),
    				HttpStatus.OK);
    	}
        return new ResponseEntity<User>(
        		headerGenerator.getHeadersForError(),
        		HttpStatus.NOT_FOUND);
    }

    @PostMapping (value = "/users")
    public ResponseEntity<User> addUser(@RequestBody User user, HttpServletRequest request){
    	if(user != null)
    		try {
    			userService.saveUser(user);
    			return new ResponseEntity<User>(
    					user,
    					headerGenerator.getHeadersForSuccessPostMethod(request, user.getId()),
    					HttpStatus.CREATED);
    		}catch (Exception e) {
    			e.printStackTrace();
    			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    	return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
    }
    @PutMapping(value="/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public  ResponseEntity<User> updateUser(@PathVariable("id") Long id,
    		@RequestBody User user ){
    	return new ResponseEntity<> (userService.updateUser(id, user), HttpStatus.OK);
    }
    
	@DeleteMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public  ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
    		
    	return new ResponseEntity<> (userService.deleteUser(id), HttpStatus.OK);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
