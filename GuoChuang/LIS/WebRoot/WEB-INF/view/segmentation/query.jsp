<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<title>查询投诉文本</title>
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0">

<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css"
	rel="stylesheet">

<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="css/login.css" />

<script type="text/javascript">
$(document).ready(function(){
	//全部初始化服务类型
	// $.ajax({
	// 		cache:true,
	// 		type:"GET",
	// 		url:"serviceRequestType/getInitServiceRequestType",
	// 		error:function (request,message,ex){
	// 			alert(request.responseText);
	// 			},
	// 		success : function(data){
				
	// 			if(data.levelOne != null) {
	// 				var levelOneHtml = '';
	// 				for(var i = 0; i < data.levelOne.length;i++){
	// 					levelOneHtml += '<option value ="' + data.levelOne[i].allCodeID + '">' + data.levelOne[i].serviceRequestName + '</option>';
	// 				}
	// 				$("#serviceRequestType1Select").html(levelOneHtml);
	// 				$("#serviceRequestType1Select").children("option :first").attr("checked","checked");
	// 				$("#serviceRequestType1Input").val($("#serviceRequestType1Select").val());
					
	// 			}
				
	// 			if(data.levelTwo != null){
	// 				var levelTwoHtml = '';
	// 				for(var i = 0; i < data.levelTwo.length;i++){
	// 					levelTwoHtml += '<option value ="' + data.levelTwo[i].allCodeID + '">' + data.levelTwo[i].serviceRequestName + '</option>';
	// 				}
	// 				$("#serviceRequestType2Select").html(levelTwoHtml);
	// 				$("#serviceRequestType2Select").children("option :first").attr("checked","checked");
	// 				$("#serviceRequestType2Input").val($("#serviceRequestType2Select").val());
					
	// 			}
				
	// 			if(data.levelThree != null){
	// 				var levelThreeHtml = '';
	// 				for(var i = 0; i < data.levelThree.length;i++){
	// 					levelThreeHtml += '<option value ="' + data.levelThree[i].allCodeID + '">' + data.levelThree[i].serviceRequestName + '</option>';
	// 				}
	// 				$("#serviceRequestType3Select").html(levelThreeHtml);
	// 				$("#serviceRequestType3Select").children("option :first").attr("checked","checked");
	// 				$("#serviceRequestType3Input").val($("#serviceRequestType3Select").val());
					
	// 			}
				
	// 			if(data.levelFour != null){
	// 				var levelFourHtml = '';
	// 				for(var i = 0; i < data.levelFour.length;i++){
	// 					levelFourHtml += '<option value ="' + data.levelFour[i].allCodeID + '">' + data.levelFour[i].serviceRequestName + '</option>';
	// 				}
	// 				$("#serviceRequestType4Select").html(levelFourHtml);
	// 				$("#serviceRequestType4Select").children("option :first").attr("checked","checked");
	// 				$("#serviceRequestType4Input").val($("#serviceRequestType4Select").val());
					
	// 			}
				
	// 			if(data.levelFive != null){
	// 				var levelFiveHtml = '';
	// 				for(var i = 0; i < data.levelFive.length;i++){
	// 					levelFiveHtml += '<option value ="' + data.levelFive[i].allCodeID + '">' + data.levelFive[i].serviceRequestName + '</option>';
	// 				}
	// 			}
				
	// 			$("#serviceRequestType5Select").html(levelFiveHtml);
	// 			$("#serviceRequestType5Select").children("option :first").attr("checked","checked");
	// 			$("#serviceRequestType5Input").val($("#serviceRequestType5Select").val());
	// 		}
	// 		});
	
	//初始化一级服务选项
	$.ajax({
			cache:true,
			type:"GET",
			url:"serviceRequestType/getServiceRequestType",
			data:"parentID= ",
			error:function (request,message,ex){
				alert(request.responseText);
				},
			success : function(data){
				var serviceRequestTypeHtml = '';
				for(var i = 0; i < data.serviceRequestTypeList.length;i++){
					serviceRequestTypeHtml += '<option value ="' + data.serviceRequestTypeList[i].allCodeID + '">' + data.serviceRequestTypeList[i].serviceRequestName + '</option>';
				}
				$("#serviceRequestType1Select").html(serviceRequestTypeHtml);
				$("#serviceRequestType1Select").children("option :first").attr("checked","checked");
				$("#serviceRequestType1Input").val($("#serviceRequestType3Select").val());
			}
			});	
	
	
	
	//根据一级服务类型的值,获取二级服务类型的值
	$("#serviceRequestType1Select").change(function(){
		$("#serviceRequestType1Input").val($("#serviceRequestType1Select").val());
		$.ajax({
			cache:true,
			type:"GET",
			url:"serviceRequestType/getServiceRequestType",
			data:"parentID=" + $("#serviceRequestType1Input").val(),
			error:function (request,message,ex){
				alert(request.responseText);
				},
			success : function(data){
				var serviceRequestTypeHtml = '';
				for(var i = 0; i < data.serviceRequestTypeList.length;i++){
					serviceRequestTypeHtml += '<option value ="' + data.serviceRequestTypeList[i].allCodeID + '">' + data.serviceRequestTypeList[i].serviceRequestName + '</option>';
				}
				$("#serviceRequestType2Select").html(serviceRequestTypeHtml);
				$("#serviceRequestType2Select").children("option :first").attr("checked","checked");
				$("#serviceRequestType2Input").val($("#serviceRequestType2Select").val());
			}
			});	
	});
	
	//根据二级服务类型的值,获取三级服务类型的值
	$("#serviceRequestType2Select").change(function(){
		$("#serviceRequestType2Input").val($("#serviceRequestType2Select").val());
		$.ajax({
			cache:true,
			type:"GET",
			url:"serviceRequestType/getServiceRequestType",
			data:"parentID=" + $("#serviceRequestType2Input").val(),
			error:function (request,message,ex){
				alert(request.responseText);
				},
			success : function(data){
				var serviceRequestTypeHtml = '';
				for(var i = 0; i < data.serviceRequestTypeList.length;i++){
					serviceRequestTypeHtml += '<option value ="' + data.serviceRequestTypeList[i].allCodeID + '">' + data.serviceRequestTypeList[i].serviceRequestName + '</option>';
				}
				$("#serviceRequestType3Select").html(serviceRequestTypeHtml);
				$("#serviceRequestType3Select").children("option :first").attr("checked","checked");
				$("#serviceRequestType3Input").val($("#serviceRequestType3Select").val());
			}
			});	
	});
	
	//根据三级服务类型的值,获取四级服务类型的值
	$("#serviceRequestType3Select").change(function(){
		$("#serviceRequestType3Input").val($("#serviceRequestType3Select").val());
		$.ajax({
			cache:true,
			type:"GET",
			url:"serviceRequestType/getServiceRequestType",
			data:"parentID=" + $("#serviceRequestType3Input").val(),
			error:function (request,message,ex){
				alert(request.responseText);
				},
			success : function(data){
				var serviceRequestTypeHtml = '';
				for(var i = 0; i < data.serviceRequestTypeList.length;i++){
					serviceRequestTypeHtml += '<option value ="' + data.serviceRequestTypeList[i].allCodeID + '">' + data.serviceRequestTypeList[i].serviceRequestName + '</option>';
				}
				$("#serviceRequestType4Select").html(serviceRequestTypeHtml);
				$("#serviceRequestType4Select").children("option :first").attr("checked","checked");
				$("#serviceRequestType4Input").val($("#serviceRequestType4Select").val());
			}
			});	
	});
	
	//根据四级服务类型的值,获取五级服务类型的值
	$("#serviceRequestType4Select").change(function(){
		$("#serviceRequestType4Input").val($("#serviceRequestType4Select").val());
		$.ajax({
			cache:true,
			type:"GET",
			url:"serviceRequestType/getServiceRequestType",
			data:"parentID=" + $("#serviceRequestType4Input").val(),
			error:function (request,message,ex){
				alert(request.responseText);
				},
			success : function(data){
				var serviceRequestTypeHtml = '';
				for(var i = 0; i < data.serviceRequestTypeList.length;i++){
					serviceRequestTypeHtml += '<option value ="' + data.serviceRequestTypeList[i].allCodeID + '">' + data.serviceRequestTypeList[i].serviceRequestName + '</option>';
				}
				$("#serviceRequestType5Select").html(serviceRequestTypeHtml);
				$("#serviceRequestType5Select").children("option :first").attr("checked","checked");
				$("#serviceRequestType5Input").val($("#serviceRequestType5Select").val());
			}
			});	
	});
	
	$("#queryInput").click(function(){
		var allCodeID = $("#serviceRequestType5Input").val();
		$.ajax({
			cache:true,
			type:"GET",
			url:"segmentation/getComplaintTextRecordsAndBussinessKeyword",
			data:"startTime="+ $("#startTime").val() + "&endTime=" + $("#endTime").val() + "&allCodeID=" + allCodeID,
			error:function (request,message,ex){
				alert(request.responseText);
				},
			success : function(data){
				var complaintTextHtml = '';
				for(var i = 0; i < data.complaintTextList.length;i++){
					complaintTextHtml += '<option value ="' + data.complaintTextList[i].complaintContent + '">' + data.complaintTextList[i].complaintContent + '</option>';
				}
				$("#complainTextSelect").html(complaintTextHtml);
				$("#complainTextSelect").children("option :first").attr("checked","checked");
				
				var keywordHtml = '';
				for(var i = 0; i < data.keywordList.length;i++){
					keywordHtml += '<option value ="' + data.keywordList[i] + '">' + data.keywordList[i] + '</option>';
				}
				$("#keywordSelect").html(keywordHtml);
				$("#keywordSelect").children("option :first").attr("checked","checked");
			}
			});		
		});
	
	$("#matchInput").click(function(){
		$.ajax({
			cache:true,
			type:"GET",
			url:"segmentation/getMatchingComplaintTexts",
			data:"keyword="+ $("#keywordSelect").val() + "&startTime="+ $("#startTime").val() + "&endTime=" + $("#endTime").val(),
			error:function (request,message,ex){
				alert(request.responseText);
				},
			success : function(data){
				
				var matchingComplaintTextsHtml = '';
				for(var i = 0; i < data.matchingComplaintTexts.length;i++){
					matchingComplaintTextsHtml += '<option value ="' + data.matchingComplaintTexts[i] + '">' + data.matchingComplaintTexts[i] + '</option>';
				}
				$("#matchingComplaintTextsSelect").html(matchingComplaintTextsHtml);
				$("#matchingComplaintTextsSelect").children("option :first").attr("checked","checked");
			}
		});
	});
});

	var x = null;
	var listObj = null;
	//鼠标按下不放时的操作
	function setTimeStart(type) {
		listObj = document.getElementById('forder');
		//超过0.3秒启动连续的向上(下)的操作
		if (type == "up") {
			x = setTimeout(upListItem, 300);
		} else {
			x = setTimeout(downListItem, 300);
		}
	}
	
	
	
	//添加
	function moveOption(obj1, obj2) {
		objValue = obj1.value;

		if (objValue == "") {
			alert("请输入要添加的数据！");
			return false;
		}
		for (var i = 0; i < obj2.options.length; i++) {
			if (objValue == obj2.options[i].value) {
				alert("该数据已经存在！");
				return false;
			}
		}
		var opt = new Option(objValue, objValue);
		opt.selected = true;
		obj2.options.add(opt);
	}
	//选取
	function chooseOption(obj1, obj2) {
		var selIndex = obj1.selectedIndex;
		var selValue = listObj.options[selIndex].value;
		for (var i = 0; i < obj2.options.length; i++) {
			if (selValue == obj2.options[i].value) {
				alert("该数据已经存在！");
				return false;
			}
		}
		var opt = new Option(selValue, selValue);
		opt.selected = true;
		obj2.options.add(opt);
	}
	
	function submitOption(obj, obj2) {
		var word = new Array();
		for(var i = 0; i < obj.options.length; i++) {
			word.push(obj.options[i].value);
		}
		alert(word);
 	 	$.ajax({ 
               url: "keyword/addKeyWork", 
               type: 'POST', 
               data: {'word': JSON.stringify(word) }, 
               dataType: 'html', 
               success : function(data) {
               		  self.location.reload()
               }
               	
           } ); 
        return true; 

	}
	
	//点击选词确认
	function submitOption(obj, obj2) {
		var word = new Array();
		for(var i = 0; i < obj.options.length; i++) {
			word.push(obj.options[i].value);
		}
		alert(word);
 	 	$.ajax({ 
               url: "keyword/addKeyWork", 
               type: 'POST', 
               data: {'word':JSON.stringify(word) }, 
               dataType: 'html', 
               success : function(data) {
               		  self.location.reload()
               }
               	
           } ); 
        return true; 

	}
	//将选中item向上
	function upListItem() {
		var selIndex = listObj.selectedIndex;
		if (selIndex < 0) {
			if (x != null) {
				clearTimeout(x);
			}
			return;
		}
		if (selIndex == 0) {
			if (x != null) {
				clearTimeout(x);
			}
			return;
		}
		var selValue = listObj.options[selIndex].value;
		var selText = listObj.options[selIndex].text;
		listObj.options[selIndex].value = listObj.options[selIndex - 1].value;
		listObj.options[selIndex].text = listObj.options[selIndex - 1].text;
		listObj.options[selIndex - 1].value = selValue;
		listObj.options[selIndex - 1].text = selText;
		listObj.selectedIndex = selIndex - 1;
		if (selIndex + 1 > 0) {
			x = setTimeout(upListItem, 200)
		}
	}
	
	
	
	//将选中item向下
	function downListItem() {
		var selIndex = listObj.selectedIndex;
		if (selIndex < 0) {
			if (x != null) {
				clearTimeout(x);
			}
			return;
		}
		if (selIndex == listObj.options.length - 1) {
			if (x != null) {
				clearTimeout(x);
			}
			return;
		}
		var selValue = listObj.options[selIndex].value;
		var selText = listObj.options[selIndex].text;
		listObj.options[selIndex].value = listObj.options[selIndex + 1].value;
		listObj.options[selIndex].text = listObj.options[selIndex + 1].text;
		listObj.options[selIndex + 1].value = selValue;
		listObj.options[selIndex + 1].text = selText;
		listObj.selectedIndex = selIndex + 1;
		if (selIndex + 1 < listObj.options.length - 1) {
			x = setTimeout(downListItem, 200)
		}
	}

</script>
<style type="text/css">
div#container {
	width: 1300px
}

div#header {
	
}

div#queryTime {
	width: 650px;
	float: left
}

div#queryCategory {
	width: 650px;
	float: left
}

div#queryButton {
	width: 1300px;
	float: left
}

div#queryResult {
	height: 600px;
	width: 1100px
}

div#complainTextResult {
	height: 450px;
	width: 800px;
	float: left
}

div#keywordResult {
	height: 450px;
	width: 500px;
	float: left
}

div#matchButton {
	height: 50px;
	width: 1300px;
	float: left
}

div#matchTextResult {
	height: 450px;
	width: 1300px;
	float: left
}

div#skipButton {
	height: 50px;
	width: 1300px;
	float: left
}

div#keywordCorrect {
	height: 400px;
	width: 1300px;
	float: left
}

div#relatedWord {
	height: 50px;
	width: 1300px;
	float: left
}

input {
	margin: 10px 10px;
}
</style>

</head>

<body>
 <p align="center">
   <form role="form" align="center" id="changePageLeftForm" method="get" action="segmentation/getServiceRequestType" >
   <input id="changePageLeft" type="submit" value="文本记录查询页面" class="btn btn-info" >	
   </form>
   <form role="form" align="center" id="changePageMiddleForm" method="get" action="complainthottopic/getTextRecords">
   <input id="changePageRight" type="submit" value="文本热点查询页面" class="btn btn-info">	
   </form>
   <form role="form" align="center" id="changePageRightForm" method="get" action="querysetting/getServiceRequestType">
   <input id="changePageRight" type="submit" value="查询设置" class="btn btn-info" >	
   </form>
 </p>		
	<div id="container">
		<div id = "header">
			<p align=center>投诉文本记录查询</p>
		</div>
		
		<div id="queryTime" align="center">
				<label>查询时间</label> <input type="date" id="startTime">
						&nbsp; <label>至</label> &nbsp; <input type="date" id="endTime">
		</div>
			
			<div id="queryCategory" align="center">
				<label>查询类别</label>
				
				<input id="serviceRequestType1Input" type="hidden" name="serviceRequestType1" >
				<select type="select" name="Item" id="serviceRequestType1Select">
				</select>
				
				<label>>></label>
				
				<input id="serviceRequestType2Input" type="hidden" name="serviceRequestType2" >
				 <select type="select" name="Item" id="serviceRequestType2Select">
				</select> 
				
				<label>>></label> 
				
				<input id="serviceRequestType3Input" type="hidden" name="serviceRequestType3" >
				<select type="select" name="Item" id="serviceRequestType3Select">
				</select>
				
				 <label>>></label> 
				 
				 <input id="serviceRequestType4Input" type="hidden" name="serviceRequestType4" >
				 <select type="select" name="Item" id="serviceRequestType4Select">
				 </select> 
				 
				 <label>>></label> 
				 
				  <input id="serviceRequestType5Input" type="hidden" name="serviceRequestType5" >
				 <select type="select" name="Item" id="serviceRequestType5Select">
				 </select>
			</div>

			
			<div id="queryButton">
				<p align='center'>
					<input id = "queryInput" type="button"
						value="&nbsp;&nbsp;查&nbsp;&nbsp;&nbsp;&nbsp;询&nbsp;&nbsp;" class="btn btn-info">
				</p>
			</div>
			
			
				<div id="complainTextResult">
					<p align='center'>投诉文本记录</p>
            		<select id="complainTextSelect" style="WIDTH: 800px; HEIGHT: 400px" size="15">
					</select>
				</div>
				<div id="keywordResult">
					<p align='center'>文本记录主题词</p>
            		<SELECT  name="keyword" id="keywordSelect" style="WIDTH: 500px; HEIGHT: 400px" size="15">
					</select>
				</div>
			
			
			<div id="matchButton">
				<p align='center'>
					<input id = "matchInput" type= "button" value="&nbsp;&nbsp;匹&nbsp;&nbsp;&nbsp;&nbsp;配&nbsp;&nbsp;"class="btn btn-info" />
				</p>
			</div>
			
			<div id="matchTextResult" align="center">
				<p align='center'>文本记录匹配结果</p>         	
            	<select id="matchingComplaintTextsSelect" style="WIDTH: 800px; HEIGHT: 400px" size="15">
				</select>
			</div>
            
            <div id="skipButton">
            	<form action="segmentation/getServiceRequestTypeChange" method="GET">
					<p align='center'>
					
						<input id = "queryInput" type="submit" style="width: 60px;"	value="确认" class="btn btn-info">
					
					</p>
				</form>
			</div>
			
		
		
		<div id="keywordCorrect">
			<p align="center">主题词更正与反馈</p>
			<p align='center'>
				<label>添加主题词：</label>
				<input type="text" name="addSite" id="addSite" style="width:300px"
				onblur="isDomain(this.value)"  /> 
				<input value="添加"
				style="width: 60px;" type="button"
				onclick="moveOption(document.getElementById('addSite'),document.getElementById('forder'))" class="btn btn-info" />
			</p>
			<form id="wordForm" action="keyword/relationKeyWord" method="post">
			<table align="center">
				<TR>
					<td>
						<SELECT id="forder"  style="WIDTH: 350px; HEIGHT: 240px" 
						size="15">
							<c:forEach items="${wordList}" var="item"  varStatus="status">
								<OPTION value="${item.word}">${item.word}</OPTION>
							</c:forEach>
							
						</select>
					</td>
					<td>
						<INPUT  class="upBtn btn btn-info" type="button" value="向上"
						onmousedown="setTimeStart('up');" onmouseup="clearTimeout(x);" class="btn btn-info"
						onclick="listObj=document.getElementById('unforder');upListItem();clearTimeout(x);"
						ID="Button1" NAME="Button1" /> <br /> 
						
						<INPUT  type="button" value="向下"
						class="downBtn btn btn-info" onmousedown="setTimeStart('down');" 
						onmouseup="clearTimeout(x);"
						onclick="listObj=document.getElementById('unforder');downListItem();clearTimeout(x);"
						ID="Button2" NAME="Button2" /><br /> 
						
						<INPUT  type="button" value="选取"
						onmousedown="setTimeStart('down');" onmouseup="clearTimeout(x);" class="btn btn-info"
						onclick="chooseOption(document.getElementById('forder'),document.getElementById('unforder'))" />
					</td>
	
					<TD>
					<SELECT id="unforder"  style="WIDTH: 350px; HEIGHT: 240px" size="15">
							
					</select></td>
					<td><input class="submitBtn btn btn-info"" type="button" onclick="submitOption(document.getElementById('unforder'),document.getElementById('wordForm'))" value="提交" class="btn btn-info" /></td>
					</tr>
				</table>
			</form>
		</div>
		
		<div id="relatedWord" align="left">
			<form id="relatedWordForm" action="keyword/getRelatedWord" method="POST">
				<table align="center">
					<tr>
						<td style="width:350px;Height:240px">
						
							<p align="center">
								<c:forEach items="${wordList2}" var="word"  varStatus="status">
									<input id="inputTopic" type="radio" align="center" name="keyWord" value="${word}" />${word}<br/ >
								</c:forEach>
							</p>
						</td>
						
						<td align="center"><label> 关联 </label></td>
						
						<td style="width:350px;Height:240px">
							<p align="center">
								<c:forEach items="${wordList2}" var="word"  varStatus="status">
									<input type="checkbox" name="list" align="center" value="${word}" />${word}<br />
								</c:forEach>
							</p>
						</td>
						
							
						
					</tr>
					
					<tr>
						<td></td>
						<td align="center">
						<INPUT type="submit" style="WIDTH: 60px; HEIGHT: 22px" value="确认" />
						</td>
						<td>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
		
</body>
</html>
