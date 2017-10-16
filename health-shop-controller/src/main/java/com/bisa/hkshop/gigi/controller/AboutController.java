package com.bisa.hkshop.gigi.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/***
 * 关于碧沙
 * @author Administrator
 *
 */
@RequestMapping(value = "l")
@Controller
public class AboutController {

	
	/**
	 * 关于
	 */
	@RequestMapping(value = "/aboutBis", method = RequestMethod.GET)
	public String index(HttpServletRequest request){
		return "about/HK_About";
	}
	
}
