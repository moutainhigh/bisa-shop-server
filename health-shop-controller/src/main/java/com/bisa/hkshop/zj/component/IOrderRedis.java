package com.bisa.hkshop.zj.component;

import java.util.HashMap;

import com.bisa.hkshop.zj.basic.utility.BaseDelayed;

public interface IOrderRedis {
	
	public HashMap<String,BaseDelayed<String>> getOrderRedis();
	
	public void addOrderRedis(BaseDelayed<String> delayed);
	
	public void delOrderRedis(String order_no);
	
	public void delAllOrderRedis();
}
