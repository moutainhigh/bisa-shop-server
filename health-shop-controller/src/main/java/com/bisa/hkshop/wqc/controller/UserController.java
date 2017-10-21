package com.bisa.hkshop.wqc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value = "/userCenter", method = RequestMethod.GET)
	public String requestReport(Model model){
		return "user/userCenter";
	}
}
