package com.bisa.hkshop.wqc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bisa.health.entity.Pager;
import com.bisa.hkshop.model.Order;
import com.bisa.hkshop.wqc.basic.dao.BaseDao;


@Repository
public class IUserOrderDaoImpl extends BaseDao<Order> implements IUserOrderDao{

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
	public Order loadOrderByname(int user_guid) {
		Order order = null;
		try{
			String sql = "select * from s_order where user_guid=?";
			order = this.queryObjectBySql(sql, new Object[]{user_guid},Order.class);
		}catch(Exception e){
			return null;
		}
		return order;
	}

	@Override
	public Order loadOrderByOrderId(int user_guid,String order_no) {
		Order order = null;
		try{
			String sql = "select * from s_order where user_guid=? and order_no=? order by update_time desc";
			order = this.queryObjectBySql(sql, new Object[]{ user_guid,order_no},Order.class);
		}catch(Exception e){
			return null;
		}
		return order;
	}

	@Override
	public int addOrder(int user_guid,Order order) {
		String sql = "insert into s_order(s_order.id,s_order.addr_num,s_order.effective_statu,s_order.invoice_title,"
				+ "s_order.invoice_type,s_order.logistics_name,s_order.logistics_number,s_order.order_fail_time,"
				+ "s_order.order_no,s_order.pay_ok_time,s_order.pay_type,s_order.post_price,s_order.price,"
				+ "s_order.reduced_price,s_order.start_time,s_order.tra_status,s_order.trade_fail_cause,"
				+ "s_order.trade_false_time,s_order.trade_ok_time,s_order.update_time,s_order.user_guid,"
				+ "s_order.guid,s_order.appraise_status) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return super.addObjectBySql(sql,new Object[]{order.getId(),order.getAddr_num(),order.getEffective_statu(),order.getInvoice_title()
				,order.getInvoice_type(),order.getLogistics_name(),order.getLogistics_number(),order.getOrder_fail_time(),order.getOrder_no()
				,order.getPay_ok_time(),order.getPay_type(),order.getPost_price(),order.getPrice(),order.getReduced_price(),order.getStart_time(),
				order.getTra_status(),order.getTrade_fail_cause(),order.getTrade_false_time(),order.getTrade_ok_time(),order.getUpdate_time(),user_guid,
				order.getUser_guid(),order.getAppraise_status()});
	}
	
	@Override
	public int updateOrder(int user_guid,Order order) {
		String sql = "UPDATE s_order SET s_order.addr_num=?,s_order.effective_statu=?,s_order.invoice_title=?,"
				+ "s_order.invoice_type=?,s_order.logistics_name=?,s_order.logistics_number=?,s_order.order_fail_time=?,"
				+ "s_order.order_no=?,s_order.pay_ok_time=?,s_order.pay_type=?,s_order.post_price=?,s_order.price=?,"
				+ "s_order.reduced_price=?,s_order.start_time=?,s_order.tra_status=?,s_order.trade_fail_cause=?,"
				+ "s_order.trade_false_time=?,s_order.trade_ok_time=?,s_order.update_time=?,s_order.user_guid=?,"
				+ "s_order.guid=?,s_order.appraise_status=? where s.order.user_guid=? and s_order.order_no=?";
		return super.delUpObjectBySql(sql,new Object[]{order.getAddr_num(),order.getEffective_statu(),order.getInvoice_title()
				,order.getInvoice_type(),order.getLogistics_name(),order.getLogistics_number(),order.getOrder_fail_time(),order.getOrder_no()
				,order.getPay_ok_time(),order.getPay_type(),order.getPost_price(),order.getPrice(),order.getReduced_price(),order.getStart_time(),
				order.getTra_status(),order.getTrade_fail_cause(),order.getTrade_false_time(),order.getTrade_ok_time(),order.getUpdate_time(),order.getUser_guid(),
				order.getUser_guid(),order.getAppraise_status(),user_guid,order.getOrder_no()});
	}

	@Override
	public Pager<Order> selPaOrder(int user_guid) {
		// TODO Auto-generated method stub
		String sql="select * from s_order where user_guid=?";
		return super.findBySql(sql, new Object[]{user_guid}, Order.class, true);
	}

	@Override
	public Pager<Order> seltra_status1(int user_guid, int tra_status,int appraise_status) {
		// TODO Auto-generated method stub
		String sql="select * from s_order where user_guid=? and tra_status=? and appraise_status=?";
		return super.findBySql(sql, new Object[]{user_guid,tra_status,appraise_status}, Order.class, true);
	}

	@Override
	public Pager<Order> seltra_status4(int user_guid, int tra_status) {
		// TODO Auto-generated method stub
		String sql="select * from s_order o where o.user_guid=? and (o.tra_status=20 || o.tra_status=21)";
		return super.findBySql(sql, new Object[]{user_guid}, Order.class, true);
	}

	@Override
	public Pager<Order> seleffective_statu(int user_guid, int effective_statu) {
		// TODO Auto-generated method stub
		String sql="select * from s_order where user_guid=? and effective_statu=?";
		return super.findBySql(sql, new Object[]{user_guid,effective_statu}, Order.class, true);
	}

	@Override
	public List<Order> Ordertra_statusList(int user_guid, int tra_status,int appraise_status) {
		// TODO Auto-generated method stub
		String sql="select * from s_order o where o.user_guid=? and o.tra_status=? and o.appraise_status=? order by o.update_time desc";
		return super.queryListBySql(sql, new Object[]{user_guid,tra_status,appraise_status}, Order.class);
	}

	@Override
	public List<Order> Ordertra_statusList2(int user_guid, int tra_status) {
		// TODO Auto-generated method stub
		String sql="select * from s_order o where o.user_guid=? and (o.tra_status=20 || o.tra_status=21) order by o.update_time desc";
		return super.queryListBySql(sql, new Object[]{user_guid}, Order.class);
	}
	public int delOrder(int user_guid,Order order) {
		String sql="delete from s_order o where o.user_guid=? and o.order_no=?";
		return super.delUpObjectBySql(sql, new Object[]{user_guid,order.getOrder_no()});
	}

	@Override
	public List<Order> Otra_effective_statu(int user_guid, int tra_status, int effective_statu) {
		// TODO Auto-generated method stub
		String sql="select * from s_order o where o.user_guid=? and o.tra_status=? and o.effective_statu=? order by o.update_time desc";
		return super.queryListBySql(sql, new Object[]{user_guid,tra_status,effective_statu}, Order.class);
	}

	@Override
	public int Ordertra_statusCount(int user_guid, int tra_status, int appraise_status) {
		// TODO Auto-generated method stub
		String sql="select count(*) from s_order o where o.user_guid=? and o.tra_status=? and o.appraise_status=? order by o.update_time desc";
		return (int) super.queryTotal(sql, new Object[]{user_guid,tra_status,appraise_status});
	}

	@Override
	public Pager<Order> Ordertra_statusPager(int user_guid, int tra_status, int appraise_status) {
		String sql="select * from s_order o where o.user_guid=? and o.tra_status=? and o.appraise_status=? order by o.update_time desc";
		return super.findBySql(sql, new Object[]{user_guid,tra_status,appraise_status}, Order.class,true);
	}


	
	
	
}
