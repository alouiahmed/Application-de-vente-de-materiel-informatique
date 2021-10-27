package com.services.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.services.userservice.entity.User;
import com.services.userservice.entity.UserDetails;
import com.services.userservice.entity.UserRole;
import com.services.userservice.repository.UserDetailsRepository;
import com.services.userservice.repository.UserRepository;
import com.services.userservice.repository.UserRoleRepository;


@SpringBootApplication
@EnableJpaRepositories
@EnableEurekaClient

public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
	
	
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	@Autowired
	private UserDetailsRepository userDetailsRepository;
	
	
	@Autowired
	private UserRepository userRepository;
	
	
	
	
	
	
	  @Bean ApplicationRunner init() {
	  
	  
	  
	  UserRole admin=new UserRole("Admin"); UserRole client=new UserRole("Client");
	  
	  
	  
	  
	  UserDetails userDetails1 =new UserDetails("Aloui1","Ahmed1","Ahmed1@gmail.com","987654321", "Test1Street",
	  "11","7777","tunis","tunis",null);
	  
	  UserDetails userDetails2 =new UserDetails("Aloui","Ahmed","Ahmed@gmail.com","123456789", "TestStreet",
			  "10","8888","Ariana","tunis",null);
	  
	  UserDetails userDetails3 =new UserDetails("Ghazouani","Zaineb","Zaineb@gmail.com","1122334455", "Street",
			  "12","9999","Sfax","tunis",null);
	  
	  
	  User user1=new User("Ahmed321","test",1,null,client);
	  
	  user1.setUserDetails(userDetails1);
	  
      User user2=new User("Ahmed21","test",1,null,admin);
	  
	  user2.setUserDetails(userDetails2);
	  
	  User user3=new User("Zaineb","test",1,null,client);
	  
	  user3.setUserDetails(userDetails3);
	  
	  
	  return (args) -> {
	  
	  
	  userRoleRepository.save(admin); userRoleRepository.save(client);
	  
	  userRepository.save(user1); userDetailsRepository.save(userDetails1);
	  userRepository.save(user2); userDetailsRepository.save(userDetails2);
	  userRepository.save(user3); userDetailsRepository.save(userDetails3);
	  
	  
	  
	  
	  };
	  
	  
	  
	  }
	 
	 
}
