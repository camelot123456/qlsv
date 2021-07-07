package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.models.NewsModel;

public class NewsMapper implements IRowMapper<NewsModel> {

	@Override
	public NewsModel mapRow(ResultSet rs) {
		try {
			NewsModel news = new NewsModel();
			news.setId(rs.getLong("ID"));
			news.setTitle(rs.getString("TITLE"));
			news.setContent(rs.getString("CONTENT"));
			news.setCategoryId(rs.getLong("CATEGORY_ID"));
			news.setThumbnail(rs.getString("THUMBNAIL"));
			news.setShortDescription(rs.getString("SHORT_DESCRIPTION"));
			news.setCreatedBy(rs.getString("CREATED_BY"));
			if (rs.getString("MODIFIED_BY") != null) {
				news.setModifiedBy(rs.getString("MODIFIED_BY"));
			}
			return news;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
