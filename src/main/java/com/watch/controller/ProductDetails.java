package com.watch.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.watch.model.Product;
import com.watch.services.IProductService;
import com.watch.services.Imp.ProductServiceImp;

@WebServlet("/product-details")
public class ProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IProductService pService;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		pService = new ProductServiceImp();
		String id = request.getParameter("productId");
		Product product = pService.getProductById(id);
		List<String> imgs = pService.getImgs(id);
		request.setAttribute("product", product);
		request.setAttribute("imgs", imgs);
		List<Product> listSale = pService.onSale();
		request.setAttribute("listP", listSale);
		request.getRequestDispatcher("/view/client/product-details.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
