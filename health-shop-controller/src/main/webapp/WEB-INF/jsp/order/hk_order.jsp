<%@ page language="java"  pageEncoding="UTF-8"%>
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
    <title>碧沙康健_确认订单页</title>
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
    label.error {
        display: block;
        margin: 5px 5px;
        float: left;
        color: #c00;
    }
    </style>
</head>

<body>
	<%@ include file="../comm/header.jsp" %> 
   <div class="wrap">
        <div class="container pl-0 pr-0">
            <div class="clear">
                <p class="pt-10 pb-10 pl-15 pr-15 line-h-20 bg-f5f5f5 cur-d ">
                    <a class="col-666 t-nonehove hovecol-309DE2" href="">首页 </a> >
                    <span class="col-252525 t-nonehove">购物车</span>
                </p>
                <p class="pt-10 pb-10 pl-15 pr-15 line-h-40 cur-d col-252525 family-h f-26">
                    确认订单
                </p>
            </div>
            <div class="clear pt-20 pl-20 pr-20 bg-f5f5f5 pb-45 full-w cur-d">
                <div class="clear bg-white pd-20">
                    <p class="pl-15 pr-15 line-h-30 col-252525 f-18">
                        收货地址
                    </p>
                    <div class="clear full-w conanorder-main">
                        <!-- 循环部分 -->
                        <!-- 一 -->
                    <c:if test="${addressList != null}">
                        <c:forEach items="${addressList }" var="address" varStatus="statu">
                                <div class="clear col-sm-3 pd-15-5-ipad conanorder-block">
                                    <div class="clear pd-15-5-ipad bor bor-col-7A7A7A ${statu.index==0?'bor-col-activate':'' } min-h-190-160-ipad conanorder-tips">
                                        <p class="line-h-30-20-ipad f-18 family-h">
                                            <input type="hidden" class="conanorder-tips-addr_number" id="shaddr_num" value="${address.addr_num}"/>
                                            <input type="hidden" value="${statu.index}" id="pre" />
                                            <span class="col-252525 conanorder-tips-name text-line-1">${address.name}</span>
                                        </p>
                                        <p class="line-h-20 mt-15-0-ipad f-14 family-h">
                                            <span class="col-555 conanorder-tips-phone">${address.tel}</span>
                                        </p>
                                        <p class="line-h-25 f-14 family-h text-line-4">
                                            <span class="col-555 conanorder-tips-address">${address.address }</span>
                                        </p>
                                        <input type="hidden" class="conanorder-tips-emal" value="${address.email}">
                                        <input type="hidden" class="conanorder-tips-about" value="${address.guid}">
                                        <p class="clear ptb-10-5-ipad f-14 family-h line-h-20">
                                            <span class="pull-right col-309DE2 cur-p t-nonehove conanorder-tips-alter dis-n">修改</span>
                                        </p>
                                    </div>
                                </div>
                        </c:forEach>
                    </c:if>
                        <!-- 循环结束 -->
                        <!-- 添加收货地址 -->
                        <div class="clear col-sm-3 pd-15-5-ipad">
                            <div class="clear pd-50-30-ipad bor bor-col-B2B2B2 min-h-190-160-ipad conanorder-tipsadd">
                                <div class="col-white family-h f-26 line-h-50 f-w text-center clear img-50 full-radius bg-eee mg-0-auto cur-p conanorder-tips-addv2">
                                    +
                                </div>
                                <p class="text-center pt-10 f-14 family-h line-h-25">
                                    <a class="col-B2B2B2 t-nonehove conanorder-tips-add" href="">添加新地址</a>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="clear full-w mb-20">
                        <button class="full-w h-45 line-h-45 col-252525 f-14 family-h text-center bor-none bg-d2d2d2 hovbg-309DE2 hovecol-white conanorder-moreaddress">
                            显示更多地址<i class="icon-angle-down col-252525 f-16 f-w ml-10"></i>
                        </button>
                        <button class="full-w h-45 line-h-45 col-252525 f-14 family-h text-center bor-none bg-d2d2d2 hovbg-309DE2 hovecol-white conanorder-moreaddresspullup dis-n">
                            显示更多地址<i class="icon-angle-up col-252525 f-16 f-w ml-10"></i>
                        </button>
                    </div>
                    <div class="clear mt-20 pt-20 pb-20 line-h-30 cur-d bor bor-b bor-col-B2B2B2">
                        <span class="f-18 col-252525 family-h dis-ib mr-30">
                            支付方式
                        </span>
                        <span class="f-14 col-309DE2 family-h dis-ib">
                            在线支付（支持微信支付、支付宝等）
                        </span>
                    </div>
                    <div class="clear pt-20 pb-20 line-h-30 cur-d bor bor-b bor-col-B2B2B2">
                        <span class="f-18 col-252525 family-h dis-ib mr-30">
                            配送方式
                        </span>
                        <span class="f-14 col-309DE2 family-h dis-ib">
                            快递配送（运费 30 元）
                        </span>
                    </div>
                    <div class="clear mt-20 pt-20 line-h-30 cur-d bor bor-b bor-col-B2B2B2">
                        <span class="f-18 col-252525 family-h dis-ib mr-30">
                            商品清单
                        </span>
                        <a class="f-14 col-252525 mr-10 family-h dis-ib pull-right t-nonehove hovecol-309DE2" href="<%=request.getContextPath() %>/l/Cart">
                            返回购物车 >
                        </a>
                    </div>
                <c:if test="${not empty productList.records}">
                <c:forEach items="${productList.records }" var="list">
                    <div class="clear full-w pt-10 pb-10">
                        <div class="clear col-sm-7 line-h-30 h-30 pl-0 pr-0">
                            <img class="img-30" src="${list.cartimg}" alt="">
                            <span class="f-14 family-h col-252525">${list.cartdir }</span>
                        </div>
                        <div class="clear col-sm-5  pl-0 pr-0">
                            <div class="col-sm-4 line-h-30 h-30 pl-0 pr-0">
                                <span class="f-14 family-h col-252525">
                                     ${list.cartprice}
                                </span>
                                <span class="f-14 family-h col-252525">
                                    ×
                                </span>
                                <span class="f-14 family-h col-252525">
                                    ${list.cartnum }
                                </span>
                            </div>
                            <div class="col-sm-4 line-h-30 h-30 pl-0 pr-0">
                                <span class="f-14 family-h col-252525">
                                    有货
                                </span>
                            </div>
                            <div class="col-sm-4 line-h-30 h-30 pl-0 pr-0">
                                <span class="f-14 family-h col-309DE2">
                                      ${list.cartprice*list.cartnum}
                                </span>
                                <span class="f-14 family-h col-309DE2">
                                    元
                                </span>
                            </div>
                        </div>
                    </div>
                </c:forEach> 
               </c:if>
               
               <c:if test="${not empty productList.product}">
                <c:forEach items="${productList.product }" var="list">
                    <div class="clear full-w pt-10 pb-10">
                        <div class="clear col-sm-7 line-h-30 h-30 pl-0 pr-0">
                            <img class="img-30" src="${list.cartimg}" alt="">
                            <span class="f-14 family-h col-252525">${list.cartdir }</span>
                        </div>
                        <div class="clear col-sm-5  pl-0 pr-0">
                            <div class="col-sm-4 line-h-30 h-30 pl-0 pr-0">
                                <span class="f-14 family-h col-252525">
                                     ${list.cartprice}
                                </span>
                                <span class="f-14 family-h col-252525">
                                    ×
                                </span>
                                <span class="f-14 family-h col-252525">
                                    ${list.cartnum }
                                </span>
                            </div>
                            <div class="col-sm-4 line-h-30 h-30 pl-0 pr-0">
                                <span class="f-14 family-h col-252525">
                                    有货
                                </span>
                            </div>
                            <div class="col-sm-4 line-h-30 h-30 pl-0 pr-0">
                                <span class="f-14 family-h col-309DE2">
                                      ${list.cartprice*list.cartnum}
                                </span>
                                <span class="f-14 family-h col-309DE2">
                                    元
                                </span>
                            </div>
                        </div>
                    </div>
                </c:forEach> 
               </c:if>
               
                    <div class="clear full-w pt-20 pb-20 bor bor-t bor-col-B2B2B2">
                        <div class="clear col-sm-3 pull-right pr-0 pl-0">
                            <div class="col-sm-6 text-right h-20 line-h-20 pr-0 pl-0">
                                <span class="f-14 family-h col-252525">商品件数：</span>
                            </div>
                            <div class="col-sm-6 text-right h-20 line-h-20 pr-0 pl-0">
                                <span class="f-14 family-h col-309DE2">
                                    ${count}
                                </span>
                                <span class="f-14 family-h col-309DE2">
                                    件
                                </span>
                            </div>
                            <div class="col-sm-6 text-right h-20 line-h-20 pr-0 pl-0">
                                <span class="f-14 family-h col-252525">金额总计：</span>
                            </div>
                            <div class="col-sm-6 text-right h-20 line-h-20 pr-0 pl-0">
                                <span class="f-14 family-h col-309DE2">
                                   ${price }
                                </span>
                                <span class="f-14 family-h col-309DE2">
                                    元
                                </span>
                            </div>
                            <div class="col-sm-6 text-right h-20 line-h-20 pr-0 pl-0">
                                <span class="f-14 family-h col-252525">活动优惠：</span>
                            </div>
                            <div class="col-sm-6 text-right h-20 line-h-20 pr-0 pl-0">
                                <span class="f-14 family-h col-309DE2">
                                    -0
                                </span>
                                <span class="f-14 family-h col-309DE2">
                                    元
                                </span>
                            </div>
                            <div class="col-sm-6 text-right h-20 line-h-20 pr-0 pl-0">
                                <span class="f-14 family-h col-252525">运费：</span>
                            </div>
                            <div class="col-sm-6 text-right h-20 line-h-20 pr-0 pl-0">
                                <span class="f-14 family-h col-309DE2">
                                    ${postPrice }
                                </span>
                                <span class="f-14 family-h col-309DE2">
                                    元
                                </span>
                            </div>
                            <div class="col-sm-6 text-right h-20 line-h-20 pt-20 pr-0 pl-0">
                                <span class="f-14 family-h col-252525">应付总额：</span>
                            </div>
                            <div class="col-sm-6 text-right h-20 line-h-20 pt-20 pr-0 pl-0">
                                <span class="f-20 family-h col-309DE2">
                                    ${total }
                                </span>
                                <span class="f-14 family-h col-309DE2">
                                    元
                                </span>
                            </div>
                        </div>
                    </div>
                </div>
                    <form action="<%=request.getContextPath() %>/l/commitOrder" method="post">
                            <div class="clear mt-5 bg-white pd-20">
                                <div class="col-sm-9 clear pl-10 pr-10 cur-d conanorder-tips-showmsg">
                                    <p class="f-16 family-h line-h-20">
                                    	<input type="hidden" class="conanorder-tips-showmsg-addr_number" id="addr_num" name="addr_num">
                                        <span class="col-252525 conanorder-tips-showmsg-name">
                                            
                                        </span>
                                        <span class="col-252525 pl-10 conanorder-tips-showmsg-phone">
                                            
                                        </span>
                                    </p>
                                    <p class="f-16 family-h line-h-20">
                                        <span class="col-252525 conanorder-tips-showmsg-address">
                                            
                                        </span>
                                        <span class="f-14 col-309DE2 hovecol-309DE2 t-nonehove main-order-tips-alter">修改</span>
                                    </p>
                                    <input type="hidden" class="conanorder-tips-showmsg-emal" value="987654321@qq.com">
                                    <input type="hidden" class="conanorder-tips-showmsg-about" value="1234">
                                    <input type="hidden" name="productList" value='${productStr}'>
                                </div>
                                <div class="col-sm-3 clear pl-0 pr-0">
                                    <button class="full-w h-40 line-h-40 col-white f-14 family-h text-center bor-none bg-309DE2 hovbg-2D90CF">
                                        立即下单
                                    </button>
                                </div>
                            </div>
                    </form>
            </div>
        </div>
        <!-- 弹出层 -->
        <!-- 添加收货地址 -->
        <div class="clear show-add-shippingaddress affix t-0 l-0 z-999 full-wh rgba-60 dis-n">
            <div class="pos-a t-30s l-0 full-w">
                <div class="w-600 mg-0-auto clear pos-r bg-white show-add-content">
                    <div class="pt-15 pb-15 line-h-30 pos-r f-18 pl-20 pr-20 col-4a4a4a full-w bg-f5f5f5">
                        添加收货地址
                        <img class="pos-a t-20 r-20 img-20 close-mod cur-p" src="<%=request.getContextPath() %>/resources/img/net_shopping/close.png" alt="">
                    </div>
                    <form class="clear pos-r shippingaddress-add" action="">
                        <div class="clear pd-40">
                            <div class="col-xs-6 text-center pl-0 pr-10 pos-r">
                                <input type="hidden" class="show-input-shipping-value" value="请输入收货人姓名" >
                                <input class="full-w bor h-36 line-h-36 bor-col-B2B2B2 pl-15 family-h f-14 col-252525 show-input-shipping" type="text" name="shname" id="name">
                                <div class="clear pos-a t-11 l-15 f-14 show-div-shipping col-9a9a9a bg-white">姓名</div>
                            </div>
                            <div class="col-xs-6 text-center pl-10 pr-0 pos-r">
                                <input type="hidden" class="show-input-shipping-value" value="请输入收货人手机号">
                                <input class="full-w bor h-36 line-h-36 bor-col-B2B2B2 pl-15 family-h f-14 col-252525 show-input-shipping" type="text" name="shphone" id="tel">
                                <div class="clear pos-a t-11 l-15 f-14 show-div-shipping col-9a9a9a bg-white">手机号</div>
                            </div>
                            <div class="col-xs-12 text-center mt-15 pl-0 pr-0 pos-r">
                                <input type="hidden" class="show-input-shipping-value" value="请输入您的详细地址">
                                <textarea rows="2" cols="20" class="full-w bor line-h-36 bor-col-B2B2B2 pl-15 family-h f-14 col-252525 show-input-shipping" type="text" name="shaddress" id="address"></textarea>
                                <div class="clear pos-a t-11 l-15 f-14 show-div-shipping col-9a9a9a bg-white">详细地址</div>
                            </div>
                            <div class="col-xs-6 text-center pl-0 pr-10 pos-r mt-15">
                                <input type="hidden" class="show-input-shipping-value" value="请输入您的电子邮件">
                                <input class="full-w bor h-36 line-h-36 bor-col-B2B2B2 pl-15 family-h f-14 col-252525 show-input-shipping" type="text" name="shemail" id="email">
                                <div class="clear pos-a t-11 l-15 f-14 show-div-shipping col-9a9a9a bg-white">电子邮件</div>
                            </div>
                            <div class="col-xs-6 text-center pl-10 pr-0 pos-r mt-15">
                                <input type="hidden" class="show-input-shipping-value" value="请输入您的备注">
                                <input class="full-w bor h-36 line-h-36 bor-col-B2B2B2 pl-15 family-h f-14 col-252525 show-input-shipping" type="text" id="guid">
                                <div class="clear pos-a t-11 l-15 f-14 show-div-shipping col-9a9a9a bg-white">备注</div>
                            </div>
                        </div>
                        <div class="clear full-w h-75 bg-f5f5f5 mt-10 pt-20 pb-20 line-h-35 text-center">
                            <button  class="full-h w-150 mr-10 bor-none bg-309DE2 hovbg-2D90CF col-white" id="addAddress">保存</button>
                            <button type="reset" class="full-h w-150 ml-10 bor-none bg-9a9a9a hovbg-666 col-white">重置</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- 修改收货地址 -->
        <div class="clear show-revise-shippingaddress affix t-0 l-0 z-999 full-wh rgba-60 dis-n">
            <div class="pos-a t-30s l-0 full-w">
                <div class="w-600 mg-0-auto clear pos-r bg-white show-revise-content">
                    <div class="pt-15 pb-15 line-h-30 pos-r f-18 pl-20 pr-20 col-4a4a4a full-w bg-f5f5f5">
                        修改收货地址
                        <img class="pos-a t-20 r-20 img-20 close-mod cur-p" src="<%=request.getContextPath() %>/resources/img/net_shopping/close.png" alt="">
                    </div>
                    <form class="clear pos-r shippingaddress-revise" action="">
                        <div class="clear pd-40">
                        	<input type="hidden" class="show-input-shipping-value inshaddrnum" value="" id="shaddrnum">
                            <div class="col-xs-6 text-center pl-0 pr-10 pos-r">
                                
                                <input type="hidden" class="show-input-shipping-value" value="请输入修改后的收货人姓名">
                                <input class="full-w bor h-36 line-h-36 bor-col-B2B2B2 pl-15 family-h f-14 col-252525 show-input-shipping inrename" type="text" name="shname" id="shname">
                                <div class="clear pos-a t-11 l-15 f-14 show-div-shipping col-9a9a9a bg-white">姓名</div>
                            </div>
                            <div class="col-xs-6 text-center pl-10 pr-0 pos-r">
                                <input type="hidden" class="show-input-shipping-value" value="请输入修改后的收货人手机号">
                                <input class="full-w bor h-36 line-h-36 bor-col-B2B2B2 pl-15 family-h f-14 col-252525 show-input-shipping inrephone" type="text" name="shphone" id="shphone">
                                <div class="clear pos-a t-11 l-15 f-14 show-div-shipping col-9a9a9a bg-white">手机号</div>
                            </div>
                            <div class="col-xs-12 text-center mt-15 pl-0 pr-0 pos-r">
                                <input type="hidden" class="show-input-shipping-value" value="请输入修改后的详细地址">
                                <textarea rows="2" cols="20" class="full-w bor line-h-36 bor-col-B2B2B2 pl-15 family-h f-14 col-252525 show-input-shipping inreaddress" type="text" name="shaddress" id="shaddress"></textarea>
                                <div class="clear pos-a t-11 l-15 f-14 show-div-shipping col-9a9a9a bg-white">详细地址</div>
                            </div>
                            <div class="col-xs-6 text-center pl-0 pr-10 pos-r mt-15">
                                <input type="hidden" class="show-input-shipping-value" value="请输入修改后的电子邮件">
                                <input class="full-w bor h-36 line-h-36 bor-col-B2B2B2 pl-15 family-h f-14 col-252525 show-input-shipping inreemail" type="text" name="shemail" id="shemail">
                                <div class="clear pos-a t-11 l-15 f-14 show-div-shipping col-9a9a9a bg-white">电子邮件</div>
                            </div>
                            <div class="col-xs-6 text-center pl-10 pr-0 pos-r mt-15">
                                <input type="hidden" class="show-input-shipping-value" value="请输入修改后的备注">
                                <input class="full-w bor h-36 line-h-36 bor-col-B2B2B2 pl-15 family-h f-14 col-252525 show-input-shipping inreabout" type="text" id="shguid">
                                <div class="clear pos-a t-11 l-15 f-14 show-div-shipping col-9a9a9a bg-white">备注</div>
                            </div>
                        </div>
                        <div class="clear full-w h-75 bg-f5f5f5 mt-10 pt-20 pb-20 line-h-35 text-center">
                            <button  class="full-h w-150 mr-10 bor-none bg-309DE2 hovbg-2D90CF col-white" id="updateAddresspost">保存</button>
                            <button type="button" class="full-h w-150 ml-10 bor-none bg-9a9a9a hovbg-666 col-white close-mod">取消</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- 收货地址已满 -->
        <div class="clear show-full-shippingaddress affix t-0 l-0 z-999 full-wh rgba-60 dis-n">
            <div class="pos-a t-30s l-0 full-w">
                <div class="w-600 mg-0-auto clear pos-r bg-white show-full-content">
                    <div class="pt-15 pb-15 line-h-30 pos-r f-18 pl-20 pr-20 col-4a4a4a full-w bg-f5f5f5">
                        收货地址已满
                        <img class="pos-a t-20 r-20 img-20 close-mod cur-p" src="<%=request.getContextPath() %>/resources/img/net_shopping/close.png" alt="">
                    </div>
                    <form class="clear pos-r" action="">
                        <div class="clear pd-40">
                            <p class="f-30 pt-60 pb-60 text-center">
                                抱歉，收货地址已满！
                            </p>
                        </div>
                        <div class="clear full-w h-75 bg-f5f5f5 mt-10 pt-20 pb-20 line-h-35 text-center">
                            <button type="button" class="full-h w-150 bor-none bg-309DE2 hovbg-2D90CF col-white close-mod">确定</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
	<%@ include file="../comm/footer.jsp" %> 
    <script src="<%=request.getContextPath() %>/resources/js/comm/jquery.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/comm/jquery.validate.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/comm/jquery.validate.messages_zh.js"></script>
    <script src="<%=request.getContextPath() %>/resources/ctrl/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/comm/base.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/shopping/HK_Order.js"></script>
	<script src="<%=request.getContextPath() %>/resources/wqc_js/order/order.js"></script>
</body>

</html>