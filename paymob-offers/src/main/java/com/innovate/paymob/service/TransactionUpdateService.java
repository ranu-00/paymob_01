package com.innovate.paymob.service;

import org.springframework.stereotype.Service;

import com.innovate.paymob.businessobjects.TransactionHistoryUpdateResponse;
import com.innovate.paymob.constants.InitialPaymentHistory;

@Service
public class TransactionUpdateService {

	public TransactionHistoryUpdateResponse updateTransactionHistory(Long mobile, double amount) throws Exception {
		TransactionHistoryUpdateResponse response = null;
		if(InitialPaymentHistory.transactionHistory.get(mobile)!=null) {
			InitialPaymentHistory.transactionHistory.put(mobile, 
					(long)amount + InitialPaymentHistory.transactionHistory.get(mobile));
			response = new TransactionHistoryUpdateResponse(true, String.valueOf(mobile));
		}else {
			throw new Exception("Mobile Number account not found!!!");
		}
		return response;
	}

}
