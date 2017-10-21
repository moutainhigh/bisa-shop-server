package com.bisa.hkshop.wqc.service;

import java.util.List;

import com.bisa.hkshop.model.CommodityImg;

public interface ICommodityImgService {

	public List<CommodityImg> getCommodityImg(String productId);
}
