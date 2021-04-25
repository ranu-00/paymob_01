package com.innovate.paymob.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.innovate.paymob.businessobjects.OfferResponse;
import com.innovate.paymob.service.TransactionUpdateService;
import com.innovate.paymob.service.UserOfferService;

@RestController
@RequestMapping("/rest")
public class UserOfferController {
	
	@Autowired
	UserOfferService userOfferService;
	
	@PostMapping(value = "/userOffer")
	public OfferResponse userOffers(@RequestParam(value = "mobile") Long mobile) {
		OfferResponse response =null;
		try {
			response = userOfferService.userAvailableOffers(mobile);
		}catch(Exception e){
			e.printStackTrace();
			response = new OfferResponse(mobile, "Something wrong happened in server");
		}
		return response;
	}

}
