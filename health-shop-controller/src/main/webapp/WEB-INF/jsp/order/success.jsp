<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- necessary -->
    <meta name="keywords" content="1,2,3">
    <meta name="description" content="">
    <!-- description -->
    <meta name="renderer" content="webkit">
    <title>碧沙康健_支付成功页</title>
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
    <div class="wrap bg-white">
        <div class="container pl-0 pr-0">
            <div class="clear">
                <p class="pt-10 pb-10 pl-15 pr-15 line-h-20 bg-f5f5f5 cur-d ">
                    <a class="col-666 t-nonehove hovecol-309DE2" href="">首页 </a> >
                    <span class="col-252525 t-nonehove">购物车</span>
                </p>
                <p class="pt-10 pb-10 pl-15 pr-15 line-h-40 cur-d col-252525 family-h f-26 bg-white">
                    支付成功
                </p>
            </div>
            <div class="clear pt-20 pl-20 pr-20 bg-f5f5f5 pb-25 mb-40 full-w cur-d">
                <div class="clear bg-efffe3 pt-40 pb-50">
                    <div class="clear col-sm-5">
                        <img class="pull-right" src="<%=request.getContextPath() %>/resources/img/net_shopping/PaySuccess_side.png" alt="">
                    </div>
                    <div class="clear col-sm-7 pt-20 pl-40">
                        <p class="f-26 col-252525 mb-15">
                            订单支付成功！
                        </p>
                        <p class="f-16 col-252525 mb-15">
                            您的订单将在<span class="mr-5 ml-5 col-309DE2">24</span>小时内发货。
                        </p>
                        <p class="f-16 col-252525 mb-15">
                            订单号：${order_no}
                        </p>
                        <p class="f-16 mb-15">
                            <a class="col-309DE2 t-nonehove mr-30" href="<%=request.getContextPath()%>/user/order_detail?order_no=${order_no}">查看订单详情</a>
                            <a class="col-309DE2 t-nonehove" href="<%=request.getContextPath()%>/l/shopping">继续购物</a>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="../comm/footer.jsp" %> 
    <script src="<%=request.getContextPath() %>/resources/js/comm/jquery.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/ctrl/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/comm/swiper.jquery.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/comm/base.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/shopping/HK_PaySuccess.js"></script>
</body>

</html>