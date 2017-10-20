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
import com.bisa.health.entity.Pager;
import com.bisa.health.model.SystemContext;
import com.bisa.health.routing.entity.RoutingTable;
import com.bisa.hkshop.model.Active;
import com.bisa.hkshop.zj.service.IActiveService;

@Controller
@RequestMapping("/user")
//@RequestMapping("/l")
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
	public String loadActivePager(Model model,HttpServletRequest request){
		int pager_offset=0;
		String offset=request.getParameter("pager.offset");
		if(offset!=null) {
			pager_offset=Integer.parseInt(offset);
		}
		if(pager_offset!=0) {
			SystemContext.setPageOffset(pager_offset);
		}
			SystemContext.setPageSize(6);
			/*SystemContext.setSort("start_time");
			SystemContext.setOrder("desc");*/
		
		Pager<Active> pager = activeService.loadActiveByUser(3);
		System.out.println(">>>>>>>>>total:"+pager.getTotal());
		model.addAttribute("pager",pager);
		return "active/hk_activeList";
	}
	
	//跳转到 激活服务页面
	@RequestMapping(value="/active_service",method=RequestMethod.GET)
	public String active_service(Model model,HttpServletRequest request){
		//取出悉心账号
		String active_code = request.getParameter("active_code");
		model.addAttribute("user","21213");
		model.addAttribute("active_code",active_code);
		return "active/hk_service_active";
	}
	
	//激活服务
	@RequestMapping(value="/active_commit",method=RequestMethod.POST)
	public String active_commit(HttpServletRequest request,Model model){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//判断激活码是否正确有效
		String active_code = request.getParameter("active_code");
		String account1 = "18682268551";//request.getParameter("account1");
		String account2 = "18682268551";//request.getParameter("account2");
		
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
		
		if(active==null || active.getActive_statu()==2){
			model.addAttribute("messege","激活码不可用");
			return "500";
		}
		
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
				serviceDtl.setCount(active.getService_number());//平安钟可以发送的短信
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
				 serviceDetail.setFinished_time(sdf.format(date));
				 int count = serviceDetail.getCount() + active.getService_number();
				 serviceDetail.setCount(count);
			}
			serviceDetailService.updateServiceDetail(serviceDetail);
		}
		
		//激活服务,激活码失效
		active.setActive_statu(2);
		activeService.updateActive(active);
		
		//激活服务
		return "active/active_success";
	}
	
}
	
	
