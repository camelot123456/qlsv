package com.laptrinhjavaweb.dao.impl;

import java.util.List;

import com.laptrinhjavaweb.dao.INewsDAO;
import com.laptrinhjavaweb.mapper.NewsMapper;
import com.laptrinhjavaweb.models.NewsModel;
import com.laptrinhjavaweb.paging.IPageble;
import com.laptrinhjavaweb.paging.PageRequest;

public class NewsDAO extends AbstractDAO<NewsModel> implements INewsDAO {

	@Override
	public List<NewsModel> findByCategoryId(Long categoryId) {
		String sql = "SELECT * FROM NEWS WHERE CATEGORY_ID = ?";
		return query(sql, new NewsMapper(), categoryId);
	}

	@Override
	public Long save(NewsModel newModel) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO NEWS(TITLE, CONTENT, CATEGORY_ID, THUMBNAIL" + ", SHORT_DESCRIPTION, CREATED_BY)"
				+ " VALUES(?, ?, ?, ?, ?, ?)";
		return insert(sql, newModel.getTitle(), newModel.getContent(), newModel.getCategoryId(),
				newModel.getThumbnail(), newModel.getShortDescription(), newModel.getCreatedBy());
	}

	@Override
	public NewsModel findOne(Long id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM NEWS WHERE ID = ?";
		List<NewsModel> news = query(sql, new NewsMapper(), id);
		return news.isEmpty() ? null : news.get(0);
	}

	@Override
	public void update(NewsModel updateNews) {
		// TODO Auto-generated method stub
		String sql = "UPDATE NEWS " + "SET TITLE=?, THUMBNAIL=?, SHORT_DESCRIPTION=?, CONTENT=?"
				+ ", CATEGORY_ID=? WHERE ID=?";
		update(sql, updateNews.getTitle(), updateNews.getThumbnail(), updateNews.getShortDescription(),
				updateNews.getContent(), updateNews.getCategoryId(), updateNews.getId());
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM NEWS" + " WHERE ID = ?";
		update(sql, id);
	}

	@Override
	public List<NewsModel> findAll(IPageble pageble) {
		// TODO Auto-generated method stub
		String sql1 = "SELECT * FROM NEWS";
		String sql2 = "";
		if (pageble.getSorter() != null) {
			sql2 = " ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + " ";
			if (pageble.getOffset() != null && pageble.getLimit() != null) {
				sql2 += "OFFSET " + pageble.getOffset() + " ROWS FETCH NEXT " + pageble.getLimit() + " ROWS ONLY";
			}
		}
		System.out.println(sql1 + sql2);
		return query(sql1 + sql2, new NewsMapper());
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		String sql = "SELECT COUNT(*) FROM NEWS";
		return count(sql);
	}

}
