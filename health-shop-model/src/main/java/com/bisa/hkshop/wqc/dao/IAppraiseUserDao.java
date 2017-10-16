package com.bisa.hkshop.wqc.dao;

import java.util.List;

import com.bisa.hkshop.model.AppraiseUser;

public interface IAppraiseUserDao {

	public int addAppraiseUser(AppraiseUser appraise);

	public AppraiseUser loadAppraiseUser(int user_guid,String order_detail_guid);
	
	public int upAppraiseUser(AppraiseUser appraise);
	
	public int delAppraiseUser(AppraiseUser appraise);

	public List<AppraiseUser> loadAppraiseUserList(int user_guid);
	

}
