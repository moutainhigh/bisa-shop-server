package com.bisa.hkshop.wqc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bisa.health.entity.Pager;
import com.bisa.health.routing.annotation.DataGuid;
import com.bisa.health.routing.annotation.DataRouting;
import com.bisa.health.routing.annotation.RoutingTab;
import com.bisa.health.routing.annotation.TableEnum;
import com.bisa.hkshop.model.Order;

import com.bisa.hkshop.wqc.dao.IUserOrderDao;



@Service
@RoutingTab(TableEnum.SWITCH)
public class IUserOrderServiceImpl implements IUserOrderService{
	
	
	
	@Autowired
	private IUserOrderDao orderDao;
	
	

	@Override
	@DataRouting("user_guid")
	public List<Order> loadOrderList(@DataGuid("user_guid") int user_guid) {
		
		return orderDao.loadOrderList(user_guid);
	}

	@Override
	@DataRouting("user_guid")
	public Order loadOrderByname(@DataGuid("user_guid") int user_guid) {
		
		return orderDao.loadOrderByname(user_guid);
	}

	@Override
	@DataRouting("user_guid")
	public Order loadOrderByOrderId(@DataGuid("user_guid")int user_guid,String orderId) {
		return orderDao.loadOrderByOrderId(user_guid,orderId);
	}

	@Override
	@DataRouting("user_guid")
	public int addOrder(@DataGuid("user_guid")int user_guid,Order order) {
		return orderDao.addOrder(user_guid,order);
	}

	@Override
	@DataRouting("user_guid")
	public int updateOrder(@DataGuid("user_guid")int user_guid,Order order) {
		return orderDao.updateOrder(user_guid,order);
	}

	@Override
	@DataRouting("user_guid")
	public Pager<Order> selPaOrder(@DataGuid("user_guid") int user_guid) {
		// TODO Auto-generated method stub
		return orderDao.selPaOrder(user_guid);
	}

	@Override
	@DataRouting("user_guid")
	public Pager<Order> seltra_status1(@DataGuid("user_guid") int user_guid, int tra_status,int appraise_status) {
		// TODO Auto-generated method stub
		return orderDao.seltra_status1(user_guid,tra_status,appraise_status);
	}


	@Override
	@DataRouting("user_guid")
	public Pager<Order> seleffective_statu(@DataGuid("user_guid") int user_guid, int effective_statu) {
		// TODO Auto-generated method stub
		return orderDao.seleffective_statu(user_guid,effective_statu);
	}

	@Override
	@DataRouting("user_guid")
	public Pager<Order> seltra_status4(@DataGuid("user_guid") int user_guid, int tra_status) {
		// TODO Auto-generated method stub
		return orderDao.seltra_status4(user_guid,tra_status);
	}

	@Override
	@DataRouting("user_guid")
	public List<Order> Ordertra_statusList(@DataGuid("user_guid") int user_guid, int tra_status,int appraise_status) {
		// TODO Auto-generated method stub
		return orderDao.Ordertra_statusList(user_guid,tra_status,appraise_status);
	}

	@Override
	@DataRouting("user_guid")
	public List<Order> Ordertra_statusList2(@DataGuid("user_guid") int user_guid, int tra_status) {
		// TODO Auto-generated method stub
		return orderDao.Ordertra_statusList2(user_guid,tra_status);
	}

	@Override
	@DataRouting("user_guid")
	public int delOrder(@DataGuid("user_guid") int user_guid,Order order) {
		// TODO Auto-generated method stub
		return orderDao.delOrder(user_guid,order);
	}

	@Override
	@DataRouting("user_guid")
	public List<Order> Otra_effective_statu(@DataGuid("user_guid") int user_guid, int tra_status, int effective_statu) {
		// TODO Auto-generated method stub
		return orderDao.Otra_effective_statu(user_guid,tra_status,effective_statu);
	}
	@Override
	@DataRouting("user_guid")
	public int Ordertra_statusCount(@DataGuid("user_guid") int user_guid, int tra_status,int appraise_status) {
		// TODO Auto-generated method stub
		return orderDao.Ordertra_statusCount(user_guid,tra_status,appraise_status);
	}

	
	
	
	
	

	
	
}
