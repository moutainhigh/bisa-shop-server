package com.bisa.hkshop.gigi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bisa.health.entity.Pager;
import com.bisa.health.routing.annotation.RoutingTab;
import com.bisa.health.routing.annotation.TableEnum;
import com.bisa.hkshop.gigi.dao.INewsDao;
import com.bisa.hkshop.model.News;
@Service
@RoutingTab(TableEnum.MASTER)
public class NewsServiceImpl implements INewsService{
	
	@Autowired
	private INewsDao iNewsDao;

	@Override
	
	public News getNewsById(int id) {
		return iNewsDao.getNewsById(id);
	}

	@Override
	public News addNews(News news) {
		return iNewsDao.addNews(news);
	}

	@Override
	public boolean updateNews(News news) {
		try {
			iNewsDao.updateNews(news);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteNews(int id) {
		try {
			iNewsDao.deleteNews(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Pager<News> getPagerNews() {
		return iNewsDao.getPagerNews();
	}

	@Override
	public List<News> getTop4ListNews() {
		return iNewsDao.getTop4ListNews();
	}

}
