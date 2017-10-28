package com.bisa.hkshop.zj.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.bisa.health.entity.Pager;
import com.bisa.hkshop.model.Active;
import com.bisa.hkshop.wqc.basic.dao.BaseDao;

@Repository
public class ActiveDAoImpl extends BaseDao<Active> implements IActiveDAo{

	
	@Override
	public Pager<Active> loadActiveByUser(int user_guid) {
			String sql = "select * from s_active where user_guid=?";
			return super.findBySql(sql, new Object[]{user_guid}, Active.class, true);
	}

	
	@Override
	public Active loadActiveBycode(int user_guid,String Active_code) {
		try{
			String sql = "select * from s_active where active_code=?";
			return super.queryObjectBySql(sql, new Object[]{Active_code},Active.class);
		}catch(Exception e){
			return null;
		}
	}

	
	@Override
	public List<Active> loadActiveList(int user_guid, String active_statu) {
		try{
			String sql = "select * from s_active where user_guid=? and active_statu=?";
			return super.queryListBySql(sql, new Object[]{user_guid,active_statu},Active.class);
		}catch(Exception e){
			return null;
		}
	}

	
	
	@Override
	public Boolean addActive(Active active) {
		try{
			String sql = "insert into s_active(s_active.active_code,s_active.active_life,"
					+ "s_active.active_statu,s_active.active_time,s_active.guid,s_active.service_guid,"
					+ "s_active.service_name,s_active.service_number,s_active.start_time,s_active.user_guid)"
					+ " values(?,?,?,?,?,?,?,?,?,?)";
			this.addObjectBySql(sql,new Object[]{active.getActive_code(),active.getActive_life(),active.getActive_statu()
					,active.getActive_time(),active.getGuid(),active.getService_guid(),active.getService_name(),active.getService_number()
					,active.getStart_time(),active.getUser_guid()});
		}catch(Exception e){
			return false;
		}
		return true;
	}

	@Override
	public Boolean updateActive(Active active) {
		try{
			String sql = "update Active s_active set s_active.active_code=?,s_active.active_life=?,"
					+ "s_active.active_statu=?,s_active.active_time=?,s_active.guid=?,s_active.service_guid=?,"
					+ "s_active.service_name=?,s_active.service_number=?,s_active.start_time=?"
					+ "where s_active.user_guid=? s_active.id=?";
			this.updateByHql(sql,new Object[]{active.getActive_code(),active.getActive_life(),active.getActive_statu()
					,active.getActive_time(),active.getGuid(),active.getService_guid(),active.getService_name(),active.getService_number()
					,active.getStart_time(),active.getUser_guid(),active.getId()});
		}catch(Exception e){
			return false;
		}
		return true;
	}


	
	
	
}
