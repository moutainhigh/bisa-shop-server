package com.bisa.hkshop.wqc.service;

import java.util.List;

import com.bisa.health.entity.Pager;
import com.bisa.hkshop.model.Commodity;

public interface ICommodityService {

	//根据商品编号获取商品详情
	public Commodity getcommodity(String product_number);
	//查询所有商品不带分页
	public List<Commodity> getcommodity();
	//获取所有商品带分页的
	public Pager<Commodity> getselCommodityPage();

	//添加商品
	public int addCommodity(Commodity comm);
	//修改商品
	public int updateCommodity(Commodity comm);
	//删除商品
	public int delCommdity(String shop_number);
	
	public List<Commodity> selthreeCon(String shop_Number);
	
	public List<Commodity> getTypecommodity(String classification);
	

	
}
