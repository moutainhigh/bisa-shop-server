package com.bisa.hkshop.wqc.web.quartz;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.bisa.hkshop.model.Order;
import com.bisa.hkshop.model.OrderDetail;
import com.bisa.hkshop.wqc.basic.utility.KdniaoTrackQueryAPI;
import com.bisa.hkshop.wqc.service.IOrderDetailService;
import com.bisa.hkshop.wqc.service.IOrderService;

/**
 * 定时任务调度——每隔15s查询一次数据库，若有未推送的报告，用信鸽推送给用户
 * 测试期间为了防止频繁推送，设置时间为900000=900s=15m
 * @author Administrator
 *
 */
public class OrderJob implements Job {
	
	
	/**
	 * Key used to store the session manager in the job data map for this job.
	 */
	public static final String SESSION_MANAGER_KEY = "sessionManager";
	public static final String SESSION_TWO_KEY = "sessionTwoManager";
	public   String[] AcceptStation; 
    public  String[] AcceptTime;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
			//XingeController xc = new XingeController();
			
			JobDataMap jobDataMap = context.getMergedJobDataMap();
			IOrderService IOrderService = (IOrderService) jobDataMap.get(SESSION_MANAGER_KEY);
			IOrderDetailService IOrderDetailService=(IOrderDetailService)jobDataMap.get(SESSION_TWO_KEY);
			System.out.println(".............IOrderService" + (IOrderService));
			System.out.println(".............IOrderDetailService" + (IOrderDetailService));
			/**
			 * 先查询所有的用户，在找到所有的user_guid,在查询所有的订单
			 */
			int user_guid=2;
			List<Order> order=IOrderService.loadOrderList(user_guid);
			if(order==null){
				System.out.println("用户没有订单>>"+user_guid);
			}else{
				for(Order od:order){
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
								 				/*Boolean isnot=IOrderDetailService.updateActive(user_guid, ordertail);
								 				System.out.println("ordertail2:"+ordertail.getTra_status());
								 				if(isnot){
								 					System.out.print("订单详情:"+od.getOrder_no()+"收货了");
								 				}*/
								 			}
								 		}
								 		System.out.print("订单:"+od.getOrder_no()+"收货了");
								 	}
								}
							}
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
}
	

