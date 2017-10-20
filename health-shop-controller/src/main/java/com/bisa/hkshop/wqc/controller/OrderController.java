package com.bisa.hkshop.wqc.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.dao.DataAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod;
import com.bisa.hkshop.model.Package;
import com.bisa.health.utils.CacheUtity;
import com.bisa.hkshop.model.Address;
import com.bisa.hkshop.model.Cart;
import com.bisa.hkshop.model.Commodity;
import com.bisa.hkshop.model.Order;
import com.bisa.hkshop.model.OrderDetail;
import com.bisa.hkshop.model.Trade;
import com.bisa.hkshop.wqc.basic.model.OrderDetailDto;
import com.bisa.hkshop.wqc.basic.utility.GuidGenerator;
import com.bisa.hkshop.wqc.service.IAddressService;
import com.bisa.hkshop.wqc.service.ICartService;
import com.bisa.hkshop.wqc.service.ICommodityService;
import com.bisa.hkshop.wqc.service.IOrderDetailService;
import com.bisa.hkshop.wqc.service.IOrderService;
import com.bisa.hkshop.wqc.service.IPackageService;
import com.bisa.hkshop.wqc.service.ITradeService;
import com.bisa.hkshop.wqc.service.IUserOrderDetailService;
import com.bisa.hkshop.zj.basic.utility.BaseDelayed;
import com.bisa.hkshop.zj.basic.utility.DelayedService;
import com.bisa.hkshop.zj.basic.utility.DelayedService.OnDelayedListener;
import com.bisa.hkshop.zj.basic.utility.DelayedService.OnStartListener;
import com.bisa.hkshop.zj.controller.OrderCloseTestController.DelayedOrder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Controller
@RequestMapping("/l")
public class OrderController {

	@Autowired
	private IAddressService addressService;
	
	@Autowired
	private IOrderService orderService;
	
	@Autowired
	private IOrderDetailService orderDetailService;
	
	@Autowired
	private ITradeService tradeService;
	
	@Autowired
	private IPackageService packageService;
	
	@Autowired
	private ICommodityService commodityService;
	
	@Autowired
	private ICartService shopCartService;

	
/*	@Resource(name = "orderPayTimer")
	private RedisTemplate orderPayTimer;*/
	/*
	 * 跳转到下订单页面
	 */
	@RequestMapping(value="orderIndex",method=RequestMethod.POST)
	public String orderIndex(Model model,HttpServletRequest request){
		
		/*
		 * 加个判断用户是否登录
		 */
		//从购物车中传来的
		/*String str1 = "{\"records\":[{'cartid':'630ed3c3971b46b5a091c5e0616f101e','cartnum':'1','cartkind':1,'cartimg':'/resources/images/producttipsv1.png','cartdir':'HC3A250 悉心心电仪','cartprice':'2000'}]}";
		String str = "{\"product\":[{\"cartid\":\"120001\",\"cartnum\":\"1\",\"cartkind\":1,\"cartimg\":\"/resources/images/producttipsv1.png\",\"cartdir\":\"HC3A250 悉心心电仪\",\"cartprice\":\"2000\"}]}";*/
		String str=request.getParameter("data");
		//从立即购买传来的
		Map<String,List<OrderDetailDto>> map = new Gson().fromJson(str, new TypeToken<HashMap<String,List<OrderDetailDto>>>(){}.getType());
		System.out.println("Gsonmap:" + new Gson().toJson(map));
		double price = 0;
		int count = 0;
		for (Map.Entry entry : map.entrySet()) {       
		    String key = (String) entry.getKey( );    
		    List<OrderDetailDto> orderDetailList = map.get(key);
		    for(OrderDetailDto orderDetail : orderDetailList){
		    	price = price + Double.valueOf(orderDetail.getCartprice()) * Integer.valueOf(orderDetail.getCartnum());
		    	count = count + Integer.valueOf(orderDetail.getCartnum());
		    }
		}   
		
		double postPrice = 0;
		double total = price;
		
		if(price<350){
			postPrice = 30.00;
			total = price + postPrice;
		}
		
		
		//取出username
		List<Address> addressList = addressService.loadAddressList(2);
		Gson gson = new Gson();
		//System.out.println(">>>>>>>>>>gson:" + data);
		model.addAttribute("productStr",str);
		model.addAttribute("productList",map);
		model.addAttribute("addressList",addressList);
		model.addAttribute("price",price);
		model.addAttribute("count",count);
		model.addAttribute("postPrice",postPrice);
		model.addAttribute("total",total);
		return "order/hk_order";
		
	}
	
	//从购物车过来结算
	@RequestMapping(value="/commitOrder",method=RequestMethod.POST)
	public String commitOrder(HttpServletRequest request,Model model,HttpSession session){
		
		Order order;
		Address address ;
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = request.getParameter("productList");
		String addr_num = request.getParameter("addr_num");
		if(str==null || str.equals("") || addr_num==null || addr_num.equals("")){
			model.addAttribute("messege","地址不正确");
			return "500";
		}
		
			int user_guid=2;
			//查出收货地址
			 address = addressService.loadAddressByAddressNum(user_guid,addr_num);
			
			//将封装好的数据转成map
			Map<String,List<OrderDetailDto>> map = new Gson().fromJson(str, new TypeToken<HashMap<String,List<OrderDetailDto>>>(){}.getType());
			
		    String from_data="";
		    
			for (Map.Entry entry : map.entrySet()) {       
			    from_data = (String) entry.getKey();
			    System.out.println(">>>>>form_data" + from_data);
			}   
			//订单号
			String orderGuid = "BISA" + System.currentTimeMillis() + "";
			
			List<OrderDetailDto> orderDetailList;
			//从购物车过来的
			if(from_data.equals("records")){
				orderDetailList = map.get(from_data);
				
				
				//把dto的每个记录都去购物车表里找，一个一个添加到list
				List<Cart> car =new ArrayList<Cart>();
				String num = "";
				for(int i=0;i<orderDetailList.size();i++){
					if(i==0){
						num =  num + orderDetailList.get(i).getCartid();
						Cart cart=shopCartService.getCart(user_guid, num);
						car.add(cart);
					}else{
						num = orderDetailList.get(i).getCartid();
						Cart cart=shopCartService.getCart(user_guid, num);
						car.add(cart);
					}
				}
			//查出购物车中的要买的东西
								
				double price = 0;
				//处理订单信息，添加订单中的具体的商品细节，并且删除购物车中的物品
				for(Cart orderCar : car){
					price = price + orderCar.getTotal();
					OrderDetail orderDetail = new OrderDetail();
					//添加订单细节表
					orderDetail.setOrder_detail_guid(GuidGenerator.generate());
					orderDetail.setOrder_no(orderGuid);
					orderDetail.setPic(orderCar.getMain_picture());
					orderDetail.setProduct_name(orderCar.getTitle());
					orderDetail.setAscription(orderCar.getSing_cox());
					orderDetail.setAscription_guid(orderCar.getPackId());
					orderDetail.setCount(orderCar.getNumber());
					orderDetail.setStart_time(date);
					orderDetail.setUser_guid(user_guid);
					orderDetail.setPrice(orderCar.getPrice());
					orderDetail.setAppraise_isnot(1);
					orderDetail.setTra_status(10);
					orderDetail.setAppraise_status(1);
					orderDetailService.addOrderDetail(orderDetail);
					//删除购物车中的当前商品
					int is_not=shopCartService.delCart(user_guid,orderCar.getPackId());	
					if(is_not>0) {
						System.out.println("删除购物车商品成功:哪个用户："+orderCar.getUser_guid()+"商品编号："+orderCar.getCart_number());
					}else {
						System.out.println("删除购物车商品失败:哪个用户："+orderCar.getUser_guid()+"商品编号："+orderCar.getCart_number());
					}
				}
				
				Order orderN = new Order();
				//order.setId(1);
				orderN.setOrder_no(orderGuid);
				orderN.setAddr_num(addr_num);
				
				if(price<350){
					orderN.setPrice(price+30 + "");
				}else{
					orderN.setPrice(price+"");
				}
				orderN.setUser_guid(user_guid);
				orderN.setTra_status(10);//未付款
				orderN.setStart_time(date);
				orderN.setEffective_statu(1);
				orderService.addOrder(user_guid,orderN);
				order = orderN;

				//在这里添加延时队列进来,并且加入redis	
				//现在加入delayQueque
				/*DelayedService service = new DelayedService();
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
						//在这里插入一天后要做的事，关闭订单
						order.setTra_status(50);
						order.setEffective_statu(2);
						Boolean o=orderService.updateOrder(user_guid, order);
						if(o) {
							System.out.println("取消订单执行成功"+order.getOrder_no());
						}else {
							System.out.println("取消订单执行失败"+order.getOrder_no());
						}
						List<OrderDetail> orderList=orderDetailService.loadOrderDetailList(user_guid, order.getOrder_no());
						for(OrderDetail OrderDetail: orderList) {
							 OrderDetail.setTra_status(50);
							 OrderDetail.setAppraise_status(2);
							 int od=orderDetailService.updateActive(user_guid, OrderDetail);
							 if(od>0) {
									System.out.println("订单详情关闭成功"+OrderDetail.getOrder_detail_guid());
								}else {
									System.out.println("订单详情关闭失败"+OrderDetail.getOrder_detail_guid());
								}
						 }
					}
				});
				service.add(new DelayedOrder(86400,order.getOrder_no(),user_guid));*/
				//现在加入redis
			/*	orderPayTimer.execute(new RedisCallback<Boolean>() {
					public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
						String sms_key = "order_userguid" + order.getUser_guid();
						connection.setEx(sms_key.getBytes(), 12, CacheUtity.toByteArray(order));
						return true;
					}
				});*/
				//在这里添加延时队列进来,并且加入redis结束
			}else{
				//立即购买过来结算
				if(from_data.equals("product")){
					orderDetailList = map.get(from_data);
					//order = orderService.addProductOrder(orderDetailList,addr_num, 2);
					
					double price = 0;
					for(int i=0;i<orderDetailList.size();i++){
						OrderDetailDto orderDetailDto = orderDetailList.get(i);
						System.out.println("orderDetailDto>>>>>>>" + orderDetailDto.getCartkind());
						//判断是套餐还是商品,0是单品，1是套餐，2是服务
						if(orderDetailDto.getCartkind().equals("1")){
							Package pa = packageService.getpackages(orderDetailDto.getCartid());
							  //处理订单信息，添加订单中的具体的商品细节，并且删除购物车中的物品
							price = price + pa.getPrice() * Integer.valueOf(orderDetailDto.getCartnum());
							OrderDetail orderDetail = new OrderDetail();
							//添加订单细节表
							orderDetail.setOrder_detail_guid(GuidGenerator.generate());
							orderDetail.setOrder_no(orderGuid);
							orderDetail.setPic(pa.getMain_picture());
							orderDetail.setProduct_name(pa.getPackage_name());
							orderDetail.setAscription("1");
							orderDetail.setAscription_guid(pa.getPackage_number());
							orderDetail.setCount(Integer.valueOf(orderDetailDto.getCartnum()));
							orderDetail.setPrice(pa.getPrice());
							orderDetail.setStart_time(date);
							orderDetail.setUser_guid(user_guid);
							orderDetail.setAppraise_isnot(1);
	/*						orderDetail.setTra_status(10);
							orderDetail.setAppraise_status(1);*/
							orderDetailService.addOrderDetail(orderDetail);
						}else{
							Commodity pro = commodityService.getcommodity(orderDetailDto.getCartid());
							  //处理订单信息，添加订单中的具体的商品细节，并且删除购物车中的物品
							price = price + pro.getSelling_price() * Integer.valueOf(orderDetailDto.getCartnum());
							OrderDetail orderDetail = new OrderDetail();
							//添加订单细节表
							orderDetail.setOrder_detail_guid(GuidGenerator.generate());
							orderDetail.setOrder_no(orderGuid);
							orderDetail.setPic(pro.getMain_picture());
							orderDetail.setProduct_name(pro.getTitle());
							orderDetail.setAscription("0");
							orderDetail.setAscription_guid(pro.getShop_number());
							orderDetail.setCount(Integer.valueOf(orderDetailDto.getCartnum()));
							orderDetail.setStart_time(date);
							orderDetail.setUser_guid(user_guid);
							orderDetail.setAppraise_isnot(1);
							orderDetail.setPrice(pro.getSelling_price()*Integer.valueOf(orderDetailDto.getCartnum()));
							/*orderDetail.setTra_status(10);
							orderDetail.setAppraise_status(1);*/
							orderDetailService.addOrderDetail(orderDetail);
						}
					}
					
					Order orderN = new Order();
					//orderN.setId(1);
					orderN.setOrder_no(orderGuid);
					orderN.setAddr_num(addr_num);
					orderN.setPrice(price + "");
					orderN.setUser_guid(user_guid);
					orderN.setTra_status(10);//未付款
					orderN.setStart_time(date);
					orderN.setEffective_statu(1);
					orderService.addOrder(user_guid,orderN);
					order = orderN;
					
					//在这里添加延时队列进来,并且加入redis	
					//现在加入delayQueque
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
						}
						
					});
					service.add(new DelayedOrder(86400,order.getOrder_no(),user_guid));
					//现在加入redis
					/*orderPayTimer.execute(new RedisCallback<Boolean>() {
						public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
							String sms_key = "order_userguid" + order.getUser_guid();
							//connection.setEx(sms_key.getBytes(), null, CacheUtity.toByteArray(order));
							return true;
						}
					});*/
					//在这里添加延时队列进来,并且加入redis结束
			
					
				}else{
					return "500";
				}
			}
			
			String trade_no = GuidGenerator.generate(16)+"N"+user_guid; //随机产生的订单号
			Trade trade = new Trade();
			trade.setOrder_guid(order.getOrder_no());
			trade.setStatus(1001);
			trade.setPrice(order.getPrice());
			trade.setStart_time(date);
			trade.setTrade_no(trade_no);
			trade.setPay_type(0);
			trade.setGuid(GuidGenerator.generate());
			//拿出用户的唯一uuid
			trade.setUser_guid(user_guid);
			//添加交易记录的表
			boolean i=tradeService.addTrade(trade);
			System.out.println("添加交易记录"+i);
			
		model.addAttribute("price",order.getPrice());
		model.addAttribute("orderId",order.getOrder_no());
		model.addAttribute("address",address);
		return "order/HK-payment";
	}
	
		//个人中心中的立即下单
		@RequestMapping(value="/order_pay",method=RequestMethod.GET)
		public String order_pay(HttpServletRequest request,Model model,HttpSession session){
			String order_no = request.getParameter("order_no");
			int user_guid = 2;
			if(order_no==null || order_no.equals("")){
				model.addAttribute("messege","订单信息出错");
				return "500";
			}
			
			Order order = orderService.loadOrderByOrderId(2,order_no);
			
			if(order==null){
				model.addAttribute("messege","订单信息出错");
				return "500";
			}
			
			String trade_no = GuidGenerator.generate(16); //随机产生的交易号
			
			Date date = new Date();
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-dd-mm HH:mm:ss");
			
			
			Trade trade = tradeService.loadTradeByorder_no(user_guid, order_no);
			trade.setTrade_no(trade_no+"N"+user_guid);
			//拿出用户的唯一uuid
			//添加交易记录的表
			tradeService.updateTrade(trade);
			//将交易信息存到session中
			Address address = addressService.loadAddressByAddressNum(user_guid,order.getAddr_num());
			model.addAttribute("price",order.getPrice());
			model.addAttribute("orderId",order.getOrder_no());
			model.addAttribute("address",address);
			return "order/HK-payment";
		}
		
		//取消订单
		@RequestMapping(value="/order_close",method=RequestMethod.GET)
		public String order_close(HttpServletRequest request,Model model,HttpSession session){
			String order_no = request.getParameter("order_no");
			session.setAttribute("user_guid", 2);
			int user_guid=(int) session.getAttribute("user_guid");
			Order order = orderService.loadOrderByOrderId(user_guid,order_no);
			order.setEffective_statu(2);//关闭订单，改变状态
			order.setTrade_fail_cause("客户自己取消订单");
			order.setTra_status(50);
			order.setAppraise_status(2);

			orderService.updateOrder(user_guid,order);
			List<OrderDetail> OrderDetail=orderDetailService.loadOrderDetailList(user_guid, order_no);
			for(OrderDetail od:OrderDetail) {
				od.setTra_status(50);
				od.setAppraise_isnot(2);
				System.out.println("order_detail_guid===="+od.getOrder_detail_guid());
				orderDetailService.updateActive(user_guid, od);
			}
			return "order/success";
		}

}
