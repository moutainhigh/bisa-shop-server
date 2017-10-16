package com.bisa.hkshop.gigi.ajax.controller;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bisa.hkshop.gigi.service.IGuestbookService;
import com.bisa.hkshop.model.Guestbook;

@Controller
@RequestMapping(value = "l")
public class ContactResoures {
	
	@Autowired
	private IGuestbookService iGuestbookService;
	
	
	@RequestMapping(value = "/contactUs", method = RequestMethod.POST)
	public @ResponseBody boolean contactUsPOST(String name,String phone,String mail,String text,HttpServletRequest request,HttpServletResponse response){
		/*
		 *参数是否为空 
		 */
		if(phone==null||phone.isEmpty()||mail==null||mail.isEmpty()||text==null||text.isEmpty()){
			return false;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Guestbook gb = new Guestbook();
		gb.setId(1);
		gb.setName(name);
		gb.setPhone(phone);
		gb.setMail(mail);
		gb.setMessage(text);
		gb.setMessage_time(sdf.format(System.currentTimeMillis()));
		Guestbook result = iGuestbookService.addGuestbook(gb);
		if(result!=null){
			return true;
		}else{
			return false;
		}
	}
}
