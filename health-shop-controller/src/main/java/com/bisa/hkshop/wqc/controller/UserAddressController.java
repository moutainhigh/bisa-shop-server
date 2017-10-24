package com.bisa.hkshop.wqc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bisa.appweb.model.Area;
import com.bisa.health.appserver.gigi.service.IAreaService;
import com.bisa.health.beans.dto.UserInfoDto;
import com.bisa.health.model.User;
import com.bisa.health.routing.annotation.CurrentUser;
import com.bisa.hkshop.model.Address;
import com.bisa.hkshop.wqc.service.IAddressService;

@Controller
@RequestMapping("/user")
public class UserAddressController {

	@Autowired
	private IAddressService addressService;
	@Autowired
	private IAreaService areaService;
	
	@RequestMapping(value = "/userAddress", method = RequestMethod.GET)
	public String requestReport(Model model,HttpServletRequest request,@CurrentUser UserInfoDto userInfo){
		User user =userInfo.getUser();
		int user_guid=user.getUser_guid();
		List<Address> addressList=addressService.loadAddressList(user_guid);
		model.addAttribute("addressList", addressList);
		List<Area> areaList = areaService.getAreaList();
		model.addAttribute("areaList", areaList);
		return "user/userAddressManager";
	}
}
