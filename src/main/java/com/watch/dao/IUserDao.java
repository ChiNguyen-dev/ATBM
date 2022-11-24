package com.watch.dao;

import com.watch.model.User;

public interface IUserDao {
	User getUser(String username,String password);
	boolean insert(String firstName, String lastName, String email, String password);
}
