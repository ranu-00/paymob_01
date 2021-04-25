package com.innovate.paymob.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.paymob.common.paymob_common.responses.TransferResponse;
import com.paymob.common.paymob_common.constants.CommonConstants;
import com.paymob.common.paymob_common.entity.MobileAccount;

@Component
public class MoneyUtility {

	@Autowired
	TransferResponse response;
	
	public TransferResponse transferMoney(MobileAccount senderMobAcct, MobileAccount receiverMobAcct, double amount) {
		
		senderMobAcct.getUserBankAccount().setAccountBalance(senderMobAcct.getUserBankAccount().getAccountBalance()-amount);
		receiverMobAcct.getUserBankAccount().setAccountBalance(receiverMobAcct.getUserBankAccount().getAccountBalance()+amount);
		
		/*
		 * OPF/CBIS or else API to call core bank to update balances. 
		 */
		response.setStatus(CommonConstants.RESPONSE_SUCCESS);
		response.setMessage("Money Transfer from "+ senderMobAcct.getMobileNumber() + " to " + receiverMobAcct.getMobileNumber()
							+ " is successful, Current Balance is: " + senderMobAcct.getUserBankAccount().getAccountBalance() 
							+ " " + senderMobAcct.getUserBankAccount().getBank().getCurrency());
		return response;
	}
//	@Transactional
//	public TransferResponse transferMoney(Long sender, Long receiver, double amount
//										  , Map<Long, MobileAccount> ) {
//		MobileAccount senderAcct = accounts.get(sender);
//		MobileAccount receiverAcct = accounts.get(receiver);
//		TransferResponse response = new TransferResponse();
//		if(senderAcct==null ||  receiverAcct==null) {
//			response.setStatus("FAILURE");
//			response.setMessage("Money Transfer is unsuccessful, since Sender or Receiver Mobile Account not found!!!");
//		}else {
//			
//			SendMoneyDemoModel model = new SendMoneyDemoModel();
//			model.setAmount("Rahul");
//			model.setReciver("Sunil");
//			model.setAmount("1200");
//			repo.save(model);
//			senderAcct.setAmountBalance(senderAcct.getAmountBalance()-amount);
//			senderAcct.setTransactionHistory(senderAcct.getTransactionHistory()+(long)amount);
//			
//			receiverAcct.setAmountBalance(receiverAcct.getAmountBalance()+amount);
//			receiverAcct.setTransactionHistory(receiverAcct.getTransactionHistory()+(long)amount);
//			
//			response.setStatus("SUCCESS");
//			response.setMessage("Money Transfer is successful, Current Balance is: " + senderAcct.getAmountBalance() + " INR");
//		}
//		
//		return response;
//	}

	
}
