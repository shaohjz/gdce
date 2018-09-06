<%@ page pageEncoding="UTF-8" import="java.util.*"
	import="com.isscollege.gdce.domain.User"%>
<%@page import="java.util.List"
	import="com.isscollege.gdce.domain.Company"%>

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

						<h3 align="center">企业资质信息上传</h3>
						<h4 align="center"><%=request.getAttribute("msg") == null ? "" : request.getAttribute("msg")%></h4>
						<br> <br> <br> <br>

						<%
							Company company = (Company) session.getAttribute("company");
							if (company != null)
							{
						%>

						<form action="../../register?forward=update_company" method="post"
							enctype="multipart/form-data">
							<table class="table table-hover table-condensed" align="center"
								style="text-align: center">
								<tr>
									<td width="20%"></td>
									<td width="30%" align="right">企业机构代码：</td>
									<td align="left"><input type="text" name="companyId"
										value="${company.getCompanyId() }" readonly="readonly">
									</td>
								</tr>

								<tr>
									<td></td>
									<td align="right">企业名称：</td>
									<td align="left"><input type="text" name="companyName"
										value="${company.getCompanyName() }" readonly="readonly">

									</td>
								</tr>
								<tr>
									<td></td>
									<td align="right">法人：</td>
									<td align="left"><input type="text" name="legalPerson"
										value="${company.getLegalPerson() }"></td>
								</tr>
								<tr>
									<td></td>
									<td align="right">联系方式：</td>
									<td align="left"><input type="text" name="phoneNumber"
										value="${company.getPhoneNumber() }"></td>
								</tr>
								<tr>
									<td></td>
									<td align="right">银行账户：</td>
									<td align="left"><input type="text" name="bankAccount"
										value="${company.getBankAccount() }"></td>
								</tr>
								<tr>
									<td></td>
									<td align="right">营业执照编号：</td>
									<td align="left"><input type="text" name="openLicenseId"
										value="${company.getOpenLicenseId() }"></td>
								</tr>

								<tr>
									<td></td>
									<td align="right">税务登记号：</td>
									<td align="left"><input type="text" name="taxRegisterId"
										value="${company.getTaxRegisterId() }"></td>
								</tr>

								<tr>
									<td></td>
									<td align="right">上传营业执照：</td>
									<td align="left"><input type="file" name="file" /></td>
								</tr>
								<tr>
									<td></td>
									<td></td>
									<td align="left"><input type="submit" value="提交"
										class="btn btn-success btn-sm" /></td>
								</tr>



							</table>
						</form>
						<%
							}
						%>
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