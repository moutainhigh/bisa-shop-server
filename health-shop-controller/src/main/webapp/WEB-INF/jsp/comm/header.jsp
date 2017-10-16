<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="user" value='<%=request.getParameter("user")%>'></c:set>

<header class="clear full-w min-h-120">
        <div class="container">
            <div class="col-xs-2 pt-35 pb-35 pl-0 pr-0">
                <img src="<%=request.getContextPath()%>/resources/img/index/logov1.png" alt="">
            </div>
            <div class="clear col-xs-10 pl-0 pr-0">
                <div class="col-xs-12 pt-20 pl-0 pr-0">
                    <ul class="clear h-30 line-h-30 pull-right">
						<c:if test="${username!=null}">                    
                        <li class="pull-left pr-10"><a class="col-333 hovecol-black" href="#">${username}</a></li>              
                        </c:if>
                        <c:if test="${username==null}">                    
                        <li class="pull-left pr-10"><a class="col-333 hovecol-black" href="../l/register">注册</a></li>
                        <li class="pull-left pr-10"><a class="col-333 hovecol-black" href="../login">登录</a></li>
                        </c:if>
                        <li class="pull-left pr-10"><a class="col-333 hovecol-black" href="">简</a></li>
                        <li class="pull-left pr-10"><a class="col-333 hovecol-black" href="">繁</a></li>
                        <li class="pull-left pr-5 col-333 cur-d hovecol-black">
                        <i class="icon-shopping-cart pr-5 f-14 col-333 hovecol-black"></i>
                            购物车(
                        <a class="col-333" href="">0</a>
                        )
                        </li>
                        <li class="pull-left pr-5 pl-5 bg-eee hovebg-ddd mainsearch">
                            <input type="text" class="h-26 line-h-26 w-100 mt--2 mb-2 bor bor-col-ccc dis-n mainsearchinput">
                            <span class="col-333 t-nonehove cur-p" href=""><i class="icon-search pr-5 f-14"></i>搜索</span>
                        </li>
                    </ul>
                </div>
                <div class="col-xs-12 pt-15 pl-0 pr-0">
                    <ul class="col-xs-10 clo-md-9 pull-left mainnav clear dis-ib pl-0 pr-0">
                        <li class="col-xs-2 text-center f-14 cur-p pd-10 f-w"><a id="1000A" class="col-309DE2 t-nonehove pb-7" href="<%=request.getContextPath()%>/l/index">首页</a></li>
                        <li class="col-xs-2 text-center f-14 cur-p pd-10 f-w"><a id="2000A" class="col-309DE2 t-nonehove pb-7" href="<%=request.getContextPath()%>/l/aboutBis">关于碧沙</a></li>
                        <li class="col-xs-2 text-center f-14 cur-p pd-10 f-w"><a id="3000A" class="col-309DE2 t-nonehove pb-7" href="<%=request.getContextPath()%>/l/shopping">网上商店</a></li><!-- shopping/HK_shopping.html -->
                        <li class="col-xs-2 text-center f-14 cur-p pd-10 f-w"><a id="4000A" class="col-309DE2 t-nonehove pb-7" href="<%=request.getContextPath()%>/l/healthInquiry">健康咨讯</a></li>
                        <li class="col-xs-2 text-center f-14 cur-p pd-10 f-w"><a id="5000A" class="col-309DE2 t-nonehove pb-7" href="<%=request.getContextPath()%>/l/shoppingGuide">购物指南</a></li>
                        <li class="col-xs-2 text-center f-14 cur-p pd-10 f-w"><a id="6000A" class="col-309DE2 t-nonehove pb-7" href="<%=request.getContextPath()%>/l/contactUs">联络我们</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </header>