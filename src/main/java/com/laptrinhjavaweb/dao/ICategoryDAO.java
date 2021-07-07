package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.models.CategoryModel;

public interface ICategoryDAO extends IGenericDAO<CategoryModel>{
	
	List<CategoryModel> findAll();
	
}
