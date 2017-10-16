package com.bisa.hkshop.wqc.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bisa.hkshop.model.Address;
import com.bisa.hkshop.wqc.basic.utility.GuidGenerator;
import com.bisa.hkshop.wqc.service.IAddressService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/l")
public class AddressController {
	@Autowired
	private IAddressService addressService;
	
	@ResponseBody
	@RequestMapping(value="/addAddress",method=RequestMethod.POST)
	public String addAddress(Model model,HttpServletRequest request,HttpSession session) throws Exception{
		String add=request.getParameter("str");
		JSONObject jsonObj = new JSONObject(add);
		
		Address address=new Address();
		address.setName(jsonObj.getString("name"));
		address.setAddress(jsonObj.getString("address"));
		address.setTel(jsonObj.getString("tel"));
		address.setEmail(jsonObj.getString("email"));
		address.setGuid(jsonObj.getString("guid"));
		session.setAttribute("user_guid", 2);
		int user_guid=(int) session.getAttribute("user_guid");
		if(address == null){
			model.addAttribute("messege","参数不能为空");
			return "500";
		}
		address.setUser_guid(user_guid);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//int user_guid=2;
		address.setAct_time(date);
		//从session取出用户名
		address.setUser_guid(user_guid);
		address.setPostcode(" ");
		address.setProvince(" ");
		address.setCity("dd");
		address.setCounty("df");
		address.setAddr_num(GuidGenerator.generate());
		Boolean bool = addressService.addAddress(user_guid,address);
		List<Address> list = new ArrayList<Address>();
		if(bool){
			list.add(address);
		}else{
			model.addAttribute("messege","添加失败");
			return "500";
		}
		Gson gson = new Gson();
		String str = gson.toJson(list);
		return str;
	}
	
	 
	@SuppressWarnings("unused")
	@ResponseBody
	@RequestMapping(value="/updateAddress",method=RequestMethod.POST)
	public String updateAddress(Model model,HttpServletRequest request,HttpSession session) throws Exception{
		String update=request.getParameter("str");
		JSONObject jsonObj = new JSONObject(update);
		Address address=new Address();
		address.setName(jsonObj.getString("name"));
		address.setAddress(jsonObj.getString("address"));
		address.setTel(jsonObj.getString("tel"));
		address.setEmail(jsonObj.getString("email"));
		address.setGuid(jsonObj.getString("guid"));
		address.setAddr_num(jsonObj.getString("addr_num"));
		if(address == null){
			model.addAttribute("messege","请填写收货信息");
			return "500";
		}
		session.setAttribute("user_guid", 2);
		int user_guid=(int) session.getAttribute("user_guid");
		address.setUser_guid(user_guid);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Address addre = addressService.loadAddressBynameNum(user_guid, address.getAddr_num());
		//System.out.println(">>>>>>>>>>>>>number" + addre==null);
		Boolean bool = false;
		if(addre!=null){
			addre.setAddress(address.getAddress());
			addre.setTel(address.getTel());
			addre.setName(address.getName());
			addre.setAct_time(date);
			addre.setEmail(address.getEmail());
			addre.setIs_default(0);
			addre.setGuid(address.getGuid());
			System.out.println("????update_is_default:"+ addre.getIs_default());
			bool = addressService.updateAddress(user_guid,addre);
		}
		
		List<Address> list = new ArrayList<Address>();
		
		if(bool){
			list.add(addre);
		}else{
			model.addAttribute("messege","修改失败");
			return "500";
		}
		Gson gson = new Gson();
		String str = gson.toJson(list);
		System.out.println(str);
		return str;
	}
	
	
	
	
	
}
