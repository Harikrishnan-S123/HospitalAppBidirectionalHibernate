package com.ty.hospita_app.dco;

import java.util.Scanner;

import com.ty.hospita_app.duo.BranchDuo;
import com.ty.hospita_app.duo.EncounterDao;
import com.ty.hospita_app.duo.HosiptalDuo;
import com.ty.hospita_app.duo.MedOrderDuo;
import com.ty.hospita_app.entity.Branch;
import com.ty.hospita_app.entity.Encounter;
import com.ty.hospita_app.entity.Hospital;
import com.ty.hospita_app.entity.MedOrders;
import com.ty.hospita_app.helper.Helper;

public class HospitalController {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		boolean flag=true;
		while(flag) {
			System.out.println("Welcome to the Hospital Application");
			System.out.println("Enter your choice");
			System.out.println("1.Hospital Operations\n2.Branch Operarations\n3.Encounter operations\n4.Medorder operations\n5.Exit");
			switch(scanner.nextInt()) {
			case 1:
			{
				HosiptalDuo hosiptalDuo=new HosiptalDuo();
				boolean hospitalFlag=true;
				while(hospitalFlag) {
					System.out.println("1.Register hospital\n2.Remove Hospital");
					switch(scanner.nextInt()) {
					case 1:
					{

						hosiptalDuo.saveHospital(new Hospital());
					}
					break;
					case 2:
					{
						hosiptalDuo.removeHospital(new Hospital(), Helper.getHospitalId(scanner));
					}
					break;
					case 3:{
						hospitalFlag=false;
					}
					}

				}
			}
			break;
			//---------------------------------------------------------
			case 2:
			{
				BranchDuo branchDuo=new BranchDuo();
				boolean branchFlag=true;
				while(branchFlag) {
					System.out.println("1.save Branch\n2.Remove Branch\n3.Update Location\n4.Go back\n5.Exit");
					switch(scanner.nextInt()) {
					case 1:
					{
						branchDuo.saveBranch(new Branch(), Helper.getHospitalId(scanner));
					}
					break;
					case 2:{
						branchDuo.removeBranch(Helper.getBranchId(scanner));
					}
					break;
					case 3:{
						branchDuo.updateBranch(Helper.getBranchId(scanner));
					}
					break;
					case 4:{
						branchFlag=false;
					}
					break;
					case 5:{
						System.exit(0);
					}
					break;
					default:{
						System.out.println("Invalid choice");
					}
					}
				}
			}
			//----------------------------------------------
			case 3:
			{
				EncounterDao dao=new EncounterDao();

				boolean encounterFlag=true;
				while(encounterFlag) {
					System.out.println("1.save encounter\n2.remove encounter\n3.Update Encounter\n4.Display Encounter\n.5.Exit");
					switch(scanner.nextInt()) {
					case 1:
					{
						dao.saveEncounter(new Encounter(), Helper.getBranchId(scanner), Helper.getPersonId(scanner));
					}
					break;
					case 2:
					{
						dao.removeEncounter(new Encounter(), Helper.getEncounterId(scanner));
					}
					break;
					case 3:
					{
						dao.updateEncounter(new Encounter(), Helper.getEncounterId(scanner));
					}
					break;
					case 4:
					{
						Helper.forEach(dao.findEncounter(Helper.getEncounterId(scanner)));
					}
					break;
					case 5:
					{
						encounterFlag=false;
					}
					break;


					}
				}
			}
			break;
			//------------------------------------------
			case 4:{
				MedOrderDuo medOrderDuo=new MedOrderDuo();
				boolean medOrderFlag=true;
				while(medOrderFlag) {
					System.out.println("hi");
					System.out.println("1.save Medorders\n2.Remove medorders\n3.Update Medorders\n4.Find Medorders\n5.Go back");
					switch(scanner.nextInt()) {
					case 1:
					{
						medOrderDuo.saveMedOrders(new MedOrders(), Helper.getEncounterId(scanner));

					}
					break;
					case 2:
					{
						medOrderDuo.removeMedOrders(new MedOrders(), Helper.getMedOrderId(scanner));

					}
					break;
					case 3:
					{
					medOrderDuo.updateMedOrders(new MedOrders(),Helper.getMedOrderId(scanner));

					}
					break;
					case 4:
					{
						Helper.forEach(medOrderDuo.findMedOrders(new MedOrders(), Helper.getMedOrderId(scanner)));

					}
					break;
					case 5:
					{
						medOrderFlag=false;

					}
					break;
					
					}
				}
			}
			break;
			
			//------------------------------------------
			case 5:
			{
				flag=false;
				System.out.println("Thanks for choosing us");
				
			}

			}
		}
	}

}
