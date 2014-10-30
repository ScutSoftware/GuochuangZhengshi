<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册</title>
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
	
    <link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>

	<link href="css/register.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
  	<div class="panel panel-default" id="register">
  	
  		<div class="panel-heading">
  			<center><h3 class="panel-title">用户注册</h3></center>
  		</div>
  		<div class="panel-body">
  			
  			<form role="form" class="form-horizontal" id="registerform" action="login" method="post">
  				<div class="form-group">
  					<label for="username" class="col-xs-3 control-label">用户名：</label>
  					<input type="text" id="username" class="col-xs-9 form-control" placeholder="请输入用户名">
  				</div>
  				<div class="form-group">
  					<label for="pwd" class="col-xs-3 control-label">密码：</label>
  					<input type="password" id="pwd" class="col-xs-9 form-control" placeholder="请输入密码">
  				</div>
  				<div class="form-group">
  					<label for="pwd-again" class="col-xs-3 control-label">确认密码：</label>
  					<input type="password" id="pwd-again" class="col-xs-9 form-control" placeholder="请确认密码："> 					
  				</div>
  				<div class="form-group">
  					<label for="sex" class="col-xs-3 control-label">性别：</label>
  					<input type="radio" name="sex" value="male" checked>男&nbsp;&nbsp;
  					<input type="radio" name="sex" value="female">女
  				</div>
  				<div class="form-group">
  					<label for="email" class="col-xs-3 control-label">邮箱：</label>
  					<input type="text" id="email" class="col-xs-9 form-control" placeholder="请输入邮箱">
  				</div>
  				<div class="form-group">
  					<label for="mobile" class="col-xs-3 control-label">电话：</label>
  					<input type="text" id="mobile" class="col-xs-9 form-control" placeholder="请输入电话号码">
  				</div>
  				<div class="form-group">
  					<label for="position" class="col-xs-3 control-label">职位：</label>
  					<input type="text" id="position" class="col-xs-9 form-control" placeholder="请输入职位">
  				</div>
  				<div class="form-group">
  					<label for="educationdegree" class="col-xs-3 control-label">学历：</label>
  					<input type="text" id="educationdegree" class="col-xs-9 form-control" placeholder="请输入学历">
  				</div>
  				<div class="form-group">
  					<input type="submit" class="btn btn-primary col-xs-offset-3" value="&nbsp;&nbsp;注&nbsp;&nbsp;册&nbsp;&nbsp;">
  				</div>
  			</form>
  			
  			<p id="login"><a href="login">已有账号，前往登录</a></p>
  			
  		</div>
  	</div>
  </body>
</html>
