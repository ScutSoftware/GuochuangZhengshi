<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查询结果</title>
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
	
    <link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/login.css" />
    
      <script type="text/javascript">
      
      $("#inputkeyword").val($("#selectkeyWord option:selected").val());
  		</script>
  
  </head>  

  <body>
  <form id="queryform" method="POST" action="segmentation/getMatchingComplaintTexts">
  	<table align="center">
      <tr>
        <td>
  		    <div>
    		      <p align='center'>投诉文本记录</p><br/>
            		<select id="forder" style="WIDTH: 500px; HEIGHT: 240px" size="15">
							<c:forEach items="${complaintTextList}" var="complaintText">
							
							<option value="${complaintText.complaintContent}">${complaintText.complaintContent}</option>
							
							</c:forEach>
					</select>
  		    </div>
        </td>        
    </tr>
    
    <tr>
        <td>
  		    <div>
    		      <p align='center'>文本记录主题词</p><br/>
            		<SELECT  name="keyword" id="forder" style="WIDTH: 500px; HEIGHT: 240px" size="15">
							<c:forEach items="${keywordList}" var="keyword">
							
							<option value="${keyword}">${keyword}</option>
							
							</c:forEach>
					</select>
  		    </div>
  		    ${requestScope.keyword}
        </td>        
    </tr>
    
    <tr>
      <td>
        <p align='center'>
          <input type="submit" value="&nbsp;&nbsp;查&nbsp;&nbsp;&nbsp;&nbsp;询&nbsp;&nbsp;">
        </p>
      </td>
    </tr>
    </table>
  </form>
  	
  </body>
</html>
