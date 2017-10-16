package com.bisa.hkshop.wqc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bisa.hkshop.model.Order;
import com.bisa.hkshop.wqc.basic.dao.BaseDao;


@Repository
public class OrderDaoImpl extends BaseDao<Order> implements IOrderDao{

	@Override
	public List<Order> loadOrderList(int user_guid) {
		List<Order> order = null;
		try{
			String sql = "select * from s_order where user_guid=?";
			order = this.queryListBySql(sql, new Object[]{user_guid},Order.class);
		}catch(Exception e){
			return null;
		}
		return order;
	}


	@Override
	public Order loadOrderByOrderId(int user_guid,String order_no) {
		Order order = null;
		try{
			String sql = "select * from s_order where user_guid=? and order_no=?";
			order = this.queryObjectBySql(sql, new Object[]{user_guid,order_no},Order.class);
		}catch(Exception e){
			return null;
		}
		return order;
	}

	@Override
	public Boolean addOrder(int user_guid,Order order) {
		
		
		try{
			String sql = "insert into s_order(s_order.addr_num,s_order.effective_statu,s_order.invoice_title,"
					+ "s_order.invoice_type,s_order.logistics_name,s_order.logistics_number,s_order.order_fail_time,"
					+ "s_order.order_no,s_order.pay_ok_time,s_order.pay_type,s_order.post_price,s_order.price,"
					+ "s_order.reduced_price,s_order.start_time,s_order.tra_status,s_order.trade_fail_cause,"
					+ "s_order.trade_false_time,s_order.trade_ok_time,s_order.update_time,s_order.user_guid,"
					+ "s_order.guid,s_order.appraise_status) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			this.addObjectBySql(sql,new Object[]{order.getAddr_num(),order.getEffective_statu(),order.getInvoice_title()
					,order.getInvoice_type(),order.getLogistics_name(),order.getLogistics_number(),order.getOrder_fail_time(),order.getOrder_no()
					,order.getPay_ok_time(),order.getPay_type(),order.getPost_price(),order.getPrice(),order.getReduced_price(),order.getStart_time(),
					order.getTra_status(),order.getTrade_fail_cause(),order.getTrade_false_time(),order.getTrade_ok_time(),order.getUpdate_time(),user_guid,
					order.getUser_guid(),order.getAppraise_status()});
		}catch(Exception e){
			return false;
		}
		return true;
		
		
	}
	
	@Override
	public Boolean updateOrder(int user_guid,Order order) {
			String sql = "UPDATE s_order SET s_order.addr_num=?,s_order.effective_statu=?,s_order.invoice_title=?,"
					+ "s_order.invoice_type=?,s_order.logistics_name=?,s_order.logistics_number=?,s_order.order_fail_time=?,"
					+ "s_order.pay_ok_time=?,s_order.pay_type=?,s_order.post_price=?,s_order.price=?,"
					+ "s_order.reduced_price=?,s_order.start_time=?,s_order.tra_status=?,s_order.trade_fail_cause=?,"
					+ "s_order.trade_false_time=?,s_order.trade_ok_time=?,s_order.update_time=?,"
					+ "s_order.guid=?,s_order.appraise_status=? where s_order.user_guid=? and s_order.order_no=?";
			int i=super.delUpObjectBySql(sql,new Object[]{order.getAddr_num(),order.getEffective_statu(),order.getInvoice_title()
					,order.getInvoice_type(),order.getLogistics_name(),order.getLogistics_number(),order.getOrder_fail_time()
					,order.getPay_ok_time(),order.getPay_type(),order.getPost_price(),order.getPrice(),order.getReduced_price(),order.getStart_time(),
					order.getTra_status(),order.getTrade_fail_cause(),order.getTrade_false_time(),order.getTrade_ok_time(),order.getUpdate_time(),
					order.getGuid(),order.getAppraise_status(),user_guid,order.getOrder_no()});
			if(i>0) {
				return true;
			}else {
				return false;
			}

	}
}
