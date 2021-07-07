package com.laptrinhjavaweb.dao;

import com.laptrinhjavaweb.models.UserModel;

public interface IUserDAO{

	UserModel findByUserNameAndPasswordAndStatus(String username, String password, Integer status);
	
}
