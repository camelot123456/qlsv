package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.models.NewsModel;
import com.laptrinhjavaweb.paging.IPageble;

public interface INewsDAO{

	NewsModel findOne(Long id);

	List<NewsModel> findByCategoryId(Long categoryId);

	Long save(NewsModel newModel);
	
	void update(NewsModel updateNews);
	
	void delete(Long id);
	
	List<NewsModel> findAll(IPageble pageble);

	int getTotalItem();
}
