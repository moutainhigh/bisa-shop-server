package com.bisa.hkshop.gigi.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bisa.health.entity.Pager;
import com.bisa.hkshop.model.Guestbook;
import com.bisa.hkshop.wqc.basic.dao.BaseDao;


@Repository
public class GuestbookDaoImpl extends BaseDao<Guestbook> implements IGuestbookDao {

	@Override
	public Pager<Guestbook> getAllGuestbookList() {
		String sql = "select * from s_guestbook order by message_time desc";
		return super.findBySql(sql, Guestbook.class, true);
		//return super.findBySql(sql, Guestbook.class, true);
	}

	@Override
	public List<Guestbook> getGuestbookListByReplyName(String reply_name) {
		String sql = "select * from s_guestbook where reply_name = ?";
		return super.queryListBySql(sql, new Object[]{reply_name}, Guestbook.class);
	}

	@Override
	public List<Guestbook> getGuestbookListByName(String name) {
		String sql = "select * from s_guestbook where name = ?";
		return super.queryListBySql(sql, new Object[]{name}, Guestbook.class);
	}

	@Override
	public Guestbook addGuestbook(Guestbook guestbook) {
		return super.add(guestbook);
	}

	@Override
	public void updateGuestbook(Guestbook guestbook) {
		super.update(guestbook);

	}

	@Override
	public void deleteGuestbook(int id) {
		super.delete(id);

	}

}
