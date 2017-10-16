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
    <title>碧沙康健_联系我们页</title>
    <!-- base -->
    <link href="<%=request.getContextPath() %>/resources/ctrl/Font-Awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/ctrl/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/comm/base.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/about/HK_About.css" rel="stylesheet">
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
    <script type="text/javascript">
			var http_request ="<%=request.getContextPath() %>";
			var request_url ="<%=request.getScheme()%>";
	</script>
</head>

<body>
<jsp:include page="./../comm/header.jsp"/>
    <div class="wrap clear">
        <div class="container pl-0 pr-0">
            <div class="clear">
                <p class="pt-10 pb-10 pl-15 pr-15 line-h-20 cur-d ">
                    <a class="col-666 t-nonehove hovecol-309DE2" id="index" href="">首页 </a> >
                    <span class="col-252525 t-nonehove">联系我们</span>
                </p>
            </div>
        </div>
        <div class="clear full-w">
            <img class="full-w" src="<%=request.getContextPath() %>/resources/img/news/HK_NewsIndex/banner.jpg" alt="">
        </div>
        <div class="container mt-30 pl-0 pr-0 clear bg-f5f5f5 pt-30 pb-70 mb-60">
            <div class="col-sm-3 pl-30 pr-20">
                <div class="clear bg-white pd-40-10-ipad">
                    <p class="mt-10 mb-10 col-212121 f-30 line-h-40 cur-d">
                        联络我们
                    </p>
                    <p class="col-757575 f-20-16-ipad line-h-25 mt-40 mb-20 cur-p hovecol-309DE2 col-active">
                        联络我们
                    </p>
                    <p class="col-757575 f-20-16-ipad line-h-25 mt-20 mb-20 cur-p hovecol-309DE2">
                        免责条款
                    </p>
                    <p class="col-757575 f-20-16-ipad line-h-25 mt-20 mb-20 cur-p hovecol-309DE2">
                        隐私条例
                    </p>
                </div>
            </div>
            <div class="clear col-sm-9 pr-30 pl-0">
                <div class="clear bg-white pb-60 pl-50 pr-50">
                    <p class="pt-40-20-ipad f-50-40-ipad col-b0b0b0 line-h-70-50-ipad pb-20">
                        联络我们
                    </p>
                    <div class="clear bor bor-b bor-col-f5f5f5">
                    </div>
                    <div class="clear mt-40 mb-40">
                        <iframe width="604" height="365" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="http://j.map.baidu.com/_NJQL"></iframe>
                    </div>
                    <div class="clear">
                        <div class="clear col-sm-6">
                            <p class="f-20 col-309DE2 mb-30">
                                在线留言
                            </p>
                            <form action="" class="clear contactus-form">
                                <div class="clear col-sm-9 mb-20 pl-0">
                                    <input type="text" class="form-control radius-0 cname" name="cname">
                                </div>
                                <div class="col-sm-3 h-34 line-h-34 f-18 col-616161 mb-20 pl-0 pr-0">
                                    姓名
                                </div>
                                <div class="clear col-sm-9 mb-20 pl-0">
                                    <input type="text" class="form-control radius-0 cphone" name="cphone">
                                </div>
                                <div class="col-sm-3 h-34 line-h-34 f-18 col-616161 mb-20 pl-0 pr-0">
                                    联系电话 
                                </div>
                                <div class="clear col-sm-9 mb-20 pl-0">
                                    <input type="text" class="form-control radius-0 cemail" name="cemail">
                                </div>
                                <div class="col-sm-3 h-34 line-h-34 f-18 col-616161 mb-20 pl-0 pr-0">
                                    联系邮箱
                                </div>
                                <div class="clear col-sm-12 pl-0 pr-0 mb-20">
                                    <textarea class="form-control radius-0 resize-v" rows="10" placeholder="请输入留言内容..." name="cabout"></textarea>
                                </div>
                                <div class="clear col-sm-12 pl-0 pr-0 ">
                                    <button type="submit" class="bor-none hovbg-2D90CF bg-309DE2 pl-40 pr-40 line-h-35 f-14 col-white">
                                        发送
                                    </button>
                                </div>
                            </form>
                        </div>
                        <div class="clear col-sm-6 pl-30">
                            <p class="f-20 col-309DE2 mb-30">
                                地址
                            </p>
                            <p class="pl-50 f-14 col-696969 line-h-25 pos-r mb-20">
                                <span class="dis-ib pos-a t-0 l-10 col-309DE2 f-26">
                                    <img src="<%=request.getContextPath() %>/resources/img/HK_About/contactus-tipsv1.png" alt="">
                                </span>
                                地址：深圳市 宝安区 沙井街道 后亭社区 全至科技创新园10E
                            </p>
                            <p class="pl-50 f-14 col-696969 line-h-25 pos-r mb-20">
                                <span class="dis-ib pos-a t--3 l-10 col-696969 f-26">
                                    <img src="<%=request.getContextPath() %>/resources/img/HK_About/contactus-tipsv2.png" alt="">
                                </span>
                                电话：<a class=" t-nonehove col-696969 hovecol-309DE2" href="tel:0755-26880962">（86）0755-26880962</a>
                            </p>
                            <p class="pl-50 f-14 col-696969 line-h-25 pos-r mb-20">
                                <span class="dis-ib pos-a t--3 l-10 col-696969 f-26">
                                    <img src="<%=request.getContextPath() %>/resources/img/HK_About/contactus-tipsv3.png" alt="">
                                </span>
                                传真：<a class=" t-nonehove col-696969 hovecol-309DE2" href="tel:0755-26880962">（86）0755-26880962</a>
                            </p>
                            <p class="pl-50 f-14 col-696969 line-h-25 pos-r mb-20">
                                <span class="dis-ib pos-a t--3 l-10 col-696969 f-26">
                                    <img src="<%=request.getContextPath() %>/resources/img/HK_About/contactus-tipsv4.png" alt="">
                                </span>
                                电邮：<a class=" t-nonehove col-696969 hovecol-309DE2" href="mailto:info@bisa.com.hk">info@bisa.com.hk</a>
                            </p>
                        </div>
                    </div>
                    
                </div>
            </div>
        </div>
    </div>
  <jsp:include page="./../comm/footer.jsp"/>
    <script src="<%=request.getContextPath() %>/resources/js/comm/jquery.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/comm/jquery.validate.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/comm/jquery.validate.messages_zh.js"></script>
    <script src="<%=request.getContextPath() %>/resources/ctrl/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/comm/base.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/about/HK_ContactUs.js"></script>
    
</body>
</html>