package tn.microservices.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tn.microservices.product.entity.Product;
import tn.microservices.product.service.ProductService;

@RestController
public class ProductRestController {
	@Autowired
	private ProductService productService;

	@GetMapping(value = "/products")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> products = productService.getAllProduct();
		if (!products.isEmpty()) {
			return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		}
		return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
	}

	@PostMapping(value = "/products")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		return new ResponseEntity<>(productService.addProduct(product), HttpStatus.OK);
	}

	@DeleteMapping(value = "/products/{id}")
	private ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
		Product product = productService.getProductById(id);
		if (product != null) {
			try {
				productService.deleteProduct(id);
				return new ResponseEntity<Void>(HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	@PutMapping(value = "/products/{id}")
	@ResponseStatus(HttpStatus.OK)
	private ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
		return new ResponseEntity<>(productService.updateProduct(id, product), HttpStatus.OK);
	}

	@GetMapping(value = "/products", params = "category")
	public ResponseEntity<List<Product>> getAllProductByCategory(@RequestParam("category") String category) {
		List<Product> products = productService.getAllProductByCategory(category);
		if (!products.isEmpty()) {
			return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		}
		return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/products/{id}")
	public ResponseEntity<Product> getOneProductById(@PathVariable("id") long id) {
		Product product = productService.getProductById(id);
		if (product != null) {
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		}
		return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/products", params = "name")
	public ResponseEntity<List<Product>> getAllProductsByName(@RequestParam("name") String name) {
		List<Product> products = productService.getAllProductsByName(name);
		if (!products.isEmpty()) {
			return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		}
		return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
			}
}
