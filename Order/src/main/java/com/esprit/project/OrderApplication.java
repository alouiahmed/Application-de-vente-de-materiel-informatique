package com.esprit.project;





import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableEurekaClient

public class OrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}
	@Autowired
	private OrderRepository repository;
	@Bean
	ApplicationRunner init() {
		return (args) -> {
	
			repository.save(new Order("encours", "beb", 500, 60, "aymen", "Tunis", 53059655,new Date()));
			repository.save(new Order("encours", "loha", 500, 60, "aymen", "Tunis", 53059655,new Date()));
			repository.save(new Order("encours", "dd", 500, 60, "aymen", "Tunis", 53059655,new Date()));
			repository.findAll().forEach(System.out::println);
		};
	}

}
