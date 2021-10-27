package tn.microservices.product;


import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import tn.microservices.product.entity.Product;
import tn.microservices.product.repository.ProductRepository;



@SpringBootApplication
@EnableJpaRepositories
@EnableEurekaClient
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}
	
	@Bean
	ApplicationRunner init(ProductRepository repo) {
		return args -> {
			repo.save(new Product("huawei",600,"smartphone huawei nova 3i","smartphone",5));
			repo.save(new Product("iphone",2300,"smartphone iphone","smartphone",10));
			repo.save(new Product("pc dell",5000,"pc dell ","pc",2));
			repo.save(new Product("tv lg",600,"television lg smart hd","tv",11));

			repo.findAll().forEach(System.out::println);
		};
	}

}
