<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/orders.css"/>
        <script src="${pageContext.request.contextPath}/js/jquery-1.4.3.js"></script>
	<script type="text/javascript">
		$(function(){
			
		})
	</script>
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
    		
    		<div class="order_right">
    		<s:iterator value="orderes">
    		
    			<table rules=rows   cellspacing=0   align="center">
    				
    				<tr>
    					<td>${date }  订单号:${id }</td> 
    					<td></td>
    					<td>订单状态:</td>
    					<td><span class="red" style="color:white">${state }</span></td>
    				</tr>
    				<s:iterator value="items">
    				<tr>
    					<td><img class="book_pic"  src="${pageContext.request.contextPath}/productImages/${product_pic}"/><br /><br />
    						<span class="book_name">${product_name }</span>
    					</td>
    					<td>${price }元</td>
						<td>${product_num }件</td>
						<td>${amount }元</td>
    				</tr>
    				
    				</s:iterator>
    				<tr>	
    					<td><span class="total">总计&nbsp&nbsp&nbsp&nbsp ${amount }元</span></td>
    					<td></td>
    					<td></td>
    					<s:if test='state =="已发货"'>
    					<td><a href="recieve?order_id=${id }"><img class="confirm" src="${pageContext.request.contextPath}/images/confirm.png"/></a></td>
    					</s:if>
    					<s:if test='state == "未受理"'>
    					<td><a class="total" href="cancelorder.action?order_id=${id }" style="border:1px solid red;border-radius:5px">取消订单</a></td>
    					</s:if>
    				</tr>
    			</table>
    			</s:iterator>
    			<div class="page">
    				<s:if test="page > 1">
    				<div class="last">
    					<a href="myorder.action?page=${page-1 }">上一页</a>&nbsp;&nbsp;&nbsp;
    				</div>
    				</s:if>
    				<s:else>
    				<div class="last2">
    					上一页&nbsp;&nbsp;&nbsp;
    				</div>
    				</s:else>
    				<div class="thispage">
    					第${page }页/共${totalPage }页&nbsp;&nbsp;&nbsp;
    				</div>
    				<s:if test="page < totalPage">
    				
    				<div class="next">
    					<a href="myorder.action?page=${page+1 }">下一页</a>&nbsp;&nbsp;&nbsp;
    				</div>
    				</s:if>
    				<s:else>
    				<div class="next2">
    					下一页&nbsp;&nbsp;&nbsp;
    				</div>
    				</s:else>
    			</div>
    		</div>
    		
    	</div>
    	
 	</body>
</html>