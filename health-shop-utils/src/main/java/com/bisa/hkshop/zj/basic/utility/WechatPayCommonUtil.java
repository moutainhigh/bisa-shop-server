package com.bisa.hkshop.zj.basic.utility;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import com.bisa.hkshop.model.Trade;


public class WechatPayCommonUtil {
	
	
	
	 
		/* * 购买请求参数，提交给微信支付平台，得到支付的url*/
		 
		public static String weixin_pay(Trade trade) throws Exception {
			
			//int price = serviceInfo.getService_price();
			String productId = "购买服务";
			
			// 账号信息
			String appid = WechatPayConfigUtil.APP_ID; // appid
			// String appsecret = PayConfigUtil.APP_SECRET; // appsecret
			String mch_id = WechatPayConfigUtil.MCH_ID; // 商业号
			String key = WechatPayConfigUtil.API_KEY; // key
			
			String currTime = WechatPayCommonUtil.getCurrTime();
			String strTime = currTime.substring(8, currTime.length());
			String strRandom = WechatPayCommonUtil.buildRandom(4) + "";
			String nonce_str = strTime + strRandom;
			
			String order_price = "1"; // 价格 注意：价格的单位是分
			String body = productId; // 商品名称
			//System.out.println(Math.abs(new Random(System.currentTimeMillis()).nextInt()));
			String out_trade_no = trade.getTrade_no(); // 订单号
			// 获取发起电脑 ip
			String spbill_create_ip = WechatPayConfigUtil.CREATE_IP;
			// 回调接口
			String notify_url = WechatPayConfigUtil.NOTIFY_URL;
			String trade_type = "NATIVE";
			
			SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
			packageParams.put("appid", appid);
			packageParams.put("mch_id", mch_id);
			packageParams.put("nonce_str", nonce_str);
			packageParams.put("body", body);
			packageParams.put("out_trade_no", out_trade_no);
			packageParams.put("total_fee", order_price);
			packageParams.put("spbill_create_ip", spbill_create_ip);
			packageParams.put("notify_url", notify_url);
			packageParams.put("trade_type", trade_type);
			String sign = WechatPayCommonUtil.createSign("UTF-8", packageParams, key);
			packageParams.put("sign", sign);
			
			String requestXML = WechatPayCommonUtil.getRequestXml(packageParams);
			//System.out.println(requestXML);
			String resXml = HttpUtil.postData(WechatPayConfigUtil.UFDODER_URL, requestXML);
			System.out.println(resXml);
			Map map = XMLUtil.doXMLParse(resXml);
			// String return_code = (String) map.get("return_code");
			// String prepay_id = (String) map.get("prepay_id");
			String urlCode = (String) map.get("code_url");
			System.out.println(urlCode);
			//urlCode = urlCode + "zj";
			return urlCode;
		}
	
	
	/* * 向微信支付接口发起查询订单支付是否成功*/
       public static String selectOrder(String trade_no) throws Exception {
				
			// 账号信息
			String appid = WechatPayConfigUtil.APP_ID; // appid
			// String appsecret = PayConfigUtil.APP_SECRET; // appsecret
			String mch_id = WechatPayConfigUtil.MCH_ID; // 商业号
			String key = WechatPayConfigUtil.API_KEY; // key

			String currTime = WechatPayCommonUtil.getCurrTime();
			String strTime = currTime.substring(8, currTime.length());
			String strRandom = WechatPayCommonUtil.buildRandom(4) + "";
			String nonce_str = strTime + strRandom;
			String out_trade_no = trade_no; // 订单号	
			SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
			packageParams.put("appid", appid);
			packageParams.put("mch_id", mch_id);
			packageParams.put("nonce_str", nonce_str);
			packageParams.put("out_trade_no", out_trade_no);	
			//packageParams.put("spbill_create_ip", spbill_create_ip);
			String sign = WechatPayCommonUtil.createSign("UTF-8", packageParams, key);
			packageParams.put("sign", sign);
			
			String requestXML = WechatPayCommonUtil.getRequestXml(packageParams);
			
			String resXml = HttpUtil.postData(WechatPayConfigUtil.ORDER_URL, requestXML);
			System.out.println(resXml);
			Map map = XMLUtil.doXMLParse(resXml);
			String trade_state = (String) map.get("trade_state");
			System.out.println(trade_state);
			return trade_state;
			
		}
			
		
		
		
   /* * 生成交易的信息*/
	/*	 
	public static Trade loadTradeInfo(ServiceInfo serviceInfo,String trade_no){
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String currenTime = formatter.format(date);		
		Trade trade = new Trade();
		trade.setCount(serviceInfo.getService_diff());
		trade.setFinishi_time(currenTime);
		trade.setService_guid(serviceInfo.getService_guid());
		trade.setService_name(serviceInfo.getService_name());
		trade.setService_type(serviceInfo.getService_type());
		trade.setTradeNo(trade_no);
		trade.setStatu(1);
		return trade;
		
	}
		*/
		
	
	
	 /** 
     * 是否签名正确,规则是:按参数名称a-z排序,遇到空值的参数不参加签名。 
     * @return boolean 
     */  
    public static boolean isTenpaySign(String characterEncoding, SortedMap<Object, Object> packageParams, String API_KEY) {  
        StringBuffer sb = new StringBuffer();  
        Set es = packageParams.entrySet();  
        Iterator it = es.iterator();  
        while(it.hasNext()) {  
            Map.Entry entry = (Map.Entry)it.next();  
            String k = (String)entry.getKey();  
            String v = (String)entry.getValue();  
            if(!"sign".equals(k) && null != v && !"".equals(v)) {  
                sb.append(k + "=" + v + "&");  
            }  
        }  
          
        sb.append("key=" + API_KEY);  
          
        //算出摘要  
        String mysign = MD5Util.MD5Encode(sb.toString(), characterEncoding).toLowerCase();  
        String tenpaySign = ((String)packageParams.get("sign")).toLowerCase();  
          
        //System.out.println(tenpaySign + "    " + mysign);  
        return tenpaySign.equals(mysign);  
    }  
  
    /** 
     * @author 
     * @date 2016-4-22 
     * @Description：sign签名 
     * @param characterEncoding 
     *            编码格式 
     * @param parameters 
     *            请求参数 
     * @return 
     */  
    public static String createSign(String characterEncoding, SortedMap<Object, Object> packageParams, String API_KEY) {  
        StringBuffer sb = new StringBuffer();  
        Set es = packageParams.entrySet();  
        Iterator it = es.iterator();  
        while (it.hasNext()) {  
            Map.Entry entry = (Map.Entry) it.next();  
            String k = (String) entry.getKey();  
            String v = (String) entry.getValue();  
            if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {  
                sb.append(k + "=" + v + "&");  
            }  
        }  
        sb.append("key=" + API_KEY);  
        String sign = MD5Util.MD5Encode(sb.toString(), characterEncoding).toUpperCase();  
        return sign;  
    }  
  
    /** 
     * @author 
     * @date 2016-4-22 
     * @Description：将请求参数转换为xml格式的string 
     * @param parameters 
     *            请求参数 
     * @return 
     */  
    public static String getRequestXml(SortedMap<Object, Object> parameters) {  
        StringBuffer sb = new StringBuffer();  
        sb.append("<xml>");  
        Set es = parameters.entrySet();  
        Iterator it = es.iterator();  
        while (it.hasNext()) {  
            Map.Entry entry = (Map.Entry) it.next();  
            String k = (String) entry.getKey();  
            String v = (String) entry.getValue();  
            if ("attach".equalsIgnoreCase(k) || "body".equalsIgnoreCase(k) || "sign".equalsIgnoreCase(k)) {  
                sb.append("<" + k + ">" + "<![CDATA[" + v + "]]></" + k + ">");  
            } else {  
                sb.append("<" + k + ">" + v + "</" + k + ">");  
            }  
        }  
        sb.append("</xml>");  
        return sb.toString();  
    }  
  
    /** 
     * 取出一个指定长度大小的随机正整数. 
     *  
     * @param length 
     *            int 设定所取出随机数的长度。length小于11 
     * @return int 返回生成的随机数。 
     */  
    public static int buildRandom(int length) {  
        int num = 1;  
        double random = Math.random();  
        if (random < 0.1) {  
            random = random + 0.1;  
        }  
        for (int i = 0; i < length; i++) {  
            num = num * 10;  
        }  
        return (int) ((random * num));  
    }  
  
    /** 
     * 获取当前时间 yyyyMMddHHmmss 
     *  
     * @return String 
     */  
    public static String getCurrTime() {  
        Date now = new Date();  
        SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");  
        String s = outFormat.format(now);  
        return s;  
    }
    
    
    
     
    
    /**
     * URL编码（utf-8）
     * 
     * @param source
     * @return
     */
    public static String urlEncodeUTF8(String source) {
        String result = source;
        try {
            result = java.net.URLEncoder.encode(source, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }
   
    
    
}
