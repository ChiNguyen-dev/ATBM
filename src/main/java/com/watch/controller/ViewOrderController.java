package com.watch.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.watch.model.Order;
import com.watch.services.IOrderService;
import com.watch.services.Imp.OrderServiceImp;

@WebServlet("/order")
public class ViewOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IOrderService oService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		oService = new OrderServiceImp();
		String stringId = (String) request.getAttribute("orderId");
		int orderId = Integer.parseInt(stringId);
		request.getSession().removeAttribute("cart");
		Order order = oService.getOrder(orderId);
		request.setAttribute("order", order);
		request.getRequestDispatcher("/view/client/order.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
