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
<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css"
	rel="stylesheet">

<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<title>投诉热点与情感趋势分析</title>
</head>

<body>
<div class="jumbotron" align = "center">

   <form role="form" align="center" id="changePageLeftForm" method="get" action="getServiceRequestType" >
   <input id="changePageLeft" type="submit" value="文本记录查询" class="btn btn-info">	
   </form>
   
   <form role="form" align="center" id="changePageMiddleForm" method="get" action="getTextRecords">
   <input id="changePageRight" type="submit" value="文本热点查询" class="btn btn-info">	
   </form>
  
   <form role="form" align="center" id="changePageRightForm" method="get" action="querySetting">
   <input id="changePageRight" type="submit" value="查询设置" class="btn btn-info">	
   </form>

 </div>
 <table align="center">
   <tr>
    <td>
     <!--  <form  id="confirmForm" method="post" action="getConfirm" >
     -->
     <h1 align=center>投诉热点与情感趋势分析</h1>
     <!--  
     <input	type="submit" value="最近N1小时内">  </input>
     <input	type="submit" value="最近N1小时内">  </input>
     <input	type="submit" value="最近N1小时内">  </input>
     -->
     <br />
     <br />
     <div align = "center">
     <input id="changePageLeft1" type="submit" value="最近${(timeSettingList[0])}小时" class="btn btn-info">
     </input>	
     <input id="changePageMiddle1" type="submit" value="最近 ${(timeSettingList[1])}小时" class="btn btn-info">
     </input>	
     <input id="changePageRight1" type="submit" value="最近${(timeSettingList[2])}小时" class="btn btn-info">
     </input>
     </div>	
     <script type="text/javascript">
    $("#changePageLeft1").click(function(){
		$.ajax({
			cache:true,
			type:"get",
			url:"./getTextRecordsAjax",
			data:"timeSetting=1" ,
			error:function (request,message,ex){
				alert(request.responseText);
				},
			success : function(data){
			    $("#queryTextSelect").empty();
				var complaintTextHtml = '';
				for(var i = 0; i < data.keywordList.length;i++){
					complaintTextHtml += '<option value ="' + data.keywordList[i] + '">' + data.keywordList[i]+ '</option>';
				}
				$("#queryTextSelect").append(complaintTextHtml);
				
			}
			});		
	 
		});
    $("#changePageMiddle1").click(function(){
		$.ajax({
			cache:true,
			type:"get",
			url:"./getTextRecordsAjax",
			data:"timeSetting=2" ,
			error:function (request,message,ex){
				alert(request.responseText);
				},
			success : function(data){
			    $("#queryTextSelect").empty();
				var complaintTextHtml = '';
				for(var i = 0; i < data.keywordList.length;i++){
					complaintTextHtml += '<option value ="' + data.keywordList[i] + '">' + data.keywordList[i]+ '</option>';
				}
				$("#queryTextSelect").append(complaintTextHtml);
				
			}
			});		
	 
		});
    $("#changePageRight1").click(function(){
		$.ajax({
			cache:true,
			type:"get",
			url:"./getTextRecordsAjax",
			data:"timeSetting=3" ,
			error:function (request,message,ex){
				alert(request.responseText);
				},
			success : function(data){
			    $("#queryTextSelect").empty();
				var complaintTextHtml = '';
				for(var i = 0; i < data.keywordList.length;i++){
					complaintTextHtml += '<option value ="' + data.keywordList[i] + '">' + data.keywordList[i]+ '</option>';
				}
				$("#queryTextSelect").append(complaintTextHtml);
				
			}
			});		
	 
		});
     
   
   
    </script>
     <br />
     <br />
     
     <SELECT id="queryTextSelect" name="texts" style="WIDTH: 700px; HEIGHT: 200px" size="15">
	</SELECT>
    <br />
    <p align="left" id = keyword1>主题词:    </p>
    <p align="left" id = emotion1>情感程度:   </p>
    
    
  <div>
    <input type="submit"  value="确定"  id=queryTextword class="btn btn-info">
    </input>
    <script type="text/javascript">
    $("#queryTextword").click(function(){
		$.ajax({
			cache:true,
			type:"post",
			url:"./getMatchingComplaintTexts",
			data:"keyword="+ $("#queryTextSelect").val(),
			error:function (request,message,ex){
				alert(request.responseText);
				},
			success : function(data){
				$("#forder").empty();
				var complaintTextHtml = '';
				for(var i = 0; i < data.matchingText.length;i++){
					complaintTextHtml += '<option value ="' + data.matchingText[i] + '">' + data.matchingText[i]+ '</option>';
				}
				$("#forder").append(complaintTextHtml);
				$("#keyword2").remove();
				$("#emotion2").remove();
				$("#keyword1").append("<p id = keyword2>"+$("#queryTextSelect").val()+"</p>");
				$("#emotion1").append("<p id = emotion2>"+data.emotionLevel+"</p>");			    
			}
			});		
	 
		});
   
   
    </script>
  </div>
     </td>

    </tr>
   </table>
    <table align="center">
   <tr>
    <td>
    <p align="center">对应文本记录列表   </p>
    <SELECT id="forder" style="WIDTH: 700px; HEIGHT: 200px" size="15">					
	</select>
    </td>
    </tr>
    <tr>
    <td>
    <p > </p>
    <input  type="button" value="确定" class="btn btn-info" align='center' >
    <br/>
    <p > </p>
    <div align = "center">
    
	<div  style="width: 700px; height: 105px; border: 1px solid #ccc;">
					<label>文本记录内容投诉细项包括</label>
					<input  id="duanyu" name="routePath" style="width:400px;    height:21px" class="input-medium search-query">
					<br/>
					<label>文本记录内容业务层级</label>
					<input  id="cengji" name="routePath" style="width:430px;    height:21px" class="input-medium search-query">
					<br>
					<label>问题分类类型</label>
					<input  id="fenglei" name="routePath" style="width:485px;    height:21px" class="input-medium search-query">
					<br>
					<label>问题细项类型</label>
					<input  id="xixiang" name="routePath" style="width:485px;    height:21px" class="input-medium search-query">				
	</div>
	</div>
    </td>
    </tr>
</table>
<br/>
<br/><br/><br/>
</body>
</html>
