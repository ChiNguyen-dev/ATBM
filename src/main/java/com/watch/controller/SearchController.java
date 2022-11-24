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
@WebServlet("/search")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IProductService pService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		pService = new ProductServiceImp();
		String name = request.getParameter("pName");
		String sortBy = request.getParameter("sort");
		String cateId = request.getParameter("category");
		String action = "search";
		int recordPerPage = 8;
		int cPage = 1;
		if (cPage <= 0) {
			cPage = 1;
		}
		if (request.getParameter("page") != null) {
			cPage = Integer.parseInt(request.getParameter("page"));
		}
		List<Product> list  = pService.getAllProduct((cPage - 1) * recordPerPage, recordPerPage, cateId, sortBy, null, name);
		int size = pService.getNumOfProduct(cateId, null, name);
		int totalPages = size % recordPerPage == 0 ? size/recordPerPage : (size/recordPerPage) + 1;
		request.setAttribute("listP", list);
		request.setAttribute("pName", name);
		request.setAttribute("currentPage", cPage);
		request.setAttribute("action", action);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("listP", list);
		request.setAttribute("currentCateId", cateId);
		request.getRequestDispatcher("/view/client/shop.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
