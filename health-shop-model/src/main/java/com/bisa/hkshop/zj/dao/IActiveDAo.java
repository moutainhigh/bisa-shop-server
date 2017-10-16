package com.bisa.hkshop.zj.dao;


import java.util.List;

import com.bisa.health.entity.Pager;
import com.bisa.hkshop.model.Active;


public interface IActiveDAo {
	
	public Pager<Active> loadActiveByUser(int user_guid);
	
	public List<Active> loadActiveList(int user_guid,String active_statu);
	
	public  Active  loadActiveBycode (int user_guid,String  Active_code);
	
	public  Boolean  addActive (Active  active);
	
	public  Boolean  updateActive(Active  active);
	
}
