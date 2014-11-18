<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
 <base href="<%=basePath%>">	
<title>查询设置</title>

</head>
<body>

   <p align="center">
   <form role="form" align="center" id="changePageLeftForm" method="get" action="segmentation/getServiceRequestType" >
   <input id="changePageLeft" type="submit" value="文本记录查询页面" class="btn btn-info">	
   </form>
   <br/>
   <form role="form" align="center" id="changePageMiddleForm" method="get" action="complainthottopic/getTextRecords">
   <input id="changePageRight" type="submit" value="文本热点查询页面" class="btn btn-info">	
   </form>
   <br/>
   <form role="form" align="center" id="changePageRightForm" method="get" action="querysetting/getServiceRequestType">
   <input id="changePageRight" type="submit" value="查询设置" class="btn btn-info">	
   </form>
   </p>	
   <p align="center">查询设置</p>
  <form role="form" align="center" id="settingform" method="post" action="querysetting/postToQuerySetting" class="form-search">
  <table align="center">
  <tr>
  <td >
   <label>文本记录存储路径</label>
  </td>
  <td>
   <input  id="routePath" name="routePath" style="width:400px;    height:17px" class="input-medium search-query">
  </td> 
  </tr>
  <tr>
   <td>
   <label>文本记录更新时间间隔（小时）</label>
   </td>
   <td>
   <input  id="timeToUpdat" name="timeToUpdat" style="width:400px;height:17px" class="input-medium search-query">
   </td>
  </tr>
  <tr>
  <td>
   <label>显示主题词个数</label>
  </td>
  <td>
   <input  id="keywordNumber" name="keywordNumber" style="width:400px;height:17px" class="input-medium search-query" >
   </td>
  </tr>
  <tr>
  <td>
   <label>统计时长设置（小时）</label>
   </td>
   <td>
   <input  id="summaryTime1" name="summaryTime1" style="width:100px;height:17px" >
   <label>——</label>
   <input  id="summaryTime2" name="summaryTime2" style="width:100px;height:17px" >
   <label>——</label>
   <input  id="summaryTime3" name="summaryTime3" style="width:100px;height:17px" >  
   </td>
   </tr>  
   </table>
   <p align="center">
   <input type="submit" value="确定" class="btn btn-info" >
   </p>  
   
</form>
   <form  role="form" align="center">
   <table>
   <label>业务结构树层级：       
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     一级&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     二级&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
     三级&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
     四级&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
      五级
   </label>
   <br />
   <b>
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </b>
   <select id="treeLevel1" name="treeLevel1" style="WIDTH: 95px; HEIGHT: 125px" size="15">
		<c:forEach items="${treeLevel1List1}" var="treeLevel1">
							
			<option value="${treeLevel1.serviceRequestName}">${treeLevel1.serviceRequestName}</option>
							
		</c:forEach>	
   </select>
   <select id="treeLevel2" name="treeLevel2" style="WIDTH: 95px; HEIGHT: 125px" size="15">
		<c:forEach items="${treeLevel1List2}" var="treeLevel2">
							
			<option value="${treeLevel2.serviceRequestName}">${treeLevel2.serviceRequestName}</option>
							
		</c:forEach>		
   </select>
   
   <select id="treeLevel3" name="treeLevel3" style="WIDTH: 95px; HEIGHT: 125px" size="15">
		<c:forEach items="${treeLevel1List3}" var="treeLevel3">
							
			<option value="${treeLevel3.serviceRequestName}">${treeLevel3.serviceRequestName}</option>
							
		</c:forEach>	
   </select>
   <select id="treeLevel4" name="treeLevel4" style="WIDTH: 95px; HEIGHT: 125px" size="15">
		<c:forEach items="${treeLevel1List4}" var="treeLevel4">
							
			<option value="${treeLevel4.serviceRequestName}">${treeLevel4.serviceRequestName}</option>
							
		</c:forEach>	
   </select>
   <select id="treeLevel5" name="treeLevel5" style="WIDTH: 95px; HEIGHT: 125px" size="15">
		<c:forEach items="${treeLevel1List5}" var="treeLevel5">
							
			<option value="${treeLevel5.serviceRequestName}">${treeLevel5.serviceRequestName}</option>
							
		</c:forEach>	
   </select>
   </table>
   </form>
   <br />	
   <form role="form" align="center" id="keyWordForm" action="querysetting/keyWordDel"  method="post">
   <table align="center">
   <tr>
   <td>
   <label>业务关键词管理</label>
   </td>
   <td>
   <select id="keyword" name="keyword" align="center"style="WIDTH: 490px; HEIGHT: 120px" size="15">
		<c:forEach items="${keywordList}" var="keyword">
							
			<option value="${keyword.bussinessKeyword}">${keyword.bussinessKeyword}</option>
							
		</c:forEach>	
   </select>
   </tr>
   <br/>  
   </table>
   <input type="submit" value="删除" class="btn btn-info" >
   </form>
   
   <form role="form" align="center" id="keyWordAddForm" method="post" action="querysetting/keyWordAdd">
   <table>
   <b>
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </b>
   <input  id="newKeyWord" name="newKeyWord" style="width:400px;height:17px" >
   <input type="submit" value="新增" class="btn btn-info">
   </table>
   </form>

   <br />
   <table align="center">
   <tr>
   <td>
   <label >情感词汇：       
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
     强烈&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     
     中等&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
    
     轻微
   </label>
   </td>
   </tr>
   </table>
   
   <br/>
   <table align="center">
   <tr>
   <td>
   <form role="form" align="center" id="qinglieForm" method="post" action="querysetting/qianglieDel" style="float:left">
   <select id="qiangLie" name="qiangLie" style="WIDTH: 140px; HEIGHT: 130px" size="15">
		<c:forEach items="${qiangLie}" var="keyword">
							
			<option value="${keyword.emotionKeyword}">${keyword.emotionKeyword}</option>
							
		</c:forEach>	
   </select>
    <input type="submit" value="删除" class="btn btn-info">
   </form>
   
   <br/>
   <form role="form" align="center" id="qiangAddForm" method="post" action="querysetting/qingLieAdd">
   <input  id="newEmotionWord" name="newEmotionWord" style="width:140px;height:17px" align="left">
   <input type="submit" value="新增" class="btn btn-info">
   </form>
   </td>
   <td>
   <form role="form"  id="zhongdengForm" method="post" action="querysetting/zhongdengDel"  >
   <select id="zhongDeng" name="zhongDeng" style="WIDTH: 140px; HEIGHT: 130px" size="15">
		<c:forEach items="${zhongDeng}" var="keyword">
							
			<option value="${keyword.emotionKeyword}">${keyword.emotionKeyword}</option>
							
		</c:forEach>	
   </select>
    <input type="submit" value="删除" class="btn btn-info">
   </form>
   <form role="form" align="center" id="zhongAddForm" method="post" action="querysetting/zhongDengAdd">
   <input  id="newEmotionWord" name="newEmotionWord"style="width:140px;height:17px" align="left">
   <input type="submit" value="新增" class="btn btn-info">
  </form>
  </td>
   <td>
   <form role="form" id="qingweiForm" method="post" action="querysetting/qingweiDel"  >
   <select id="qingWei" name="qingWei" style="WIDTH: 140px; HEIGHT: 130px" size="15">
		<c:forEach items="${qingWei}" var="keyword">
							
			<option value="${keyword.emotionKeyword}">${keyword.emotionKeyword}</option>
							
		</c:forEach>	
   </select>
   <input type="submit" value="删除" class="btn btn-info">
   </form>

  <form role="form" align="center" id="qingAddForm" method="post" action="querysetting/qingWeiAdd">
   <input id="newEmotionWord" name="newEmotionWord" style="width:140px;height:17px" align="left">
   <input type="submit" value="新增" class="btn btn-info">
  </form>
  </td>
  </tr>
  </table>
</body>
</html>