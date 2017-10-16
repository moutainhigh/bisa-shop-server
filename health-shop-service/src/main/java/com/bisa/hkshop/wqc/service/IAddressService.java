package com.bisa.hkshop.wqc.service;

import java.util.List;

import com.bisa.hkshop.model.Address;

public interface IAddressService {
	
	public  List<Address>  loadAddressList(int  user_guid);
	
	public  Address  loadAddressByAddressNum(int user_guid , String  addressNum);	
	
	public Address loadAddressBynameNum(int user_guid, String addressNum);
	
	public  Boolean  updateAddress(int user_guid,Address  address);
	
	public  Boolean  addAddress(int user_guid,Address  address);	
	
}
