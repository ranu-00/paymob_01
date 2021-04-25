package com.innovate.paymob.paymobchatservice.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paymob.common.paymob_common.chatmodel.ChatCategoryModel;

@Repository
public interface CategoryRepo extends JpaRepository<ChatCategoryModel, Long> {

	public ChatCategoryModel findByCategoryName(String key);
}
