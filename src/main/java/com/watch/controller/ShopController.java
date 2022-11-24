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

@WebServlet("/shop")
public class ShopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IProductService pService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		pService = new ProductServiceImp();
		String cateId = request.getParameter("category");
		String sortBy = request.getParameter("sort");
		String gender = request.getParameter("gender");
		String action = "shop";
		int recordPerPage = 8;
		String location = null;
		if(gender != null) {
			location = gender.equals("1") ? "nam" : "nữ";
		}
		int cPage = 1;
		if (cPage <= 0) {
			cPage = 1;
		}
		if (request.getParameter("page") != null) {
			cPage = Integer.parseInt(request.getParameter("page"));
		}
		List<Product> list = pService.getAllProduct((cPage - 1) * recordPerPage, recordPerPage, cateId, sortBy, gender, null);
		int size = pService.getNumOfProduct(cateId, gender, null);
		int totalPages = size % recordPerPage == 0 ? size/recordPerPage : (size/recordPerPage) + 1;
		request.setAttribute("gender", gender);
		request.setAttribute("action", action);
		request.setAttribute("sortBy", sortBy);
		request.setAttribute("location", location);
		request.setAttribute("currentPage", cPage);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("listP", list);
		request.setAttribute("currentCateId", cateId);
		request.getRequestDispatcher("/view/client/shop.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
