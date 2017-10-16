package com.bisa.hkshop.wqc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bisa.health.entity.Pager;
import com.bisa.health.routing.annotation.DataGuid;
import com.bisa.health.routing.annotation.DataRouting;
import com.bisa.health.routing.annotation.RoutingTab;
import com.bisa.health.routing.annotation.TableEnum;
import com.bisa.hkshop.model.OrderDetail;
import com.bisa.hkshop.wqc.dao.IUserOrderDetailDao;
@Service
@RoutingTab(TableEnum.SWITCH)
public class IUserOrderDetailServiceImpl implements IUserOrderDetailService{
	
	@Autowired
	private IUserOrderDetailDao IUserOrderDetailDao;
	@Override
	@DataRouting("user_guid")
	public List<OrderDetail> loadOrderDetailList(@DataGuid("user_guid") int user_guid,String order_no) {
		// TODO Auto-generated method stub
		return IUserOrderDetailDao.loadOrderDetailList(user_guid,order_no);
	}

	@Override
	@DataRouting("user_guid")
	public OrderDetail loadOrderDetail(@DataGuid("user_guid") int user_guid,String order_detail_guid) {
		// TODO Auto-generated method stub
		return IUserOrderDetailDao.loadOrderDetail(user_guid,order_detail_guid);
	}

	@Override
	@DataRouting("user_guid")
	public int addOrderDetail(@DataGuid("user_guid") OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		return IUserOrderDetailDao.addOrderDetail(orderDetail);
	}

	@Override
	@DataRouting("user_guid")
	public int updateActive(@DataGuid("user_guid") OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		return IUserOrderDetailDao.updateActive(orderDetail);
	}

	@Override
	@DataRouting("user_guid")
	public Pager<OrderDetail> loadOderPage(@DataGuid("user_guid") int user_guid,String order_no) {
		// TODO Auto-generated method stub
		return IUserOrderDetailDao.loadOderPage(user_guid,order_no);
	}

	@Override
	@DataRouting("user_guid")
	public List<OrderDetail> pageuserdetails(@DataGuid("user_guid") int user_guid,int appraise_isnot) {
		// TODO Auto-generated method stub
		return IUserOrderDetailDao.pageuserdetails(user_guid, appraise_isnot);
	}

	@Override
	@DataRouting("user_guid")
	public List<OrderDetail> getOrderDetail(@DataGuid("user_guid") int user_guid) {
		// TODO Auto-generated method stub
		return IUserOrderDetailDao.getOrderDetail(user_guid);
	}


	@Override
	@DataRouting("user_guid")
	public int delOdtail(@DataGuid("user_guid") int user_guid,OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		return IUserOrderDetailDao.delOdtail(user_guid,orderDetail);
	}
	@Override
	@DataRouting("user_guid")
	public Pager<OrderDetail> page_userdetails(@DataGuid("user_guid") int user_guid,int appraise_isnot,int tra_status,int appraise_status) {
		// TODO Auto-generated method stub
		return IUserOrderDetailDao.page_userdetails(user_guid, appraise_isnot,tra_status,appraise_status);
	}
	@Override
	@DataRouting("user_guid")
	public Pager<OrderDetail> PagerOrderDetail(@DataGuid("user_guid") int user_guid){
		return IUserOrderDetailDao.PagerOrderDetail(user_guid);
	}
	
	

}
