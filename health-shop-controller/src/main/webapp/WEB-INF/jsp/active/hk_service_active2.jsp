<%@ page language="java"  pageEncoding="utf-8"%>
<%@ include file="../comm/tag.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
	<base href="<%=basePath%>">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- necessary -->
    <meta name="keywords" content="1,2,3">
    <meta name="description" content="">
    <!-- description -->
    <meta name="renderer" content="webkit">
    <title>碧沙康健_激活服务</title>
    <!-- base -->
    <link href="<%=request.getContextPath() %>/resources/ctrl/Font-Awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/ctrl/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/ctrl/icheck/flat/blue.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/comm/base.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/user/HK_Order.css" rel="stylesheet">
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    
    <style>
    label.error {
        display: block;
        margin: 5px 5px;
        float: left;
        color: #c00;
    }
    </style>
</head>

<body>
   <%@ include file="../comm/header.jsp" %>
    <div class="wrap clear bg-f5f5f5">
        <div class="clear full-w bg-white">
            <div class="container pl-0 pr-0">
                <div class="clear">
                    <p class="pt-10 pb-10 pl-15 pr-15 line-h-20 cur-d ">
                        <a class="col-666 t-nonehove hovecol-309DE2" href="">首页 </a> >
                        <span class="col-252525 t-nonehove">激活服务</span>
                    </p>
                </div>
            </div>
        </div>
        <div class="clear full-w">
            <img class="full-w" src="<%=request.getContextPath() %>/resources/img/news/HK_NewsIndex/banner.jpg" alt="">
        </div>
        <div class="clear full-w">
            <div class="container clear pt-30 pb-70 mt-30 mb-60">
                <div class="col-sm-8 pl-20 pr-15">
                    <div class="clear bg-white pd-20 min-h-400">
                        <p class="pb-30 f-26 col-757575">
                            服务激活
                        </p>
                        <div class="claer bor bor-t bor-col-e0e0e0 pd-30-10-ipad">
                            <p class="f-20 col-666">
                                请输入需要激活服务的悉心APP帐号（手机号、邮箱、微信ID）
                            </p>
                            <form class="servicact-validate clear" action="">
                                <div class="clear full-w">
                                    <div class="clear col-sm-6 plr-15-5-ipad">
                                        <input type="hidden" name="appcode" value="${active_code}" >
                                        <input type="text" class="form-control mt-20 radius-0 activate-cid" name="appid" placeholder="请输入悉心APP帐号">
                                        <input type="text" class="form-control mt-20 radius-0 activate-cidagain" name="appidagain" placeholder="再次输入悉心APP帐号">
                                    </div>
                                    <div class="clear col-sm-6 plr-15-5-ipad">
                                        <p class="mt-30">
                                            <input type="hidden" class="sql-activatg-cid" value="${user }">
                                            <input class="activatecheckv1" type="checkbox">
                                            <span class="col-757575 f-16 ml-10 pos-r t-2">为当前登录帐号激活服务</span>
                                        </p>
                                    </div>
                                </div>
                                <div class="clear col-sm-12 mt-40 plr-15-5-ipad">
                                    <button class="bor-none pl-40 pr-40 col-white bg-309DE2 hovbg-2D90CF h-35 line-h-35" type="submit">确认激活</button>
                                    <p class="col-666 f-14 line-h-20 mt-10">
                                        注：微信帐号请输入APP个人中心的帐号ID。
                                    </p>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-sm-4 pl-15 pr-20">
                    <div class="clear bg-white min-h-400 pd-50-10-ipad">
                        <img src="<%=request.getContextPath() %>/resources/img/user/Service/service-prov2.png" alt="">
                        <p class="col-666 f-20 line-h-25">
                            ${serviceName}
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="../comm/footer.jsp" %> 
    <script src="<%=request.getContextPath() %>/resources/js/comm/jquery.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/comm/jquery.validate.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/comm/jquery.validate.messages_zh.js"></script>
    <script src="<%=request.getContextPath() %>/resources/ctrl/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/ctrl/icheck/icheck.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/comm/base.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/user/HK_Service.js"></script>

</body>

</html>