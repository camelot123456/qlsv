package com.laptrinhjavaweb.service;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.IUserDAO;
import com.laptrinhjavaweb.models.UserModel;

public class UserService implements IUserService{

	@Inject
	private IUserDAO userDAO;
	
	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String username, String password, Integer status) {
		// TODO Auto-generated method stub
		
		return userDAO.findByUserNameAndPasswordAndStatus(username, password, status);
	}

}
