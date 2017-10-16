package com.bisa.hkshop.wqc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bisa.health.routing.annotation.DataGuid;
import com.bisa.health.routing.annotation.DataRouting;
import com.bisa.health.routing.annotation.RoutingTab;
import com.bisa.health.routing.annotation.TableEnum;
import com.bisa.hkshop.model.OrderDetail;
import com.bisa.hkshop.wqc.dao.IOrderDetailDao;


@Service
@RoutingTab(TableEnum.SWITCH)
public class OrderDetailServiceImpl implements IOrderDetailService{

	@Autowired
	private IOrderDetailDao orderDetailDao;
	
	@Override
	@DataRouting("user_guid")
	public List<OrderDetail> loadOrderDetailList(@DataGuid("user_guid") int user_guid,String order_no) {
		return orderDetailDao.loadOrderDetailList(user_guid,order_no);
	}

	@Override
	@DataRouting("user_guid")
	public OrderDetail loadOrderDetail(@DataGuid("user_guid") int user_guid,String order_detail_guid) {
		return orderDetailDao.loadOrderDetail(user_guid,order_detail_guid);
	}

	@Override
	@DataRouting("user_guid")
	public Boolean addOrderDetail(@DataGuid("user_guid") OrderDetail orderDetail) {
		return orderDetailDao.addOrderDetail(orderDetail);
	}

	@Override
	@DataRouting("user_guid")
	public int updateActive(@DataGuid("user_guid") int user_guid, OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		return orderDetailDao.updateActive(user_guid, orderDetail);
	}

	
	
	

}
