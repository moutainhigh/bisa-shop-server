package com.bisa.hkshop.wqc.dao;

import java.util.List;

import com.bisa.hkshop.model.Address;

public interface IAddressDao {
	
	public  List<Address>  loadAddressList(int user_guid);
	
	public  Address  loadAddressByAddressNum(int user_guid,String  addr_num);	
	
	public Address  loadAddressBynameNum(int user_guid,String addr_num);
	
	public  Boolean  updateAddress(int user_guid,Address  address);
		
	public  Boolean  addAddress(int user_guid,Address  address);
		
}
