package com.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.watch.services.IOrderService;
import com.watch.services.Imp.OrderServiceImp;

/**
 * Servlet implementation class CRUDOrder
 */
@WebServlet({"/delete-order","/add-order"})
public class CRUDOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IOrderService oService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CRUDOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		oService = new OrderServiceImp();
		String url = request.getRequestURL().toString();
		String id = request.getParameter("oId");
		if(url.contains("delete-order")) {
			oService.deleteOderById(id);
			response.sendRedirect("./admin-order");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
