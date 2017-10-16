package com.bisa.hkshop.wqc.dao;

import java.util.List;

import com.bisa.hkshop.model.Order;

public interface IOrderDao {
	

	public List<Order> loadOrderList(int  user_guid);
	
	public  Order  loadOrderByOrderId (int user_guid,String  order_no);
	
	public  Boolean  addOrder(int  user_guid,Order  order);
	
	public  Boolean  updateOrder (int  user_guid,Order order);

}
