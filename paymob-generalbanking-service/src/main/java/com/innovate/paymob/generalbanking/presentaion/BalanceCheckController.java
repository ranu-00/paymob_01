package com.innovate.paymob.generalbanking.presentaion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.innovate.paymob.service.MobileMoneyService;
import com.paymob.common.paymob_common.responses.TransferResponse;

@RestController
@RequestMapping(path = "/general")
public class BalanceCheckController {

	@Autowired
	TransferResponse response;
	
	@Autowired
	MobileMoneyService moneyBalanceService;
	
	@GetMapping(value = "/home")
	public String testHome() {
		return "home Okay";
	}

	@GetMapping(value = "/checkmoney")
	public TransferResponse checkMoneyBalance(
							@RequestParam(value = "mobileNumber") 
										      Long mobileNumber) {
		TransferResponse response=null;
		try {
			response = moneyBalanceService.checkMobileAccountBalance(mobileNumber);
			System.out.println("checkBalance: All Good | No Error");
		}catch(Exception e){
			//response = new TransferResponse();
			response.setStatus("FAILURE");
			response.setMessage("Something wrong happened in server!!!");
			e.printStackTrace();
		}
		return response;
	}

	
	
}
