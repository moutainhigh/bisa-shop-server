package com.bisa.hkshop.wqc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bisa.hkshop.model.Address;
import com.bisa.hkshop.wqc.basic.dao.BaseDao;


@Repository
public class AddressDaoImpl extends BaseDao<Address> implements IAddressDao{

	@Override
	/*
	 * 加载当前用户名的所有地址信息
	 */
	public List<Address> loadAddressList(int user_guid) {
		List<Address> address = null;
		try{
			String sql = "select * from s_address where user_guid=? order by act_time desc";
			address = this.queryListBySql(sql, new Object[]{user_guid},Address.class);
		}catch(Exception e){
			return address;
		}
		return address;
	}

	
	@Override
	public Address loadAddressBynameNum(int user_guid, String addr_num) {
		Address address ;
		try{
			String sql = "select * from s_address where user_guid=? and addr_num=?";
			address = this.queryObjectBySql(sql, new Object[]{user_guid,addr_num},Address.class);
		}catch(Exception e){
			return null;
		}
		return address;
	}
	
	
	@Override
	public Address loadAddressByAddressNum(int user_guid,String addr_num) {
		String sql = "select * from s_address where user_guid=? and addr_num=?";
		Address	address = this.queryObjectBySql(sql, new Object[]{user_guid,addr_num},Address.class);
		return address;
	}

	@Override
	public Boolean updateAddress(int user_guid,Address address) {
		
		try{
			String sql = "update s_address set s_address.act_time=?,"
					+ "s_address.address=?,s_address.city=?,s_address.county=?,s_address.email=?,"
					+ "s_address.name=?,s_address.postcode=?,s_address.province=?,s_address.is_default=?,"
					+ "s_address.tel=?,s_address.guid=?,s_address.user_guid=? where s_address.user_guid=? and s_address.addr_num=?";
			this.delUpObjectBySql(sql, new Object[]{address.getAct_time(),address.getAddress(),address.getCity(),address.getCounty(),address.getEmail(),address.getName(),
								address.getPostcode(),address.getProvince(),
								address.getIs_default(),address.getTel(),
								address.getGuid(),address.getUser_guid(),
								user_guid,address.getAddr_num()});
		}catch(Exception e){
			return false;
		}
		return true;
	}

	@Override
	public Boolean addAddress(int user_guid,Address address) {
		try{
			String sql = "insert into s_address(s_address.act_time,s_address.addr_num,"
					+ "s_address.address,s_address.city,s_address.county,s_address.email,s_address.is_default,"
					+ "s_address.name,s_address.postcode,s_address.province,s_address.tel,"
					+ "s_address.user_guid,s_address.guid) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			this.addObjectBySql(sql, new Object[]{address.getAct_time(),address.getAddr_num(),address.getAddress(),address.getCity()
					,address.getCounty(),address.getEmail(),address.getIs_default(),address.getName(),
					address.getPostcode(),address.getProvince(),address.getTel(),user_guid,address.getGuid()});
		}catch(Exception e){
			return false;
		}
		return true;
	}


	
	
}
