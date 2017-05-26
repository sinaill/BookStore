<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<script type="text/javascript" src="../js/prototype-1.6.0.3.js">
		</script>
		<link href="${pageContext.request.contextPath}/css/book.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/second.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/list.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/search.css" rel="stylesheet" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.4.3.js"></script>
		<script>
		
		
		window.onload = function(){
	
			   SameH("left","divRight")
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
		        b.style.height= a.scrollHeight-14+"px";
		    }
		}
		
		
		  //添加购买处理
			$(function(){
				$(".buy").click(function(){
					//获取产品id
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
								msg_span.html("已加入购物车！");
								$a.show(5000);
							}else{
								msg_span.html("已购买，去购物车修改数量！");
								$a.show(5000);
							}
						}
					);
					return false;//取消href功能
				});
			});
		</script>
	</head>
	<body>
		&nbsp;

		<!-- 头部开始 -->
		<%@include file="../common/head.jsp"%>
		<!-- 头部结束 -->

		<div style="width: 962px; margin:auto;background-color:white;">
			<div class="content">
   			<div class="search">
   				<form action="getproduct.action" method="post" style="margin-top:-10px">
   					<input type="text" name="product_name" class="search_kuang" placeholder="搜索宝贝" value="${product_name }"/>
   					<input type="submit" value="搜索" class="search_button" />
   				</form>
   			</div>
   			</div>
		</div>
		<div class='your_position'>
			您现在的位置:&nbsp;
			<a href='#'>当当图书</a> &gt;&gt;
			<font style='color: #cc3300'><strong></strong> </font>
		</div>
		<div class="book">

			<!--左栏开始-->
			<div id="left" class="book_left">
				<s:action name="category" executeResult="true"/>
				<div class="empty_left">
				</div>
			</div>

			<div class="more2">
			</div>
			<!--1级分类结束-->
							<li>
								<div></div>
							</li>
						</ul>
					</div>
				</div>
			</div>

			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">

				<!--图书列表开始-->
				<div id="divRight" class="list_right" style="background-color:white;margin-top:-10px;padding-bottom:-23px">

					<div id="book_list" class="list_r_title">
						<div class="list_r_title_text">
							排序方式
						</div>
						<div id="divTopPageNavi" class="list_r_title_text3">

							<!--分页导航开始-->
							<s:if test="page > 1">
							<div class='list_r_title_text3a'>
								<a name=link_page_next
									href="getproduct.action?product_name=${product_name }&page=${page-1 }">
								<img src='../images/page_up.gif' /> 
								</a>
							</div>
							</s:if>
	                        <s:else>
							<div class='list_r_title_text3a'>
								<img src='../images/page_up_gray.gif' />
							</div>
				            </s:else>
							<div class='list_r_title_text3b'>
								第${page }页/共${totalPage}页
							</div>
							<s:if test="page < totalPage">
							<div class='list_r_title_text3a'>
								<a name=link_page_next
									href="getproduct.action?product_name=${product_name }&page=${page+1 }">
									<img src='../images/page_down.gif' />
								 </a>
							</div>
			                 </s:if>
			                 <s:else>
							<div class='list_r_title_text3a'>
								<img src='../images/page_down_gray.gif' />
							</div>
                              </s:else>
							<!--分页导航结束-->
						</div>
					</div>
			<div id="fenlei" style="background-color:white">
	
			<s:iterator value="products">

					<!--商品条目开始-->
						<div class="list_r_line"></div>
						<div class="clear"></div>
						<div class="list_r_list">
							<span class="list_r_list_book"><a name="link_prd_img" href='#'>
								<img src="../productImages/<s:property value='picture'/>" /> </a> </span>
							<h2>
								<a name="" href='productinfo.action?product_id=${id }'><s:property value='name'/></a>
							</h2>

							<h4 class="list_r_list_h4">
								作 者:
								<a href='#' name='作者'>${author}</a>
							</h4>
							<h4>
								出版社：
								<a href='#' name='出版社'><s:property value='publisher'/></a>
							</h4>
							<h4>
								出版时间：
								<s:property value='publish_time'/>
							</h4>
							<h5>
								简介：<s:property value='description'/>
							</h5>
							<div class="clear"></div>
							<h6>
						
								<span class="red">￥<s:property value='price'/></span>
								
							</h6>
							<span class="list_r_list_button"/> 
							<a href="#" class="buy" id="<s:property value='id'/>"> 
							<img src='../images/buttom_goumai.gif' /> </a>
							<span id="cartinfo"></span>
						</div>
						<div class="clear"></div>
						<!--商品条目结束-->
				</s:iterator>
				</div>
					<div class="clear"></div>
					<div id="divBottomPageNavi" class="fanye_bottom">
					</div>
				</div>
				<!--图书列表结束-->
			
			</div>
			<!--中栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
		<s:debug></s:debug>
	</body>
</html>