package com.bisa.hkshop.zj.controller;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jdom.JDOMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bisa.hkshop.model.Active;
import com.bisa.hkshop.model.Commodity;
import com.bisa.hkshop.model.Order;
import com.bisa.hkshop.model.OrderDetail;
import com.bisa.hkshop.model.Trade;
import com.bisa.hkshop.wqc.basic.utility.GuidGenerator;
import com.bisa.hkshop.wqc.service.ICommodityService;
import com.bisa.hkshop.wqc.service.IOrderDetailService;
import com.bisa.hkshop.wqc.service.IOrderService;
import com.bisa.hkshop.wqc.service.ITradeService;
import com.bisa.hkshop.zj.basic.utility.DateUtil;
import com.bisa.hkshop.zj.basic.utility.WechatPayCommonUtil;
import com.bisa.hkshop.zj.basic.utility.WechatPayConfigUtil;
import com.bisa.hkshop.zj.basic.utility.XMLUtil;
import com.bisa.hkshop.zj.service.IActiveService;




@Controller
@RequestMapping("/l")
public class ShopPayCallBack {
	
	@Autowired
	private IOrderService orderService;
	
	@Autowired
	private ITradeService tradeService;
	
	@Autowired
	private IOrderDetailService orderDetailService;
	
	@Autowired
	private IActiveService activeService;
	
	@Autowired
	private ICommodityService commodityService;
	
	private static Logger logger = LogManager.getLogger(ShopPayCallBack.class.getName());
	
	/**
	 * 微信平台发起的回调方法，
	 * 调用我们这个系统的这个方法接口，将扫描支付的处理结果告知我们系统
	 * @throws JDOMException
	 * @throws Exception
	 */
	@RequestMapping(value="/notify",method=RequestMethod.POST)
	public void  weixinNotify(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws JDOMException, Exception{
		 int user_guid = 2;
		  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  Date date = new Date();
	       //读取参数  
	       InputStream inputStream ;  
	       StringBuffer sb = new StringBuffer();  
	       inputStream = request.getInputStream();  
	       String s ;  
	       BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));  
	       while ((s = in.readLine()) != null){  
	           sb.append(s);
	       }
	       in.close();
	       inputStream.close();
	  
	       //解析xml成map  
	       Map<String, String> m = new HashMap<String, String>();  
	       m = XMLUtil.doXMLParse(sb.toString());  
	        
	       //过滤空 设置 TreeMap  
	       SortedMap<Object,Object> packageParams = new TreeMap<Object,Object>();        
	       Iterator it = m.keySet().iterator();  
	       while (it.hasNext()) {  
	           String parameter = (String) it.next();
	           String parameterValue = m.get(parameter);
	            
	           String v = "";  
	           if(null != parameterValue) {	
	               v = parameterValue.trim();  
	           }  
	           packageParams.put(parameter, v);  
	       }  
	          
	       // 账号信息  
	       String key = WechatPayConfigUtil.API_KEY; //key  
	  
	       //判断签名是否正确  
	       if(WechatPayCommonUtil.isTenpaySign("UTF-8", packageParams,key)) {  
	           //------------------------------  
	           //处理业务开始  
	           //------------------------------  
	           String resXml = "";  
	           if("SUCCESS".equals((String)packageParams.get("result_code"))){  
	               // 这里是支付成功  
	               //////////执行自己的业务逻辑////////////////  
	               String mch_id = (String)packageParams.get("mch_id");  
	               String openid = (String)packageParams.get("openid");  
	               String is_subscribe = (String)packageParams.get("is_subscribe");  
	               String out_trade_no = (String)packageParams.get("out_trade_no");  	                
	               String total_fee = (String)packageParams.get("total_fee");                
	        	   System.out.println(">>>>>回调中的tradeNo" + out_trade_no);
	        	   Trade trade = tradeService.loadTrade(2,out_trade_no);
	        	   trade.setStatus(1002);//已支付
	        	   trade.setPay_type(1002);//微信支付
	        	   Order order = orderService.loadOrderByOrderId(2,trade.getOrder_guid());
	        	   List<OrderDetail> orderDetailList = orderDetailService.loadOrderDetailList(user_guid, out_trade_no);
	        	   int i=0;//用来判定订单里购买的是否都是服务，如果都是服务在生成激活码之后，订单显示为已收货，不用发货。
	        	   for(OrderDetail orderDetail : orderDetailList){
	        		  
	        		   if(orderDetail.getAscription_guid()=="4001"||orderDetail.getAscription_guid()=="4002"
	        				   ||orderDetail.getAscription_guid()=="4003"){
	        				/*
	   		   		  	 * 生成激活码
	   		   		  	 */
	        			i++;
	        			Commodity commodtity = commodityService.getcommodity(orderDetail.getAscription_guid());//拿到当前服务信息
	   		   		  	Active active = new Active();
	   		   		  	active.setActive_code(GuidGenerator.generate(16));
	   		   		  	active.setActive_life(DateUtil.getAddTime(24, null));
	   		   		  	active.setActive_statu(1);
	   		   		  	active.setGuid(commodtity.getType()); //服务类型
	   		   		  	active.setService_guid(orderDetail.getAscription_guid());
	   		   		  	active.setService_name(orderDetail.getProduct_name());
	   		   		  	active.setService_number(orderDetail.getCount());
	   		   		  	active.setStart_time(date);
	   		   		  	active.setUser_guid(user_guid);
	   		   		  	activeService.addActive(active);
	   		   		  	logger.info("生成激活码");
	   		   		    orderDetail.setTra_status(30);//交易状态
	        		   }else{
	        			   orderDetail.setTra_status(20); //交易状态
	        			   
	        		   }
	        		   orderDetail.setAppraise_status(1);//是否已经评价过了
	        		   orderDetail.setAppraise_isnot(1);//评价有效
	        		   orderDetailService.updateActive(2,orderDetail);
	        	   }
	        	   //判断如果全是购买的服务则订单交易完成
	        	   if(i==orderDetailList.size()){
	        		   order.setTra_status(30);
	        		   order.setTrade_ok_time(date);
	        		   order.setAppraise_status(1);
	        	   }else{
	        		   order.setTra_status(20);
	        	   }
	        	   logger.info("修改订单");
	        	   order.setUpdate_time(date);
	        	   orderService.updateOrder(2,order);
	        	   
	        	   
		   			/*
		   			 * 将交易的状态改为已添加过的服务状态
		   			 */
		   		  	tradeService.updateTrade(trade);
		   		  	
	                System.out.println("支付成功");  
	               
	               //通知微信.异步确认成功.必写.不然会一直通知后台.八次之后就认为交易失败了.  
	               resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"  
	                       + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";  
	                  
	           } else {
	               resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"  
	                       + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";  
	           }
	           //------------------------------  
	           //处理业务完毕  
	           //------------------------------  
	           
	           BufferedOutputStream out = new BufferedOutputStream(  
	                   response.getOutputStream());  
	           out.write(resXml.getBytes());  
	           out.flush();  
	           out.close();
	           
	       } else{  
	         System.out.println("通知签名验证失败");  
	       }
	       
	}
	
	
		//支付宝回调
		@RequestMapping(value="/aliPayCallback",method=RequestMethod.POST)
		public void loadCallback(HttpServletRequest request,HttpServletResponse response, HttpSession session){
			System.out.println(">>>>>>>>>>>>>>>>>>>ali回调");
			Date date = new Date();
			int user_guid = 2;
			SimpleDateFormat df = new SimpleDateFormat("yyyy-dd-mm HH:mm:ss");
			String tradeNo = request.getParameter("out_trade_no");
			//String tradeNo = (String)session.getAttribute("tradeNo");
			if(request.getParameter("trade_status").equals("TRADE_SUCCESS")){
		 	    System.out.println("huitiaozhong >>>>>>>>>>>" + tradeNo);
		 	   //int user_guid = Integer.valueOf(tradeNo.substring(tradeNo.indexOf("N")));
		 	   Trade trade = tradeService.loadTrade(user_guid,tradeNo);
	    	   trade.setStatus(1002);//已支付
	    	   trade.setPay_type(1002);//微信支付
	    	   Order order = orderService.loadOrderByOrderId(user_guid,trade.getOrder_guid());
	    	   List<OrderDetail> orderDetailList = orderDetailService.loadOrderDetailList(user_guid, tradeNo);
	    	   int i=0;//用来判定订单里购买的是否都是服务，如果都是服务在生成激活码之后，订单显示为已收货，不用发货。
	    	   for(OrderDetail orderDetail : orderDetailList){
	    		  
	    		   if(orderDetail.getAscription_guid()=="4001"||orderDetail.getAscription_guid()=="4002"
	    				   ||orderDetail.getAscription_guid()=="4003"){
	    				/*
			   		  	 * 生成激活码
			   		  	 */
	    			   	i++;
	    			   	Commodity commodtity = commodityService.getcommodity(orderDetail.getAscription_guid());//拿到当前服务信息
			   		  	Active active = new Active();
			   		  	active.setActive_code(GuidGenerator.generate(16));
			   		  	active.setActive_life(DateUtil.getAddTime(24, null));
			   		  	active.setActive_statu(1);
			   		  	active.setGuid(commodtity.getType());//设置服务类型
			   		  	active.setService_guid(orderDetail.getAscription_guid());
			   		  	active.setService_name(orderDetail.getProduct_name());
			   		  	active.setService_number(orderDetail.getCount());
			   		  	active.setStart_time(date);
			   		  	active.setUser_guid(user_guid);
			   		    orderDetail.setTra_status(30);//交易状态
	    		   }else{
	    			   orderDetail.setTra_status(20); //交易状态
	    		   }
	    		   orderDetail.setAppraise_status(1);//是否已经评价过了
	    		   orderDetail.setAppraise_isnot(1);//评价有效
	    		   orderDetailService.updateActive(2,orderDetail);
	    	   }
	    	   //判断如果全是购买的服务则订单交易完成
	    	   if(i==orderDetailList.size()){
	    		   order.setTra_status(30);
	    		   order.setTrade_ok_time(date);
	    		   order.setAppraise_status(1);
	    	   }else{
	    		   order.setTra_status(20);
	    	   }
	    	   logger.info("修改订单");
	    	   order.setUpdate_time(date);
	    	   orderService.updateOrder(2,order);
	   			/*
	   			 * 将交易的状态改为已添加过的服务状态
	   			 */
	   			tradeService.updateTrade(trade);
	            System.out.println("支付成功");  
					try {
						response.getWriter().write("success"); //告诉支付宝通知已经推送成功
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		         System.out.println("支付成功");
			}
		}
		
}
