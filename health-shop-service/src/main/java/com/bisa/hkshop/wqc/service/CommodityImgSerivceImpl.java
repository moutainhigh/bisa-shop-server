package com.bisa.hkshop.wqc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.bisa.health.routing.annotation.RoutingTab;
import com.bisa.health.routing.annotation.TableEnum;
import com.bisa.hkshop.model.CommodityImg;
import com.bisa.hkshop.wqc.basic.dao.BaseDao;
import com.bisa.hkshop.wqc.dao.ICommodityDao;
import com.bisa.hkshop.wqc.dao.ICommodityImgDao;
@Service
@RoutingTab(TableEnum.MASTER)
public class CommodityImgSerivceImpl implements ICommodityImgService{

	@Autowired
	private ICommodityImgDao iCommodityImgDao;
	
	@Override
	public List<CommodityImg> getCommodityImg(String productId) {
		// TODO Auto-generated method stub
		return iCommodityImgDao.getCommodityImg(productId);
	}

	
}
