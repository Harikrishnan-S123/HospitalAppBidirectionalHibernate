package com.ty.hospita_app.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
@Entity
public class MedOrders {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "med_id_gen")
	@SequenceGenerator(name = "med_id_gen",initialValue = 500,sequenceName = "med_seq")
	private int medOrderId;
	private int noofMedicines;
	private String invoiceNumber;
	
	private String orderDate;
	private String paymentMode;
	@ManyToOne
	@JoinColumn(name="encounter_id")
	private Encounter encounter;
	@ManyToMany
	@JoinTable(joinColumns  = @JoinColumn(name="medorder_id"),inverseJoinColumns = @JoinColumn(name="item_id"))
	private List<Item> items;
	public int getMedOrderId() {
		return medOrderId;
	}
	public void setMedOrderId(int medOrderId) {
		this.medOrderId = medOrderId;
	}
	public int getNoofMedicines() {
		return noofMedicines;
	}
	public void setNoofMedicines(int noofMedicines) {
		this.noofMedicines = noofMedicines;
	}
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	public Encounter getEncounter() {
		return encounter;
	}
	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}
	
	public MedOrders(int noofMedicines, String invoiceNumber, String orderDate, String paymentMode,
			List<Item> items) {
		super();
		this.noofMedicines = noofMedicines;
		this.invoiceNumber = invoiceNumber;
		this.orderDate = orderDate;
		this.paymentMode = paymentMode;
		this.items = items;
	}
	public MedOrders() {}

}
