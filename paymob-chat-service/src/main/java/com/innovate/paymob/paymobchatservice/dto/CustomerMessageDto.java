package com.innovate.paymob.paymobchatservice.dto;

import java.util.List;

import com.paymob.common.paymob_common.chatmodel.CustomerMessage;


public interface CustomerMessageDto {
	public CustomerMessage findByCatIdAndMobileNumber(Long messageCategoryId,String mobileNumber);

	public void updateCustomerMessage(Long chatMessageId, Long messageCategoryId, String mobileNumber);
	 public CustomerMessage save(CustomerMessage model);
		public List<CustomerMessage> findBymobileNumber(String mobileNumber);
		public void updateSenderamount(Long chatMessageId,String amount);
		public void delete(CustomerMessage chat);

		public void deleteBatch(Iterable<CustomerMessage> entities);
		

}
