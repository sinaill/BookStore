<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/address.css"/>
        <title>收货地址</title>
    </head>
    <body>
    	<div class="main">
    		<div class="logo">
    			<a href="${pageContext.request.contextPath}/main/main.jsp"><img src="${pageContext.request.contextPath}/images/logo.gif"/></a>
    			
    		</div>
    		<hr />
   
    		<div class="menu_left">
    		<fieldset id="">
    				<legend>状态</legend>
    				
    			<ul>
    			    <li>${user.nickname }</li>
    				<li>上次登录时间</li>
    				<li>${user.last_logintime }</li>
    				
    			</ul>
    			</fieldset>
    			<fieldset id="">
    				<legend>我的订单</legend>
    				
    			<ul>
    				<li><a href="untreated.action"><s:action name="untreatednum" executeResult="true"/></a></li>
    				<li><a href="delivered.action"><s:action name="deliverednum" executeResult="true"/></a></li>
    				<li><a href="recieved.action">已收货</a></li>
    				<li><a href="myorder.action">所有订单</a></li>
    			</ul>
    			</fieldset>
    			<fieldset id="">
    				<legend>我的地址</legend>
    				
    			<ul>
    				<li><a href="address.action">地址管理</a></li>
    			</ul>
    			</fieldset>
    			<fieldset id="">
    				<legend>我的密码</legend>
    				
    			<ul>
    				<li><a href="${pageContext.request.contextPath}/mydangdang/password.jsp">密码管理</a></li>
    			</ul>
    			</fieldset>
    			

    		</div>
    		
    		<div class="content_right">
    			<table>
		<tr class="start">
			<th>收件人</th>
			<th>地址</th> 
			<th>邮编</th>
			<th>手机号码</th>
		</tr>
		<s:iterator value="addresses">
		<tr>
			<td>${reciever_name }</td>
			<td>${address }</td>
			<td>${postal_code }</td>
			<td>${mobile }</td>
			<td><a href="address.action?address_id=${id }" class="switch">编辑</a></td>
			<td><a href="deleteaddress.action?address_id=${id }">删除</a></td>
	    </tr>
		</s:iterator>
		
	</table>
	
	<div class="hidden">
	 
	<form action="addaddress.action" method="post">
		<input type="hidden" value="<s:property value="address.id"/>" class="addressswitch" name="address_id">
		&nbsp;&nbsp;&nbsp;&nbsp;收件人:<input type="text" name="address.reciever_name" value="<s:property value="address.reciever_name"/>">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;地址:<input type="text" name="address.address" value="<s:property value="address.address"/>"><br/><br />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;邮编:<input type="text" name="address.postal_code" value="<s:property value="address.postal_code"/>">
		&nbsp;&nbsp;&nbsp;&nbsp;手机号码:<input type="text" name="address.mobile" value="<s:property value="address.mobile"/>"><br/><br />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
		<input class="submit" type="submit" value="保存">
	</form>
			</div>
	
	
    		</div>
    	</div>
 	</body>
</html>