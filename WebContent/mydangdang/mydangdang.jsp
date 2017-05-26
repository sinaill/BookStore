<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mydangdang.css"/>
    </head>
    <body>
    	<div class="main">
    		<div class="logo">
    			<a href="${pageContext.request.contextPath}/main/main.jsp"><img src="${pageContext.request.contextPath}/images/logo.gif"/></a>
    			
    		</div>
    		<hr />
   
    		<div class="menu_left">
    			<br /><br /><br />
    			<a href="myorder.action">我的订单</a><br /><br /><br />
    			<a href="address.action">收货地址管理</a><br /><br /><br />
    			<a href="${pageContext.request.contextPath}/mydangdang/password.jsp">修改密码</a><br /><br /><br />
    		</div>
    		
    		
    	</div>
    	
 	</body>
</html>