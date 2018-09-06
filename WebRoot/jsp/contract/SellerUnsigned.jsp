<%@page import="com.isscollege.gdce.domain.Contract"%>
<%@ page pageEncoding="UTF-8" import="java.util.*"
	import="com.isscollege.gdce.domain.User"%>
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
		<%=currentUser.equals("") ? "<a href='" + context + "/jsp/user/login.jsp'>登录</a>" : currentUser%>&nbsp;&nbsp;
		<%=currentUser.equals("") ? "<a href='" + context + "/jsp/user/register.jsp'>注册</a>" : ""%>&nbsp;&nbsp;
		<a href="<%=context%>/login?forward=logout">退出</a>
	</div>
	<div class="container">
		<div class="header clearfix">
			<nav class="navbar">
				<ul class="nav nav-pills pull-right socials">
					<li role="presentation" ><a href="<%=request.getContextPath()%>/index.jsp">首页</a></li>
					<li role="presentation"><a href="#">交易中心</a></li>
					<li role="presentation"><a
						href="<%=request.getContextPath()%>/news?forward=findPageBean&&type=hgzc&&currentPage=1">资讯中心</a></li>
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
										style="width: 90px; height: 40px"
										class="btn btn-default btn-primary" type="button"
										onClick="showReport1()">合同查询</button></a>
							</div>
							<div class="panel-body" align="center">
								<a href="<%=context%>/jsp/product/managing.jsp" target="_self"><button
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
								<a href="<%=context%>/jsp/logistics/waybillIndex.jsp"
									target="_self"><button style="width: 90px; height: 40px"
										class="btn btn-default " type="button" onClick="showReport1()">物流中心</button></a>
							</div>
							<%
								}

								if (per.indexOf('2') != -1 || per.indexOf('3') != -1) {
							%>
							<div class="panel-body" align="center">
								<a href="<%=context%>/jsp/logistics/logisticsQuery.jsp"
									target="_self"><button style="width: 90px; height: 40px"
										class="btn btn-default " type="button" onClick="showReport1()">物流查询</button></a>
							</div>
							<%
								}
							%>
							</div>
						</div>
					</div>
					<div class="col-md-10 column">
						<div
							style="background-color: #D9EDF7; margin-left: 40px; margin-right: 140px; margin-top: 8px; margin-bottom: 100px; height: 45px; padding: 10px">
							<p id="myctr">我的合同</p>
							<p>&nbsp;</p>
							<ul class="nav nav-tabs">
								<li><a href="<%=context%>/jsp/contract/contractEnsure.jsp">买方未签订</a></li>
								<li class="active"><a
									href="<%=context%>/jsp/contract/SellerUnsigned.jsp">卖方未签订</a></li>
								<li><a href="<%=context%>/jsp/contract/bothSigned.jsp">历史合同</a></li>
							</ul>
						</div>
						<form action="<%=context%>/contract?forward=ensurelist"
							method="post" onsubmit="return sumbit_sure()">
							<%
								List<Contract> contracts = (List<Contract>) request.getSession().getAttribute("contracts");
							%>
							<%
								int count = 0;
							%>
							<%
								for (int i = 0; i < contracts.size(); i++) {
									Contract contract = (Contract) contracts.get(i);
							%>
							<%
								if (contract.isSellerContractState() == false) {
										count++;
							%>
							<div
								style="border: 1px solid #E0E0E0; margin-left: 40px; margin-right: 140px; margin-top: 30px">
								<div
									style="background-color: #D9EDF7; height: 45px; padding: 10px">
									<p id="ctrId">
										合同编号：<%=contract.getContractId()%></p>
								</div>
								<div style="padding-left: 20px">
									<p style="padding-top: 8px">
										买方公司编号：<%=contract.getBuyerCompanyId()%></p>
									<p>
										卖方公司编号：<%=contract.getSellerCompanyId()%></p>
									<p>
										商品编号：<%=contract.getProductId()%></p>
									<p>
										创建时间：<%=contract.getCreateDate()%></p>
									<p>
										结束时间：<%=contract.getEndDate()%></p>
									<p style="text-align: right">
										买方合同状态： 买方已签 &nbsp;&nbsp;&nbsp;&nbsp; 卖方合同状态：卖方未签
										&nbsp;&nbsp;&nbsp;&nbsp;
										<script>
											function sumbit_sure() {
												var gnl = confirm("恭喜合同已签订成功！是否跳转订单页面？");
												if (gnl == true) {
													return true;
												} else {
													return false;
												}
											}
										</script>
										<%
											if (request.getSession().getAttribute("companyID").equals

													(contract.getSellerCompanyId())) {
										%>
										<input type="hidden" name="ensureID" id="ensureID"
											value=<%=i%>> <input type="submit" name="submit"
											id="submit" value="签订合同"> &nbsp;&nbsp;&nbsp;&nbsp;
										<%
											}
										%>
									
								</div>
							</div>
							<%
								}
							%>

							<%
								}
							%>
						</form>
						<%
							if (count == 0) {
						%>
						<div style="height: 300px;padding-left:50px">暂无卖方未签定的合同</div>
						<%
							}
						%>
						<div style="height: 200px;"></div>
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

</body>
</html>