package com.watch.model;

public class OrderDetails {
	private int id;
	private Product product;
	private int quantity; 
	public OrderDetails() {
		// TODO Auto-generated constructor stub
	}
	public OrderDetails(int id, Product product, int quantity) {
		super();
		this.id = id;
		this.product = product;
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", product=" + product + ", quantity=" + quantity + "]";
	}
	public double getDetailsTotal() {
		return this.quantity * this.product.getPrice();
	}
	
	
	
}
