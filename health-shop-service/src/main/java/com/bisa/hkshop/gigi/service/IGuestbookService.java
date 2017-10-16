package com.bisa.hkshop.gigi.service;

import java.util.List;

import com.bisa.health.entity.Pager;
import com.bisa.hkshop.model.Guestbook;

public interface IGuestbookService {
	
		public Pager<Guestbook> getAllGuestbookList();
		
		public List<Guestbook> getGuestbookListByReplyName(String reply_name);
		
		public List<Guestbook> getGuestbookListByName(String name);
		
		public Guestbook addGuestbook(Guestbook guestbook);
		
		public Guestbook updateGuestbook(Guestbook guestbook);
		
		public boolean deleteGuestbook(int id);
		
}
