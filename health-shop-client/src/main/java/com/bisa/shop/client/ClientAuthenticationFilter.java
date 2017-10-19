package com.bisa.shop.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.AuthenticationFilter;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.util.StringUtils;

import com.bisa.shop.client.core.ClientSavedRequest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

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
public class ClientAuthenticationFilter extends AuthenticationFilter {

	private static final Logger log = LogManager.getLogger(ClientAuthenticationFilter.class);
	public static final String DEFAULT_REMEMBER_ME_PARAM = "rememberMe";
	public static final String DEFAULT_SESSIONID_PARAM = "sid";
	private String rememberMeParam = DEFAULT_REMEMBER_ME_PARAM;

	private String sessionidParam = DEFAULT_SESSIONID_PARAM;

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

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {

		Subject subject = getSubject(request, response);
		return subject.isAuthenticated();
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		redirectToLogin(request, response);
		return false;

	}

	protected String getSid(ServletRequest request) {
		return WebUtils.getCleanParam(request, getSessionidParam());
	}

	protected String getRememberMe(ServletRequest request) {
		return WebUtils.getCleanParam(request, getRememberMeParam());
	}

}
