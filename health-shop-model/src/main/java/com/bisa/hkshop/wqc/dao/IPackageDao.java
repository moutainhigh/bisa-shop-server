package com.bisa.hkshop.wqc.dao;

import java.util.List;

import com.bisa.hkshop.model.Active;
import com.bisa.hkshop.model.Package;

public interface IPackageDao {
	


	public List<Package> getpackage(String shop_Number);

	public Package getpackages(String packId);
	

}
