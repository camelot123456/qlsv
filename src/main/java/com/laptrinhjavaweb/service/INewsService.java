package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.models.NewsModel;
import com.laptrinhjavaweb.paging.IPageble;
import com.laptrinhjavaweb.paging.PageRequest;

public interface INewsService {

	List<NewsModel> findByCategoryId(Long categoryId);

	NewsModel save(NewsModel newModel);

	NewsModel update(NewsModel updateNewModel);
	
	void delete(Long[] ids);
	
	List<NewsModel> findAll(IPageble pageble);
	
	int getTotalItem();

	NewsModel findOne(Long id);
}
