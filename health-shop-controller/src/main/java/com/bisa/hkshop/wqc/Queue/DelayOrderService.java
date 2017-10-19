package com.bisa.hkshop.wqc.Queue;

import java.util.concurrent.DelayQueue;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;



@Service
public class DelayOrderService {
	private static final Logger log = LogManager.getLogger(DelayOrderService.class.getName());
	private boolean start;    
    //private OnDelayedListener listener;  
    private DelayQueue<BaseDelayed> delayQueue = new DelayQueue<BaseDelayed>();  
   // private DelayQueue<BaseDelayed<?>> delayQueue = new DelayQueue<BaseDelayed<?>>();  
    public static interface OnDelayedListener{  
       // public void onStart();  
    	public void onDelayedArrived(BaseDelayed delayed);  
    }   
    public static interface OnStartListener{
    	public void onStart();
    }

    public  void start(final OnStartListener onStartListener, final OnDelayedListener listener){  
        if(start){  
            return;  
        }  
        log.debug("DelayService start...");
        start = true;  
        //启动DelayQueue
        new Thread(new Runnable(){  
            public void run(){  
                try{  
                    while(true){  
                    	BaseDelayed baseDelayed = delayQueue.take();  
                    	log.debug("DelayService baseDelayed:"+baseDelayed);
                        if(listener != null){ 
                        	ThreadPoolUtil.execute(new Runnable(){
                        		public void run(){
                        			listener.onDelayedArrived(baseDelayed);  
                        		}
                        	});
                        }  
                    }  
                }catch(Exception e){  
                    e.printStackTrace();  
                }  
            }  
        }).start();
        //回调出去
        if(onStartListener != null){
        	ThreadPoolUtil.execute(new Runnable(){
				@Override
				public void run() {
					onStartListener.onStart();
				}
        	});
        }
    }  
      
    public void add(BaseDelayed baseDelayed){  
        delayQueue.put(baseDelayed);  
    }  

	@SuppressWarnings("unchecked")
	public void remove(String orderId){  
        BaseDelayed[] array = delayQueue.toArray(new BaseDelayed[]{});  
        if(array == null || array.length <= 0){  
            return;  
        }  
        BaseDelayed target = null;  
        for(BaseDelayed order : array){  
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
