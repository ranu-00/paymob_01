package com.innovate.paymob.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.innovate.paymob.repo.MobileAccountRepo;
import com.paymob.common.paymob_common.constants.CommonConstants;
import com.paymob.common.paymob_common.entity.MobileAccount;
import com.paymob.common.paymob_common.responses.TransferResponse;

@Service
public class MobileMoneyService {
	@Autowired(required=true)
	MobileAccountRepo mobileAccountRepo;
	
	@Autowired
	TransferResponse response;
	
	private static final String ACCOUNT_NOT_FOUND = "User Mobile Account not found in database!!!";

	@Transactional
	public TransferResponse checkMobileAccountBalance(Long mobileNumber) {

		Optional<MobileAccount> mobileAccount = mobileAccountRepo.findById(mobileNumber);
		if(!mobileAccount.isPresent()) {
			response.setStatus(CommonConstants.RESPONSE_FAILURE);
			response.setMessage(ACCOUNT_NOT_FOUND);
		}else {
			double currentBalance = mobileAccount.get().getUserBankAccount().getAccountBalance();
			String balanceFound = "Current balance is: "+currentBalance;
			response.setStatus(CommonConstants.RESPONSE_SUCCESS);
			response.setMessage(balanceFound);
		}
		return response;
	}

}
