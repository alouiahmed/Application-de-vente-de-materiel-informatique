package com.esprit.project;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "order_table")
public class Order  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int id;
	
   
	   @Column(name="status") 
    private String status;

private String item;
@Column (name = "prix_order")
private int prix;
@Column (name = "quantite_order")
private int quantite;

public int getPrix() {
	return prix;
}
public void setPrix(int prix) {
	this.prix = prix;
}
public int getQuantite() {
	return quantite;
}
public void setQuantite(int quantite) {
	this.quantite = quantite;
}
@Column (name = "user_name")
    private String username;
@Column (name = "user_adress")
    private String adress;
    @Column (name = "user_tel")
    private int Telephone;
    @Column (name = "ordered_date")
    private Date orderedDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getOrderedDate() {
		return orderedDate;
	}
	public void setOrderedDate(Date orderedDate) {
		this.orderedDate = orderedDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public int getTelephone() {
		return Telephone;
	}
	public void setTelephone(int telephone) {
		Telephone = telephone;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String status, String item, int prix, int quantite, String username, String adress, int telephone,
			Date orderedDate) {
		super();
		this.status = status;
		this.item = item;
		this.prix = prix;
		this.quantite = quantite;
		this.username = username;
		this.adress = adress;
		Telephone = telephone;
		this.orderedDate = orderedDate;
	}

    
}
