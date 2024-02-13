package com.ty.hospita_app.duo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hospita_app.entity.Encounter;
import com.ty.hospita_app.entity.Item;
import com.ty.hospita_app.entity.MedOrders;
import com.ty.hospita_app.helper.Helper;

public class MedOrderDuo {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	Scanner scanner=new Scanner(System.in);
	public MedOrders saveMedOrders(MedOrders medOrders,int id) {
		Encounter encounter=(new EncounterDao()).findEncounter(id);
		if(encounter!=null) {
			System.out.println("Enter number of medicine");
			int noOfMedicines=scanner.nextInt();
			System.out.println("Enter invoice number");
			String invoiceNumber=scanner.next();
			System.out.println("Enter orderdate");
			String orderDate=scanner.next();
			System.out.println("Enter payment mode");
			String paymentMode=scanner.next();
			List<Item> items=ItemDuo.getItems();
			medOrders=new MedOrders(noOfMedicines, invoiceNumber, orderDate, paymentMode, items);
			medOrders.setEncounter(encounter);
			entityTransaction.begin();
			for(Item eachItem:items)
				entityManager.persist(eachItem);
			entityManager.persist(medOrders);
			entityTransaction.commit();
			Helper.forEach(medOrders);
		}
		else {
			System.out.println("Invalid encounter id");
		}
		return medOrders;

	}
	public  MedOrders findMedOrders(MedOrders medOrders,int medOrderId) {
		return entityManager.find(MedOrders.class,medOrderId);
	}
	public boolean removeMedOrders(MedOrders medOrders,int medOrderId) {
		boolean flag=false;
		medOrders=findMedOrders(medOrders, medOrderId);
		if(medOrders!=null) {
			List<Item> items=medOrders.getItems();
			entityTransaction.begin();
//			for(Item eachItem:items)
//				entityManager.remove(eachItem);
			entityManager.remove(medOrders);
			entityTransaction.commit();
		}
		else {
			System.out.println("invalid medorderid");
		}




		return flag;






	}

	//---------------------
	public MedOrders updateMedOrders(MedOrders medOrders,int medorderId) {
		medOrders=findMedOrders(medOrders, medorderId);
		boolean flag=true;
		if(medOrders!=null) {
			while(flag) {
				System.out.println("1.change payment mode\n2.Change the items completely.\n3.add items to existing\n4.Add Existing item to the medorder\n5.Go back");
				switch(scanner.nextInt()) {
				case 1:
				{
					System.out.println("Enter the payment mode");
					String paymentMode=scanner.next();
					medOrders.setPaymentMode(paymentMode);
					entityTransaction.begin();
					entityManager.merge(medOrders);
					entityTransaction.commit();
					System.out.println("Updated");

				}
				break;
				case 2:
				{
					List<Item> oldItems=medOrders.getItems();
					List<Item> items=ItemDuo.getItems();
					medOrders.setItems(items);
					entityTransaction.begin();
					for(Item item:items) {
                        //System.out.println(item);
						entityManager.persist(item);
					}
					entityManager.merge(medOrders);
//					for(Item item:oldItems) {
//						entityManager.remove(item);
//					}

					entityTransaction.commit();
					System.out.println("Updated");
				}
				break;
				case 3:
				{
					List<Item> oldItems=medOrders.getItems();
					List<Item> items=ItemDuo.getItems();
					entityTransaction.begin();
					for(Item i:items)
						entityManager.persist(i);
					entityTransaction.commit();
					oldItems.addAll(items);
					medOrders.setItems(oldItems);
					entityTransaction.begin();
//					for(Item item:items) {
//                        //System.out.println(item);
//						entityManager.persist(item);
//					}
					entityManager.merge(medOrders);


					entityTransaction.commit();
					System.out.println("Updated");
				}
				break;
				case 4:
				{
					addExistingItem(medOrders);
				}
				case 5:
				{
					flag=false;
				}
				break;
				default:{
					System.out.println("Invalid option");
				}
				}
			}
		}
		else {
			System.out.println("Invalid medorder id");
		}
		return medOrders;

	}
	//----------------------------------------------------------------------
	
	
	public void addExistingItem(MedOrders medOrders) {
		System.out.println("enter itemid to be inserted");
		int itemId=scanner.nextInt();
		Item item=entityManager.find(Item.class, itemId);
		if(item!=null) {
			List<Item> itemList=medOrders.getItems();
		    itemList.add(item);
		    medOrders.setItems(itemList);
			entityTransaction.begin();
			entityManager.merge(medOrders);
			entityTransaction.commit();
			System.out.println("Added successfully");
			Helper.forEach(item);
		}
	}

}
