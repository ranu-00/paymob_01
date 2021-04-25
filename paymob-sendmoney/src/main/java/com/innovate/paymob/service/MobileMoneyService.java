package com.innovate.paymob.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovate.paymob.repo.MobileAccountRepo;
import com.paymob.common.paymob_common.entity.MobileAccount;

@Service
public class MobileMoneyService {
	@Autowired
	MobileAccountRepo mobileAccountRepo;

	public Optional<MobileAccount> retrieveMobileAccount(Long mobileNumber) {

		return mobileAccountRepo.findById(mobileNumber);
	}
	
	
	

}
