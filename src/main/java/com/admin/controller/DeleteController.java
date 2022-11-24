package com.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.watch.services.IProductService;
import com.watch.services.Imp.ProductServiceImp;

/**
 * Servlet implementation class DeleteController
 */
@WebServlet("/admin-delete-product")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IProductService service;
    public DeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	service = new ProductServiceImp();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("pId");
		int res = service.deleteP(id);
		if(res != 0) {
			response.sendRedirect("./admin-product");
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Infomation is required');");
			out.println("location='/Project_CuoiKy//admin-product'");
			out.println("</script>");
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
