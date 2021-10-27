package tn.product.recommandation;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import tn.product.recommandation.entity.Recommandation;
import tn.product.recommandation.repository.RecommandationRepository;

@SpringBootApplication
@EnableEurekaClient
@EnableJpaRepositories
public class ProductRecommandationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductRecommandationApplication.class, args);
	}
	
	@Bean
    ApplicationRunner init(RecommandationRepository recom){
		return (args) -> {
			recom.save(new Recommandation (1,5,1,1));
			recom.save(new Recommandation (2,4,2,1));
			recom.save(new Recommandation (3,3,2,2));
			recom.findAll().forEach(System.out::println);
			
		};

	}
}