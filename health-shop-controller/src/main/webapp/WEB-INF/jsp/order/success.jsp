<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/comm/bootstrap.min.css">
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/comm/jquery.min.js" ></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/zhifu3.css"><!--报告列表样式-->
</head>
<body>
<body>	
	<div class="container-fluid" id="wrapper" >
		<div class="main row">
			<div class="imgby col-md-12">
				<img class="img-content" src="<%=request.getContextPath() %>/resources/images/pay_status3.png" class="img-responsive"> 
			</div>
			<div class="conbody container-fluid">
				<div class="panel-body col-md-12" style="padding-top:40px;" align="center" >
		          	<!--二维码-->
	            	<input type="image" src="<%=request.getContextPath() %>/resources/images/gmcg.png" width="auto" style="padding-top:5px;"><br>
	               <!--  <a href="http://17a6315d87.iask.in/bisa-teamb-controller/service/serviceIndex"> -->
	                <a  class="btn btn-info btn-lg" href="http://17a6315d87.iask.in/bisa-teamb-controller/service/serviceIndex" target="form-content" style="width:200px; margin-top:10px; margin-bottom:10px;">查看订单</a>
	              <!--   </a> -->
		        </div>
			</div>
		</div>
	</div>
</body>
</html>