<%@ page pageEncoding="UTF-8" import="java.util.*"
	import="com.isscollege.gdce.domain.User"%>
<%@ include file="/jsp/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
a {
	cursor: pointer;
}
</style>
<script type="text/javascript">
	function judge()
	{
		var pass=<%=permission.equals("3") ? 1 : 2%>
		if(pass==1)
			{
				window.location.href="<%=context%>/jsp/report/reportIndex.jsp";
		} else {
			$('#modal-container-204152').modal();
		}

	}
</script>
<body>
	<%
		User user = null;
		user = (User) request.getSession().getAttribute("currentUser");
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/jsp/user/login.jsp");
			return;
		}
	%>

	<div class="modal fade" id="modal-container-204152" role="dialog"
		aria-hidden="true" aria-labelledby="myModalLabel">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button class="close" aria-hidden="true" type="button"
						data-dismiss="modal">×</button>
					<h4 class="modal-title" id="myModalLabel">错误</h4>
				</div>
				<div class="modal-body">该功能暂未开放</div>
				<div class="modal-footer">
					<button class="btn btn-default" type="button" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
	<div class="container text-right" style="margin-bottom: 0">
		<%=currentUser%>&nbsp;&nbsp; <a
			href="<%=context%>/login?forward=logout">退出</a>
	</div>
	<div class="container">
		<div class="header clearfix">
			<nav class="navbar">
				<ul class="nav nav-pills pull-right socials">
					<li role="presentation"><a href="<%=context%>/index.jsp">首页</a></li>
					<li role="presentation"><a
						href="<%=context%>/jsp/product/productsList.jsp">交易中心</a></li>
					<li role="presentation"><a
						href="<%=context%>/jsp/news/newsCenter.jsp">资讯中心</a></li>
					<li role="presentation"><a onClick="judge()"
						href="javascript:judge()">报表中心</a></li>
					<li role="presentation" class="active"><a
						href="<%=context%>/register?forward=qualification">会员中心</a></li>
				</ul>
				<h3 class="text-muted">
					<img alt="logo" src="<%=context%>/imgs/logo.png">
				</h3>
			</nav>
		</div>
	</div>

	<div class="box" ; align="center">
		<img alt="分割图" src="<%=context%>/imgs/banner004.png";>
	</div>
	<div class="locationD" ; align="center">
		<h2>会员中心</h2>
	</div>
	<br>
	<br>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="row clearfix">
					<div class="col-md-2 column">
						<div class="panel panel-default">
							<div class="panel-body" align="center">
								<a href="<%=context%>/register?forward=qualification"
									target="_self"><button style="width: 90px; height: 40px"
										class="btn btn-default btn-primary" type="button"
										onClick="showReport2()">资质管理</button></a>
							</div>
							<div class="panel-body" align="center">
								<a href="<%=context%>/order?forward=query&page=1" target="_self"><button
										style="width: 90px; height: 40px" class="btn btn-default"
										type="button" onClick="showReport2()">订单查询</button></a>
							</div>
							<div class="panel-body" align="center">
								<a href="<%=context%>/contract?forward=querylist" target="_self"><button
										style="width: 90px; height: 40px" class="btn btn-default "
										type="button" onClick="showReport1()">合同查询</button></a>
							</div>
							<div class="panel-body" align="center">
								<a href="<%=context%>/product?forward=query" target="_self"><button
										style="width: 90px; height: 40px" class="btn btn-default"
										type="button" onClick="showReport1()">商品查询</button></a>
							</div>
							<div class="panel-body" align="center">
								<a href="<%=context%>/jsp/product/payBond.jsp" target="_self"><button
										style="width: 90px; height: 40px" class="btn btn-default "
										type="button" onClick="showReport1()">商品发布</button></a>
							</div>
							<div class="panel-body" align="center">
								<a href="<%=context%>/jsp/ad/management.jsp" target="_self"><button
										style="width: 90px; height: 40px" class="btn btn-default "
										type="button" onClick="showReport1()">广告中心</button></a>
							</div>
							<%
								String per = user.getPermission();
								if (per.indexOf('4') != -1) {
							%>
							<div class="panel-body" align="center">
								<a href="<%=context%>/logistics?forward=query&state=0&page=1"
									target="_self"><button style="width: 90px; height: 40px"
										class="btn btn-default " type="button" onClick="showReport1()">物流中心</button></a>
							</div>
							<%
								}

								if (per.indexOf('2') != -1 || per.indexOf('3') != -1) {
							%>
							<div class="panel-body" align="center">
								<a href="<%=context%>/logistics?forward=queryorder&page=1"
									target="_self"><button style="width: 90px; height: 40px"
										class="btn btn-default " type="button" onClick="showReport1()">物流查询</button></a>
							</div>
							<%
								}
							%>
						</div>
					</div>
					<div class="col-md-10 column">
						<div class="panel panel-warning">
							<div class="panel-heading">
								<h3 class="panel-title" style="display: inline">订单编号：${order.orderId }
									&nbsp;&nbsp;&nbsp;&nbsp; 订单状态：${orderState }</h3>
								<a style="float: right" id="back">返回</a>
							</div>
						</div>
						<%
							if (per.indexOf('2') != -1) {
						%>
						<c:if test="${orderState=='待付款'}">
							<div class="panel panel-info">
								<div class="panel-heading">
									<h3 class="panel-title" style="display: inline">
										上传银行回执 <a style="float: right" data-toggle="collapse"
											data-parent="#accordion" href="#collapseThree"> <strong>^</strong>
										</a>
									</h3>
								</div>
								<div id="collapseThree" class="panel-collapse collapse in">
									<div class="panel-body">
										<form
											action="<%=context%>/order?forward=uploadImg&orderId=${order.orderId }"
											enctype="multipart/form-data" method="post">
											<div class="form-group">
												<label for="inputfile">上传回执单</label> <input id="lefile"
													name="filename" type="file" style="display: none"
													accept="image/png">
												<div class="input-append">
													<input id="photoCover" class="input-large" type="text"
														style="height: 30px;"> <a
														class="btn btn-primary btn-sm"
														onclick="$('input[id=lefile]').click();">选择图片</a>
												</div>
												<p class="help-block">请选择图片类型文件</p>
											</div>
											<button type="submit" class="btn btn-default">提交</button>
										</form>
									</div>
								</div>
							</div>
						</c:if>
						<%
							}
							if (per.indexOf('3') != -1) {
						%>
						<c:if test="${orderState=='待发货'}">
							<div class="panel panel-info">
								<div class="panel-heading">
									<form action="<%=context%>/jsp/order/waybillProduce.jsp"
										method="post">
										<h3 class="panel-title" style="display: inline">发布物流信息</h3>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<button class="btn btn-info btn-sm" type="submit">发布</button>
									</form>
								</div>
							</div>

						</c:if>
						<%
							}
						%>

						<%
							String orderId = (String) request.getAttribute("orderId");
							String result = (String) request.getAttribute("result");
							if (result != null) {
						%>
						<script type="text/javascript" language="javascript">
					alert("<%=result%>"); 
					
					window.location = "<%=context%>/order?forward=detail&orderId=<%=orderId%>
							";
						</script>
						<%
							}
						%>
						<div class="panel panel-success">
							<div class="panel-heading">
								<h3 class="panel-title">
									订单信息 <a style="float: right" data-toggle="collapse"
										data-parent="#accordion" href="#collapseTwo"> <strong>^</strong>
									</a>
								</h3>
							</div>
							<div id="collapseTwo" class="panel-collapse collapse in">
								<div class="panel-body"
									style="border-bottom: dashed 1px #DCDCDC">
									<strong>买家信息：</strong><br /> 企业名称 :${buyer.companyName }&nbsp;&nbsp;&nbsp;&nbsp;
									联系方式 : ${buyer.phoneNumber }&nbsp;&nbsp;&nbsp;&nbsp;
								</div>
								<div class="panel-body"
									style="border-bottom: dashed 1px #DCDCDC">
									<strong>卖家信息：</strong><br /> 企业名称 : ${seller.companyName }
									&nbsp;&nbsp;&nbsp;&nbsp; 联系方式 : ${seller.phoneNumber }&nbsp;&nbsp;&nbsp;&nbsp;
								</div>
								<div class="panel-body">
									<strong>商品信息：</strong><br /> 商品编号 :${product.productId }
									&nbsp;&nbsp;&nbsp;&nbsp;<br /> 煤种: ${product.productType }&nbsp;&nbsp;&nbsp;&nbsp;产地：${product.srcAddress }<br />
									价格:${product.price }万元/吨 &nbsp;&nbsp;&nbsp;&nbsp;数量:
									${product.quantity }吨&nbsp;&nbsp;&nbsp;&nbsp;<br> 交易金额:
									${order.tradePrice }万元&nbsp;&nbsp;&nbsp;&nbsp;交货地:${product.destAddress }
									&nbsp;&nbsp;&nbsp;&nbsp;
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<br>
	<br>
	<br>
	<div class="jumbotron text-center"
		style="margin-bottom: 0; margin-top: 8px">
		<h5>
			<a href="">客服中心</a>|<a href="">联系我们</a><br> <br>
			网站版权归中国国电集团公司所有 京ICP备 05053479号-2 |京公网安备110102005596号-1<br>
			地址：北京市昌平区未来科技城 邮编：102209
			电话：400-020-8000（非工作时间：15011089832）、010-56978755 传真： 010-56978760<br>
			电子邮箱：fuel@powerec.net
		</h5>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$('input[id=lefile]').change(function() {
				$('#photoCover').val($(this).val());
			});
			$("#back").click(function() {
				window.history.back();
			});
		});
	</script>
</body>
</html>