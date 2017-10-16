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
     <title>碧沙康健_资讯内容页</title>
    <!-- base -->
    <link href="<%=request.getContextPath() %>/resources/ctrl/Font-Awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/comm/bootstrap.css" rel="stylesheet">
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
                    <a class="col-666 t-nonehove hovecol-309DE2" id="healthInquiry" href="">健康咨询 </a> >
                    <span class="col-252525 t-nonehove">咨询内容</span>
                </p>
            </div>
            <div class="clear h-30 bg-2c9fd9 col-white line-h-30">
                <img class="ml-30 pos-r t--3" src="<%=request.getContextPath() %>/resources/img/news/HK_NewsContent/shapev1.png" alt="">
                <span class="col-white f-18 pl-5">咨讯详情</span>
                <img class="pos-r t--5 ml-10" src="<%=request.getContextPath() %>/resources/img/news/HK_NewsContent/shapev2.png" alt="">
                <span class="col-white f-16 pl-5">INFORMATION</span>
            </div>
        </div>
        <div class="clear container pt-40 pl-0 pr-0 pb-40">
            <p class="col-3f3b3c f-24 text-center line-h-30 text-overflow">
             ${currentDetail.news_title}
            </p>
            <p class="col-898989 f-16 text-center line-h-25 mt-5 mb-5">
                <span class="col-898989">日期：</span>
                <span class="col-898989 mr-10"> ${currentDetail.release_time}</span>
                <span class="col-898989 ml-10">阅读：</span>
                <span class="col-898989"> ${currentDetail.read_quantity}</span>
            </p>
        </div>
        <div class="clear main-details container pb-20 bor bor-b bor-col-e4e4e4">
        ${currentDetail.news_content}
        
       <%--      <div class="clear text-center">
                <img src="<%=request.getContextPath() %>/resources/img/news/HK_NewsContent/newscontent-tipsv1.jpg" alt="">
            </div>
            <p class="f-18 col-666 text-ind line-h-35 mt-20">
                那时我的家住在高士的老街上，老街是散发清新泥土气息的土路面，路的两旁林立着参差不齐却古朴典雅的青砖瓦房。与青砖瓦房形成鲜明对比的是，我家斜对面矗立着高大而气派的高士合作社，合作社虽也是青砖瓦房结构，但它是那种带有木质阁楼的楼房，比民宅要高许多，兀立在那里有种鹤立鸡群的感觉。而在那个物质极度匮乏的年代合作社是物质和财富的象征，是特权和地位的象征。那里有油盐酱醋等生活必需品，更有糖、烟、酒、布匹等紧俏生活物资，是极少数有钱人和特权人的自由进出的天堂，是广大穷苦百姓不敢轻易踏足的地方。
            </p>
            <p class="f-18 col-666 text-ind line-h-35">
                合作社的前面有块宽阔而空旷的场地，这里长着两棵高大的苦楝树。这是个自由、平等、开放的好地方，它不仅是孩童们开心玩耍的乐园，更是街坊纳凉、聊天、聚会的好去处。
            </p>
            <p class="f-18 col-666 text-ind line-h-35 mb-40">
                我享有得天独厚的条件，所以每天都会在苦楝树下留连，或吃饭、或玩耍、或混迹在大人堆里凑热闹。就这样，在四季的轮回里，我看着它蓬勃生长，看着它开花结果，看着它枝叶凋零。
            </p> --%>
        </div>
        <div class="clear container pt-15 pb-15 pl-0 pr-0 cur-d" > 
            <p class="col-898989 f-18 line-h-25 pt-5 pb-5">
                上一篇：<a class="col-898989 t-nonehove hovecol-309DE2" id="last-news" href="<%=request.getContextPath()%>/l/newsDetail?news_id=${lastNew.id}">${lastNew!=null?lastNew.news_title:"无"}</a>
            </p>
            <p class="col-898989 f-18 line-h-25 pt-5 pb-5" >
                下一篇：<a class="col-898989 t-nonehove hovecol-309DE2" id="next-news" href="<%=request.getContextPath()%>/l/newsDetail?news_id=${nextNew.id}">${nextNew!=null?nextNew.news_title:"无"}</a>
            </p>
        </div>
         <div class="clear container pl-0 pr-0 cur-d pb-40">
            <p class="clear line-h-35 pt-5 pb-5">
                <span class="f-24 col-666 pull-left">相关文章</span>
                <a class="f-18 col-898989 t-nonehove hovecol-309DE2 pull-right" id="more_news" href="<%=request.getContextPath()%>/l/healthInquiry">更多>></a>
            </p>
            <div class="clear pt-15 pb-15">
            <c:forEach items="${more }" var="moreNews">
                <div class="clear col-sm-6 pt-15 pb-15 pl-0 pr-20">
                    <div class="clear bg-fafafa">
                        <div class="col-sm-5 clear pd-15">
                        <img class="full-w wh16-9 cur-p" src="${moreNews.img_url }" alt=" ${moreNews.news_title}" onclick="javascript:detail(${moreNews.id})">
                    </div>
                    <div class="col-sm-7 clear pt-15 pb-15">
                        <p class="line-h-20 h-20 f-16 col-414141 text-overflow cur-p hovecol-309DE2" onclick="javascript:detail(${moreNews.id})">
                           ${moreNews.news_title}
                        </p>
                        <p class="f-12 col-888 mtb-10-0-ipad line-h-20 text-line-2-1-ipad cur-p hovecol-999"  onclick="javascript:detail(${moreNews.id})">
                             ${moreNews.news_subhead}
                        </p>
                        <p class="f-12 col-888 mtb-10-0-ipad line-h-20 text-line-2-1-ipad cur-d">
                            日期：<span class="col-888">${moreNews.release_time}</span> 阅读：<span class="col-888">${moreNews.read_quantity}</span>
                        </p>
                    </div>
                </div>
            </div>
                </c:forEach>
            </div>
        </div>
 		<script type="text/javascript">
         	function detail(news){
         		window.location.href="<%=request.getContextPath()%>/l/newsDetail?news_id="+news;
         	}
         	var healthInquiry = document.getElementById("healthInquiry").innerText;
         	
         </script>
         
    </div>
 	<jsp:include page="./../comm/footer.jsp"/>
    <script src="<%=request.getContextPath() %>/resources/js/comm/jquery.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/comm/bootstrap.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/comm/base.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/news/HK_News.js"></script>
</body>

</html>