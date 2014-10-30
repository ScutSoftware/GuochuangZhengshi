<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户主页</title>
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
	
    <link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
    
    <link href="css/home.css" rel="stylesheet" type="text/css">
    <script src="js/home.js" type="text/javascript"></script>
    
  </head>
  
  <body>
  	
  	<div id="wrapper">
  		<div id="header">
  			  <jsp:include page="header.jsp"></jsp:include>
  		</div>
  		<div id="content">
  			<div id="menu">
  				<jsp:include page="menu.jsp"></jsp:include>
  			</div>
  			<div id="infowin">
				<iframe name="infowindow"></iframe>
  			</div>
  		</div>
  		<div id="footer">
  			<p>@你猜</p>
  		</div>
  	</div>
  	
  </body>
</html>

