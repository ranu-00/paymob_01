package com.innovate.paymob.paymobchatservice.dto;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovate.paymob.paymobchatservice.repository.CategoryRepo;
import com.paymob.common.paymob_common.chatmodel.ChatCategoryModel;
@Service
public class CategoryServiceDtoImpl implements CategoryServiceDto{

	@Autowired
	CategoryRepo categoryRepo;
	
	@Override
	public boolean save(ChatCategoryModel model) {
		
		ChatCategoryModel chatCategory = categoryRepo.save(model);		
		if (chatCategory != null)
			return true;
		
		return false;
	}

	@Override
	public List<ChatCategoryModel> fetchAllData() {
		return categoryRepo.findAll();
	}

	@Override
	public ChatCategoryModel findByCategoryName(String key) {		
		return categoryRepo.findByCategoryName(key);
	}
	
}
