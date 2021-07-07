package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.models.RoleModel;
import com.laptrinhjavaweb.models.UserModel;

public class UserMapper implements IRowMapper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet rs) {
		try {
			UserModel user = new UserModel();
			user.setId(rs.getLong("ID"));
			user.setUsername(rs.getString("USERNAME"));
			user.setPassword(rs.getString("PASSWORD"));
			user.setFullname(rs.getString("FULLNAME"));
			user.setStatus(rs.getInt("STATUS"));
			try {
				RoleModel role = new RoleModel();
				role.setCode(rs.getString("CODE"));
				role.setName(rs.getString("NAME"));
				user.setRole(role);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
