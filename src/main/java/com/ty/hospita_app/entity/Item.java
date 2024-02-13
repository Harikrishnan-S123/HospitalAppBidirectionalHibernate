package com.ty.hospita_app.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "item_id_gen")
	@SequenceGenerator(name = "item_id_gen",initialValue = 10,sequenceName = "item_seq")
	private int itemId;
	private String name;
	private double price;
	private String dosage;
	private String noofDays;
	private String expiryDate;
	@ManyToMany(mappedBy = "items")
	private List<MedOrders> medOrders;
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDosage() {
		return dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	public String getNoofDays() {
		return noofDays;
	}
	public void setNoofDays(String noofDays) {
		this.noofDays = noofDays;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public Item(String name, double price, String dosage, String noofDays, String expiryDate) {
		super();
		this.name = name;
		this.price = price;
		this.dosage = dosage;
		this.noofDays = noofDays;
		this.expiryDate = expiryDate;
	}
	public Item() {}
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", name=" + name + ", price=" + price + ", dosage=" + dosage + ", noofDays="
				+ noofDays + ", expiryDate=" + expiryDate + "]";
	}
	public List<MedOrders> getMedOrders() {
		return medOrders;
	}
	
	

}
