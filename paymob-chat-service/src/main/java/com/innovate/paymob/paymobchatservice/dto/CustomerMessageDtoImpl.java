package com.innovate.paymob.paymobchatservice.dto;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovate.paymob.paymobchatservice.repository.CustomerMessageRepo;
import com.paymob.common.paymob_common.chatmodel.CustomerMessage;
@Service
public class CustomerMessageDtoImpl implements CustomerMessageDto{
    @Autowired
	private CustomerMessageRepo customerMessageRepo;
	
	@Override
	public CustomerMessage findByCatIdAndMobileNumber(Long messageCategoryId, String mobileNumber) {
		// TODO Auto-generated method stub
		return customerMessageRepo.findByCatIdAndMobileNumber(messageCategoryId, mobileNumber);
	}

	@Override
	@Transactional
	public void updateCustomerMessage(Long chatMessageId, Long messageCategoryId, String mobileNumber) {
		customerMessageRepo.updateCustomerMessage(chatMessageId, messageCategoryId, mobileNumber);
	}

	@Override
	@Transactional
	public CustomerMessage save(CustomerMessage model) {
		// TODO Auto-generated method stub
		return customerMessageRepo.save(model);
	}

	@Override
	public List<CustomerMessage> findBymobileNumber(String mobileNumber) {
		// TODO Auto-generated method stub
		return customerMessageRepo.findBymobileNumber(mobileNumber);
	}

	@Override
	@Transactional
	public void updateSenderamount(Long chatMessageId, String amount) {
		// TODO Auto-generated method stub
		customerMessageRepo.updateSenderamount(chatMessageId, amount);
		
	}

	@Override
	@Transactional
	public void delete(CustomerMessage chat) {
		// TODO Auto-generated method stub
		
		customerMessageRepo.delete(chat);
		
	}
	@Override
	@Transactional
	public void deleteBatch(Iterable<CustomerMessage> entities) {
		// TODO Auto-generated method stub
		
		customerMessageRepo.deleteInBatch(entities);
		
	}


	
}
