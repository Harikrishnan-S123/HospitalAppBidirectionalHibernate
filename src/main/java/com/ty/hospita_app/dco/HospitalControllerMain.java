package com.ty.hospita_app.dco;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.ty.hospita_app.duo.BranchDuo;
import com.ty.hospita_app.duo.EncounterDao;
import com.ty.hospita_app.duo.HosiptalDuo;
import com.ty.hospita_app.duo.MedOrderDuo;
import com.ty.hospita_app.entity.Branch;
import com.ty.hospita_app.entity.Encounter;
import com.ty.hospita_app.entity.Hospital;
import com.ty.hospita_app.entity.MedOrders;
import com.ty.hospita_app.helper.DriverHelper;
import com.ty.hospita_app.helper.Helper;

public class HospitalControllerMain {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		boolean flag=true;
		try {
		while(flag) {
			System.out.println("Welcome to the Hospital Application");
			System.out.println("Enter your choice");
			System.out.println("1.Hospital Operations\n2.Branch Operarations\n3.Encounter operations\n4.Medorder operations\n5.Exit");
			switch(scanner.nextInt()) {
			case 1:
			{
				
				DriverHelper.HospitalOperations();
				
			}
			break;
			//---------------------------------------------------------
			case 2:
			{
				DriverHelper.BranchOperation();
			}
			break;
			//----------------------------------------------
			case 3:
			{
				DriverHelper.EncounterOperations();
			}
			break;
			//------------------------------------------
			case 4:{
				DriverHelper.MedOrderOperations();
			}
			break;
			
			//------------------------------------------
			case 5:
			{
				flag=false;
				System.out.println("Thanks for choosing us");
				
			}
			break;
			default:System.out.println("Invalid choice");
			

			}
		}
		}
		catch (InputMismatchException e) {
			System.out.println("Wrong input chosen");
			System.out.println("Taking you back");
			scanner.nextLine();
			main(args);
			//scanner.nextLine();
		}
		scanner.close();
	}

}
