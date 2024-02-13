package com.ty.hospita_app.dco;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.hospita_app.duo.MedOrderDuo;
import com.ty.hospita_app.entity.MedOrders;
import com.ty.hospita_app.helper.Helper;



public class TestController {
	
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		MedOrderDuo duo=new MedOrderDuo();
		Scanner scanner=new Scanner(System.in);
		MedOrders medOrders=entityManager.find(MedOrders.class, Helper.getMedOrderId(scanner));
		duo.addExistingItem(medOrders);
		
		
	}

}
