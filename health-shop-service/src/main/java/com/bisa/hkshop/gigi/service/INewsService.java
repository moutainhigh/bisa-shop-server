package com.bisa.hkshop.gigi.service;

import java.util.List;

import com.bisa.health.entity.Pager;
import com.bisa.hkshop.model.News;

public interface INewsService {
	
	public News getNewsById(int id);
	/**
	 * 上一篇，本文，下一篇文章
	 * @param last
	 * @param next
	 * @return
	 */
	public List<News> getTop4ListNews();
	
	public Pager<News> getPagerNews();
	
	public News addNews(News news);
	
	public boolean updateNews(News news);
	
	public boolean deleteNews(int id);

}
