package com.watch.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.watch.model.Cart;
import com.watch.model.User;
import com.watch.services.IOrderService;
import com.watch.services.Imp.OrderServiceImp;

@WebServlet("/place-order")
public class PlaceOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IOrderService oService;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		oService = new OrderServiceImp();
		String ho = request.getParameter("ho");
		String ten = request.getParameter("ten");
		String sdt = request.getParameter("sdt");
		String diachi = request.getParameter("diachi");
		String thanhpho = request.getParameter("thanhpho");

		HttpSession ss = request.getSession();
		User user = (User) ss.getAttribute("user");
		Cart cart = (Cart) ss.getAttribute("cart");
		
		if (ho == null || ho.equals("") || ten == null || ten.equals("") || diachi == null || diachi.equals("")
				|| thanhpho == null || thanhpho.equals("") || sdt == null || sdt.equals("")) {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Infomation is required');");
			out.println("location='/Project_CuoiKy/view/client/checkout.jsp'");
			out.println("</script>");
		} else {
			String orderId = oService.insertOrder(cart, user, ho, ten, diachi, thanhpho, sdt);
			request.setAttribute("orderId", orderId);
			request.getRequestDispatcher("/order").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
