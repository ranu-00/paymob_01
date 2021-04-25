package com.innovate.paymob.paymobchatservice.dto;
import java.util.List;

import com.paymob.common.paymob_common.chatmodel.ChatCategoryModel;


public interface CategoryServiceDto {
    public boolean save(ChatCategoryModel model);	
	public List<ChatCategoryModel> fetchAllData();
	public ChatCategoryModel findByCategoryName(String key);
}
