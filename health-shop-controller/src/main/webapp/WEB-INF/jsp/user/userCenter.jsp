<%@ page language="java" pageEncoding="utf-8"%>

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
    <title>碧沙康健_用户中心</title>
    <!-- base -->
    <link href="<%=request.getContextPath() %>/resources/ctrl/Font-Awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/ctrl/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <link  href="<%=request.getContextPath() %>/resources/ctrl/cropper/dist/cropper.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/comm/base.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/user/HK_User.css" rel="stylesheet">

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
                    <span class="col-252525 t-nonehove">用户中心</span>
                </p>
            </div>
        </div>
        <div class="clear full-w">
            <img class="full-w" src="<%=request.getContextPath() %>/resources/img/news/HK_HowToShop/banner.jpg" alt="">
        </div>
        <div class="container pl-0 pr-0 mt-30 clear bg-f5f5f5 pt-30 pb-70 mb-60">
            <div class="col-sm-3 pl-30 pr-20">
                <div class="clear bg-white pd-40-10-ipad">
                    <p class="mt-10 mb-10 col-212121 f-30 line-h-40 cur-d">
                        订单中心
                    </p>
                    <p class="col-757575 f-20-16-ipad line-h-25 mt-40 mb-20 cur-p hovecol-309DE2 ">
                        我的订单
                    </p>
                    <p class="col-757575 f-20-16-ipad line-h-25 mt-20 mb-20 cur-p hovecol-309DE2">
                        评价晒单
                    </p>
                    <p class="mt-30 mb-30 col-212121 f-30 line-h-40 cur-d">
                        个人中心
                    </p>
                    <p class="col-757575 f-20-16-ipad line-h-25 mt-20 mb-20 cur-p hovecol-309DE2 col-active">
                        我的个人中心
                    </p>
                    <p class="col-757575 f-20-16-ipad line-h-25 mt-20 mb-20 cur-p hovecol-309DE2">
                        充值服务
                    </p>
                    <p class="col-757575 f-20-16-ipad line-h-25 mt-20 mb-20 cur-p hovecol-309DE2">
                        收货地址
                    </p>
                    <p class="col-757575 f-20-16-ipad line-h-25 mt-20 mb-20 cur-p hovecol-309DE2">
                        账号安全
                    </p>
                </div>
            </div>
            <div class="clear col-sm-9 pr-30 pl-0">
                <div class="clear bg-white pb-100 plr-50-10-ipad pt-40">
                    <div class="clear">
                        <div class="clear col-sm-3 pl-0 pr-0">
                            <div class="clear pull-left w-120">
                                <img class="img-120 overflow-h full-radius bor bor-3px bor-col-fff box-sha-imgsha" src="<%=request.getContextPath() %>/resources/img/user/User/user-head-portrait.jpg" alt="">
                                <p class="text-center cur-p line-h-40 f-20 col-309DE2 set-heads">
                                    设置头像
                                </p>
                            </div>
                        </div>
                        <div class="clear col-sm-9 pl-0 pr-0">
                            <p class="line-h-40 f-28 col-616161">
                                123456754
                            </p>
                            <p class="line-h-40 f-22 col-b0b0b0">
                                早上好~
                            </p>
                            <p class="line-h-40 f-20 col-757575">
                                绑定手机：未绑定<span class="col-309DE2 cur-p f-16 ml-20">立即绑定</span>
                            </p>
                            <p class="line-h-40 f-20 col-757575">
                                绑定邮箱：youxianshenghenduoyouxiang.com<span class="col-309DE2 cur-p f-16 ml-20">修改</span>
                            </p>
                        </div>
                        <div class="clear col-sm-12 mt-40 bor bor-t bor-col-e0e0e0">
                        </div>
                    </div>
                    <div class="clear pt-40 pl-0 pr-0">
                        <div class="clear col-sm-6 pl-0 pr-0 pt-40 pb-40">
                            <div class="clear col-sm-5 pl-0 pr-0 text-center">
                                <img class="img-110 overflow-h full-radius" src="<%=request.getContextPath() %>/resources/img/user/User/center-tipsv1.png" alt="">
                            </div>
                            <div class="clear col-sm-7 pl-0 pr-0 pt-20 pb-20">
                                <p class="line-h-35 f-22 col-757575">
                                    待支付的订单：<a class="col-309DE2 t-nonehove col-active">1</a>
                                </p>
                                <p class="line-h-35 f-18 col-309DE2 t-nonehove">
                                    <a class="t-nonehove col-active">查看待支付的订单<span class="col-active icon-chevron-right f-14 ml-10 pos-r t--1"></span></a>
                                </p>
                            </div>
                        </div>
                        <div class="clear col-sm-6 pl-0 pr-0 pt-40 pb-40">
                            <div class="clear col-sm-5 pl-0 pr-0 text-center">
                                <img class="img-110 overflow-h full-radius" src="<%=request.getContextPath() %>/resources/img/user/User/center-tipsv2.png" alt="">
                            </div>
                            <div class="clear col-sm-7 pl-0 pr-0 pt-20 pb-20">
                                <p class="line-h-35 f-22 col-757575">
                                    待收货的订单：<a class="col-309DE2 t-nonehove col-active">0</a>
                                </p>
                                <p class="line-h-35 f-18 col-309DE2 t-nonehove">
                                    <a class="col-757575i t-nonehove">查看待收货的订单<span class="col-757575i icon-chevron-right f-14 ml-10 pos-r t--1"></span></a>
                                </p>
                            </div>
                        </div>
                        <div class="clear col-sm-6 pl-0 pr-0 pt-40 pb-40">
                            <div class="clear col-sm-5 pl-0 pr-0 text-center">
                                <img class="img-110 overflow-h full-radius" src="<%=request.getContextPath() %>/resources/img/user/User/center-tipsv3.png" alt="">
                            </div>
                            <div class="clear col-sm-7 pl-0 pr-0 pt-20 pb-20">
                                <p class="line-h-35 f-22 col-757575">
                                    待评价的订单：<a class="col-309DE2 t-nonehove col-active">0</a>
                                </p>
                                <p class="line-h-35 f-18 col-309DE2 t-nonehove">
                                    <a class="col-757575i t-nonehove">查看待评价的订单<span class="col-757575i icon-chevron-right f-14 ml-10 pos-r t--1"></span></a>
                                </p>
                            </div>
                        </div>
                        <div class="clear col-sm-6 pl-0 pr-0 pt-40 pb-40">
                            <div class="clear col-sm-5 pl-0 pr-0 text-center">
                                <img class="img-110 overflow-h full-radius" src="<%=request.getContextPath() %>/resources/img/user/User/center-tipsv4.png" alt="">
                            </div>
                            <div class="clear col-sm-7 pl-0 pr-0 pt-20 pb-20">
                                <p class="line-h-35 f-22 col-757575">
                                    待激活的服务：<a class="col-309DE2 t-nonehove col-active">0</a>
                                </p>
                                <p class="line-h-35 f-18 col-309DE2 t-nonehove">
                                    <a class="col-757575i t-nonehove">查看待激活的服务<span class="col-757575i icon-chevron-right f-14 ml-10 pos-r t--1"></span></a>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
   <%@ include file="../comm/footer.jsp" %> 
    <!-- 选择头像弹出层 -->
    <div class="clear show-selhead affix t-0 l-0 z-999 full-wh rgba-60 dis-n">
        <div class="pos-a t-150 l-0 full-w">
            <div class="w-900 mg-0-auto clear pos-r bg-white selhead-content radius-5 t--300 modal-content">
                <div class="pt-10 pb-10 line-h-25 pos-r f-20 pl-20 pr-20 col-333 full-w radius-5 cur-d">
                   	 选择头像
                    <img class="pos-a t-10 r-20 img-20 close-mod cur-p" src="<%=request.getContextPath() %>/resources/img/user/User/close.png" alt="">
                </div>
                <div class="clear bor bor-t bor-col-f2 pd-20">
                    <div class="clear col-sm-9 h-364 bg-fcfcfc box-sha-inset-big pos-r pl-0 pr-0 overflow-h">
                        <div class="clear " style="width: 643px;height: 364px;">
                            <img id="show-main-img" class="max-w-100p" src="">
                        </div>
                    </div>
                    <div class="clear col-sm-3">
                        <div class="clear">
                            <img id="show-little-imgv1" class="img-184 img-thumbnail" src="" alt="">
                        </div>
                        <div class="clear mt-15">
                            <img id="show-little-imgv2" class="img-184 img-thumbnail full-radius" src="" alt="">
                        </div>
                    </div>
                    <div class="clear col-sm-12 pl-0 pr-0 mt-30 mb-10">
                        <div class="clear col-sm-9 btn-toolbar" role="toolbar">
                            <div class="btn-group pull-left col-sm-2" role="group">
                                <span class="btn btn-success pos-r cur-p">
                                    <input type="file" id="sel-file" class="opacity-0 pos-a t-0 l-0 full-wh cur-p">选择文件
                                </span>
                            </div>
                            <div class="btn-group pull-left col-sm-3" role="group">
                                <button type="button" class="btn btn-success cro-btn-reset">重置操作</button>
                            </div>
                            <div class="btn-group pull-left pull-right" role="group">
                                <button type="button" class="btn btn-success cro-btn-big">放大</button>
                                <button type="button" class="btn btn-success cro-btn-small">缩小</button>
                                <button type="button" class="btn btn-success cro-btn-left">左旋</button>
                                <button type="button" class="btn btn-success cro-btn-right">右旋</button>
                            </div>
                        </div>
                        <div class="clear col-sm-3">
                            <button class="btn full-w btn-success cro-btn-submit">确定上传</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="<%=request.getContextPath() %>/resources/js/comm/jquery.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/ctrl/cropper/dist/cropper.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/ctrl/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/ctrl/layer/layer.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/comm/base.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/user/HK_User.js"></script>
<!-- 	<script type="text/javascript" src="http://localhost:8082/upload/resources/wqc_js/user/userCenter.js"></script> -->
</body>

</html>