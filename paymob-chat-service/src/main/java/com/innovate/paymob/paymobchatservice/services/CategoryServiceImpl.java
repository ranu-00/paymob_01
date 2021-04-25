package com.innovate.paymob.paymobchatservice.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.innovate.paymob.paymobchatservice.businessobjects.ItemsResponse;
import com.innovate.paymob.paymobchatservice.businessobjects.OfferResponse;
import com.innovate.paymob.paymobchatservice.businessobjects.SenderResponse;
import com.innovate.paymob.paymobchatservice.constants.CommonConstant;
import com.innovate.paymob.paymobchatservice.dto.CategoryServiceDto;
import com.innovate.paymob.paymobchatservice.dto.ChatMessageDto;
import com.innovate.paymob.paymobchatservice.dto.CustomerMessageDto;
import com.paymob.common.paymob_common.chatmodel.ChatMessageModel;
import com.paymob.common.paymob_common.chatmodel.CustomerMessage;
import com.paymob.common.paymob_common.responses.TransferResponse;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
@RefreshScope
public class CategoryServiceImpl implements CategoryService{

	@Value(value="${whatsapp.firstmessage}")
	private String firstMessage;
	@Autowired
	private CategoryServiceDto categoryServicedto;
	
	@Autowired
	private CustomerMessageDto customerMessageDto;
	
	@Autowired
	private ChatMessageDto chatMessageDto;
	
	@Value(value="${url.moneyTransfer}")
	private String SEND_MONEY_MICRO_SERVICE_URL;
	
	@Value(value="${url.offer}")
	private String OFFERS_MICRO_SERVICE_URL;
	@Value(value="${url.bucketList}")
	private String BUCKET_LIST_MICRO_SERVICE_URL;
	
	@Value(value="${whatsapp.mobilenumber}")
	private String whatsappMobileNumber;
	
	@Value(value="${whatsapp.twilio}")
	private String twilioNumber;
	
	
	@Override
	public String getResponse(Message receiveObj,String mobileNumber) {
		 Twilio.init(CommonConstant.ACCOUNT_SID, CommonConstant.AUTH_TOKEN);
		 String receiveMessage = receiveObj.getBody();	
		 CategoryServiceUtility utility = new CategoryServiceUtility();
		 List<CustomerMessage> listMessage = customerMessageDto.findBymobileNumber(mobileNumber);
		   if(receiveMessage.toLowerCase().contains("JoinFisPaymobBanking".toLowerCase()) || receiveMessage.toLowerCase().contains("exit".toLowerCase())) {
			   CustomerMessage historyModel = new CustomerMessage();
			   if(receiveMessage.toLowerCase().contains("exit".toLowerCase())) {
				   // delete user created session
				   Message sendMessageObj =Message
						   .creator(new PhoneNumber("whatsapp:+91"+whatsappMobileNumber), // to
				                   new PhoneNumber("whatsapp:+"+twilioNumber), 
				                   "Operation terminated! Please rejoin visa Fis code JoinFisPaymobBanking")
				           .create();
				   historyModel.setMobileNumber(whatsappMobileNumber);
				   historyModel.setMessageDesc("Operation terminated! Please rejoin visa Fis code JoinFisPaymobBanking");
				   customerMessageDto.deleteBatch(customerMessageDto.findBymobileNumber(whatsappMobileNumber));
				   
			   }else {
				  
				   Message sendMessageObj =Message
						   .creator(new PhoneNumber("whatsapp:+91"+whatsappMobileNumber), // to
				                   new PhoneNumber("whatsapp:+"+twilioNumber), 
				                   utility.getFirstMessage(categoryServicedto))
				           .create();
				
				   historyModel.setMobileNumber(whatsappMobileNumber);
				   historyModel.setMessageDesc(utility.getFirstMessage(categoryServicedto));
				   customerMessageDto.save(historyModel);
			   }
			   
		
			   
		   }else if("1".equals(receiveMessage.replaceAll("[^0-9]", "")) || (0 < customerMessageDto.findBymobileNumber(whatsappMobileNumber).size())) {
			   
			   
			   List<ChatMessageModel> listAllMessage = chatMessageDto.findAll();
			   int length = customerMessageDto.findBymobileNumber(whatsappMobileNumber).size();
			   
			   
			   
			   CustomerMessage historyModel = new CustomerMessage();
			   if("1".equals(receiveMessage))			   
			   Message
			   .creator(new PhoneNumber("whatsapp:+91"+whatsappMobileNumber), // to
	                   new PhoneNumber("whatsapp:+"+twilioNumber), 
	                   "You have Choosed Transfer money")
	           .create(); 
			   SenderResponse senderResp = new SenderResponse();
			   if("yes".equals(receiveMessage.toLowerCase())) {
				   List<CustomerMessage> list = customerMessageDto.findBymobileNumber(whatsappMobileNumber);
				   list.forEach(p-> {
					   if("SenderName".equals(p.getSenderField()))
						   senderResp.setName(p.getSenderDetails());
					   else if("SenderNumber".equals(p.getSenderField()))
						   senderResp.setCreditMobileNumber(p.getSenderDetails());
					   else if("SenderAmount".equals(p.getSenderField()))
						   senderResp.setAmount(p.getSenderDetails());
					   else
						   senderResp.setDebitMobileNumber(whatsappMobileNumber);
					   });			   
				   
				   CategoryServiceImpl ctl = new CategoryServiceImpl();
				   try {
					   TransferResponse resp = ctl.callSendMoneyMicroService(SEND_MONEY_MICRO_SERVICE_URL,senderResp.getDebitMobileNumber(), senderResp.getCreditMobileNumber(), senderResp.getAmount());
					   Message
					   .creator(new PhoneNumber("whatsapp:+91"+whatsappMobileNumber), // to
			                   new PhoneNumber("whatsapp:+"+twilioNumber), 
			                   resp.getMessage())
			           .create(); 
					   
				   }catch (Exception e) {
					// Connection refused
					   Message
					   .creator(new PhoneNumber("whatsapp:+91"+whatsappMobileNumber), // to
			                   new PhoneNumber("whatsapp:+"+twilioNumber), 
			                   e.getMessage())
			           .create(); 
				}
				try {
					   TransferResponse resp = ctl.callSendMoneyMicroService(SEND_MONEY_MICRO_SERVICE_URL,senderResp.getDebitMobileNumber(), senderResp.getCreditMobileNumber(), senderResp.getAmount());
					   Message
					   .creator(new PhoneNumber("whatsapp:+91"+whatsappMobileNumber), // to
			                   new PhoneNumber("whatsapp:+"+twilioNumber), 
			                   resp.getMessage())
			           .create(); 
				} catch (Exception e) {
					// connection refused sendmoney service not working
					 Message
					   .creator(new PhoneNumber("whatsapp:+91"+whatsappMobileNumber), // to
			                   new PhoneNumber("whatsapp:+"+twilioNumber), 
			                   "Connection refused sendmoney is down")
			           .create(); 
				}
			   }else {
                 if("SenderName".equals(CommonConstant.fields.get(length-1))) {
					   
					   if(CategoryServiceUtility.isValidName(receiveMessage)) {
						   Message
						   .creator(new PhoneNumber("whatsapp:+91"+whatsappMobileNumber), // to
				                   new PhoneNumber("whatsapp:+"+twilioNumber), 
				                   listAllMessage.get(length-1).getMessage())
				           .create(); 
						   historyModel.setChatMessageId(1L);
						   historyModel.setMessageCategoryId(Long.valueOf(""+length));
						   historyModel.setMobileNumber(whatsappMobileNumber);
						   historyModel.setSenderDetails(receiveMessage);
						   historyModel.setMessageDesc(listAllMessage.get(length-1).getMessage());
						   historyModel.setSenderField(CommonConstant.fields.get(length-1));
						   customerMessageDto.save(historyModel);  
					   }else {
						   Message
						   .creator(new PhoneNumber("whatsapp:+91"+whatsappMobileNumber), // to
				                   new PhoneNumber("whatsapp:+"+twilioNumber), 
				                   "SenderName must be Alphbatic")
				           .create(); 
					   }
					  
					   
				   }					   
				   else if("SenderNumber".equals(CommonConstant.fields.get(length-1))) {
					   if(CategoryServiceUtility.isValidPhone(receiveMessage)) {
					   Message
					   .creator(new PhoneNumber("whatsapp:+91"+whatsappMobileNumber), // to
			                   new PhoneNumber("whatsapp:+"+twilioNumber), 
			                   listAllMessage.get(length-1).getMessage())
			           .create(); 
					   historyModel.setChatMessageId(1L);
					   historyModel.setMessageCategoryId(Long.valueOf(""+length));
					   historyModel.setMobileNumber(whatsappMobileNumber);
					   historyModel.setSenderDetails(receiveMessage);
					   historyModel.setMessageDesc(listAllMessage.get(length-1).getMessage());
					   historyModel.setSenderField(CommonConstant.fields.get(length-1));
					   customerMessageDto.save(historyModel);
					   }else {
						   Message
						   .creator(new PhoneNumber("whatsapp:+91"+whatsappMobileNumber), // to
				                   new PhoneNumber("whatsapp:+"+twilioNumber), 
				                   "SenderNumber must be Numeric")
				           .create();  
					   }
				   }					  
				   else if("SenderAmount".equals(CommonConstant.fields.get(length-1))){
					   if(CategoryServiceUtility.isValidAmount(receiveMessage)) {
						   Message
						   .creator(new PhoneNumber("whatsapp:+91"+whatsappMobileNumber), // to
				                   new PhoneNumber("whatsapp:+"+twilioNumber), 
				                   listAllMessage.get(length-1).getMessage().replace("{1}", receiveMessage))
				           .create(); 
						   historyModel.setChatMessageId(1L);
						   historyModel.setMessageCategoryId(Long.valueOf(""+length));
						   historyModel.setMobileNumber(whatsappMobileNumber);
						   historyModel.setSenderDetails(receiveMessage);
						   historyModel.setMessageDesc(listAllMessage.get(length-1).getMessage());
						   historyModel.setSenderField(CommonConstant.fields.get(length-1));
						   customerMessageDto.save(historyModel);  
					   }else {
						   Message
						   .creator(new PhoneNumber("whatsapp:+91"+whatsappMobileNumber), // to
				                   new PhoneNumber("whatsapp:+"+twilioNumber), 
				                   "Please Enter valid amount")
				           .create();  
					   }
					   
				   }else {
					   {
						   Message
						   .creator(new PhoneNumber("whatsapp:+91"+whatsappMobileNumber), // to
				                   new PhoneNumber("whatsapp:+"+twilioNumber), 
				                   listAllMessage.get(length-1).getMessage())
				           .create(); 
						   historyModel.setChatMessageId(1L);
						   historyModel.setMessageCategoryId(Long.valueOf(""+length));
						   historyModel.setMobileNumber(whatsappMobileNumber);
						   historyModel.setSenderDetails(receiveMessage);
						   historyModel.setMessageDesc(listAllMessage.get(length-1).getMessage());
						   historyModel.setSenderField(CommonConstant.fields.get(length-1));
						   customerMessageDto.save(historyModel);
					   }
				   }
			   }
		   
		   }else if("2".equals(receiveMessage.replaceAll("[^0-9]", ""))) { //bucketList
				   
		   }else if("3".equals(receiveMessage.replaceAll("[^0-9]", ""))) { //offer and loan
				   
			   
		   }else if("4".equals(receiveMessage.replaceAll("[^0-9]", ""))) { //general banking
			   
			   
	       }else {
			   Message sendMessageObj =Message
					   .creator(new PhoneNumber("whatsapp:+91"+whatsappMobileNumber), // to
			                   new PhoneNumber("whatsapp:+"+twilioNumber), 
			                   "Invalid Response please type exit and join visa Fis code JoinFisPaymobBanking or provide valid input Thanks!")
			           .create();  
			   
		   }
		
			   
		   
		return receiveMessage;
	}
	

	public TransferResponse callSendMoneyMicroService(String urlString,String debitMobileNumber,
				String creditMobileNumber
				, String amount) {
	RestTemplate restTemplate = new RestTemplate();
	TransferResponse response = restTemplate.getForObject(
			urlString+"?debitMobileNumber="+Long.valueOf(debitMobileNumber)+"&creditMobileNumber="+Long.valueOf(creditMobileNumber)+"&amount="+Double.valueOf(amount)+"", 
		  TransferResponse.class);
	return response;
	}
	
	
	//Sample Case Method to call OFFERS MICRO_SERVICE
	public OfferResponse callOffersMicroService(Long mobile) {
		OfferResponse response =null;
		UriComponentsBuilder builder = UriComponentsBuilder
			    						.fromUriString(OFFERS_MICRO_SERVICE_URL)
									    // Add query parameter
									    .queryParam("mobile", mobile);

		RestTemplate restTemplate = new RestTemplate();
		response = restTemplate.postForObject(
								 builder.toUriString(), null, OfferResponse.class);
		return response;
	}
		
	//Sample Case Method to call BucketList MICRO_SERVICE
	public ItemsResponse callBucketListMicroService(String itemsInfo) {
		ItemsResponse response =null;
		UriComponentsBuilder builder = UriComponentsBuilder
			    						.fromUriString(BUCKET_LIST_MICRO_SERVICE_URL)
									    // Add query parameter
									    .queryParam("itemsInfo", itemsInfo);

		RestTemplate restTemplate = new RestTemplate();
		response = restTemplate.postForObject(
								 builder.toUriString(), null, ItemsResponse.class);
		return response;
	}
}
