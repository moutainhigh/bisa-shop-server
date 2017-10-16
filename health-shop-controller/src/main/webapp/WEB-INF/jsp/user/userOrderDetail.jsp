<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">

<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- necessary -->
    <meta name="keywords" content="1,2,3">
    <meta name="description" content="">
    <!-- description -->
    <meta name="renderer" content="webkit">
    <title>碧沙康健_订单详情页</title>
    <!-- base -->
    <link href="<%=request.getContextPath() %>/resources/ctrl/Font-Awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/ctrl/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/comm/base.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/user/HK_Order.css" rel="stylesheet">
    
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<%@ include file="../comm/header.jsp" %> 
    <div class="wrap clear">
        <div class="container pl-0 pr-0">
            <div class="clear">
                <p class="pt-10 pb-10 pl-15 pr-15 line-h-20 cur-d ">
                    <a class="col-666 t-nonehove hovecol-309DE2" href="">首页 </a> >
                    <span class="col-252525 t-nonehove">我的订单</span>
                </p>
            </div>
        </div>
        <div class="clear full-w">
            <img class="full-w" src="<%=request.getContextPath() %>/resources/images/images/news/HK_NewsIndex/banner.jpg" alt="">
        </div>
        <div class="container mt-30 pl-0 pr-0 clear bg-f5f5f5 pt-30 pb-70 mb-60">
            <%@ include file="./comm/menu.jsp" %>
            <div class="clear col-sm-9 pr-30 pl-0">
                <div class="clear bg-white pb-280 pl-50 pr-50">
                    <p class="pt-40-20-ipad f-50-40-ipad col-757575 line-h-70-50-ipad pb-20">
                        订单详情
                    </p>
                    <div class="clear full-w">
                        <div class="clear pull-left f-20-14-ipad col-333 h-30 line-h-30 mb-10">
                            订单号：${order.order_no }
                        </div>
                        <div class="clear pull-right h-30 line-h-30 mb-10 ">
                        	<c:if test="${order.effective_statu==1 && order.tra_status==10}">
                            <button onclick="window.location.href='<%=request.getContextPath() %>/l/order_close?order_no=${order.order_no}'" class="h-30 line-h-30 f-14 col-757575 bg-white w-110 text-center bor bor-col-ccc hovbg-757575 hovecol-white mr-20">
                                	取消订单
                            </button>
                            <button onclick="window.location.href='<%=request.getContextPath() %>/l/order_pay?order_no=${order.order_no}'" class="h-30 line-h-30 f-14 bor-none col-white bg-309DE2 w-110 text-center hovbg-2D90CF">
                                	立即支付
                            </button>
                            </c:if>
                        </div>
                    </div>
                    <div class="clear bor bor-b bor-col-f5f5f5">
                    </div>
                    <!-- 在这里判断状态，根据值来判断要显示的内容 -->
                    <!-- 10下单，20已付款，21正在配货，22已出库，30交易成功，40已退款，50已关闭 -->
                    <input class="order-stateinputval" type="hidden" value="${order.tra_status}">
                    <div class="clear order-statev1 dis-n">
                    	
                        <div class="clear pt-20 pb-20">
							<c:if test="${order.effective_statu==1 && order.tra_status==10}">
	                            <p class="col-309DE2 f-20 line-h-25">
	                            	    等待付款
	                            </p>
	                            <p class="col-309DE2 f-14 line-h-20 pt-10">
	                                	${time }后订单将被关闭
	                            </p>
                            </c:if>
                        </div>
                        <div class="clear mt-5 mb-5 radius-13 bg-eee h-25 line-h-25 cur-d">
                            <div class="clear w-20s bg-83c441 radius-13 text-center col-white pull-left">下单</div>
                            <div class="clear w-20s text-center col-424242 pull-left">付款</div>
                            <div class="clear w-20s text-center col-424242 pull-left">配货</div>
                            <div class="clear w-20s text-center col-424242 pull-left">出库</div>
                            <div class="clear w-20s text-center col-424242 pull-left">交易成功</div>
                        </div>
                    </div>
                    <div class="clear order-statev2 dis-n">
                        <div class="clear pt-20 pb-20">
                            <p class="col-b0b0b0 f-20 line-h-25">
                                已付款
                            </p>
                        </div>
                        <div class="clear mt-5 mb-5 radius-13 bg-eee h-25 line-h-25 cur-d">
                            <div class="clear w-20s bg-83c441 radius-13l text-center col-white pull-left bor bor-r bor-col-ccc">下单</div>
                            <div class="clear w-20s bg-83c441 radius-13r text-center col-white pull-left">付款</div>
                            <div class="clear w-20s text-center col-424242 pull-left">配货</div>
                            <div class="clear w-20s text-center col-424242 pull-left">出库</div>
                            <div class="clear w-20s text-center col-424242 pull-left">交易成功</div>
                        </div>
                    </div>
                    <div class="clear order-statev3 dis-n">
                        <div class="clear pt-20 pb-20">
                            <p class="col-b0b0b0 f-20 line-h-25">
                                正在配货
                            </p>
                        </div>
                        <div class="clear mt-5 mb-5 radius-13 bg-eee h-25 line-h-25 cur-d">
                            <div class="clear w-20s bg-83c441 radius-13l text-center col-white pull-left bor bor-r bor-col-ccc">下单</div>
                            <div class="clear w-20s bg-83c441 text-center col-white pull-left bor bor-r bor-col-ccc">付款</div>
                            <div class="clear w-20s bg-83c441 radius-13r text-center col-white pull-left">配货</div>
                            <div class="clear w-20s text-center col-424242 pull-left">出库</div>
                            <div class="clear w-20s text-center col-424242 pull-left">交易成功</div>
                        </div>
                    </div>
                    <div class="clear order-statev4 dis-n">
                        <div class="clear pt-20 pb-20">
                            <p class="col-b0b0b0 f-20 line-h-25">
                                已出库
                            </p>
                        </div>
                        <div class="clear mt-5 mb-5 radius-13 bg-eee h-25 line-h-25 cur-d">
                            <div class="clear w-20s bg-83c441 radius-13l text-center col-white pull-left bor bor-r bor-col-ccc">下单</div>
                            <div class="clear w-20s bg-83c441 text-center col-white pull-left bor bor-r bor-col-ccc">付款</div>
                            <div class="clear w-20s bg-83c441 text-center col-white pull-left bor bor-r bor-col-ccc">配货</div>
                            <div class="clear w-20s bg-83c441 radius-13r text-center col-white pull-left">出库</div>
                            <div class="clear w-20s text-center col-424242 pull-left">交易成功</div>
                        </div>
                    </div>
                    <div class="clear order-statev5 dis-n">
                        <div class="clear pt-20 pb-20">
                            <p class="col-b0b0b0 f-20 line-h-25">
                                交易成功
                            </p>
                        </div>
                        <div class="clear mt-5 mb-5 radius-13 bg-eee h-25 line-h-25 cur-d">
                            <div class="clear w-20s bg-83c441 radius-13l text-center col-white pull-left bor bor-r bor-col-ccc">下单</div>
                            <div class="clear w-20s bg-83c441 text-center col-white pull-left bor bor-r bor-col-ccc">付款</div>
                            <div class="clear w-20s bg-83c441 text-center col-white pull-left bor bor-r bor-col-ccc">配货</div>
                            <div class="clear w-20s bg-83c441 text-center col-white pull-left bor bor-r bor-col-ccc">出库</div>
                            <div class="clear w-20s bg-83c441 radius-13r text-center col-white pull-left">交易成功</div>
                        </div>
                    </div>
                    <div class="clear order-statev6 dis-n">
                        <div class="clear pt-20 pb-20">
                            <p class="col-b0b0b0 f-20 line-h-25">
                                订单已退款
                            </p>
                        </div>
                        <div class="clear mt-5 mb-5 radius-13 bg-eee h-25 line-h-25 cur-d">
                            <div class="clear w-20s text-center col-424242 pull-left">下单</div>
                            <div class="clear w-20s text-center col-424242 pull-left">付款</div>
                            <div class="clear w-20s text-center col-424242 pull-left">配货</div>
                            <div class="clear w-20s text-center col-424242 pull-left">出库</div>
                            <div class="clear w-20s text-center col-424242 pull-left">交易成功</div>
                        </div>
                    </div>
                    <div class="clear order-statev7 dis-n">
                        <div class="clear pt-20 pb-20">
                            <p class="col-b0b0b0 f-20 line-h-25">
                                订单已关闭
                            </p>
                        </div>
                        <div class="clear mt-5 mb-5 radius-13 bg-eee h-25 line-h-25 cur-d">
                            <div class="clear w-20s text-center col-424242 pull-left">下单</div>
                            <div class="clear w-20s text-center col-424242 pull-left">付款</div>
                            <div class="clear w-20s text-center col-424242 pull-left">配货</div>
                            <div class="clear w-20s text-center col-424242 pull-left">出库</div>
                            <div class="clear w-20s text-center col-424242 pull-left">交易成功</div>
                        </div>
                    </div>
                    <div class="clear mt-5 mb-5 h-25 line-h-25 cur-d">
                        <div class="clear w-20s col-757575 text-center pull-left"><fmt:formatDate value="${order.start_time }" pattern="yyyy年MM月dd日 HH:mm"/></div>
                    </div>
                    <div class="clear full-w pt-20 pb-20">
                     <c:forEach items="${orderDetail }" var="orderDetail">
                        <div class="clear full-w">
                            <div class="col-sm-1 col-md-1 pl-0 pr-0 mt-15 mb-15">
                                <img class="img-60-35-ipad" src="<%=request.getContextPath() %>/resources${orderDetail.pic}" alt="">
                            </div>
                            <div class="col-sm-7 col-md-5 col-lg-4 f-14 col-333 h-60-35-ipad line-h-60-ipad mt-15 mb-15 text-line-1">
                               ${orderDetail.product_name}
                            </div>
                            <div class="col-sm-4 col-md-6 col-lg-7 f-14 col-333 h-60-35-ipad line-h-60-ipad mt-15 mb-15">
                                ${orderDetail.price } X ${orderDetail.count }
                            </div>
                            <div class="clear bor bor-b bor-col-f5f5f5 full-w">
                            </div>
                        </div>
                      </c:forEach>
                    </div>
                    <div class="clear pt-15 pb-20">
                        <p class="mb-15 f-20 col-333">
                            收货信息
                        </p>
                        <p class="f-14 col-757575 mt-20 line-h-20">
                            <span class="col-757575">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</span>
                            <span class="col-757575 ml-10">${address.name }</span>
                        </p>
                        <p class="f-14 col-757575 mt-15 line-h-20">
                            <span class="col-757575">联系电话：</span>
                            <span class="col-757575 ml-10">${address.tel }</span>
                        </p>
                        <p class="f-14 col-757575 mt-15 line-h-20 mb-30">
                            <span class="col-757575">收货地址：</span>
                            <span class="col-757575 ml-10">${address.address}</span>
                        </p>
                        <div class="clear bor bor-b bor-col-f5f5f5 full-w">
                        </div>
                    </div>
                    <c:if test="${order.pay_type!=0 }">
	                    <div class="clear pt-15 pb-20">
	                        <p class="mb-15 f-20 col-333">
	                           	 支付方式
	                        </p>
	                        <p class="f-14 col-757575 mt-20 line-h-20 mb-30">
	                            <span class="col-757575">支付方式：</span>
	                            <span class="col-757575 ml-10"><c:if test="${order.pay_type==1001?'微信支付':'支付宝支付'}"></c:if></span>
	                        </p>
	                        <div class="clear bor bor-b bor-col-f5f5f5 full-w">
	                        </div>
	                    </div>
                    </c:if>
                    <div class="clear full-w pt-20 pb-20">
                        <div class="clear">
                            <div class="col-md-10 col-sm-9 pl-0 pr-0 text-right f-14 col-757575 line-h-25">
                                商品总价：
                            </div>
                            <div class="col-md-2 col-sm-3 pl-0 pt-0 text-right f-14 col-309DE2 line-h-25">
                                ${order.price+order.reduced_price-order.post_price} 元
                            </div>
                        </div>
                        <div class="clear">
                            <div class="col-md-10 col-sm-9 pl-0 pr-0 text-right f-14 col-757575 line-h-25">
                                优惠金额：
                            </div>
                            <div class="col-md-2 col-sm-3 pl-0 pt-0 text-right f-14 col-309DE2 line-h-25">
                                -${order.reduced_price } 元
                            </div>
                        </div>
                        <div class="clear">
                            <div class="col-md-10 col-sm-9 pl-0 pr-0 text-right f-14 col-757575 line-h-25">
                                运费：
                            </div>
                            <div class="col-md-2 col-sm-3 pl-0 pt-0 text-right f-14 col-309DE2 line-h-25">
                                ${order.post_price } 元
                            </div>
                        </div>
                        <div class="clear pt-10 pb-10">
                            <div class="col-md-10 col-sm-9 pl-0 pr-0 text-right f-14 col-757575 line-h-25">
                                实付金额：
                            </div>
                            <div class="col-md-2 col-sm-3 pl-0 pt-0 text-right f-14 col-309DE2 line-h-25">
                                <span class="f-22 mr-5 col-309DE2">${order.price }</span>元
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
    <%@ include file="../comm/footer.jsp" %> 
	
	<script src="<%=request.getContextPath() %>/resources/js/comm/jquery.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/ctrl/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/comm/base.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/user/HK_OrderDetails.js"></script>
</body>

</html>