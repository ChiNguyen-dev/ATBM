package com.watch.services;

import java.util.List;
import com.watch.model.Product;

public interface IProductService {
	List<Product> getAllProduct(int offset, int record, String cateId, String sortBy, String gender, String name);

	Product getProductById(String id);

	List<Product> getProductByCateId(String cateId);

	List<Product> newProduct();

	List<Product> onSale();

	List<String> getImgs(String id);

	List<Product> getProductByName(String name);

	int getNumOfProduct(String cateId, String gender, String name);

	int deleteP(String id);

	void addProduct(Product p);

	void updateP(Product p, String oldId);

}
