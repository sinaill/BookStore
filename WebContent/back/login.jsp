<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/loginmag.css"/>
</head>
<body>
<div class="login">
    			<div class="head">
    				<img src="${pageContext.request.contextPath}/images/login.png" class="image"/><br />&nbsp;&nbsp;&nbsp;
    				<span>后台管理系统登录</span><br />
    			</div>
    			
   				<form action="managerlogin.action" method="post">
   					<br/>&nbsp;账号：<input type="text" name="name"class="text"/><br /><br />
   					
   					&nbsp;密码：<input type="password" name="password" class="text"/>
   					<br /><br />
   					<input type="submit" value="登录" class="submit"/><p style="color: red;"><s:property value="#request.login_error"/></p>
   				</form>
   			</div>
</body>
</html>