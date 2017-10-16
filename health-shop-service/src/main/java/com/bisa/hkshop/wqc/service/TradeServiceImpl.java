package com.bisa.hkshop.wqc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bisa.health.routing.annotation.DataGuid;
import com.bisa.health.routing.annotation.DataRouting;
import com.bisa.health.routing.annotation.RoutingTab;
import com.bisa.health.routing.annotation.TableEnum;
import com.bisa.hkshop.model.Trade;
import com.bisa.hkshop.wqc.dao.ITradeDao;

@Service
@RoutingTab(TableEnum.SWITCH)
public class TradeServiceImpl implements ITradeService{

	@Autowired
	private ITradeDao tradeDao;
	
	@Override
	@DataRouting("user_guid")
	public Trade loadTrade(@DataGuid("user_guid") int user_guid,String tradeNo) {
		return tradeDao.loadTrade(user_guid,tradeNo);
	}

	@Override
	@DataRouting("user_guid")
	public List<Trade> loadTradeList(@DataGuid("user_guid") int user_guid) {
		return tradeDao.loadTradeList(user_guid);
	}
	
	@Override
	@DataRouting("user_guid")
	public Boolean addTrade(@DataGuid("user_guid") Trade trade) {
		return tradeDao.addTrade(trade);
	}

	@Override
	@DataRouting("user_guid")
	public Boolean updateTrade(@DataGuid("user_guid") Trade trade) {
		
		return tradeDao.updateTrade(trade);
	}

	

}
