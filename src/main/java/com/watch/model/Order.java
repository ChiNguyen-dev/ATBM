package com.watch.model;
import java.sql.Date;

import java.util.List;

public class Order {
	private int id;
	private List<OrderDetails> orderDetails;
	private Date placeDate;
	private String username;
	public Order() {
		// TODO Auto-generated constructor stub
	}
	public Order(int id, List<OrderDetails> orderDetails, Date placeDate, String string) {
		super();
		this.id = id;
		this.orderDetails = orderDetails;
		this.placeDate = placeDate;
		this.username = string;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}
	public Date getPlaceDate() {
		return placeDate;
	}
	public void setPlaceDate(Date placeDate) {
		this.placeDate = placeDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public double getTotalOrder() {
		double total = 0.0;
		for (OrderDetails element : orderDetails) {
			total += element.getDetailsTotal();
		}
		return total;
	}
	
	
}
