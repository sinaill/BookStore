<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/editproduct.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.3.js"></script>
</head>
<script type="text/javascript">

function Delete(){
	var product_id = $('.hidden').val();
	var category_id = $('.secondlist option:selected').val();
	$.post("deleteproduct.action",{
		"product_id":product_id,"category_id":category_id},function(data){
			if(data){
				alert("删除成功")
				window.location.reload();
			}
			
		})
	
}
	
function cha(){
	$('.secondlist').empty();
	var id = $('.list option:selected').val();
	$.post("secondcategory.action",
			{"category_id":id},
			function(data){
				for(var i =0;i<data.length;i++){
					$('.secondlist').append("<option value="+data[i].id+">"+data[i].name+"<option/>");
				}
			})
}


	$(function(){
		$.post("category.action",
				{"json":true},
				function(data){
			for(var i =0;i<data.length;i++){
				$('.list').append("<option value="+data[i].id+">"+data[i].name+"<option/>");
			}
		})
		
				$.post("secondcategory.action",
					{"category_id":2},
					function(data){
						for(var i =0;i<data.length;i++){
							$('.secondlist').append("<option value="+data[i].id+">"+data[i].name+"<option/>");
						}
					})
	})

	


	function search(){
		var ISBN = $('.isbn').val();
		if(!ISBN.match(/^\d{6}$/)){
			alert("输入正确格式ISBN");
			return false;
		}
			$.post("getprobyisbn",{"ISBN":ISBN},
					function(data){
				$('form').show();
				$("[name='product.name']").val(data.name);
				$("[name='product.author']").val(data.author);
				$("[name='product.publisher']").val(data.publisher);
				$("[name='product.publish_time']").val(data.publish_time);
				$("[name='product.description']").val(data.description);
				$("[name='product.price']").val(data.price);
				$("[name='product.words']").val(data.words);
				$("[name='product.revision']").val(data.revision);
				$("[name='product.impression']").val(data.impression);
				$("[name='product.total_page']").val(data.total_page);
				$("[name='product.print_time']").val(data.print_time);
				$("[name='product.ISBN']").val(data.ISBN);
				$("[name='product.sumary']").val(data.sumary);
				$("[name='product.paper']").val(data.paper);
				$("[name='product.packaging']").val(data.packaging);
				$("[name='product.stock']").val(data.stock);
				$("[name='product.id']").val(data.id);
				$("[name='product.picture']").val(data.picture);
			})
	}
</script>
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
    			
    			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    			输入ISBN:<input type="text" name="ISBN" class="isbn"/>
    			<input type="button" value="查找" onclick="search();" class="submit"/>
    			
    			<form action="editproduct.action" method="post" enctype="multipart/form-data">
    				<input type="hidden" class="hidden" name="product.id">
    				<input type="hidden" name="product.picture">
    				&nbsp;&nbsp;书名<input type="text" name="product.name"/>
    				&nbsp;&nbsp;作者<input type="text" name="product.author"/>
    				出版社<input type="text" name="product.publisher"/><br />
    				出版时间<input type="text" name="product.publish_time"/>
    				简要描述<input type="text" name="product.description"/>
    				&nbsp;价格<input type="text" name="product.price"/><br />
    				
    				&nbsp;&nbsp;字数<input type="text" name="product.words"/>
    				&nbsp;&nbsp;版次<input type="text" name="product.revision"/>
    				&nbsp;印次<input type="text" name="product.impression"/><br />
    				&nbsp;总页数<input type="text" name="product.total_page"/>
    				印刷时间<input type="text" name="product.print_time"/>
    				&nbsp;ISBN<input type="text" name="product.ISBN"/><br />
    				内容简介<input type="text" name="product.sumary"/>
    				&nbsp;&nbsp;纸张<input type="text" name="product.paper"/>
    				&nbsp;包装<input type="text" name="product.packaging"/><br />
    				&nbsp;&nbsp;库存<input type="text" name="product.stock"/>
    				
    				&nbsp;&nbsp;分类&nbsp;<select class="list" onchange="cha()">
    					
    				</select>
    				&nbsp;<select class="secondlist" name="category_id">
    					
    				</select><br />
    				&nbsp;&nbsp;图片<input type="file" name="file"/>
    				<input type="submit" value="保存修改" class="submit"/>
    				<input type="button" value="删除" class="delete" onclick="Delete()">
    			</form>
    		</div>
    		
    	</div>
    	
</body>
</html>