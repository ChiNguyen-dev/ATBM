package com.watch.services.Imp;

import com.watch.dao.IUserDao;
import com.watch.dao.Imp.UserDaoImp;
import com.watch.model.User;
import com.watch.services.IUserService;

public class UserServiceImp implements IUserService {
	private IUserDao dao;
	public UserServiceImp() {
		dao = new UserDaoImp();
	}

	@Override
	public User login(String username, String password) {
		User u = dao.getUser(username,password);
		return u != null ? u : null;
	}

	@Override
	public boolean register(String firstname, String lastname, String username, String password,String p_key) {
		return dao.insert(firstname, lastname, username, password,p_key);
	}

}
