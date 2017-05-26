<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>修改密码</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/password.css"/>
        <script src="${pageContext.request.contextPath}/js/jquery-1.4.3.js"></script>
        <script type="text/javascript">
        	$(function(){
        		$('.password_form').submit(function(){
        			var oldpw = $('.oldpw').val();
        			var newpw = $('.newpw').val();
					$.post("modifypassword",{"old_password":oldpw,"new_password":newpw},
							function(data){
							if(data){
								alert("修改成功")
							}else{
								alert("密码错误")
							}
								
					})
				return false;
			})
        	});
        	
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
    				<li><a href="#">地址管理</a></li>
    			</ul>
    			</fieldset>
    			<fieldset id="">
    				<legend>我的密码</legend>
    				
    			<ul>
    				<li><a href="#">密码管理</a></li>
    			</ul>
    			</fieldset>
    		</div>
    		<div class="content_right">
    			<div class="password">
    				
    			</div>
    			<form action="" method="post" class="password_form">
    				<br /><br /><br /><br /><br /><br /><br /><br />
    				<span class="text">旧密码:&nbsp</span><input type="password" name="old_password" class="oldpw"/><br /><br /><br /><br />
    				<span class="text">新密码:&nbsp</span><input type="password" name="new_password"/ class="newpw"><br /><br /><br />
    				<input type="submit" value="确定" class="button"/>
    			</form> 
    		</div>
    		
    	</div>
    	
 	</body>
</html>