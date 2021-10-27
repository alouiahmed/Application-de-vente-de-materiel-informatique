package tn.microservices.product.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product implements Serializable {
	private static final long serialVersionUID = 6;

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "productName")
	private String productName;

	@Column(name = "price")
	private float price;

	@Column(name = "description")
	private String description;

	@Column(name = "category")
	private String category;

	@Column(name = "availability")
	private int availability;

	public Product() {

	}
	

	public Product(String productName) {
		super();
		this.productName = productName;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String discription) {
		this.description = discription;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}
	public Product(String productName, float price, String description, String category, int availability) {
		super();
		this.productName = productName;
		this.price = price;
		this.description = description;
		this.category = category;
		this.availability = availability;
	}
}
