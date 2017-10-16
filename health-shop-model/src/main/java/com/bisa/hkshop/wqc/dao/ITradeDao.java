package com.bisa.hkshop.wqc.dao;

import java.util.List;

import com.bisa.hkshop.model.Trade;





public interface ITradeDao {
	
	public Trade loadTrade(int user_guid,String tradeNo);
	
	public List<Trade> loadTradeList(int user_guid);
	
	public Boolean addTrade(Trade trade);
	
	public Boolean updateTrade(Trade trade);
}
