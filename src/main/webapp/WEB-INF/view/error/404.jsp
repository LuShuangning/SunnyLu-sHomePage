<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%
	String web_domain = request.getScheme()+"://"+request.getServerName();
	String file_domain = "http://115.159.40.239";
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>404错误</title>
	<link rel="stylesheet" type="text/css" href="<%=web_domain %>/static/css/public/bootstrap-3.3.7/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="<%=web_domain %>/static/css/public/Font-Awesome-3.2.1/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="<%=web_domain %>/static/css/public/public.css">
	<link rel="stylesheet" type="text/css" href="<%=web_domain %>/static/css/public/404.css">
	<link rel="icon" href="<%=web_domain %>/static/img/easyicon.ico" type="image/x-ico" />
</head>
<body>
	<%@ include file="/static/html/public/header.html" %>
	<!-- <%@ include file="/static/html/public/main-navigation.html" %> -->
	<div class="lsn-center">
		<h2 class="text-center"> <stong>404错误！抱歉您要找的页面不存在</stong> </h2>

		
	</div>
	<%@ include file="/static/html/public/footer.html" %>

	<script type="text/javascript" src="<%=file_domain %>/framework/jquery/jquery-3.1.1.js"></script>
	<script type="text/javascript" src="<%=web_domain %>/static/js/front-end/404.js"></script>
</body>
</html>