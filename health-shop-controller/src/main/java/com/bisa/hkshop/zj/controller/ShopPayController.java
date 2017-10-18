package com.bisa.hkshop.zj.controller;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.demo.trade.config.Configs;
import com.alipay.demo.trade.model.ExtendParams;
import com.alipay.demo.trade.model.GoodsDetail;
import com.alipay.demo.trade.model.builder.AlipayTradePrecreateRequestBuilder;
import com.alipay.demo.trade.model.builder.AlipayTradeQueryRequestBuilder;
import com.alipay.demo.trade.model.result.AlipayF2FPrecreateResult;
import com.alipay.demo.trade.model.result.AlipayF2FQueryResult;
import com.alipay.demo.trade.service.AlipayTradeService;
import com.alipay.demo.trade.service.impl.AlipayTradeServiceImpl;
import com.bisa.hkshop.model.Trade;
import com.bisa.hkshop.wqc.service.ITradeService;
import com.bisa.hkshop.zj.basic.utility.AlipayConfig;
import com.bisa.hkshop.zj.basic.utility.CommonUtil;
import com.bisa.hkshop.zj.basic.utility.WechatPayCommonUtil;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;


@Controller
@RequestMapping("/l")
public class ShopPayController {
	
	@Autowired
	private ITradeService tradeService;
	

	private static Logger logger = LogManager.getLogger(ShopPayController.class.getName());
	
    // 支付宝当面付2.0服务
    private  AlipayTradeService aliTradeService;
    static{
    	Configs.init("zfbinfo.properties");
    }
	 
	/*
	 * 轮询判断是否已经支付成功
	 */
	@ResponseBody
	@RequestMapping(value="/hadPay",method=RequestMethod.GET)
	public Map<String,String> loadby1Package(HttpServletRequest request,HttpSession session){
		Map<String,String> map = new HashMap<String,String>();
		String order_no = request.getParameter("order_no");
		System.out.println("轮询："+order_no);
		map.put("hadpay", "1002");
		//判断UUID是否相等
		Trade trade  = tradeService.loadTrade(2,order_no);
		System.out.println("zhuangtai>>>>>>>>>>>>" + trade.getStatus());
		if(trade.getStatus()==1002){
			map.put("hadpay","1001"); //支付成功跳转到支付成功的页面
		}
		return map;
	}
	
	/*
	 * 刷新服务按钮，防止出现用户支付成功但没有添加上服务密钥：BS7WFSS9s3dSWJGRS5kyEg==
	 */	
	@ResponseBody
	@RequestMapping(value="/selectOrder",method=RequestMethod.GET)
	public Map<String,String> selectOrder(){
		
		Map<String,String> map = new HashMap<String,String>();
		
		return map;
	}
	
	
	/*
	 * 根据参数生成微信二维码。
	 */
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value="/wechatPay",method=RequestMethod.GET,produces="image/jpeg")
	public void wechatPay(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	       //获取购买服务的guid,以及次数。（guid用来查询服务是一分钟服务，还是二十四小时服务，或者是平安钟服务）
		    System.out.println("微信支付请求");
		    int user_guid = 2;
			String order_no = request.getParameter("order_no");
			System.out.println("wechat:"+ order_no);
			Trade trade = tradeService.loadTradeByorder_no(user_guid,order_no);
					String text = null;
					try {
						text = WechatPayCommonUtil.weixin_pay(trade);
						// 二维码的图片格式
						Hashtable hints = new Hashtable();
						// 内容所使用编码
						hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
					 	response.setHeader("Pragma", "no-cache");
				        response.setHeader("Cache-Control", "no-cache");
				        response.setDateHeader("Expires", 0);
				        response.setContentType("image/jpeg");
						BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, 300, 300, hints);
						BufferedImage image = CommonUtil.toBufferedImage(bitMatrix);
						ImageIO.write(image, "jpg", response.getOutputStream());
					} catch (Exception e) {
						e.printStackTrace();
					}
	}
	
	
	
	
	
	/*
	 * 支付宝支付
	 */
	/*
	 * 支付宝支付
	 */
	public  String loadAlipay(Trade trade){
		 // (必填) 商户网站订单系统中唯一订单号，64个字符以内，只能包含字母、数字、下划线，
       // 需保证商户系统端不能重复，建议通过数据库sequence生成，
		
       String outTradeNo = trade.getTrade_no();

       // (必填) 订单标题，粗略描述用户的支付目的。如“xxx品牌xxx门店当面付扫码消费”
       String subject = "碧沙商城支付";
       
       // (必填) 订单总金额，单位为元，不能超过1亿元
       // 如果同时传入了【打折金额】,【不可打折金额】,【订单总金额】三者,则必须满足如下条件:【订单总金额】=【打折金额】+【不可打折金额】
       
       String totalAmount = trade.getPrice();
       // (可选) 订单不可打折金额，可以配合商家平台配置折扣活动，如果酒水不参与打折，则将对应金额填写至此字段
       // 如果该值未传入,但传入了【订单总金额】,【打折金额】,则该值默认为【订单总金额】-【打折金额】
       String undiscountableAmount = "0";

       // 卖家支付宝账号ID，用于支持一个签约账号下支持打款到不同的收款账号，(打款到sellerId对应的支付宝账号)
       // 如果该字段为空，则默认为与支付宝签约的商户的PID，也就是appid对应的PID
       String sellerId = "";

       // 订单描述，可以对交易或商品进行一个详细地描述，比如填写"购买商品2件共15.00元"
       String body = "购买商品3件共20.00元";

       // 商户操作员编号，添加此参数可以为商户操作员做销售统计
       String operatorId = "test_operator_id";

       // (必填) 商户门店编号，通过门店号和商家后台可以配置精准到门店的折扣信息，详询支付宝技术支持
       String storeId = "test_store_id";

       // 业务扩展参数，目前可添加由支付宝分配的系统商编号(通过setSysServiceProviderId方法)，详情请咨询支付宝技术支持
       ExtendParams extendParams = new ExtendParams();
       //extendParams.setSysServiceProviderId("2088102172141188");

       // 支付超时，定义为120分钟
       String timeoutExpress = "120m";

       // 商品明细列表，需填写购买商品详细信息，
       List<GoodsDetail> goodsDetailList = new ArrayList<GoodsDetail>();
       // 创建一个商品信息，参数含义分别为商品id（使用国标）、名称、单价（单位为分）、数量，如果需要添加商品类别，详见GoodsDetail
       // 创建好一个商品后添加至商品明细列表

       // 继续创建并添加第一条商品信息，用户购买的产品为“黑人牙刷”，单价为5.00元，购买了两件
       GoodsDetail goods2 = GoodsDetail.newInstance("goods_id002", "xxx牙刷", 500, 2);
       goodsDetailList.add(goods2);

       // 创建扫码支付请求builder，设置请求参数
       AlipayTradePrecreateRequestBuilder builder = new AlipayTradePrecreateRequestBuilder()
           .setSubject(subject).setTotalAmount(totalAmount).setOutTradeNo(outTradeNo)
           .setUndiscountableAmount(undiscountableAmount).setSellerId(sellerId).setBody(body)
           .setOperatorId(operatorId).setStoreId(storeId).setExtendParams(extendParams)
           .setTimeoutExpress(timeoutExpress)
           .setNotifyUrl(AlipayConfig.notifyUrl)//支付宝服务器主动通知商户服务器里指定的页面http路径,根据需要设置
           .setGoodsDetailList(goodsDetailList);
       /** 使用Configs提供的默认参数
        *  AlipayTradeService可以使用单例或者为静态成员对象，不需要反复new
        */
       aliTradeService = new AlipayTradeServiceImpl.ClientBuilder().build();
       AlipayF2FPrecreateResult result = aliTradeService.tradePrecreate(builder);
       AlipayTradePrecreateResponse response1 =result.getResponse();
       System.out.println(response1.getBody());
       switch (result.getTradeStatus()) {
           case SUCCESS:
               AlipayTradePrecreateResponse response = result.getResponse();
               // 需要修改为运行机器上的路径
               String filePath = String.format("/Users/sudo/Desktop/qr-%s.png",
                   response.getOutTradeNo());
               System.out.println(">>>>>>>>>>>>>>>>>>>>qrcode" + response.getQrCode());
               return response.getQrCode();
               
           case FAILED:
               return "FAILED";

           case UNKNOWN:
               return "UNKNOWN";
           default:
               return "3";
       }
       
	}
	
	
	@RequestMapping(value="/zfbqrcode",method=RequestMethod.GET,produces="image/jpeg")
	public void zfbqrcode(HttpServletRequest request, HttpServletResponse response,
	    HttpSession session) throws Exception{
		System.out.println("支付宝二维码");
	   /* try {*/
	    	 //获取购买服务的guid,以及次数。（guid用来查询服务是一分钟服务，还是二十四小时服务，或者是平安钟服务）
		       String order_no = request.getParameter("order_no");
		       int user_guid = 2;
		        System.out.println(">>>>>>>>支付宝tradeNo:" + order_no);
		        Trade trade = tradeService.loadTradeByorder_no(user_guid,order_no);
		        
		        System.out.println("zhifubao " + trade.getOrder_guid() + trade.getGuid() + "   " + trade.getTrade_no() + (trade==null));
		        
			       String text = loadAlipay(trade); 
			       //根据url来生成生成二维码
			       //二维码的图片格式 
			       Hashtable hints = new Hashtable(); 
			       	//内容所使用编码 
			       	hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
				 	response.setHeader("Pragma", "no-cache");
			        response.setHeader("Cache-Control", "no-cache");
			        response.setDateHeader("Expires", 0);
			        response.setContentType("image/jpeg");
			        
			        BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, 300, 300, hints);
					BufferedImage image = CommonUtil.toBufferedImage(bitMatrix);
					ImageIO.write(image, "jpg", response.getOutputStream());
	  /*  } catch (Exception e) {
	    	System.out.println(">>>>>>>支付宝请求扫码出现异常");
	    	try {
				response.sendRedirect(request.getContextPath() + "/l/error");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	    }
	*/
	
	}
	
	
	
	 // 测试当面付2.0查询订单
    public String test_trade_query(String outTradeNo) {
    	 // (必填) 商户订单号，通过此商户订单号查询当面付的交易状态
        // String outTradeNo = "tradeprecreate15016386524965545757";

         // 创建查询请求builder，设置请求参数
         AlipayTradeQueryRequestBuilder builder = new AlipayTradeQueryRequestBuilder()
             .setOutTradeNo(outTradeNo);

         AlipayF2FQueryResult result = aliTradeService.queryTradeResult(builder);
         switch (result.getTradeStatus()) {
             case SUCCESS:
                 return "OK";

             case FAILED:
                 //log.error("查询返回该订单支付失败或被关闭!!!");
             	 return "FAILED";

             case UNKNOWN:
                // log.error("系统异常，订单支付状态未知!!!");
             	 return "UNKNOWN";
             	 
             default:
               //  log.error("不支持的交易状态，交易返回异常!!!");
             	 return "ERROR";
         }
    }
    
    
    /*
	 * 支付成功，进行添加服务
	 */
	@RequestMapping(value="/success",method=RequestMethod.GET)
	public String loadsuccess(){
		return "order/success";
	}
    
	
}
