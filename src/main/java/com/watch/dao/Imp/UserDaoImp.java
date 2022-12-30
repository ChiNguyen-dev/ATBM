package com.watch.dao.Imp;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.watch.connection.DBConnection;
import com.watch.dao.IUserDao;
import com.watch.model.User;

public class UserDaoImp implements IUserDao {
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

            while (rs.next()) {
                String userName = rs.getString(1);
                String pass = rs.getString(2);
                String firstName = rs.getString(3);
                String lastName = rs.getString(4);
                String email = rs.getString(5);
                String pubicKey = rs.getString(6);
                int role = rs.getInt(7);
                user = new User(userName, pass, firstName, lastName, email, null, null, null, role, pubicKey);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean insert(String username, String pass, String lastName, String email, String p_key) {
        String query = "insert into KhachHang(TaiKhoan, MatKhau, Ho, Ten, email,pubicKey,uRole) values (?,?,?,?,?,?,2)";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, pass);
            ps.setString(3, null);
            ps.setString(4, lastName);
            ps.setString(5, email);
            ps.setString(6, p_key);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


}
