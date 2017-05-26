<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/jquery-1.4.3.js"></script>
<script type="text/javascript">

	$(function(){
		
			$('.switch').click(function(){
			$('.addressswitch').val("修改")
		}
		)
		

	})

</script>
</head>
<body>


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
		收件人:<input type="text" name="address.reciever_name" value="<s:property value="address.reciever_name"/>">
		地址:<input type="text" name="address.address" value="<s:property value="address.address"/>">
		邮编:<input type="text" name="address.postal_code" value="<s:property value="address.postal_code"/>">
		手机号码:<input type="text" name="address.mobile" value="<s:property value="address.mobile"/>">
		<input type="submit" value="确定">
	</form>
	</div>
	
</body>
</html>