<%@ page language="java"  pageEncoding="UTF-8"%>
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
    <title>碧沙康健_激活成功</title>
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
    <div class="wrap clear bg-f5f5f5">
        <div class="clear full-w bg-white">
            <div class="container pl-0 pr-0">
                <div class="clear">
                    <p class="pt-10 pb-10 pl-15 pr-15 line-h-20 cur-d ">
                        <a class="col-666 t-nonehove hovecol-309DE2" href="<%=request.getContextPath() %>/l/index">首页 </a> >
                        <span class="col-252525 t-nonehove">激活服务</span>
                    </p>
                </div>
            </div>
        </div>
        <div class="clear full-w">
            <img class="full-w" src="<%=request.getContextPath() %>/resources/images/news/HK_NewsIndex/banner.jpg" alt="">
        </div>
        <div class="clear full-w">
            <div class="container clear pt-30 pb-70 mt-30 mb-60">
                <div class="col-sm-12 pl-20 pr-15">
                    <div class="clear bg-white pd-20 min-h-400">
                        <p class="pb-30 f-26 col-757575">
                            服务激活
                        </p>
                        <div class="claer bor bor-t bor-col-e0e0e0 pd-30-10-ipad">
                            <p class="mt-50 mb-50 text-center">
                                <img class="img-100 dis-ib" src="<%=request.getContextPath() %>/resources/images/user/Service/success-face.png" alt="">
                                <span class="f-40 col-757575 pos-r t-10 ml-20">
                                    服务激活成功
                                </span>
                            </p>
                            <p class="text-center">
                                <button class="bor-none pl-40 pr-40 col-white bg-309DE2 hovbg-2D90CF h-35 line-h-35" type="button" onclick="window.location.href='<%=request.getContextPath() %>/user/userOrder'">返回个人中心</button>
                            </p>
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
    <script src="<%=request.getContextPath() %>/resources/js/user/HK_Appraise.js"></script>

</body>

</html>