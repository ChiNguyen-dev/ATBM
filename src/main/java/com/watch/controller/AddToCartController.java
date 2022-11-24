package com.watch.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.watch.model.Cart;
import com.watch.model.Item;
import com.watch.model.Product;
import com.watch.services.IProductService;
import com.watch.services.Imp.ProductServiceImp;

@WebServlet({ "/add-to-cart" })
public class AddToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IProductService pService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		pService = new ProductServiceImp();
		int quantity = 1;
		if (request.getParameter("productId") != null) {
			Product product = pService.getProductById(request.getParameter("productId"));
			if (product != null) {
				if (request.getParameter("quantity") != null) {
					quantity = Integer.parseInt(request.getParameter("quantity"));
				}
				HttpSession ss = request.getSession();
				Cart cart = (Cart) ss.getAttribute("cart");
				if (cart == null) {
					cart = new Cart();
					Item item = new Item(product, quantity, quantity * product.getPrice());
					cart.addItem(item);
					ss.setAttribute("cart", cart);
				} else {
					Item item = new Item(product, quantity, quantity * product.getPrice());
					cart.addItem(item);
					ss.setAttribute("cart", cart);
				}
				request.setAttribute("gender", product.isMale());			}
			request.getRequestDispatcher("/view/client/cart.jsp").forward(request, response);

		} else {
			response.sendError(404, "...");
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
