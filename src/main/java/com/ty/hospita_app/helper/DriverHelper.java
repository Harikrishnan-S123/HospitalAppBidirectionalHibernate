package com.ty.hospita_app.helper;

import java.util.Scanner;

import com.ty.hospita_app.duo.BranchDuo;
import com.ty.hospita_app.duo.EncounterDao;
import com.ty.hospita_app.duo.HosiptalDuo;
import com.ty.hospita_app.duo.MedOrderDuo;
import com.ty.hospita_app.duo.PersonDao;
import com.ty.hospita_app.entity.Branch;
import com.ty.hospita_app.entity.Encounter;
import com.ty.hospita_app.entity.Hospital;
import com.ty.hospita_app.entity.MedOrders;
import com.ty.hospita_app.entity.Person;

public class DriverHelper {
	static Scanner scanner=new Scanner(System.in);
	public static void HospitalOperations() {

		HosiptalDuo hosiptalDuo=new HosiptalDuo();
		boolean hospitalFlag=true;
		while(hospitalFlag) {
			System.out.println("1.Register hospital\n2.Remove Hospital\n3.Find Hospital\n4.Update Hospital\n5.Go back\n6.Exit");
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
				Helper.forEach(hosiptalDuo.findHopsital(Helper.getHospitalId(scanner)));
			}
			break;
			case 4:{
				hosiptalDuo.updateHospital(new Hospital(), Helper.getHospitalId(scanner));
			}
			break;
			case 5:{
				hospitalFlag=false;
			}
			break;
			case 6:{
				System.out.println("Thanks for choosing us");
				System.exit(0);
			}
			break;
			default:System.out.println("Invalid choice");
			}

		}
	}
	//----------------------------------
	public static void BranchOperation() {
		BranchDuo branchDuo=new BranchDuo();
		boolean branchFlag=true;
		while(branchFlag) {
			System.out.println("1.save Branch\n2.Remove Branch\n3.Update Branch\n4.Find Branch\n5.Go Back\n6.Exit");
			switch(scanner.nextInt()) {
			case 1:
			{
				(new HosiptalDuo()).getAllHospital();
				branchDuo.saveBranch(new Branch(), Helper.getHospitalId(scanner));
			}
			break;
			case 2:{
				branchDuo.removeBranch(Helper.getBranchId(scanner));
			}
			break;
			case 3:{
				branchDuo.updateBranchDetails(new Branch(), Helper.getBranchId(scanner));
			}
			break;
			case 4:{
				Helper.forEach(branchDuo.findBranch(Helper.getBranchId(scanner)));
			}
			break;
			case 5:{
				branchFlag=false;
			}
			break;
			case 6:{
				System.out.println("Thanks for choosing us");
				System.exit(0);
			}
			break;
			default:{
				System.out.println("Invalid choice");
			}
			}
		}
	}
	
	//----------------------------------------------------------
	public static void EncounterOperations() {
		EncounterDao dao=new EncounterDao();

		boolean encounterFlag=true;
		while(encounterFlag) {
			System.out.println("1.save encounter\n2.remove encounter\n3.Update Encounter\n4.Display Encounter\n5.Go back\n6.Exit");
			switch(scanner.nextInt()) {
			case 1:
			{
				System.out.println("New user?");
				System.out.println("Press 1 for adding new person \n any other number to continue");
				if(scanner.nextInt()==1) {
					Person person=(new PersonDao()).savePerson(new Person());
					dao.saveEncounter(new Encounter(), Helper.getBranchId(scanner),person.getPersonId() );

					
				}
				else {
				dao.saveEncounter(new Encounter(), Helper.getBranchId(scanner), Helper.getPersonId(scanner));
				}
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
			case 6:
			{
				System.out.println("Thanks for choosing us");
				System.exit(0);
			}
			break;
			default:System.out.println("Invalid choice");


			}
		}
	}
	//----------------------------------
	public static void MedOrderOperations() {
		MedOrderDuo medOrderDuo=new MedOrderDuo();
		boolean medOrderFlag=true;
		while(medOrderFlag) {
			System.out.println("hi");
			System.out.println("1.save Medorders\n2.Remove medorders\n3.Update Medorders\n4.Find Medorders\n5.Go back\n6.Exit");
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
			case 6:{
				System.out.println("Thanks for choosing us");
				System.exit(0);
			}
			break;
			default:{
				System.out.println("Invalid option");
			}
			}
		}
	}
		
		
	}


