package com.watch.services;

import com.watch.model.User;

public interface IUserService {
	User login(String username, String password);

	boolean register(String firstname, String lastname, String email, String password);
}
