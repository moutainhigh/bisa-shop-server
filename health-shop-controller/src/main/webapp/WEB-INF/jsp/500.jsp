<%@ page language="java" import="java.util.*"  pageEncoding="UTF-8"%>
<%@ include file="comm/tag.jsp" %>
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
    <title>碧沙康健_商品404页</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/error.css" />
</head>
<body>

		<div id="container">
			<div id = "error">
				<span>出现错误</span>
				<div id="message"><span class="errorContainer">${message }</span></div>
				<div id="message"><span class="errorContainer">${exception.message }</span></div>
				<div id="upPage"><a href="javascript:history.go(-1)">返回上一页</a></div>
			</div>
		</div>

</body>
</html>