package com.innovate.paymob.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paymob.common.paymob_common.entity.MobileAccount;


@Repository
public interface MobileAccountRepo extends JpaRepository<MobileAccount, Long>{

}
