package com.bisa.hkshop.wqc.dao;


import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.bisa.health.entity.Pager;
import com.bisa.hkshop.model.Commodity;
import com.bisa.hkshop.wqc.basic.dao.BaseDao;
import com.bisa.hkshop.wqc.basic.dao.StringUtil;
@Repository
public class CommodityDaoImpl extends BaseDao<Commodity> implements ICommodityDao{

	@Override
	public Commodity getcommodity(String product_number) {
		// TODO Auto-generated method stub
		String sql="select * from s_commodity where shop_number=?";
		return super.queryObjectBySql(sql, new Object[]{product_number}, Commodity.class);
	}

	@Override
	public Pager<Commodity> getselCommodityPage() {
		String sql = "select * from s_commodity";
		return super.findBySql(sql, Commodity.class, true);
	}


	@Override
	public int addCommodity(Commodity comm) {
		// TODO Auto-generated method stub
		String sql="insert into s_commodity(id,shop_number,title,subtitle,description,selling_price,classification,orderId,"
				+ "type,main_picture,pic1_picture,pic2_picture,pic3_picture,pic4_picture,insertime,updatime,product_guid) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return super.addObjectBySql(sql, new Object[] {comm.getId(),comm.getShop_number(),comm.getTitle(),comm.getSubtitle(),comm.getDescription(),comm.getSelling_price(),
				comm.getClassification(),comm.getOrderId(),comm.getType(),comm.getMain_picture(),comm.getPic1_picture(),comm.getPic2_picture(),comm.getPic3_picture(),
				comm.getPic4_picture(),comm.getInsertime(),comm.getUpdatime(),comm.getProduct_guid()});
	}

	@Override
	public int updateCommodity(Commodity comm) {
		// TODO Auto-generated method stub
		String sql="update s_commodity as c set c.id=?,c.shop_number=?,c.title=?,c.subtitle=?,c.description=?,c.selling_price=?,c.classification=?,"
				+ "c.orderId=?,c.type=?,c.main_picture=?,c.pic1_picture=?,c.pic2_picture=?,c.pic3_picture=?,c.pic4_picture=?,c.insertime=?,c.updatetime=? where c.shop_number=?";
		return super.delUpObjectBySql(sql, new Object[] {comm.getId(),comm.getShop_number(),comm.getTitle(),comm.getSubtitle(),comm.getDescription(),comm.getSelling_price(),
				comm.getClassification(),comm.getOrderId(),comm.getType(),comm.getMain_picture(),comm.getPic1_picture(),comm.getPic2_picture(),comm.getPic3_picture(),
				comm.getPic4_picture(),comm.getInsertime(),comm.getUpdatime(),comm.getShop_number()});
	}

	@Override
	public int delCommdity(String shop_number) {
		// TODO Auto-generated method stub
		String sql="delete from s_commodity s where s.shop_number=?";
		return super.delUpObjectBySql(sql,new Object[]{shop_number});
	}

	@Override
	public List<Commodity> getcommodity() {
		String sql = "select * from s_commodity";
		return super.queryListBySql(sql, null, Commodity.class);
	}

	@Override
	public List<Commodity> selthreeCon(String shop_Number) {
		// TODO Auto-generated method stub
		String sql="select * from s_commodity where classification=? order by orderId desc";
		return super.queryListBySql(sql, new Object[]{shop_Number}, Commodity.class);
	}

	@Override
	public List<Commodity> getTypecommodity(String classification) {
		// TODO Auto-generated method stub
		String sql="select * from s_commodity where classification=? order by updatime desc";	
		return super.queryListBySql(sql, new Object[]{classification},Commodity.class);
	}

/*	@Override
	public Commodity getcompro_guid(int product_guid) {
		// TODO Auto-generated method stub
		String sql="select * from s_commodity where product_guid=?";	
		return super.queryObjectBySql(sql, new Object[]{product_guid},Commodity.class);
	}*/
	

	

}
