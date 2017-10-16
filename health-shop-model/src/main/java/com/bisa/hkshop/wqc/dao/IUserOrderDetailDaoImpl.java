package com.bisa.hkshop.wqc.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import com.bisa.health.entity.Pager;
import com.bisa.health.routing.annotation.DataGuid;
import com.bisa.health.routing.annotation.RoutingTab;
import com.bisa.health.routing.annotation.TableEnum;
import com.bisa.hkshop.model.OrderDetail;
import com.bisa.hkshop.wqc.basic.dao.BaseDao;


@Repository
@RoutingTab(TableEnum.SWITCH)
public class IUserOrderDetailDaoImpl extends BaseDao<OrderDetail> implements IUserOrderDetailDao{

	
	
	@Override
	public List<OrderDetail> loadOrderDetailList(int user_guid,String order_no) {
		 List<OrderDetail> orderDetail = null;
		try{
			String sql = "select * from s_order_detail where user_guid=? and order_no=? order by start_time desc";
			orderDetail = this.queryListBySql(sql, new Object[]{user_guid,order_no},OrderDetail.class);
		}catch(Exception e){
			return null;
		}
		return orderDetail;
	}
	
	
	@Override
	public OrderDetail loadOrderDetail(int user_guid,String order_detail_guid) {
		OrderDetail orderDetail = null;
		try{
			String sql = "select * from s_order_detail where user_guid=? and order_detail_guid=? order by start_time desc";
			orderDetail = this.queryObjectBySql(sql, new Object[]{user_guid,order_detail_guid},OrderDetail.class);
		}catch(Exception e){
			return null;
		}
		return orderDetail;
	}

	@Override
	public int addOrderDetail(OrderDetail orderDetail) {
		String sql = "insert into s_order_detail(s.order_detail.id,s_order_detail.ascription,s_order_detail.ascription_guid,"
				+ "s_order_detail.count,s_order_detail.order_detail_guid,s_order_detail.order_no,s_order_detail.pic,"
				+ "s_order_detail.product_name,s_order_detail.start_time,s_order_detail.price,s_order_detail.appraise_isnot,"
				+ "s_order_detail.user_guid) values(?,?,?,?,?,?,?,?,?,?,?)";
		return super.addObjectBySql(sql, new Object[]{orderDetail.getId(),orderDetail.getAscription(),orderDetail.getAscription_guid()
				,orderDetail.getCount(),orderDetail.getOrder_detail_guid(),orderDetail.getOrder_no(),
				orderDetail.getPic(),orderDetail.getProduct_name(),orderDetail.getStart_time(),orderDetail.getPrice(),orderDetail.getAppraise_isnot()
				,orderDetail.getUser_guid()});
	}

	@Override
	public int updateActive(OrderDetail orderDetail) {
		String sql = "update s_order_detail set s_order_detail.ascription=?,s_order_detail.ascription_guid=?,"
				+ "s_order_detail.count=?,s_order_detail.order_detail_guid=?,s_order_detail.order_no=?,s_order_detail.pic=?,"
				+ "s_order_detail.product_name=?,s_order_detail.start_time=?,s_order_detail.price=?,s_order_detail.appraise_isnot=?,"
				+ "s_order_detail.user_guid=? where s_order_detail.user_guid=? and s_order_detail.order_detail_guid=?";
		return super.addObjectBySql(sql, new Object[]{orderDetail.getAscription(),orderDetail.getAscription_guid()
				,orderDetail.getCount(),orderDetail.getOrder_detail_guid(),orderDetail.getOrder_no(),
				orderDetail.getPic(),orderDetail.getProduct_name(),orderDetail.getStart_time(),orderDetail.getPrice(),orderDetail.getAppraise_isnot()
				,orderDetail.getUser_guid(),orderDetail.getUser_guid(),orderDetail.getOrder_detail_guid()});
	}


	@Override
	public Pager<OrderDetail> loadOderPage(int user_guid,String order_no) {
		// TODO Auto-generated method stub
		String sql="select od.* from s_order_detail od where user_guid=? and order_no=? order by start_time desc";
		return super.findBySql(sql, new Object[]{user_guid,order_no},OrderDetail.class, true);
	
	}


	@Override
	public List<OrderDetail> pageuserdetails(int user_guid,int appraise_isnot) {
		// TODO Auto-generated method stub
		/*String sql="SELECT od.* FROM s_order AS o,s_order_detail AS od where o.user_guid=? and o.tra_status=? and o.appraise_isnot=? and o.appraise_status=? and od.order_no=o.order_no";
		return super.findBySql(sql, new Object[]{guid,tra_status,appraise_isnot,appraise_status},OrderDetail.class, true);*/
		String sql="select od.* from s_order_detail as od where od.user_guid=? and od.appraise_isnot=? order by start_time desc";
		return super.queryListBySql(sql, new Object[]{user_guid,appraise_isnot},OrderDetail.class);
	}


	@Override
	public List<OrderDetail> getOrderDetail(int user_guid) {
		// TODO Auto-generated method stub
		String sql = "select * from s_order_detail where user_guid=? order by start_time desc";
		return super.queryListBySql(sql, new Object[]{user_guid},OrderDetail.class);
	}


	@Override
	public int delOdtail(int user_guid,OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		String sql="delete from s_order_detail  od where od.user_guid=? and od.order_detail_guid=? order by start_time desc";
		return super.delUpObjectBySql(sql, new Object[]{user_guid,orderDetail.getOrder_detail_guid()});
	}
	@Override
	public Pager<OrderDetail> page_userdetails(int user_guid,int appraise_isnot,int tra_status,int appraise_status){
			String sql="select od.* from s_order_detail as od where od.user_guid=? and od.appraise_isnot=? and od.tra_status=? and od.appraise_status=?";
			return super.findBySql(sql, new Object[]{user_guid,appraise_isnot,tra_status,appraise_status},OrderDetail.class,true);
	}
	
	@Override
	public Pager<OrderDetail> PagerOrderDetail(int user_guid){
		String sql="select od.* from s_order_detail as od where od.user_guid=? ";
		return super.findBySql(sql, new Object[]{user_guid},OrderDetail.class,true);
	}


	
	


	

	
	
	
	
}
