package com.ty.hospita_app.duo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hospita_app.entity.Address;
import com.ty.hospita_app.entity.Branch;
import com.ty.hospita_app.entity.Hospital;

public class BranchDuo {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	Scanner scanner=new Scanner(System.in);
	HosiptalDuo duo=new HosiptalDuo();
	public Branch saveBranch(Branch branch,int hospitalId) {
		
		Hospital hospital=duo.findHopsital(hospitalId);
		if(hospital!=null) {
			System.out.println("Enter branch name");
			String branchName=scanner.next();
			branch.setBranchName(branchName);
			System.out.println("Enter branch head name");
			String branchHeadName=scanner.next();
			branch.setBranchHeadName(branchHeadName);
			System.out.println("Enter branch start year");
			int startYear=scanner.nextInt();
			branch.setYearOfStart(startYear);
			System.out.println("Enter number of devices in your branch");
			int noOfDevices=scanner.nextInt();
			branch.setNoOfDevices(noOfDevices);
			Address address=AddressDuo.getAddressofBranch(new Address());
			branch.setAddress(address);
			branch.setHospital(hospital);
			entityTransaction.begin();
			entityManager.persist(branch);
			entityTransaction.commit();
			System.out.println("Branch saved successfully");
		}
		else {
			System.out.println("Please add a hospital first");
		}


		return branch;

	}
	public Branch findBranch(int branchId) {
		return entityManager.find(Branch.class, branchId);
	}
	public Branch updateBranch(int branchId) {
		Branch branch=findBranch(branchId);
//		int addressId
		if(branch!=null) {
			Address address=branch.getAddress();
			Address addressNew=AddressDuo.getAddress(new Address());
			branch.setAddress(addressNew);
			entityTransaction.begin();
			entityManager.merge(branch);
			entityManager.remove(address);
			entityTransaction.commit();
		}
		else {
			System.out.println("given branch does not exist");
		}
		return branch;
	}
	public boolean removeBranch(int branchId) {
		boolean flag=false;
		Branch branch=findBranch(branchId);
		if(branch!=null) {
			entityTransaction.begin();
			entityManager.remove(branch);
			entityTransaction.commit();
			flag=true;
		}
		else {
			System.out.println("given branch does not exist");
		}
		return flag;
	}
	
	
	public Branch updateBranchDetails(Branch branch,int branchId) {
		boolean flag=true;
	    branch=findBranch(branchId);
	    if(branch!=null) {
	    	while(flag) {
	    		System.out.println("1.Update Head name\n2.Update Location\n3.Go back");
	    		switch(scanner.nextInt()) {
	    		case 1:
	    		{
	    			System.out.println("Enter new head name");
	    			String headName=scanner.next();
	    			branch.setBranchHeadName(headName);
	    			entityTransaction.begin();
	    			entityManager.merge(branch);
	    			entityTransaction.commit();
	    		}
	    		break;
	    		case 2:
	    		{
	    			Address address=branch.getAddress();
	    			AddressDuo.getAddressofBranch(address);
	    			branch.setAddress(address);
	    			entityTransaction.begin();
	    			entityManager.merge(branch);
	    			//entityManager.remove(address);
	    			entityTransaction.commit();
	    		}
	    		break;
	    		case 3:
	    		{
	    			flag=false;
	    		}
	    		break;
	    		default:System.out.println("Invalid choice");
	    			
	    		}
	    		
	    		
	    		
	    		}
	    }
		return branch;
		
		
	}
	


}
