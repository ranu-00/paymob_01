package com.innovate.paymob.presentation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paymob.common.paymob_common.responses.TransferResponse;
import com.innovate.paymob.service.MobileMoneyService;
import com.innovate.paymob.service.MoneySendService;

@RestController
@RequestMapping("/rest")
public class TransferController {
	
	@Autowired
	MoneySendService serveTransfer;
	
	@Autowired
	TransferResponse response;
	
	@GetMapping(value = "/transfer")
	public TransferResponse sendMoney(
			@RequestParam(value = "debitMobileNumber") Long sender,
			@RequestParam(value = "creditMobileNumber") Long reciever,
			@RequestParam(value = "amount") double amount
			) {
		try {
			response = serveTransfer.transferMoney(sender, reciever, amount);
			System.out.println("All Good | No Error");
		}catch(Exception e){
			response.setStatus("FAILURE");
			response.setMessage("Something wrong happened in server!!!");
			System.out.println("Something wrong happened in server!!!");
			e.printStackTrace();
		}
		return response;
		
	}

}
