package com.watch.listener;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.watch.model.Category;
import com.watch.services.ICategoryService;
import com.watch.services.Imp.CategoryServiceImp;
@WebListener
public class contextListener implements ServletContextListener {
	private ICategoryService cService;
    public void contextDestroyed(ServletContextEvent sce)  { 
     	sce.getServletContext().removeAttribute("listC");
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	cService = new CategoryServiceImp();
    	List<Category> listC = cService.getAllCategory();
    	sce.getServletContext().setAttribute("listC", listC);  
    }
	
}
