package com.bisa.hkshop.gigi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bisa.health.entity.Pager;
import com.bisa.health.model.SystemContext;

import com.bisa.hkshop.gigi.service.INewsService;
import com.bisa.hkshop.model.News;


/**
 * 新闻
 * @author Administrator
 *
 */
@RequestMapping(value = "/l")
@Controller
public class NewsController {
	@Autowired
	private INewsService iNewsService;
	/**
	 * 健康咨询
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/healthInquiry", method = RequestMethod.GET)
	public String healthInquiry(HttpServletRequest request,Model model){
		/**
		 * 按时间倒序加载新闻分页
		 */
		SystemContext.setSort("release_time");
		SystemContext.setOrder("desc");
		SystemContext.setPageSize(10);
		Pager<News> newsPager = iNewsService.getPagerNews();
		System.out.println("总条数："+newsPager.getDatas().size());
		
		System.out.println("第几页："+SystemContext.getPageOffset());
		
		System.out.println("每页显示条数："+SystemContext.getPageSize());
		model.addAttribute("newsPager", newsPager);
		return "news/HK_NewsIndex";
	}
	/**
	 * 新闻详情 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/newsDetail", method = RequestMethod.GET)
	public String newsDetail(HttpServletRequest request,int news_id,Model model){
		/**
		 * 上一篇
		 */
		News last = iNewsService.getNewsById(news_id-1);
		if(last!=null){
			model.addAttribute("lastNew", last);
		}
		/**
		 * 当前新闻
		 */
		News current =  iNewsService.getNewsById(news_id);
		model.addAttribute("currentDetail", current);
		/**
		 * 增加阅读量
		 */
		current.setRead_quantity(current.getRead_quantity()+1);
		Boolean result = iNewsService.updateNews(current);
		if(!result){
			/**
			 * 没有修改成功，log日志
			 */
		}
		
		/**
		 * 下一篇
		 */
		News next = iNewsService.getNewsById(news_id+1);
		if(next!=null){
			model.addAttribute("nextNew", next);
		}
		
		/**
		 * 更多
		 */
		List<News> moreNews= iNewsService.getTop4ListNews();
		model.addAttribute("more", moreNews);
		return "news/HK_NewsContent";
	}
	
}
