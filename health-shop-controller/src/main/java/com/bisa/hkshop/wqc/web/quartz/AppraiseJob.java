package com.bisa.hkshop.wqc.web.quartz;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.bisa.hkshop.model.Order;
import com.bisa.hkshop.model.OrderDetail;
import com.bisa.hkshop.wqc.service.IAppraiseService;
import com.bisa.hkshop.wqc.service.IOrderDetailService;
import com.bisa.hkshop.wqc.service.IOrderService;
import com.bisa.hkshop.wqc.service.IUserOrderDetailService;
import com.bisa.hkshop.wqc.service.IUserOrderService;

public class AppraiseJob implements Job{
	private  Logger logger =LogManager.getLogger(AppraiseJob.class);
	public static final String APPRAISE_MANAGER_KEY = "AppraiseManager";
	public static final String ORDER_MANAGER_KEY = "OrderManager";
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		JobDataMap jobDataMap = context.getMergedJobDataMap();
		IUserOrderDetailService IUserOrderDetailService = (IUserOrderDetailService) jobDataMap.get(APPRAISE_MANAGER_KEY);
		IUserOrderService IUserOrderService=(IUserOrderService)jobDataMap.get(ORDER_MANAGER_KEY);
		System.out.println(".............IUserOrderDetailService" + (IUserOrderDetailService));
		System.out.println(".............IUserOrderService" + (IUserOrderService));
		//业务逻辑,查询所有用户，把他们评价
		//1.购买1个月未评价的商品，归类为评价失效商品，并不能再评价。
		int user_guid=2;
		List<OrderDetail> OrderDetail=IUserOrderDetailService.Appraiselist(user_guid,0,30,1);
		for(OrderDetail od:OrderDetail) {
			long i=od.getStart_time().getTime();
			long monthTime=i+(250600);
			long dangTime=System.currentTimeMillis();
			if(dangTime>monthTime) {
				od.setAppraise_status(2);
				int isnot=IUserOrderDetailService.updateActive(od);
				if(isnot>0){
					logger.error(user_guid+"修改订单详情成功为无效，订单号为"+od.getOrder_detail_guid());
				}else{
					logger.error(user_guid+"修改订单详情失败为无效，订单号为"+od.getOrder_detail_guid());
				}
				 String order_no=od.getOrder_no();
				 Order Order=IUserOrderService.loadOrderByOrderId(user_guid, order_no);
				 Order.setAppraise_status(2);
				 int orderis_not=IUserOrderService.updateOrder(user_guid, Order);
				 if(orderis_not>0){
						logger.error(user_guid+"修改订单成功为无效，订单号为"+Order.getOrder_no());
				 }else{
					logger.error(user_guid+"修改订单失败为无效，订单号为"+Order.getOrder_no());
				 }
			}else {
				logger.error(new Date()+"当天时间不需要改评价无效"+od.getOrder_detail_guid());
			}
		}
		
	}

}
