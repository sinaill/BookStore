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
    <script type="text/javascript">
   window.onload = function(){
	   SameH("menu","right")
   }
function SameH(sidebar,right)
{
    var a=document.getElementById(sidebar);
    var b=document.getElementById(right);
   
    if (a.scrollHeight < b.scrollHeight)
    {
        a.style.height= b.scrollHeight+"px";
    }
    else
    {
        b.style.height= a.scrollHeight+"px";
    }
}
</script>
    <body>
    	<div class="main">
    		<div class="logo">
    			<a href="${pageContext.request.contextPath}/main/main.jsp"><img src="${pageContext.request.contextPath}/images/logo.gif"/></a>
    			
    		</div>
    		<hr />
   
    		<div class="menu_left" id="menu">
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
    		<div class="right" id="right" >
    		<s:iterator value="orders">
    			<table rules=rows      align="center" class="user">
    				
    				<tr class="head">
    					<td>${date}&nbsp;&nbsp;&nbsp;订单号:${id }</td>
    					<td></td>
    					<td>订单状态:</td>
    					<td><span style="color:red;font-weight:bold;font-family:Arial;">${state }</span></td>
    				</tr>
    				<s:iterator value="items">
    					<tr>
    						<td><img class="book_pic"  src="${pageContext.request.contextPath}/productImages/${product_pic}"/><br /><br />
    							&nbsp;&nbsp;&nbsp;<span class="book_name">${product_name }</span>
    						</td>
    							<td>${price }元&nbsp;&nbsp;</td>
								<td>${product_num }</td>
								<td>${amount }元</td> 
    				</tr>
    				</s:iterator>
    				
    				
    				<tr>
    					<td colspan="4" class="address">地址:${address.address }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;邮编:${address.postal_code }
    					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    					<span style="color:blue"><a href="getuserbyemail.action?email=${user.email }">用户：${user.email }</a></span> 
    					<br/>
    						收件人:${address.reciever_name }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;联系电话:${address.mobile }
    					</td>
    				</tr>
					<tr>	 
    					<td><span class="total">总计:&nbsp;&nbsp;&nbsp;${amount }元</span></td>
    					<td></td>
    					<td></td>
    					<s:if test='state=="未受理"'>
    					<td><a href="deliver.action?order_id=${id }"><img src="${pageContext.request.contextPath}/images/fahuo.jpg"/></a></td>
    					</s:if> 
    				</tr>
    				  
    				  
    			</table>
    		</s:iterator>
    		<div class="page">
    				<s:if test="page > 1">
    				<div class="last">
    					<a href="gettreatedorder.action?page=${page-1 }">上一页</a>&nbsp;&nbsp;&nbsp;
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
    					<a href="gettreatedorder.action?page=${page+1 }">下一页</a>&nbsp;&nbsp;&nbsp;
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