package com.bisa.hkshop.wqc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bisa.health.routing.annotation.DataGuid;
import com.bisa.health.routing.annotation.DataRouting;
import com.bisa.health.routing.annotation.RoutingTab;
import com.bisa.health.routing.annotation.TableEnum;
import com.bisa.hkshop.model.Order;
import com.bisa.hkshop.wqc.dao.IOrderDao;


@Service
@RoutingTab(TableEnum.SWITCH)
public class OrderServiceImpl implements IOrderService{
	
	@Autowired
	private IOrderDao orderDao;
	

	@Override
	@DataRouting("user_guid")
	public List<Order> loadOrderList(@DataGuid("user_guid")int user_guid) {
		
		return orderDao.loadOrderList(user_guid);
	}

	
	@Override
	@DataRouting("user_guid")
	public Order loadOrderByOrderId(@DataGuid("user_guid")int user_guid,String orderId) {
		return orderDao.loadOrderByOrderId(user_guid,orderId);
	}
	
	@Override
	@DataRouting("user_guid")
	public Boolean addOrder(@DataGuid("user_guid")int user_guid,Order order) {
		return orderDao.addOrder(user_guid,order);
	}
	
	@Override
	@DataRouting("user_guid")
	public Boolean updateOrder(@DataGuid("user_guid")int user_guid,Order order) {
		return orderDao.updateOrder(user_guid,order);
	}
	
	
}
