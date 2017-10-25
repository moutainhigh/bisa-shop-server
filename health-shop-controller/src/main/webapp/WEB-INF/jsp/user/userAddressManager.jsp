<%@ page language="java" pageEncoding="utf-8"%>
<%@ page import="com.bisa.health.model.SystemContext" %>
<%@ include file="../comm/tag.jsp" %>
<%  String menuType="userAddress"; %>

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
    <title>碧沙康健_地址管理</title>
    <!-- base -->
    <link href="<%=request.getContextPath() %>/resources/ctrl/Font-Awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/ctrl/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/comm/base.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/user/HK_Order.css" rel="stylesheet">
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
    <div class="wrap clear">
        <div class="container pl-0 pr-0">
            <div class="clear">
                <p class="pt-10 pb-10 pl-15 pr-15 line-h-20 cur-d ">
                    <a class="col-666 t-nonehove hovecol-309DE2" href="">首页 </a> >
                    <span class="col-252525 t-nonehove">收货地址</span>
                </p>
            </div>
        </div>
        <div class="clear full-w">
            <img class="full-w" src="<%=request.getContextPath() %>/resources/img/news/HK_NewsIndex/banner.jpg" alt="">
        </div>
        <div class="container pl-0 pr-0 mt-30 clear bg-f5f5f5 pt-30 pb-70 mb-60">
          <%@ include file="./comm/menu.jsp" %>
            <div class="clear col-sm-9 pr-30 pl-0">
                <div class="clear bg-white pb-280 plr-50-10-ipad">
                    <p class="pt-40-20-ipad f-50-40-ipad col-757575 line-h-70-50-ipad pb-20">
                        服务管理
                    </p>
                    <div class="clear bor bor-b bor-col-f5f5f5">
                    </div>
	                    <div class="clear pt-30">
                    	<c:forEach var="addressList" items="${addressList}">
	                        <div class="clear col-sm-4 pl-5 pr-5 pt-10 pb-10 address-tips cur-d">
	                            <div class="clear bor bor-col-7a7a7a pd-10 min-h-160 address-tips-in">
	                                <p class="f-18 col-252525 text-line-1">
	                                    ${addressList.name}
	                                </p>
	                                <p class="f-14 col-555 mt-25 text-line-1">
	                                   ${addressList.tel}
	                                </p>
	                                <p class="f-14 col-555 line-h-25 mt-10 text-line-2">
	                                    ${addressList.address}
	                                </p>
	                                <p class="clear min-h-20">
	                                    <span class="pull-right col-309DE2 f-14 mt-3 cur-p dis-n address-tips-edit">修改</span>
	                                     <input type="hidden" class="add-addr_num" value="${addressList.addr_num}">
	                                    <input type="hidden" class="add-name" value=" ${addressList.name}">
	                                    <input type="hidden" class="add-phone" value="${addressList.tel}">
	                                    <input type="hidden" class="add-area" value="${addressList.county}">
	                                    <input type="hidden" class="add-address" value="${addressList.address}">
	                                    <input type="hidden" class="add-email" value="${addressList.email}">
	                                </p>
	                            </div>
	                        </div>
	                       
	                    </c:forEach> 
                        <div class="clear col-sm-4 pl-5 pr-5 pt-10 pb-10 address-tipsv2">
                            <div class="clear bor bor-col-7a7a7a pd-10 min-h-160 cur-p address-tipsv2-in add-address-control">
                                <div class="clear pt-20 text-center">
                                    <div class="clear img-60 full-radius dis-ib bg-b2b2b2 line-h-60 col-white f-30 address-tipsv2-circle">
                                        <i class=" icon-plus f-20 col-white pos-r t--3"></i>
                                    </div>
                                </div>
                                <p class="text-center mt-10 f-14 col-b2b2b2 address-tipsv2-text">
                                    添加新地址
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
   	<%@ include file="../comm/footer.jsp" %> 
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
                        <div class="clear full-w">
                            <div class="col-xs-6 text-center pl-0 pr-10 pos-r">
                                <input type="hidden" class="show-input-shipping-value" value="请输入收货人姓名">
                                <input class="full-w bor h-36 line-h-36 bor-col-B2B2B2 pl-15 family-h f-14 col-252525 show-input-shipping" type="text" name="shname" id="shname">
                                <div class="clear pos-a t-11 l-15 f-14 show-div-shipping col-9a9a9a bg-white">姓名</div>
                            </div>
                            <div class="col-xs-6 text-center pl-10 pr-0 pos-r">
                                <input type="hidden" class="show-input-shipping-value" value="请输入收货人手机号">
                                <input class="full-w bor h-36 line-h-36 bor-col-B2B2B2 pl-15 family-h f-14 col-252525 show-input-shipping" type="text" name="shphone" id="shphone">
                                <div class="clear pos-a t-11 l-15 f-14 show-div-shipping col-9a9a9a bg-white">手机号</div>
                            </div>
                        </div>
                        <div class="clear full-w">
                            <div class="col-xs-6 text-center pl-0 pr-10 pos-r mt-15">
                                <input type="hidden" class="show-input-shipping-value" value="请输入您的电子邮件">
                                <input class="full-w bor h-36 line-h-36 bor-col-B2B2B2 pl-15 family-h f-14 col-252525 show-input-shipping" type="text" name="shemail" id="shemail">
                                <div class="clear pos-a t-11 l-15 f-14 show-div-shipping col-9a9a9a bg-white">电子邮件</div>
                            </div>
                            <div class="col-xs-6 text-center pl-10 pr-0 pos-r mt-15">
	                                <select class="full-w bor h-36 line-h-36 bor-col-B2B2B2 pl-15 family-h f-14 col-252525 show-input-shipping" name="sharea" id="sharea">
		                            	<c:forEach var="areaList" items="${areaList}">
			                                  <option value="${areaList.area_name}">${areaList.area_name}</option>
			                            </c:forEach>
	                                </select>
                            </div>
                        </div>
                        <div class="col-xs-12 text-center mt-15 pl-0 pr-0 pos-r">
                            <input type="hidden" class="show-input-shipping-value" value="请输入您的详细地址">
                            <textarea rows="2" cols="20" class="full-w bor line-h-36 bor-col-B2B2B2 pl-15 family-h f-14 col-252525 show-input-shipping" type="text" name="shaddress" id="shaddress"></textarea>
                            <div class="clear pos-a t-11 l-15 f-14 show-div-shipping col-9a9a9a bg-white">详细地址</div>
                        </div>
                    </div>
                    <div class="clear full-w h-75 bg-f5f5f5 mt-10 pt-20 pb-20 line-h-35 text-center">
                        <button type="submit" class="full-h w-150 mr-10 bor-none bg-309DE2 hovbg-2D90CF col-white add-useraddress">保存</button>
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
                        <div class="full-w clear">
                            <div class="col-xs-6 text-center pl-0 pr-10 pos-r">
                                <input class="inreaddr_num" type="hidden" value="" id="upaddrnum">
                                <input type="hidden" class="show-input-shipping-value" value="请输入收货人姓名">
                                <input class="full-w bor h-36 line-h-36 bor-col-B2B2B2 pl-15 family-h f-14 col-252525 show-input-shipping inrename" type="text" name="shname" id="upname">
                                <div class="clear pos-a t-11 l-15 f-14 show-div-shipping col-9a9a9a bg-white">姓名</div>
                            </div>
                            <div class="col-xs-6 text-center pl-10 pr-0 pos-r">
                                <input type="hidden" class="show-input-shipping-value" value="请输入收货人手机号">
                                <input class="full-w bor h-36 line-h-36 bor-col-B2B2B2 pl-15 family-h f-14 col-252525 show-input-shipping inrephone" type="text" name="shphone" id="upphone">
                                <div class="clear pos-a t-11 l-15 f-14 show-div-shipping col-9a9a9a bg-white">手机号</div>
                            </div>
                        </div>
                        <div class="clear full-w">
                            <div class="col-xs-6 text-center pl-0 pr-10 pos-r mt-15">
                                <input type="hidden" class="show-input-shipping-value" value="请输入您的电子邮件">
                                <input class="full-w bor h-36 line-h-36 bor-col-B2B2B2 pl-15 family-h f-14 col-252525 show-input-shipping inreemail" type="text" name="shemail" id="upemail">
                                <div class="clear pos-a t-11 l-15 f-14 show-div-shipping col-9a9a9a bg-white">电子邮件</div>
                            </div>
                            <div class="col-xs-6 text-center pl-10 pr-0 pos-r mt-15">
	                                <select class="full-w bor h-36 line-h-36 bor-col-B2B2B2 pl-15 family-h f-14 col-252525 show-input-shipping inrearea" name="sharea" id="uparea">
		                            	<c:forEach var="areaList" items="${areaList}">
			                                   <option value="${areaList.area_name}">${areaList.area_name}</option>
			                            </c:forEach>
	                                </select>
                            </div>
                        </div>
                        <div class="col-xs-12 text-center mt-15 pl-0 pr-0 pos-r">
                            <input type="hidden" class="show-input-shipping-value" value="请输入您的详细地址">
                            <textarea rows="2" cols="20" class="full-w bor line-h-36 bor-col-B2B2B2 pl-15 family-h f-14 col-252525 show-input-shipping inreaddress" type="text" name="shaddress" id="upaddress"></textarea>
                            <div class="clear pos-a t-11 l-15 f-14 show-div-shipping col-9a9a9a bg-white">详细地址</div>
                        </div>
                    </div>
                    <div class="clear full-w h-75 bg-f5f5f5 mt-10 pt-20 pb-20 line-h-35 text-center">
                        <button type="submit" class="full-h w-150 mr-10 bor-none bg-309DE2 hovbg-2D90CF col-white">保存</button>
                        <button type="reset" class="full-h w-150 ml-10 bor-none bg-9a9a9a hovbg-666 col-white">重置</button>
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
    <script src="<%=request.getContextPath() %>/resources/js/comm/jquery.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/comm/jquery.validate.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/comm/jquery.validate.messages_zh.js"></script>
    <script src="<%=request.getContextPath() %>/resources/ctrl/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/comm/base.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/user/HK_AddressManage.js"></script>
    <script src="<%=request.getContextPath() %>/resources/wqc_js/user/comm/menu.js"></script>

</body>

</html>