<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/stock.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.3.js"></script>
     <script>
        	
        function change(id){
        	var num = prompt("请输入添加库存的数量", "");
        	if(num){
        		$.post("addstock.action",
            			{"product_id":id,"num":num},
            			function(data){
            				if(data){
            					alert("添加成功");
            					window.location.reload();
            				}else{
            					alert("添加失败");
            				}
            			})
        	}
        	
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

</head>
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
    		<div class="right" id="right">
    			<table rules=rows  align="center" class="user">
    				<tr>
						<td>ISBN</td>
						<td>书名</td>
						<td>作者</td>
						<td>出版社</td>
						<td>出版时间</td>
						
						<td>库存</td>
						<td>操作</td>
					</tr>
				<s:iterator value="products">
					<tr>
    					<td>${ISBN }</td>
    					<td>${name }</td>
    					<td>${author }</td>
    					<td>${publisher }</td>
    					<td>${publish_time }</td>
    					<td>${stock }</td>
    					<td><a href="#" onclick="change(${id});return false">添加库存</a></td>
    				</tr>
				</s:iterator>
    			</table>
    			<div class="page">
    				<s:if test="page > 1">
    				<div class="last">
    					<a href="getallproducts.action?page=${page-1 }">上一页</a>&nbsp;&nbsp;&nbsp;
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
    					<a href="getallproducts.action?page=${page+1 }">下一页</a>&nbsp;&nbsp;&nbsp;
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
    		
    		<script type="text/javascript">SameH("menu","right");</script>
    	</div>
</body>
</html>