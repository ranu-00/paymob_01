package com.innovate.paymob.paymobchatservice.services;
import java.util.List;

import com.paymob.common.paymob_common.chatmodel.ChatCategoryModel;
import com.twilio.rest.api.v2010.account.Message;

public interface CategoryService {
	
	public String getResponse(Message message,String mobileNumber);

}
