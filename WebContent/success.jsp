<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>hello world</h1>
<s:iterator value="categories" var="c1">
		<!--1级分类开始-->
			<div class="bg_old" onmouseover="this.className = 'bg_white';"
				onmouseout="this.className = 'bg_old';">
				<h3>
					[<a href='#'>${c1.name }</a>]
				</h3>
				<ul class="ul_left_list">
						<!--2级分类开始-->
						<s:iterator value="categories" var="c2">
						<li>
							<a href='booklist.action?pid=${c1.id }&cid=${c2.id }'>${c2.name }</a>
						</li>
						<!--2级分类结束-->
						</s:iterator>
				</ul>
				<div class="empty_left">
				</div>
			</div>

			<div class="more2">
			</div>
			<!--1级分类结束-->
	</s:iterator>
</body>
</html>