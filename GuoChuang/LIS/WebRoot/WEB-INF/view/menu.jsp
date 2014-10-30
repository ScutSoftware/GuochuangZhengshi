<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>导航栏</title>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
	
  </head>
  
  <body>
  
    <a href="login" target="infowindow">仓库</a><br/><br/>
	<a href="login" target="infowindow">订单</a><br/><br/>
	<a href="login" target="infowindow">仓库</a><br/><br/>
	<a href="login" target="infowindow">订单</a><br/><br/>
	<a href="login" target="infowindow">仓库</a><br/><br/>
	<a href="login" target="infowindow">订单</a><br/><br/>
  </body>
</html>
