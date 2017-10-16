package com.bisa.hkshop.zj.service;

import com.bisa.health.entity.Pager;
import com.bisa.hkshop.model.Active;


public interface IActiveService {
	
	public Pager<Active> loadActiveByUser(int user_guid);  //加载当前用户的服务激活情况
	
	public  Active  loadActiveBycode (int user_guid,String  Active_code);
	
	public  Boolean  addActive (Active  active);

	public  Boolean  updateActive(Active  active);
}
