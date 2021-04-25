package com.paymob.common.paymob_common.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="pay_mob_mobile_account")
public class MobileAccount {
	
	@Id
	@Column(name="mobile_number")
	private long mobileNumber;
	
	@Column
	private String name;
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_number", referencedColumnName = "account_number")
    UserBankAccount userBankAccount;
	
    //constructors 
  	public MobileAccount(){
  	}

  	public MobileAccount(long mobileNumber, String name, UserBankAccount userBankAccount) {
  		super();
  		this.mobileNumber = mobileNumber;
  		this.name = name;
  		this.userBankAccount = userBankAccount;
  	}
  	
	//getters & setters
	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserBankAccount getUserBankAccount() {
		return userBankAccount;
	}

	public void setUserBankAccount(UserBankAccount userBankAccount) {
		this.userBankAccount = userBankAccount;
	}

}
