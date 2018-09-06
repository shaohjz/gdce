<%@ page pageEncoding="UTF-8" import="java.util.*"
	import="com.isscollege.gdce.domain.User,com.isscollege.gdce.domain.Product"%>
<%@ include file="/jsp/header.jsp"%>
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
		if (user == null)
		{
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
										class="btn btn-default " type="button" onClick="showReport2()">资质管理</button></a>
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
										style="width: 90px; height: 40px"
										class="btn btn-default btn-primary" type="button"
										onClick="showReport1()">商品查询</button></a>
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
								if (per.indexOf('4') != -1)
								{
							%>
							<div class="panel-body" align="center">
								<a href="<%=context%>/logistics?forward=query&state=0&page=1"
									target="_self"><button style="width: 90px; height: 40px"
										class="btn btn-default " type="button" onClick="showReport1()">物流中心</button></a>
							</div>
							<%
								}

								if (per.indexOf('2') != -1 || per.indexOf('3') != -1)
								{
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

						<style>
.col_style {
	height: 30px;
	width: 95px;
	text-align: center;
}

。main_table_style {
	height: 30px;
	width: 100px;
	text-align: center;
}

.table tbody {
	display: block;
	height: 600px;
	overflow-y: scroll;
	text-align: center;
}

.table thead, tbody tr {
	display: table;
	width: 100%;
	table-layout: fixed;
}

.table thead {
	width: cacl(100% -1em);
}

.table thead th {
	text-align: center;
	background: #ccc;
}
</style>
						</head>
						<body>

							<ul id="myTab" class="nav nav-pills">
								<li class="active"><a href="#published" data-toggle="tab">已发布</a></li>
								<li><a href="#auditing" data-toggle="tab">待审核</a></li>
								<li><a href="#shelves" data-toggle="tab">已下架</a></li>
								<li><a href="#sss" data-toggle="tab">未通过</a></li>
							</ul>
							<hr>

							<%-- //这是在当前页面展示信息的 --%>
							<div id="myTabContent" class="tab-content">
								<div class="tab-pane fade in active" id="published">
									<div class="container">
										<div class="row clearfix">
											<div class="col-md-12 column">
												<div class="table-responsive">
													<h2>
														<span class="label label-primary">已发布商品信息</span>
													</h2>
													<table class="table table-hover">
														<thead>

															<tr>
																<th class="col_style">煤种</th>
																<th class="col_style">低位发热量<br>（Kcal）
																</th>
																<th class="col_style">价格<br>（元/吨）
																</th>
																<th class="col_style">数量<br>（万吨）
																</th>
																<th class="col_style">交货方式</th>
																<th class="col_style">交割地</th>
																<th class="col_style">查看</th>
																<th class="col_style">修改</th>
															</tr>
														</thead>
														<tbody>
															<%
															
																ArrayList productList = (ArrayList)session.getAttribute("productList");
																for (int i = 0; i < productList.size(); i++)
																{
																	Product product = (Product) productList.get(i);
																	if (product.getProductState() == 0 && product.getReviewState() == 1)
																	{
															%>
															<tr class="success">
																<td><%=product.getProductType()%></td>
																<td><%=product.getLowPower()%></td>
																<td><%=product.getPrice()%></td>
																<td><%=product.getQuantity()%></td>
																<td><%=product.getTransactionMode()%></td>
																<td><%=product.getDestAddress()%></td>
																<td><a href="<%=context%>/product?forward=productId&productId=<%=product.getProductId()%>">查看</a></td>
																<td><a href="jsp/product/updateProduct.jsp?id=<%=product.getId()%>">修改</a></td>
															</tr>
															<%
																}
																}
															%>

														</tbody>
													</table>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="tab-pane fade" id="auditing">
									<div class="container">
										<div class="row clearfix">
											<div class="col-md-12 column">
												<div class="table-responsive">
													<h2>
														<span class="label label-primary">待审核商品信息</span>
													</h2>
													<table class="table table-hover">
														<thead>
															<tr>
																<th class="col_style">煤种</th>
																<th class="col_style">低位发热量<br>（Kcal）
																</th>
																<th class="col_style">价格<br>（元/吨）
																</th>
																<th class="col_style">数量<br>（万吨）
																</th>
																<th class="col_style">交货方式</th>
																<th class="col_style">交割地</th>
																<th class="col_style">查看</th>
															</tr>
														</thead>
														<tbody>
															<%
																for (int i = 0; i < productList.size(); i++)
																{
																	Product product = (Product) productList.get(i);
																	if ((product.getReviewState() == 0) && (product.getProductState() == 1))
																	{
															%>
															<tr class="success">
																<td><%=product.getProductType()%></td>
																<td><%=product.getLowPower()%></td>
																<td><%=product.getPrice()%></td>
																<td><%=product.getQuantity()%></td>
																<td><%=product.getTransactionMode()%></td>
																<td><%=product.getDestAddress()%></td>
																<td><a href="<%=context%>/product?forward=productId&productId=<%=product.getProductId()%>">查看</a></td>
                                                                </tr>
															<%
																}
																}
															%>
														</tbody>
													</table>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="tab-pane fade" id="shelves">
									<div class="container">
										<div class="row clearfix">
											<div class="col-md-12 column">
												<div class="table-responsive">
													<h2>
														<span class="label label-primary">已下架商品信息</span>
													</h2>
													<table class="table table-hover">
														<thead>
															<tr>
																<th class="col_style">煤种</th>
																<th class="col_style">低位发热量<br>（Kcal）
																</th>
																<th class="col_style">价格<br>（元/吨）
																</th>
																<th class="col_style">数量<br>（万吨）
																</th>
																<th class="col_style">交货方式</th>
																<th class="col_style">交割地</th>
																<th class="col_style">查看</th>
															</tr>
														</thead>
														<tbody>
															<%
																for (int i = 0; i < productList.size(); i++)
																{
																	Product product = (Product) productList.get(i);
																	if (product.getReviewState() == 1 && product.getProductState() == 1)
																	{
															%>
															<tr class="success">
																<td><%=product.getProductType()%></td>
																<td><%=product.getLowPower()%></td>
																<td><%=product.getPrice()%></td>
																<td><%=product.getQuantity()%></td>
																<td><%=product.getTransactionMode()%></td>
																<td><%=product.getDestAddress()%></td>
																<td><a href="<%=context%>/product?forward=productId&productId=<%=product.getProductId()%>">查看</a></td>
															</tr>
															<%
																}
																}
															%>
														</tbody>
													</table>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="tab-pane fade" id="sss">
									<div class="container">
										<div class="row clearfix">
											<div class="col-md-12 column">
												<div class="table-responsive">
													<h2>
														<span class="label label-primary">未通过审核商品信息</span>
													</h2>
													<table class="table table-hover">
														<thead>
															<tr>
																<th class="col_style">煤种</th>
																<th class="col_style">低位发热量<br>（Kcal）
																</th>
																<th class="col_style">价格<br>（元/吨）
																</th>
																<th class="col_style">数量<br>（万吨）
																</th>
																<th class="col_style">交货方式</th>
																<th class="col_style">交割地</th>
																<th class="col_style">查看</th>
															</tr>
														</thead>
														<tbody>
															<%
																for (int i = 0; i < productList.size(); i++)
																{
																	Product product = (Product) productList.get(i);
																	if (product.getReviewState() == 2 && product.getProductState() == 1)
																	{
															%>
															<tr class="success">
																<td><%=product.getProductType()%></td>
																<td><%=product.getLowPower()%></td>
																<td><%=product.getPrice()%></td>
																<td><%=product.getQuantity()%></td>
																<td><%=product.getTransactionMode()%></td>
																<td><%=product.getDestAddress()%></td>
																<td><a href="<%=context%>/product?forward=productId&productId=<%=product.getProductId()%>">查看</a></td>
															</tr>
															<%
																}
																}
															%>
														</tbody>
													</table>
												</div>
											</div>
										</div>
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
	</div>
	</div>
	</div>

</body>
</html>