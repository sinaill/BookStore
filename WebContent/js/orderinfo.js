var R = false, A = false, P=false; M=false//用于验证表单

//智能填表
$(function(){
	$("#addressId").val(-1);
	var ops = $("#address");//下拉列表
	
	$.post("address",
			{"json":true},
			function(data){
				appendOps(data);
				ops.change(function(){
				fillForm(data,$(this).val());
			});
			
	
	});
	
	//动态增加下拉列表
	function appendOps(addrs){
		for(var i=0;i<addrs.length;i++){
			var k = i+1
			ops.append("<option value="+i+">"+k+":"+addrs[i].address.substr(0,6)+"...</option>");
		}
	}
	
	//根据选项智能填表
	function fillForm(addrs,index){
		if(index==-1){
			$("#recieveName").val('');
			$("#fullAddress").val('');
			$("#postalCode").val('');
			$("#mobile").val('');
			$("#addressId").val(-1);
			return;
		}
		A=true;
		R=true;
		P=true;
		M=true;
		$("#nameValidMsg>span").html('');
		$("#addressValidMsg>span").html('');
		$("#recieveName").val(addrs[index].reciever_name);
		$("#fullAddress").val(addrs[index].address);
		$("#postalCode").val(addrs[index].postal_code);
		$("#mobile").val(addrs[index].mobile);
		
		$("#addressId").val(addrs[index].id);
		
	}
});

//表单验证
$(function(){
	//验证收件人姓名
	$("#recieveName").blur(function(){
		R = false;
		var val = $(this).val();
		var info = $("#nameValidMsg>span");
		info.text("");
		if(val == ""){
			info.text("收件人不能为空");
		}else{
			info.html("<img src='../images/my/ajax_ok.png' />");
			R = true;
		}
	});
	
	//验证详细地址
	$("#fullAddress").blur(function(){
		A = false;
		var val = $(this).val();
		var info = $("#addressValidMsg>span");
		info.text("");
		if(val == ""){
			info.text("收信地址不能为空");
		}else{
			info.html("<img src='../images/my/ajax_ok.png' />");
			A = true;
		}
	});
	
	//验证邮编
	$("#postalCode").blur(function(){
		P = false;
		var val = $(this).val();
		var info = $("#codeValidMsg>span");
		info.text("");
		if(val == ""){
			info.text("邮政编码不能为空");
		}else if (!val.match(/^[0-9]{6,6}$/)) {
			info.text("邮编格式不正确");}else{
			info.html("<img src='../images/my/ajax_ok.png' />");
			P = true;
		}
	});
	//验证手机号码
	$("#mobile").blur(function(){
		M = false;
		var val = $(this).val();
		var info = $("#mobileValidMsg>span");
		info.text("");
		if(val == ""){
			info.text("手机号码不能为空");
		}else if(!val.match(/(^0{0,1}1[3|4|5|6|7|8|9][0-9]{9}$)/)){
			info.text("手机号码格式不正确")
		}else{
			info.html("<img src='../images/my/ajax_ok.png' />");
			M = true;
		}
	})
	
	
	//当地址和收件人正确填写后，才能点击提交
	$("#btnClientRegister").click(function(){
		if(A && R && P && M){
			return true;
		}else{
			alert("请正确填写信息")
			return false;
		}
	});
		

});