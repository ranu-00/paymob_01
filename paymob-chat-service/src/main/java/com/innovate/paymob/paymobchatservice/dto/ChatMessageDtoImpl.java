package com.innovate.paymob.paymobchatservice.dto;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovate.paymob.paymobchatservice.repository.ChatMessageRepo;
import com.paymob.common.paymob_common.chatmodel.ChatMessageModel;

@Service
public class ChatMessageDtoImpl implements ChatMessageDto{

	@Autowired
	private ChatMessageRepo chatMessageRepo;
	
	@Override
	public List<ChatMessageModel> findAll() {
		// TODO Auto-generated method stub
		return chatMessageRepo.findAll();
	}
	
	@Override
	public List<ChatMessageModel> findByMessageId(Long messageId) {
		// TODO Auto-generated method stub
		return  chatMessageRepo.findBymessageId(messageId);
	}

	
}
