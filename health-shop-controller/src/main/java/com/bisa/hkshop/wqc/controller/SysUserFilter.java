package com.bisa.hkshop.wqc.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import com.bisa.health.appserver.yoyo.service.UinfoService;
import com.bisa.health.appserver.yoyo.service.UserService;
import com.bisa.health.beans.dto.UserInfoDto;
import com.bisa.health.contants.Constants;
import com.bisa.health.model.UInfo;
import com.bisa.health.model.User;
import com.bisa.health.routing.entity.RoutingTable;
import com.bisa.health.routing.service.RoutingTableService;
import com.bisa.health.utils.EncryptionUtils;


import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * <p>
 * User: Zhang Kaitao
 * <p>
 * Date: 14-2-15
 * <p>
 * Version: 1.0
 */
public class SysUserFilter extends PathMatchingFilter {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UinfoService uinfoService;

	@Autowired
	private RoutingTableService routingTableService;

	@Override
	protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {

		String username = (String) SecurityUtils.getSubject().getPrincipal();
		RoutingTable routingTbale = routingTableService.findUsernameMd5(EncryptionUtils.md5EnBit16(username));
		if (routingTbale == null) {
			throw new UnknownAccountException("用户不存在");// 没找到帐号
		}
		User user=userService.findByUsername(username,routingTbale.getUid());
		UInfo uinfo=uinfoService.findByUserguid(routingTbale.getUid());
		UserInfoDto userInfo=new UserInfoDto();
		userInfo.setUinfo(uinfo);
		userInfo.setUser(user);
		request.setAttribute(Constants.CURRENT_USER,userInfo);
		return true;
	}
}
