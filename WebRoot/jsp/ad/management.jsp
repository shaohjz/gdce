<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/jsp/header.jsp"%>
<%@ page import="com.isscollege.gdce.domain.Advertisement"%>

<script>
	function goAdvertisementReview(reviewState)
	{
		window.location.href("<%=context%>/ads?forward=getAdvertisement&reviewState="+ reviewState);
	}
	$(function() {
		var unreviewAdvertisements = '${unreviewAdvertisements}';
		var reviewedAds = '${reviewedAdvertisements}';
		if (unreviewAdvertisements == null || unreviewAdvertisements == "") {
			$('#unreviewAds').collapse('hide');
		} else {
			$('#unreviewAds').collapse('show');
		}
		if (reviewedAds == null || reviewedAds == "") {
			$('#reviewedAds').collapse('hide');
		} else {
			$('#reviewedAds').collapse('show');
		}
	});
	
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

<style type="text/css">
body {
	background-color: white
}

.dd {
	text-align: left;
	font-size: 20px;
	color: #6A5ACD;
}

td {
	text-align: left;
}
</style>


<body onload="checkLogin()">
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
										style="width: 90px; height: 40px"
										class="btn btn-default btn-primary" type="button"
										onClick="showReport1()">广告中心</button></a>
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



						<div class="container">
							<div class="row clearfix">
								<div class="col-md-12 column">
									<div class="alert alert-success" role="alert">
										<a href="<%=context%>/jsp/ad/ad.jsp">新增</a>
									</div>
								</div>
								<br>
							</div>
						</div>


						<br>

						<div class="container">
							<div class="row clearfix">
								<div class="col-md-12 column">
									<div class="panel panel-default">
										<div class="panel-heading">
											<a class="panel-title collapsed" href="unreviewAds"
												data-toggle="collapse" data-parent="#panel-864597"
												onclick="goAdvertisementReview(0)">
												<h2>
													<span class="label label-primary">待审核</span>
												</h2> <!--待审核列表-->
											</a>
										</div>
										<div class="panel-collapse collapse" id="unreviewAds">
											<div class="panel-body">
												<table class="table table-hover">
													<thead>
														<tr>
															<th>企业机构代码</th>
															<th>投放时间</th>
															<th>价格</th>
															<th>位置</th>
														</tr>
													</thead>
													<tbody>
														<%
															if (request.getAttribute("unreviewAdvertisements") != null)
															{
																int i = 15;
																String style = "";
																for (Advertisement advertisement : (List<Advertisement>) request.getAttribute("unreviewAdvertisements"))
																{
																	int temp = i % 5;
																	i--;
																	switch (temp) {
																	case 0:
																		style = "success";
																		break;
																	case 1:
																		style = "error";
																		break;
																	case 2:
																		style = "warning";
																		break;
																	case 3:
																		style = "info";
																		break;
																	case 4:
																		style = "active";
																		break;
																	}
														%>
														<tr class=<%=style%>>
															<td><%=advertisement.getCompanyId()%></td>
															<td><%=advertisement.getPosition()%></td>
															<td><%=advertisement.getEndDate()%></td>
															<td><%=advertisement.getAdsImgPath()%></td>
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
									<div class="panel panel-default">
										<div class="panel-heading">
											<a class="panel-title collapsed" href="#reviewedAds"
												data-toggle="collapse" data-parent="#panel-864597"
												onclick="goAdvertisementReview(1)">
												<h2>
													<span class="label label-primary">已审核</span>
												</h2> <!--已审核列表-->
											</a>
										</div>
										<div class="panel-collapse collapse" id="reviewedAds">
											<div class="panel-body">

												<table class="table table-hover">
													<thead>
														<tr>
															<th>企业机构代码</th>
															<th>投放时间</th>
															<th>价格</th>
															<th>位置</th>
														</tr>
													</thead>
													<tbody>
														<%
															if (request.getAttribute("reviewedAdvertisements") != null)
															{
																int i = 15;
																String style = "";
																for (Advertisement advertisement : (List<Advertisement>) request.getAttribute("reviewedAdvertisements"))
																{
																	int temp = i % 5;
																	i--;
																	switch (temp) {
																	case 0:
																		style = "success";
																		break;
																	case 1:
																		style = "error";
																		break;
																	case 2:
																		style = "warning";
																		break;
																	case 3:
																		style = "info";
																		break;
																	case 4:
																		style = "active";
																		break;
																	}
														%>
														<tr class=<%=style%>>
															<td><%=advertisement.getCompanyId()%></td>
															<td><%=advertisement.getPosition()%></td>
															<td><%=advertisement.getEndDate()%></td>
															<td><%=advertisement.getAdsImgPath()%></td>
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
						<br>

					</div>
				</div>
			</div>
		</div>
	</div>
	</div>


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


</body>
</html>