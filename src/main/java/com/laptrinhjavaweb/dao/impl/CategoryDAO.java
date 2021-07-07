package com.laptrinhjavaweb.dao.impl;

import java.util.List;

import com.laptrinhjavaweb.dao.ICategoryDAO;
import com.laptrinhjavaweb.mapper.CategoryMapper;
import com.laptrinhjavaweb.models.CategoryModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {

	@Override
	public List<CategoryModel> findAll() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM CATEGORY";
		return query(sql, new CategoryMapper());
	}

}
