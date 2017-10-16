package com.bisa.hkshop.wqc.service;

import java.util.List;

import com.bisa.hkshop.model.Active;
import com.bisa.hkshop.model.Package;

public interface IPackageService {
	

	//获取套餐
	public List<Package> getpackage(String shop_Number);

	public Package getpackages(String packId);
	

}
