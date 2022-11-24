package com.watch.services.Imp;

import java.util.List;

import com.watch.dao.IOrderDao;
import com.watch.dao.Imp.OrderDaoImp;
import com.watch.model.Cart;
import com.watch.model.Order;
import com.watch.model.OrderDetails;
import com.watch.model.User;
import com.watch.services.IOrderService;

public class OrderServiceImp implements IOrderService {
	IOrderDao orderDao;

	public OrderServiceImp() {
		orderDao = new OrderDaoImp();
	}

	@Override
	public String insertOrder(Cart cart, User user, String ho, String ten, String diachi, String thanhpho, String sdt) {
		return orderDao.insertOrder(cart, user, ho, ten, diachi, thanhpho, sdt);
	}

	@Override
	public Order getOrder(int orderId) {
		return orderDao.getOrder(orderId);
	}

	@Override
	public List<Order> getAll(int i, int record) {
		return orderDao.getAll(i, record);
	}

	@Override
	public List<OrderDetails> getOrderDetails(int parseInt) {
		// TODO Auto-generated method stub
		return orderDao.getOrderDetails(parseInt);
	}

	@Override
	public int getNumberOfOrder() {
		// TODO Auto-generated method stub
		return orderDao.getNumberOfOrder();
	}

	@Override
	public List<Order> getOrderByUserName(int i, int recordPerPage, String name) {
		// TODO Auto-generated method stub
		return orderDao.getOrderByUserName(i, recordPerPage, name);
	}

	@Override
	public void deleteOderById(String id) {
		orderDao.deleteOrderById(id);
	}

}
