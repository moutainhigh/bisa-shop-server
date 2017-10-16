package com.bisa.hkshop.wqc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bisa.hkshop.model.AppraiseUser;
import com.bisa.hkshop.wqc.basic.dao.BaseDao;
@Repository
public class IAppraiseUserDaoImpl extends BaseDao<AppraiseUser> implements IAppraiseUserDao{

	@Override
	public int addAppraiseUser(AppraiseUser appraise) {
		// TODO Auto-generated method stub
		String sql="insert into s_appraise_user(id,appraise_no,shop_number,main_picture,price,"
				+ "title,appraise_one,appraise_two,appraise_degree,appraise_status,user_guid,"
				+ "insert_time,update_time,order_detail_guid,product_guid) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return super.addObjectBySql(sql, new Object[] {appraise.getId(),appraise.getAppraise_no(),appraise.getShop_number(),appraise.getMain_picture(),
				appraise.getPrice(),appraise.getTitle(),appraise.getAppraise_one(),appraise.getAppraise_two(),appraise.getAppraise_degree(),
				appraise.getAppraise_status(),appraise.getUser_guid(),appraise.getInsert_time(),appraise.getUpdate_time(),
				appraise.getOrder_detail_guid(),appraise.getProduct_guid()});
	}

	@Override
	public AppraiseUser loadAppraiseUser(int user_guid,String order_detail_guid) {
		// TODO Auto-generated method stub
		String sql="select * from s_appraise_user where user_guid=? and order_detail_guid=?";
		return super.queryObjectBySql(sql, new Object[]{user_guid,order_detail_guid}, AppraiseUser.class);
	}


	@Override
	public int upAppraiseUser(AppraiseUser appraise) {
		// TODO Auto-generated method stub
		String sql="update s_appraise_user a set a.id=?,a.appraise_no=?,a.shop_number=?,a.main_picture=?,a.price=?,a.title=?"
				+ "a.appraise_one=?,a.appraise_two=?,a.appraise_degree=?,a.appraise_status=?,a.user_guid=?,a.insert_time=?,a.update_time=?,"
				+ "a.order_detail_guid=?,a.product_guid=?";
		return super.delUpObjectBySql(sql, new Object[] {appraise.getId(),appraise.getAppraise_no(),appraise.getShop_number(),appraise.getMain_picture(),
				appraise.getPrice(),appraise.getTitle(),appraise.getAppraise_one(),appraise.getAppraise_two(),appraise.getAppraise_degree(),
				appraise.getAppraise_status(),appraise.getUser_guid(),appraise.getInsert_time(),appraise.getUpdate_time(),
				appraise.getOrder_detail_guid(),appraise.getProduct_guid()});
	}

	@Override
	public int delAppraiseUser(AppraiseUser appraise) {
		// TODO Auto-generated method stub
		String sql="delete from s_appraise_user a where  a.user_guid=? and a.appraise_no=?";
		return super.delUpObjectBySql(sql, new Object[] {appraise.getUser_guid(),appraise.getAppraise_no()});
	}

	@Override
	public List<AppraiseUser> loadAppraiseUserList(int user_guid) {
		// TODO Auto-generated method stub
		String sql="select * from s_appraise_user a where a.user_guid=? order by update_time desc";
		return super.queryListBySql(sql, new Object[]{user_guid}, AppraiseUser.class);
	}
	

}
