package com.bisa.hkshop.wqc.controller;


import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bisa.health.beans.dto.UserInfoDto;
import com.bisa.health.model.User;
import com.bisa.health.routing.annotation.CurrentUser;
import com.bisa.hkshop.wqc.service.ICartService;
import com.itextpdf.text.log.SysoCounter;

@Controller
@RequestMapping("/l")
public class IndexController {

	@Autowired
	private ICartService ICartService;
	

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String requestReport(Model model,HttpSession session){
		int cartNum=0;
		Subject subject = SecurityUtils.getSubject();
		User user=(User) subject.getSession().getAttribute("user");
		if(user==null) {
			System.out.println("还没登录");
		}else {
			System.out.println("登录了");
			int user_guid=user.getUser_guid();
			cartNum=ICartService.selCartNum(user_guid);
			System.out.println("cartNum"+cartNum);
		}
		session.setAttribute("cartNum", cartNum);
		
		return "index";
	}
}
