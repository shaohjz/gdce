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
	<div style="margin: 15% 0% 11% 0%;">
		<p class="text-center h1">您已取消物流需求发布。</p>
		<p class="text-center h5 text-danger">
			<span id="totalSecond">5</span>秒后自动跳转到平台首页。。。
		</p>
	</div>
</body>
<script> 
	var second = totalSecond.innerText; 
	setInterval("redirect()", 1000); 
	function redirect()
	{ 
		totalSecond.innerText=--second; 
		if(second<1) 
			location.href="<%=context%>/index.jsp";
	}
</script>
<div class="jumbotron text-center" style="margin-bottom: 0">
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
</html>