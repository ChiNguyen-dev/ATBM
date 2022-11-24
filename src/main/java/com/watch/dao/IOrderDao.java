package com.watch.dao;
import java.util.List;

import com.watch.model.Cart;
import com.watch.model.Order;
import com.watch.model.OrderDetails;
import com.watch.model.User;

public interface IOrderDao {

	String insertOrder(Cart cart, User user ,String ho, String ten, String diachi, String thanhpho, String sdt);

	Order getOrder(int orderId);

	List<Order> getAll(int i, int record);

	List<OrderDetails> getOrderDetails(int parseInt);

	int getNumberOfOrder();

	List<Order> getOrderByUserName(int i, int recordPerPage, String name);

	void deleteOrderById(String id);

}
