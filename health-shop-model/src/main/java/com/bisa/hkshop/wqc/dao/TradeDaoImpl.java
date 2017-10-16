package com.bisa.hkshop.wqc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bisa.hkshop.model.Trade;
import com.bisa.hkshop.wqc.basic.dao.BaseDao;




@Repository
public class TradeDaoImpl extends BaseDao<Trade> implements ITradeDao{

	@Override
	public Trade loadTrade(int user_guid,String tradeNo) {
		Trade trade;
		try{
			String sql = "select * from s_trade where user_guid=? and trade_no=?";
			trade = this.queryObjectBySql(sql, new Object[]{user_guid,tradeNo}, Trade.class);
		}catch(Exception e){
			return null;
		}
		return trade;
	}

	@Override
	public List<Trade> loadTradeList(int user_guid) {
		List<Trade> trade;
		try{
			String sql = "select * from s_trade where user_guid=? and status=1002";
			trade = this.queryListBySql(sql, new Object[]{user_guid}, Trade.class);
		}catch(Exception e){
			return null;
		}
		return trade;
	}
	
	
	@Override
	public Boolean addTrade(Trade trade) {
		
		String sql = "insert into s_trade(s_trade.order_guid,s_trade.pay_type,"
				+ "s_trade.price,s_trade.start_time,s_trade.status,s_trade.trade_no,"
				+ "s_trade.user_guid,s_trade.guid) values(?,?,?,?,?,?,?,?)";
		int i=super.addObjectBySql(sql, new Object[]{trade.getOrder_guid(),trade.getPay_type(),trade.getPrice()
				,trade.getStart_time(),trade.getStatus(),trade.getTrade_no(),trade.getUser_guid(),trade.getGuid()});
		if(i>0){
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Boolean updateTrade(Trade trade) {
		try{
			String sql = "UPDATE Trade s_trade SET s_trade.order_guid=?,s_trade.pay_type=?,"
					+ "s_trade.price=?,s_trade.start_time=?,s_trade.status=?,"
					+ "s_trade.guid=? where s_trade.user_guid=? and s_trade.trade_no=?";
			this.updateByHql(sql, new Object[]{trade.getOrder_guid(),trade.getPay_type(),trade.getPrice()
					,trade.getStart_time(),trade.getStatus(),trade.getGuid(),trade.getUser_guid(),trade.getTrade_no()});
		}catch(Exception e){
			return false;
		}
		return true;
	}

	
	
	
}
