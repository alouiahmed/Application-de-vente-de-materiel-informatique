package tn.microservices.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.microservices.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	 public List<Product> findAllByCategory(String category);
	    public List<Product> findAllByProductName(String name);
}
