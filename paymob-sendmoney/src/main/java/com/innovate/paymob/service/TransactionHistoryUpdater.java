package com.innovate.paymob.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.innovate.paymob.businessobjects.TransactionHistoryUpdateResponse;

@Service
public class TransactionHistoryUpdater {

	public static final String PAYMENT_HISTORY_SERVICE_URL 
						= "http://localhost:8099/PaymentHistoryApp/rest/payHistory";
	public boolean updatePaymentHistory(Long mobile, double amount) {
		
		return restPostAmountToUpdatePaymentHistory(mobile, amount);		
	}
	
	public boolean restPostAmountToUpdatePaymentHistory(Long mobile, double amount) {
		boolean flag = false;
		UriComponentsBuilder builder = UriComponentsBuilder
			    						.fromUriString(PAYMENT_HISTORY_SERVICE_URL)
									    // Add query parameter
									    .queryParam("mobile", mobile)
									    .queryParam("amount", amount);

			RestTemplate restTemplate = new RestTemplate();
			TransactionHistoryUpdateResponse response = restTemplate.postForObject(
														builder.toUriString(), null, TransactionHistoryUpdateResponse.class);
			flag = response.isStatus();
			return flag;
		
	}

}
