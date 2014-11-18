<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>投诉热点与情感趋势分析</title>
</head>

<body>
 <table align="center">
   <tr>

    
    <td>
    <p align="center">对应文本记录列表   </p>
    <SELECT id="forder" style="WIDTH: 304px; HEIGHT: 240px" size="15">
						  <c:forEach items="${matchingText}" var="matchingText">
							
							<option value="${matchingText}">${matchingText}</option>
							
							</c:forEach>

	</select>
    </td>
    </tr>
</table>
</body>
</html>
