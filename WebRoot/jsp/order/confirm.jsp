<%@ page pageEncoding="UTF-8"%>
<%@ include file="/jsp/header.jsp"%>
<body>
	<div class="container text-right" style="margin-bottom: 0">
		<%=currentUser.equals("") ? "<a href='" + context + "/jsp/login.jsp'>登录</a>" : currentUser%>&nbsp;&nbsp;
		<a href="<%=context%>/jsp/user/register.jsp">注册</a>&nbsp;&nbsp; <a
			href="<%=context%>/login?forward=logout">注销</a>
	</div>
	<div class="container">
		<div class="header clearfix">
			<nav class="navbar">
				<ul class="nav nav-pills pull-right socials">
					<li role="presentation" class="active"><a href="#">首页</a></li>
					<li role="presentation"><a href="#">交易中心</a></li>
					<li role="presentation"><a
						href="<%=context%>/jsp/news/newsCenter.jsp">资讯中心</a></li>
					<li role="presentation"><a
						href="<%=context%>/jsp/trade/reportIndex.jsp">报表中心</a></li>
					<li role="presentation"><a
						href="<%=context%>/jsp/user/mumberCenter.jsp">会员中心</a></li>
				</ul>
				<h3 class="text-muted">
					<img alt="" src="<%=context%>/imgs/logo.png">
				</h3>
			</nav>
		</div>
	</div>
	<div class="container">
		<div>
			<div style="margin:20%;margin-top:30px;margin-bottom:30px" align="center">
				<table class="table table-condensed" >
					<tr>
					    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td>物流商：</td>
						<td>${requestScope.companynamelist.companyName}</td>
					</tr>
					<tr>
					    <td display:none>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td>出发地：</td>
						<td>${requestScope.startingplace}</td>
					</tr>
					<tr>
					    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td>目的地：</td>
						<td>${requestScope.destination}</td>
					</tr>
					<tr>
					    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td>煤炭种类：</td>
						<td>${requestScope.productType}</td>
					</tr>
					<tr>
					    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td>单价：</td>
						<td>${requestScope.logisticspricelist.price}</td>
					</tr>
					<tr>
					    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td>数量：</td>
						<td>${requestScope.quantity}</td>
					</tr>
					<tr>
					    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td>总价：</td>
						<td>${requestScope.sumcostlist}</td>
					</tr>
				</table>
			</div>
		</div>
		<div style="margin-left:75%">
			<a class="btn-info btn-lg" href="<%=context%>/order?forward=detail&orderId=${orderId }">确认</a>
		</div>
	</div>
	<div class="jumbotron text-center" style="margin-top: 100px">
	<p>
	<h5>
		<a href="">客服中心</a>|<a href="">联系我们</a><br> <br>
		网站版权归中国国电集团公司所有 京ICP备 05053479号-2 |京公网安备110102005596号-1<br>
		地址：北京市昌平区未来科技城 邮编：102209
		电话：400-020-8000（非工作时间：15011089832）、010-56978755 传真： 010-56978760<br>
		电子邮箱：fuel@powerec.net
	</h5>
	</p>
</div>
</body>
</html>