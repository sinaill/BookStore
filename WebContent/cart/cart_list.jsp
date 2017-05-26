<%@page pageEncoding="utf-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="${pageContext.request.contextPath}/css/book.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/second.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/shopping_vehicle.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.3.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/cart.list.js"></script>



</head>
	
	<body>
		<br />
		<br />
		<div class="my_shopping">
			<img class="pic_shop" src="${pageContext.request.contextPath}/images/pic_myshopping.gif" />

		</div>
		<div id="div_choice" class="choice_merch">
			<h2 id="cart_tips">
				您已选购以下商品<span style="color:red">${cart_empty}</span>
				&nbsp;&nbsp;&nbsp;<span style="color:red"><a href="cleancart.action">清空购物车</a></span>
			</h2>
			<div class="choice_bord">
				<table class="tabl_buy" id="tbCartItemsNormal">
					<tr class="tabl_buy_title">
						<td class="buy_td_6">
							<span>&nbsp;</span>
						</td>
						<td>
							<span >商品名</span>
						</td>
						<td><span >封面</span>
						</td>
						<td class="buy_td_5">
							<span class="span_w2"></span>
						</td>
						<td class="buy_td_4">
							<span class="span_w3">价格</span>
						</td>
						<td class="buy_td_1">
							<span class="span_w2">数量</span>
						</td>
						<td class="buy_td_2">
							<span>变更数量</span>
						</td>
						<td class="buy_td_1">
							<span>删除</span>
						</td>
					</tr>
					<tr class='objhide' over="no">
						<td colspan="8">
							&nbsp;
						</td>
					</tr>
					
                      <!-- 购物列表开始 -->
                      <s:iterator value="cartitems" var="ci">
						<tr class='td_no_bord'>
						
						
							<td style='display: none'>
							
							</td>
							<td class="buy_td_6">
								<span class="objhide"><img /> </span>
							</td>
							<td>
							<a href="http://localhost:8080/dangdang/main/book_view?id=${ci.product.id }">${ci.product.name }</a>
							</td>
							<td>
								<a href="http://localhost:8080/dangdang/main/book_view?id=${ci.product.id }"><IMG id=img_show_prd
										src="${pageContext.request.contextPath}/productImages/${ci.product.picture }" width="75px"></td>
							<td class="buy_td_5">
								<span class="c_gray"></span>
							</td>
							<td class="buy_td_4">
								&nbsp;&nbsp;
								<span>￥${ci.product.price}</span>
							</td>
							
							<td class="buy_td_1">
								&nbsp;&nbsp;${ci.product_num }
							</td>

							<td >
								<form action="modifycart.action" method="post">
									<input type="hidden" name="product_id" value="${ci.product.id }"/>
									<input  class="del_num" type="text" name="product_num" size="3" maxlength="4"/>
									<input style="border:0px" type="submit" value="变更"/>
								</form>
								
								
							</td>
							<td>
								<a href="deletecart?product_id=${ci.product.id }">删除</a>
							</td>
						</tr>
						</s:iterator>
					<!-- 购物列表结束 -->
				</table>
				<div id="div_no_choice" class="objhide">
					<div class="choice_title"></div>
					<div class="no_select">
						您还没有挑选商品
					</div>
				</div>
				<div class="choice_balance">
					<div class="select_merch">
						<a href="/BookStore/main/main.jsp"> 继续挑选商品>></a>
					</div>
					<div class="total_balance">
						<div class="save_total">
							&nbsp;&nbsp;&nbsp;&nbsp;
							<span class="c_red"> <span id="total_economy"><c1:retainTwo/></span>
							</span>
							<span id='total_vip_economy' class='objhide'> ( 其中享有优惠： <span
								class="c_red"> <span id='span_vip_economy'><c1:retainTwo/></span> </span>
								) </span>
							<span style="font-size: 14px">|</span>
							<span class="t_add">商品金额总计：￥&nbsp;${amount }</span>
							<span class="c_red_b"> <span id='total_account'></span>
							</span>
						</div>
						<div id="balance" class="balance">
							<a name='checkout' href='orderinfo.action' > 
								<img src="${pageContext.request.contextPath}/images/butt_balance.gif" alt="结算" border="0" title="结算" />
							</a>
						
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- 用户删除恢复区 -->


		
		<br />
		<br />
		<br />
		<br />
		<!--页尾开始 -->
		<%@include file="/common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>



