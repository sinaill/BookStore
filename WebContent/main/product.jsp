<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<HTML>
	<HEAD>
		<TITLE>图书 - 当当网</TITLE>
		<META http-equiv=Content-Type content="text/html; charset=utf-8">
		<LINK href="${pageContext.request.contextPath}/product_files/dangdang.css" type=text/css
			rel=Stylesheet>
		<LINK href="${pageContext.request.contextPath}/product_files/book1.css" type=text/css rel=stylesheet>
		<link href="${pageContext.request.contextPath}/css/book1.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/comm_answer.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.3.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/book.list.js"></script>

	</HEAD>
	<BODY>
		<%@include file="/common/head.jsp"%>
		
		<DIV id=tag_box style="DISPLAY: none; Z-INDEX: 10; POSITION: absolute"></DIV>
		<DIV id=div_shield></DIV>
		<DIV id=main>
			<DIV class=mainsearch></DIV>
			<DIV class=wrap>
				<!--left start-->
				<!--left end-->
				<DIV class=right>
					<DIV class=right_wai>
						<DIV class=shuming>
							<DIV class=shuming_left>
							
								<SPAN class=black000><A name=top_bk></A>${product.name
									}</SPAN>
							</DIV>
							<DIV class=book_case>
								<SPAN class=seriesname>丛书名： ${product.name }</SPAN>
							</DIV>
							<DIV class=empty_box></DIV>
						</DIV>
						<DIV class=book_left>
							<DIV class=book_pic>
								<IMG id=img_show_prd
										src="${pageContext.request.contextPath}/productImages/${product.picture }">
								</A>
							</DIV>
							<INPUT id=hid_largepictureurl type=hidden>
						</DIV>
						<DIV class=book_right>
							<DIV id=author_>
								作 者： ${product.author }
							</DIV>
							<DIV id=publisher_>
								出 版 社： ${product.publisher }
							</DIV>
							<UL>
								<LI>
									出版时间： ${product.publish_time }
								</LI>
								<LI>
									字 数： ${product.words }
								</LI>
								<LI>
									版 次： ${product.revision }
								</LI>
								<LI>
									页 数： ${product.total_page }
								</LI>
								<LI>
									印刷时间： ${product.print_time }
								</LI>
								<LI>
									印 次： ${product.impression }
								</LI>
								<LI>
									纸 张： ${product.paper }
								</LI>
								<LI>
									I S B N ： ${product.ISBN }
								</LI>
								<LI>
									包 装： ${product.packaging }
								</LI>
								<LI>
									库存： ${product.stock }
								</LI>
							</UL>

							<DIV class=jiage>
								<SPAN class=gray87>价格：<SPAN style="font-size:20px;color:red">￥${product.price
										}</SPAN>
								</SPAN>
					
								<DIV class=pd_buy_num>
									<DIV class=clear></DIV>
								</DIV>
								<DIV class=goumai>
									<span class="list_r_list_button"> 
							<a href="#" class="buy" id="${product.id }"> 
							<img src='${pageContext.request.contextPath}/images/buttom_goumai.gif' class="pic"/> </a></span>
							<span id="cartinfo" class="mycartinfo"></span>
									<!--  <A id=favor title=收藏 href="#" name=wishlist_book>
<IMG id=imgfavor src="../product_files/bookz_save.gif"></A>
-->
								</DIV>
							

							</DIV>
						</DIV>
						<DIV id=dvTPUrls></DIV>
						<DIV id=__zhinengbiaozhu_bk>
							<DIV class=dashed></DIV>
							<H2 class=black14>
								
							
							<DIV class=dashed></DIV>
							<H2 class=black14>
							
								内容简介
							</H2>
							<DIV class=zhengwen>
								${product.description }
							</DIV>
							<DIV class=dashed></DIV>
							<H2 class=black14>
								
								详情
							</H2>
							<DIV class=zhengwen>
								${product.sumary }
							</DIV>
							<DIV class=dashed></DIV>
							
						</DIV>
						<A name=review_point></A>
					</DIV>
				</DIV>
				<DIV id=tag_box
					style="DISPLAY: none; Z-INDEX: 2; POSITION: absolute"></DIV>
				<DIV id=tag_box_pay
					style="DISPLAY: none; Z-INDEX: 2; POSITION: absolute"></DIV>
				<DIV id=div_shield></DIV>
				<!--页尾 开始 -->
				<DIV class=public_footer_add_s></DIV>
				<!--09.3.10new-->
				<!--页尾 end -->
				<!--页尾开始 -->
				<%@include file="/common/foot.jsp"%>
				<!--页尾结束 -->
	</BODY>
</HTML>
