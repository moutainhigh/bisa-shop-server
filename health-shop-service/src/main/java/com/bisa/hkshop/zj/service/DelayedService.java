package com.bisa.hkshop.zj.service;

import java.util.concurrent.DelayQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.bisa.hkshop.zj.basic.utility.BaseDelayed;
import com.bisa.hkshop.zj.basic.utility.ThreadPoolUtil;

@Component
public class DelayedService  implements IDelayedService{
	
	private static Logger log = LoggerFactory.getLogger(DelayedService.class);
	
    private boolean start ;     
    
    private static DelayQueue<BaseDelayed<?>> delayQueue = new DelayQueue<BaseDelayed<?>>();  
    
    //匿名的内部类
    public <T> void start(OnStartListener onStartListener,OnDelayedListener listener){  
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
                    	BaseDelayed<?> baseDelayed = delayQueue.take();  
                    	log.info("DelayService baseDelayed:"+baseDelayed);
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
      
    public void add(BaseDelayed<?> baseDelayed){  
        delayQueue.put(baseDelayed);  
    }  

    //返回当前所有的队列
    public BaseDelayed<?>[] getDelayQueue(){
    	BaseDelayed<?>[] array = delayQueue.toArray(new BaseDelayed<?>[]{});  
    	return array;
    }
    
    
	@SuppressWarnings("unchecked")
	public <T, D extends BaseDelayed<?>> D remove(Class<D>clazz, T value){  
    	BaseDelayed<?>[] array = delayQueue.toArray(new BaseDelayed<?>[]{});  
		if(array == null || array.length <= 0){  
			return null;  
		}  
		D target = null;  
		for(BaseDelayed<?> delayed : array){  
			if(clazz != delayed.getClass()){
				continue;
			}
			if(delayed.getValue().equals(value)){  
				target = (D)delayed;  
				break;  
			}  
		}  
		if(target != null){  
		      delayQueue.remove(target);  
		}  
		return target;
    } 
}
