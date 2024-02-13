package com.ty.hospita_app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Encounter {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "encounter_id_gen")
	@SequenceGenerator(name = "encounter_id_gen",initialValue = 250,sequenceName = "encounter_seq")
	private int encounterId;
	private String admissionDate;
	private String vistedDoctor;
	private String diseaseName;
	private int noOfTest;
	@ManyToOne
	@JoinColumn(name="branch_id")
	private Branch branch;
	@ManyToOne
	@JoinColumn(name="person_id")
	private Person person;
	@OneToMany(mappedBy = "encounter",cascade = CascadeType.ALL)
	private List<MedOrders> medOrders;

	public int getEncounterId() {
		return encounterId;
	}
	public void setEncounterId(int encounterId) {
		this.encounterId = encounterId;
	}
	public String getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(String admissionDate) {
		this.admissionDate = admissionDate;
	}
	public String getVistedDoctor() {
		return vistedDoctor;
	}
	public void setVistedDoctor(String vistedDoctor) {
		this.vistedDoctor = vistedDoctor;
	}
	public String getDiseaseName() {
		return diseaseName;
	}
	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}
	public int getNoOfTest() {
		return noOfTest;
	}
	public void setNoOfTest(int noOfTest) {
		this.noOfTest = noOfTest;
	}
	public List<MedOrders> getMedOrders() {
		return medOrders;
	}
	public void setMedOrders(List<MedOrders> medOrders) {
		this.medOrders = medOrders;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	



}
