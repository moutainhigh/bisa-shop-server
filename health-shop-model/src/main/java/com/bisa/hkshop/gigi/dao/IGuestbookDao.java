package com.bisa.hkshop.gigi.dao;

import java.util.List;

import com.bisa.health.entity.Pager;
import com.bisa.hkshop.model.Guestbook;

public interface IGuestbookDao {
	
		public Pager<Guestbook> getAllGuestbookList();
		
		public List<Guestbook> getGuestbookListByReplyName(String reply_name);
		
		public List<Guestbook> getGuestbookListByName(String name);
		
		public Guestbook addGuestbook(Guestbook guestbook);
		
		public void updateGuestbook(Guestbook guestbook);
		
		public void deleteGuestbook(int id);
}
