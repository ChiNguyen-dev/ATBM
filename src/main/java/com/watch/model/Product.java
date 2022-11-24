package com.watch.model;

public class Product {
	private String id;
	private String name;
	private String img;
	private boolean male;
	private double price;
	private double basePrice;
	private String desc;
	private String cateId;
	public Product(String id, String name, String img, boolean male, double price, double basePrice, String desc,
			String cateId) {
		super();
		this.id = id;
		this.name = name;
		this.img = img;
		this.male = male;
		this.price = price;
		this.basePrice = basePrice;
		this.desc = desc;
		this.cateId = cateId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public boolean isMale() {
		return male;
	}
	public void setMale(boolean male) {
		this.male = male;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getCateId() {
		return cateId;
	}
	public void setCateId(String cateId) {
		this.cateId = cateId;
	}
	
	
	
}
