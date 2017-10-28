<%@ page language="java" import="java.util.*"  pageEncoding="UTF-8"%>
<%@ page import="com.bisa.health.model.SystemContext" %>
<%@ include file="../comm/tag.jsp" %>
<%  String menuType="userApprise"; %>
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
    <title>碧沙康健_商品评价页</title>
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
                    <span class="col-252525 t-nonehove">商品评价</span>
                </p>
            </div>
        </div>
        <div class="clear full-w">
            <img class="full-w" src="<%=request.getContextPath() %>/resources/img/news/HK_NewsIndex/banner.jpg" alt="">
        </div>
        <div class="container pl-0 pr-0 clear mt-30 bg-f5f5f5 pt-30 pb-70 mb-60">
            <%@ include file="./comm/menu.jsp" %>
            <div class="clear col-sm-9 pr-30 pl-0">
                <div class="clear bg-white pb-280 pl-50 pr-50">
                    <p class="pt-40-20-ipad f-50-40-ipad col-757575 line-h-70-50-ipad pb-20">
                        商品评价
                    </p>
                    <div class="clear bor bor-b bor-col-f5f5f5">
                    </div>
                    <div class="clear mt-40-20-ipad f-20-14-ipad mb-30-20-ipad line-h-25">
                       <span class="col-333 col-active cur-p Appraise-control Appraise-controlv1" onclick="document.location='<%=request.getContextPath() %>/user/userAppraise';">待评价商品</span>
                       <span class="col-e9e9e9 mlr-20-10-ipad cur-d">|</span>
                       <span class="col-333 cur-p Appraise-control Appraise-controlv2" onclick="document.location='<%=request.getContextPath() %>/user/userAppraise1';">已评价商品</span>
                       <span class="col-e9e9e9 mlr-20-10-ipad cur-d">|</span>
                       <span class="col-333 cur-p Appraise-control Appraise-controlv3" onclick="document.location='<%=request.getContextPath() %>/user/userAppraise2';">评价失效商品</span>
                    </div>
                    <div class="clear bor bor-b bor-col-f5f5f5">
                    </div>
                    <!-- 待评价商品部分 -->
                    <div class="clear Appraise-tabtips Appraise-tabtipsv1">
                        <c:forEach var="listordertails" items="${odtail.datas}">
                                <div class="clear col-sm-4 pd-20 text-center bor bor-b bor-col-f5f5f5 appraise-protips">
                                    <a href="javascript:;">
                                        <img class="img-200-100-ipad min-h-200-100-ipad" src="<%=request.getContextPath() %>/resources/${listordertails.pic}" alt="">
                                    </a>
                                    <p class="f-16-12-ipad col-333 mt-20 cur-p">
                                        ${listordertails.product_name}
                                    </p>
                                    <p class="col-309DE2 f-14-12-ipad mt-10 cur-d">
                                        ${listordertails.price}元
                                    </p>
                                    <div class="clear full-w pb-10 pt-10 min-h-40">
                                        <button class="w-70 h-20 bor-none bg-309DE2 col-white text-center hovbg-2D90CF dis-n appraise-btninto" onclick="javascript:window.location.href='<%=request.getContextPath() %>/user/goAppraise?detail_guid=${listordertails.order_detail_guid}'">
                                            去评价
                                        </button>
                                    </div>
                                </div>
                        </c:forEach>   
                    </div>
						
						
                        <!-- 循环结束，这里放分页。 -->
                        <div class="clear full-w text-center f-16 col-333 mt-20">
                            <jsp:include page="../comm/pager.jsp">
                                <jsp:param name="url" value="user/userAppraise"/>
                                <jsp:param name="items" value="${odtail.total}"/>
                            </jsp:include> 
                        </div>
                    
                    <!-- 已评价商品部分 -->
                    <div class="clear Appraise-tabtips Appraise-tabtipsv2 dis-n">
                        <div class="clear full-w">
                            <c:forEach var="odpingjia" items="${odpingjia.datas}">
                                <!-- 已评价部分的循环体和待评价部分的不同，少了评价按钮 -->
                                    <div class="clear col-sm-4 pd-20 text-center bor bor-b bor-col-f5f5f5 appraise-protips">
                                        <a href="javascript:;">
                                            <img class="img-200-100-ipad min-h-200-100-ipad" src="<%=request.getContextPath() %>/resources/${odpingjia.pic}" alt="">
                                        </a>
                                        <p class="f-16-12-ipad col-333 mt-20 cur-p">
                                             ${odpingjia.product_name}
                                        </p>
                                        <p class="col-309DE2 f-14-12-ipad mt-10 cur-d">
                                             ${odpingjia.price}元
                                        </p>
                                        <div class="clear full-w pb-10 pt-10 min-h-40">
                                            <button class="w-70 h-20 bor-none bg-309DE2 col-white text-center hovbg-2D90CF dis-n appraise-btninto" onclick="window.location.href='<%=request.getContextPath() %>/user/AppraiseSuccess?order_detail_guid=${odpingjia.order_detail_guid}'">
                                                查看评价
                                            </button>
                                        </div>
                                    </div>
                            </c:forEach> 
                        </div>   
                    </div>
                <!-- 循环结束，这里放分页。最多四行。四行之后分页。
                <div class="clear full-w text-center f-16 col-333 mt-20">-->
                    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/pager/pager-taglib.js"></script> 
                    <jsp:include page="../comm/pager.jsp">
                        <jsp:param name="url" value="user/userAppraise1"/>
                        <jsp:param name="items" value="${odpingjia.total}"/>
                    </jsp:include> 
                </div> 
            
                    <!-- 评价失效商品部分 -->
                    <div class="clear Appraise-tabtips Appraise-tabtipsv3 dis-n">
                        <div class="clear full-w">
                         <c:forEach var="odtas" items="${odtas.datas}">
                            <!-- 已评价部分的循环体和待评价部分的不同，少了评价按钮 -->
                            <div class="clear col-sm-4 pd-20 text-center bor bor-b bor-col-f5f5f5">
                                <a href="">
                                    <img class="img-200-100-ipad min-h-200-100-ipad" src="<%=request.getContextPath() %>/resources/${odtas.pic}" alt="">
                                </a>
                                <p class="f-16-12-ipad col-333 mt-20 cur-p">
                                    ${odtas.product_name}
                                </p>
                                <p class="col-309DE2 f-14-12-ipad mt-10 cur-d">
                                    ${odtas.price}元
                                </p>
                                <div class="clear full-w pb-10 pt-10 min-h-40">
                                </div>
                            </div>
                        </c:forEach>  
                        </div>
                        <!-- 循环结束，这里放分页。最多四行。四行之后分页。 
                        <div class="clear full-w text-center f-16 col-333 mt-20">-->
                            <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/pager/pager-taglib.js"></script> 
			                    <jsp:include page="../comm/pager.jsp">
			                       <jsp:param name="url" value="user/userAppraise2"/>
			                       <jsp:param name="items" value="${odtas.total}"/>
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
    <script src="<%=request.getContextPath() %>/resources/js/user/HK_Appraise.js"></script>
    <script src="<%=request.getContextPath() %>/resources/wqc_js/user/comm/menu.js"></script> 
	<script src="<%=request.getContextPath() %>/resources/wqc_js/user/useAppraiseList.js"></script> 
</body>

</html>