package com.innovate.paymob.paymobchatservice.services;

import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.innovate.paymob.paymobchatservice.dto.CategoryServiceDto;

public class CategoryServiceUtility {

	
	public  String getFirstMessage(CategoryServiceDto categoryServicedto) {
		
		 StringJoiner joinedFirstMessage = new StringJoiner("\n", "", "\n");
		   categoryServicedto.fetchAllData().forEach(p -> {
			   joinedFirstMessage.add(p.getCategoryId() + ": "+p.getCategoryDiscription()); 
			    
		   });
		   
		   return joinedFirstMessage.toString();
	}
	
	public String spilitMessage(String s) {		
		return s.substring(s.indexOf(":") + 1, s.indexOf("."));
	}
	
	public static boolean isValidName(String str) {
		String regex = "^[a-zA-Z]+$";
		if (str.matches(regex)) 
		    return true;
		else
			 return false;	
	}
	
	

	public static boolean isValidPhone(String s){ 
	    Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}"); 
	    Matcher m = p.matcher(s); 
	    return (m.find() && m.group().equals(s)); 
	}
	
	public static boolean isValidAmount(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
		
}
