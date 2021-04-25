package com.innovate.paymob.paymobchatservice.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.paymob.common.paymob_common.chatmodel.CustomerMessage;
@Repository
public interface CustomerMessageRepo extends JpaRepository<CustomerMessage, Long>{
	
	@Query(value = "SELECT c FROM CustomerMessage c where c.messageCategoryId = :messageCategoryId and c.mobileNumber =:mobileNumber")   
	
	public CustomerMessage findByCatIdAndMobileNumber(@Param("messageCategoryId") Long messageCategoryId,@Param("mobileNumber") String mobileNumber);

	@Modifying
	@Query("update CustomerMessage u set u.chatMessageId = :chatMessageId where u.messageCategoryId = :messageCategoryId and u.mobileNumber=:mobileNumber")
	
	public void updateCustomerMessage(@Param("chatMessageId")Long chatMessageId,@Param("messageCategoryId") Long messageCategoryId, @Param("mobileNumber")String mobileNumber);

	public List<CustomerMessage> findBymobileNumber(String mobileNumber);
	
	
	@Modifying
	@Query("update CustomerMessage u set u.amount = :amount where u.chatMessageId = :chatMessageId")
	
	public void updateSenderamount(@Param("chatMessageId")Long chatMessageId,@Param("amount") String amount);

}
