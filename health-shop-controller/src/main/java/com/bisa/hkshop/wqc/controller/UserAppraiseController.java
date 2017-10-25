package com.bisa.hkshop.wqc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bisa.health.beans.dto.UserInfoDto;
import com.bisa.health.entity.Pager;
import com.bisa.health.model.SystemContext;
import com.bisa.health.model.UInfo;
import com.bisa.health.model.User;
import com.bisa.health.routing.annotation.CurrentUser;
import com.bisa.hkshop.model.Appraise;
import com.bisa.hkshop.model.AppraiseUser;
import com.bisa.hkshop.model.Commodity;
import com.bisa.hkshop.model.Order;
import com.bisa.hkshop.model.Package;
import com.bisa.hkshop.model.OrderDetail;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bisa.hkshop.wqc.service.IAppraiseService;
import com.bisa.hkshop.wqc.service.IAppraiseUserService;
import com.bisa.hkshop.wqc.service.ICommodityService;
import com.bisa.hkshop.wqc.service.IPackageService;
import com.bisa.hkshop.wqc.service.IUserOrderDetailService;
import com.bisa.hkshop.wqc.service.IUserOrderService;
import com.bisa.hkshop.wqc.basic.dao.StringUtil;

import com.bisa.hkshop.wqc.basic.utility.GuidGenerator;


@Controller
@RequestMapping("/user")
public class UserAppraiseController {
	@Autowired
	private ICommodityService iCommodityService;
	@Autowired
	private IAppraiseUserService IAppraiseUserService;
	@Autowired
	private IUserOrderService IUserOrderService;
	@Autowired
	private IUserOrderDetailService IUserOrderDetailService;
	@Autowired
	private IAppraiseService IAppraiseService;
	@Autowired
	private IPackageService IPackageService;
	 
	 @RequestMapping(value = "/userAppraise", method = RequestMethod.GET)
		public String userAppraise(HttpServletRequest request,Model model,@CurrentUser UserInfoDto userInfo) throws Exception{
		 		User user =userInfo.getUser();
		 		int user_guid=user.getUser_guid();
		 		//List<OrderDetail> listordertails=new ArrayList<OrderDetail>();
		 		int pager_offset=0;
				String offset=request.getParameter("pager.offset");
				if(StringUtil.isNotEmpty(offset)) {
					pager_offset=Integer.parseInt(offset);
				}
				if(pager_offset!=0) {
					SystemContext.setPageOffset(pager_offset);
				}

				SystemContext.setSort("start_time");
				SystemContext.setOrder("desc");
				SystemContext.setPageSize(6);
				//查询订单详情
				Pager<OrderDetail>  listordertails=IUserOrderDetailService.page_userdetails(user_guid,1,30,1);
				model.addAttribute("odtail",listordertails);
				//request.setAttribute("request_type", "userAppraise");
				return "user/useAppraiseList";
				
		 	
	 }
		@RequestMapping(value = "/userAppraise1", method = RequestMethod.GET)
		public String useAppraise1(HttpServletRequest request,Model model,@CurrentUser UserInfoDto userInfo) throws Exception{
				User user =userInfo.getUser();
				int user_guid=user.getUser_guid();
		 		int pager_offset=0;
				String offset=request.getParameter("pager.offset");
				if(StringUtil.isNotEmpty(offset)) {
					pager_offset=Integer.parseInt(offset);
				}
				if(pager_offset!=0) {
					SystemContext.setPageOffset(pager_offset);
				}

				SystemContext.setSort("start_time");
				SystemContext.setOrder("desc");
				SystemContext.setPageSize(6);
				Pager<OrderDetail> listordertails=IUserOrderDetailService.page_isAppraise(user_guid,0,30);
				SystemContext.setSort("start_time");
				SystemContext.setOrder("desc");
				model.addAttribute("odpingjia",listordertails);
			
			return "user/useAppraiseList";
		}
		
		@RequestMapping(value = "/userAppraise2", method = RequestMethod.GET)
		public String useAppraise2(HttpServletRequest request,Model model,@CurrentUser UserInfoDto userInfo) throws Exception{
			User user =userInfo.getUser();
			int user_guid=user.getUser_guid();
				int pager_offset=0;
				String offset=request.getParameter("pager.offset");
				if(StringUtil.isNotEmpty(offset)) {
					pager_offset=Integer.parseInt(offset);
				}
				if(pager_offset!=0) {
					SystemContext.setPageOffset(pager_offset);
				}

				SystemContext.setSort("start_time");
				SystemContext.setOrder("desc");
				SystemContext.setPageSize(6);
				//这里可能涉及到时间的问题
				Pager<OrderDetail> listordertails=IUserOrderDetailService.page_userdetails(user_guid,1,30,2);
				List<OrderDetail> odtas=listordertails.getDatas();
				model.addAttribute("odtas",listordertails);
			
			return "user/useAppraiseList";
		}
		@RequestMapping(value = "/goAppraise", method = RequestMethod.GET)
		public String goAppraise(HttpServletRequest request,Model model,@CurrentUser UserInfoDto userInfo) throws Exception{
			String order_detail_guid=request.getParameter("detail_guid");
			User user =userInfo.getUser();
			int user_guid=user.getUser_guid();
			OrderDetail od=IUserOrderDetailService.loadOrderDetail(user_guid,order_detail_guid);
			model.addAttribute("od", od);
			return "user/userAppraiseInfo";
		}
		@RequestMapping(value = "/addAppraise", method = RequestMethod.POST)
		@ResponseBody
		public String addAppraise(HttpServletRequest request,Model model,@CurrentUser UserInfoDto userInfo) throws Exception{
			Subject subject = SecurityUtils.getSubject();
			String username=(String) subject.getPrincipal();
			String appraise_one=request.getParameter("appraise_one");
			String appraise_degree=request.getParameter("appraise_degree");
			String order_detail_guid=request.getParameter("order_detail_guid");
			User user =userInfo.getUser();
			int user_guid=user.getUser_guid();
			String name=null; 
			UInfo user2=userInfo.getUinfo();
			if(user2==null) {
				System.out.println("用户没有昵称");
				name="匿名";
			}else {
				name= user2.getName();
			}
			OrderDetail od=IUserOrderDetailService.loadOrderDetail(user_guid,order_detail_guid);
			if(od.getAppraise_isnot()==0) {
				System.out.println("已评价");
				return "success";
			}else {
				String main_picture=od.getPic();
				Double price=od.getPrice();
				String title=od.getProduct_name();
				String product_number=od.getAscription_guid();
				Commodity com=iCommodityService.getcommodity(product_number);
				int product_guid=0;
				if(com==null) {
					 Package pack=IPackageService.getpackages(product_number);
					 String productId=pack.getProduct_id();
					 Commodity comm=iCommodityService.getcommodity(productId);
					 product_guid=comm.getProduct_guid();
				}else {
					product_guid=com.getProduct_guid();
				}
				Random random=new Random();// 定义随机类
				int result=random.nextInt(5);
				String img=String.valueOf(result+1);
				//把值设置进评价信息
				AppraiseUser appraiseUser=new AppraiseUser();
				appraiseUser.setAppraise_no(GuidGenerator.generate());
				appraiseUser.setAppraise_degree(appraise_degree);
				appraiseUser.setAppraise_one(appraise_one);
				appraiseUser.setAppraise_status("1");
				appraiseUser.setInsert_time(new Date());
				appraiseUser.setUpdate_time(new Date());
				appraiseUser.setMain_picture(main_picture);
				appraiseUser.setOrder_detail_guid(order_detail_guid);
				appraiseUser.setTitle(title);
				appraiseUser.setPrice(price);
				appraiseUser.setShop_number(product_number);
				appraiseUser.setUser_guid(user_guid);
				appraiseUser.setProduct_guid(product_guid);
				//appraiseUser.setMain_picture(main_picture);
				int ii=IAppraiseUserService.addAppraiseUser(appraiseUser);
				if(ii>0) {
					System.out.println("添加成功"+appraiseUser.getAppraise_no());
				}else {
					System.out.println("添加失败"+appraiseUser.getAppraise_no());
				}
				//把订单详情的状态改变，成已评价的商品
				OrderDetail ods=IUserOrderDetailService.loadOrderDetail(user_guid,order_detail_guid);
				ods.setAppraise_isnot(0);
				IUserOrderDetailService.updateActive(ods);
				//把商品添加进商品评价表
				Appraise appraise=new Appraise();
				appraise.setAppraise_no(GuidGenerator.generate());
				appraise.setAppraise_degree(appraise_degree);
				appraise.setAppraise_one(appraise_one);
				appraise.setAppraise_status("1");
				appraise.setInsert_time(new Date());
				appraise.setUpdate_time(new Date());
				appraise.setMain_picture(main_picture);
				appraise.setOrder_detail_guid(order_detail_guid);
				appraise.setTitle(title);
				appraise.setPrice(price);
				appraise.setProduct_number(product_number);
				appraise.setUserImg(img);
				appraise.setProduct_guid(product_guid);
				appraise.setUser_guid(user_guid);
				appraise.setNick_name(name);
				int i=IAppraiseService.addAppraise(appraise);
				if(i>0) {
					System.out.println("添加成功"+appraise.getAppraise_no());
				}else {
					System.out.println("添加失败"+appraise.getAppraise_no());
				}
			}
			return "success";

		}
		//查看评价和评价后跳转页面
		@RequestMapping(value = "/AppraiseSuccess", method = RequestMethod.GET)
		public String AppraiseSuccess(HttpServletRequest request,Model model,@CurrentUser UserInfoDto userInfo) throws Exception{
			String order_detail_guid=request.getParameter("order_detail_guid");
			UInfo user =userInfo.getUinfo();
			User user1 =userInfo.getUser();
			int user_guid=user1.getUser_guid();
			String userImg=null;
			AppraiseUser appraise=IAppraiseUserService.loadAppraiseUser(user_guid,order_detail_guid);
			//session.setAttribute("userImg", "/img/user/Appraise/appraise-portraitv3.png");
			if(user==null) {
				System.out.println("用户信息为空！无头像");
			}else {
				userImg=((UInfo)user).getUri_pic();
			}
			//System.out.println("userImg"+userImg);
			model.addAttribute("userImg", userImg);
			model.addAttribute("appraise", appraise);
			return "user/userAppraiseSuceess";
			
		}
		
}
