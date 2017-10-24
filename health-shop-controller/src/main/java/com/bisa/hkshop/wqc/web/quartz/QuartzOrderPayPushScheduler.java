package com.bisa.hkshop.wqc.web.quartz;
import java.text.ParseException;

import org.osgi.service.component.annotations.Component;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.bisa.hkshop.wqc.service.IOrderDetailService;
import com.bisa.hkshop.wqc.service.IOrderService;
import com.bisa.hkshop.wqc.service.IUserOrderDetailService;
import com.bisa.hkshop.wqc.service.IUserOrderService;
import com.bisa.hkshop.zj.component.IOrderRedis;
import com.bisa.hkshop.zj.service.IDelayedService;
@Component
public class QuartzOrderPayPushScheduler implements QuartzOrderPushSchedulerInterface {
	
	 private static final String JOB_NAME = "OrderAppraiseJob";
	 private Scheduler scheduler;
	 
	 private boolean enabled = false;
	 private boolean schedulerImplicitlyCreated = false;
	 
	@Autowired
	private IOrderRedis orderRedis;
	@Autowired
	private IDelayedService delayedService;
	@Autowired
	private IOrderDetailService orderDetailService;
	@Autowired
	private IOrderService orderService;

	/**
	   * 改到配置参数里面去
	   */
	//private long OrderInterval = 30*1000;
	private long OrderInterval;
	
	public QuartzOrderPayPushScheduler() {
	
	}
	
    public QuartzOrderPayPushScheduler(boolean runenabled, long OrderInterval,IOrderRedis orderRedis,
    		IDelayedService delayedService,IOrderService orderService,IOrderDetailService orderDetailService) {
		this.OrderInterval = OrderInterval;
		this.orderService = orderService;
		this.orderDetailService=orderDetailService;
		this.delayedService=delayedService;
		this.orderRedis=orderRedis;
		if(runenabled==true&&enabled==false){
			enableSessionValidation();
		}
	}

	protected Scheduler getScheduler() throws SchedulerException {
        if (scheduler == null) {
            scheduler = StdSchedulerFactory.getDefaultScheduler();
            schedulerImplicitlyCreated = true;
        }
        return scheduler;
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }
    
  

/*
	public long getOrderInterval() {
		return OrderInterval;
	}

	public void setOrderInterval(long orderInterval) {
		OrderInterval = orderInterval;
	}*/

	@Override
	public boolean isEnabled() {
		   return this.enabled;
	}

	@Override
	public void enableSessionValidation() {
		try {
			
			Trigger trigger=new CronTrigger("trigger_1", "tGroup1","0 0 24 * * ?");
            JobDetail detail = new JobDetail(JOB_NAME, Scheduler.DEFAULT_GROUP, OrderAppraiseJob.class);
            detail.getJobDataMap().put(OrderAppraiseJob.ORDER_MANAGER_KEY, orderDetailService);
            detail.getJobDataMap().put(OrderAppraiseJob.ORDER_TWO_KEY, orderService);
            detail.getJobDataMap().put(OrderAppraiseJob.ORDER_THREE_KEY, orderRedis);
            detail.getJobDataMap().put(OrderAppraiseJob.ORDER_FOUR_KEY, delayedService);
            Scheduler scheduler = getScheduler();

            scheduler.scheduleJob(detail, trigger);
            if (schedulerImplicitlyCreated) {
                scheduler.start();
             
            }
            this.enabled = true;

        } catch (SchedulerException e) {
           e.printStackTrace();
        } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void disableSessionValidation() {

        Scheduler scheduler;
        try {
            scheduler = getScheduler();
            if (scheduler == null) {
       
                return;
            }
        } catch (SchedulerException e) {
            return;
        }

        try {
            scheduler.unscheduleJob(JOB_NAME, Scheduler.DEFAULT_GROUP);
  
        } catch (SchedulerException e) {

        }

        this.enabled = false;

        if (schedulerImplicitlyCreated) {
            try {
                scheduler.shutdown();
            } catch (SchedulerException e) {            
                	System.out.println("Unable to cleanly shutdown implicitly created Quartz Scheduler instance."+ e.getMessage());
            } finally {
                setScheduler(null);
                schedulerImplicitlyCreated = false;
            }
        }
	}
}
