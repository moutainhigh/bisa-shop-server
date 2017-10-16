package com.bisa.hkshop.wqc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.bisa.health.routing.annotation.DataGuid;
import com.bisa.health.routing.annotation.DataRouting;
import com.bisa.health.routing.annotation.RoutingTab;
import com.bisa.health.routing.annotation.TableEnum;
import com.bisa.hkshop.model.AppraiseUser;
import com.bisa.hkshop.model.Order;
import com.bisa.hkshop.wqc.basic.dao.BaseDao;
import com.bisa.hkshop.wqc.dao.IAppraiseUserDao;
@Service
@RoutingTab(TableEnum.SWITCH)
public class IAppraiseUserServiceImpl implements IAppraiseUserService{

	@Autowired
	private IAppraiseUserDao IAppraiseUserDao;

	@Override
	@DataRouting("user_guid")
	public int addAppraiseUser(@DataGuid("user_guid") AppraiseUser appraise) {
		// TODO Auto-generated method stub
		return IAppraiseUserDao.addAppraiseUser(appraise);
	}

	@Override
	@DataRouting("user_guid")
	public AppraiseUser loadAppraiseUser(@DataGuid("user_guid") int user_guid, String order_detail_guid) {
		// TODO Auto-generated method stub
		return IAppraiseUserDao.loadAppraiseUser(user_guid, order_detail_guid);
	}

	@Override
	@DataRouting("user_guid")
	public int upAppraiseUser(@DataGuid("user_guid") AppraiseUser appraise) {
		// TODO Auto-generated method stub
		return IAppraiseUserDao.upAppraiseUser(appraise);
	}

	@Override
	@DataRouting("user_guid")
	public int delAppraiseUser(@DataGuid("user_guid") AppraiseUser appraise) {
		// TODO Auto-generated method stub
		return IAppraiseUserDao.delAppraiseUser(appraise);
	}

	@Override
	@DataRouting("user_guid")
	public List<AppraiseUser> loadAppraiseUserList(@DataGuid("user_guid") int user_guid) {
		// TODO Auto-generated method stub
		return IAppraiseUserDao.loadAppraiseUserList(user_guid);
	}

	
	
	



}
