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
    <title>碧沙康健_我的购物车</title>
    <!-- base -->
    <link href="<%=request.getContextPath() %>/resources/ctrl/Font-Awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/comm/bootstrap.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/comm/base.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/index/index.css" rel="stylesheet">
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
</head>
<body>
	<%@ include file="../comm/header.jsp" %> 
    <div class="wrap min-h-40">
        <div class="container pl-0 pr-0">
            <p class="pt-10 pb-10 pl-15 pr-15 line-h-20 bg-f5f5f5 cur-d">
                <a class="col-666 t-nonehove hovecol-309DE2" href="">首页 </a>
                >
                <a class="col-333 t-nonehove hovecol-309DE2" href="">购物车</a>
            </p>
            <p class="col-252525 f-26 pd-20 ">
                我的购物车
            </p>
            <div class="clear full-w bg-f5f5f5 pd-15 cur-d">
                <!-- 列表菜单 -->
                <!-- 全选的是否被选择为类is-checkall,单选的是否被选择为is-checkbox，禁止选择类是stop-check和隐藏类dis-n一起使用。没有这些选项的类默认为未选中. -->
                <div class="clear full-w bg-white">
                    <div class="clear col-md-2 col-sm-1 pl-0 pr-0 pt-20 pb-20 line-h-30">
                        <div class="clear col-sm-8 pl-0 pr-0">
                            <div class="img-25-20-ipad pull-right bg-9a9a9a bg-activate text-center mt-3-5-ipad car-checkall is-checkall">
                                <img class="pos-r t--4--6-ipad img-20-15-ipad cur-p" src="<%=request.getContextPath() %>/resources/img/net_shopping/ico_ok.png" alt="">
                            </div>
                        </div>
                        <div class="clear col-sm-4 pl-0 pr-0 text-center col-252525 f-16 hidden-sm">
                            全选
                        </div>
                    </div>
                    <div class="clear col-md-3 col-sm-4 pl-0 pr-0 pt-20 pb-20 line-h-30 text-center col-252525 f-16">商品名称</div>
                    <div class="clear col-sm-1 pl-0 pr-0 pt-20 pb-20 line-h-30 text-right pr-15 col-252525 f-16">单价</div>
                    <div class="clear col-sm-2 pl-0 pr-0 pt-20 pb-20 line-h-30 text-center col-252525 f-16">数量</div>
                    <div class="clear col-sm-2 pl-0 pr-0 pt-20 pb-20 line-h-30 text-right pr-40 col-252525 f-16">小计</div>
                    <div class="clear col-sm-2 pl-0 pr-0 pt-20 pb-20 line-h-30 pl-40 col-252525 f-16">操作</div>
                </div>
                <!-- 套餐部分 -->
                <!-- 套餐外框架需要隐藏的时候把dis-n放到外框层即是car-combo层。把stop-check放到car-kind层 -->
                <div class="clear full-w car-combo">
                    <!-- 套餐外循环 -->
                    <c:forEach var="listcart" items="${listcart }">
                        <c:if test="${listcart.sing_cox=='1' }">
                        
                            <div class="clear full-w bg-white mt-4 mb-4">
                                <div class="clear full-w pl-0 pr-0 mb-10 car-kinds is-checkbox">
                                    <div class="clear col-md-2 col-sm-1 pl-0 pr-0 pt-10 pb-10 line-h-30">
                                        <div class="clear col-sm-8 pl-0 pr-0 pt-20 pb-20">
                                            <div class="img-25-20-ipad pull-right bg-9a9a9a bg-activate cur-p text-center mt-3-5-ipad car-checktips is-check">
                                                <img class="pos-r t--4--6-ipad img-20-15-ipad cur-p" src="<%=request.getContextPath() %>/resources/img/net_shopping/ico_ok.png" alt="">
                                            </div>
                                        </div>
                                        <div class="clear col-sm-4 pl-0 pr-0 pt-20 pb-20 text-center col-252525 f-16">
                                        </div>
                                    </div>
                                    <div class="clear col-md-3 col-sm-4 pl-0 pr-0 pt-10 pb-10 line-h-30 text-center col-252525 f-16-14-ipad">
                                        <div class="clear col-sm-3 pl-0 pr-0 pos-r pt-0-5-ipad">
                                            <img class="full-w cart-maintips-img" src="<%=request.getContextPath() %>/resources/${listcart.main_picture }" alt="">
                                            <div class="clear pos-a b--21--30-ipad l-25-20-ipad img-25 triangle-cart-up">
                                            </div>
                                        </div>
                                        <div class="clear col-sm-9 pl-0 pr-0 pt-20 pb-20 text-left pl-15">
                                            <span class="col-252525 cart-maintips-dir">${listcart.title }</span>
                                        </div>
                                    </div>
                                    <div class="clear col-sm-1 pl-0 pt-30 pb-30 line-h-30 text-right pr-15-0-ipad col-252525 f-16-14-ipad">
                                        <!-- 单价 -->
                                        <span class="col-252525 cart-price-show"></span>元
                                    </div>
                                    <div class="clear col-sm-2 pl-0 pr-0 pt-30 pb-30 line-h-30 text-center col-252525 f-16">
                                        <div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2 pos-r pl-0 pr-0 line-h-20 h-20 mt-5 mb-5">
                                            <!-- 物品的信息JS获取用 -->
                                            <input class="cart-tips-id" type="hidden" value="${listcart.packId }">
                                            <input class="cart-price" type="hidden" value="${listcart.price }">
                                            <span class="pos-a img-20 t-2 l-5 f-16 f-w select-none cur-p cart-combo-min">-</span>
                                            <input class="full-w bor-col-B2B2B2 bor text-center focus-input-pri cart-combo-textbox" maxlength="2" type="text" value="${listcart.number}">
                                            <span class="pos-a img-20 t-2 r-5 f-16 f-w select-none cur-p cart-combo-add">+</span>
                                        </div>
                                    </div>
                                    <div class="clear col-sm-2 pl-0 pr-0 pt-30 pb-30 line-h-30 text-right pr-40 col-309DE2 f-16-14-ipad">
                                        <span class="col-309DE2 cart-total"></span>元
                                    </div>
                                    <div class="clear col-sm-2 pl-0 pr-0 pt-30 pb-30 line-h-30 pl-40 col-252525 f-16">
                                        <span class="img-30 pd-5 cur-p car-tipsdel">
                                            <img class="img-20" src="<%=request.getContextPath() %>/resources/img/net_shopping/close.png" alt="">
                                        </span>
                                    </div>
                                </div>
                                <c:forEach var="list" items="${mapPackdetails }">
                                	<c:if test="${list.key eq listcart.packId }">
                                		<c:forEach var="listPackdetails" items="${list.value }">
		                                    <div class="clear col-sm-12 pl-0 mb-10 pr-0 f-14-12-ipad bg-white h-60-40-ipad line-h-60-40-ipad car-combo-tips">
		                                        <!-- 本套餐的部分信息 -->
		                                        <input class="car-combo-tips-id" type="hidden" value="${listPackdetails.pack_number }">
		                                        <div class="clear col-sm-4 col-sm-offset-1 col-md-3 col-md-offset-2 bg-eee pl-0 pr-0">
		                                            <div class="clear col-sm-3 pl-0 pr-0 ">
		                                                <div class="clear img-40-30-ipad pull-left bg-white ml-15 mt-10-5-ipad mb-10-5-ipad">
		                                                    <img class="img-30-20-ipad dis-ib pull-left mg-5" src="<%=request.getContextPath() %>/resources/${listPackdetails.main_picture}" alt="">
		                                                </div>
		                                            </div>
		                                            <div class="clear col-sm-9 pl-0 pr-0 text-left pl-15 f-14">
		                                                <span class="col-252525">${listPackdetails.pack_name }</span>
		                                            </div>
		                                        </div>
		                                        <div class="clear col-sm-1 bg-eee pl-0 text-right pr-15 col-252525 t-through">
		                                            <span class="col-252525 car-combo-tips-unp">${listPackdetails.pack_price }</span>元
		                                        </div>
		                                        <div class="clear col-sm-2 bg-eee pl-0 pr-0 text-center h-60-40-ipad">
		                                            <span class="col-252525 car-combo-tips-numcase"></span>
		                                        </div>
		                                        <div class="clear col-sm-2 bg-eee pl-0 text-right pr-40 col-309DE2 t-through">
		                                            <span class="col-309DE2 car-combo-tips-tot"></span>元
		                                        </div>
		                                        <div class="clear col-sm-1 bg-eee pl-0 pr-0 h-60-40-ipad">
		                                        </div>
		                                    </div>
		                                    </c:forEach>
                                    </c:if>
                               </c:forEach>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
                <!-- 单品部分 -->
                <!-- 套餐外框架需要隐藏的时候把dis-n放到外框层,即是car-single层。把stop-check放到car-kind层 -->
                <!-- 这样就是说明隐藏的外层，内层不可被选择 -->
                <div class="clear full-w car-single">
                    <c:forEach var="listcart" items="${listcart }">
                        <c:if test="${listcart.sing_cox=='0' || listcart.sing_cox=='2' }">
                            <!-- 单品外循环 -->
                            <div class="clear full-w bg-white mt-4 mb-4 car-kinds is-checkbox">
                                <div class="clear col-md-2 col-sm-1 pl-0 pr-0 pt-10 pb-10 line-h-30">
                                    <div class="clear col-sm-8 pl-0 pr-0 pt-20 pb-20">
                                        <div class="img-25-20-ipad pull-right bg-9a9a9a bg-activate cur-p text-center mt-3-5-ipad car-checktips is-check">
                                            <img class="pos-r t--4--6-ipad img-20-15-ipad cur-p" src="<%=request.getContextPath() %>/resources/img/net_shopping/ico_ok.png" alt="">
                                        </div>
                                    </div>
                                    <div class="clear col-sm-4 pl-0 pr-0 pt-20 pb-20 text-center col-252525 f-16">   
                                    </div>
                                </div>
                                <div class="clear col-md-3 col-sm-4 pl-0 pr-0 pt-10 pb-10 line-h-30 text-center col-252525 f-16-14-ipad">
                                    <div class="clear col-sm-3 pl-0 pr-0 pt-0-5-ipad">
                                        <img class="full-w cart-maintips-img" src="<%=request.getContextPath() %>/resources/${listcart.main_picture}" alt="">
                                    </div>
                                    <div class="clear col-sm-9 pl-0 pr-0 pt-20 pb-20 text-left pl-15">
                                        <span class="col-252525 cart-maintips-dir">${listcart.title}</span>
                                    </div>
                                </div>
                                <div class="clear col-sm-1 pl-0 pt-30 pb-30 line-h-30 text-right pr-15-0-ipad col-252525 f-16-14-ipad">
                                    <!-- 单价 -->
                                    <span class="col-252525 cart-price-show"></span>元
                                </div>
                                <div class="clear col-sm-2 pl-0 pr-0 pt-30 pb-30 line-h-30 text-center col-252525 f-16">
                                    <div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2 pos-r pl-0 pr-0 line-h-20 h-20 mt-5 mb-5">
                                        <!-- 物品的信息JS获取用 -->
                                        <input class="cart-tips-id" type="hidden" value="${listcart.packId }">
                                        <input class="cart-price" type="hidden" value="${listcart.price}">
                                        <span class="pos-a img-20 t-2 l-5 f-16 f-w select-none cur-p cart-min">-</span>
                                        <input class="full-w bor-col-B2B2B2 bor text-center focus-input-pri cart-textbox" maxlength="2" type="text" value="${listcart.number }">
                                        <span class="pos-a img-20 t-2 r-5 f-16 f-w select-none cur-p cart-add">+</span>
                                    </div>
                                </div>
                                <div class="clear col-sm-2 pl-0 pr-0 pt-30 pb-30 line-h-30 text-right pr-40 col-309DE2 f-16-14-ipad">
                                    <span class="col-309DE2 cart-total"></span>元
                                </div>
                                <div class="clear col-sm-2 pl-0 pr-0 pt-30 pb-30 line-h-30 pl-40 col-252525 f-16">
                                    <span class="img-30 pd-5 cur-p car-tipsdel">
                                        <img class="img-20" src="<%=request.getContextPath() %>/resources/img/net_shopping/close.png" alt="">
                                    </span>
                                </div>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
                <!-- 服务选项 -->
                <div class="clear mt-15 mb-15">
                    <!-- 服务选项一 -->
                    <c:forEach var="comm" items="${comm }" varStatus="Status">
                        <c:if test="${ Status.index=='0'}">
                            <div class="clear full-w bg-white mt-4 mb-4 servecontrol servecontrolv1">
                                <input class="cart-serve-cid" type="hidden" value="${comm.shop_number }" name="serveOne">
                                <div class="clear w11s pl-0 pr-0 pt-10 pb-10 line-h-30 pull-left">
                                    <div class="img-25 pull-right bg-9a9a9a bg-activate text-center mt-3 full-radius bg-f5f5f5 cur-p car-servecontrolv1-add">
                                        <i class="icon-plus col-white f-14 pos-r t--2 car-del-fuwuid"></i>
                                    </div>
                                </div>
                                <div class="clear pull-left pl-15 pr-0 pt-10 pb-10 line-h-30 col-252525 f-14">
                                    <span class="col-252525">${comm.sub_description }</span>
                                    <a class="hovecol-309DE2 t-nonehove pl-5" href="">查看服务细节</a>
                                </div>
                            </div>
                        </c:if>
                        <!-- 服务选项二 -->
                        <c:if test="${ Status.index=='1'}">
                            <div class="clear full-w bg-white mt-4 mb-4 servecontrol servecontrolv2">
                                <input class="cart-serve-cid" type="hidden" value="${comm.shop_number }"  name="servetwo">
                                <div class="clear w11s pl-0 pr-0 pt-10 pb-10 line-h-30 pull-left">
                                    <div class="img-25 pull-right bg-9a9a9a bg-activate text-center mt-3 full-radius bg-f5f5f5 cur-p car-servecontrolv2-add">
                                        <i class="icon-plus col-white f-14 pos-r t--2 car-del-fuwuid"></i>
                                    </div>
                                </div>
                                <div class="clear pull-left pl-15 pr-0 pt-10 pb-10 line-h-30 col-252525 f-14">
                                    <span class="col-252525">${comm.sub_description }</span>
                                    <a class="hovecol-309DE2 t-nonehove pl-5" href="">查看服务细节</a>
                                </div>
                            </div>
                        </c:if>
                        <!-- 服务选项三 -->
                        <c:if test="${ Status.index=='2'}">
                            <div class="clear full-w bg-white mt-4 mb-4 servecontrol servecontrolv3">
                                <input class="cart-serve-cid" type="hidden" value="${comm.shop_number }"  name="servethree">
                                <div class="clear w11s pl-0 pr-0 pt-10 pb-10 line-h-30 pull-left">
                                    <div class="img-25 pull-right bg-9a9a9a bg-activate text-center mt-3 full-radius bg-f5f5f5 cur-p car-servecontrolv3-add">
                                        <i class="icon-plus col-white f-14 pos-r t--2 car-del-fuwuid"></i>
                                    </div>
                                </div>
                                <div class="clear pull-left pl-15 pr-0 pt-10 pb-10 line-h-30 col-252525 f-14">
                                    <span class="col-252525">${comm.sub_description }</span>
                                    <a class="hovecol-309DE2 t-nonehove pl-5" href="">查看服务细节</a>
                                </div>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
                <!-- 结算 -->
                <div class="clear full-w bg-white mb-30 mt-15">
                    <div class="clear col-lg-3 col-lg-offset-1 pl-0 pr-0 h-60 line-h-60 col-252525 f-16 hidden-sm hidden-md">
                        <span class="col-252525">继续购物</span>
                        <span class="col-252525 pl-5 pr-5">|</span>
                        <span class="col-252525">共</span>
                        <span class="col-309DE2 tot-num-of-kinds"></span>
                        <span class="col-252525">件商品，已选则</span>
                        <span class="col-309DE2 tot-num-of-goods"></span>
                        <span class="col-252525">件</span>
                    </div>
                    <div class="clear col-sm-8 col-sm-offset-1 col-md-6 col-md-offset-3 col-lg-5 col-lg-offset-0 pl-0 pr-0 h-60 line-h-55 col-252525 f-16 pl-25">
                        <span class="col-252525 ">活动优惠:减</span>
                        <span class="col-252525 pl-5 pr-5">0</span>
                        <span class="col-252525">元</span>
                        <span class="col-252525 pl-5 pr-5">|</span>
                        <span class="col-309DE2 ">合计（不含运费）:</span>
                        <span class="col-309DE2 f-24 tot-num-of-totprice"></span>
                        <span class="col-309DE2 ">元</span>
                    </div>
                    <div class="clear col-sm-3 pl-0 pr-0 line-h-60 h-60">
                        <form action="<%=request.getContextPath()%>/l/orderIndex" method="Post">
                            <input class="HK-cartsubmitinput" type="hidden" name="data" value="">
                            
                            <button class="bor-none full-wh bg-309DE2 col-white f-24 text-center pos-r t--2 hovbg-38B3FF HK-cartsubmit" type="submit">
                                去结算
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- 弹出层 -->
    <!-- 普通弹出层 -->
    <div class="clear show-carisdel affix t-0 l-0 z-999 full-wh rgba-30 dis-n">
        <div class="pos-a t-30s l-0 full-w">
            <div class="w-400 mg-0-auto clear pos-r bg-white carisdel-content">
                <div class="pt-15 pb-15 line-h-30 pos-r f-18 pl-20 pr-20 col-4a4a4a full-w bg-f5f5f5">
                    确定删除此商品么？
                    <img class="pos-a t-20 r-20 img-20 close-mod cur-p" src="<%=request.getContextPath() %>/resources/img/net_shopping/close.png" alt="">
                </div>
                <div class="clear full-w bg-white pt-20 pb-20">
                    <!-- 需要删除物品的id -->
                    <input class="show-carisdelid" name="deleteId" type="hidden" value="">
                    <div class="col-sm-6 text-center">
                        <button class="bor-none bg-309DE2 col-white f-16 pt-5 pb-5 pl-20 pr-20 text-center pos-r t--2 hovbg-38B3FF del-product" >确定</button>
                    </div>
                    <div class="col-sm-6 text-center">
                        <button class="bor-none bg-309DE2 col-white f-16 pt-5 pb-5 pl-20 pr-20 text-center pos-r t--2 hovbg-38B3FF close-mod ">取消</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
      <%@ include file="../comm/footer.jsp" %> 
    <script src="<%=request.getContextPath() %>/resources/js/comm/jquery.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/comm/bootstrap.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/comm/base.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/shopping/HK_cart.js"></script>
     <script src="<%=request.getContextPath() %>/resources/wqc_js/Cart.js"></script>
</body>

</html>