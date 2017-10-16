package com.bisa.hkshop.gigi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bisa.health.beans.dto.UserInfoDto;
import com.bisa.health.model.UInfo;
import com.bisa.health.model.User;
import com.bisa.health.routing.annotation.CurrentUser;



@Controller
@RequestMapping("/l")//后期改为"user"
public class ShopUserController {
	/**
	 * 登录请求地址
	 */
	@Value("${login.url}")
	private String login_url;

	private Logger logger =LogManager.getLogger(ShopUserController.class);

	
	@RequestMapping(value = "/user_index", method = RequestMethod.GET)
	public String user_index(HttpServletRequest request, HttpServletResponse response,@CurrentUser UserInfoDto userInfoDto,Model model){
		
		System.out.println(">>>>>>>>user_index>>>>>>>");
		User user = null;
		UInfo userInfo = null;
		try {
			user = userInfoDto.getUser();
			userInfo = userInfoDto.getUinfo();
			if(userInfo != null){
				model.addAttribute("userInfo", userInfo);
			}else{
				if(user!=null){
					System.out.println("username:"+user.getUsername());
					model.addAttribute("username", user.getUsername());
					model.addAttribute("user",user);
				}else{
				/*
				 * 返回到登录页
				 */
					model.addAttribute("username", "已登入");
				}
		}
			return "index";
		} catch (NullPointerException e) {
			logger.debug("shop login user is null"+(user.getUsername()==null));
			e.printStackTrace();
			return "redirect:"+login_url;
		}
	}
	
	@RequestMapping(value="/HK_user_center",method=RequestMethod.GET)
	public String HK_user_center(HttpServletRequest request, HttpServletResponse response,Model model){
		User user = new User();
		user.setUser_guid(206);
		request.setAttribute("user", user);
		model.addAttribute("username",123456);
		return "HK_UserCenter";
	}
	
	@RequestMapping(value="/upload_portrait",method=RequestMethod.POST)
	public @ResponseBody Boolean upload_portrait(int user_guid,String img_portrait){
		/*
		 * 先将编码格式的img_portrait转成图片.jpg或png.
		 * 存到本地文件夹,然后将这个本地存储地址存到数据库就可以了.
		 */
		
		
		return null;
		
	}

}
