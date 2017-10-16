<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../comm/tag.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- necessary -->
    <meta name="keywords" content="1,2,3">
    <meta name="description" content="">
    <!-- description -->
    <meta name="renderer" content="webkit">
    <title>碧沙康健_订单提交成功页</title>
    <!-- base -->
    
    <link href="<%=request.getContextPath() %>/resources/ctrl/Font-Awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/ctrl/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/comm/swiper.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/comm/base.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/index/index.css" rel="stylesheet">
    
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
  	<%@ include file="../comm/header.jsp" %> 
    <div class="wrap">
        <div class="container pl-0 pr-0">
            <div class="clear">
                <p class="pt-10 pb-10 pl-15 pr-15 line-h-20 bg-f5f5f5 cur-d ">
                    <a class="col-666 t-nonehove hovecol-309DE2" href="">首页 </a>
                    >
                    <span class="col-252525 t-nonehove">购物车</span>
                </p>
                <p class="pt-10 pb-10 pl-15 pr-15 line-h-40 cur-d col-252525 family-h f-26">
                    支付订单
                </p>
            </div>
            <div class="clear pt-20 pl-20 pr-20 bg-f5f5f5 pb-45 full-w cur-d">
                <div class="clear bg-white">
                    <div class="clear col-sm-2 pt-60 pb-60">
                        <img class="clear img-80 mg-0-auto dis-b" src="<%=request.getContextPath() %>/resources/images/net_shopping/produ-right.png" alt="">
                    </div>
                    <div class="col-sm-7 pt-40 pb-40">
                        <p class="f-26 family-h col-252525 line-h-30">
                            订单提交成功，请选择付款方式。
                        </p>
                        <p class="f-16 family-h col-252525 line-h-30 pt-10">
                            请在 <span class="col-309DE2">2小时</span> 内完成支付，超时后将取消订单
                        </p>
                        <p class="f-16 family-h col-252525 line-h-30 pt-10">
                            收货信息：<span class="col-252525">${address.address }</span>
                        </p>
                    </div>
                    <div class="col-sm-3 pt-100 pb-40">
                        <p class="f-16 family-h col-252525 line-h-30 pt-10">
                            应付总额：<span class="f-26 col-309DE2">${price}</span> 元
                        </p> 
                    </div>
                </div>
                
                <div class="clear mt-40 bg-white pt-25 pb-25 pl-50 pr-50">
                    <p class="f-18 family-h col-666 line-h-30 bor bor-b bor-col-D2D2D2 pb-10">
                        请选择以下支付方式付款
                    </p>
                    <p class="f-18 family-h col-252525 line-h-30 pt-20 pb-20">
                        支付平台
                    </p>
                    <div class="clear full-w pay-way">
                        <img class="pull-left dis-b w-150 bor bor-col-B2B2B2 pt-10 pb-10 pl-30 pr-30 cur-p weixinpay" src="<%=request.getContextPath() %>/resources/images/net_shopping/weixinpay.png" alt="">
                        <img class="pull-left dis-b w-150 bor bor-col-B2B2B2 ml-20 pt-10 pb-10 pl-30 pr-30 cur-p zhifubaopay" src="<%=request.getContextPath() %>/resources/images/net_shopping/zhifubaopay.png" alt="">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- 弹出层 -->
    <!-- 微信支付 -->
    <div class="clear show-weixinpay affix t-0 l-0 z-999 full-wh rgba-60 dis-n">
        <div class="pos-a t-30s l-0 full-w">
            <div class="w-400 mg-0-auto clear pos-r bg-white weixinpay-content">
                <div class="pt-15 pb-15 line-h-30 pos-r f-18 pl-20 pr-20 col-4a4a4a full-w bg-f5f5f5">
                    微信支付
                    <img class="pos-a t-20 r-20 img-20 close-mod cur-p" src="<%=request.getContextPath() %>/resources/images/net_shopping/close.png" alt="">
                </div>
                <form class="clear pos-r" action="">
                    <div class="clear">
                        <p class="f-30 pt-60 pb-10 text-center">
                           <img  src="<%=request.getContextPath() %>/l/wechatPay?21231234546" >
                        </p>
                    </div>
                    <div class="clear full-w line-h-30 pt-10 pb-20 text-center">
                        <p class="family-h f-14 col-4a4a4a">
                            请使用<span class="col-309DE2">微信</span>扫一扫
                        </p>
                        <p class="family-h f-14 col-4a4a4a">
                            二维码完成支付
                        </p>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!-- 支付宝支付 -->
    <div class="clear show-zhifubaopay affix t-0 l-0 z-999 full-wh rgba-60 dis-n">
        <div class="pos-a t-30s l-0 full-w">
            <div class="w-400 mg-0-auto clear pos-r bg-white zhifubaopay-content">
                <div class="pt-15 pb-15 line-h-30 pos-r f-18 pl-20 pr-20 col-4a4a4a full-w bg-f5f5f5">
                    支付宝支付
                    <img class="pos-a t-20 r-20 img-20 close-mod cur-p" src="<%=request.getContextPath() %>/resources/images/net_shopping/close.png" alt="">
                </div>
                <form class="clear pos-r" action="">
                    <div class="clear">
                        <p class="f-30 pt-60 pb-10 text-center">
                            <img src="<%=request.getContextPath() %>/l/zfbqrcode?orderId=${orderId}&21231234546"  alt="">
                        </p>
                    </div>
                    <div class="clear full-w line-h-30 pt-10 pb-20 text-center">
                        <p class="family-h f-14 col-4a4a4a">
                            请使用<span class="col-309DE2">支付宝</span>扫一扫
                        </p>
                        <p class="family-h f-14 col-4a4a4a">
                            二维码完成支付
                        </p>
                    </div>
                </form>
            </div>
        </div>
        
        
    </div>
    <%@ include file="../comm/footer.jsp" %> 
    
    <script src="<%=request.getContextPath() %>/resources/js/comm/jquery.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/ctrl/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/comm/swiper.jquery.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/comm/base.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/shopping/HK_Payment.js"></script>
    
    <%-- 
    <script type="text/javascript">
    var i=0;
    $(document).ready(function(){ 	 
  		c = window.setInterval("getResult()",2000); //间隔多少秒去触发ajax
  		 });
 
  	 function getResult(){
  		 i++; //记录轮询的次数  
  		 //这里写你的代码 
 		  $.ajax({
 	          type:'get',
 	           url:'<%=request.getContextPath()%>/l/hadPay',
 	           dataType:'json',
 	           async: false,
 	           success:function(json){
 	        	  
 	        	   alert("sa");
 	               if(json.hadpay == "1001"){ //处理自己的业务
 	                   window.location.href = '<%=request.getContextPath()%>/l/success';
 	               }
 	        		//设置轮询了多少次停止轮询
 	              if(i==6){
 	           	  	window.clearInterval(c);
 	              }
 	           }
 	       });
 		
  	 }

    </script>
 --%>
    
</body>

</html>