package com.bisa.hkshop.gigi.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bisa.health.entity.Pager;
import com.bisa.hkshop.model.News;
import com.bisa.hkshop.wqc.basic.dao.BaseDao;


@Repository
public class NewsDaoImpl extends BaseDao<News> implements INewsDao {

	@Override
	public News getNewsById(int id) {
		String sql = "select * from s_news where id=?";
		return super.queryObjectBySql(sql, new Object[]{id}, News.class);
	}

	@Override
	public News addNews(News news) {
		return super.add(news);
	}

	@Override
	public void updateNews(News news) {
		super.update(news);
	}

	@Override
	public void deleteNews(int id) {
		super.delete(id);
	}

	@Override
	public Pager<News> getPagerNews() {
		String sql = "select * from s_news";
		return super.findBySql(sql, News.class, true);
	}

	@Override
	public List<News> getTop4ListNews() {
		String sql = "select * from s_news order by read_quantity desc limit 0,4";
		return super.queryListBySql(sql, null, News.class);
	}

}
