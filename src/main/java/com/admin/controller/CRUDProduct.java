package com.admin.controller;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.watch.model.Product;
import com.watch.services.IProductService;
import com.watch.services.Imp.ProductServiceImp;

/**
 * Servlet implementation class UploadFile
 */
@WebServlet({"/add-product" ,"/update-product","/load-product"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 50, // 50MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class CRUDProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR = "image";
	private IProductService service;
	

	public CRUDProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = request.getRequestURL().toString();
		this.service = new ProductServiceImp();
		if (url.contains("load-product")) {
			loadProduct(request, response);
			request.getRequestDispatcher("/view/admin/edit-product.jsp").forward(request, response);
		} else {
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String  cateId = request.getParameter("cateId");
			double price = Double.parseDouble(request.getParameter("price"));
			String maleStr = request.getParameter("male");
			double basePrice = Double.parseDouble(request.getParameter("basePrice"));
			boolean isMale = maleStr.equals("0") ? true : false;
			String des = request.getParameter("des");
			String savePath = request.getServletContext().getRealPath(SAVE_DIR);
			Product p = null;
			// check dir
			File fileSaveDir = new File(savePath);
			if (!fileSaveDir.exists()) {
				fileSaveDir.mkdir();
			}
			List<String> fileNames = new ArrayList<String>();
			for (Part part : request.getParts()) {
				String fileName = getFileName(part);
				if(fileName != null) {
					try {
						part.write(savePath + File.separator + fileName);
					} catch (IOException e) {
						
						e.printStackTrace();
					}
					fileNames.add(SAVE_DIR + "/" + fileName);
				}
			}
			
			service = new ProductServiceImp();
			p = new Product(id, name ,fileNames.get(0), isMale, price, basePrice,des, cateId );
			if(url.contains("add-product")) {
				service.addProduct(p);
			} else if(url.contains("update-product")) {
				String oldId = request.getParameter("oldId");
				service.updateP(p, oldId);
			}
			response.sendRedirect("./admin-product");
		}
		
	}
	private void loadProduct(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("pid");
		Product p = service.getProductById(id);
		request.setAttribute("product", p);
		
	}

	private String getFileName(Part part) {
		String disposition = part.getHeader("content-disposition");
		if(!disposition.contains("filename=")) {
			return null;
		}
		int beIndex = disposition.indexOf("filename=") + 10;
		int endInedx = disposition.length() - 1;
		return disposition.substring(beIndex, endInedx);
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
