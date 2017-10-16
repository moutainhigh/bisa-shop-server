package com.bisa.hkshop.gigi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 购物指南
 * @author Administrator
 *
 */
@RequestMapping(value = "l")
@Controller
public class PayGuideController {
	/**
	 * 购物指南
	 * @return
	 */
	@RequestMapping(value = "/shoppingGuide", method = RequestMethod.GET)
	public String shoppingGuide(HttpServletRequest request){
		request.setAttribute("request_type", "shoppingGuide");
		return "guide/HK_HowToShop";
	}
	/**
	 * 购物流程
	 * @return
	 */
	@RequestMapping(value = "/shoppingProcess", method = RequestMethod.GET)
	public String shoppingProcess(HttpServletRequest request,HttpServletResponse response){
		request.setAttribute("request_type", "shoppingProcess");
		return "guide/HK_HowToShop";
	}
	
	/**
	 * 包邮政策
	 * @return
	 */
	@RequestMapping(value = "/deliveryDetail", method = RequestMethod.GET)
	public String deliveryDetail(HttpServletRequest request,HttpServletResponse response){
		request.setAttribute("request_type", "deliveryDetail");
		return "guide/HK_HowToShop";
	}
	
	/**
	 * 下单及支付时效
	 * @return
	 */
	@RequestMapping(value = "/placeOrder", method = RequestMethod.GET)
	public String placeOrder(HttpServletRequest request,HttpServletResponse response){
		request.setAttribute("request_type", "placeOrder");
		return "guide/HK_HowToShop";
	}
	
	/**
	 * 发货时效
	 * @return
	 */
	@RequestMapping(value = "/deliveryTime", method = RequestMethod.GET)
	public String deliveryTime(HttpServletRequest request,HttpServletResponse response){
		request.setAttribute("request_type", "deliveryTime");
		return "guide/HK_HowToShop";
	}
	/**
	 * paymentMethod
	 */
	@RequestMapping(value = "/paymentMethod", method = RequestMethod.GET)
	public String paymentMethod(HttpServletRequest request,HttpServletResponse response){
		request.setAttribute("request_type", "paymentMethod");
		return "guide/HK_HowToShop";
	}
	/**
	 * 售后政策
	 * @return
	 */
	@RequestMapping(value = "/afterSales", method = RequestMethod.GET)
	public String afterSales(HttpServletRequest request,HttpServletResponse response){
		request.setAttribute("request_type", "afterSales");
		return "guide/HK_HowToShop";
	}
	
}
