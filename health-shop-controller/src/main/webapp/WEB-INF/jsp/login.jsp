<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <!DOCTYPE dwr PUBLIC "-//GetAhead Limited//DTD Direct Web Remoting 3.0//EN" "http://getahead.org/dwr//dwr30.dtd">
<html>
<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Login Here</title>
		<link href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" rel="stylesheet">
		<link href="<%=request.getContextPath() %>/resources/css/login.css" rel="stylesheet"><!--独立css文件-->
		<script src="<%=request.getContextPath() %>/resources/js/jquery-1.11.1.min.js"></script><!--独立js文件-->
		<script src="<%=request.getContextPath() %>/resources/js/bootstrap.min.js"></script><!--独立js文件-->
		<script src="http://cdn.bootcss.com/jquery-mockjax/1.6.2/jquery.mockjax.min.js"></script> <!--独立js文件 模拟实现-->
		<script src="<%=request.getContextPath() %>/resources/js/bootstrapValidator.min.js"></script> <!--独立js文件 验证手机号密码用户名的格式-->
		<style type="text/css"></style>
</head>
<body>
		<img src="<%=request.getContextPath() %>/resources/images/reg-bg.png" alt="" width="100%" height="100%" class="bg-img">
		<div class="container container_bg">
			<div id="loginBox" class="loginBox">
				<div class="login-content">
					<div class="phoneLogin wn_new_l_items" id="phoneLogin">
						<a href="#" class="dongtai">手机动态码登录（请选择国际区号）</a><!--手机动态码登录标题-->
						<form id="phoneSubmit" method="post" class="phoneSubmit bv-form" role="form" novalidate="novalidate" action="../l/phoneLogin">
							<ul class="formInput">
						        <li class="mobileLoginLi mobilenumberLi">
						        	<div class="form-group">
							            <div class="input-group">
											<span class="input-group-addon"><span class="glyphicon glyphicon-phone"></span></span><!--手机动态登录的图标-->
											<span class="input-group-addon"><!--选择手机号的地区-->
							            		<select class="selectpicker" id="selectpicker" name="selectpicker">
												  <option value="+86" name="中国大陆">中国</option>
												  <option value="+852">香港</option>
												  <option value="+853">澳门</option>
												  <option value="+886">台湾</option>
												</select>
							            	</span>
											<input type="text" class="form-control" id="accessname" name="accessname" placeholder="手机号" data-bv-field="accessname"><!--手机号输入框-->
											<input type="button" class="getcode" id="btnSendCode" name="btnSendCode" value="获取动态密码" onclick="sendMessage()"><!--发送验证码和重新发送按钮-->
										</div>
										<div class="adm_div" id="user_phone"></div><!--手机号格式后台验证,前台我已验证,需后台再验证一次,把验证结果填入-->
									<small data-bv-validator="notEmpty" data-bv-validator-for="accessname" class="help-block" style="display: none;">手机号不能为空！</small><small data-bv-validator="regexp" data-bv-validator-for="accessname" class="help-block" style="display: none;">请输入正确的手机号码！</small></div>
						        </li>
						        <li class="mobileLoginLi mobilecodeLi">
						        	<div class="form-group">
							            <div class="input-group">
								            <input type="text" class="form-control" id="icode" name="icode" placeholder="动态密码" data-bv-field="icode">
								            <span id="mobileCodeTip" class="wrong1"></span>
						            	</div>
										<div class="adm_div" id="password_user">${message}</div><!--动态密码格式后台验证,前台我已验证,需后台再验证一次,把验证结果填入-->
									<small data-bv-validator="notEmpty" data-bv-validator-for="icode" class="help-block" style="display: none;">密码不能为空！</small><small data-bv-validator="digits" data-bv-validator-for="icode" class="help-block" style="display: none;">只能是数字！</small><small data-bv-validator="stringLength" data-bv-validator-for="icode" class="help-block" style="display: none;">必须是6位数字!</small></div>
						        </li>
						        <li class="commitcode_new">
							        <input type="checkbox" id="isremember_id_new_mobile">
							        <span>下次自动登录</span><!--下次自动登录需后台实现-->
						        </li>
						        <li class="mobileLoginLi mobileBtnLi">
						            <button type="submit" id="loginMobileButton" class="submit btn btn-lg btn-primary btn-block">登录</button>
						        </li>
						    </ul>
						    <input type="hidden" name="l_type" value="1"> 
						<input type="hidden" value=""></form>
					</div>
					<div class="emailLogin wn_new_l_items" id="emailLogin" style="display: none;">
						<a href="#" class="dongtai">密码登录</a><!--密码登录标题-->
						  <form id="emailSubmit" method="post" class="emailSubmit bv-form" role="form"  novalidate="novalidate"> 
							<ul id="userlogin_ul" class="formInput">
					            <!---用户名---->
					            <li class="usernameliUser">
					            	<div class="form-group">
						            	<div class="input-group">
											<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
											<input type="text" class="form-control" id="accessname" name="accessname" placeholder="用户名" data-bv-field="accessname">
										</div>
										<div class="adm_div" id="user_email">${loginMessage}</div><!--用户名验证验证-->
									<small data-bv-validator="notEmpty" data-bv-validator-for="accessname" class="help-block" style="display: none;">用户名不能为空！</small><small data-bv-validator="stringLength" data-bv-validator-for="accessname" class="help-block" style="display: none;">用户名长度必须在2到11位之间</small><small data-bv-validator="regexp" data-bv-validator-for="accessname" class="help-block" style="display: none;">用户名只能包含大写、小写、数字和下划线</small></div>
					            </li>
					            <!--密码-->
					            <li class="passwordliUser">
					                <div class="form-group">
										<div class="input-group">
											<span class="input-group-addon"><span class="glyphicon glyphicon-certificate"></span></span>
											<input type="password" class="form-control" id="password" name="password" placeholder="密码" data-bv-field="password">
										</div>
										<div class="adm_div" id="password_email"></div><!--密码登录验证-->
									<small data-bv-validator="notEmpty" data-bv-validator-for="password" class="help-block" style="display: none;">密码不能为空！</small><small data-bv-validator="different" data-bv-validator-for="password" class="help-block" style="display: none;">密码和用户名不能一样</small><small data-bv-validator="regexp" data-bv-validator-for="password" class="help-block" style="display: none;">用户名只能包含大写、小写、数字和下划线</small><small data-bv-validator="stringLength" data-bv-validator-for="password" class="help-block" style="display: none;">密码长度必须是6位!</small></div>
					            </li>
					            <li class="commitcode_new">
					           	 	<a href="#" class="passwordonclick=">忘记密码</a><!--忘记密码需要重置密码,需要手机动态码和邮箱双重验证,后面我补回-->
					                <input type="checkbox" name="autologin">
					                <span>下次自动登录</span>    <!--下次自动登录需后台实现-->            
					            </li>
					            <li class="submit_new">
					                <button type="submit" id="btnSubmitUser" class="submit btn btn-lg btn-primary btn-block" >登录</button>
					            </li>
					        </ul>
					        <input type="hidden" name="l_type" value="2"> 
						<input type="hidden" value="">
						
					 	</form>
					</div>
				</div>
				<div id="thirdLogin" class="third-login">
	                <a class="qq-login" href="#"><i></i><span>手机登录</span></a><!--手机登录导航标题,用户切换页面-->
	                <a class="wx-login" href="#"><i></i><span>密码登录</span></a><!--密码登录导航标题,用户切换页面-->
	                <a class="wb-login" id="modal-188839" href="#modal-container-188839" role="button" data-toggle="modal"><!--微信登录导航标题,用户切换页面-->
	                	<i></i><span>微信登录</span>
	                </a>
				    <div class="modal fade" id="modal-container-188839" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"><!--隐藏的二维码,点击微信登录时弹出-->
				        <div class="modal-dialog">
				          <div class="modal-content">
				            <div class="modal-header">
				              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button><!--点击关闭二维码弹出框-->
				              <h4 class="modal-title" id="myModalLabel">
				              	  微信登录
				              </h4>
				            </div>
				            <div class="modal-body">
				              <img class="img-responsive" src="<%=request.getContextPath() %>/resources/images/dl_weixin.jpg" width="200" height="200"><!--二维码图片-->
				            </div>
					        <div class="wx-qrcode-txt">
					            <i></i>请使用微信扫一扫
					        </div>
				          </div>
				        </div>
				    </div>
	            </div>
			</div>
		</div>
		<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/login.js"></script>
	    
</body>
</html>