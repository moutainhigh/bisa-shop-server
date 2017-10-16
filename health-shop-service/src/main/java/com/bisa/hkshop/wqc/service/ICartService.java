package com.bisa.hkshop.wqc.service;

import java.util.List;

import com.bisa.hkshop.model.Cart;

public interface ICartService {


	public int addCart(int user_guid,Cart cart);


	public List<Cart> selCart(int user_guid);
	
	public Cart getCart(int user_guid,String packId);
	
	public int delCart(int user_guid,String deleteId);


	public int updateCart(int user_guid,Cart cart);
	
	public int selCartNum(int user_guid);
	
	public List<Cart> loadCarList(int user_guid,String carNum);
	
	public Boolean deteleCar(int user_guid,String carNum);
}
