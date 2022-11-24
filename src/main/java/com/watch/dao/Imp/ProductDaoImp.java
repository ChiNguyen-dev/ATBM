package com.watch.dao.Imp;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.watch.connection.DBConnection;
import com.watch.dao.IProductDao;
import com.watch.model.Product;

public class ProductDaoImp implements IProductDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	public ProductDaoImp() {
	}

	@Override
	public Product getProductById(String param) {
		Product result = null;
		String query = "select * from SanPham where MaSanPham = ?";
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, param);
			rs = ps.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String img = rs.getString(3);
				boolean male = rs.getBoolean(4);
				double price = rs.getDouble(5);
				double baseprice = rs.getDouble(6);
				String desc = rs.getString(7);
				String cateId = rs.getString(8);

				result = new Product(id, name, img, male, price, baseprice, desc, cateId);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public List<Product> getAllProduct(int offset, int record, String cate, String sortBy, String gender,
			String pName) {
		List<Product> result = new ArrayList<Product>();

		StringBuilder query = new StringBuilder();
		query.append("select * from SanPham ");

		if (cate != null) {
			query.append(" where MaDanhMuc= " + "'" + cate + "'");
		}
		if (pName != null && cate != null) {
			if (!pName.trim().equals("")) {
				query.append(" and TenSanPham like '%" + pName + "%'");
			}
		}
		if (pName != null && cate == null) {
			if (!pName.trim().equals("")) {
				query.append(" where TenSanPham like '%" + pName + "%'");
			}
		}
		if (gender != null && cate != null) {
			query.append(" and nam = " + "'" + gender + "'");
		}
		if (gender != null && cate == null && pName == null) {
			query.append(" where nam = " + "'" + gender + "'");
		}
		if (sortBy != null && sortBy.equals("price-asc")) {
			query.append("\n order by GiaMoi asc");
		} else if (sortBy != null && sortBy.equals("price-desc")) {
			query.append("\n order by GiaMoi desc");
		} else {
			query.append("\n order by MaSanPham asc");
		}
		query.append("\n offset " + offset + " rows fetch next " + record + " rows only \n");
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(query.toString());
			rs = ps.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String img = rs.getString(3);
				boolean male = rs.getBoolean(4);
				double price = rs.getDouble(5);
				double baseprice = rs.getDouble(6);
				String desc = rs.getString(7);
				String cateId = rs.getString(8);
				Product p = new Product(id, name, img, male, price, baseprice, desc, cateId);
				result.add(p);
			}
			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<Product> getProductBySubCategory(String subCate) {
		List<Product> result = new ArrayList<Product>();
		try {
			conn = DBConnection.getConnection();
			String query = "select * from SanPham where MaDanhMucCon = ? ";
			ps = conn.prepareStatement(query);
			ps.setString(1, subCate);
			rs = ps.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String img = rs.getString(3);
				boolean male = rs.getBoolean(4);
				double price = rs.getDouble(5);
				double baseprice = rs.getDouble(6);
				String desc = rs.getString(7);
				String cateId = rs.getString(8);
				Product p = new Product(id, name, img, male, price, baseprice, desc, cateId);
				result.add(p);
			}
			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	@Override
	public List<Product> newProduct() {
		List<Product> result = new ArrayList<Product>();
		String query = "select top(4) * from SanPham order by MaSanPham desc";
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String img = rs.getString(3);
				boolean male = rs.getBoolean(4);
				double price = rs.getDouble(5);
				double baseprice = rs.getDouble(6);
				String desc = rs.getString(7);
				String cateId = rs.getString(8);
				Product p = new Product(id, name, img, male, price, baseprice, desc, cateId);
				result.add(p);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	@Override
	public List<Product> onSale() {
		List<Product> result = new ArrayList<Product>();
		String query = "select top(4) * from sanpham where GiaCu - GiaMoi > 0";
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String img = rs.getString(3);
				boolean male = rs.getBoolean(4);
				double price = rs.getDouble(5);
				double baseprice = rs.getDouble(6);
				String desc = rs.getString(7);
				String cateId = rs.getString(8);
				Product p = new Product(id, name, img, male, price, baseprice, desc, cateId);
				result.add(p);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	@Override
	public List<String> getImgs(String id) {
		List<String> result = new ArrayList<String>();
		String query = "select DuongDan from Anh join SanPham on anh.MaSanPham = SanPham.MaSanPham where anh.MaSanPham = ?";
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				String uri = rs.getString(1);
				result.add(uri);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public List<Product> getProductByCateId(String param) {
		List<Product> result = new ArrayList<Product>();
		String query = "select * from SanPham where MaDanhMuc = ? ";
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, param);
			rs = ps.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String img = rs.getString(3);
				boolean male = rs.getBoolean(4);
				double price = rs.getDouble(5);
				double baseprice = rs.getDouble(6);
				String desc = rs.getString(7);
				String cateId = rs.getString(8);
				Product p = new Product(id, name, img, male, price, baseprice, desc, cateId);
				result.add(p);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public List<Product> getProductByName(String pName) {
		List<Product> result = new ArrayList<Product>();
		String query = "select * from sanpham where TenSanPham like ?";
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, "%" + pName + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String img = rs.getString(3);
				boolean male = rs.getBoolean(4);
				double price = rs.getDouble(5);
				double baseprice = rs.getDouble(6);
				String desc = rs.getString(7);
				String cateId = rs.getString(8);
				Product p = new Product(id, name, img, male, price, baseprice, desc, cateId);
				result.add(p);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public List<Product> getProductByColor(String param) {
		List<Product> result = new ArrayList<Product>();
		String query = "select * from SanPham where MauSac = ?";
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, param);
			rs = ps.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String img = rs.getString(3);
				boolean male = rs.getBoolean(4);
				double price = rs.getDouble(5);
				double baseprice = rs.getDouble(6);
				String desc = rs.getString(7);
				String cateId = rs.getString(8);
				Product p = new Product(id, name, img, male, price, baseprice, desc, cateId);
				result.add(p);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int getNumOfProduct(String cate, String gender, String pName) {
		StringBuilder query = new StringBuilder();
		query.append("select count(*) from SanPham ");

		if (cate != null) {
			query.append(" where MaDanhMuc= " + "'" + cate + "'");
		}
		if (pName != null && cate != null) {
			if (!pName.trim().equals("")) {
				query.append(" and TenSanPham like '%" + pName + "%'");
			}
		}
		if (pName != null && cate == null) {
			if (!pName.trim().equals("")) {
				query.append(" where TenSanPham like '%" + pName + "%'");
			}
		}
		if (gender != null && cate != null) {
			query.append(" and nam = " + "'" + gender + "'");
		}
		if (gender != null && cate == null) {
			query.append(" where nam = " + "'" + gender + "'");
		}
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(query.toString());
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteP(String id) {
		deleteImg(id);
		deleteOrderDetails(id);
		int result = 0;
		String query = "delete from sanpham where MaSanPham = ?";
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int deleteImg(String id) {
		String query = "delete from Anh where MaSanPham = ?";
		int result = 0;
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int deleteOrderDetails(String id) {
		String query = "delete from ChiTietHoaDon where MaSanPham = ?";
		int result = 0;
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void addProduct(Product p) {
		String query = "insert into SanPham values(?, ?, ?, ? ,?, ?, ?, ?)";

		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, p.getId());
			ps.setString(2, p.getName());
			ps.setString(3, p.getImg());
			ps.setBoolean(4, p.isMale());
			ps.setBigDecimal(5, BigDecimal.valueOf(p.getPrice()));
			ps.setBigDecimal(6, BigDecimal.valueOf(p.getBasePrice()));
			ps.setString(7, p.getDesc());
			ps.setString(8, p.getCateId());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateP(Product p, String oldId) {
		deleteOrderDetails(oldId);
		deleteImg(oldId);
		
		String query = "update SanPham SET MaSanPham = ?, TenSanPham = ?, AnhSanPham = ?, Nam = ?, GiaMoi = ?, GiaCu = ?, Mota = ?, MaDanhMuc = ? where MaSanPham = ?";

		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, p.getId());
			ps.setString(2, p.getName());
			ps.setString(3, p.getImg());
			ps.setBoolean(4, p.isMale());
			ps.setBigDecimal(5, BigDecimal.valueOf(p.getPrice()));
			ps.setBigDecimal(6, BigDecimal.valueOf(p.getBasePrice()));
			ps.setString(7, p.getDesc());
			ps.setString(8, p.getCateId());
			ps.setString(9, oldId);
			ps.executeUpdate();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
