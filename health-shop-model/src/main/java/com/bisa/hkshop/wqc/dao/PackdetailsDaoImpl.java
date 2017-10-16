package com.bisa.hkshop.wqc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.bisa.hkshop.model.Packdetails;
import com.bisa.hkshop.wqc.basic.dao.BaseDao;

@Repository
public class PackdetailsDaoImpl extends BaseDao<Packdetails> implements IPackdetailsDao{

	@Override
	public List<Packdetails> getpackdetails(String packIds) {
		// TODO Auto-generated method stub
		String sql="select * from s_packdetails as  p where p.packId=? order by p.update_time desc";
		return super.queryListBySql(sql, new Object[]{packIds}, Packdetails.class);
	}

}
