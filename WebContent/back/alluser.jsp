<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/alluser.css"/>
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
						<li><a href="suspenseorder.action"><s:action name="suspensenum" executeResult="true"/></a></li>	
						<li><a href="deliveredBack.action"><s:action name="deliverednumBack" executeResult="true"/></a></li>	
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
    			<table class="user" rules=rows   cellspacing=0   align="center">
    				<tr>
    					<th>ID</th>
    					<th>昵称</th>
    					<th>账户</th>
    					<th>上次登录时间</th>
    					<th>操作</th>
    				</tr>
    				<s:iterator value="users">
    				<tr>
    					<td>${id }</td>
    					<td><s:property value="nickname"/></td>
    					<td><s:property value="email"/></td>
    					<td><s:property value="last_logintime"/></td>
    					<td><a href="banuser.action?email=${email }">封禁</a></td>
    				</tr>
    				</s:iterator>
    				
    			</table>
    			<div class="page">
    				<s:if test="page > 1">
    				<div class="last">
    					<a href="getnobanuser.action?page=${page-1 }">上一页</a>&nbsp;&nbsp;&nbsp;
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
    					<a href="getnobanuser.action?page=${page+1 }">下一页</a>&nbsp;&nbsp;&nbsp;
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