<%@ page pageEncoding="UTF-8" import="java.util.*"
	import="com.isscollege.gdce.domain.User"%>
<%@ include file="/jsp/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	function judge()
	{
		var pass=<%=permission.equals("3") ? 1 : 2%>
		if(pass==1)
			{
				window.location.href="<%=context%>
	/jsp/report/reportIndex.jsp";
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
	<%
		int i = 0;
		String[] orderStateArray = (String[]) request.getAttribute("orderStateArray");
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
										style="width: 90px; height: 40px"
										class="btn btn-default btn-primary" type="button"
										onClick="showReport2()">订单查询</button></a>
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
						<form role="form"
							action="<%=context%>/order?forward=queryAppointedOrder&page=1"
							method="post">
							<!-- 表单提交     -->
							<div class="from-group">
								<div class="col-md-3 column"></div>
								<div class="col-md-5 column">
									<input type="text" class="form-control" id="orderNumber"
										name="orderNumber" placeholder="请输入订单号">
								</div>
								<div class="col-md-1 column">
									<button class="btn btn-default" type="submit">查询</button>

								</div>
							</div>
						</form>
						<form role="form" action="<%=context%>/order?forward=query&page=1"
							method="post">
							<button class="btn btn-default" type="submit">查询全部</button>
						</form>
						<div style="margin-top: 30px; height: 340px">
							<table class="table" id="orderTable">
								<caption></caption>
								<thead>
									<tr class="info">
										<th>订单号</th>
										<th>创建时间</th>
										<th>交易金额</th>
										<th>订单状态</th>
									</tr>
								</thead>
								<tbody>
									<c:choose>
										<c:when test="${hasResult==true }">
											<c:forEach var="order" items="${orderList }" varStatus="loop">
												<tr>
													<td><a
														href="/gdce/order?forward=detail&orderId=${order.orderId }">${order.orderId }</a></td>
													<td>${order.createDate }</td>
													<td>${order.tradePrice }万元</td>
													<td><%=orderStateArray[i]%></td>

													<%
														i++;
													%>
												</tr>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<tr style="height: 50px">
												<td colspan="4" style="text-align: center"><br>没有查询结果</td>
											</tr>
										</c:otherwise>
									</c:choose>

								</tbody>
							</table>
						</div>
						<div style="text-align: center" id="paging">
							<ul class="pagination">
								<c:choose>
									<c:when test="${isAppointed==true && totalPages>1 }">
										<li><a
											href="<%=context%>/order?forward=queryAppointedOrder&page=${page-1>1?page-1:1}&orderNumber=${orderId }">&laquo;</a></li>
										<c:forEach begin="1" end="${totalPages}" varStatus="loop">
											<li><a
												href="<%=context%>/order?forward=queryAppointedOrder&page=${loop.index}&orderNumber=${orderId }">${loop.index}</a>
											</li>
										</c:forEach>
										<li><a
											href="<%=context%>/order?forward=queryAppointedOrder&page=${page+1<totalPages?page+1:totalPages}&orderNumber=${orderId }">&raquo;</a>
										</li>
									</c:when>
									<c:when test="${isAppointed==false && totalPages>1 }">
										<li><a
											href="<%=context%>/order?forward=query&page=${page-1>1?page-1:1}">&laquo;</a></li>
										<c:forEach begin="1" end="${totalPages}" varStatus="loop">
											<li><a
												href="<%=context%>/order?forward=query&page=${loop.index}">${loop.index}</a>
											</li>
										</c:forEach>
										<li><a
											href="<%=context%>/order?forward=query&page=${page+1<totalPages?page+1:totalPages}">&raquo;</a>
										</li>
									</c:when>
								</c:choose>
							</ul>
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
</body>
</html>