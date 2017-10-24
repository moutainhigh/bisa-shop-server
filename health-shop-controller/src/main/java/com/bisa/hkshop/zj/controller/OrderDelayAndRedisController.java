package com.bisa.hkshop.zj.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bisa.hkshop.model.Order;
import com.bisa.hkshop.model.OrderDetail;
import com.bisa.hkshop.wqc.basic.utility.KdniaoTrackQueryAPI;
import com.bisa.hkshop.wqc.service.IOrderDetailService;
import com.bisa.hkshop.wqc.service.IOrderService;
import com.bisa.hkshop.zj.basic.utility.BaseDelayed;
import com.bisa.hkshop.zj.component.IOrderRedis;
import com.bisa.hkshop.zj.service.IDelayedService;
import com.bisa.hkshop.zj.service.OnDelayedListener;
/*
 * 还有的问题，1：声明队列为全局变量 2：redis的有效时间
 */
import com.bisa.hkshop.zj.service.OnStartListener;

@Controller
@RequestMapping("/l")

public class OrderDelayAndRedisController {
	
	@Autowired
	private IOrderRedis orderRedis;
	
	@Autowired
	 private IOrderService orderService;
	 
	 @Autowired
	 private IOrderDetailService orderDetailService;
	 
	@Autowired
	private IDelayedService service;
	
	public   String[] AcceptStation; 
    public  String[] AcceptTime;
	
	private static Logger logger = LogManager.getLogger(OrderDelayAndRedisController.class.getName());
	//项目启动时，将redis里的数据加载到delayed队列中
	@PostConstruct
	public void delayed() {
		logger.info("开始初始化订单队列");
		System.out.println(".............delayedService" + (service));
		service.start(new OnStartListener(){
			@Override 
			public void onStart() {
				System.out.println("启动完成");
			}
		}, 
		new OnDelayedListener(){
			//加入队列到期了之后的业务逻辑处理的方法
			@Override
			public <T extends BaseDelayed<?>> void onDelayedArrived(T delayed) {
				System.out.println("[onDelayedArrived]"+delayed.toString());
						switch (delayed.getClassId()) {
						//七天自动收货的业务
						case 7:
								 Order od = orderService.loadOrderByOrderId(delayed.getUid(), (String)delayed.getValue());
								 String logistics_number=od.getLogistics_number(); 	
								 String logistics_name=od.getLogistics_name();
								 KdniaoTrackQueryAPI api = new KdniaoTrackQueryAPI();
								 String result;
									try {
										//result = api.getOrderTracesByJson("logistics_name", "logistics_number");
										result = api.getOrderTracesByJson("YTO", "886592328420907712");
										JSONObject jsonObj = new JSONObject(result);
										String State=jsonObj.getString("State");
										if(State.equals("3")){
											JSONArray jsonArray=jsonObj.getJSONArray("Traces");
											System.out.println("jsonArray.length():"+jsonArray.length());
											AcceptStation = new String[ jsonArray.length() ];//初始化数组
											AcceptTime = new String[ jsonArray.length()];//初始化数组
											for(int i = 0; i<jsonArray.length(); i++){
												JSONObject jsonTemp = (JSONObject)jsonArray.getJSONObject(i);
												 AcceptStation[i]=jsonTemp.getString("AcceptStation");
												 AcceptTime[i]=jsonTemp.getString("AcceptTime");
												if(AcceptStation[i].contains("已签收")||AcceptStation[i].contains("签收人")){
												 		od.setTra_status(30);
												 		String order_no=od.getOrder_no();
												 		Boolean SS=orderService.updateOrder(od.getUser_guid(), od);
												 		List<OrderDetail> OrderDetail=orderDetailService.loadOrderDetailList(od.getUser_guid(), order_no);
												 		for(OrderDetail ordertail:OrderDetail) {
												 			if(ordertail==null) {
												 				logger.error("订单无详情，订单出错");
												 			}else {
												 				ordertail.setTra_status(30);
												 				System.out.println("ordertail:"+ordertail.getTra_status());
												 				int  isnot= orderDetailService.updateActive(od.getUser_guid(), ordertail);
												 				System.out.println("ordertail2:"+ordertail.getTra_status());
												 				if(isnot>0){
												 					logger.info("订单详情:"+od.getOrder_no()+"收货了");
												 				}
												 			}
												 		}
												 		logger.info("订单:"+od.getOrder_no()+"收货了");
												 	
												}
											}
										}
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
							//记得从redis删除order		
							 orderRedis.delOrderRedis(od.getOrder_no());
							 
								//七天自动收货了之后，添加当前订单的评价30天后失效
					    	   BaseDelayed<String> delayedOrder = new BaseDelayed<String>(100,od.getOrder_no(),od.getUser_guid(),30);
					    	   service.add(delayedOrder);//存到队列中
					   		   orderRedis.addOrderRedis(delayedOrder);//存到redis中
							 
							break;
						case 24:
							
							Order orderTwo = orderService.loadOrderByOrderId(delayed.getUid(),
									(String) delayed.getValue());
							orderTwo.setTra_status(50);
							orderTwo.setEffective_statu(2);
							boolean i = orderService.updateOrder(orderTwo.getUser_guid(), orderTwo);
							if (i) {
								System.out.println("订单关闭成功" + orderTwo.getOrder_no());
							} else {
								System.out.println("订单关闭失败" + orderTwo.getOrder_no());
							}
							List<OrderDetail> OrdertailList = orderDetailService
									.loadOrderDetailList(orderTwo.getUser_guid(), orderTwo.getOrder_no());
							for (OrderDetail OrderDetail : OrdertailList) {
								OrderDetail.setTra_status(50);
								OrderDetail.setAppraise_status(2);
								int b = orderDetailService.updateActive(orderTwo.getUser_guid(), OrderDetail);
								if (b > 0) {
									System.out.println("订单详情关闭成功" + OrderDetail.getOrder_detail_guid());
								} else {
									System.out.println("订单详情关闭失败" + OrderDetail.getOrder_detail_guid());
								}
							}
							//记得从redis删除order		
							 orderRedis.delOrderRedis(orderTwo.getOrder_no());
							break;
						case 30:
							 Order order=orderService.loadOrderByOrderId(delayed.getUid(), (String)delayed.getValue());
							 List<OrderDetail> orderDetailList = orderDetailService.loadOrderDetailList(order.getUser_guid(), order.getOrder_no());
							 
							 for(OrderDetail orderDetail : orderDetailList){
								 orderDetail.setAppraise_status(2);
								 int isnot = orderDetailService.updateActive(order.getUser_guid(), orderDetail);
								 if(isnot>0){
										logger.error(order.getUser_guid()+"修改订单详情成功为无效，订单号为"+orderDetail.getOrder_detail_guid());
									}else{
										logger.error(order.getUser_guid()+"修改订单详情失败为无效，订单号为"+orderDetail.getOrder_detail_guid());
									}
							 }
							 
							 order.setAppraise_status(2);
							 boolean orderis_not=orderService.updateOrder(order.getUser_guid(),order);
							 if(orderis_not){
									logger.error(order.getUser_guid()+"修改订单成功为无效，订单号为"+order.getOrder_no());
							 }else{
								logger.error(order.getUser_guid()+"修改订单失败为无效，订单号为"+order.getOrder_no());
							 }
							 
							//记得从redis删除order	
							orderRedis.delOrderRedis(order.getOrder_no());
							 
							break;
						}
				//orderRedis.delOrderRedis(delayed);
			}
		});
		HashMap<String,BaseDelayed<String>> delayMap = orderRedis.getOrderRedis();
		if(delayMap!=null){
			for(String key : delayMap.keySet()){
				BaseDelayed<String> delayed = delayMap.get(key);
				System.out.println(delayMap.get(key).getValue());
				int time=5;
				//down机了之后重新计算出队列的时间
				if(delayed.getStartTime() > System.currentTimeMillis()){
					time = Integer.valueOf(((delayed.getStartTime() - System.currentTimeMillis()) / 1000)+"");
				}else{
					//直接操作数据库更改订单状态为收货状态
				}
				BaseDelayed<String> new_delayed = new BaseDelayed<String>(time,delayed.getValue(),delayed.getUid(),delayed.getClassId());
				service.add(new_delayed);
			}
		}
		logger.info("初始化订单队列完成");
	}
	    
	
	
	//添加订单到队列、和redis中
	@RequestMapping(value="/test_add_delayed",method=RequestMethod.GET)
	public String test_add_delayed(HttpServletRequest request){
		int intTime = Integer.valueOf(request.getParameter("intTime"));
		String order_no = request.getParameter("order_no");
		BaseDelayed<String> delayedOrder = new BaseDelayed<String>(intTime,order_no,2,7);
		System.out.println(">>>>>>>>>>>>dingdan"+delayedOrder.getValue());
		service.add(delayedOrder);//存到队列中
		orderRedis.addOrderRedis(delayedOrder);//存到redis中
		return "";
	}
	
	
	//打印队列中的值
	@RequestMapping(value="/getDelayQue",method=RequestMethod.GET)
	public void getDelayQue(Model model){
		if(service!=null){
			BaseDelayed<?>[] array = service.getDelayQueue();
			for (BaseDelayed<?> delayed : array) {
				System.out.println(delayed.getUid() + "   " + delayed.getStartTime()+"   " + delayed.getValue() + "     " + delayed.getClassId());
			}
		}
	}
	
	
}
