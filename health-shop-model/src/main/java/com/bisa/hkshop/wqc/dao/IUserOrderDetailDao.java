package com.bisa.hkshop.wqc.dao;

import java.util.List;

import com.bisa.health.entity.Pager;
import com.bisa.health.routing.annotation.DataGuid;
import com.bisa.hkshop.model.OrderDetail;

public interface IUserOrderDetailDao {
	
	public  List<OrderDetail>  loadOrderDetailList(int user_guid,String  order_no);
	
	public  OrderDetail  loadOrderDetail (int user_guid,String  order_detail_guid);
	
	public  int addOrderDetail (OrderDetail  orderDetail);

	public  int updateActive(OrderDetail  orderDetail);

	public Pager<OrderDetail> loadOderPage(int user_guid,String order_no);

	public List<OrderDetail> pageuserdetails(int user_guid, int appraise_isnot);

	public List<OrderDetail> getOrderDetail(int user_guid);
	
	public int delOdtail(int user_guid,OrderDetail  orderDetail);

	public Pager<OrderDetail> page_userdetails(int user_guid,int appraise_isnot,int tra_status,int appraise_status);

	public Pager<OrderDetail> PagerOrderDetail(int user_guid);
	
}
