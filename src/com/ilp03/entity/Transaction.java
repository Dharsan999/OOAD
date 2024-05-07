package com.ilp03.entity;

public class Transaction {
	private long transactionId;
	private int employeeId;
	private double amount;
	private String bankName;
	private String transactionDate;
	private String transactionStatus;
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	public Transaction(long transactionId, int employeeId, double amount, String bankName, String transactionDate,
			String transactionStatus) {
		super();
		this.transactionId = transactionId;
		this.employeeId = employeeId;
		this.amount = amount;
		this.bankName = bankName;
		this.transactionDate = transactionDate;
		this.transactionStatus = transactionStatus;
	}

}
