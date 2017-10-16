package com.bisa.hkshop.wqc.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bisa.hkshop.model.Package;
import com.bisa.hkshop.model.Packdetails;
import com.bisa.hkshop.model.Cart;
import com.bisa.hkshop.model.Commodity;
import com.bisa.hkshop.wqc.basic.dao.StringUtil;
import com.bisa.hkshop.wqc.basic.utility.GuidGenerator;
import com.bisa.hkshop.wqc.service.IPackdetailsService;
import com.bisa.hkshop.wqc.service.ICartService;
import com.bisa.hkshop.wqc.service.ICommodityService;
import com.bisa.hkshop.wqc.service.IPackageService;


@Controller
@RequestMapping("/l")
public class CartController {
	@Autowired
	private ICartService ICartService;
	@Autowired
	private IPackdetailsService IPackdetailsService;
	@Autowired
	private IPackageService IPackageService;
	@Autowired
	private ICommodityService iCommodityService;
	

	@RequestMapping(value = "/addCart", method = RequestMethod.POST)
	@ResponseBody
	public String addCart(HttpServletRequest request,Model model,HttpSession session) throws Exception{
		Date date=new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String packId=request.getParameter("packId");
		session.setAttribute("guid", "2");
		String guid=(String) session.getAttribute("guid");
		int user_guid=Integer.parseInt(guid);
		if(user_guid!=2) {
			System.out.println("请去登录");
			return null;
		}else {
		
		String serviceId=request.getParameter("serviceId");
		String issingleorcombo=request.getParameter("issingleorcombo");
		String service_number=request.getParameter("service_number");
		String cart_product=request.getParameter("cart_product");//判断从哪个页面过来的
			if(StringUtil.isEmpty(cart_product)){
				//是否是单品还是套餐
				if("1".equals(issingleorcombo)) {
				Package pack=IPackageService.getpackages(packId);
				Cart cart=ICartService.getCart(user_guid,packId);
					if(cart==null) {
						cart=new Cart();//这里是空的，就set,肯定空异常
						cart.setCart_number(GuidGenerator.generate());
						cart.setNumber(1);
						cart.setPrice(pack.getPrice());
						cart.setTitle(pack.getPatitle());
					//	cart.setTotal(pack.getPrice()*1.0);
						cart.setUser_guid(user_guid);
						cart.setPackId(packId);
						cart.setMain_picture(pack.getMain_picture());
						cart.setSing_cox("1");
						cart.setTotal(1.0*cart.getPrice());
						//插入更新时间
						cart.setInsert_time(df.parse(df.format(date)));
						cart.setUpdate_time(df.parse(df.format(date)));
						ICartService.addCart(user_guid,cart);
					}else {
						cart.setNumber(cart.getNumber()+1);
						String i=String.valueOf(cart.getNumber());
						cart.setTotal(Double.parseDouble(i)*cart.getPrice());
						cart.setUpdate_time(df.parse(df.format(date)));
						ICartService.updateCart(user_guid,cart);
					}
				}
				if("1".equals(serviceId) || "0".equals(issingleorcombo)) {
					Cart cart2=ICartService.getCart(user_guid,packId);
					Cart cart3=ICartService.getCart(user_guid,service_number);
					if(cart2==null) {
						cart2=new Cart();
					 Commodity commodity=iCommodityService.getcommodity(packId);
					 	cart2.setCart_number(GuidGenerator.generate());
					 	cart2.setNumber(1);
						cart2.setPrice(commodity.getSelling_price());
						cart2.setTitle(commodity.getTitle());
					//	cart.setTotal(commodity.getPrice()*1.0);
						cart2.setUser_guid(user_guid);
						cart2.setPackId(commodity.getShop_number());
						cart2.setMain_picture(commodity.getMain_picture());
						cart2.setInsert_time(df.parse(df.format(date)));
						cart2.setUpdate_time(df.parse(df.format(date)));
						cart2.setTotal(1.0*cart2.getPrice());
						cart2.setSing_cox("0");
						ICartService.addCart(user_guid,cart2);
						//判断服务
						if(cart3==null) {
							cart3=new Cart();
							Commodity commo=iCommodityService.getcommodity(service_number);
						 	cart3.setCart_number(GuidGenerator.generate());
						 	cart3.setNumber(1);
							cart3.setPrice(commo.getSelling_price());
							cart3.setTitle(commo.getTitle());
						//	cart.setTotal(commo.getPrice()*1.0);
							cart3.setUser_guid(user_guid);
							cart3.setPackId(commo.getShop_number());
							cart3.setMain_picture(commo.getMain_picture());
							cart3.setInsert_time(df.parse(df.format(date)));
							cart3.setUpdate_time(df.parse(df.format(date)));
							cart3.setTotal(1.0*cart3.getPrice());
							cart3.setSing_cox("2");
							ICartService.addCart(user_guid,cart3);
						}else{
							cart3.setNumber(cart3.getNumber()+1);
							String i=String.valueOf(cart3.getNumber());
							cart3.setTotal(Double.parseDouble(i)*cart3.getPrice());
							cart3.setUpdate_time(df.parse(df.format(date)));
							ICartService.updateCart(user_guid,cart3);
						}
					}else {
						cart2.setNumber(cart2.getNumber()+1);
						String i=String.valueOf(cart2.getNumber());
						cart2.setTotal(Double.parseDouble(i)*cart2.getPrice());
						cart2.setUpdate_time(df.parse(df.format(date)));
						ICartService.updateCart(user_guid,cart2);
						//判断服务
						if(cart3==null) {
							cart3=new Cart();
							Commodity commo=iCommodityService.getcommodity(service_number);
						 	cart3.setCart_number(GuidGenerator.generate());
						 	cart3.setNumber(1);
							cart3.setPrice(commo.getSelling_price());
							cart3.setTitle(commo.getTitle());
						//	cart.setTotal(commo.getPrice()*1.0);
							cart3.setUser_guid(user_guid);
							cart3.setPackId(commo.getShop_number());
							cart3.setMain_picture(commo.getMain_picture());
							cart3.setInsert_time(df.parse(df.format(date)));
							cart3.setUpdate_time(df.parse(df.format(date)));
							cart3.setTotal(1.0*cart3.getPrice());
							cart3.setSing_cox("2");
							ICartService.addCart(user_guid,cart3);
						}else{
							cart3.setNumber(cart3.getNumber()+1);
							String w=String.valueOf(cart3.getNumber());
							cart3.setTotal(Double.parseDouble(w)*cart3.getPrice());
							cart3.setUpdate_time(df.parse(df.format(date)));
							ICartService.updateCart(user_guid,cart3);
						
						}
					}
				}
			}else {
				Cart cart3=ICartService.getCart(user_guid,service_number);
				if(cart3==null) {
					cart3=new Cart();
					Commodity commo=iCommodityService.getcommodity(service_number);
				 	cart3.setCart_number(GuidGenerator.generate());
				 	cart3.setNumber(1);
					cart3.setPrice(commo.getSelling_price());
					cart3.setTitle(commo.getTitle());
				//	cart.setTotal(commo.getPrice()*1.0);
					cart3.setUser_guid(user_guid);
					cart3.setPackId(commo.getShop_number());
					cart3.setMain_picture(commo.getMain_picture());
					cart3.setInsert_time(df.parse(df.format(date)));
					cart3.setUpdate_time(df.parse(df.format(date)));
					cart3.setTotal(1.0*cart3.getPrice());
					cart3.setSing_cox("2");
					ICartService.addCart(user_guid,cart3);
				}else{
					cart3.setNumber(cart3.getNumber()+1);
					String w=String.valueOf(cart3.getNumber());
					cart3.setTotal(Double.parseDouble(w)*cart3.getPrice());
					cart3.setUpdate_time(df.parse(df.format(date)));
					ICartService.updateCart(user_guid,cart3);
				
				}
			}
		}
				return "success";

	}
	@RequestMapping(value = "/Cart", method = RequestMethod.GET)
	public String getCart(HttpServletRequest request,Model model,HttpSession session) throws Exception{
		//String packId=request.getParameter("packId");
		//String guid=request.getParameter("userId");
		session.setAttribute("guid", "2");
		String guid=(String) session.getAttribute("guid");
		int user_guid=Integer.parseInt(guid);
		if(user_guid!=2) {
			System.out.println("请去登录");
			return null;
		}else {
			//查看购物车
			//遍历购物车商品
			List<Cart> listcart=ICartService.selCart(user_guid);
			int cartNum=listcart.size();
			//遍历是否有套餐
			List<Packdetails> listPackdetails=new ArrayList<>(); //
	//		List<Packdetails> listPackdetailss=new ArrayList<>();
			Map<String,List<Packdetails>> map= new HashMap<String,List<Packdetails>>();  
			for(Cart c:listcart) {
				String pi=c.getPackId();
				listPackdetails=IPackdetailsService.getpackdetails(pi);
				map.put(pi, listPackdetails);		
	//		 	listPackdetails.add(c);
			}
			List<Commodity> comm=iCommodityService.getTypecommodity("3001");
			model.addAttribute("cartNum", cartNum);
			model.addAttribute("comm", comm);
			model.addAttribute("listcart", listcart);
			//model.addAttribute("listPackdetails", listPackdetails);
			model.addAttribute("mapPackdetails", map);
		}
		return "shopping/cart";
}
	@RequestMapping(value = "/delCart", method = RequestMethod.POST)
	@ResponseBody
	public String delCart(HttpServletRequest request,Model model,HttpSession session) throws Exception{
		session.setAttribute("guid", "2");
		String guid=(String) session.getAttribute("guid");
		int user_guid=Integer.parseInt(guid);
		if(user_guid!=2) {
			System.out.println("请去登录");
			return null;
		}else {
			String deleteId=request.getParameter("deleteId");
			int i=ICartService.delCart(user_guid,deleteId);
			String result=null;
			if(i>0) {
				result="success";
			}else {
				result="false";
			}
			return result;
		}
	}
	@RequestMapping(value = "/upCart", method = RequestMethod.POST)
	@ResponseBody
	public String upCart(HttpServletRequest request,Model model,HttpSession session) throws Exception{
		session.setAttribute("guid", "2");
		String guid=(String) session.getAttribute("guid");
		int user_guid=Integer.parseInt(guid);
		if(user_guid!=2) {
			System.out.println("请去登录");
			return null;
		}else {
		String num=request.getParameter("num");
		String productId=request.getParameter("packId");
		String result=null;
		Cart product=ICartService.getCart(user_guid,productId);
			product.setNumber(Integer.parseInt(num));
			int i=ICartService.updateCart(user_guid,product);
			if(i>0) {
				result="success";
			}else {
				result="error";
			}
		return result;
		}
	}
}
