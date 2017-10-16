package com.bisa.hkshop.gigi.dao;

import java.util.List;

import com.bisa.health.entity.Pager;
import com.bisa.hkshop.model.News;

public interface INewsDao {
	
	public News getNewsById(int id);
	/**
	 * 新闻列表的新闻分页
	 * @param news
	 * @return
	 */
	public Pager<News> getPagerNews();
	
	public News addNews(News news);
	
	public void updateNews(News news);
	
	public void deleteNews(int id);
	
	public List<News> getTop4ListNews();
}
