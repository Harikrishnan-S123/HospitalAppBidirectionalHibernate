package com.ty.hospita_app.duo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospita_app.entity.Branch;
import com.ty.hospita_app.entity.Encounter;
import com.ty.hospita_app.entity.Hospital;
import com.ty.hospita_app.entity.MedOrders;
import com.ty.hospita_app.entity.Person;
import com.ty.hospita_app.helper.Helper;

public class HosiptalDuo {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	Scanner scanner=new Scanner(System.in);
	//BranchDuo branchDuo=new BranchDuo();
	EncounterDao encounterDao=new EncounterDao();
	MedOrderDuo medOrderDuo=new MedOrderDuo();
	public Hospital saveHospital(Hospital hospital) {
		System.out.println("Enter hospitalName");
		String hospitalName=scanner.next();
		hospital.setHospitalName(hospitalName);
		System.out.println("Enter founder name");
		String founderName=scanner.next();
		hospital.setFounderName(founderName);
		System.out.println("Enter total no of beds");
		int noOfBeds=scanner.nextInt();
		hospital.setNoOfBeds(noOfBeds);
		System.out.println("Enter total no of doctors");
		int noOfDoctors=scanner.nextInt();
		hospital.setNoOfDoctors(noOfDoctors);
		hospital.setBranches(new ArrayList<Branch>());
		entityTransaction.begin();
		entityManager.persist(hospital);
		entityTransaction.commit();
		System.out.println("Hospital Registered successfully");
		Helper.forEach(hospital);
		return hospital;


	}
	public Hospital findHopsital(int hospitalId) {
		return entityManager.find(Hospital.class, hospitalId);
	}

	public boolean removeHospital(Hospital hospital,int hospitalId) {
		boolean flag=false;
		hospital=findHopsital(hospitalId);
		if(hospital!=null) {
			entityTransaction.begin();
			entityManager.remove(hospital);
			entityTransaction.commit();
			flag=true;
		}
		else {
			System.out.println("Invalid to find hospital");
		}

		return flag;

	}
	public  Hospital updateHospital(Hospital hospital,int hospitalId) {
		hospital=findHopsital(hospitalId);
		if(hospital!=null) {
			boolean flag=true;
			while(flag) {
				System.out.println("1.Update hospitalname\n2.Update no of beds\n3.Update no of doctors\n4.Go back");
				switch(scanner.nextInt()) {
				case 1:{
					System.out.println("Enter hsopital name");
					String hospitalName=scanner.next();
					hospital.setHospitalName(hospitalName);
					entityTransaction.begin();
					entityManager.merge(hospital);
					entityTransaction.commit();

				}
				break;
				case 2:{
					System.out.println("Enter no of beds");
					int noOfBeds=scanner.nextInt();
					hospital.setNoOfBeds(noOfBeds);
					entityTransaction.begin();
					entityManager.merge(hospital);
					entityTransaction.commit();


				}
				break;
				case 3:{
					System.out.println("Enter no of beds");
					int noOfDoctors=scanner.nextInt();
					hospital.setNoOfDoctors(noOfDoctors);
					entityTransaction.begin();
					entityManager.merge(hospital);
					entityTransaction.commit();

				}
				break;
				case 4:{
					flag=false;

				}
				break;
				default:System.out.println("Invalid");

				}
			}
		}
		else {
			System.out.println("invalid hospital id");
		}

		return hospital;

	}


	public void finalTasks(Scanner scanner) {
		this.scanner.close();
		encounterDao.scanner.close();
		//branchDuo.scanner.close();
		scanner.close();
	}
	public  void getAllHospital() {
		Query query=entityManager.createQuery("select h from Hospital h");
		List<Hospital> hospitals=query.getResultList();
		if(hospitals!=null && hospitals.isEmpty()==false) {
		  for(Hospital hospital:hospitals) {
			Helper.forEach(hospital);
			
		  }
		}
		else {
			System.out.println("No hospitals registered till now");
		}
	}

}
