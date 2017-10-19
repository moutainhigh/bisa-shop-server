package com.bisa.hkshop.yoyo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {


	@Value("${login.success}")
	private String loginsuccess;
	
    @RequestMapping(value = "/login")
	public String index(HttpServletRequest request, HttpServletResponse response,Model model) {
    	
    	 Subject subject = SecurityUtils.getSubject();
		 
			if(subject.isAuthenticated()){
				return "redirect:"+loginsuccess;
		}
    	
    	 String exceptionClassName = (String)request.getAttribute("shiroLoginFailure");
         String error = null;
         if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
             error = "用户名不存在";
         } else if(ExcessiveAttemptsException.class.getName().equals(exceptionClassName)) {
             error = "验证码不正确";
         }  else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
             error = "密码错误";
         }  else if(ExpiredCredentialsException.class.getName().equals(exceptionClassName)) {
             error = "微信登入异常";
         } else if(exceptionClassName != null) {
             error = "其他错误：" + exceptionClassName;
         }
         System.out.println("error:"+error);
         /*
          * 查询临期的服务信息，生成消息
          */
         
         model.addAttribute("message", error);
         return "appreg/login";
	}
}
