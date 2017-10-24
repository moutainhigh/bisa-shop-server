<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ page import="com.bisa.health.model.SystemContext" %>
<%@ include file="../comm/tag.jsp" %>
<%  String menuType="active_list"; %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
    <title>碧沙康健_服务管理</title>
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
                    <span class="col-252525 t-nonehove">服务管理</span>
                </p>
            </div>
        </div>
        <div class="clear full-w">
            <img class="full-w" src="<%=request.getContextPath() %>/resources/img/news/HK_NewsIndex/banner.jpg" alt="">
        </div>
        <div class="container pl-0 pr-0 mt-30 clear bg-f5f5f5 pt-30 pb-70 mb-60">
            <%@ include file="../user/comm/menu.jsp" %>
            <div class="clear col-sm-9 pr-30 pl-0">
                <div class="clear bg-white pb-280 plr-50-10-ipad">
                    <p class="pt-40-20-ipad f-50-40-ipad col-757575 line-h-70-50-ipad pb-20">
                      	  服务管理
                      	 <span class="clear pull-right dis-ib f-14 col-757575 pl-20 pr-20 h-30 line-h-30 bor bor-col-ccc cur-p mt-20">
                          		 <a href="<%=request.getContextPath()%>/a/active_service"> 激活码激活 </a>
                         </span>
                    </p>
                    <div class="clear bor bor-b bor-col-f5f5f5">
                    </div>
                    <!-- 状态一 -->
                    
                    <c:forEach items="${pager.datas }" var="activeList">
                    
                     <div class="clear">
                        <div class="clear mt-40">
                            <p class="h-50 line-h-50 ${activeList.active_statu==1?'bg-76bd27 f-16 col-white':'bor bor-col-b0b0b0 f-16 col-333' } pl-30 pr-30">
                               		${activeList.service_name }
                            </p>
                        </div>
                        <div class="clear bor bor-t-none bor-col-76bd27">
                            <div class="clear col-sm-2 pt-30 pb-30 pl-15 pr-15 text-center">
                                <img class="" src="<%=request.getContextPath() %>/resources/images/user/Appraise/appraise-portraitv1.png" alt="">
                            </div>
                            <div class="clear col-sm-5 pt-30 pb-10">
                                <p class="f-16 col-333 line-h-20">
                                  	  绑定帐号：
                                </p>
                                <p class="f-14 col-757575 line-h-20">
                                   	 未绑定
                                </p>
                                <p class="mt-15 f-16 col-333 line-h-20">
                                   	 服务状态：
                                </p>
                                <p class="f-14 col-757575 line-h-20">
                                  	 ${activeList.active_statu==1?"未激活":"已激活"}
                                </p>
                            </div>
                            <div class="clear col-sm-5 pt-30 pb-10">
                                <p class="f-16 col-333 line-h-20">
                                   	 有效期：
                                </p>
                               
                                <p class="f-14 col-757575 line-h-20">
                                  	  激活后生效（请在  <fmt:formatDate value="${activeList.active_time}" pattern="yyyy年MM月dd日"/>前激活）
                                </p>
                                <p class="mt-15 f-16 col-333 line-h-20">
                                   	 次数：
                                </p>
                                <p class="f-14 col-757575 line-h-20">
                                   ${activeList.service_number}次
                                </p>
                            </div>
                            <div class="col-sm-12">
                                <div class="col-sm-10 col-sm-offset-2 pl-0 pr-40">
                                    <div class="clear bor bor-t bor-col-ccc pt-20 pb-20">
                                        <p class="clear line-h-30">
                                            <span class="f-16 col-333">
                                               	 激活码：
                                            </span>
                                            <span class="f-14 col-333">
                                                ${activeList.active_code}
                                            </span>
                                            <c:if test="${activeList.active_statu==1}">
                                            <button class="pull-right h-30 line-h-30 pl-30 pr-30 bor-none bg-76bd27 hovebg-89D92E col-white ml-10" onclick="window.location.href='<%=request.getContextPath()%>/a/active_service?active_code=${activeList.active_code}'">
                                               	 激活服务
                                            </button>
                                            </c:if>
                                            <a class="pull-right f-12 col-757575 hovcol-76bd27 t-nonehove" href="#">
                                               	 了解 悉心铃服务 更多细节
                                            </a>
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    </c:forEach>
                    <div class="clear full-w text-center f-16 col-333 mt-20">
                            <jsp:include page="../comm/pager.jsp">
        						<jsp:param name="url" value="a/active_list"/>
        						<jsp:param name="totalRecord" value="${pager.total}"/>
					       </jsp:include>
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
	
</body>

</html>