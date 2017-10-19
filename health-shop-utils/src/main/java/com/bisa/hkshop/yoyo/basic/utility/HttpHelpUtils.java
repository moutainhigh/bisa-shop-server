package com.bisa.hkshop.yoyo.basic.utility;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class HttpHelpUtils {
	
	public static Cookie getCookie(HttpServletRequest request,String cookiename){
		  Cookie[] cookies = request.getCookies();
		  for(Cookie cookie : cookies){
			  if(cookie.getName().equals(cookiename)){
				  return cookie;
			  }
		  }
		  return null;
	}
}
