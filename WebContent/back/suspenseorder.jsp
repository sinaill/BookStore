<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/allorder.css"/>
    </head>
    <body>
    	<div class="main">
    		<div class="logo">
    			<a href="${pageContext.request.contextPath}/main/main.jsp"><img src="${pageContext.request.contextPath}/images/logo.gif"/></a>
    			
    		</div>
    		<hr />
   
    		<div class="menu_left">
				<ul>
					<li class="test">管理员 
					<ul>
						<li><a href="${pageContext.request.contextPath}/back/modifypassword.jsp">修改密码</a></li>

					</ul></li>
					<li class="test">会员管理 
					<ul>
						<li><a href="getnobanuser.action">所有会员</a></li>
						<li><a href="getbanuser.action">解禁</a></li>

					</ul></li>
					<li class="test">商品管理
					<ul>
						<li><a href="${pageContext.request.contextPath}/back/addproduct.jsp">添加商品</a></li>
						<li><a href="${pageContext.request.contextPath}/back/editproduct.jsp">修改/删除商品</a></li>
					</ul></li>
					
					<li class="test">分类管理
					<ul>
						<li><a href="${pageContext.request.contextPath}/back/category.jsp">管理分类</a></li>
					</ul></li>
					
					<li class="test">订单管理
						<ul>
						<li><a href="suspenseorder.action">新订单</a></li>	
						<li><a href="gettreatedorder.action">所有订单</a></li>
					</ul>
					</li>
					<li class="test">库存
					<ul>
						<li><a href="getallproducts.action">添加库存</a></li>	
					</ul></li>
				</ul>
    		</div>
    		<div class="right">
    		<s:iterator value="orders">
    			<table rules=rows      align="center" class="user">
    				
    				<tr class="head">
    					<td>${date}&nbsp;&nbsp;&nbsp;订单号:${id }</td>
    					<td></td>
    					<td>订单状态:</td>
    					<td>${state }</td>
    				</tr>
    				<s:iterator value="items">
    					<tr>
    						<td><img class="book_pic"  src="${pageContext.request.contextPath}/productImages/${product_pic}"/><br /><br />
    							&nbsp;&nbsp;&nbsp;<span class="book_name">${product_name }</span>
    						</td>
    							<td>${price }¥&nbsp;&nbsp;</td>
								<td>${product_num }</td>
								<td>${amount }¥</td> 
    				</tr>
    				</s:iterator>
    				
    				
    				<tr>
    					<td colspan="4" class="address">地址:${address.address }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;邮编:${address.postal_code }<br/>
    						收件人:${address.reciever_name }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;联系电话:${address.mobile }
    					</td>
    				</tr>
					<tr>	
    					<td>总计:&nbsp;&nbsp;&nbsp;${amount }¥</td>
    					<td></td>
    					<td></td> 
    					<td><a href="deliver.action?order_id=${id }"><img src="${pageContext.request.contextPath}/images/fahuo.jpg"/></a></td>
    				</tr>
    				  
    				  
    			</table>
    		</s:iterator>
    		
    		</div>
    		
    	</div>
    	
 	</body>
</html>