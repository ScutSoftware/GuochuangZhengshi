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
<title>主题词更正与反馈</title>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script>
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
	
	//点击上边确认
	function submitOption(obj, obj2) {
		var word = new Array();
		for(var i = 0; i < obj.options.length; i++) {
			word.push(obj.options[i].value);
		}
		alert(word);
 	 	$.ajax({ 
               url: "keyword/addKeyWork", 
               type: 'POST', 
               data: {"word": JSON.stringify(word)},  
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

</head>

<body>
	
	<h2 align="center">主题词更正与反馈</h2>

	<p align='center'>
		<label>添加主题词：</label>
		<input type="text" name="addSite" id="addSite"
			onblur="isDomain(this.value)" /> <input value="确认"
			style="width: 70px;" type="button"
			onclick="moveOption(document.getElementById('addSite'),document.getElementById('forder'))" />
	</p>
	<br />
	<form id="wordForm" action="keyword/relationKeyWord" method="post">
		<table align="center">
			<TR>
				<td>
					<SELECT id="forder"  style="WIDTH: 304px; HEIGHT: 240px" 
					size="15">
						<c:forEach items="${wordList}" var="item"  varStatus="status">
							<OPTION value="${item.word}">${item.word}</OPTION>
						</c:forEach>
						
					</select>
				</td>
				<td><INPUT class="upBtn" type="button" value="向上↑"
					onmousedown="setTimeStart('up');" onmouseup="clearTimeout(x);"
					onclick="listObj=document.getElementById('unforder');upListItem();clearTimeout(x);"
					ID="Button1" NAME="Button1" /> <br /> <INPUT
					style="WIDTH: 48px; HEIGHT: 22px" type="button" value="↓向下"
					class="downBtn" onmousedown="setTimeStart('down');"
					onmouseup="clearTimeout(x);"
					onclick="listObj=document.getElementById('unforder');downListItem();clearTimeout(x);"
					ID="Button2" NAME="Button2" /><br /> <INPUT
					style="WIDTH: 48px; HEIGHT: 22px" type="button" value="选取"
					onmousedown="setTimeStart('down');" onmouseup="clearTimeout(x);"
					onclick="chooseOption(document.getElementById('forder'),document.getElementById('unforder'))" />
				</td>

				<TD><SELECT id="unforder"  style="WIDTH: 304px; HEIGHT: 240px"
					size="15">
						
				</select></td>
				<td><input class="submitBtn" type="button" style="WIDTH: 48px; HEIGHT: 22px" onclick="submitOption(document.getElementById('unforder'),document.getElementById('wordForm'))" 
					value="确认" /></td>
			</tr>
		</table>
	</form>
	<form action="keyword/getRelatedWord" method="POST">
		<table align="center">
			<tr>
				<td>
				
					<c:forEach items="${wordList2}" var="word"  varStatus="status">
							<input id="inputTopic"type="radio" name="keyWord" value="${word}" />${word}<br/ >
					</c:forEach>
				</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><label> 关联 </label></td>

				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>

				<td>
					<c:forEach items="${wordList2}" var="word"  varStatus="status">
							<input type="checkbox" name="list" value="${word}" />${word}<br />
					</c:forEach>
					
				</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>

				<td>
				<INPUT type="submit" style="WIDTH: 48px; HEIGHT: 22px" value="确认" />
				</td>
			</tr>

		</table>
	</form>
</body>
</html>

