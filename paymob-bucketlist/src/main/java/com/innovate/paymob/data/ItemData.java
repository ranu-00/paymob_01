package com.innovate.paymob.data;

import java.util.Arrays;
import java.util.List;

import com.innovate.paymob.businessobjects.Category;
import com.innovate.paymob.businessobjects.Item;

public class ItemData {
	
	public static List<Category> categoryList = Arrays.asList(
													new Category(101, "Electronics"),
													new Category(103, "Daily Needs")
													
												);
	public static List<Item> itemList = Arrays.asList(
											new Item(3001, 101, "AC", "Voltas", 35000.00),
											new Item(3002, 101, "Laptop", "Dell", 49000.00),
											new Item(3003, 101, "Mobile", "Samsung", 38000.00),
											new Item(3004, 101, "Mobile", "IPhone", 69000.00),
										
											new Item(3101, 103, "Bread", "Patanjali", 30.00),
											new Item(3102, 103, "Hair Oil", "Patanjali", 50.00),
											new Item(3103, 103, "Toothpaste", "Patanjali", 45.00)
											
										);
	
}
