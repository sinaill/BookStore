<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@page import="java.util.*" %>
<h2>
	编辑推荐
</h2>
<div id=__bianjituijian/danpin>
	<div class=second_c_02 style="width:518px;height:650px">
		<div class=second_c_02_b1>
		  <s:iterator value="products">
			
			<div class=second_c_02_b1_1>
				<a href='#' target='_blank'><img src="${pageContext.request.contextPath}/productImages/<s:property value="picture"/>" width=70 border=0 /> </a>
			</div>
			
			<div class=second_c_02_b1_2>
				<h3>
					<a href='productinfo.action?product_id=<s:property value="id"/>' target='_blank' title='输赢'><s:property value="name"/></a>
				</h3>
				<h4>
					作者：<s:property value="author"/> 著
					<br />
					出版社：<s:property value="publisher"/>&nbsp;&nbsp;&nbsp;&nbsp;出版时间：
					<s:property value="publish_time"/>
				</h4>
				<h5>
					简洁：<s:property value="description"/>
				</h5>
				<h6>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;定价：￥<s:property value="price"/>
				</h6>
				<div class=line_xx></div>
			</div>
			</s:iterator>
		</div>
	</div>
</div>
