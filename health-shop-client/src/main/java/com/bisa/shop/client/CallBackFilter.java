package com.bisa.shop.client;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.AuthenticationFilter;
import org.apache.shiro.web.servlet.AdviceFilter;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.util.StringUtils;

import com.bisa.shop.client.core.ClientSavedRequest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import java.net.URLDecoder;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * User: Zhang Kaitao
 * <p>
 * Date: 14-3-14
 * <p>
 * Version: 1.0
 */
public class CallBackFilter extends AdviceFilter {

	public static final String DEFAULT_REMEMBER_ME_PARAM = "rememberMe";
	public static final String DEFAULT_SESSIONID_PARAM = "sid";
	public static final int DEFAULT_EXPIRES_PARAM = 2592000;
	private String rememberMeParam = DEFAULT_REMEMBER_ME_PARAM;
	private String sessionidParam = DEFAULT_SESSIONID_PARAM;

	private String callUrl;

	private int maxAge = DEFAULT_EXPIRES_PARAM;

	public String getRememberMeParam() {
		return rememberMeParam;
	}

	public void setRememberMeParam(String rememberMeParam) {
		this.rememberMeParam = rememberMeParam;
	}

	public String getSessionidParam() {
		return sessionidParam;
	}

	public void setSessionidParam(String sessionidParam) {
		this.sessionidParam = sessionidParam;
	}

	public String getCallUrl() {
		return callUrl;
	}

	public void setCallUrl(String callUrl) {
		this.callUrl = callUrl;
	}

	
	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {

		HttpServletRequest req = WebUtils.toHttp(request);
		HttpServletResponse resp = WebUtils.toHttp(response);

		if (!StringUtils.isEmpty(getSid(request))) {

			String domainPath = "/";
			if (!StringUtils.isEmpty(req.getContextPath())) {
				domainPath = req.getContextPath();
			}

			Cookie sidCookie = new Cookie(getSessionidParam(), getSid(request));
			sidCookie.setPath(domainPath);
			sidCookie.setHttpOnly(true);
			sidCookie.setDomain(request.getRemoteHost());
			resp.addCookie(sidCookie);

			if (getRememberMe(request) != null) {

				String rememberMe = StringEscapeUtils.unescapeHtml(getRememberMe(request));
				Cookie rememberMeCookie = new Cookie(getRememberMeParam(), rememberMe);
				rememberMeCookie.setPath(domainPath);
				rememberMeCookie.setHttpOnly(true);
				rememberMeCookie.setDomain(request.getRemoteHost());
				rememberMeCookie.setMaxAge(getMaxAge());
				resp.addCookie(rememberMeCookie);
			}

			WebUtils.issueRedirect(req, resp, getCallUrl());
			return false;
		}

		return super.preHandle(request, response);

	}

	protected String getSid(ServletRequest request) {
		return WebUtils.getCleanParam(request, getSessionidParam());
	}

	protected String getRememberMe(ServletRequest request) {
		return WebUtils.getCleanParam(request, getRememberMeParam());
	}

}
