package com.watch.dao.Imp;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.watch.connection.DBConnection;
import com.watch.dao.ICategoryDao;
import com.watch.model.Category;

public class CategoryDaoImp implements ICategoryDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public CategoryDaoImp() {

	}


	@Override
	public List<Category> getAllCategory() {
		ArrayList<Category> list = new ArrayList<Category>();
		String query = "select * from DanhMuc";
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				Category cate = new Category(id, name);
				list.add(cate);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
