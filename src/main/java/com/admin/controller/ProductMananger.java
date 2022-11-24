package com.admin.controller;

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

/**
 * Servlet implementation class ProductMananger
 */
@WebServlet("/admin-product")
public class ProductMananger extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private IProductService pService;
    public ProductMananger() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	pService = new ProductServiceImp();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		pService = new ProductServiceImp();
		
		int recordPerPage = 4;
		String action = "admin-product";
		int cPage = 1;
		if (cPage <= 0) {
			cPage = 1;
		}
		if (request.getParameter("page") != null) {
			cPage = Integer.parseInt(request.getParameter("page"));
		}
		List<Product> list = pService.getAllProduct((cPage - 1) * recordPerPage, recordPerPage, null, null, null, null);
		int size = pService.getNumOfProduct(null, null, null);
		int totalPages = size % recordPerPage == 0 ? size/recordPerPage : (size/recordPerPage) + 1;
		request.setAttribute("currentPage", cPage);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("listP", list);
		request.setAttribute("action", action);
		request.getRequestDispatcher("/view/admin/product.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
