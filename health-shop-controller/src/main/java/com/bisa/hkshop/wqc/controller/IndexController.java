package com.bisa.hkshop.wqc.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bisa.health.beans.dto.UserInfoDto;
import com.bisa.health.model.User;
import com.bisa.health.routing.annotation.CurrentUser;
import com.bisa.hkshop.wqc.service.ICartService;

@Controller
@RequestMapping("/l")
public class IndexController {

	@Autowired
	private ICartService ICartService;
	

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String requestReport(Model model,@CurrentUser UserInfoDto userInfo,HttpSession session){
		int cartNum=0;
		if(userInfo==null) {
			System.out.println("还没登录");
		}else {
			System.out.println("已登录");
		User user =userInfo.getUser();
		int user_guid=user.getUser_guid();
		cartNum=ICartService.selCartNum(user_guid);
		}
		session.setAttribute("cartNum", cartNum);
		
		return "index";
	}
}
