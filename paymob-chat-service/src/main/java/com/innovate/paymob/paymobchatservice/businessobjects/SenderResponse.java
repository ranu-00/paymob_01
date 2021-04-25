package com.innovate.paymob.paymobchatservice.businessobjects;

public class SenderResponse {
	
	private String name;
	
	private String debitMobileNumber;
	
	private String creditMobileNumber;
	
	private String amount;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDebitMobileNumber() {
		return debitMobileNumber;
	}

	public void setDebitMobileNumber(String debitMobileNumber) {
		this.debitMobileNumber = debitMobileNumber;
	}

	public String getCreditMobileNumber() {
		return creditMobileNumber;
	}

	public void setCreditMobileNumber(String creditMobileNumber) {
		this.creditMobileNumber = creditMobileNumber;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	

}
