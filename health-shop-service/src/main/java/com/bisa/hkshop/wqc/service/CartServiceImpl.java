package com.bisa.hkshop.wqc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bisa.health.routing.annotation.DataGuid;
import com.bisa.health.routing.annotation.DataRouting;
import com.bisa.health.routing.annotation.RoutingTab;
import com.bisa.health.routing.annotation.TableEnum;
import com.bisa.hkshop.model.Cart;
import com.bisa.hkshop.wqc.dao.IcartDao;


@Repository
@RoutingTab(TableEnum.SWITCH)
public class CartServiceImpl implements ICartService{

	@Autowired
	private IcartDao ICartDao;
	@Override
	@DataRouting("user_guid")
	public int addCart(@DataGuid("user_guid") int user_guid,Cart cart) {
		// TODO Auto-generated method stub
		return ICartDao.addCart(user_guid,cart);
	}

	
	@Override
	@DataRouting("user_guid")
	public List<Cart> selCart(@DataGuid("user_guid") int user_guid) {
		// TODO Auto-generated method stub
		return ICartDao.selCart(user_guid);
	}

	@Override
	@DataRouting("user_guid")
	public Cart getCart(@DataGuid("user_guid") int user_guid,String packId) {
		// TODO Auto-generated method stub
		 Cart cart=ICartDao.getCart(user_guid,packId);
		return cart;
	}



	@Override
	@DataRouting("user_guid")
	public int delCart(@DataGuid("user_guid") int user_guid,String deleteId) {
		// TODO Auto-generated method stub
		return ICartDao.delCart(user_guid,deleteId);
	}



	@Override
	@DataRouting("user_guid")
	public int updateCart(@DataGuid("user_guid") int user_guid,Cart cart) {
		// TODO Auto-generated method stub
		return ICartDao.updateCart(user_guid,cart);
	}




	@Override
	@DataRouting("user_guid")
	public int selCartNum(@DataGuid("user_guid") int user_guid) {
		// TODO Auto-generated method stub
		return ICartDao.selCartNum(user_guid);
	}


	@Override
	@DataRouting("user_guid")
	public List<Cart> loadCarList(@DataGuid("user_guid") int user_guid, String carNum) {
		// TODO Auto-generated method stub
		return ICartDao.loadCarList(user_guid, carNum);
	}


	@Override
	@DataRouting("user_guid")
	public Boolean deteleCar(@DataGuid("user_guid") int user_guid, String carNum) {
		// TODO Auto-generated method stub
		return ICartDao.deteleCar(user_guid, carNum);
	}

}
