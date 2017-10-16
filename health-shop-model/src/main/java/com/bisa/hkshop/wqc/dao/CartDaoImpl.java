package com.bisa.hkshop.wqc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bisa.hkshop.model.Active;
import com.bisa.hkshop.model.Cart;
import com.bisa.hkshop.wqc.basic.dao.BaseDao;
@Repository
public class CartDaoImpl extends BaseDao<Cart> implements IcartDao{


	@Override
	public List<Cart> selCart(int user_guid) {
		// TODO Auto-generated method stub
		String sql="select * from s_cart AS c where c.user_guid=? order by c.update_time desc";
		return super.queryListBySql(sql, new Object[]{user_guid}, Cart.class);
	}

	@Override
	public int addCart(int user_guid,Cart cart) {
		// TODO Auto-generated method stub
		String sql="insert into s_cart(id,cart_number,number,price,title,total,guid,"
				+ "packId,main_picture,insert_time,update_time,sing_cox,user_guid) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return super.addObjectBySql(sql, new Object[]{cart.getId(),cart.getCart_number(),cart.getNumber(),cart.getPrice(),cart.getTitle(),
				cart.getTotal(),cart.getGuid(),cart.getPackId(),cart.getMain_picture(),cart.getInsert_time(),cart.getUpdate_time(),
				cart.getSing_cox(),user_guid});
	}

	@Override
	public Cart getCart(int user_guid,String packId) {
		// TODO Auto-generated method stub
		String sql="select * from s_cart where user_guid=? and packId=?";
		return super.queryObjectBySql(sql, new Object[]{user_guid,packId}, Cart.class);
	}

	@Override
	public int delCart(int user_guid,String deleteId) {
		// TODO Auto-generated method stub
		String sql="delete from s_cart where user_guid=? and packId=?";
		return super.delUpObjectBySql(sql, new Object[]{user_guid,deleteId});
	}

	@Override
	public int updateCart(int user_guid,Cart cart) {
		// TODO Auto-generated method stub
		String sql="update s_cart c set c.cart_number=?,c.number=?,c.price=?,c.title=?,c.total=?,c.guid=?,"
				+ "c.packId=?,c.main_picture=?,c.insert_time=?,c.update_time=?,c.sing_cox=?,c.user_guid=? where c.user_guid=? and c.cart_number=?";
		return super.delUpObjectBySql(sql, new Object[]{cart.getCart_number(),cart.getNumber(),cart.getPrice(),cart.getTitle(),
				cart.getTotal(),cart.getGuid(),cart.getPackId(),cart.getMain_picture(),cart.getInsert_time(),cart.getUpdate_time(),
				cart.getSing_cox(),cart.getUser_guid(),user_guid,cart.getCart_number()});
	}

	@Override
	public int selCartNum(int user_guid) {
		// TODO Auto-generated method stub
		String sql="select count(*) from s_cart where user_guid=?";
		return (int) super.queryTotal(sql, new Object[]{user_guid});
	}

	@Override
	public List<Cart> loadCarList(int user_guid,String carNum) {
		List<Cart> car;
		try{
			String sql = "select * from s_cart where user_guid=? and packId IN(?)";
			car = super.queryListBySql(sql, new Object[]{user_guid,carNum}, Cart.class);
		}catch(Exception e){
			return null;
		}
		return car;
	}

	@Override
	public Boolean deteleCar(int user_guid,String carNum) {
		Boolean b = false;
		try{
			
			String sql = "delete from s_cart where user_guid=? and packId=?";
			 int a = super.delUpObjectBySql(sql, new Object[]{user_guid,carNum});
			 if(a>0){
				 b = true;
			 }
			 return b;
		}catch(Exception e){
			return false;
		}
	}
	

}
