package com.watch.services.Imp;

import java.util.List;

import com.watch.dao.ICategoryDao;
import com.watch.dao.Imp.CategoryDaoImp;
import com.watch.model.Category;
import com.watch.services.ICategoryService;

public class CategoryServiceImp implements ICategoryService {
	ICategoryDao dao;

	public CategoryServiceImp() {
		dao = new CategoryDaoImp();
	}

	@Override
	public List<Category> getAllCategory() {
		List<Category> result = dao.getAllCategory();
		return result;
	}

}
