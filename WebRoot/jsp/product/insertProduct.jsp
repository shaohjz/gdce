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
						<div>
							<form action="<%=context%>/product?forward=insert" method="post">
								</style>

								<tr>
									<span style="margin-top: 40px; margin-left: 15%;">
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										煤种： </span>
									<select style="width: 200px; height: 30px;" name="productType">
										<option value="productType" id="productType"
											selected="selected">请选择</option>
										<option>烟煤</option>
										<option>混煤</option>
										<option>电煤</option>
										<option>褐煤</option>
										<option>沫煤</option>
										<option>无烟煤</option>
									</select>
									<span style="margin-left: 20px;">&nbsp;&nbsp;交货地：</span>
								</tr>

								<tr>
									<select style="width: 200px; height: 30px;" name="destAddress">
										<option value="destAddress" id="destAddress"
											selected="selected">请选择</option>
										<option>集宁</option>
										<option>达州电厂</option>
										<option>康平</option>
										<option>酒泉</option>
										<option>豫源国电</option>
										<option>大武口电厂</option>
									</select>
								</tr>
								<p>
									<span style="margin-top: 40px; margin-left: 15%;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
								</p>
								<p>
									<span style="margin-top: 40px; margin-left: 15%;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;产地：
									</span> <select style="width: 200px; height: 30px;" name="srcAddress">
										<option value="srcAddress" id="srcAddress" selected="selected">请选择</option>
										<option>山西</option>
										<option>内蒙</option>
									</select><span style="margin-left: 20px;">交货方式：</span> <select
										style="width: 200px; height: 30px;" name="transactionMode">
										<option value="transactionMode" id="transactionMode"
											selected="selected">请选择</option>
										<option>场地交货</option>
										<option>到厂交货</option>
									</select>
								</p>
								<table style="margin-left: 15%;">
									<tr>
										<td><div align="right" style="margin-top: 40px;">价格(元/吨)：</div></td>
										<td><input name="price" type="text" id="price"
											style="width: 200px; height: 30px; margin-top: 40px;"
											maxlength="5"
											onkeyup="if(! /^d*(?:d{0,2})?$/.test(this.value)){alter('只能输入数字，只保留两位小数');this.value='';}"></td>
										<td><div align="right" style="margin-top: 40px;">&nbsp;&nbsp;数量(万吨)：</div></td>
										<td><input name="quantity" type="text" id="quantity"
											style="width: 200px; height: 30px; margin-top: 40px;"
											maxlength="5"
											onkeyup="if(! /^d*(?:d{0,2})?$/.test(this.value)){alter('只能输入数字，只保留两位小数');this.value='';}"></td>

									</tr>
									<tr>
										<td><div align="right" style="margin-top: 40px;">低位发热量(Kcal)：</div></td>
										<td><input name="lowPower" type="number" id="lowPower"
											style="width: 200px; height: 30px; margin-top: 40px;"
											max="99999"></td>
										<td><div align="right" style="margin-top: 50px;">&nbsp;&nbsp;挥发份(%)：</div></td>
										<td><input name="volatiles" type="text" id="volatiles"
											placeholder="请输入1-100以内数字" min="0" max="100"
											style="width: 200px; height: 30px; margin-top: 40px;"
											maxlength="5"
											onkeyup="if(! /^d*(?:d{0,2})?$/.test(this.value)){alter('只能输入数字，只保留两位小数');this.value='';}"></td>
									</tr>
									<tr>
										<td><div align="right" style="margin-top: 40px;">全水分(%)：</div></td>
										<td><input name="fullMoisture" type="text"
											id="fullMoisture" placeholder="请输入1-100以内数字" min="0"
											max="100"
											style="width: 200px; height: 30px; margin-top: 40px;"
											maxlength="5"
											onkeyup="if(! /^d*(?:d{0,2})?$/.test(this.value)){alter('只能输入数字，只保留两位小数');this.value='';}"></td>
										<td><div align="right" style="margin-top: 40px;">全硫份(%)：</div></td>
										<td><input name="fullSulfur" type="text" id="fullSulfur"
											placeholder="请输入1-100以内数字" min="0" max="100"
											style="width: 200px; height: 30px; margin-top: 40px;"
											maxlength="5"
											onkeyup="if(! /^d*(?:d{0,2})?$/.test(this.value)){alter('只能输入数字，只保留两位小数');this.value='';}"></td>
									</tr>
									<tr>

										<td><div align="right" style="margin-top: 40px;">截止时间：</div></td>
										<td><input name="endDate" type="date" id="endDate"
											style="width: 200px; height: 30px; margin-top: 40px; text-align: center"
											maxlength="30"></td>
									</tr>
								</table>
								<table style="margin-left: 15%;">
									<tr>
										<td><div text-align="left">备注消息：</div></td>
										<td><textarea name="remark" id="remark"
												style="width: 600px; height: 100px; margin-top: 40px;"
												maxlength="1000"></textarea></td>
									</tr>
								</table>
								<tr>
									<td><div style="margin-left: 50%;">
											<button type="submit" style="width: 60px"
												class="form-control">提交</button>
										</div></td>
								</tr>
							</form>
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