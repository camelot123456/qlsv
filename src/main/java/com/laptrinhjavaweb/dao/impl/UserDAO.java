package com.laptrinhjavaweb.dao.impl;

import java.util.List;

import com.laptrinhjavaweb.dao.IUserDAO;
import com.laptrinhjavaweb.mapper.UserMapper;
import com.laptrinhjavaweb.models.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO{

	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String username, String password, Integer status) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM [USER] AS U "
				+ "INNER JOIN [ROLE] AS R ON R.ID = U.ROLE_ID "
				+ "WHERE USERNAME = ? AND [PASSWORD] = ? AND [STATUS] = ? ";
		List<UserModel> users = query(sql, new UserMapper(), username, password, status);
		return users.isEmpty() ? null : users.get(0);
	}

}
