// Mysti Freed, mrfreed@dmacc.edu
// 10/2/2018
// This program is used in combination with RegistrationHelper.java program to add/adjust or delete a
// vehicle or owner to the MySQL Database webcarregistration via the auto_info and owner_info tables

package view;

import java.util.List;
import java.util.Scanner;

import controller.RegistrationHelper;
import model.AutoInfo;
import model.OwnerInfo;

public class CarRegistrationRun {

	static Scanner in = new Scanner(System.in);
	static RegistrationHelper rh = new RegistrationHelper();

	/**
	 * This method adds a vehicle to the database in combination with the addVehicle method from the RegistrationHelper 
	 */
	private static void addNewVehicle() {

		System.out.print("Enter vehicle make: ");
		String make = in.nextLine();
		System.out.print("Enter vehicle model: ");
		String model = in.nextLine();
		System.out.println("Enter vehicle year: ");
		String year = in.nextLine();
		System.out.println("Enter vehicle vin: ");
		String vin = in.nextLine();
		AutoInfo toAdd = new AutoInfo(make, model, year, vin);
		rh.addVehicle(toAdd);
	}

	/**
	 * This method adds an owner to the database in combination with the addOwner method from the RegistrationHelper 
	 */
	public static void addVehicleOwner() {
		System.out.println("Enter owner first name: ");
		String firstName = in.nextLine();
		System.out.println("Enter last name: ");
		String lastName = in.nextLine();
		OwnerInfo toAdd = new OwnerInfo(firstName, lastName);
		rh.addOwner(toAdd);
	}

	/**
	 * This method removes a vehicle from the database in combination with the deleteVehicle method from the RegistrationHelper 
	 */
	private static void removeVehicle() {
		System.out.print("Enter the VIN for the vehicle to be deleted: ");
		String vin = in.nextLine();
		AutoInfo toRemove = new AutoInfo(vin);
		rh.deleteVehicle(toRemove);
	}

	/**
	 * This method edits a vehicle or owner in the database in combination with the following methods from the RegistrationHelper:
	 * updateVehicle, updateOwner, searchByVin, searchByIDAuto, searchByLast, searchByIDOwner 
	 */
	private static void editRegistration() {
		System.out.println("Please choose search criteria: ");
		System.out.println("1 : Search by VIN Number");
		System.out.println("2 : Search by Owner Last Name");
		int searchBy = in.nextInt();
		in.nextLine();
		List<AutoInfo> foundVehicle;
		List<OwnerInfo> foundOwner;
		if (searchBy == 1) {
			System.out.print("Enter the VIN number: ");
			String vinNumber = in.nextLine();
			foundVehicle = rh.searchByVin(vinNumber);
			if (!foundVehicle.isEmpty()) {
				System.out.println("Found Results.");
				for (AutoInfo ai : foundVehicle) {
					System.out.println(ai.getId() + " : " + ai.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();
				AutoInfo toEdit = rh.searchByIDAuto(idToEdit);
				System.out.println("Retrieved " + toEdit.getVin());
				System.out.println("1 : Update Make:");
				System.out.println("2 : Update Model:");
				System.out.println("3 : Update Year: ");
				System.out.println("4 : Update VIN: ");
				int update = in.nextInt();
				in.nextLine();
				if (update == 1) {
					System.out.print("New Make: ");
					String newMake = in.nextLine();
					toEdit.setMake(newMake);
				} else if (update == 2) {
					System.out.print("New Model: ");
					String newModel = in.nextLine();
					toEdit.setModel(newModel);
				} else if (update == 3) {
					System.out.print("New Year: ");
					String newYear = in.nextLine();
					toEdit.setYear(newYear);
				} else if (update == 4) {
					System.out.print("New VIN: ");
					String newVIN = in.nextLine();
					toEdit.setVin(newVIN);
				}
				rh.updateVehicle(toEdit);
			} else {
				System.out.println("---- No results found");
			}
		} else {
			System.out.print("Enter the last name: ");
			String lastName = in.nextLine();
			foundOwner = rh.searchByLast(lastName);
			if (!foundOwner.isEmpty()) {
				System.out.println("Found Results.");
				for (OwnerInfo oi : foundOwner) {
					System.out.println(oi.getId() + " : " + oi.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();
				OwnerInfo toEdit = rh.searchByIDOwner(idToEdit);
				System.out.println("Retrieved " + toEdit.getLastName() + ", " + toEdit.getFirstName());
				System.out.println("1 : Update First Name:");
				System.out.println("2 : Update Last Name:");
				int update = in.nextInt();
				in.nextLine();
				if (update == 1) {
					System.out.print("New First Name: ");
					String newFirst = in.nextLine();
					toEdit.setFirstName(newFirst);
				} else if (update == 2) {
					System.out.print("New Last Name: ");
					String newLast = in.nextLine();
					toEdit.setLastName(newLast);
				} 
				rh.updateOwner(toEdit);
			} else {
				System.out.println("---- No results found");
			}
		}
	}

	/**
	 * This method yields a list of vehicles in the database in combination with the generateList method from the RegistrationHelper 
	 */
	private static void viewRegisteredVehicles() {
		List<AutoInfo> allVehicles = rh.displayVehicles();
		for(AutoInfo ai : allVehicles){
			ai.generateList();
		}
	}

	/**
	 * This method runs the start menu for use with the program offline for debugging
	 */
	public static void main(String[] args) {
		runMenu();
	}

	/**
	 * This method works runs the start menu for use with the program offline for debugging
	 */
	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("This program will allow you to register a vehicle. Please ensure you have auto and owner information.");
		while (goAgain) {
			System.out.println("*  Make a selection from the below list: ");
			System.out.println("*  1 -- Add a vehicle to the database");
			System.out.println("*  2 -- Add corresponding owner to the database");
			System.out.println("*  3 -- Edit a vehicle in the database");
			System.out.println("*  4 -- Delete a registered vehicle");
			System.out.println("*  5 -- View all registered vehicles");
			System.out.println("*  6 -- Quit");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addNewVehicle();
			} else if (selection == 2) {
				addVehicleOwner();
			} else if (selection == 3) {
				editRegistration();
			} else if (selection == 4) {
				removeVehicle();
			} else if (selection == 5) {
				viewRegisteredVehicles();
			} else {
				rh.cleanUp();
				System.out.println("   Thank you.   ");
				goAgain = false;
			}
		}
	}
}