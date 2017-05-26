//购买按钮相关操作
$(function(){
	$(".buy").click(function(){
		//获取产品id
		var info = $('.mycartinfo');
		var id = $(this).attr("id");
		//将购买按钮消失
		var msg_span = $(this).next();
		var $a = $(this);
		$(this).hide();
		//发送ajax购买请求
		$.post(
			"addtocart.action",
			{"product_id":id},
			function(data){//data为action返回的buy值
				if(data == true){
					info.html("已加入购物车！");
					$a.show(1000);
				}else{
					info.html("库存不足");
					$a.show(1000);
				}
			}
		);
		return false;//取消href功能
	});
	
});