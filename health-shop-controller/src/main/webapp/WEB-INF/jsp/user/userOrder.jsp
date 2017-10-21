  <%@ page language="java" import="java.util.*"  pageEncoding="UTF-8"%>
<%@ page import="com.bisa.health.model.SystemContext"%>
<%@ include file="../comm/tag.jsp" %>

<% String menuType = "userOrder";  %>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
	<base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- necessary -->
    <meta name="keywords" content="1,2,3">
    <meta name="description" content="">
    <!-- description -->
    <meta name="renderer" content="webkit">
    <title>碧沙康健_订单中心页</title>
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
            <img class="full-w" src="<%=request.getContextPath() %>/resources/img/news/HK_NewsIndex/banner.jpg" alt="">
        </div>
        <div class="container pl-0 pr-0 mt-30 clear bg-f5f5f5 pt-30 pb-70 mb-60">
            <%@ include file="./comm/menu.jsp" %>
            <div class="clear col-sm-9 pr-30 pl-0">
                <div class="clear bg-white pb-280 plr-50-10-ipad">
                    <p class="pt-40-20-ipad f-50-40-ipad col-757575 line-h-70-50-ipad pb-20">
                        我的订单
                    </p>
                    <div class="clear bor bor-b bor-col-f5f5f5">
                    </div>
                    <div class="clear mt-40-20-ipad f-20-14-ipad mb-30-20-ipad line-h-25">
                        <span class="col-333  col-active cur-p Order-control Order-controlv1" onclick="document.location='<%=request.getContextPath() %>/user/userOrder';">全部有效订单</span>
                        <span class="col-e9e9e9 mlr-20-10-ipad cur-d">|</span>
                        <span class="col-333  cur-p Order-control Order-controlv2" onclick="document.location='<%=request.getContextPath() %>/user/userOrder1';">待支付（${oListnum1 }）
                        </span>
                        <span class="col-e9e9e9 mlr-20-10-ipad cur-d">|</span>
                        <span class="col-333 cur-p Order-control Order-controlv3" onclick="document.location='<%=request.getContextPath() %>/user/userOrder2';">待收货（${oListnum2 }）</span>
                        <span class="col-e9e9e9 mlr-20-10-ipad cur-d">|</span>
                        <span class="col-333 cur-p Order-control Order-controlv4" onclick="document.location='<%=request.getContextPath() %>/user/userOrder3';">已关闭（${oListnum3}）</span>
                    </div>
                    <div class="clear Order-tabtips Order-tabtipsv1">
                        <!--等待支付前-->
                        <c:forEach var="orderList" items="${orderList.datas}">
                            <c:if test="${orderList.tra_status==10}">
                                <div class="clear full-w bor bor-col-67b7ea min-h-200 mb-25">
                                    <div class="clear full-w bg-deeffa min-h-88 bor bor-b bor-col-67b7ea pt-15 pb-10 plr-20-5-ipad">
                                        <p class="pt-5">
                                            <span class="col-309DE2 f-20">等待付款</span>
                                        </p>
                                        <ul class="clear h-35 pos-r cur-d">
                                            <li class="col-757575 f-12 pull-left mt-17">
                                                <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${orderList.start_time}"/>
                                            </li>
                                            <li class="col-e9e9e9 ml-5 mr-5 cur-d f-12 pull-left mt-17">|</li>
                                            <li class="col-757575 f-12 pull-left mt-17">订单号:${orderList.order_no}</li>
                                            <li class="col-e9e9e9 ml-5 mr-5 cur-d f-12 pull-left mt-17">|</li>
                                            <li class="col-757575 f-12 pull-left mt-17">
                                                <c:if test="${orderList.pay_type==1001}">微信支付</c:if>
                                                <c:if test="${orderList.pay_type==1002}">支付宝支付</c:if>
                                            </li>
                                            <li class="col-757575 f-12 pull-right mt-17">元</li>
                                            <li class="col-333 f-22-14-ipad pull-right mt-10-17-ipad mr-5 ml-5">${orderList.price}</li>
                                            <li class="col-757575 f-12 pull-right mt-17">订单金额：</li>
                                        </ul>
                                    </div>
                                    <c:forEach var="list" items="${listordertails}">
                                        <c:if test="${list.key eq orderList.order_no}">
                                            <c:forEach var="listordertails" items="${list.value }" varStatus="status">
                                                <div class="clear pt-15 pb-15 plr-20-5-ipad">
                                                    <div class="clear pull-left">
                                                        <div class="clear pull-left">
                                                            <img class="img-80 cur-p" src="<%=request.getContextPath() %>/resources/${listordertails.pic}" alt="">
                                                        </div>
                                                        <div class="clear pull-left cur-d">
                                                            <p class="pt-15 line-h-25 col-333 f-14">
                                                                ${listordertails.product_name}
                                                            </p>
                                                            <p class="pb-15 line-h-25 col-333 f-14">
                                                                ${listordertails.price}元 × ${listordertails.count}
                                                            </p>
                                                        </div>
                                                    </div>
                                             
                                                    <div class="clear pull-right">
                                                    <c:if test="${status.first==true }">
                                                     <div class="clear h-40 pb-10">
                                                         <button class="h-30 line-h-30 f-14 bor-none col-white bg-309DE2 w-110 text-center hovbg-2D90CF" onclick="window.location.href='<%=request.getContextPath() %>/a/order_pay?order_no=${orderList.order_no}'">
                                                             立即支付
                                                         </button>
                                                     </div>
                                                     <div class="clear h-40 pt-10">
                                                         <button class="h-30 line-h-30 f-14 col-757575 bg-white w-110 text-center bor bor-col-ccc hovbg-757575 hovecol-white" onclick="window.location.href='<%=request.getContextPath() %>/user/order_detail?order_no=${orderList.order_no}'">
                                                             订单详情
                                                         </button>
                                                     </div>   
                                                 	</c:if>
                                                 </div> 
                                                </div>
                                            </c:forEach>
                                        </c:if>
                                    </c:forEach>    
                                </div>
                            </c:if>
                        </c:forEach>
                        <!--等待支付后-->
                        <!--待收货前-->
                         <c:forEach var="orderList" items="${orderList.datas}">
                            <c:if test="${orderList.tra_status==20 ||orderList.tra_status==21 ||orderList.tra_status==22 }">
                                <div class="clear full-w bor bor-col-ccc min-h-200 mb-25">
                                    <div class="clear full-w min-h-88 bor bor-b bor-col-ccc pt-15 pb-10 plr-20-5-ipad">
                                        <p class="pt-5">
                                            <span class="col-757575 f-20">待收货</span>
                                        </p>
                                        <ul class="clear h-35 pos-r cur-d">
                                            <li class="col-757575 f-12 pull-left mt-17" ><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"  value="${orderList.start_time}"/></li>
                                            <li class="col-e9e9e9 ml-5 mr-5 cur-d f-12 pull-left mt-17">|</li>
                                            <li class="col-757575 f-12 pull-left mt-17">订单号:${orderList.order_no}</li>
                                            <li class="col-e9e9e9 ml-5 mr-5 cur-d f-12 pull-left mt-17">|</li>
                                            <li class="col-757575 f-12 pull-left mt-17">
                                                <c:if test="${orderList.pay_type==1001}">微信支付</c:if>
                                                <c:if test="${orderList.pay_type==1002}">支付宝支付</c:if>
                                            </li>
                                            <li class="col-757575 f-12 pull-right mt-17">元</li>
                                            <li class="col-333 f-22-14-ipad pull-right mt-10-17-ipad mr-5 ml-5">${orderList.price}</li>
                                            <li class="col-757575 f-12 pull-right mt-17">订单金额：</li>
                                        </ul>
                                    </div>
                                    <c:forEach var="list" items="${listordertails}">
                                            <c:if test="${list.key eq orderList.order_no}">
                                                <c:forEach var="listordertails" items="${list.value }" varStatus="status">
                                                    <div class="clear pt-15 pb-15 plr-20-5-ipad">
                                                        <div class="clear pull-left">
                                                            <div class="clear pull-left">
                                                                <img class="img-80 cur-p" src="<%=request.getContextPath() %>/resources/${listordertails.pic}" alt="">
                                                            </div>
                                                            <div class="clear pull-left cur-d">
                                                                <p class="pt-15 line-h-25 col-333 f-14">
                                                                    ${listordertails.product_name}
                                                                </p>
                                                                <p class="pb-15 line-h-25 col-333 f-14">
                                                                    ${listordertails.price}元 × ${listordertails.count}
                                                                </p>
                                                            </div>
                                                        </div>
                                                        <div class="clear pull-right">
                                                            <c:if test="${status.first==true }">
                                                                <div class="clear h-40 pb-10">
                                                                    <button class="h-30 line-h-30 f-14 col-757575 bg-white w-110 text-center bor bor-col-ccc hovbg-757575 hovecol-white"onclick="window.location.href='<%=request.getContextPath() %>/user/order_detail?order_no=${orderList.order_no}'">
                                                                        订单详情
                                                                    </button>
                                                                </div>
                                                            </c:if>
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </c:if>
                                    </c:forEach>  
                                </div>
                            </c:if> 
                        </c:forEach>
                        <!--待收货后--> 
                        <!--已关闭前-->
                        <c:forEach var="orderList" items="${orderList.datas}">
                            <c:if test="${orderList.tra_status==50}">
                                <div class="clear full-w bor bor-col-ccc min-h-200 mb-25">
                                    <div class="clear full-w min-h-88 bor bor-b bor-col-ccc pt-15 pb-10 plr-20-5-ipad">
                                        <p class="pt-5">
                                            <span class="col-757575 f-20">已关闭</span>
                                        </p>
                                        <ul class="clear h-35 pos-r cur-d">
                                            <li class="col-757575 f-12 pull-left mt-17" ><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" 
                                                value="${orderList.start_time}"/></li>
                                            <li class="col-e9e9e9 ml-5 mr-5 cur-d f-12 pull-left mt-17">|</li>
                                            <li class="col-757575 f-12 pull-left mt-17">订单号:${orderList.order_no}</li>
                                            <li class="col-e9e9e9 ml-5 mr-5 cur-d f-12 pull-left mt-17">|</li>
                                            <li class="col-757575 f-12 pull-left mt-17">
                                                 <c:if test="${orderList.pay_type==1001}">微信支付</c:if>
                                                 <c:if test="${orderList.pay_type==1002}">支付宝支付</c:if>
                                            </li>
                                            <li class="col-757575 f-12 pull-right mt-17">元</li>
                                            <li class="col-333 f-22-14-ipad pull-right mt-10-17-ipad mr-5 ml-5">${orderList.price}</li>
                                            <li class="col-757575 f-12 pull-right mt-17">订单金额：</li>
                                        </ul>
                                    </div>
                                    <c:forEach var="list" items="${listordertails}">
                                        <c:if test="${list.key eq orderList.order_no}">
                                            <c:forEach var="listordertails" items="${list.value }" varStatus="status">
                                                <div class="clear pt-15 pb-15 plr-20-5-ipad">
                                                    <div class="clear pull-left">
                                                        <div class="clear pull-left">
                                                            <img class="img-80 cur-p" src="<%=request.getContextPath() %>/resources/${listordertails.pic}" alt="">
                                                        </div>
                                                        <div class="clear pull-left cur-d">
                                                            <p class="pt-15 line-h-25 col-333 f-14">
                                                                ${listordertails.product_name}
                                                            </p>
                                                            <p class="pb-15 line-h-25 col-333 f-14">
                                                                ${listordertails.price}元 × ${listordertails.count}
                                                            
                                                            </p>
                                                        </div>
                                                    </div>
                                                    <div class="clear pull-right">
                                                        <c:if test="${status.first==true }">
                                                            <div class="clear h-40 pb-10">
                                                                <button class="h-30 line-h-30 f-14 col-757575 bg-white w-110 text-center bor bor-col-ccc hovbg-757575 hovecol-white" onclick="window.location.href='<%=request.getContextPath() %>/user/order_detail?order_no=${orderList.order_no}'">
                                                                    订单详情
                                                                </button>
                                                            </div>
                                                        </c:if>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </c:if>
                                    </c:forEach>
                                </div>
                            </c:if>
                        </c:forEach>   
                        <!--已关闭后-->
                        <div class="clear text-center col-333 f-14">
                            <script type="text/javascript" scr="<%=request.getContextPath()%>/resources/js/pager/pager-taglib.js"></script> 
                            <jsp:include page="../comm/pager.jsp">
                                <jsp:param name="url" value="user/userOrder"/>
                                <jsp:param name="items" value="${orderList.total}"/>
                            </jsp:include> 
                        </div>
                    </div>
                  
                     <!--等待付款页面-->
                    <div class="clear Order-tabtips Order-tabtipsv2 dis-n">
                        <c:forEach var="orderList5" items="${orderList5.datas}">
                            <c:if test="${orderList5.tra_status==10 }">
                                <div class="clear full-w bor bor-col-67b7ea min-h-200 mb-25">
                                    <div class="clear full-w bg-deeffa min-h-88 bor bor-b bor-col-67b7ea pt-15 pb-10 plr-20-5-ipad">
                                        <p class="pt-5">
                                            <span class="col-309DE2 f-20">等待付款</span>
                                        </p>
                                        <ul class="clear h-35 pos-r cur-d">
                                            <li class="col-757575 f-12 pull-left mt-17">
                                                <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${orderList5.start_time}"/>
                                            </li>
                                            <li class="col-e9e9e9 ml-5 mr-5 cur-d f-12 pull-left mt-17">|</li>
                                            <li class="col-757575 f-12 pull-left mt-17">订单号:${orderList5.order_no}</li>
                                            <li class="col-e9e9e9 ml-5 mr-5 cur-d f-12 pull-left mt-17">|</li>
                                            <li class="col-757575 f-12 pull-left mt-17">
                                                <c:if test="${orderList5.pay_type==1001}">微信支付</c:if>
                                                <c:if test="${orderList5.pay_type==1002}">支付宝支付</c:if>
                                            </li>
                                            <li class="col-757575 f-12 pull-right mt-17">元</li>
                                            <li class="col-333 f-22-14-ipad pull-right mt-10-17-ipad mr-5 ml-5">${orderList5.price}</li>
                                            <li class="col-757575 f-12 pull-right mt-17">订单金额：</li>
                                        </ul>
                                    </div>
                                    <c:forEach var="list" items="${listordertails}">
                                        <c:if test="${list.key eq orderList5.order_no}">
                                            <c:forEach var="listordertails" items="${list.value }" varStatus="status">
                                                    <div class="clear pt-15 pb-15 plr-20-5-ipad">
                                                        <div class="clear pull-left">
                                                            <div class="clear pull-left">
                                                                <img class="img-80 cur-p" src="<%=request.getContextPath() %>/resources/${listordertails.pic}" alt="">
                                                            </div>
                                                            <div class="clear pull-left cur-d">
                                                                <p class="pt-15 line-h-25 col-333 f-14">
                                                                   ${listordertails.product_name}
                                                                </p>
                                                                <p class="pb-15 line-h-25 col-333 f-14">
                                                                   ${listordertails.price}元 × ${listordertails.count}
                                                                </p>
                                                            </div>
                                                        </div>
                                                        <div class="clear pull-right">
                                                            <c:if test="${status.first==true }">
                                                                <div class="clear h-40 pb-10">
                                                                    <button class="h-30 line-h-30 f-14 bor-none col-white bg-309DE2 w-110 text-center hovbg-2D90CF" onclick="window.location.href='<%=request.getContextPath() %>/a/order_pay?order_no=${orderList5.order_no}'">
                                                                        立即支付
                                                                    </button>
                                                                </div>
                                                                <div class="clear h-40 pt-10">
                                                                    <button class="h-30 line-h-30 f-14 col-757575 bg-white w-110 text-center bor bor-col-ccc hovbg-757575 hovecol-white" onclick="window.location.href='<%=request.getContextPath() %>/user/order_detail?order_no=${orderList5.order_no}'">
                                                                        订单详情
                                                                    </button>
                                                                </div>
                                                            </c:if>
                                                        </div>
                                                    </div>
                                            </c:forEach>
                                        </c:if>
                                    </c:forEach>    
                                </div>
                            </c:if>
                        </c:forEach>
                        <div class="clear text-center col-333 f-14">
                           <script type="text/javascript" scr="<%=request.getContextPath()%>/resources/js/pager/pager-taglib.js"></script> 
                         	<jsp:include page="../comm/pager.jsp">
                                <jsp:param name="url" value="user/userOrder1"/>
                                <jsp:param name="items" value="${orderList5.total}"/>
                            </jsp:include> 
                        </div>
                    </div>
                    
                    <!--待收货页面前-->
                    <div class="clear Order-tabtips Order-tabtipsv3 dis-n">
                    	<c:forEach var="orderList3" items="${orderList3.datas}">
                            <c:if test="${orderList3.tra_status ==20|| orderList3.tra_status==21||orderList3.tra_status ==22}">
                                <div class="clear full-w bor bor-col-ccc min-h-200 mb-25">
                                    <div class="clear full-w min-h-88 bor bor-b bor-col-ccc pt-15 pb-10 plr-20-5-ipad">
                                        <p class="pt-5">
                                            <span class="col-757575 f-20">待收货</span>
                                        </p>
                                        <ul class="clear h-35 pos-r cur-d">
                                            <li class="col-757575 f-12 pull-left mt-17" ><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${orderList3.start_time}"/></li>
                                            <li class="col-e9e9e9 ml-5 mr-5 cur-d f-12 pull-left mt-17">|</li>
                                            <li class="col-757575 f-12 pull-left mt-17">订单号:${orderList3.order_no}</li>
                                            <li class="col-e9e9e9 ml-5 mr-5 cur-d f-12 pull-left mt-17">|</li>
                                            <li class="col-757575 f-12 pull-left mt-17">
                                                 <c:if test="${orderList3.pay_type==1001}">微信支付</c:if>
                                                 <c:if test="${orderList3.pay_type==1002}">支付宝支付</c:if>
                                            </li>
                                            <li class="col-757575 f-12 pull-right mt-17">元</li>
                                            <li class="col-333 f-22-14-ipad pull-right mt-10-17-ipad mr-5 ml-5">${orderList3.price}</li>
                                            <li class="col-757575 f-12 pull-right mt-17">订单金额：</li>
                                        </ul>
                                    </div>
                                    <c:forEach var="list" items="${listordertails}">
                                        <c:if test="${list.key eq orderList3.order_no}">
                                            <c:forEach var="listordertails" items="${list.value }" varStatus="status">    
                                                <div class="clear pt-15 pb-15 plr-20-5-ipad">
                                                    <div class="clear pull-left">
                                                        <div class="clear pull-left">
                                                            <img class="img-80 cur-p" src="<%=request.getContextPath() %>/resources/${listordertails.pic}" alt="">
                                                        </div>
                                                        <div class="clear pull-left cur-d">
                                                            <p class="pt-15 line-h-25 col-333 f-14">
                                                               ${listordertails.product_name}
                                                            </p>
                                                            <p class="pb-15 line-h-25 col-333 f-14">
                                                                 ${listordertails.price}元 × ${listordertails.count}
                                                            </p>
                                                        </div>
                                                    </div>
                                                    <div class="clear pull-right">
                                                        <c:if test="${status.first==true }">
                                                            <div class="clear h-40 pb-10">
                                                                <button class="h-30 line-h-30 f-14 col-757575 bg-white w-110 text-center bor bor-col-ccc hovbg-757575 hovecol-white" onclick="window.location.href='<%=request.getContextPath() %>/user/order_detail?order_no=${orderList3.order_no}'">
                                                                    订单详情
                                                                </button>
                                                            </div>
                                                        </c:if>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </c:if>
                                    </c:forEach>  
                                </div>
                            </c:if> 
                        </c:forEach>
                     <!--待收货后--> 
                        <div class="clear text-center col-333 f-14">
                            <script type="text/javascript" scr="<%=request.getContextPath()%>/resources/js/pager/pager-taglib.js"></script> 
                            <jsp:include page="../comm/pager.jsp">
                                <jsp:param name="url" value="user/userOrder2"/>
                                <jsp:param name="items" value="${orderList3.total}"/>
                            </jsp:include> 
                        </div>
                    </div>
                    <!--已关闭页面--> 
                    <div class="clear Order-tabtips Order-tabtipsv4 dis-n">
                        <c:forEach var="orderList4" items="${orderList4.datas}">
                            <c:if test="${orderList4.tra_status==50}">
                                <div class="clear full-w bor bor-col-ccc min-h-200 mb-25">
                                    <div class="clear full-w min-h-88 bor bor-b bor-col-ccc pt-15 pb-10 plr-20-5-ipad">
                                        <p class="pt-5">
                                            <span class="col-757575 f-20">已关闭</span>
                                        </p>
                                        <ul class="clear h-35 pos-r cur-d">
                                            <li class="col-757575 f-12 pull-left mt-17">
                                                <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${orderList4.start_time}"/>
                                            </li>
                                            <li class="col-e9e9e9 ml-5 mr-5 cur-d f-12 pull-left mt-17">|</li>
                                            <li class="col-757575 f-12 pull-left mt-17">订单号:${orderList4.order_no}</li>
                                            <li class="col-e9e9e9 ml-5 mr-5 cur-d f-12 pull-left mt-17">|</li>
                                            <li class="col-757575 f-12 pull-left mt-17">
                                                 <c:if test="${orderList4.pay_type==1001}">微信支付</c:if>
                                                 <c:if test="${orderList4.pay_type==1002}">支付宝支付</c:if>
                                            </li>
                                            <li class="col-757575 f-12 pull-right mt-17">元</li>
                                            <li class="col-333 f-22-14-ipad pull-right mt-10-17-ipad mr-5 ml-5">${orderList4.price}</li>
                                            <li class="col-757575 f-12 pull-right mt-17">订单金额：</li>
                                        </ul>
                                    </div>
                                    <c:forEach var="list" items="${listordertails}">
                                        <c:if test="${list.key eq orderList4.order_no}">
                                            <c:forEach var="listordertails" items="${list.value }" varStatus="status">
                                                <div class="clear pt-15 pb-15 plr-20-5-ipad">
                                                    <div class="clear pull-left">
                                                        <div class="clear pull-left">
                                                            <img class="img-80 cur-p" src="<%=request.getContextPath() %>/resources/${listordertails.pic}" alt="">
                                                        </div>
                                                        <div class="clear pull-left cur-d">
                                                            <p class="pt-15 line-h-25 col-333 f-14">
                                                                ${listordertails.product_name}
                                                            </p>
                                                            <p class="pb-15 line-h-25 col-333 f-14">
                                                                ${listordertails.price}元 × ${listordertails.count}
                                                            
                                                            </p>
                                                        </div>
                                                    </div>
                                                    <div class="clear pull-right">
                                                        <c:if test="${status.first==true }">
                                                            <div class="clear h-40 pb-10">
                                                                <button class="h-30 line-h-30 f-14 col-757575 bg-white w-110 text-center bor bor-col-ccc hovbg-757575 hovecol-white" onclick="window.location.href='<%=request.getContextPath() %>/user/order_detail?order_no=${orderList4.order_no}'">
                                                                    订单详情
                                                                </button>
                                                            </div>
                                                        </c:if>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </c:if>
                                    </c:forEach>
                                </div>
                            </c:if>
                        </c:forEach>
                        <div class="clear text-center col-333 f-14">
                            <script type="text/javascript" scr="<%=request.getContextPath()%>/resources/js/pager/pager-taglib.js"></script> 
                          	<jsp:include page="../comm/pager.jsp">
                                <jsp:param name="url" value="user/userOrder3"/>
                                <jsp:param name="items" value="${orderList4.total}"/>
                            </jsp:include> 
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
    <script src="<%=request.getContextPath() %>/resources/js/user/HK_OrderCenter.js"></script>
    <script src="<%=request.getContextPath() %>/resources/wqc_js/user/comm/menu.js"></script> 
	<script src="<%=request.getContextPath() %>/resources/wqc_js/user/userOrder.js"></script> 
</body>

</html>