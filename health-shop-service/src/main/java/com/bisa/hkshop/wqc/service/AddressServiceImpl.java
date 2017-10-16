package com.bisa.hkshop.wqc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bisa.health.routing.annotation.DataGuid;
import com.bisa.health.routing.annotation.DataRouting;
import com.bisa.health.routing.annotation.RoutingTab;
import com.bisa.health.routing.annotation.TableEnum;
import com.bisa.hkshop.model.Address;
import com.bisa.hkshop.wqc.dao.IAddressDao;



@Service
@RoutingTab(TableEnum.SWITCH)
public class AddressServiceImpl implements IAddressService{

	@Autowired
	private IAddressDao addressDao;
	
	@Override
	@DataRouting("user_guid")
	public List<Address> loadAddressList(@DataGuid("user_guid") int user_guid) {
		
		return addressDao.loadAddressList(user_guid);
	}

	@Override
	@DataRouting("user_guid")
	public Address loadAddressByAddressNum(@DataGuid("user_guid") int user_guid,String addressNum) {
		
		return addressDao.loadAddressByAddressNum(user_guid,addressNum);
	}

	@Override
	@DataRouting("user_guid")
	public Address loadAddressBynameNum(@DataGuid("user_guid") int user_guid, String addressNum) {
		
		return addressDao.loadAddressBynameNum(user_guid, addressNum);
	}
	
	@Override
	@DataRouting("user_guid")
	public Boolean updateAddress(@DataGuid("user_guid") int user_guid, Address address) {
		return addressDao.updateAddress(user_guid,address);
	}

	@Override
	@DataRouting("user_guid")
	public Boolean addAddress(@DataGuid("user_guid") int user_guid,Address address) {
		return addressDao.addAddress(user_guid,address);
	}

	

}
