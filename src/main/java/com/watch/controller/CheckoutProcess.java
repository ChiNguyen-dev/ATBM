package com.watch.controller;

import com.watch.model.Cart;
import com.watch.model.User;
import com.watch.services.Imp.Hash;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckoutProcess
 */
@WebServlet("/checkoutprocess")
public class CheckoutProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckoutProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession ss = request.getSession();
		User user = (User) ss.getAttribute("user");
		if(user != null) {
			Cart cart = (Cart) ss.getAttribute("cart");
			Hash hash = Hash.getInstance("MD5");
			String hashcode = hash.hash(cart.toString());
			ss.setAttribute("hashcode", hashcode);
			request.getRequestDispatcher("/view/client/checkout.jsp").forward(request, response);

		} else {
			request.getRequestDispatcher("/view/client/login.jsp").forward(request, response);
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
