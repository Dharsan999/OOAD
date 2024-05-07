package com.ilp03.service;

import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.ilp03.dao.SalaryManagementDAO;
import com.ilp03.entity.Transaction;
import com.ilp03.entity.BankDetails;
import com.ilp03.entity.Employee;

public class SalaryManagementService {

	public static void getEmployeeSalaryBasedOnId() {
		// TODO Auto-generated method stub
		try {
			Connection connection = SalaryManagementDAO.getConnection();
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the ID of Employee: ");
			int searchEmployeeId = scanner.nextInt();
			ArrayList<Employee> employeeList = SalaryManagementDAO.employeeList(connection, searchEmployeeId);

			System.out.println(
					"EmployeeID | FirstName | LastName | GradeName | TransactionID | Amount | AccountNumber | TransactionDate | TransactionStatus");
			for (Employee employee : employeeList) {
				System.out.println(employee.getEmployeeId() + "\t     " + employee.getFirstName() + "\t "
						+ employee.getLastName() + "\t    " + employee.getGrade().getGradeName() + "\t "
						+ employee.getTransaction().getTransactionId() + "\t\t" + employee.getTransaction().getAmount()
						+ "  " + employee.getBankDetails().getAccountNumber() + "\t "
						+ employee.getTransaction().getTransactionDate() + "\t\t"
						+ employee.getTransaction().getTransactionStatus());
			}

			System.out.println("\nSalary Structure:");
			for (Employee employee : employeeList) {
				System.out.println("GradeID:" + employee.getGrade().getGradeId() + "\n" + "GradeName:"
						+ employee.getGrade().getGradeName() + "\n" + "GradeBasic:"
						+ employee.getGrade().getGradeBasic() + "\n" + "GradeTA:" + employee.getGrade().getGradeTa()
						+ "\n" + "GradeHRA:" + employee.getGrade().getGradeHra() + "\n" + "GradeMA:"
						+ employee.getGrade().getGradeMa() + "\n" + "GradeBonus:" + employee.getGrade().getGradeBonus()
						+ "\n" + "GradePF:" + employee.getGrade().getGradePf() + "\n" + "GradePT:"
						+ employee.getGrade().getGradePt());
			}

			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void insertEmployee(Employee employee) {
		Connection connection = SalaryManagementDAO.getConnection();
		PreparedStatement statement = null;

		try {
			String query = "INSERT INTO Employee (FirstName, LastName, JoinDate, GradeID) VALUES (?, ?, ?, ?)";
			statement = connection.prepareStatement(query);
			statement.setString(1, employee.getFirstName());
			statement.setString(2, employee.getLastName());
			statement.setString(3, employee.getDate());
			statement.setLong(4, employee.getGradeId());
			statement.executeUpdate();

			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insertTransaction(Transaction transaction) {
		Connection connection = SalaryManagementDAO.getConnection();
		PreparedStatement statement = null;

		try {
			String query = "INSERT INTO Transaction (EmployeeID, Amount, BankName, TransactionDate, TransactionStatus) VALUES (?, ?, ?, ?, ?)";
			statement = connection.prepareStatement(query);
			statement.setLong(1, transaction.getEmployeeId());
			statement.setDouble(2, transaction.getAmount());
			statement.setString(3, transaction.getBankName());
			statement.setString(4, transaction.getTransactionDate());
			statement.setString(5, transaction.getTransactionStatus());
			statement.executeUpdate();

			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insertBankDetails(BankDetails bankDetails) {
		Connection connection = SalaryManagementDAO.getConnection();
		PreparedStatement statement = null;

		try {
			String query = "INSERT INTO BankDetails (EmployeeID, AccountNumber, BankName, BranchName, IFSCCode) VALUES (?, ?, ?, ?, ?)";
			statement = connection.prepareStatement(query);
			statement.setLong(1, bankDetails.getEmployeeId());
			statement.setString(2, bankDetails.getAccountNumber());
			statement.setString(3, bankDetails.getBankName());
			statement.setString(4, bankDetails.getBranchName());
			statement.setString(5, bankDetails.getIfscCode());

			statement.executeUpdate();

			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
