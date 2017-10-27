<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ page import="com.bisa.health.model.SystemContext"%>
<%@ include file="../comm/tag.jsp" %>

<% String menuType = "sys3"; %>
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
    <title>碧沙康健_商品详细页</title>
    <!-- base -->
    <link href="<%=request.getContextPath() %>/resources/ctrl/Font-Awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/ctrl/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/comm/base.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/index/index.css" rel="stylesheet">
	
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
    /* 页面嵌入部分CSS为设置zoom框大小 */

    @media (min-width:768px) and (max-width:991px) {
        .zoomLens {
            width: 80px !important;
            height: 80px !important;
        }
        .zoomWindow {
            border-width: 1px !important;
            width: 260px !important;
            height: 260px !important;
        }
    }

    @media (min-width:992px) and (max-width:1199px) {
        .zoomLens {
            width: 100px !important;
            height: 100px !important;
        }
        .zoomWindow {
            border-width: 1px !important;
            width: 366px !important;
            height: 366px !important;
        }
    }

    @media (min-width:1200px) and (max-width:1299px) {
        .zoomLens {
            width: 130px !important;
            height: 130px !important;
        }
        .zoomWindow {
            border-width: 1px !important;
            width: 400px !important;
            height: 400px !important;
        }
    }

    @media (min-width:1300px) {
        .zoomLens {
            width: 130px !important;
            height: 130px !important;
        }
        .zoomWindow {
            border-width: 1px !important;
            width: 400px !important;
            height: 400px !important;
        }
    }
    </style>
</head>

<body>
   <%@ include file="../comm/header.jsp" %> 
    <div class="clear full-w bor bor-t bor-col-D6D6D6 sha-float-titlev1 flo-menuv2">
        <div class="containerv2 pt-10 pb-10 clear line-h-30 plr-0-10-ipad">
            <span class="col-black family-h pull-left cur-d f-20 ">${commodity.title }</span>
            <span class="col-black family-h pull-right f-12">
            <span class="t-nonehove hovecol-309DE2 col-black cur-p">概述</span>
            <span>|</span>
            <span class="t-nonehove hovecol-309DE2 col-black cur-p sf-pointer">参数</span>
            <span>|</span>
            <span class="t-nonehove hovecol-309DE2 col-black cur-p user-appraise">用户评价</span>
            </span>
        </div>
    </div>
    <div class="clear full-w bor bor-t bor-col-D6D6D6 sha-float-titlev1 affix t-0 l-0 bg-white z-999 dis-n flo-menuv2-aff">
        <div class="containerv2 pt-10 pb-10 clear line-h-30 plr-0-10-ipad">
            <span class="col-black family-h pull-left cur-d f-20 ">${commodity.title }</span>
            <button class="pull-right f-20 line-h-30 h-30 text-center bor-none bg-309DE2 hovbg-2D90CF col-white pl-20 pr-20" disabled="disabled">
                	立即购买
            </button>
        </div>
    </div>
    <div class="wrap">
        <div class="containerv2 pl-0 pr-0">
            <div class="clear cont-other">
                <div class="clear full-w ">
                    <div class="clear col-sm-5 pl-0 pr-0 pull-left">
                        <div class="claer col-md-12 pull-left text-center pd-50-30-ipad">
                            <img id="prode-zoom-main" class="full-w produ-max-show " src="<%=request.getContextPath() %>/resources/img/net_shopping/imgloadflase.jpg" data-zoom-image="<%=request.getContextPath() %>/resources/img/net_shopping/imgloadflase.jpg" alt="">
                        </div>
                        <div class="clear col-md-12 mtb-20-5-ipad pl-0 pr-0 pull-left">
                            <div class="prode-zoom-img clear dis-ib cur-p col-sm-3 plr-10-5-ipad prode-zoom-img-v1" data-image="<%=request.getContextPath() %>/resources/img/net_shopping/imgloadflase.jpg" data-zoom-image="<%=request.getContextPath() %>/resources/img/net_shopping/imgloadflase.jpg">
                                <img class="full-w bor bor-col-B2B2B2 bor-col-309DE2 produ-min-tips " src="<%=request.getContextPath() %>/resources/img/net_shopping/imgloadflase.jpg" />
                            </div>
                            <div class="prode-zoom-img clear dis-ib cur-p col-sm-3 plr-10-5-ipad 
                            prode-zoom-img-v2" data-image="<%=request.getContextPath() %>/resources/img/net_shopping/imgloadflase.jpg" data-zoom-image="<%=request.getContextPath() %>/resources/img/net_shopping/imgloadflase.jpg">
                                <img class="full-w bor bor-col-B2B2B2 produ-min-tips" src="<%=request.getContextPath() %>/resources/img/net_shopping/imgloadflase.jpg" />
                            </div>
                            <div class="prode-zoom-img clear dis-ib cur-p col-sm-3 plr-10-5-ipad prode-zoom-img-v3" data-image="<%=request.getContextPath() %>/resources/img/net_shopping/imgloadflase.jpg" data-zoom-image="<%=request.getContextPath() %>/resources/img/net_shopping/imgloadflase.jpg">
                                <img class="full-w bor bor-col-B2B2B2 produ-min-tips" src="<%=request.getContextPath() %>/resources/img/net_shopping/imgloadflase.jpg" />
                            </div>
                            <div class="prode-zoom-img clear dis-ib cur-p col-sm-3 plr-10-5-ipad prode-zoom-img-v4" data-image="<%=request.getContextPath() %>/resources/img/net_shopping/imgloadflase.jpg" data-zoom-image="<%=request.getContextPath() %>/resources/img/net_shopping/imgloadflase.jpg">
                                <img class="full-w bor bor-col-B2B2B2 produ-min-tips" src="<%=request.getContextPath() %>/resources/img/net_shopping/imgloadflase.jpg" />
                            </div>
                        </div>
                    </div>
                    <div class="clear col-sm-5 pull-left pt-20-5-ipad plr-25-5-ipad">
                        <div class="clear pb-30 min-h-470-390-ipad pos-r">
                            <div class="clear pos-a t-0 l-0 full-w">
                                <p class="f-30-20-ipad col-black family-h h-30 line-h-30 mtb-10-5-ipad pro-main-dir">
                                    ${commodity.title }
                                </p>
                                <p class="f-18-14-ipad col-616161 min-h-125-60 family-hs line-h-25 pro-dep-dir">
                                    ${commodity.description }
                                </p>
                            </div>
                            <div class="clear pos-a b-0 l-0 full-w">
                                <div class="clear line-h-25 ptb-20-0-ipad bor bor-l-none bor-r-none bor-col-B2B2B2-hide-ipad">
                                    <span class="col-309DE2 f-30 family-h dis-ib pull-left pro-main-price">
                                         ${commodity.selling_price }
                                    </span>
                                    <span class="col-309DE2 f-16 family-h dis-ib pull-left">
                                        元
                                    </span>
                                </div>
                                <div class="clear full-w combomainbox">
                                    <div class="col-sm-4 text-center cur-p pl-0 combotips">
                                        <div class="clear bor-col-B2B2B2 bor-col-activate bor h-40-30-ipad line-h-40-30-ipad f-18-14-ipad col-black combotips-div combotips-div-biaopei">
                                          	  标&nbsp;&nbsp;配
                                        </div>
                                        <!-- 数据库的ID -->
                                        <input class="comboiput-cid" type="hidden" id="productId" value="${commodity.shop_number }">
                                        <!-- 单价 -->
                                        <input class="comboiput-price" type="hidden" value="${commodity.selling_price }">
                                        <!-- 主标题 -->
                                        <input class="comboiput-maindir" type="hidden" value="${commodity.title }">
                                        <!-- 副标题 -->
                                        <input class="comboiput-depdir" type="hidden" value="${commodity.description }">
                                        <!-- 四张介绍图 -->
                                        <input class="comboiput-prodezoomimgv1" type="hidden" value="<%=request.getContextPath() %>/resources/${commodity.pic1_picture}">
                                        <input class="comboiput-prodezoomimgv2" type="hidden" value="<%=request.getContextPath() %>/resources/${commodity.pic2_picture}">
                                        <input class="comboiput-prodezoomimgv3" type="hidden" value="<%=request.getContextPath() %>/resources/${commodity.pic3_picture}">
                                        <input class="comboiput-prodezoomimgv4" type="hidden" value="<%=request.getContextPath() %>/resources/${commodity.pic4_picture}">
                                        <!-- 主图 -->
                                        <input class="comboiput-mainimg" type="hidden" value="<%=request.getContextPath() %>/resources/${commodity.main_picture}">
                                    </div>
                                    <c:forEach var="pack" items="${pack }">
                                    <div class="col-sm-4 text-center cur-p pl-0 combotips">
                                        <div class="clear bor-col-B2B2B2  bor h-40-30-ipad line-h-40-30-ipad f-18-14-ipad col-black combotips-div">
                                            ${pack.package_name }
                                        </div>
                                        <!-- 数据库的ID -->
                                        <input class="comboiput-cid" type="hidden"  value="${pack.package_number }">
                                        <!-- 单价 -->
                                        <input class="comboiput-price" type="hidden" value="${pack.price }">
                                        <!-- 主标题 -->
                                        <input class="comboiput-maindir" type="hidden" value="${pack.patitle }">
                                        <!-- 副标题 -->
                                        <input class="comboiput-depdir" type="hidden" value="${pack.sub_descrition }">
                                        <!-- 四张介绍图 -->
                                        <input class="comboiput-prodezoomimgv1" type="hidden" value="<%=request.getContextPath() %>/resources/${pack.pic1_picture}">
                                        <input class="comboiput-prodezoomimgv2" type="hidden" value="<%=request.getContextPath() %>/resources/${pack.pic2_picuture}">
                                        <input class="comboiput-prodezoomimgv3" type="hidden" value="<%=request.getContextPath() %>/resources/${pack.pic3_picuture}">
                                        <input class="comboiput-prodezoomimgv4" type="hidden" value="<%=request.getContextPath() %>/resources/${pack.pic4_picuture}">
                                        <!-- 主图 -->
                                        <input class="comboiput-mainimg" type="hidden" value="<%=request.getContextPath() %>/resources/${pack.main_picture}">
                                    </div>
                                    </c:forEach>
                                </div>
                         <!--    </div> -->
                                <div class="clear full-w bor bor-col-B2B2B2 cur-p shieldframe mb-20">
                                    <!-- 此框的选中状态1为选中，0为未选中 -->
                                    <input class="shieldframe_sel" type="hidden" value="0">
                                    <div class="clear col-md-3 col-sm-2 pull-left ptb-35-16-ipad text-center pl-0 pr-0">
                                        <div class="clear img-30-20 bg-B1B1B1 full-radius text-center dis-ib line-h-30 shieldframe_circle">
                                            <img class="img-20-14 pos-r t--2--6-ipad" src="<%=request.getContextPath() %>/resources/img/net_shopping/ico_ok.png" alt="">
                                        </div>
                                    </div>
                                    <div class="clear col-md-7 col-sm-8 pull-left pt-30-10-ipad pl-0 pr-0">
                                        <div class="clear pull-left col-sm-2 pl-0 pr-0">
                                            <img class="pos-r t--2-6-ipad" src="<%=request.getContextPath() %>/resources/${comm.main_picture}" alt="">
                                        </div>
                                        <div class="clear pull-left col-sm-10 pl-5 pr-0">
                                            <p class="col-black f-18-14-ipad family-h line-h-25-30-ipad">
                                                悉心平安服务
                                            <span class="col-309DE2 f-12 hidden-sm">
                                                <a href="<%=request.getContextPath() %>/shopping/getCommodityId?shop_number=${comm.shop_number}">
                                                了解服务详情
                                                </a>
                                            </span>
                                            </p>
                                            <p class="col-aaa f-12 family-h line-h-20 hidden-sm text-overflow">
                                               ${comm.description }
                                            </p>
                                        </div>
                                    </div>
                                    <div class="clear col-md-2 col-sm-2 pull-left pt-10 pl-0 pr-0">
                                        <p class="clear pb-10 line-h-30 col-309DE2 f-14 pr-10">
                                            <a class="t-nonehove col-309DE2 pull-right hovecol-309DE2 " href="javascript:;">选购</a>
                                        </p>
                                        <p class="clear line-h-20 pr-10 hidden-sm">
                                            <span class="col-aaa f-12 family-h pull-right">${comm.selling_price }元/月</span>
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="clear ptb-20-10-ipad bor bor-l-none bor-r-none bor-col-B2B2B2">
                            <!-- 这里是需要提交的相关信息 -->
                            <!-- 获取套餐的id -->
                            <input class="pro-submit-selid" type="hidden"  name="packId" value="">
                            <!-- 获取是否选择了悉心平安服务0是未选择1是选择 -->
                            <input class="pro-submit-ischeckserve" type="hidden" name="serviceId" value="0">
                            <!-- 这里是判断选择的是单品还是套餐。单品为0，套餐为1 -->
                            <input class="pro-submit-issingleorcombo" type="hidden" name="issingleorcombo" value="0">
                            <!-- 获取所选内容的主标题 -->
                            <input class="pro-submit-maintitle" type="hidden" value="">
                            <!-- 获取所选内容的副标题 -->
                            <input class="pro-submit-depdir" type="hidden" value="">
                            <!-- 获取所选内容的主图的url地址 -->
                            <input class="pro-submit-mainimg" type="hidden" value="">
                            <!-- 获取所选内容的单价 -->
                            <input class="pro-submit-singleprice" type="hidden" value="">
                            <!-- 获取所选内容的数量默认为1 -->
                            <input class="pro-submit-num" type="hidden" value="1">
                            <!-- 唯一的一个服务的值 -->
                            <!-- 后台要把服务的相应的值赋给下面 -->
                            <input class="pro-submit-fuwucid" type="hidden"   name="service_number" value="${comm.shop_number }">
                            <input class="pro-submit-fuwunum" type="hidden" value="1">
                            <input class="pro-submit-fuwukind" type="hidden" value="0">
                            <input class="pro-submit-fuwumainimg" type="hidden" value="<%=request.getContextPath() %>/resources/${comm.main_picture}">
                            <input class="pro-submit-fuwudir" type="hidden" value="${comm.title}">
                            <input class="pro-submit-fuwuprice" type="hidden" value="${comm.selling_price}">


                            <div class="clear col-sm-8 pl-0 pr-10">
                            	<form action="<%=request.getContextPath()%>/user/addCart" method="get">
       						 	<input name="add_packId" value="" class="add-PackId" type="hidden">
       						 	<input name="add_serviceId" value="" class="add-serviceId" type="hidden">
       						 	<input name="add_issingleorcombo" value="" class="add-issingleorcombo" type="hidden">
       						 	<input name="add_service_number" value="" class="add-service_number" type="hidden">
       						 <!-- 	<input name="add_service_Id" value="" class="add-service_Id" type="hidden"> -->
                                <button type="submit" class="line-h-45-30-ipad h-45-30-ipad col-white f-18-14-ipad text-center full-w radius-0 bg-309DE2 bor-none hovbg-2D90CF add_shopcar">加入购物车</button>
                                </form>
                            </div>
                            <form action="<%=request.getContextPath()%>/a/orderIndex" method="get">
	                            <div class="clear col-sm-4 pl-10 pr-0">
	                            	<input type="hidden" class="product-submit" value="" name="data">
	                                <button class="line-h-45-30-ipad h-45-30-ipad col-white f-18-14-ipad text-center full-w radius-0 bg-9BD2F4 bor-none hovbg-9BD2F4 pro-buynow" type="submit">立即购买</button>
	                            </div>
                            </form>
                        </div>
                        <p class="pt-10 pb-10 line-h-30 f-16 ">
                            <img class="img-20 mr-5 pos-r t--2" src="<%=request.getContextPath() %>/resources/img/net_shopping/find-more.png" alt="">
                            <a class="col-616161 hovecol-309DE2 t-nonehove" href="<%=request.getContextPath() %>/l/index">返回首页查看更多心脏健康产品</a>
                        </p>
                    </div>
                    <div class="clear col-sm-2 pull-left pt-20 pl-10 pr-10">
                        <div class="pos-r clear text-center line-h-20 f-16-14-ipad col-black pb-20-0-ipad">
                            相关产品
                            <div class="pos-a bor bor-b w-50 t-10 l-0 hidden-sm hidden-md">
                            </div>
                            <div class="pos-a bor bor-b w-50 t-10 r-0 hidden-sm hidden-md">
                            </div>
                        </div>
                            <c:forEach var="listproduct" items="${listproduct }" begin="0" end="2">
                                <div class="clear pos-r bor bor-col-B2B2B2 pull-left mt-10 mb-10 cur-p">
                                    <a href="<%=request.getContextPath() %>/l/shopping/getCommodityId?shop_number=${listproduct.shop_number}"><img class="full-wh" src="<%=request.getContextPath() %>/resources/${listproduct.main_picture}" alt=""></a>
                                    <div class="clear h-25 line-h-25 rgba-d2d2d2-20 pos-a b-0 l-0 pl-10 pr-10 full-w hidden-sm hidden-md">
                                       <a class="col-727272 t-nonehove hovecol-309DE2" href="<%=request.getContextPath() %>/shopping/getCommodityId?shop_number=${listproduct.shop_number}">
                                       <span class="col-727272 t-nonehove hovecol-309DE2 text-line-1"> 
                                           ${listproduct.description}
                                       </span>
                                       </a>
                                    </div>
                                </div>
                            </c:forEach>
                    </div>
                </div>
            </div>
            <div class="clear full-w HK-begin-describe">
	            <c:forEach var="CommodityImg" items="${CommodityImg }">
		                <div class="clear full-w">
		                    <img class="full-w" src="<%=request.getContextPath() %>/resources/${CommodityImg.pic}" alt="">
		                </div>
	             </c:forEach>
            </div>
        </div>
    </div>
    <div class="img-60 bg-9BD2F4 affix t-80s r-40 z-999 hk-upbtn dis-n">
        <img src="<%=request.getContextPath() %>/resources/img/net_shopping/up.png" class="img-40 mt-10 ml-10" alt="">
    </div>
     <%@ include file="../comm/footer.jsp" %> 
	<script src="<%=request.getContextPath() %>/resources/js/comm/jquery.min.js"></script> 
    <script src="<%=request.getContextPath() %>/resources/ctrl/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/comm/jquery.elevatezoom.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/comm/base.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/shopping/HK_Product.js"></script>
    <script src="<%=request.getContextPath() %>/resources/wqc_js/product/product.js"></script>
    <script>
    $("#prode-zoom-main").elevateZoom({
        gallery: 'gallery_01',
        cursor: 'pointer',
        galleryActiveClass: 'active',
        easing: true,
    });
    </script>
</body>

</html>