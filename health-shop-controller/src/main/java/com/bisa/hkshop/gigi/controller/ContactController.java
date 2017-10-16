package com.bisa.hkshop.gigi.controller;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bisa.hkshop.model.Guestbook;

/**
 * 联系我们
 * @author Administrator
 *
 */
@RequestMapping(value = "l")
@Controller
public class ContactController {
	
	@RequestMapping(value = "/contactUs", method = RequestMethod.GET)
	public String index(HttpServletRequest request,HttpServletResponse response){
		request.setAttribute("request_type", "contactUs");
		return "about/HK_ContactUs";
	}
	
	@RequestMapping(value = "/disclaimer", method = RequestMethod.GET)
	public String disclaimer(HttpServletRequest request,HttpServletResponse response){
		request.setAttribute("request_type", "disclaimer");
		return "about/HK_ContactUs";
	}
	
	@RequestMapping(value = "/privacyPrinciple", method = RequestMethod.GET)
	public String privacyPrinciple(HttpServletRequest request,HttpServletResponse response){
		request.setAttribute("request_type", "privacyPrinciple");
		return "about/HK_ContactUs";
	}
	

}
