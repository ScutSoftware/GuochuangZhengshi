<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
    
    <title>投诉文本查询</title>
  </head>
  
  <body>
   <div id="content">
  <div id="querybar">
      <div class="titlebar">
      <h2 id="titlespan">投诉文本记录查询</h2>
      </div>
    <div id="queryformdiv">
      <form id="queryform" methods="post" action="complaintTextRecordQuery/getComplaintText">
         <div id="conditionQuery">
         <table id="queryTable">
             <tr>
             <td colspan="5"><h4>查询时间</h4></td>
         	 <td colspan="9"><h4>查询类别</h4></td>
             </tr>
             <tr>
             <td width="18%" height="23">
             	<input class="forminput" type="text" name="starttime"/>
             </td>
             <td width="3%"></td>
             <td width="4%">至</td>
             <td width="18%">
             	<input class="forminput" type="text" name="finishtime"/>
             </td>
             <td width="7%"></td>
             <td width="8%">
             <select class="querySelect">
             <option>1</option>
             <option>2</option>
             </select>
             </td>
             <td width="3%">>></td>
             <td width="8%">
             <select class="querySelect">
             <option>1</option>
             <option>2</option>
             </select>
             </td>
             <td width="3%">>></td>
             <td width="8%">
             <select class="querySelect">
             <option>1</option>
             <option>2</option>
             </select>
             </td>
             <td width="2%">>></td>
             <td width="8%">
             <select class="querySelect">
             <option>1</option>
             <option>2</option>
             </select>
             </td>
             <td width="2%">>></td>
             <td width="8%">
             <select class="querySelect">
             <option>1</option>
             <option>2</option>
             </select>
             </td>
             </tr>
         </table>
         </div>
        <div id="submitbutton">
            <input type="submit" id="querybutton" value="查询" >
        </div>
      </form>	
    </div>
  </div>
</div>
   
  </body>
</html>


