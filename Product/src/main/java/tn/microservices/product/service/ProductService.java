package tn.microservices.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.microservices.product.entity.Product;
import tn.microservices.product.repository.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
    private ProductRepository productRepository;

    
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public List<Product> getAllProductByCategory(String category) {
        return productRepository.findAllByCategory(category);
    }

    
    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    
    public List<Product> getAllProductsByName(String name) {
        return productRepository.findAllByProductName(name);
    }

    
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
    
    public Product updateProduct(Long productId, Product product) {
        if (productRepository.findById(productId).isPresent()) {
        	Product existingProduct = productRepository.findById(productId).get();
        	existingProduct.setProductName(product.getProductName());
        	existingProduct.setDescription(product.getDescription());
        	existingProduct.setPrice(product.getPrice());
        	existingProduct.setCategory(product.getCategory());
        	existingProduct.setAvailability(product.getAvailability());
        	
        	return productRepository.save(existingProduct);	
        }else {
        	return null;
        }
    }
    
    

}
