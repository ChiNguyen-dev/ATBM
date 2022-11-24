package com.watch.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.google.gson.Gson;
import com.watch.model.Cart;


@WebServlet({ "/addjust", "/remove", "/minus" })
public class ChangQty extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ChangQty() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		if (url.contains("addjust")) {
			add(request, response);
		} else if (url.contains("minus")) {
			minus(request, response);
		} else {
			remove(request, response);
		}
	}

	private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("itemId");
		HttpSession ss = request.getSession();
		Cart cart = (Cart) ss.getAttribute("cart");
		cart.removeItem(id);
		Gson son = new Gson();
		String json = son.toJson(cart);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}

	private void minus(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("itemId");
		HttpSession ss = request.getSession();
		Cart cart = (Cart) ss.getAttribute("cart");
		cart.minusItem(id);
		Gson son = new Gson();
		String json = son.toJson(cart);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);

	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("itemId");
		HttpSession ss = request.getSession();
		Cart cart = (Cart) ss.getAttribute("cart");
		cart.addjustItem(id);
		Gson son = new Gson();
		String json = son.toJson(cart);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
