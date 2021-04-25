package com.paymob.common.paymob_common.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="pay_mob_bank_account")
public class UserBankAccount {
	
	
	@Id
	@Column(name="account_number")
	private Long accountNumber;
	
	@Column(name="account_balance")
	private double accountBalance;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bank_id", referencedColumnName = "bank_id")
	Bank bank;
	
	//constructors
	public UserBankAccount(){
	}
	public UserBankAccount(Long accountNumber, double accountBalance, String firstName, String lastName, Bank bank) {
		super();
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
		this.firstName = firstName;
		this.lastName = lastName;
		this.bank = bank;
	}

	//getters & setters
	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

}
