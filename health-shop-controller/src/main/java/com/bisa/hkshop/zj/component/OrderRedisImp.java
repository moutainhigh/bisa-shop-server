package com.bisa.hkshop.zj.component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.bisa.health.appserver.utils.CacheUtity;
import com.bisa.hkshop.zj.basic.utility.BaseDelayed;
import com.bisa.hkshop.zj.basic.utility.DelayOrderDto;

@Component
public class OrderRedisImp implements IOrderRedis{

	@Autowired
	private RedisTemplate redisTemp;
	
	private static Logger logger = LogManager.getLogger(OrderRedisImp.class.getName());
	
	//获取所有redis中所有的order
	@Override
	public HashMap<String,BaseDelayed<String>> getOrderRedis() {
		DelayOrderDto order = null;
		if(redisTemp.hasKey("order")){
			        order = (DelayOrderDto) redisTemp.execute(new RedisCallback<Object>() {
					public Object doInRedis(RedisConnection connection) throws DataAccessException {
						String sms_key = "order";
						byte[] value = connection.get(sms_key.getBytes());
						if(value.length>0){
							return CacheUtity.toObject(value);
						}else{
							return new DelayOrderDto();
						}
					}
				});
		  return  order.getDelaylist();
		}
		return null;
	}
	
	
	//添加到缓存
	public void addOrderRedis(BaseDelayed<String> delayed) {
		/**
		 * 将order存到redis缓存
		 */
		
		HashMap<String,BaseDelayed<String>> delayList = this.getOrderRedis();
		if(delayList==null){
			delayList = new HashMap<String,BaseDelayed<String>>();
		}
		delayList.put(delayed.getValue(), delayed);
		
		DelayOrderDto order = new DelayOrderDto();
		order.setDelaylist(delayList); //存到封装好的map中
		
		redisTemp.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				String sms_key = "order";
				connection.setEx(sms_key.getBytes(), 3600, CacheUtity.toByteArray(order));
				logger.info("添加订单到redis");
				return true;
			}
		});
		
		
	}

	
	//删除缓存中某个order
	public void delOrderRedis(String order_no) {
		/*
		 * 将delay从redis中的删除
		 */
		HashMap<String,BaseDelayed<String>> delayList = this.getOrderRedis();
		delayList.remove(order_no);
		DelayOrderDto order = new DelayOrderDto();
		order.setDelaylist(delayList); //存到封装好的list中
		redisTemp.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				String sms_key = "order";
				connection.setEx(sms_key.getBytes(), 3600, CacheUtity.toByteArray(order));
				logger.info("从redis中删除订单");
				return true;
			}
		});
		
	}

	
	
}
