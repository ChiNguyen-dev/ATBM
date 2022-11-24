package com.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.watch.model.Order;
import com.watch.model.OrderDetails;
import com.watch.services.IOrderService;
import com.watch.services.Imp.OrderServiceImp;

/**
 * Servlet implementation class OrderDetailsController
 */
@WebServlet("/order-details")
public class OrderDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IOrderService service;
    /**
     * @see HttpServlet#HttpServlet()
     */
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	service = new OrderServiceImp();
    }
    public OrderDetailsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<OrderDetails> ods = service.getOrderDetails(Integer.parseInt(request.getParameter("oId")));
		request.setAttribute("ods", ods);
		double total=0;
		for (OrderDetails od : ods) {
			total +=od.getDetailsTotal();
		}
		request.setAttribute("total", total);
		request.getRequestDispatcher("/view/admin/order-detail.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
