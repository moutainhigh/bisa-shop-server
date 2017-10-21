package com.bisa.hkshop.yoyo.basic.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

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

	public static String[] getIP(String url) {
			if(StringUtils.isEmpty(url)){
				return null;
			}
			String[] urlAtr=new String[2];
			Pattern p = Pattern.compile("(http://|https://)?([^/]*)",Pattern.CASE_INSENSITIVE);
		    Matcher m = p.matcher(url);
		    return m.find()?m.group(2).split("\\:"):null;
	}
}
