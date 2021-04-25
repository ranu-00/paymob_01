package com.innovate.paymob.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paymob.common.paymob_common.entity.MobileAccount;
import com.paymob.common.paymob_common.responses.TransferResponse;
import com.innovate.paymob.constants.CommonConstants;
import com.innovate.paymob.utils.MoneyUtility;

@Service
public class MoneySendService {
	
	@Autowired
	MoneyUtility utility;
	
	@Autowired
	MobileMoneyService mobileAccountService;
	
	@Autowired
	TransferResponse response;
	
	/*
	 * Map<Long, MobileAccount> accounts = null;
	 * 
	 * { if(accounts==null || accounts.size()==0) { accounts = new HashMap<>();
	 * for(int i=0; i<CommonConstants.mobileNumberList.size();i++) {
	 * CommonConstants.accountList.get(i).setMobile(CommonConstants.mobileNumberList
	 * .get(i)); accounts.put(CommonConstants.mobileNumberList.get(i),
	 * CommonConstants.accountList.get(i)); } } }
	 */
	@Transactional
	public TransferResponse transferMoney(Long sender, Long receiver, double amount) {
		
		String message = null;
		Optional<MobileAccount> senderAccount = mobileAccountService.retrieveMobileAccount(sender);
		Optional<MobileAccount> receiverAccount = mobileAccountService.retrieveMobileAccount(receiver);
		if(!senderAccount.isPresent()) {
			message = "Sender Mobile Account "+ sender + " does not exist";
			response.setStatus(CommonConstants.RESPONSE_FAILURE);
			response.setMessage(message);
			return response;
		}
		if(!receiverAccount.isPresent()) {
			message = "Receiver Mobile Account " + receiver + " does not exist";
			response.setStatus(CommonConstants.RESPONSE_FAILURE);
			response.setMessage(message);
			return response;
		}
		
		TransferResponse response = utility.transferMoney(senderAccount.get(), receiverAccount.get(), amount);
		return response;
		
		//////////////////////////////////////////////old one static one below
		
//		TransferResponse response = utility.transferMoney(sender, receiver, amount, accounts);
//		
//		boolean isPaymentHistoryUpdatedForSender = transactionHistoryUpdater.updatePaymentHistory(sender ,amount);
//		if(isPaymentHistoryUpdatedForSender) {
//			System.out.println("Payemnt History updates for Mobile:" + sender + " is successfull.");
//		}else {
//			System.out.println("Payemnt History updates for Mobile:" + sender + " is failure!!!");
//		}
//		
//		boolean isPaymentHistoryUpdatedForReceiver = transactionHistoryUpdater.updatePaymentHistory(receiver ,amount);
//		if(isPaymentHistoryUpdatedForReceiver) {
//			System.out.println("Payemnt History updates for Mobile:" + receiver + " is successfull.");
//		}else {
//			System.out.println("Payemnt History updates for Mobile:" + receiver + " is failure!!!");
//		}
//		return response;
	}

	
	
}
