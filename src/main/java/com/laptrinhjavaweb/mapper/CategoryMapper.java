package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.models.CategoryModel;

public class CategoryMapper implements IRowMapper<CategoryModel> {

	@Override
	public CategoryModel mapRow(ResultSet rs) {
		try {
			CategoryModel category = new CategoryModel();
			category.setId(rs.getLong("ID"));
			category.setCode(rs.getString("CODE"));
			category.setName(rs.getString("NAME"));
			return category;
		} catch (SQLException e) {
			// TODO: handle exception
			return null;
		}
	}

}
