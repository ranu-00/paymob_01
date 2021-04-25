package com.innovate.paymob.utility;

import org.springframework.stereotype.Component;

import com.innovate.paymob.businessobjects.Category;
import com.innovate.paymob.businessobjects.Item;
import com.innovate.paymob.businessobjects.ItemsResponse;
import com.innovate.paymob.data.ItemData;

@Component
public class ItemDataUtils {
	
	public ItemsResponse allItemsInfo() {
		
		ItemsResponse response = new ItemsResponse();
		
		for(Category category : ItemData.categoryList) {
			for(Item item : ItemData.itemList) {
				if(category.getCategoryCode()==item.getCategoryCode()) {
					category.getItems().add(item);
				}
			}
		}
		response.setCategory(ItemData.categoryList);
		
		return response;
	}

}
