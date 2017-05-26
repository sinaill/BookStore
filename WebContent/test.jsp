<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/jquery-1.4.3.js"></script>

<script type="text/javascript">
	function cha(){
		$('.secondlist').empty();
		var id = $('.deleteseclist option:selected').val();
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
				$('.addlist').append("<option value="+data[i].id+">"+data[i].name+"<option/>");
				$('.deletefirlist').append("<option value="+data[i].id+">"+data[i].name+"<option/>");
				$('.deleteseclist').append("<option value="+data[i].id+">"+data[i].name+"<option/>");
			}
		})
		
		
		
		$.post("secondcategory.action",
					{"category_id":2},
					function(data){
						for(var i =0;i<data.length;i++){
							$('.secondlist').append("<option value="+data[i].id+">"+data[i].name+"<option/>");
						}
					})
		

		
		$('.addsecond').submit(function(){
			var category_name = $('#seccategoryname').val();
			var option = $('.addlist option:selected').val();
			$.post(
			   "addcategory.action",
			   {"category_name":category_name,
				   "category_id":option,
				   "addfirstcat":false}
			)
		})
		
	
		$('.addfirst').submit(function(){
			var categoryname = $('#fircategoryname').val();
			$.post(
			   "addcategory.action",
			   {"category_name":categoryname,
				   "addfirstcat":true}
			)
		})
		
		
		$('.deletefirst').submit(function(){
			var option = $('.deletefirlist option:selected').val();
			$.post("deletecategory.action",
					{"category_id":option,
					"deletefirstcat":true})
		})
		
		$('.deletesecond').submit(function(){
	
			var option = $('.secondlist option:selected').val();
			var option2 = $('.deleteseclist option:selected').val();
			$.post("deletecategory.action",
					{"category_id":option2,
					"secondcategory_id":option,
					"deletefirstcat":false})
		})
	});
</script>
</head>

<body>
	<form action="addcategory" class="addsecond" onsubmit="return false">
		
		添加二级分类&nbsp<select class="addlist">
					</select> 
		
		<input type="text" name="category_name" id="seccategoryname">
		<input type="submit" value="添加">
	</form>
	
	<form action="addcategory" class="addfirst" onsubmit="return false">
		添加一级分类&nbsp<input type="text" name="category_name" id="fircategoryname">
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
</body>
</html>