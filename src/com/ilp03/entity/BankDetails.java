package com.ilp03.entity;

public class BankDetails {
	private long bankDetailId;
	private int employeeId;
	private String accountNumber;
	private String bankName;
	private String branchName;
	private String ifscCode;
	public BankDetails(long bankDetailId, int employeeId, String accountNumber, String bankName, String branchName,
			String ifscCode) {
		super();
		this.bankDetailId = bankDetailId;
		this.employeeId = employeeId;
		this.accountNumber = accountNumber;
		this.bankName = bankName;
		this.branchName = branchName;
		this.ifscCode = ifscCode;
	}
	public long getBankDetailId() {
		return bankDetailId;
	}
	public void setBankDetailId(long bankDetailId) {
		this.bankDetailId = bankDetailId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

}
