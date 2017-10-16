package com.bisa.hkshop.wqc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bisa.hkshop.model.Package;
import com.bisa.hkshop.wqc.basic.dao.BaseDao;
@Repository
public class PackageDaoImpl extends BaseDao<Package> implements IPackageDao {

	@Override
	public List<Package> getpackage(String shop_Number) {
		// TODO Auto-generated method stub
		String sql="select * from s_package where product_id=? order by orderId asc";
		return super.queryListBySql(sql, new Object[]{shop_Number},Package.class);
	}

	@Override
	public Package getpackages(String packId) {
		// TODO Auto-generated method stub
		String sql="select  *from s_package where package_number=?";
		return super.queryObjectBySql(sql, new Object[]{packId}, Package.class);
	}


	

}
