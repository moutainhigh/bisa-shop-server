package com.bisa.hkshop.wqc.dao;

import java.util.List;

import com.bisa.hkshop.model.CommodityImg;

public interface ICommodityImgDao {

	public List<CommodityImg> getCommodityImg(String productId);
}
