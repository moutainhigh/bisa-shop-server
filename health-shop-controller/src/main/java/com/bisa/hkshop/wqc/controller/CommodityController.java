package com.bisa.hkshop.wqc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bisa.health.entity.Pager;
import com.bisa.health.model.SystemContext;
import com.bisa.hkshop.model.Appraise;
import com.bisa.hkshop.model.Commodity;
import com.bisa.hkshop.model.CommodityImg;
import com.bisa.hkshop.model.Package;
import com.bisa.hkshop.wqc.basic.dao.StringUtil;
import com.bisa.hkshop.wqc.service.IAppraiseService;
import com.bisa.hkshop.wqc.service.ICommodityImgService;
import com.bisa.hkshop.wqc.service.ICommodityService;
import com.bisa.hkshop.wqc.service.IPackageService;


@Controller
@RequestMapping("/l")
public class CommodityController {
	@Autowired
	private ICommodityService iCommodityService;

	@Autowired
	private IPackageService IPackageService;
	@Autowired
	private IAppraiseService IAppraiseService;
	@Autowired
	private ICommodityImgService ICommodityImgService;
	/**
	 *  获取所有商品列表(带分页)
	 */
	@RequestMapping(value = "/shopping", method = RequestMethod.GET)
	public String requestReport(String sort, String order,Model model,HttpServletRequest request){
		//CommodityImg d=new CommodityImg();
		return "shopping/shopping";
	}
	/**
	 * 根据商品id获取商品详情
	 * @return
	 */
	@RequestMapping(value="/shopping/getCommodityId",method=RequestMethod.GET)
	public String getCommodityId(HttpServletRequest request,Model model) {
		String shop_Number=request.getParameter("shop_number");
		Commodity commodity = iCommodityService.getcommodity(shop_Number);
		model.addAttribute("commodity", commodity);
		String classification=commodity.getClassification();
		List<Commodity> listproduct=iCommodityService.selthreeCon(classification);
		model.addAttribute("listproduct", listproduct);
		List<Package> pack=IPackageService.getpackage(shop_Number);
		model.addAttribute("pack", pack);
		//悉心服务
		Commodity comm = iCommodityService.getcommodity("51409f91960848579d64bd5f103ea66a");
		model.addAttribute("comm", comm);
		List<CommodityImg> CommodityImg=ICommodityImgService.getCommodityImg(shop_Number);
		model.addAttribute("CommodityImg", CommodityImg);
		
        	
        
		return "shopping/product";
		
	}

	/**
	 * 添加商品
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/shopping/addCommodity",method=RequestMethod.POST)
	public String addCommmodity(HttpServletRequest request,Model model) {
		return null;
	}
	/**
	 * 修改商品
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/shopping/updateCommodity",method=RequestMethod.POST)
	public String updateCommmodity(HttpServletRequest request,Model model) {
		
		return null;
	}
	/**
	 * 删除商品
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/shopping/delCommodity",method=RequestMethod.POST)
	public String delCommmodity(HttpServletRequest request,Model model) {
		return null;
	}
	/**
	 * 查看用户评价
	 */
	@RequestMapping(value="/shopping/Uappraise",method=RequestMethod.GET)
	public String Uappraise(HttpServletRequest request,Model model) {
		String productId=request.getParameter("productId");
		String appraise_more=request.getParameter("appraise_more");
		//查询商品编号
		Commodity commodity=iCommodityService.getcommodity(productId);
		int product_guid=commodity.getProduct_guid();
		
		int pager_offset=0;
		String offset=request.getParameter("pager.offset");
		if(StringUtil.isNotEmpty(offset)) {
			pager_offset=Integer.parseInt(offset);
		}
		if(pager_offset!=0) {
			SystemContext.setPageOffset(pager_offset);
		}

		SystemContext.setSort("update_time");
		SystemContext.setOrder("desc");
		SystemContext.setPageSize(6);
		
		Pager<Appraise> appraise=IAppraiseService.loadAppraiseList(product_guid);
		model.addAttribute("productDto", appraise);
		model.addAttribute("comm", commodity);
		return "shopping/Uappraise";
		}
	@RequestMapping(value="/shopping/addUappraise",method=RequestMethod.GET)
	public @ResponseBody Map<String,List<Appraise>> addUappraise1(HttpServletRequest request,Model model) {
		String productId=request.getParameter("productId");
		String appraise_more=request.getParameter("appraise_more");
		//查询商品编号
		Commodity commodity=iCommodityService.getcommodity(productId);
		int product_guid=commodity.getProduct_guid();
		
		int pager_offset=0;
		String offset=request.getParameter("pager.offset");
		int pageNum=0;
		pageNum=Integer.parseInt(request.getParameter("pageNum"));
		
		if(StringUtil.isNotEmpty(offset)) {
			pager_offset=Integer.parseInt(offset);
		}
		if(pager_offset!=0) {
			SystemContext.setPageOffset((pageNum-1)*6);
		}
		
		SystemContext.setSort("update_time");
		SystemContext.setOrder("desc");
		SystemContext.setPageSize(6);
		int pageSize=SystemContext.getPageSize();
		Pager<Appraise> appraise=IAppraiseService.loadAppraiseList(product_guid);
		pager_offset=(pageNum-1)*pageSize;
		pageNum++;
		
		List<Appraise> list=appraise.getDatas();
        String url="&pager.offset="+pager_offset+"&pageNum="+pageNum+"";
        Map<String,List<Appraise>> map=new HashMap<String,List<Appraise>>();
        map.put(url, list);
        
		return map;
	}
		
	}

	

