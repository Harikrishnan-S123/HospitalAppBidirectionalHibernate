package com.ty.hospita_app.duo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



import com.ty.hospita_app.entity.Item;

public class ItemDuo {
//	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
//	EntityManager entityManager=entityManagerFactory.createEntityManager();
//	EntityTransaction entityTransaction=entityManager.getTransaction();
	static Scanner scanner=new Scanner(System.in);
	
	public static  List<Item> getItems(){
		System.out.println("eneter no of items you want bill for");
		int noOfItems=scanner.nextInt();
		List<Item> items=new ArrayList<>();

		for(int i=0;i<noOfItems;i++) {
			System.out.println("Enter name");
			String itemName=scanner.next();
			System.out.println("Enter price");
			double price=scanner.nextDouble();
			System.out.println("Enter dosage");
			String dosage=scanner.next();
			System.out.println("Enter number of days");
			String noOfDays=scanner.next();
			System.out.println("Enter expiry(in months)");
			String expiry=scanner.next();
			Item item=new Item(itemName, price, dosage, noOfDays, expiry);
			items.add(item);


		}
		return items;
	}
	

}
