package com.innovate.paymob.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovate.paymob.businessobjects.ItemsResponse;
import com.innovate.paymob.utility.ItemDataUtils;

@Service
public class ItemsInfoService {

	@Autowired
	ItemDataUtils collectItemInfo;
	
	public ItemsResponse allItemsInfoCategorised(String itemsInfo) {
		return collectItemInfo.allItemsInfo();
	}

}
