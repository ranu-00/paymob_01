package com.innovate.paymob.paymobchatservice.dto;

import java.util.List;

import com.paymob.common.paymob_common.chatmodel.ChatMessageModel;

public interface ChatMessageDto {
		 
	 public List<ChatMessageModel> findAll();
	 
	 public List<ChatMessageModel> findByMessageId(Long messageId);

}
