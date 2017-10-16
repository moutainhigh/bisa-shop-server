package com.bisa.hkshop.wqc.web.quartz;

public interface QuartzOrderPushSchedulerInterface {

   boolean isEnabled();

   void enableSessionValidation();

   void disableSessionValidation();

}
