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
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />


<script type="text/javascript" src="js/tags.js"></script>

<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css"	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="js/jqcloud.css" />
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jqcloud-1.0.4.js"></script>
<script type="text/javascript">
      
</script>

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
				var keywordHtml2 = '';
				var method1Html = '';
				var method2Html = '';
				for(var i = 0; i < data.keywordList.length;i++){
					keywordHtml += '<option value ="' + data.keywordList[i] + '">' + data.keywordList[i] + '</option>';
					keywordHtml2 += '<a >' +data.keywordList[i] +'</a>' ;
				}
				
				$("#keywordSelect").html(keywordHtml);
				$("#keywordSelect").children("option :first").attr("checked","checked");
				$("#tagsList").append(keywordHtml2);
				$("#my_favorite_latin_words").empty() ;
				var word_list = [];	
				for(var i = 0; i < data.keywordList.length;i++){
					var word =  {
					         "text" : data.keywordList[i],
					         "weight" :  1
					     }
					word_list.push(word) ;
				}
				
							                
				$(function() {
				             $("#my_favorite_latin_words").jQCloud(word_list);
				           });
			}
			});		
		});
	
	//填充文本记录投诉细项
	$("#contentButton").click(function(){
		$.ajax({
			cache:true,
			type:"POST",
			url:"segmentation/getComplaintTextPhrase",
			data: {
				sentence : $("#complainTextSelect").val()
			},
			error:function (request,message,ex){
				alert(request.responseText);
				},
			success : function(data){
				
				var phrases = new Array;
				for(var i = 0; i < data.duanyu.length; i++){
					phrases.push(data.duanyu[i]);
				}
				$("#duanyu").val(phrases);
				$("#cengji").val($("#serviceRequestType1Select").find("option:selected").text() + ">>" + $("#serviceRequestType2Select").find("option:selected").text() + ">>" + $("#serviceRequestType3Select").find("option:selected").text() + ">>" + $("#serviceRequestType4Select").find("option:selected").text() + ">>" + $("#serviceRequestType5Select").find("option:selected").text());
				$("#fenlei").val(data.problemType);
				$("#xixiang").val(data.problemDetail);
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
	
	$("#clickInput").click(function() {
	
		$.ajax({ 
               url: "segmentation/getServiceRequestTypeChange", 
               type: 'GET', 
               dataType: 'json', 
               success : function(data) {
               		
               		var wordList_Html = '';
					for(var i = 0; i < data.wordList.length;i++){
						wordList_Html += '<option value ="' + data.wordList[i] + '">' + data.wordList[i] + '</option>';
					}
					$("#forder").html(wordList_Html);
               }
           });
	});
	
	
	$("#submitBtn").click(function(){
		var word = new Array();
		
		$("#unforder option").each(function(){ //遍历全部option
        var txt = $(this).text(); //获取option的内容
            word.push(txt); //添加到数组中
    	});
		
		
		$.ajax({ 
               url: "segmentation/addKeyWork", 
               type: 'POST', 
               data: {
               			'word': JSON.stringify(word)
               		}, 
               dataType: 'json', 
               success : function(data) {
               
               		var word_One_Html = '';
					for(var i = 0; i < data.wordList2.length;i++){
						word_One_Html +='<input id="inputTopic" type="radio" align="center" name="keyWord" value="' + data.wordList2[i] + '" />' + data.wordList2[i] + '<br/ >';
					}
					$("#one").html(word_One_Html);
					
					var word_Many_Html = '';
					for(var i = 0; i < data.wordList2.length; i++) {
						word_Many_Html += '<input type="checkbox" name="list" align="center" value="' + data.wordList2[i] + '" />' + data.wordList2[i] + '<br />';
					}
					$("#many").html(word_Many_Html);
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
<div class="jumbotron" align = "center">

   <form role="form" id="changePageLeftForm" method="get" action="segmentation/getServiceRequestType" >
   <input id="changePageLeft" type="submit" value="文本记录查询" class="btn btn-info" >	
   </form>
   <form role="form"  id="changePageMiddleForm" method="get" action="complainthottopic/getTextRecords" >
   <input id="changePageRight" type="submit" value="文本热点查询" class="btn btn-info"> 
   </form>	
   <form role="form"  id="changePageRightForm" method="get" action="querysetting/getServiceRequestType">
   <input id="changePageRight" type="submit" value="查询设置" class="btn btn-info" >	
   </form>
		
</div>
	<div id="container">
		<div id = "header">
			<h1 align=center>投诉文本记录查询</h1>
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
				<p align = "center">
					<input id = "queryInput" type="button"
						value="&nbsp;&nbsp;查&nbsp;&nbsp;&nbsp;&nbsp;询&nbsp;&nbsp;" class="btn btn-info" align='center' >
				</p>
			</div>
			
				<div id="xxx" align = "center">
					<!-- 文本记录 -->
            		<select id="complainTextSelect" style="WIDTH: 700px; HEIGHT: 200px" size="15">
					</select>
					<p align = "center">
					<input  type="button" id= "contentButton"
						value="确定" class="btn btn-info" align='center' >
				    </p>
					<div  style="width: 700px; height: 200px; border: 1px solid #ccc;">
					<label>文本记录内容投诉细项包括</label>
						<input  id="duanyu" name="routePath" style="width:400px;    height:21px" class="input-medium search-query">
					<label>文本记录内容业务层级</label>
						<input  id="cengji" name="routePath" style="width:430px;    height:21px" class="input-medium search-query">
					<br>
						<label>问题分类类型</label>
						<input  id="fenlei" name="routePath" style="width:485px;    height:21px" class="input-medium search-query">
					<br>
						<label>问题细项类型</label>
					<input  id="xixiang" name="routePath" style="width:485px;    height:21px" class="input-medium search-query">
					
					</div>
					
				   <table>
				   <tr>
				    <td>
				    <br>
				    <!-- 主题词 -->
					<SELECT  name="keyword" id="keywordSelect" style="WIDTH: 470px; HEIGHT: 200px" size="15">
					</select>
					</td>
					<td>
					<!--  
					<div id="tagsList"> 
					  <style type="text/css">      
                      #tagsList {position:relative; width:250px; height:200px; margin: 150px auto 0;  }
                      #tagsList a {position:absolute; top:0px; left:0px; font-family: Microsoft YaHei; font-weight:bold; text-decoration:none; padding: 3px 6px; }
                      #tagsList a:hover { color:#FF0000; letter-spacing:2px;}
                      </style>
	                 
	                </div>
	                -->
	                <br>
	                <div id="my_favorite_latin_words" style="width: 300px; height: 200px; border: 1px solid #ccc;"></div>
					</td>
				   </tr>
				</table>
				</div>			
			
		
			<div id="matchButton">
				<p align='center'>
					<input id = "matchInput" type= "button" value="&nbsp;&nbsp;匹&nbsp;&nbsp;&nbsp;&nbsp;配&nbsp;&nbsp;"class="btn btn-info" />
				</p>
			</div>
			
			<div id="textResule" align="center">
				<p >文本记录匹配结果</p>         	
            	<select id="matchingComplaintTextsSelect" style="WIDTH: 700px; HEIGHT: 200px" size="15">
				</select>
			</div>

            <div id="skipButton" align = "center">			
						<input id = "clickInput" type="button" style="width: 60px;"	value="确认" class="btn btn-info">
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
						<SELECT id="forder"  style="WIDTH: 400px; HEIGHT: 240px" 
						size="15">
		
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
	
					<td>
					<SELECT id="unforder"  style="WIDTH: 400px; HEIGHT: 240px" size="15">
							
					</select>
					</td>
					<td><input class="submitBtn btn btn-info" id="submitBtn" type="button" value="提交" /></td>
					</tr>

				</table>
			</form>
		</div>
		
		<div id="relatedWord" align="left">
			<form id="relatedWordForm" action="segmentation/getRelatedWord" method="POST">
				<table align="center">

					<tr>
						
						<td style="width:350px;Height:240px" >

							<p align="center" id="one">
							</p>
						</td>
						<td align="center"><label> 关联 </label></td>
						<td style="width:350px;Height:240px">
							<p align="center" id="many">
							</p>
						</td>	
						<td align="center">
						</br>
						<INPUT class="submit btn btn-info" type="submit" value="确认" />
						</td>
						<td>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
    </br>
    </br>
</body>
</html>
