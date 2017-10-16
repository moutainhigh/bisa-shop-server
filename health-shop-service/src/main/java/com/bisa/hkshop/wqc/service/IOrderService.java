package com.bisa.hkshop.wqc.service;

import java.util.List;

import com.bisa.hkshop.model.Order;


public interface IOrderService {
	
	public List<Order> loadOrderList(int  user_guid);
	
	public  Order  loadOrderByOrderId (int user_guid,String  orderId);
	
	public  Boolean  addOrder(int user_guid,Order  order);
	
	public  Boolean  updateOrder (int user_guid,Order order);
	
	
}
