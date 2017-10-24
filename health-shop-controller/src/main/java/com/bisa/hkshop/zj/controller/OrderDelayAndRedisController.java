package com.bisa.hkshop.zj.controller;

import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	private IDelayedService service;
	
	private static Logger logger = LogManager.getLogger(OrderDelayAndRedisController.class.getName());
	//项目启动时，将redis里的数据加载到delayed队列中
	@PostConstruct
	public void delayed() {
		logger.info("开始初始化订单队列");
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
