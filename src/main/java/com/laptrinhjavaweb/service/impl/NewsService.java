package com.laptrinhjavaweb.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.ICategoryDAO;
import com.laptrinhjavaweb.dao.INewsDAO;
import com.laptrinhjavaweb.models.CategoryModel;
import com.laptrinhjavaweb.models.NewsModel;
import com.laptrinhjavaweb.paging.IPageble;
import com.laptrinhjavaweb.service.INewsService;

public class NewsService implements INewsService {

	@Inject
	private INewsDAO newsDAO;
	
	@Inject
	private ICategoryDAO categoryDao;

	@Override
	public List<NewsModel> findByCategoryId(Long categoryId) {
		// TODO Auto-generated method stub
		return newsDAO.findByCategoryId(categoryId);
	}

	@Override
	public NewsModel save(NewsModel newModel) {
		// TODO Auto-generated method stub
		CategoryModel categoryModel = categoryDao.findOneByCode(newModel.getCategoryCode());
		newModel.setCategoryId(categoryModel.getId());
		Long newId = newsDAO.save(newModel);
		return newsDAO.findOne(newId);
	}

	@Override
	public NewsModel update(NewsModel updateNews) {
		// TODO Auto-generated method stub
		CategoryModel categoryModel = categoryDao.findOneByCode(updateNews.getCategoryCode());
		updateNews.setCategoryId(categoryModel.getId());
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

	@Override
	public NewsModel findOne(Long id) {
		// TODO Auto-generated method stub
		NewsModel newsModel = newsDAO.findOne(id);
		CategoryModel categoryModel = categoryDao.findOne(newsModel.getCategoryId());
		newsModel.setCategoryCode(categoryModel.getCode());
		return newsModel;
	}

	

}
