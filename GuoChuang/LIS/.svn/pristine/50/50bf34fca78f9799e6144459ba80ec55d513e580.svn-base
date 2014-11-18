<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>投诉文本记录查询结果</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/query.css">

	<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>

  </head>
  
  <body>
<div id="content">
 
  <div id="queryresult">
        <div class="titlebar">
      <h3 class="titlespan">查询结果</h3>
      </div>
      <div id="showresultdiv">
      <textarea class="showresult" type="text" ></textarea>
      </div>
  </div>
  <div id="themeword">
        <div class="titlebar">
      <h3 class="titlespan">主题词与情感分析</h3>
      </div>
      <div id="themepart1">
         <table id="themetable1">
         <tr class="themetabletr">
         <td width="48%" height="13" align="center">文本记录热门主题词</td>
         <td width="8%"></td>
         <td width="21%">主题词</td>
         <td width="23%">情感程度</td>
         </tr>
         <tr>
           <td><textarea class="showtheme" type="text" ></textarea></td>
           <td></td>
           <td align="center">主题词</td>
           <td align="center">情感程度</td>
         </tr>
         </table>
      </div>
      <div id="themepart2">
       <table id="themetable2">
         <tr class="themetabletr">
         <td width="48%" height="13" align="center">主题词墙</td>
         <td width="8%"></td>
         <td width="44%" align="center">对应文本记录列表</td>
         </tr>
         <tr>
           <td height="88">
           <!-- 此处为可点击的table -->
           <table>
           		<tr>
<td>${requestScope.success }${requestScope.keywordList[0] }</td>
                </tr>
			</table>
            <!-- 此处为可点击的table -->
           </td>
           <td></td>
           <td><textarea class="showtheme showresult" type="text" ></textarea></td>
         </tr>
         </table>
      </div>
  </div>
</div>
</body>
</html>
