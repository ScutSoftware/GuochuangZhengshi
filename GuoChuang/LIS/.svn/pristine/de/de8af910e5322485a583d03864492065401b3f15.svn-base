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
<p align="center">
  <form role="form" align="center" id="changePageLeftForm" method="get" action="getServiceRequestType" >
   <input id="changePageLeft" type="submit" value="文本记录查询页面" class="btn btn-info">	
   </form>
   <br/>
   <form role="form" align="center" id="changePageMiddleForm" method="get" action="getTextRecords">
   <input id="changePageRight" type="submit" value="文本热点查询页面" class="btn btn-info">	
   </form>
   <br/>
   <form role="form" align="center" id="changePageRightForm" method="get" action="querySetting">
   <input id="changePageRight" type="submit" value="查询设置" class="btn btn-info">	
   </form>
 </p>	
 <table align="center">
   <tr>
    <td>
     <!--  <form  id="confirmForm" method="post" action="getConfirm" >
     -->
     <p align=center>投诉热点与情感趋势分析</p>
     <!--  
     <input	type="submit" value="最近N1小时内">  </input>
     <input	type="submit" value="最近N1小时内">  </input>
     <input	type="submit" value="最近N1小时内">  </input>
     -->
     <br />
     <br />
     <br />
     <br />
     
     <SELECT id="keywordList" name="keywordList" style="WIDTH: 800px; HEIGHT: 400px" size="15">
                             <c:forEach items="${keywordList}" var="keywordListAll">
							
							<option value="${keywordListAll}">${keywordListAll}</option>
							
							</c:forEach>
	</select>
    <br />
    <p align="left" id = keyword1>主题词:  </p>
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
			data:"keyword="+ $("#keywordList").val(),
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
				$("#keyword1").append("<p>"+$("#keywordList").val()+"</p>");
				$("#emotion1").append("<p>"+data.emotionLevel+"</p>");
			
			}
			});		
	 
		});
   
   
    </script>
  </div>
    <!--  
     </form>
    -->
     </td>

    </tr>
   </table>
    <table align="center">
   <tr>

    
    <td>
    <p align="center">对应文本记录列表   </p>
    <SELECT id="forder" style="WIDTH: 800px; HEIGHT: 400px" size="15">
						

	</select>
    </td>
    </tr>
</table>
</body>
</html>
