package com.paymob.common.paymob_common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="pay_mob_bank")
public class Bank {

	@Id
	//@SequenceGenerator(name = "hibernate_seq_sendmoney", sequenceName = "hibernate_id_seq_sendmoney", allocationSize = 10000)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_seq_sendmoney")
	@Column(name="bank_id")
	private long bankId;
	
	@Column(name="bank_name")
	private String bankName;
	
	@Column(name="bank_code")
	private String bankCode;
	
	@Column(name="ifsc_code")
	private String ifscCode;
	
	@Column(name="currency")
	private String currency;
	
	//constructors
	Bank(){
	}

	public Bank(long bankId, String bankName, String bankCode, String ifscCode, String currency) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
		this.bankCode = bankCode;
		this.ifscCode = ifscCode;
		this.currency = currency;
	}
		
	//getters & setters
	public long getBankId() {
		return bankId;
	}

	public void setBankId(long bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getIfscCode() {
		return this.ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
