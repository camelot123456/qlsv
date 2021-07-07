package com.laptrinhjavaweb.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.INewsDAO;
import com.laptrinhjavaweb.models.NewsModel;
import com.laptrinhjavaweb.paging.IPageble;
import com.laptrinhjavaweb.service.INewsService;

public class NewsService implements INewsService {

	@Inject
	private INewsDAO newsDAO;

	@Override
	public List<NewsModel> findByCategoryId(Long categoryId) {
		// TODO Auto-generated method stub
		return newsDAO.findByCategoryId(categoryId);
	}

	@Override
	public NewsModel save(NewsModel newModel) {
		// TODO Auto-generated method stub
		newModel.setCreatedBy("");
		Long newId = newsDAO.save(newModel);
		return newsDAO.findOne(newId);
	}

	@Override
	public NewsModel update(NewsModel updateNews) {
		// TODO Auto-generated method stub
		NewsModel oldNew = newsDAO.findOne(updateNews.getId());
		updateNews.setCreatedBy(oldNew.getCreatedBy());
		updateNews.setModifiedBy(oldNew.getModifiedBy());
		newsDAO.update(updateNews);
		return newsDAO.findOne(updateNews.getId());
	}

	@Override
	public void delete(Long[] ids) {
		// TODO Auto-generated method stub
		for (Long id : ids) {
			newsDAO.delete(id);
		}
	}

	@Override
	public List<NewsModel> findAll(IPageble pageble) {
		// TODO Auto-generated method stub
		return newsDAO.findAll(pageble);
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return newsDAO.getTotalItem();
	}

	

}
