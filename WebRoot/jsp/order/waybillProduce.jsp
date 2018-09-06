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
	<div align="center">
		<form class="form-horizontal"
			action="<%=context%>/order?forward=CreateWayBill" method="post"
			name="waybillproduce">
			<div class="form-group">
				<label class="col-xs-4 control-label"> 订单编号： </label>
					<input style="height:24px; margin-top:6px"class="col-xs-2 " type="text" name="orderId">
			</div>
			<div class="form-group">
				<label class="col-xs-4 control-label"> 发货地址： </label>
				<div align="left" style="margin: 0.6% 0 0 0;">
					<select id="selectstartingplace" name="startingplace">
						<option>秦皇岛</option>
						<option>天津</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-xs-4 control-label"> 收货地址： </label>
				<div align="left" style="margin: 0.6% 0 0 0;">
					<select id="selectdestination" name="destination">
						<option>广州</option>
						<option>福州</option>
						<option>宁波</option>
						<option>上海</option>
						<option>张家港</option>
						<option>镇江</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-xs-4 control-label"> 运输方式： </label>
				<div class="col-xs-6">
					<p class="form-control-static text-left" id="way">海运</p>
				</div>
			</div>
			<div>
				<button style="margin-left:-37%" class="btn btn-info" type="submit">确定</button>&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="<%=context%>/jsp/order/cancel.jsp" target="_self">
					<button class="btn btn-info" type="button">取消</button>
				</a>
			</div>
		</form>
	</div>
</body>
<div class="jumbotron text-center" style="margin: 14% 0 0 0;">
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