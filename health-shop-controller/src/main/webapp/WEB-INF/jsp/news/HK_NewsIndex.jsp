<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- necessary -->
    <meta name="keywords" content="1,2,3">
    <meta name="description" content="">
    <!-- description -->
    <meta name="renderer" content="webkit">
       <title>碧沙康健_健康咨询页</title>
    <!-- base -->
    <link href="<%=request.getContextPath() %>/resources/ctrl/Font-Awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/comm/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/comm/base.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/news/HK_News.css" rel="stylesheet">
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
      <script type="text/javascript">
			var http_request ="<%=request.getContextPath() %>";
			var request_url ="<%=request.getMethod() %>";
		</script>
</head>

<body>
  <jsp:include page="./../comm/header.jsp"/>
    <div class="wrap clear">
        <div class="container pl-0 pr-0">
            <div class="clear">
                <p class="pt-10 pb-10 pl-15 pr-15 line-h-20 cur-d ">
                    <a class="col-666 t-nonehove hovecol-309DE2" id="index" href="">首页 </a> >
                    <span class="col-252525 t-nonehove">健康咨询</span>
                </p>
            </div>
        </div>
        <div class="clear full-w">
            <img class="full-w" src="<%=request.getContextPath() %>/resources/img/news/HK_NewsIndex/banner.jpg" alt="">
        </div>
        <div class="clear container mt-15 mb-15 pt-15 pb-15">
        
      <c:forEach items="${newsPager.datas}" var="news">  
            <div class="clear col-sm-6 pt-15 pb-15 pl-0 pr-20">
                <div class="clear bg-fafafa">
                    <div class="col-sm-5 clear pd-15">
                        <img class="full-w wh16-9 cur-p" src="${news.img_url }" alt=" ${news.news_title}" onclick="javascript:detail(${news.id})">
                    </div>
                    <div class="col-sm-7 clear pt-15 pb-15">
                        <p class="line-h-20 h-20 f-16 col-414141 text-overflow cur-p hovecol-309DE2" onclick="javascript:detail(${news.id})">
                           ${news.news_title}
                        </p>
                        <p class="f-12 col-888 mtb-10-0-ipad line-h-20 text-line-2-1-ipad cur-p hovecol-999"  onclick="javascript:detail(${news.id})">
                             ${news.news_subhead}
                        </p>
                        <p class="f-12 col-888 mtb-10-0-ipad line-h-20 text-line-2-1-ipad cur-d">
                            日期：<span class="col-888">${news.release_time}</span> 阅读：<span class="col-888">${news.read_quantity}</span>
                        </p>
                    </div>
                </div>
            </div>
         </c:forEach> 
         <script type="text/javascript">
         	function detail(news){
         		window.location.href="<%=request.getContextPath()%>/l/newsDetail?news_id="+news;
         	}
         </script>
           <%--  <div class="clear col-sm-6 pt-15 pb-15 pl-20 pr-0">
                <div class="clear bg-fafafa">
                    <div class="col-sm-5 clear pd-15">
                        <img class="full-w wh16-9 cur-p" src="<%=request.getContextPath() %>/resources/img/news/HK_NewsIndex/news-tipsv2.jpg" alt="">
                    </div>
                    <div class="col-sm-7 clear pt-15 pb-15">
                        <p class="line-h-20 h-20 f-16 col-414141 text-overflow cur-p hovecol-309DE2">
                            这是一条新闻哦哦哦
                        </p>
                        <p class="f-12 col-888 mtb-10-0-ipad line-h-20 text-line-2-1-ipad cur-p hovecol-999">
                            这是新闻的内容哦哦哦哦哦啊啊啊啊啊啊啊啊啊啊啊一定要看啊啊啊啊啊啊啊啊啊啊。
                        </p>
                        <p class="f-12 col-888 mtb-10-0-ipad line-h-20 text-line-2-1-ipad cur-d">
                            日期：<span class="col-888">2017</span>/<span class="col-888">09</span>/<span class="col-888">06</span> 阅读：<span class="col-888">1888</span>
                        </p>
                    </div>
                </div>
            </div>

      
            <div class="clear col-sm-6 pt-15 pb-15 pl-0 pr-20">
                <div class="clear bg-fafafa">
                    <div class="col-sm-5 clear pd-15">
                        <img class="full-w wh16-9 cur-p" src="<%=request.getContextPath() %>/resources/img/news/HK_NewsIndex/news-tipsv1.jpg" alt="">
                    </div>
                    <div class="col-sm-7 clear pt-15 pb-15">
                        <p class="line-h-20 h-20 f-16 col-414141 text-overflow cur-p hovecol-309DE2">
                            这是一条新闻哦哦哦哦哦这是一条新闻哦哦哦哦哦这是一条新闻哦哦哦哦哦这是一条新闻哦哦哦哦哦这是一条新闻哦哦哦哦哦
                        </p>
                        <p class="f-12 col-888 mtb-10-0-ipad line-h-20 text-line-2-1-ipad cur-p hovecol-999">
                            这是新闻的内容哦哦哦哦哦啊啊啊啊啊啊啊啊啊啊啊一定要看啊啊啊啊啊啊啊啊啊啊。这是新闻的内容哦哦哦哦哦啊啊啊啊啊啊啊啊啊啊啊一定要看啊啊啊啊啊啊啊啊啊啊。这是新闻的内容哦哦哦哦哦啊啊啊啊啊啊啊啊啊啊啊一定要看啊啊啊啊啊啊啊啊啊啊。
                        </p>
                        <p class="f-12 col-888 mtb-10-0-ipad line-h-20 text-line-2-1-ipad cur-d">
                            日期：<span class="col-888">2017</span>/<span class="col-888">09</span>/<span class="col-888">06</span> 阅读：<span class="col-888">1888</span>
                        </p>
                    </div>
                </div>
            </div> --%>

           <!--  <div class="clear col-sm-12 text-center mt-15 mb-15">
                <span class="f-14 col-888 bor bor-col-dfdfdf pl-5 pr-5 cur-p pt-3 pb-3">首页</span>
                <span class="f-14 col-white pl-10 pr-10 bg-309DE2 bor bor-col-309DE2 cur-p pt-3 pb-3">1</span>
                <span class="f-14 col-888 bor bor-col-dfdfdf pl-5 pr-5 cur-p pt-3 pb-3">下一页</span>
            </div> -->
            <div class="clear text-center col-333 f-14">
            <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/pager/pager-taglib.js"></script> 
            <jsp:include page="../comm/pager.jsp">
				 <jsp:param name="url" value="healthInquiry"/>
				 <jsp:param name="items" value="${newsPager.total}"/>
			</jsp:include>
			</div>
        </div>
    </div>
    
	<jsp:include page="./../comm/footer.jsp"/>
	
    <script src="<%=request.getContextPath() %>/resources/js/comm/jquery.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/comm/bootstrap.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/comm/base.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/news/HK_News.js"></script>
</body>

</html>