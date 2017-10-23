package com.bisa.hkshop.zj.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bisa.health.appserver.utils.CacheUtity;
import com.bisa.hkshop.model.Order;
import com.bisa.hkshop.model.OrderDetail;
import com.bisa.hkshop.wqc.basic.utility.KdniaoTrackQueryAPI;
import com.bisa.hkshop.wqc.service.IOrderDetailService;
import com.bisa.hkshop.wqc.service.IOrderService;
import com.bisa.hkshop.zj.basic.utility.BaseDelayed;
import com.bisa.hkshop.zj.basic.utility.DelayedService;
import com.bisa.hkshop.zj.basic.utility.DelayedService.OnDelayedListener;
import com.bisa.hkshop.zj.basic.utility.DelayedService.OnStartListener;
import com.bisa.hkshop.zj.basic.utility.ThreadPoolUtil;
import com.bisa.hkshop.zj.component.IOrderRedis;
/*
 * 还有的问题，1：声明队列为全局变量 2：redis的有效时间
 */

@Controller
@RequestMapping("/l")

public class OrderCloseTestController {
	@Autowired  
	private IOrderService IOrderService;
	@Autowired
	private IOrderDetailService IOrderDetailService;
	@Autowired
	private IOrderRedis orderRedis;
	
	public static class DelayedOrder extends BaseDelayed<String>{
		public DelayedOrder(int timeout, String orderId,int uid){
			super(timeout, orderId,uid);
		}
		public String getOrderId(){
			return super.getValue();
		}
	}
	
	DelayedService service=null;
	DelayedService service1 = null;
	//项目启动时，将redis里的数据加载到delayed队列中
	@PostConstruct
	public void delayed() {
		service = new DelayedService();
		
		service1 = new DelayedService();
		
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
				orderRedis.delOrderRedis(delayed);
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
				BaseDelayed<String> new_delayed = new BaseDelayed<String>(time,delayed.getValue(),delayed.getUid());
				service.add(new_delayed);
			}
		}
	}
	    
	
	//添加订单到队列、和redis中
	@RequestMapping(value="/test_add_delayed",method=RequestMethod.GET)
	public String test_add_delayed(HttpServletRequest request){
		
		int intTime = Integer.valueOf(request.getParameter("intTime"));
		String order_no = request.getParameter("order_no");
		
		BaseDelayed<String> delayedOrder = new BaseDelayed<String>(intTime,order_no,2);
		
		System.out.println(">>>>>>>>>>>>dingdan"+delayedOrder.getValue());
		
		service.add(delayedOrder);//存到队列中
		orderRedis.addOrderRedis(delayedOrder);//存到redis中
		
		return "";
	}
	
	
	
	//队列到时间后，自动出队列
	@RequestMapping(value="/testdelayed",method=RequestMethod.GET)
	public String testdelayed(HttpServletRequest request){
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
			}
		});
		return "";
	}
	
	
	//打印队列中的值
	@RequestMapping(value="/getDelayQue",method=RequestMethod.GET)
	public void getDelayQue(Model model){
		if(service!=null){
			BaseDelayed<?>[] array = service.getDelayQueue();
			for (BaseDelayed<?> delayed : array) {
				System.out.println(delayed.getUid() + "   " + delayed.getStartTime()+"   " + delayed.getValue());
			}
		}
	}
	
	
}
