package com.bisa.hkshop.wqc.web.quartz;

import java.util.List;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.bisa.hkshop.model.Order;
import com.bisa.hkshop.wqc.service.IOrderService;
import com.bisa.hkshop.wqc.service.IUserOrderService;

public class OrderpayJob implements Job{

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		
	}

	//public static final String SESSION_MANAGER_KEY = "sessionManager";
	
	/*@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		JobDataMap jobDataMap = context.getMergedJobDataMap();
		IUserOrderService IUserOrderService = (IUserOrderService) jobDataMap.get(SESSION_MANAGER_KEY);
		System.out.println("............." + (IUserOrderService));
		int user_guid=2;
		List<Order> order=IUserOrderService.Ordertra_statusList2(user_guid, 10);
		if(order==null){
			System.out.println("用户没有订单>>"+user_guid);
		}else{
			for(Order od:order){
				
			}
		}*/
	//}

}
