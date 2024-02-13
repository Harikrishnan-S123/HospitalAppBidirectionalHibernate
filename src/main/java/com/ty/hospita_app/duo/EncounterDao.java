package com.ty.hospita_app.duo;

import java.util.ArrayList;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hospita_app.entity.Branch;
import com.ty.hospita_app.entity.Encounter;
import com.ty.hospita_app.entity.MedOrders;
import com.ty.hospita_app.entity.Person;
import com.ty.hospita_app.helper.Helper;

public class EncounterDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	//BranchDuo branchDuo=new BranchDuo();
	Scanner scanner=new Scanner(System.in);
	public  Encounter saveEncounter(Encounter encounter,int branchId,int personId) {
		Branch branch=entityManager.find(Branch.class, branchId);
		Person person=entityManager.find(Person.class, personId);
		if(branch!=null && person!=null) {
		System.out.println("Enter Admission date");
		String admsissionDate=scanner.next();
		encounter.setAdmissionDate(admsissionDate);
		System.out.println("Enter visited doctor name");
		String doctorName=scanner.next();
		encounter.setVistedDoctor(doctorName);
		System.out.println("Enter disease name");
		String diseaseName=scanner.next();
		encounter.setDiseaseName(diseaseName);
		System.out.println("Enter number of tests conducted");
		int noOfTests=scanner.nextInt();
		encounter.setNoOfTest(noOfTests);
		encounter.setPerson(person);
		encounter.setBranch(branch);
		entityTransaction.begin();
		entityManager.persist(encounter);
		entityTransaction.commit();
		encounter.setMedOrders(new ArrayList<MedOrders>());
		Helper.forEach(encounter);
		}
		else if(person!=null && branch==null) {
			System.out.println("Invalid Branch id");
		}
		else if(person==null && branch!=null) {
			System.out.println("New user?");
			System.out.println("1.Add person\nAnything else to go back");
			if((scanner.nextInt()==1)) {
				person=(new PersonDao()).savePerson(person);
				System.out.println("Person saved with id" +person.getPersonId());
				System.out.println("Now press 1 if you want to save");
			}
			else {
				return encounter;
			}

		}
		
		else {
			System.out.println("Invalid insertion");
		}
		return encounter;
		
	}
	
	
	public boolean removeEncounter(Encounter encounter,int encounterId) {
		boolean flag=false;
		encounter=findEncounter(encounterId);
		if(encounter!=null) {
			entityTransaction.begin();
			entityManager.remove(encounter);
			entityTransaction.commit();
			flag=true;
			System.out.println("Encounter with id"+encounterId+" removed");
			
		}
		return flag;
		
	}
	public Encounter findEncounter(int id) {
		return entityManager.find(Encounter.class,id);
	}
	public Encounter updateEncounter(Encounter encounter,int encounterId) {
		encounter=findEncounter(encounterId);
		boolean flag=true;
		if(encounter!=null) {
			while(flag) {
			System.out.println("1.Update no of tests\n2.Update diseasename\n3.Update visiteddoctorname\n4.going back");
			switch(scanner.nextInt()) {
			case 1:{
				System.out.println("Eter no of tests conducted");
				int noofTests=scanner.nextInt();
				encounter.setNoOfTest(noofTests);
				entityTransaction.begin();
				entityManager.merge(encounter);
				entityTransaction.commit();
				System.out.println("Updated");
			}
			break;
			case 2:{
				System.out.println("Enter disease name");
				String diseaseName=scanner.next();
				encounter.setDiseaseName(diseaseName);
				entityTransaction.begin();
				entityManager.merge(encounter);
				entityTransaction.commit();
				System.out.println("Updated");
			}
			break;
			case 3:{
				System.out.println("Enter visited doctor name");
				String visitedDoctor=scanner.next();
				encounter.setVistedDoctor(visitedDoctor);
				entityTransaction.begin();
				entityManager.merge(encounter);
				entityTransaction.commit();
				System.out.println("Updated");

			}
			break;
			case 4:{
				flag=false;
			}
			break;
			default:System.out.println("Invalid choice");
			
			}
			
			}
			
		}
		else {
			System.out.println("Invalid Encounter id");
		}
		return encounter;
		
	}
	
	
	

}
