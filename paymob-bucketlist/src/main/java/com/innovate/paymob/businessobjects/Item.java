package com.innovate.paymob.businessobjects;

public class Item {
	
	private int itemCode;
	private int categoryCode;
	
	private String name;
	private String brand;
	private double price;
	
	public Item(int itemCode, int categoryCode, String name, String brand, double price) {
		this.itemCode = itemCode;
		this.categoryCode = categoryCode;
		this.name = name;
		this.brand = brand;
		this.price = price;
	}
	public Item() {
		super();
	}
	
	public int getItemCode() {
		return itemCode;
	}
	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}
	public int getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
