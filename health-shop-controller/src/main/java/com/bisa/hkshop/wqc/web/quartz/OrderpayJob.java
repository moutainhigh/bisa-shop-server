package com.bisa.hkshop.wqc.web.quartz;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.dao.DataAccessException;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import com.bisa.health.utils.CacheUtity;
import com.bisa.hkshop.model.Order;
import com.bisa.hkshop.model.OrderDetail;
import com.bisa.hkshop.wqc.service.IOrderDetailService;
import com.bisa.hkshop.wqc.service.IOrderService;
import com.bisa.hkshop.wqc.service.IUserOrderDetailService;
import com.bisa.hkshop.wqc.service.IUserOrderService;

public class OrderpayJob implements Job{
	@Resource(name = "orderPayTimer")
	private RedisTemplate orderPayTimer;
	public static final String ORDER_MANAGER_KEY = "orderManager";
	public static final String ORDER_TWO_KEY = "sessionTwoManager";
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		JobDataMap jobDataMap = context.getMergedJobDataMap();
		IUserOrderService IUserOrderService = (IUserOrderService) jobDataMap.get(ORDER_MANAGER_KEY);
		IUserOrderDetailService IUserOrderDetailService=(IUserOrderDetailService)jobDataMap.get(ORDER_TWO_KEY);
		System.out.println(".............IOrderService" + (IUserOrderService));
		System.out.println(".............IUserOrderDetailService" + (IUserOrderDetailService));
		/**
		 *  从缓存里取出订单
		 */
		String isCode;
		try {
			/*isCode = (String) orderPayTimer.execute(new RedisCallback<Object>() {
				public Object doInRedis(RedisConnection connection) throws DataAccessException {
					String sms_key = "order_userguid" + order.getUser_guid();
					byte[] value = connection.get(sms_key.getBytes());
					return CacheUtity.toObject(value);
				}
			});*/
			/**
			 * 拿到所有的redis,进行遍历
			 */
			/*for(Order order:value) {
				//如何拿出订单的值啊。
				List<Order> orderList=IUserOrderService.Ordertra_statusList(order.getUser_guid(), 10, 1);
				if(orderList==null) {
					System.out.println("订单列表没有代付款的订单");
				}
				for(Order orderTwo:orderList){
					long orderTime=orderTwo.getStart_time().getTime()+(1483286400-1483200000);
					long time = System.currentTimeMillis();
					if(orderTime>time) {
						orderTwo.setTra_status(50);
						orderTwo.setEffective_statu(2);
						int i=IUserOrderService.updateOrder(order.getUser_guid(), orderTwo);
						if(i>0) {
							System.out.println("订单关闭成功"+order.getOrder_no());
						}else {
							System.out.println("订单关闭失败"+order.getOrder_no());
						}
						 List<OrderDetail> OrdertailList=IUserOrderDetailService.loadOrderDetailList(order.getUser_guid(), order.getOrder_no());
						 for(OrderDetail OrderDetail: OrdertailList) {
							 OrderDetail.setTra_status(50);
							 OrderDetail.setAppraise_status(2);
							 int od=IUserOrderDetailService.updateActive(OrderDetail);
							 if(od>0) {
									System.out.println("订单详情关闭成功"+OrderDetail.getOrder_detail_guid());
								}else {
									System.out.println("订单详情关闭失败"+OrderDetail.getOrder_detail_guid());
								}
						 }
					}
				}
				
			}*/
			
		} catch (Exception e1) {
			//return new AppServer(400, be.TokenTimeOut, null, null, null, null, null, null, null);
			System.out.println("异常");
		}
		

	}
}
