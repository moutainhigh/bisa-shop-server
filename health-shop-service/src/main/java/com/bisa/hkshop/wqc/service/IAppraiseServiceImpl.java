package com.bisa.hkshop.wqc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bisa.health.entity.Pager;
import com.bisa.health.routing.annotation.DataGuid;
import com.bisa.health.routing.annotation.DataRouting;
import com.bisa.health.routing.annotation.RoutingTab;
import com.bisa.health.routing.annotation.TableEnum;
import com.bisa.hkshop.model.Appraise;
import com.bisa.hkshop.wqc.dao.IAppraiseDao;

@Service
@RoutingTab(TableEnum.SWITCH)
public class IAppraiseServiceImpl implements IAppraiseService{
	@Autowired
	private IAppraiseDao IAppraiseDao;

	@Override
	@DataRouting("product_guid")
	public int addAppraise(@DataGuid("product_guid") Appraise appraise) {
		// TODO Auto-generated method stub
		return IAppraiseDao.addAppraise(appraise);
	}

	@Override
	@DataRouting("product_guid")
	public Appraise loadAppraise(@DataGuid("product_guid") int product_guid,String order_detail_guid) {
		// TODO Auto-generated method stub
		return IAppraiseDao.loadAppraise(product_guid,order_detail_guid);
	}

	@Override
	@DataRouting("product_guid")
	public int upAppraise(@DataGuid("product_guid") Appraise appraise) {
		// TODO Auto-generated method stub
		return IAppraiseDao.upAppraise(appraise);
	}

	@Override
	@DataRouting("product_guid")
	public int delAppraise(@DataGuid("product_guid") Appraise appraise) {
		// TODO Auto-generated method stub
		return IAppraiseDao.delAppraise(appraise);
	}

	@Override
	@DataRouting("product_guid")
	public Pager<Appraise> loadAppraiseList(@DataGuid("product_guid") int product_guid) {
		// TODO Auto-generated method stub
		return IAppraiseDao.loadAppraiseList(product_guid);
	}

}
