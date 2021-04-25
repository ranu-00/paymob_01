package com.innovate.paymob.paymobchatservice;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.innovate.paymob.paymobchatservice.services.CategoryService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
@RestController
@RequestMapping(value="/chat")
public class Controller {
	  private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

	@Autowired
	private CategoryService categoryService;
	   public static final String ACCOUNT_SID = "AC816cefacab21575348571763119cb742";
	    public static final String AUTH_TOKEN = "64721ee98ab68d30e73956ac2158c92e";
	
	@RequestMapping(value="/fetch",method =RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public String getAllCategory(){
		Message message = null;
		   LOGGER.trace("doStuff needed more information - {}");
		    LOGGER.debug("doStuff needed to debug - {}");
		    LOGGER.info("doStuff took input - {}");
		    LOGGER.warn("doStuff needed to warn - {}");
		    LOGGER.error("doStuff encountered an error with value - {}");
		
		return "sdfs";
	}
	
	@RequestMapping(value="/fetchOne", method=RequestMethod.POST)
	public String getCategoryData(RequestEntity<String> req){
		String message1 =  req.getBody();
		Map<String, String[]>  map = getParamsFromQueryString(message1);
		 Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		
		String[] str = map.get("SmsSid");
		
		  Message message = Message.fetcher(str[0])
		            .fetch();
		  String[] smsStatus = map.get("SmsStatus");
		  
		 
		  System.out.println(message.getDirection().toString());
		  
		  
		  if("read".equalsIgnoreCase(smsStatus[0]) && !"delivered".equalsIgnoreCase(smsStatus[0]) && !"sent".equalsIgnoreCase(smsStatus[0]) && "outbound-reply".equalsIgnoreCase(message.getDirection().toString()) && !"outbound-api".equalsIgnoreCase(message.getDirection().toString())) {
			 // String[] mobileNumber = map.get("SmsStatus");
			  categoryService.getResponse(message,"8010580426");
		  }
		
		return "Ok";
	}
	 private Map<String, String[]> getParamsFromQueryString(final String queryString) {
         String decoded = "";
         try {
             decoded = URLDecoder.decode(queryString, "UTF-8");
         } catch (UnsupportedEncodingException e) {
             e.printStackTrace();
         }
         String[] params = decoded.split("&");
         Map<String, List<String>> collect = Stream.of(params)
             .map(x -> x.split("="))
             .collect(Collectors.groupingBy(
                 x -> x[0],
                 Collectors.mapping(
                     x -> x.length > 1 ? x[1] : null,
                     Collectors.toList())));

         Map<String, String[]> result = collect.entrySet().stream()
             .collect(Collectors.toMap(
                 x -> x.getKey(),
                 x -> x.getValue()
                     .stream()
                     .toArray(String[]::new)));

         return result;
     }
}
