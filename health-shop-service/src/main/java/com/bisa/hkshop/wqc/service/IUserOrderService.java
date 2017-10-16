package com.bisa.hkshop.wqc.service;

import java.util.List;

import com.bisa.health.entity.Pager;
import com.bisa.health.routing.annotation.DataGuid;
import com.bisa.hkshop.model.Order;


public interface IUserOrderService {
	
	public List<Order> loadOrderList(int user_guid);
	
	public  Order loadOrderByname(int user_guid);
	
	public  Order loadOrderByOrderId (int user_guid,String  order_no);
	
	public  int addOrder(int user_guid,Order  order);
	
	public  int updateOrder (int user_guid,Order order);

	public Pager<Order> selPaOrder(int user_guid);

	public Pager<Order> seltra_status1(int user_guid, int tra_status,int appraise_status);

	public Pager<Order> seltra_status4(int user_guid, int tra_status);

	public Pager<Order> seleffective_statu(int user_guid, int effective_statu);

	public List<Order> Ordertra_statusList(int user_guid, int tra_status,int appraise_status);

	public List<Order> Ordertra_statusList2(int user_guid, int tra_status);
	
	public int delOrder(int user_guid,Order order);

	public List<Order> Otra_effective_statu(int user_guid, int tra_status,int effective_statu);
	/**
	 * 待收货待支付都用这个
	 * @param user_guid
	 * @param tra_status
	 * @param appraise_status
	 * @return
	 */
	public int Ordertra_statusCount(int user_guid, int tra_status,int appraise_status);

	
}
