package com.bisa.hkshop.wqc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.bisa.hkshop.wqc.service.ICommodityService;

@Controller
@RequestMapping("/l")
public class IndexController {

	@Autowired
	private ICommodityService ICommodityService;
	

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String requestReport(Model model){
		return "index";
	}
}
