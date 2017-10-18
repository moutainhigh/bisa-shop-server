package com.bisa.hkshop.Queue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bisa.hkshop.model.Order;
import com.bisa.hkshop.model.OrderDetail;
import com.bisa.hkshop.wqc.basic.utility.KdniaoTrackQueryAPI;
import com.bisa.hkshop.wqc.service.IOrderDetailService;
import com.bisa.hkshop.wqc.service.IOrderService;
@Service 
public class OrderpayJob implements Delayed{
	@Autowired  
	private IOrderService IOrderService;
	@Autowired
	IOrderDetailService IOrderDetailService;
	public String[] AcceptStation; 
	public String[] AcceptTime;
	  
	private String order_no;
	private int user_guid;
	private long expTime;//延期时间

	public OrderpayJob(String order_no, long expTime,int user_guid) {
		super();
		this.order_no = order_no;
		this.user_guid=user_guid;
		this.expTime =expTime+(1507305600-1506787200);
	}

	public String getOrder_no() {
		return order_no;
	}

	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}

	public long getExpTime() {
		return expTime;
	}

	public void setExpTime(long expTime) {
		this.expTime = expTime;
	}
	
  public int getUser_guid() {
		return user_guid;
	}

	public void setUser_guid(int user_guid) {
		this.user_guid = user_guid;
	}

	//判断出队列的顺序，
	@Override
	public int compareTo(Delayed o) {
		if(o==this) {
			return 0;
		}
		if(o instanceof OrderpayJob) {
			OrderpayJob OrderpayJob=(OrderpayJob)o;
			long expTime=OrderpayJob.getExpTime();
			return (int)(this.expTime - expTime);  
		}
		return 0;
	}
	//判断订单出对列
	@Override
	public long getDelay(TimeUnit unit) {
		// TODO Auto-generated method stub
		Order od=IOrderService.loadOrderByOrderId(user_guid, order_no);
		if(od==null){
			System.out.println("用户没有订单>>"+user_guid);
		}else{
					String logistics_number=od.getLogistics_number(); 	
					String logistics_name=od.getLogistics_name();
					KdniaoTrackQueryAPI api = new KdniaoTrackQueryAPI();
					String result;
				try {
					//result = api.getOrderTracesByJson("logistics_name", "logistics_number");
					result = api.getOrderTracesByJson("YTO", "886592328420907712");
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
					return 0;
					}else{
						return expTime+(1506960000-1506787200);
					}

				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return -1;
	}
}
