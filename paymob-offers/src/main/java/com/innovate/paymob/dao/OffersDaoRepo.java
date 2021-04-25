package com.innovate.paymob.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paymob.common.paymob_common.entity.MobileAccount;

@Repository
public interface OffersDaoRepo extends JpaRepository<MobileAccount,Long>{

}
