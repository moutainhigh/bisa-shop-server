<%@ page language="java"  pageEncoding="UTF-8"%>
	<div class="col-sm-3 pl-30 pr-20">
        <div class="clear bg-white pd-40-10-ipad">
                <p class="mt-10 mb-10 col-212121 f-30 line-h-40 cur-d">
                    订单中心
                </p>
                <p class="col-757575 f-20-16-ipad line-h-25 mt-40 mb-20 cur-p hovecol-309DE2 <% if("userOrder".equals(menuType)){ %>col-active<% } %> user-munu user-order">
                  我的订单
                </p>
                <p class="col-757575 f-20-16-ipad line-h-25 mt-20 mb-20 cur-p hovecol-309DE2 <% if("userApprise".equals(menuType)){ %>col-active<% } %> user-munu user-appraise">
        	评价晒单
                </p>
                <p class="mt-30 mb-30 col-212121 f-30 line-h-40 cur-d">
                    个人中心
                </p>
                <p class="col-757575 f-20-16-ipad line-h-25 mt-20 mb-20 cur-p hovecol-309DE2 user-munu user-center">
                    我的个人中心
                </p>
                <p class="col-757575 f-20-16-ipad line-h-25 mt-20 mb-20 cur-p hovecol-309DE2  <% if("userActive".equals(menuType)){ %>col-active<% } %> user-munu user-active">
                    激活服务
                </p>
                <p class="col-757575 f-20-16-ipad line-h-25 mt-20 mb-20 cur-p hovecol-309DE2 <% if("userAddress".equals(menuType)){ %>col-active<% } %> user-munu user-address">
                    收货地址
                </p>
                <p class="col-757575 f-20-16-ipad line-h-25 mt-20 mb-20 cur-p hovecol-309DE2 user-munu user-password">
                    账号安全
                </p>
            </div>

	</div>