package com.bisa.hkshop.wqc.service;

import java.util.concurrent.DelayQueue;

import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.druid.support.logging.LogFactory;
import com.bisa.hkshop.Queue.OrderpayJob;

@Service
public class DelayOrderService {
	private static final Logger log = (Logger) LogFactory.getLog(DelayOrderService.class);

	
	private boolean start ;    
    private OnDelayedListener listener;  
    private DelayQueue<OrderpayJob> delayQueue = new DelayQueue<OrderpayJob>();  
    
    public static interface OnDelayedListener{  
        public void onDelayedArrived(OrderpayJob order);  
    }   
    public void start(OnDelayedListener listener){  
        if(start){  
            return;  
        }  
        log.error("DelayService 启动");  
        start = true;  
        this.listener = listener;  
        new Thread(new Runnable(){  
            public void run(){  
                try{  
                    while(true){  
                    	OrderpayJob order = delayQueue.take();  
                        if(DelayOrderService.this.listener != null){  
                        	DelayOrderService.this.listener.onDelayedArrived(order);  
                        }  
                    }  
                }catch(Exception e){  
                    e.printStackTrace();  
                }  
            }  
        }).start();;
    }  
    public void add(OrderpayJob order){  
        delayQueue.put(order);  
    }  
  
    public boolean remove(OrderpayJob order){  
        return delayQueue.remove(order);  
    }  
      
     
      
    public void remove(String orderId){  
        OrderpayJob[] array = delayQueue.toArray(new OrderpayJob[]{});  
        if(array == null || array.length <= 0){  
            return;  
        }  
        OrderpayJob target = null;  
        for(OrderpayJob order : array){  
            if(order.getOrder_no() == orderId){  
                target = order;  
                break;  
            }  
        }  
        if(target != null){  
            delayQueue.remove(target);  
        }  
    }  
    
}
