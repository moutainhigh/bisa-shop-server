package com.bisa.hkshop.wqc.service;

import java.util.List;

import com.bisa.hkshop.model.OrderDetail;

public interface IOrderDetailService {
	
	public  List<OrderDetail> loadOrderDetailList(int user_guid,String  order_no);
	
	public  OrderDetail loadOrderDetail (int user_guid,String  order_detail_guid);
	
	public  Boolean addOrderDetail (OrderDetail orderDetail);
	
	public int updateActive(int user_guid,OrderDetail orderDetail);
}
