package com.ilp03.utility;

import java.util.Scanner;
import com.ilp03.service.SalaryManagementService;
import com.ilp03.entity.Employee;
import com.ilp03.entity.Transaction;
import com.ilp03.entity.BankDetails;

public class SalaryManagementUtility {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char goToMainMenu = 'y';

		System.out.println("Welcome to Salary Management System!");

		do {
			System.out.println("1. Input Employee data");
			System.out.println("2. Input BankDetails data");
			System.out.println("3. Input Transaction data");
			System.out.println("4. Display data");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				inputEmployeeData();
				break;
			case 2:
				inputBankDetails();
				break;
			case 3:
				inputTransaction();
				break;
			case 4:
				SalaryManagementService.getEmployeeSalaryBasedOnId();
				break;
			default:
				System.out.println("Invalid choice. Please enter a valid input");
				break;
			}
			System.out.println("Go back to Main Menu (y/n)");
			goToMainMenu = scanner.next().charAt(0);
		} while (goToMainMenu == 'y');

		scanner.close();
	}

	private static void inputEmployeeData() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter employee details:");
		System.out.print("First Name: ");
		String firstName = scanner.nextLine();
		System.out.print("Last Name: ");
		String lastName = scanner.nextLine();
		System.out.print("Join Date: ");
		String joinDate = scanner.nextLine();
		System.out.print("Grade ID: ");
		long gradeId = scanner.nextLong();

		Employee employee = new Employee(0, firstName, lastName, joinDate, gradeId, null, null, null);
		SalaryManagementService.insertEmployee(employee);

		System.out.println("Employee data inserted successfully!");

		scanner.close();
	}

	private static void inputBankDetails() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter bank details:");
		System.out.print("Employee Number: ");
		int employeeId = scanner.nextInt();
		System.out.print("Account Number: ");
		scanner.nextLine();
		String accountNumber = scanner.nextLine();
		System.out.print("Bank Name: ");
		String bankName = scanner.nextLine();
		System.out.print("Branch Name: ");
		String branchName = scanner.nextLine();
		System.out.print("IFSC Code: ");
		String ifscCode = scanner.nextLine();

		BankDetails bankDetails = new BankDetails(0, employeeId, accountNumber, bankName, branchName, ifscCode);
		SalaryManagementService.insertBankDetails(bankDetails);

		System.out.println("Bank details inserted successfully!");

		scanner.close();
	}

	private static void inputTransaction() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter transaction details:");
		System.out.print("Employee ID: ");
		int employeeId = scanner.nextInt();
		System.out.print("Amount: ");
		double amount = scanner.nextDouble();
		scanner.nextLine();
		System.out.print("Bank Name: ");
		String bankName = scanner.nextLine();
		System.out.print("Date: ");
		String date = scanner.nextLine();
		System.out.print("Status: ");
		String status = scanner.nextLine();

		Transaction transaction = new Transaction(0, employeeId, amount, bankName, date, status);
		SalaryManagementService.insertTransaction(transaction);

		System.out.println("Transaction data inserted successfully!");

		scanner.close();
	}
}
