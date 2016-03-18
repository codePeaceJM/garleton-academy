<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <a href="userAction!log?name=admin&pwd=admin">登录</a> <br>
    <a href="userAction!search?name=admin">搜索</a> <br>
    <a href="userAction!search">查看</a> <br>
    <a href="userAction!del?id=1">删除</a> <br>
       <form action= "commentAction!add" method= "post">
  		
  		名称：<input type = "text" name ="newsname"/><br>
  		<input type = "submit" value = "添加"/>
   	</form> <br>
   	<form action="commentAction!del" method="post">
   		id:<input type ="text" name="id"/><br>
   		<input type = "submit" value ="删除"/>
   	</form>
   	<form action="districtAction!searchAll" method = "post">
   		<input type="submit" value="查询"/>
   	</form>
   	<form action="newsAction!update" method="post">
   		id:<input type="text" name="id"/><br>
   		name:<input type="text" name="title"/><br>
   		<input type ="submit" value="修改"/>
   	</form>
   	<s:iterator value="districtList">
   		<s:property value="id"/>
   		<s:property value ="name"/>
   	</s:iterator>
  </body>
</html>
