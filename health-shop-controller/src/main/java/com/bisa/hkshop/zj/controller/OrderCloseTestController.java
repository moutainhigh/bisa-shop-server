package com.bisa.hkshop.zj.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bisa.hkshop.model.Order;
import com.bisa.hkshop.model.OrderDetail;
import com.bisa.hkshop.wqc.basic.utility.KdniaoTrackQueryAPI;
import com.bisa.hkshop.wqc.service.IOrderDetailService;
import com.bisa.hkshop.wqc.service.IOrderService;
import com.bisa.hkshop.zj.basic.utility.BaseDelayed;
import com.bisa.hkshop.zj.basic.utility.DelayedService;
import com.bisa.hkshop.zj.basic.utility.DelayedService.OnDelayedListener;
import com.bisa.hkshop.zj.basic.utility.DelayedService.OnStartListener;
import com.bisa.hkshop.zj.basic.utility.ThreadPoolUtil;


@Controller
@RequestMapping("/l")
public class OrderCloseTestController {
	@Autowired  
	private IOrderService IOrderService;
	@Autowired
	IOrderDetailService IOrderDetailService;
	
	public String[] AcceptStation; 
	public String[] AcceptTime;
	
	public static class DelayedOrder extends BaseDelayed<String>{
		public DelayedOrder(int timeout, String orderId,int uid){
			super(timeout, orderId,uid);
		}
		public String getOrderId(){
			return super.getValue();
		}
	}
	
	
	@PostConstruct
	public void delayed() {
		
		
	}
	    
	@RequestMapping(value="/testdelayed",method=RequestMethod.GET)
	public String testdelayed(HttpServletRequest request){
		int intTime = Integer.valueOf(request.getParameter("intTime"));
		String order_no = request.getParameter("order_no");
		
		DelayedService service = new DelayedService();
		
		service.start(new OnStartListener(){
			@Override 
			public void onStart() {
				System.out.println("启动完成");
			}
		}, 
		new OnDelayedListener(){
			@Override
			public <T extends BaseDelayed<?>> void onDelayedArrived(T delayed) {
				System.out.println("[onDelayedArrived]"+delayed.toString());
				int user_guid = 2;
				Order od=IOrderService.loadOrderByOrderId(2, (String)delayed.getValue());
				if(od==null){
					System.out.println("用户没有订单>>"+user_guid);
				}else{
							String logistics_number=od.getLogistics_number(); 	
							String logistics_name=od.getLogistics_name();
							KdniaoTrackQueryAPI api = new KdniaoTrackQueryAPI();
							String result;
						try {
							//result = api.getOrderTracesByJson("logistics_name", "logistics_number");
							//result = api.getOrderTracesByJson("YTO", "886592328420907712");
							result = api.getOrderTracesByJson("BTWL", "70075250701164");
							JSONObject jsonObj = new JSONObject(result);
							String State=jsonObj.getString("State");
							if(State.equals("3")){
								JSONArray jsonArray=jsonObj.getJSONArray("Traces");
								System.out.println("jsonArray.length():"+jsonArray.length());
								AcceptStation = new String[ jsonArray.length() ];//初始化数组
								AcceptTime = new String[ jsonArray.length()];//初始化数组
								for(int i = 0; i<jsonArray.length(); i++){
									JSONObject jsonTemp = (JSONObject)jsonArray.getJSONObject(i);
									 AcceptStation[i]=jsonTemp.getString("AcceptStation");
									 AcceptTime[i]=jsonTemp.getString("AcceptTime");
									if(AcceptStation[i].contains("已签收")||AcceptStation[i].contains("签收人")){
										SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
										Date dates=sdf.parse(AcceptTime[i]);
										long date=dates.getTime();
										System.out.print("Format To times:"+dates.getTime());  
									 	long servenday=518400;
									 	date=date+servenday;
									 	long time = System.currentTimeMillis();
									 	if(time>date){
									 		od.setTra_status(30);
									 		String order_no=od.getOrder_no();
									 		Boolean SS=IOrderService.updateOrder(user_guid, od);
									 		List<OrderDetail> OrderDetail=IOrderDetailService.loadOrderDetailList(user_guid, order_no);
									 		for(OrderDetail ordertail:OrderDetail) {
									 			if(ordertail==null) {
									 				System.out.println("订单无详情，订单出错");
									 			}else {
									 				ordertail.setTra_status(30);
									 				System.out.println("ordertail:"+ordertail.getTra_status());
									 			}
									 		}
									 		System.out.print("订单:"+od.getOrder_no()+"收货了");

									 	}
									}
								}
							}else{
								service.add(new DelayedOrder(5,od.getOrder_no(),2));
							}

						}catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
			}
		});
		
		service.add(new DelayedOrder(604800,order_no,2));
		
		return "";
	}
	
}
