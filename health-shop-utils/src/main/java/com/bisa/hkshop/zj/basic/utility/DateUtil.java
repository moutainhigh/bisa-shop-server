package com.bisa.hkshop.zj.basic.utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	public static Date getAddTime(int number,Date inputDate){
		Calendar c = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		if(inputDate==null){
			date = new Date();
		}else{
			date = inputDate;
		}
        c.setTime(date);
        c.add(Calendar.MONTH,number);//添加多少个月
        //更新服务到期时间
        return c.getTime();
	}
}
