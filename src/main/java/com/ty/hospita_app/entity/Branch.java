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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "branch_id_gen")
	@SequenceGenerator(name = "branch_id_gen",initialValue = 10,sequenceName = "branch_seq")
	private int branchId;
	private String branchName;
	private String branchHeadName;
	private int yearOfStart;
	private int noOfDevices;
	@ManyToOne
	@JoinColumn(name="hospital_id")
	private Hospital hospital;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;
	@OneToMany(cascade =CascadeType.ALL ,mappedBy = "branch")
	private List<Encounter> encounters;
	
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBranchHeadName() {
		return branchHeadName;
	}
	public void setBranchHeadName(String branchHeadName) {
		this.branchHeadName = branchHeadName;
	}
	public int getYearOfStart() {
		return yearOfStart;
	}
	public void setYearOfStart(int yearOfStart) {
		this.yearOfStart = yearOfStart;
	}
	public int getNoOfDevices() {
		return noOfDevices;
	}
	public void setNoOfDevices(int noOfDevices) {
		this.noOfDevices = noOfDevices;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Encounter> getEncounters() {
		return encounters;
	}
	public void setEncounters(List<Encounter> encounters) {
		this.encounters = encounters;
	}
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	
	
}
