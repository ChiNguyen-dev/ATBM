package com.watch.services.Imp;

import java.util.List;

import com.watch.dao.IProductDao;
import com.watch.dao.Imp.ProductDaoImp;
import com.watch.model.Product;

public class ProductServiceImp implements com.watch.services.IProductService {
	IProductDao productDao;

	public ProductServiceImp() {
		productDao = new ProductDaoImp();
	}

	@Override
	public List<Product> getAllProduct(int offset, int record, String cateId, String sortBy, String gender, String name) {
		List<Product> result = productDao.getAllProduct(offset, record, cateId, sortBy, gender, name);
		return result;
	}

	@Override
	public Product getProductById(String id) {
		Product result = productDao.getProductById(id);
		return result;
	}

	@Override
	public List<Product> newProduct() {
		List<Product> result = productDao.newProduct();
		return result;
	}

	@Override
	public List<Product> onSale() {
		List<Product> result = productDao.onSale();
		return result;
	}

	@Override
	public List<String> getImgs(String id) {
		List<String> result = productDao.getImgs(id);
		return result;
	}

	@Override
	public List<Product> getProductByCateId(String cateId) {
		List<Product> result = productDao.getProductByCateId(cateId);
		return result;
	}

	@Override
	public List<Product> getProductByName(String name) {
		List<Product> result = productDao.getProductByName(name);
		return result;
	}

	@Override
	public int getNumOfProduct(String cate, String gender, String name) {
		return productDao.getNumOfProduct(cate, gender, name);
	}

	@Override
	public int deleteP(String id) {
		return productDao.deleteP(id);
	}

	@Override
	public void addProduct(Product p) {
		productDao.addProduct(p);
		
	}

	@Override
	public void updateP(Product p, String oldId) {
		// TODO Auto-generated method stub
		productDao.updateP(p, oldId);
	}

}
