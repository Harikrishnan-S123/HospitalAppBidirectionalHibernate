package com.ty.hospita_app.duo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hospita_app.entity.Address;

public class AddressDuo {
//	static EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
//	static EntityManager entityManager=entityManagerFactory.createEntityManager();	
	static Scanner scanner=new Scanner(System.in);
	public static Address getAddress(Address address) {
		System.out.println("Enter address location name");
		String addressName=scanner.next();
		System.out.println("Enter district name");
		String districtName=scanner.next();
		System.out.println("Enter state name");
		String stateName=scanner.next();
		System.out.println("Enter landmark");
		String landmark=scanner.next();
		System.out.println("Enter pin");
		int pin=scanner.nextInt();
		address=new Address(addressName, districtName, stateName, landmark, pin);
		return address;
	}
	public static Address getAddressofBranch(Address address) {
		System.out.println("Enter address location name");
		String addressName=scanner.next();
		address.setName(addressName);
		System.out.println("Enter district name");
		String districtName=scanner.next();
		address.setDistrictName(districtName);
		System.out.println("Enter state name");
		String stateName=scanner.next();
		address.setStateName(stateName);
		System.out.println("Enter landmark");
		String landmark=scanner.next();
		System.out.println("Enter pin");
		address.setLandMark(landmark);
		int pin=scanner.nextInt();
		address.setPin(pin);
		return address;
		
	}


}
