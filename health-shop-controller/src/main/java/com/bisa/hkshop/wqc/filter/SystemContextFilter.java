package com.bisa.hkshop.wqc.filter;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.bisa.health.model.SystemContext;

public class SystemContextFilter extends PathMatchingFilter implements ApplicationContextAware {
	
	private Integer pageSizeDefalut=6;
	private Integer pageSize=pageSizeDefalut;
	
	
	
	public SystemContextFilter() {
		super();
		System.out.println(">>>>>>>>>>>>applicationContext>>>>>>>>>>>"+(applicationContext==null));
	}
	@Override
	protected boolean onPreHandle(ServletRequest req, ServletResponse response, Object mappedValue)
			throws Exception {
		
		
		Integer offset = 0;
		try {
			pageSize = Integer.parseInt(req.getParameter("pageSize"));
		} catch (NumberFormatException e) {
			pageSize = pageSizeDefalut;
		}
		try {
			offset = Integer.parseInt(req.getParameter("pager.offset"));
		} catch (NumberFormatException e) {}
		try {
			SystemContext.setOrder(req.getParameter("order"));
			SystemContext.setSort(req.getParameter("sort"));
			SystemContext.setPageOffset(offset);
			SystemContext.setPageSize(pageSize);
			SystemContext.setRealPath(((HttpServletRequest)req).getSession().getServletContext().getRealPath("/"));
			return true;
		} catch (Exception e) {

			SystemContext.removeOrder();
			SystemContext.removeSort();
			SystemContext.removePageOffset();
			SystemContext.removePageSize();
			SystemContext.removeRealPath();
			return true;
		
		}
	
	}
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
    private ApplicationContext applicationContext;

}
