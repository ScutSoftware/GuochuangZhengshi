<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>文本匹配结果</title>

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
		// //添加
		// function moveOption(obj1, obj2){    
  //   		objValue = obj1.value;  
      		
  //   		if(objValue==""){  
  //       		alert("请输入要添加的数据！");  
  //       		return false;  
  //   		}  
  //   		for(var i = 0; i< obj2.options.length; i++) {  
  //      	 		if(objValue==obj2.options[i].value){  
  //           	alert("该数据已经存在！");  
  //           	return false;  
  //       		}  
  //  	 		}  
  //   		var opt = new Option(objValue,objValue);    
  //   		opt.selected = true;    
  //   		obj2.options.add(opt);    
		// }  
		// //选取
		// function chooseOption(obj1,obj2) {
		// 	var selIndex = obj1.selectedIndex;
		// 	var selValue = listObj.options[selIndex].value;
		// 	for(var i = 0; i < obj2.options.length; i++) {
		// 		if(selValue == obj2.options[i].value) {
		// 			alert("该数据已经存在！");
		// 			return false;
		// 		}
		// 	}
		// 	alert(selValue);
		// 	var opt = new Option(selValue, selValue);
		// 	opt.selected = true;
		// 	obj2.options.add(opt);
		// }
		// //将选中item向上
		// function upListItem() {
		// 	var selIndex = listObj.selectedIndex;
		// 	if (selIndex < 0) {
		// 		if (x != null) {
		// 			clearTimeout(x);
		// 		}
		// 		return;
		// 	}
		// 	if (selIndex == 0) {
		// 		if (x != null) {
		// 			clearTimeout(x);
		// 		}
		// 		return;
		// 	}
		// 	var selValue = listObj.options[selIndex].value;
		// 	var selText = listObj.options[selIndex].text;
		// 	listObj.options[selIndex].value = listObj.options[selIndex - 1].value;
		// 	listObj.options[selIndex].text = listObj.options[selIndex - 1].text;
		// 	listObj.options[selIndex - 1].value = selValue;
		// 	listObj.options[selIndex - 1].text = selText;
		// 	listObj.selectedIndex = selIndex - 1;
		// 	if (selIndex + 1 > 0) {
		// 		x = setTimeout(upListItem, 200)
		// 	}
		// }
		//将选中item向下
		// function downListItem() {
		// 	var selIndex = listObj.selectedIndex;
		// 	if (selIndex < 0) {
		// 		if (x != null) {
		// 			clearTimeout(x);
		// 		}
		// 		return;
		// 	}
		// 	if (selIndex == listObj.options.length - 1) {
		// 		if (x != null) {
		// 			clearTimeout(x);
		// 		}
		// 		return;
		// 	}
		// 	var selValue = listObj.options[selIndex].value;
		// 	var selText = listObj.options[selIndex].text;
		// 	listObj.options[selIndex].value = listObj.options[selIndex + 1].value;
		// 	listObj.options[selIndex].text = listObj.options[selIndex + 1].text;
		// 	listObj.options[selIndex + 1].value = selValue;
		// 	listObj.options[selIndex + 1].text = selText;
		// 	listObj.selectedIndex = selIndex + 1;
		// 	if (selIndex + 1 < listObj.options.length - 1) {
		// 		x = setTimeout(downListItem, 200)
		// 	}
		// }
	</script>
</head>

<body>
	
    <form role="form"  id="matchform" method="post" action="segmentation/getMatchingComplaintTexts">
	<table align="center">
   		<TR>
        	<td>
            	<p align='center'>文本记录匹配</p><br/>            	
            	<SELECT id="forder" style="WIDTH: 500px; HEIGHT: 240px" size="15">
								<c:forEach items="${matchingComplaintTexts}" var="matchingComplaintText">
							
								<option value="${matchingComplaintText}">${matchingComplaintText}</option>
							
								</c:forEach>
				</select>
			</td>
        </TR>
        
        <TR>
        	<td>
            <p align='center'>
          <input type="submit" value="跳转">
        </p>
            </td>
        </TR>
     </table>
     </form>
       
     
    
</body>
</html>
