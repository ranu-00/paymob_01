package com.innovate.paymob.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.innovate.paymob.businessobjects.TransactionHistoryUpdateResponse;
import com.innovate.paymob.service.TransactionUpdateService;

@RestController
@RequestMapping("/rest")
public class TransactionUpdateController {
	
	@Autowired
	TransactionUpdateService servePayemtHistory;
	
	@PostMapping(value = "/payHistory")
	public TransactionHistoryUpdateResponse updatePaymentHistory(
			@RequestParam(value = "mobile") Long mobile,
			@RequestParam(value = "amount") double amount
			) {
		TransactionHistoryUpdateResponse response = null;
		try {
			response = servePayemtHistory.updateTransactionHistory(mobile, amount);
			if(response.isStatus()) {
				System.out.println("Payment History Updated successfully!!!");
			}
		}catch(Exception e){
			response = new TransactionHistoryUpdateResponse(false, String.valueOf(mobile));
			e.printStackTrace();
		}
		return response;
	}

}
