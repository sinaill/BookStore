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
				   "addfirstcat":false},
				   function(data){
					   window.location.reload();
				   }
			)
		})
		
	
		$('.addfirst').submit(function(){
			var categoryname = $('#fircategoryname').val();
			$.post(
			   "addcategory.action",
			   {"category_name":categoryname,
				   "addfirstcat":true},
				   function(data){
					   window.location.reload();
				   }
			)
		})
		
		
		$('.deletefirst').submit(function(){
			var option = $('.deletefirlist option:selected').val();
			$.post("deletecategory.action",
					{"category_id":option,
					"deletefirstcat":true},
					   function(data){
						   window.location.reload();
					   }
			)
		})
		
		$('.deletesecond').submit(function(){
	
			var option = $('.secondlist option:selected').val();
			var option2 = $('.deleteseclist option:selected').val();
			$.post("deletecategory.action",
					{"category_id":option2,
					"secondcategory_id":option,
					"deletefirstcat":false},
					   function(data){
						   window.location.reload();
					   }
			)
		})
	});