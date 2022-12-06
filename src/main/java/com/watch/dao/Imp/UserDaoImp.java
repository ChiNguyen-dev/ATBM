package com.watch.dao.Imp;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.watch.connection.DBConnection;
import com.watch.dao.IUserDao;
import com.watch.model.User;

public class UserDaoImp implements IUserDao{
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	public UserDaoImp() {
		this.conn = DBConnection.getConnection();
	}

	@Override
	public User getUser(String username, String password) {
		String query = "select * from KhachHang where TaiKhoan = ? and MatKhau = ?";
		User user = null;
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String uname = rs.getString(1);
				String pass = rs.getString(2);
				String fname = rs.getString(3);
				String lname = rs.getString(4);
				int role = rs.getInt(5);
				user = new User(uname, pass, fname, lname, null, null, null,role, null );
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	} 

	@Override
	public boolean insert(String firstName, String lastName, String email, String password) {
		String query = "insert into KhachHang(TaiKhoan, MatKhau, Ho, Ten, uRole) values (?,?,?,?,2)";
		try {
			ps= conn.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			ps.setString(3, firstName);
			ps.setString(4, lastName);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	
}
