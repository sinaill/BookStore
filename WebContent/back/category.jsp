<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/js/jquery-1.4.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/category.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/category.css" />
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
    			
	
	<form action="addcategory" class="addfirst" onsubmit="return false">
		添加一级分类&nbsp<input type="text" name="category_name" id="fircategoryname">
		<input type="submit" value="添加">
	</form>
	
	<form action="addcategory" class="addsecond" onsubmit="return false">
		
		添加二级分类&nbsp<select class="addlist">
					</select> 
		
		<input type="text" name="category_name" id="seccategoryname">
		<input type="submit" value="添加">
	</form>
	
	<form action="deletegory" class="deletefirst" onsubmit="return false">
		删除一级分类&nbsp<select class="deletefirlist"></select>
		<input type="submit" value="删除">
	</form>
	
	<form action="deletegory" class="deletesecond" onsubmit="return false">
		删除二级分类&nbsp<select class="deleteseclist" onchange="cha()"></select>&nbsp
		<select class="secondlist"></select>
		<input type="submit" value="删除">
	</form>
    		</div>
    		
    	</div>
</body>
</html>