package tn.product.recommandation.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Recommandation implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private int rating;
	
	private int userRecom;
	
	private int productRecom;

	public Recommandation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Recommandation(long id, int rating, int userRecom, int productRecom) {
		super();
		this.id = id;
		this.rating = rating;
		this.userRecom = userRecom;
		this.productRecom = productRecom;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getUserRecom() {
		return userRecom;
	}

	public void setUserRecom(int userRecom) {
		this.userRecom = userRecom;
	}

	public int getProductRecom() {
		return productRecom;
	}

	public void setProductRecom(int productRecom) {
		this.productRecom = productRecom;
	}
	
	
}
