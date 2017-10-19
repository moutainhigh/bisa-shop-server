package com.bisa.hkshop.yoyo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试更新会话
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/user")
public class SessionController {
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public @ResponseBody String updateSession(HttpServletRequest request, HttpServletResponse response,Model model){
		
		return "success";
		
	}

}
