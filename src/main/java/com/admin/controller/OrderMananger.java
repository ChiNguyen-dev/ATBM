package com.admin.controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.watch.model.Order;
import com.watch.services.IOrderService;
import com.watch.services.Imp.OrderServiceImp;

/**
 * Servlet implementation class OrderMananger
 */
@WebServlet("/admin-order")
public class OrderMananger extends HttpServlet {
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
    public OrderMananger() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int recordPerPage = 4;
		
		int cPage = 1;
		if (cPage <= 0) {
			cPage = 1;
		}
		if (request.getParameter("page") != null) {
			cPage = Integer.parseInt(request.getParameter("page"));
			
		}
		List<Order> list = service.getAll((cPage - 1) * recordPerPage, recordPerPage);
		int size = service.getNumberOfOrder();
		int totalPages = size % recordPerPage == 0 ? size/recordPerPage : (size/recordPerPage) + 1;
		request.setAttribute("currentPage", cPage);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("listO", list);
		request.getRequestDispatcher("/view/admin/order.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
