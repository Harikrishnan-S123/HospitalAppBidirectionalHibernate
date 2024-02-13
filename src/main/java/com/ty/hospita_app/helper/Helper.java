package com.ty.hospita_app.helper;

import java.util.Scanner;

import com.ty.hospita_app.entity.Address;
import com.ty.hospita_app.entity.Branch;
import com.ty.hospita_app.entity.Encounter;
import com.ty.hospita_app.entity.Hospital;
import com.ty.hospita_app.entity.Item;
import com.ty.hospita_app.entity.MedOrders;
import com.ty.hospita_app.entity.Person;

public class Helper {
	
	public static  void forEach(Hospital hospital) {
		if(hospital!=null) {
			System.out.println("-----------------------------------------------");
			System.out.println("Id:  "+hospital.getHospitalId());
			System.out.println("Name: "+hospital.getHospitalName());
			System.out.println("Founder: :"+hospital.getFounderName());
			System.out.println("No of Beds: :"+hospital.getNoOfBeds());
			System.out.println("No of doctors"+hospital.getNoOfBeds());
			System.out.println("-----------------------------------------------");
		}
		else
			System.out.println("Invalid Insertion");
		
	}
	public static  void forEach(Encounter encounter) {
		if(encounter!=null) {
			Person person=encounter.getPerson();
			System.out.println("------------------------Person Basic Details ----------------------");
			System.out.println("Id: "+person.getPersonId());
			System.out.println("Name: "+person.getName());
			System.out.println("NO of visits"+person.getNoOfVisits());
			System.out.println("------------------------Encounter Details----------------------");
			System.out.println("Id:  "+encounter.getEncounterId());
			System.out.println("Disease Name: "+encounter.getDiseaseName());
			System.out.println("Visited Doctor: :"+encounter.getVistedDoctor());
			System.out.println("No of tests: :"+encounter.getNoOfTest());
			System.out.println("Admission Date:"+encounter.getAdmissionDate());
			System.out.println("-----------------------------------------");
		}
		else {
			System.out.println("Encounter does not exist");
		}
		
	}
	public static int getHospitalId(Scanner scanner) {
		System.out.println("Enter hospital id");
		return scanner.nextInt();
	}
	public static int getBranchId(Scanner scanner) {
		System.out.println("Enter branch id");
		return scanner.nextInt();
	}
	public static int getPersonId(Scanner scanner) {
		System.out.println("Enter person id");
		return scanner.nextInt();
	}
	public static int getEncounterId(Scanner scanner) {
		System.out.println("Enter encounter id");
		return scanner.nextInt();
	}
	public static int getMedOrderId(Scanner scanner) {
		System.out.println("Enter MedOrder id");
		return scanner.nextInt();
	}
	public static void forEach(MedOrders medOrders) {
		if(medOrders!=null) {
			System.out.println("-------------------------------------");
			System.out.println("Medorder id"+medOrders.getMedOrderId());
			System.out.println("Medorder invoice no"+medOrders.getInvoiceNumber());
			System.out.println("No of medicines"+medOrders.getNoofMedicines());
			System.out.println("Order Date"+medOrders.getOrderDate());
			System.out.println("Payment Mode"+medOrders.getPaymentMode());
			System.out.println("Billed item number"+medOrders.getItems().size());
			System.out.println("-------------------------------------");
			
		}
		
	}
	public static void forEach(Branch branch) {
		if(branch!=null) {
			System.out.println("-------------------------------------");
			System.out.println("Branch id  "+branch.getBranchId());
			System.out.println("Branch Head Name  "+branch.getBranchHeadName());
			System.out.println("Branch year of start  "+branch.getYearOfStart());
			System.out.println("No of devices   "+branch.getNoOfDevices());
			System.out.println("-------------------Address Details--------------");
			Address address=branch.getAddress();
			if(address!=null) {
				System.out.println("Address name"+address.getName());
				System.out.println("District Name:"+address.getDistrictName());
				System.out.println("State Name:" +address.getStateName());
				System.out.println("LandMark: "+address.getLandMark());
			}
			

			
		}
		else {
			System.out.println("Invalid Branch Id");
		}
		
	}
	public static void forEach(Item item) {
		// TODO Auto-generated method stub
		if(item!=null) {
			System.out.println("---------------------");
			System.out.println("Item id"+item.getItemId());
			System.out.println("Item Name"+item.getName());
			System.out.println("Item Dosage"+item.getDosage());
			System.out.println("No of days"+item.getNoofDays());
			//System.out.println(item.getMedOrders().size());
			System.out.println("---------------------");
		}
		else {
			System.out.println("Item does not exist");
		}
	}


}
