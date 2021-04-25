package com.innovate.paymob.paymobchatservice.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paymob.common.paymob_common.chatmodel.ChatMessageModel;


@Repository
public interface ChatMessageRepo extends JpaRepository<ChatMessageModel, Long>{
  public List<ChatMessageModel> findBymessageId(Long messageId);
}
