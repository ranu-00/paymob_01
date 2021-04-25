package com.innovate.paymob.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.innovate.paymob.businessobjects.ItemsResponse;
import com.innovate.paymob.service.ItemsInfoService;

@RestController
@RequestMapping("/bucket")
public class BucketItemController {
	
	@Autowired
	ItemsInfoService serveItemsInfo;
	
	@PostMapping(value = "/bucketListItems")
	public ItemsResponse sendMoney(
			@RequestParam(value = "itemsInfo") String itemsInfo
			) {
		ItemsResponse response=null;
		try {
			response = serveItemsInfo.allItemsInfoCategorised(itemsInfo);
			System.out.println("All Good | No Error");
		}catch(Exception e){
			/*
			 * response = new ItemsResponse(); response.setStatus("FAILURE");
			 * response.setMessage("Something wrong happened in server!!!");
			 */			e.printStackTrace();
		}
		return response;
		
	}

}
