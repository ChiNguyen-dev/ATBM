package com.watch.services;

import com.watch.model.User;

public interface IUserService {
	User login(String username, String password);
	boolean register(String username, String pass, String lastname, String email, String p_key);

	void updatePublicKey(String publicKey, String username);
}
