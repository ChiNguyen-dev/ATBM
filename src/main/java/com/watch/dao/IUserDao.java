package com.watch.dao;

import com.watch.model.User;

public interface IUserDao {
	User getUser(String username,String password);
	boolean insert(String username, String pass, String lastname,String email,String p_key);
	boolean updatePublicKey(String key, String username);
}
