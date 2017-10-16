package com.bisa.hkshop.wqc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.bisa.health.model.SystemContext;




public class SystemContextFilter implements Filter{
	private Integer pageSize;

	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		//System.out.println("=======guolv");
		Integer offset = 0;
		try {
			offset = Integer.parseInt(req.getParameter("pager.offset"));
		} catch (NumberFormatException e) {}
		try {
			SystemContext.setOrder(req.getParameter("order"));
			SystemContext.setSort(req.getParameter("sort"));
			SystemContext.setPageOffset(offset);
			SystemContext.setPageSize(pageSize);
			SystemContext.setRealPath(((HttpServletRequest)req).getSession().getServletContext().getRealPath("/"));
			chain.doFilter(req,resp);
		} finally {
			SystemContext.removeOrder();
			SystemContext.removeSort();
			SystemContext.removePageOffset();
			SystemContext.removePageSize();
			SystemContext.removeRealPath();
		}
	}

	public void init(FilterConfig cfg) throws ServletException {
		//System.out.println("=======guolv");
		try {
			pageSize = Integer.parseInt(cfg.getInitParameter("pageSize"));
			//System.out.println("============"+pageSize);
		} catch (NumberFormatException e) {
			pageSize = 2;
			//System.out.println("开始============"+pageSize);
		}
	}

}
