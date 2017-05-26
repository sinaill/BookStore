<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.4.3.js"></script>
		<script type="text/javascript">
			function change(){
				var new_password = $('#newpw').val();
				var email = $('#get').val();
				$.post("modifypassword",{"fpw":true,
					"email":email,
					"new_password":new_password},
				function(data){
					if(data){
						alert("修改密码成功")
						window.location.href="login_form.jsp"
					}
				})
			}
			function send(){
				var email = $('#get').val();
				$.post("getveryfication",{"email":email},
				function(data){
					alert("已发送验证码")
				})
			}
			function show(){
				$('#password').show();
			}
			
			
			
		     $(function(){
		    	 
		       $('#register_ok').submit(function(){ 
		    	   var email = $('#get').val();
		          var validateCode = $('#validateCode').val();
		          if(validateCode==''){
		            $('#errorMsg').html('请输入邮箱验证码');
		             return false;
		          }
		          $.post(
		           'checkemailcode.action',
		           {'Emailcode':validateCode,
		        	   "fpw":true,
		        	   "email":email},
		           function(date){
		             if(date){
		               show();
		             }else{
		               $('#errorMsg').html('邮箱验证码不正确');  
		             }
		           }
		         ); 
		         return false;
		       });
		     });
		</script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>


		<form action="/user/register_ok.jsp" method="post" id="register_ok">
			<div class="validate_email">
				<h2>
					请按以下步骤完成找回密码!
				</h2>
				<div class="look_email">
					<h4>
						第一步：输入您的电子邮箱
					</h4>
					<div class="mess reduce_h">
					<div class="mess">
						<span class="write_in">邮箱：</span>
						<input style="width: 200px" name="code" type="text"  class="yzm_text" id="get"/>
						<input class="finish" style="float:left;margin-left:20px" type="button" value="发送验证码" id="Button1" onclick="send()"/>
					</div>
					</div>
					<h4>
						第二步：输入验证码
					</h4>
					
					<div class="mess">
						<span class="write_in">输入您收到邮件中的验证码：</span>
						<input name="code" type="text" id="validateCode" class="yzm_text" />
						<input class="finsh" type="submit" value="完 成" id="Button1" />
						<span id="errorMsg" class="no_right"></span>
					</div>
					<h4>
						第三步：输入新密码
					</h4>
					
					<div class="mess" id="password" style="display:none">
						<span class="write_in">新密码：</span>
						<input name="code" type="password"class="yzm_text" id="newpw"/>
						<input class="finsh" type="button" value="确定" id="Button1" onclick="change()"/>
						<span id="errorMsg" class="no_right"></span>
					</div>
				</div>
			</div>
		</form>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

