<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ page import="com.bisa.health.model.SystemContext"%>
<%@ include file="../comm/tag.jsp" %>

<!DOCTYPE html>
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
    <title>碧沙康健_评价成功</title>
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
                        <span class="col-252525 t-nonehove">评价成功</span>
                    </p>
                </div>
            </div>
            <div class="clear full-w">
                <img class="full-w" src="<%=request.getContextPath() %>/resources/img/news/HK_NewsIndex/banner.jpg" alt="">
            </div>
            <div class="container pl-30 pr-30 mt-30 clear bg-f5f5f5 pt-30 pb-70 mb-60">
                <div class="clear h-120-90-ipad bg-83c44e ptb-35-20-ipad pl-150-30-ipad pr-120-30-ipadv2 line-h-50">
                    <span class="dis-ib pull-left">
                        <img class="img-40-25-ipad" src="<%=request.getContextPath() %>/resources/img/user/Appraise/appraise-ok.png" alt="">
                    </span>
                    <span class="col-white f-30-22-ipad ml-15 dis-ib pull-left">评价发表成功啦！</span>
                    <span class="col-white f-22-16-ipad ml-30 dis-ib pull-left">你还可以</span>
                    <a class="col-ffd600 f-22-16-ipad dis-ib pull-left t-nonehove hovecol-ffd600" href="<%=request.getContextPath() %>、user/useAppraise">继续评价其他商品</a>
                    <button class="h-50-35-ipad w-200-150-ipad pull-right bor-none bg-fec517 line-h-50-35-ipad col-white f-22 hovebg-FFCE37 mt-0-7-ipad" onclick="window.location.href='<%=request.getContextPath() %>/l/index'">
                        	继续购物
                    </button>
                </div>
                <div class="clear bg-white">
                    <div class="col-sm-4 pt-100 pb-80">
                        <div class="clear text-center">
                            <img class="img-300-200-ipad min-h-300-200-ipad" src="<%=request.getContextPath() %>/resources/${appraise.main_picture}" alt="">
                            <p class="f-20 col-333 mt-30 cur-d">
                               ${appraise.title}
                            </p>
                            <p class="col-309DE2 f-20 mt-20 cur-d">
                                ${appraise.price}元
                            </p>
                        </div>
                    </div>
                    <div class="col-sm-1 pt-70 pb-30 text-center pl-0 pr-0">
                        <img class="" src="${userImg}" alt="无用户头像">
                    </div>
                    <div class="col-sm-6 pt-70 pb-30">
                        <div class="clear col-sm-9 pl-0 pr-0">
                            <p class="f-20-16-ipad col-757575 pl-15 pr-15 line-h-30">
                                ${appraise.appraise_one}
                            </p>
                        </div>
                    <div class="clear col-sm-3 pl-0 pr-0">
                        <!-- 状态码默认0超爱，1失望，2一般，3满意，4喜欢，5超爱 -->
                        <input type="hidden" class="appraisesuccess-state" value="${appraise.appraise_degree}">
                        <span class="img-20 pull-left mr-10 cur-d bg-faceauto mt-3 appraisesuccess-stateface">
                        </span>
                        <span class="f-20 col-ffd600 mt-2 pull-left cur-d mr-10 appraisesuccess-statetext">
                            <c:if test="${appraise.appraise_degree==1 }">
                               失望
                            </c:if>
                            <c:if test="${appraise.appraise_degree==2 }">
                               一般
                            </c:if>
                            <c:if test="${appraise.appraise_degree==3 }">
                              满意
                            </c:if>
                            <c:if test="${appraise.appraise_degree==4 }">
                               喜爱
                            </c:if>
                            <c:if test="${appraise.appraise_degree==5 }">
                               超爱
                            </c:if>
                        </span>
                    </div>
                    <div class="clear col-sm-12 bor bor-b bor-col-e0e0e0 mt-50">
                    </div>
                    </div>
                    <div class="col-sm-1 pt-70 pb-30 pl-0">
                        
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