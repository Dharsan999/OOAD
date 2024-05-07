package com.ilp03.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ilp03.entity.Transaction;
import com.ilp03.entity.Employee;
import com.ilp03.entity.Grade;
import com.ilp03.entity.BankDetails;

public class SalaryManagementDAO {
	public static Connection getConnection() {
		String connectionString = "jdbc:mysql://localhost:3306/salary?useSSL=false";
		String userName = "root";
		String password = "Haida@123";
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(connectionString, userName, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public static void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Employee> employeeList(Connection connection, int searchEmployeeId)
	{
		PreparedStatement statement;
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		try {
			statement = connection.prepareStatement("SELECT * FROM Employee e JOIN Grade g ON e.GradeID = g.GradeID JOIN Transaction t ON e.EmployeeID = t.EmployeeID JOIN BankDetails b ON e.EmployeeID = b.EmployeeID WHERE e.EmployeeID = ?;");
			statement.setInt(1, searchEmployeeId);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int employeeId = resultSet.getInt(1);
				String firstName = resultSet.getString(2);
				String lastName = resultSet.getString(3);
				String joinDate = resultSet.getString(4);
				long gradeId = resultSet.getLong(5);
				String gradeName = resultSet.getString(7);
				double gradeBasic = resultSet.getDouble(8);
				double gradeTa = resultSet.getDouble(9);
				double gradeHra = resultSet.getDouble(10);
				double gradeMa = resultSet.getDouble(11);
				double gradeBonus = resultSet.getDouble(12);
				double gradePf = resultSet.getDouble(13);
				double gradePt = resultSet.getDouble(14);
				long transactionId = resultSet.getLong(15);
				double amount = resultSet.getDouble(17);
				String transactionBankName	= resultSet.getString(18);
				String transactionDate = resultSet.getString(19);
				String transactionStatus = resultSet.getString(20);
                long bankDetailId = resultSet.getLong(21);
				String accountNumber =  resultSet.getString(23);
                String employeeBankName = resultSet.getString(24);
                String branchName = resultSet.getString(25);
                String ifscCode = resultSet.getString(26);
				
     			BankDetails bankDetails = new BankDetails(bankDetailId,employeeId,accountNumber,employeeBankName,branchName,ifscCode);
                Grade grade = new Grade(gradeId,gradeName,gradeBasic,gradeTa,gradeHra,gradeMa,gradeBonus,gradePf,gradePt);
                Transaction transaction = new Transaction(transactionId,employeeId,amount,transactionBankName,transactionDate,transactionStatus);
				Employee employee = new Employee(employeeId,firstName,lastName,joinDate,gradeId,bankDetails,grade,transaction);

     			employeeList.add(employee);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       return employeeList;
		
	}
}