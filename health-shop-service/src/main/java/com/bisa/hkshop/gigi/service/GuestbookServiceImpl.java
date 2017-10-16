package com.bisa.hkshop.gigi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bisa.health.entity.Pager;
import com.bisa.health.routing.annotation.RoutingTab;
import com.bisa.health.routing.annotation.TableEnum;
import com.bisa.hkshop.gigi.dao.IGuestbookDao;
import com.bisa.hkshop.model.Guestbook;
@Service
@RoutingTab(TableEnum.MASTER)
public class GuestbookServiceImpl implements IGuestbookService {
	
	@Autowired
	private IGuestbookDao iGuestbookDao;

	@Override
	public Pager<Guestbook> getAllGuestbookList() {
		return iGuestbookDao.getAllGuestbookList();
	}

	@Override
	public List<Guestbook> getGuestbookListByReplyName(String reply_name) {
		return iGuestbookDao.getGuestbookListByReplyName(reply_name);
	}

	@Override
	public List<Guestbook> getGuestbookListByName(String name) {
		return iGuestbookDao.getGuestbookListByName(name);
	}

	@Override
	public Guestbook addGuestbook(Guestbook guestbook) {
		return iGuestbookDao.addGuestbook(guestbook);
	}

	@Override
	public Guestbook updateGuestbook(Guestbook guestbook) {
		try {
			iGuestbookDao.updateGuestbook(guestbook);
			return guestbook;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean deleteGuestbook(int id) {
		 try {
			iGuestbookDao.deleteGuestbook(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
