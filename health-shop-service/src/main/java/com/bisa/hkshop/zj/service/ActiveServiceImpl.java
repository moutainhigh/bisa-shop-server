package com.bisa.hkshop.zj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bisa.health.entity.Pager;
import com.bisa.health.routing.annotation.DataGuid;
import com.bisa.health.routing.annotation.DataRouting;
import com.bisa.health.routing.annotation.RoutingTab;
import com.bisa.health.routing.annotation.TableEnum;
import com.bisa.hkshop.model.Active;

import com.bisa.hkshop.zj.dao.IActiveDAo;

@Service
@RoutingTab(TableEnum.SWITCH)
public class ActiveServiceImpl implements IActiveService{

	@Autowired
	private IActiveDAo activeDao;
	
	@DataRouting("user_guid")
	public Pager<Active> loadActiveByUser(@DataGuid("user_guid") int user_guid) {
		return activeDao.loadActiveByUser(user_guid);
	}
	
	@Override
	@DataRouting("user_guid")
	public Active loadActiveBycode(@DataGuid("user_guid") int user_guid,String Active_code) {
		return activeDao.loadActiveBycode(user_guid,Active_code);
	}
	
	@Override
	public Boolean addActive(@DataGuid("user_guid") Active active) {
		return activeDao.addActive(active);
	}
	
	@Override
	@DataRouting("user_guid")
	public Boolean updateActive(@DataGuid("user_guid") Active active) {
		return activeDao.updateActive(active);
	}
	
}
