<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'header.jsp' starting page</title>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
	
	<link href="css/header.css" rel="stylesheet" type="text/css" >

  </head>
  
  <body>
  		<h1>物流信息管理系统</h1>
  </body>
</html>
