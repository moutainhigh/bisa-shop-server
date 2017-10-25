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
        <header class="clear full-w min-h-120 header bg-white">
            <div class="container">
                <div class="col-xs-2 pt-35 pb-35 pl-0 pr-0">
                    <img src="<%=request.getContextPath() %>/resources/img/index/logov1.png" alt="">
                </div>
                <div class="clear col-xs-10 pl-0 pr-0">
                    <div class="col-xs-12 pt-20 pl-0 pr-0">
                        <ul class="clear h-30 line-h-30 pull-right">
                            <li class="pull-left pr-10"><a class="col-333 hovecol-black" href="">注册</a></li>
                            <li class="pull-left pr-10"><a class="col-333 hovecol-black" href="">登录</a></li>
                            <li class="pull-left pr-10"><a class="col-333 hovecol-black" href="">简</a></li>
                            <li class="pull-left pr-10"><a class="col-333 hovecol-black" href="">繁</a></li>
                            <li class="pull-left pr-5 col-333 cur-d hovecol-black">
                                <i class="icon-shopping-cart pr-5 f-14 col-333 hovecol-black"></i> 购物车(
                                <a class="col-333" href="">0</a> )
                            </li>
                            <li class="pull-left pr-5 pl-5 bg-eee hovebg-ddd mainsearch">
                                <input type="text" class="h-26 line-h-26 w-100 mt--2 mb-2 bor bor-col-ccc dis-n mainsearchinput">
                                <span class="col-333 t-nonehove cur-p" href=""><i class="icon-search pr-5 f-14"></i>搜索</span>
                            </li>
                        </ul>
                    </div>
                    <div class="col-xs-12 pt-15 pl-0 pr-0">
                        <ul class="col-xs-10 clo-md-9 pull-left mainnav clear dis-ib pl-0 pr-0">
                            <li class="col-xs-2 text-center f-14 cur-p pd-10 f-w"><a class="col-309DE2 t-nonehove pb-7 " href="">首页</a></li>
                            <li class="col-xs-2 text-center f-14 cur-p pd-10 f-w"><a class="col-309DE2 t-nonehove pb-7" href="">关于碧沙</a></li>
                            <li class="col-xs-2 text-center f-14 cur-p pd-10 f-w"><a class="col-309DE2 t-nonehove pb-7 navborpitch" href="">网上商城</a></li>
                            <li class="col-xs-2 text-center f-14 cur-p pd-10 f-w"><a class="col-309DE2 t-nonehove pb-7" href="">健康咨询</a></li>
                            <li class="col-xs-2 text-center f-14 cur-p pd-10 f-w"><a class="col-309DE2 t-nonehove pb-7" href="">购物指南</a></li>
                            <li class="col-xs-2 text-center f-14 cur-p pd-10 f-w"><a class="col-309DE2 t-nonehove pb-7" href="">联系我们</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </header>
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