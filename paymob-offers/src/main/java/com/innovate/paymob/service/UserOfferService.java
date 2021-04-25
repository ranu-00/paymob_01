package com.innovate.paymob.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.innovate.paymob.businessobjects.OfferResponse;
import com.innovate.paymob.dao.OffersDaoRepo;
import com.paymob.common.paymob_common.entity.MobileAccount;

@Service
public class UserOfferService {

	@Autowired
	OffersDaoRepo offerRepo;
	
	@Transactional
	public OfferResponse userAvailableOffers(Long mobile) {

		Optional<MobileAccount> mobAccount = offerRepo.findById(mobile);
		long loanAmount = 0l;
		OfferResponse response = null;
		if(mobAccount.isPresent()) {
			Double amount = mobAccount.get().getUserBankAccount().getAccountBalance();
			if(amount<=5000) {
				loanAmount = 10000l;
			}else if(amount<=20000) {
				loanAmount = 50000l;
			}else if(amount<=50000) {
				loanAmount = 100000l;
			}else if(amount<=100000) {
				loanAmount = 500000l;
			}else if(amount<=150000) {
				loanAmount = 700000l;
			}else if(amount<=200000) {
				loanAmount = 1000000l;
			}
			String OFFER_SUMMARY = "User(" + mobile + ") has offer of loan amount upto " 
									+ loanAmount 
									+ " INR with low cost emi from 1 year to 5 years"
									+", contact your Relationship Manager";
			response = new OfferResponse(mobile, OFFER_SUMMARY);
		}else {
			response = new OfferResponse(mobile, "Mobile Account not found in Bank records!!!");
		}
		return response;
	}

}
