package com.innovate.paymob.businessobjects;

import java.io.Serializable;

public class TransactionHistoryUpdateResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean status;
	
	private String mobile;

	public TransactionHistoryUpdateResponse() {
		
	}
	public TransactionHistoryUpdateResponse(boolean status, String mobile){
		this.status = status;
		this.mobile = mobile;
		
	}
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	

}
