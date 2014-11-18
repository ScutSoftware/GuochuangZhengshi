<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'queryResult.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <form id="queryform" method="POST" action="complaintTextRecordQuery/getComplaintText">
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
    		      <input  id="inputkeyword" type="hidden" name="keyword" >
            		<SELECT  name="keyWord" id="forder" style="WIDTH: 500px; HEIGHT: 240px" size="15">
							<c:forEach items="${gistlist}" var="gist">
							
							<option value="${gist}">${gist}</option>
							
							</c:forEach>
					</select>
  		    </div>
//${requestScope.keyword}
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
  <body>
  
  </body>
</html>
