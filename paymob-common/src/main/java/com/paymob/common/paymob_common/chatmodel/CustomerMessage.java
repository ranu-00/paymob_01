package com.paymob.common.paymob_common.chatmodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pay_mob_customer_message")
public class CustomerMessage {
	@Id
	@GeneratedValue
	private Long id;
	
	private String mobileNumber;
	
	private Long messageCategoryId;
	
	private Long chatMessageId;
	
	private String senderDetails;
	
    private String senderField;
	
	private String amount;
	
	private String messageDesc;	
	
	
	
	public String getSenderField() {
		return senderField;
	}

	public void setSenderField(String senderField) {
		this.senderField = senderField;
	}

	public String getSenderDetails() {
		return senderDetails;
	}

	public void setSenderDetails(String senderDetails) {
		this.senderDetails = senderDetails;
	}

	public String getMessageDesc() {
		return messageDesc;
	}

	public void setMessageDesc(String messageDesc) {
		this.messageDesc = messageDesc;
	}




	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Long getMessageCategoryId() {
		return messageCategoryId;
	}

	public void setMessageCategoryId(Long messageCategoryId) {
		this.messageCategoryId = messageCategoryId;
	}

	public Long getChatMessageId() {
		return chatMessageId;
	}

	public void setChatMessageId(Long chatMessageId) {
		this.chatMessageId = chatMessageId;
	}

	
}
