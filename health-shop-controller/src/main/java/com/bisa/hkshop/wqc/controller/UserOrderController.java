package com.bisa.hkshop.wqc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bisa.hkshop.wqc.service.IAddressService;
import com.bisa.hkshop.wqc.service.IUserOrderDetailService;
import com.bisa.hkshop.wqc.service.IUserOrderService;
import com.bisa.health.entity.Pager;
import com.bisa.health.model.SystemContext;
import com.bisa.hkshop.model.Address;
import com.bisa.hkshop.model.Order;
import com.bisa.hkshop.model.OrderDetail;
import com.bisa.hkshop.wqc.basic.dao.StringUtil;

@Controller
@RequestMapping("/l")
public class UserOrderController {

	@Autowired
	private IUserOrderService iUserOrderService;
	@Autowired
	private IUserOrderDetailService IUserOrderDetailService;
	@Autowired
	private IAddressService addressService;
	
	@RequestMapping(value = "/userOrder", method = RequestMethod.GET)
	public String userOrder(HttpServletRequest request,HttpServletResponse response,Model model,HttpSession session) throws Exception{
		session.setAttribute("guid", "2");
		String guid=(String) session.getAttribute("guid");
		int user_guid=Integer.parseInt(guid);
		if(user_guid!=2) {
			System.out.println("请去登录");
			return null;
		}else {
				//查询订单带分页
				int pager_offset=0;
				String offset=request.getParameter("pager.offset");
				if(StringUtil.isNotEmpty(offset)) {
					pager_offset=Integer.parseInt(offset);
				}
				if(pager_offset!=0) {
					SystemContext.setPageOffset(pager_offset);
				}
					SystemContext.setPageSize(6);
					SystemContext.setSort("start_time");   
					SystemContext.setOrder("desc");
					Pager<Order> orderList=null;
					orderList=iUserOrderService.selPaOrder(user_guid);
					//查询订单细节
					List<Order> orderList2=orderList.getDatas();
					Map<String,List<OrderDetail>> map= new HashMap<String,List<OrderDetail>>();  
					List<OrderDetail> listordertails=new ArrayList<>(); 
					for(Order o:orderList2) {
						String oi=o.getOrder_no();
						listordertails=IUserOrderDetailService.loadOrderDetailList(user_guid,oi);
						map.put(oi, listordertails);		
					}
					model.addAttribute("listordertails", map);
					model.addAttribute("orderList", orderList);
					model.addAttribute("orderList2", orderList2);
				
				//查询其他的状态
				/*SystemContext.setPageSize(6);
				SystemContext.setSort("start_time");
				SystemContext.setOrder("desc");*/
				Pager<Order> orderList5=null;
				orderList5=iUserOrderService.seltra_status1(user_guid,10,1);
				long oListnum1=orderList5.getTotal();
				model.addAttribute("oListnum1", oListnum1);


				Pager<Order> orderList3=null;
				orderList3=iUserOrderService.seltra_status4(user_guid, 2);
				long oListnum2=orderList3.getTotal();
				model.addAttribute("oListnum2", oListnum2);
				 

				Pager<Order> orderList4=null;
				orderList4=iUserOrderService.seltra_status1(user_guid,50,2);
				long oListnum3=orderList4.getTotal();
				 model.addAttribute("oListnum3", oListnum3);
			return "user/userOrder";
		}
	}
	@RequestMapping(value = "/userOrder1", method = RequestMethod.GET)
	public String userOrder1(HttpServletRequest request,Model model,HttpSession session) throws Exception{
		session.setAttribute("guid", "2");
		String guid=(String) session.getAttribute("guid");
		int user_guid=Integer.parseInt(guid);
		if(user_guid!=2) {
			System.out.println("请去登录");
			return null;
		}else {
		//查询订单待支付
			int pager_offset=0;
			String offset=request.getParameter("pager.offset");
			if(StringUtil.isNotEmpty(offset)) {
				pager_offset=Integer.parseInt(offset);
			}
			if(pager_offset!=0) {
				SystemContext.setPageOffset(pager_offset);
			}
			SystemContext.setPageSize(6);
			SystemContext.setSort("start_time");   
			SystemContext.setOrder("desc");
			Pager<Order> orderList5=null;
			orderList5=iUserOrderService.seltra_status1(user_guid,10,1);
			long oListnum1=orderList5.getTotal();
			model.addAttribute("oListnum1", oListnum1);
			model.addAttribute("orderList5", orderList5);
			List<Order> orderList2=orderList5.getDatas();
		//	List<Order> orderList2=iUserOrderService.Ordertra_statusList(user_guid,10,1);
			Map<String,List<OrderDetail>> map= new HashMap<String,List<OrderDetail>>();  
			List<OrderDetail> listordertails=new ArrayList<>(); //
			for(Order o:orderList2) {
				String oi=o.getOrder_no();
				listordertails=IUserOrderDetailService.loadOrderDetailList(user_guid,oi);
				map.put(oi, listordertails);		
			}
			model.addAttribute("listordertails", map);
			//查询其他的状态
			Pager<Order> orderList3=null;
			orderList3=iUserOrderService.seltra_status4(user_guid, 2);
			long oListnum2=orderList3.getTotal();
			model.addAttribute("oListnum2", oListnum2);
			 
			Pager<Order> orderList4=null;
			orderList4=iUserOrderService.seltra_status1(user_guid,50,2);
			long oListnum3=orderList4.getTotal();
			 model.addAttribute("oListnum3", oListnum3);
			 
			return "user/userOrder";
		}
	}
	@RequestMapping(value = "/userOrder2", method = RequestMethod.GET)
	public String userOrder2(HttpServletRequest request,Model model,HttpSession session) throws Exception{
		session.setAttribute("guid", "2");
		String guid=(String) session.getAttribute("guid");
		int user_guid=Integer.parseInt(guid);
		if(user_guid!=2) {
			System.out.println("请去登录");
			return null;
		}else {
		//查询订单待收货
			int pager_offset=0;
			String offset=request.getParameter("pager.offset");
			if(StringUtil.isNotEmpty(offset)) {
				pager_offset=Integer.parseInt(offset);
			}
			if(pager_offset!=0) {
				SystemContext.setPageOffset(pager_offset);
			}
				SystemContext.setPageSize(6);
				SystemContext.setSort("start_time");   
				SystemContext.setOrder("desc");
				Pager<Order> orderList3=null;
				orderList3=iUserOrderService.seltra_status4(user_guid, 2);
				long oListnum2=orderList3.getTotal();
				model.addAttribute("oListnum2", oListnum2);
				model.addAttribute("orderList3", orderList3);
				List<Order> orderList2=iUserOrderService.Ordertra_statusList2(user_guid,2);
				Map<String,List<OrderDetail>> map= new HashMap<String,List<OrderDetail>>();  
				List<OrderDetail> listordertails=new ArrayList<>(); //
				for(Order o:orderList2) {
					String oi=o.getOrder_no();
					listordertails=IUserOrderDetailService.loadOrderDetailList(user_guid,oi);
					map.put(oi, listordertails);		
				}
				model.addAttribute("listordertails", map);
				
				//查询其他状态的总数
				Pager<Order> orderList5=null;
				orderList5=iUserOrderService.seltra_status1(user_guid,10,1);
				long oListnum1=orderList5.getTotal();
				model.addAttribute("oListnum1", oListnum1);
				
				Pager<Order> orderList4=null;
				orderList4=iUserOrderService.seltra_status1(user_guid,50,2);
				long oListnum3=orderList4.getTotal();
				 model.addAttribute("oListnum3", oListnum3);
				 
				return "user/userOrder";
				}
	}
	@RequestMapping(value = "/userOrder3", method = RequestMethod.GET)
	public String userOrder3(HttpServletRequest request,Model model,HttpSession session) throws Exception{
		session.setAttribute("guid", "2");
		String guid=(String) session.getAttribute("guid");
		int user_guid=Integer.parseInt(guid);
		if(user_guid!=2) {
			System.out.println("请去登录");
			return null;
		}else {
		//查询订单待关闭
		int pager_offset=0;
		String offset=request.getParameter("pager.offset");
		if(StringUtil.isNotEmpty(offset)) {
			pager_offset=Integer.parseInt(offset);
		}
		if(pager_offset!=0) {
			SystemContext.setPageOffset(pager_offset);
		}
			SystemContext.setPageSize(6);
			SystemContext.setSort("start_time");   
			SystemContext.setOrder("desc");
		Pager<Order> orderList4=null;
		orderList4=iUserOrderService.seltra_status1(user_guid,50,2);
		long oListnum3=orderList4.getTotal();
		model.addAttribute("oListnum3", oListnum3);
		model.addAttribute("orderList4", orderList4);
		List<Order> orderList2=orderList4.getDatas();
		Map<String,List<OrderDetail>> map= new HashMap<String,List<OrderDetail>>();  
		List<OrderDetail> listordertails=new ArrayList<>(); 
		for(Order o:orderList2) {
			String oi=o.getOrder_no();
			listordertails=IUserOrderDetailService.loadOrderDetailList(user_guid,oi);
			map.put(oi, listordertails);		
		}
		model.addAttribute("listordertails", map);
		//查询其他的状态
		Pager<Order> orderList5=null;
		orderList5=iUserOrderService.seltra_status1(user_guid,10,1);
		long oListnum1=orderList5.getTotal();
		model.addAttribute("oListnum1", oListnum1);

		Pager<Order> orderList3=null;
		orderList3=iUserOrderService.seltra_status4(user_guid, 2);
		long oListnum2=orderList3.getTotal();
		model.addAttribute("oListnum2", oListnum2);
		return "user/userOrder";
		}
	}
	
	//订单细节页面
	@RequestMapping(value="/order_detail",method=RequestMethod.GET)
	public String order_detail(HttpServletRequest request,Model model,HttpSession session){
		String order_no=request.getParameter("order_no");
		int user_guid=2;
		//根据订单号去查商品
		Order order = iUserOrderService.loadOrderByOrderId(user_guid, order_no);
	
		List<OrderDetail> order_detail = IUserOrderDetailService.loadOrderDetailList(user_guid,order.getOrder_no());
		
		Address address = addressService.loadAddressByAddressNum(user_guid,order.getAddr_num());
		
		Date date = new Date();
		
		Date date1 = order.getStart_time();
		
		long time = date.getTime() - date1.getTime();
		if(86400000>time){
			time = 86400000 - time;
			System.out.println(">>>>>>>>>>"+time);			
		    long hh = time % (1000 * 24 * 60 * 60) / (1000 * 60 * 60);
		    long min = time % (1000 * 24 * 60 * 60) % (1000 * 60 * 60) / (1000 * 60);
		    model.addAttribute("time",hh + "小时" + min + "分");
		}
		
		model.addAttribute("orderDetail",order_detail);
		
		model.addAttribute("order",order);
		
		model.addAttribute("address",address);
		
		return "user/userOrderDetail";
		
	}
}
