package com.bisa.hkshop.zj.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bisa.appweb.model.ServiceDetail;
import com.bisa.health.appserver.gigi.service.IRoutingTableService;
import com.bisa.health.appserver.gigi.service.IWebAppUserService;
import com.bisa.health.appserver.utils.EncryptionUtils;
import com.bisa.health.appserver.zj.service.IServiceDetailService;
import com.bisa.health.beans.dto.UserInfoDto;
import com.bisa.health.entity.Pager;
import com.bisa.health.model.SystemContext;
import com.bisa.health.model.User;
import com.bisa.health.routing.annotation.CurrentUser;
import com.bisa.health.routing.entity.RoutingTable;
import com.bisa.hkshop.model.Active;
import com.bisa.hkshop.wqc.basic.dao.StringUtil;
import com.bisa.hkshop.zj.service.IActiveService;

@Controller
@RequestMapping("/a")
public class ActiveController {
	
	@Autowired
	private IActiveService activeService;
	@Autowired
	private IServiceDetailService serviceDetailService;
	
	@Autowired
	private IWebAppUserService iWebAppUserService;
	
	@Autowired
	private IRoutingTableService iRoutingTableService;

	
	@RequestMapping(value="/active_list",method=RequestMethod.GET)
	public String loadActivePager(Model model,HttpServletRequest request,@CurrentUser UserInfoDto userInfoDto){
		User user = userInfoDto.getUser();
		int user_guid=user.getUser_guid();
		String offset=request.getParameter("pager.offset");
		int pager_offset=0;
		if(StringUtil.isNotEmpty(offset)) {
			pager_offset=Integer.parseInt(offset);
		}
		if(pager_offset!=0) {
			SystemContext.setPageOffset(pager_offset);
		}
		SystemContext.setPageSize(6);
		SystemContext.setSort("start_time");   
		SystemContext.setOrder("desc");
		Pager<Active> active = activeService.loadActiveByUser(user_guid);
		System.out.println(">>>>>>>>>total:"+active.getTotal());
		model.addAttribute("active",active);
		return "active/hk_activeList";
	}
	
	//跳转到激活服务页面
	@RequestMapping(value="/active_service",method=RequestMethod.GET)
	public String active_service1(Model model,HttpServletRequest request,@CurrentUser UserInfoDto userInfoDto){
		//取出悉心账号
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		User user = userInfoDto.getUser();
		String active_code = request.getParameter("active_code");
		model.addAttribute("user",user.getUsername());
		model.addAttribute("active_code",active_code);
		return "active/hk_service_active";
	}
	
	//跳转到激活服务2页面
	@RequestMapping(value="/active_service2",method=RequestMethod.GET)
	public String active_service2(Model model,HttpServletRequest request,@CurrentUser UserInfoDto userInfoDto){
		//取出悉心账号
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		User user = userInfoDto.getUser();
		String active_code = request.getParameter("active_code");
		String serviceName = request.getParameter("serviceName");
		model.addAttribute("serviceName",serviceName);
		model.addAttribute("user",user.getUsername());
		model.addAttribute("active_code",active_code);
		return "active/hk_service_active2";
	}
	
	
	//激活服务
	@RequestMapping(value="/active_commit",method=RequestMethod.GET)
	public String active_commit(HttpServletRequest request,Model model,@CurrentUser UserInfoDto userInfoDto){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//判断激活码是否正确有效
		String active_code = request.getParameter("active_code");
		
		String account1 = request.getParameter("account1");//"18682268551";
		String account2 = request.getParameter("account2");//"18682268551";//
		
		System.out.println("a1:" + account1 + "a2:" +account2);
		
		if(active_code==null || active_code.equals("")){
			model.addAttribute("messege","激活码出错");
			return "500";
		}
		
		//判断悉心账号是否存在
		if(!account1.equals(account2)){
			model.addAttribute("messege","输入悉心账号不一致");
			return "500";
		}
		
		//查询悉心账号是否存在
		String enusername = EncryptionUtils.md5EnBit16(account1);
		RoutingTable routingTable = iRoutingTableService.findUsenameMd5(enusername);
		if(routingTable.getStub()==null){
			model.addAttribute("messege","悉心账号不存在");
			return "500";
		}
		
		
		Active active = activeService.loadActiveBycode(routingTable.getUid(),active_code);
		//查询激活码是否可用
		if(active==null || active.getActive_statu()==2){
			model.addAttribute("messege","激活码不可用");
			return "500";
		}
		
		//查看当前用户是否已经开通过服务
		ServiceDetail serviceDetail = serviceDetailService.loadByAcceAndType(routingTable.getUid(), active.getGuid());
		
		if(serviceDetail == null){
			ServiceDetail serviceDtl = new ServiceDetail();
			serviceDtl.setIs_active(1);
			serviceDtl.setService_name(active.getService_name());
			serviceDtl.setService_guid(active.getService_guid());
			serviceDtl.setService_type(Integer.valueOf(active.getGuid()));;
			serviceDtl.setUser_guid(routingTable.getUid());
			if(active.getGuid().equals("103")){//平安钟服务
				Calendar c = Calendar.getInstance();
		        c.setTime(date);
		        c.add(Calendar.MONTH,active.getService_number());
				serviceDtl.setFinished_time(sdf.format(c.getTime()));
				serviceDtl.setCount(active.getService_number()*200); //平安钟可以发送的短信
			}else{
				serviceDtl.setFinished_time(sdf.format(date));
				serviceDtl.setCount(active.getService_number());//
			}
			
			serviceDetailService.addServiceDetail(serviceDtl);
			
		}else{//已经开通过了
			if(active.getGuid().equals("103")){//平安钟服务
				Calendar c = Calendar.getInstance();
				Date date1 = null;
				try {
					date1 = sdf.parse(serviceDetail.getFinished_time());
				} catch (Exception e) {
					e.printStackTrace();
				}
		        c.setTime(date1);
		        c.add(Calendar.MONTH,active.getService_number());
		        serviceDetail.setFinished_time(sdf.format(c.getTime()));
		        int count = serviceDetail.getCount() + active.getService_number()*200;
				serviceDetail.setCount(count);
			}else{
				/* serviceDetail.setFinished_time(sdf.format(date));*/
				 int count = serviceDetail.getCount() + active.getService_number();
				 serviceDetail.setCount(count);
			}
			serviceDetailService.updateServiceDetail(serviceDetail);
		}
		
		//激活服务之后,激活码失效，状态改为失效
		active.setActive_statu(2);
		activeService.updateActive(active);
		
		//激活服务
		return "active/active_success";
	}
	
}
	
	
