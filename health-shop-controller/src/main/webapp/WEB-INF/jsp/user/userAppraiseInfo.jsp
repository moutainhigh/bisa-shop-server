<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ page import="com.bisa.health.model.SystemContext"%>
<%@ include file="../comm/tag.jsp" %>
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
    <title>碧沙康健_评价开始</title>
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
                    <a class="col-666 t-nonehove hovecol-309DE2" href="<%=request.getContextPath() %>/l/index">首页 </a> >
                    <span class="col-252525 t-nonehove">评价开始</span>
                </p>
            </div>
        </div>
        <div class="clear full-w">
            <img class="full-w" src="<%=request.getContextPath() %>/resources/img/news/HK_NewsIndex/banner.jpg" alt="">
        </div>
        <div class="container pl-30 pr-30 mt-30 clear bg-f5f5f5 pt-30 pb-70 mb-60">
            <div class="clear bg-white">
                <div class="col-sm-5 pt-100 pb-80">
                    <div class="clear text-center">
                        <img class="img-300-250-ipad min-h-300-250-ipad" src="<%=request.getContextPath() %>/resources/${od.pic}" alt="">
                        <p class="f-20 col-333 mt-30 cur-d">
                           ${od.product_name}
                        </p>
                        <p class="col-309DE2 f-20 mt-20 cur-d">
                            ${od.price}元
                        </p>
                    </div>
                </div>
                <div class="col-sm-7 pt-70 pr-120-30-ipad">
                    <div class="clear pb-30">
                        <div class="clear h-35 pt-5 pb-5 pull-left face-main-box">
                            <span class="img-25 pull-left mr-20 cur-p bg-starun star-tips star-tipsv1">
                            </span>
                            <span class="img-25 pull-left mr-20 cur-p bg-starun star-tips star-tipsv2">
                            </span>
                            <span class="img-25 pull-left mr-20 cur-p bg-starun star-tips star-tipsv3">
                            </span>
                            <span class="img-25 pull-left mr-20 cur-p bg-starun star-tips star-tipsv4">
                            </span>
                            <span class="img-25 pull-left mr-20 cur-p bg-starun star-tips star-tipsv5">
                            </span>
                            <span class="f-20 col-757575 pull-left mt-3 cur-d mr-10 face-item">
                                超爱
                            </span>
                            <span class="img-20 pull-left mr-20 cur-d bg-faceauto mt-3 face-tips">
                            </span>
                        </div>
                    </div>
                    <div class="clear">
                        <form action="">
                            <!-- 0位未评级，1位一颗星，2位两颗星，3位三颗星等 -->
                            <input class="record-face" type="hidden" value="0">
                            <textarea class="form-control f-16 full-w appraises-one" rows="10" maxlength="500" placeholder="外形如何，品质如何，好用吗，写点您真实的使用感受吧" id="appraises-one"></textarea>
                            <input type="hidden"  class="text-appraise" value="">
                            <input type="hidden"  class="text-orderguid" value="${od.order_detail_guid}">
                        </form>
                        <div class="clear pt-15 ">
                            <button class="pull-right h-30 w-110 text-center f-12 col-white bg-309DE2 hovbg-2D90CF bor-none submit-sh">
                                发表评价
                            </button>
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
    <script src="<%=request.getContextPath() %>/resources/wqc_js/user/userAppraiseInfo.js"></script> 

</body>

</html>