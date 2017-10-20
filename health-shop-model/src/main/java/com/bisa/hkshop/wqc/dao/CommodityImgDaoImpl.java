package com.bisa.hkshop.wqc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bisa.hkshop.model.Commodity;
import com.bisa.hkshop.model.CommodityImg;
import com.bisa.hkshop.wqc.basic.dao.BaseDao;
@Repository
public class CommodityImgDaoImpl  extends BaseDao<CommodityImg> implements ICommodityImgDao{

	@Override
	public List<CommodityImg> getCommodityImg(String productId) {
		// TODO Auto-generated method stub
		String sql="select * from s_commodity_img where product_id=? order by type desc";
		return super.queryListBySql(sql, new Object[]{productId}, CommodityImg.class);
	}

	
}
