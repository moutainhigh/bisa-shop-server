package com.bisa.hkshop.wqc.dao;

import java.util.List;

import com.bisa.hkshop.model.Packdetails;



public interface IPackdetailsDao {

	List<Packdetails> getpackdetails(String packIds);
	
	
}
