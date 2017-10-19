package com.bisa.hkshop.wqc.Queue;

import java.util.List;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DelayOrderServiceImpl{ //implements DelayOrderService.OnDelayedListener{
	 
	private static final Logger log = LogManager.getLogger(DelayOrderService.class.getName());

	 @Autowired  
	 DelayOrderService DelayOrderService;

	//自动收货  
	
	/*public void onDelayedArrived(BaseDelayed order) {
		// TODO Auto-generated method stub
		 ThreadPoolUtil.execute(new Runnable(){  
             public void run(){  
                String orderId = order.getOrder_no();
                 //查库判断是否需要自动收货  
                 log.error("自动确认收货，onDelayedArrived():"+orderId);  
             }  
         });
	} */
        
     
}
