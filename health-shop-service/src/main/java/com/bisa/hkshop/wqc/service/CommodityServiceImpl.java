package com.bisa.hkshop.wqc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bisa.health.entity.Pager;
import com.bisa.health.routing.annotation.RoutingTab;
import com.bisa.health.routing.annotation.TableEnum;
import com.bisa.hkshop.model.Commodity;
import com.bisa.hkshop.wqc.dao.ICommodityDao;

@Service
@RoutingTab(TableEnum.MASTER)
public class CommodityServiceImpl implements ICommodityService{
	@Autowired
	private ICommodityDao iCommodityDao;
	
	@Override
	public Commodity getcommodity(String product_number) {
		// TODO Auto-generated method stub
		return iCommodityDao.getcommodity(product_number);
	}

	@Override
	public Pager<Commodity> getselCommodityPage() {
		// TODO Auto-generated method stub
		return iCommodityDao.getselCommodityPage();
	}



	@Override
	public int addCommodity(Commodity comm) {
		// TODO Auto-generated method stub
		return iCommodityDao.addCommodity(comm);
	}

	@Override
	public int updateCommodity(Commodity comm) {
		 return iCommodityDao.updateCommodity(comm);
		
	}

	@Override
	public int delCommdity(String shop_number) {
		// TODO Auto-generated method stub
		return iCommodityDao.delCommdity(shop_number);
	}

	@Override
	public List<Commodity> getcommodity() {
		// TODO Auto-generated method stub
		return iCommodityDao.getcommodity();
	}

	@Override
	public List<Commodity> selthreeCon(String shop_Number) {
		// TODO Auto-generated method stub
		return iCommodityDao.selthreeCon(shop_Number);
	}

	@Override
	public List<Commodity> getTypecommodity(String classification) {
		// TODO Auto-generated method stub
		return iCommodityDao.getTypecommodity(classification);
	}

	/*@Override
	public Commodity getcompro_guid(int product_guid) {
		// TODO Auto-generated method stub
		return iCommodityDao.getcompro_guid(product_guid);
	}*/
	

}
