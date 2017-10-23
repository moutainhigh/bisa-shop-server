package com.bisa.hkshop.wqc.web.quartz;
import org.osgi.service.component.annotations.Component;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.bisa.hkshop.wqc.service.IOrderDetailService;
import com.bisa.hkshop.wqc.service.IOrderService;
import com.bisa.hkshop.wqc.service.IUserOrderDetailService;
import com.bisa.hkshop.wqc.service.IUserOrderService;
@Component
public class QuartzAppraisePushScheduler implements QuartzOrderPushSchedulerInterface {
	
	 private static final String JOB_NAME = "OrderJob";
	 private Scheduler scheduler;
	 private boolean enabled = false;
	 private boolean schedulerImplicitlyCreated = false;
	 
	 @Autowired
	 private IUserOrderService orderService;
	 
	 @Autowired
	 private IUserOrderDetailService orderDetailService;

	/**
	   * 改到配置参数里面去
	   */
	//private long OrderInterval = 30*1000;
	private long AppraiseInterval;
	
	public QuartzAppraisePushScheduler() {
	
	}
	
    public QuartzAppraisePushScheduler(boolean runenabled, long AppraiseInterval,IUserOrderService orderService,IUserOrderDetailService orderDetailService) {
    	
		this.AppraiseInterval = AppraiseInterval;
		this.orderService = orderService;
		this.orderDetailService=orderDetailService;
		
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
    
    
	

	public long getAppraiseInterval() {
		return AppraiseInterval;
	}

	public void setAppraiseInterval(long appraiseInterval) {
		AppraiseInterval = appraiseInterval;
	}

	@Override
	public boolean isEnabled() {
		   return this.enabled;
	}

	@Override
	public void enableSessionValidation() {
		try {
            SimpleTrigger trigger = new SimpleTrigger(getClass().getName(),
                    Scheduler.DEFAULT_GROUP,
                    SimpleTrigger.REPEAT_INDEFINITELY,
                    AppraiseInterval);

            JobDetail detail = new JobDetail(JOB_NAME, Scheduler.DEFAULT_GROUP, OrderJob.class);
            detail.getJobDataMap().put(AppraiseJob.ORDER_MANAGER_KEY, orderService);
            detail.getJobDataMap().put(AppraiseJob.APPRAISE_MANAGER_KEY, orderDetailService);
            Scheduler scheduler = getScheduler();

            scheduler.scheduleJob(detail, trigger);
            if (schedulerImplicitlyCreated) {
                scheduler.start();
             
            }
            this.enabled = true;

        } catch (SchedulerException e) {
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
