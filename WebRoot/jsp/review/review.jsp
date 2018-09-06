<%@ page language="java" pageEncoding="utf-8"%>
	<%@ page import="com.isscollege.gdce.domain.Product"%>
<%@ page import="com.isscollege.gdce.domain.Company"%>
<%@ page import="com.isscollege.gdce.domain.Advertisement"%>
<%@ page import="com.isscollege.gdce.domain.News"%>
<%@ page import="java.util.List"%>
<%@ include file="/jsp/header.jsp"%>

<%!	String des = "";%>

<script type="text/javascript">

	$(function(){
		var pageNumber = '${pageShow}';
		if(pageNumber == null || pageNumber=="")
		{
			$('#myTab a:first').tab('show');	
		}
		else
		{
			if(pageNumber =="product")
			{
	
				$('#myTab a[href=#product]').tab('show');	
			}
			else if(pageNumber =="company")
			{
				$('#myTab a[href=#company]').tab('show');	
			}
			else if(pageNumber =="advertisement")
			{
				$('#myTab a[href=#advertisement]').tab('show');	
			}
			else
			{
				$('#myTab a[href=#news]').tab('show');
			}	
		}
	})
	//按钮触发更新
    function changePro(productId, state) {
        window.location.href = "<%=context%>/review?forward=changePro&productId=" + productId + "&state=" + state + "&page=<%=request.getAttribute("page")%>";
    }
    function changeCom(companyId, state) {
        window.location.href = "<%=context%>/review?forward=changeCom&companyId=" + companyId + "&state=" + state + "&page=<%=request.getAttribute("page")%>";
    }
    function changeAdv(adId, state) {
        window.location.href = "<%=context%>/review?forward=changeAdv&adId=" + adId + "&state=" + state + "&page=<%=request.getAttribute("page")%>";
    }
    function changeNew(newsId, state) {
        window.location.href = "<%=context%>/review?forward=changeNew&newsId=" + newsId + "&state=" + state + "&page=<%=request.getAttribute("page")%>";
    }
    
    //选项卡预览读取数据
    function goProductReview()
	{
		window.location.href = "<%=context%>/review?forward=productReview";
	}
    function goCompanyReview()
	{
		window.location.href = "<%=context%>/review?forward=companyReview";
	}
    function goAdvertisementReview()
	{
		window.location.href = "<%=context%>/review?forward=advertisementReview";
	}
	function goNewsReview()
	{
		window.location.href = "<%=context%>/review?forward=newsReview";
	}
	//显示本地图片
	function reP(){
		document.getElementById('oImg').style.display = "block";
	}
</script>

<style type="text/css">
.STYLE1 {
	font-size: 18px
}

.STYLE3 {
	font-size: 24px
}

.STYLE5 {
	font-size: large;
	font-weight: bold;
}

.STYLE6 {
	font-weight: bold
}
</style>

<body>
	<%
		User user = null;
		user = (User) request.getSession().getAttribute("currentUser");
		if (user == null || user.getLevel() == 2 || user.getLevel() == 3 || user.getLevel() == 4)
		{
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			return;
		}
	%>

	<div class="container text-right" style="margin-bottom: 0">
		<%=currentUser.equals("") ? "<a href='" + context + "/jsp/user/login.jsp'>登录</a>" : currentUser%>&nbsp;&nbsp;
		<%=currentUser.equals("") ? "<a href='" + context + "/jsp/user/register.jsp'>注册</a>" : ""%>&nbsp;&nbsp;
		<a href="<%=context%>/login?forward=logout">退出</a>
	</div>
	<div class="container">
		<div class="header clearfix">
			<nav class="navbar">
				<h3 class="text-muted">
					<img alt="" src="<%=context%>/imgs/logo.png">
				</h3>
			</nav>
		</div>
	</div>

	<div class="box" align="center">
		<img alt="分割图" src="<%=context%>/imgs/banner004.png">
	</div>
	<br>
	<br>
	<div align="center" class="locationD">
		<h2>管理员中心</h2>
	</div>
	<br>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="row clearfix">
					<div class="col-md-2 column">
						<div class="panel panel-default">
							<div class="panel-body" align="center">
								<a href="<%=context%>/review?forward=productReview" target="_self"><button
										style="width: 90px; height: 40px"
										class="btn btn-default btn-primary" type="button"
										onClick="showReport2()">审核</button></a>
							</div>
							<div class="panel-body" align="center">
								<a href="<%=context%>/news?forward=adminPageBean&&type=hgzc&&currentPage=1"
									target="_self"><button style="width: 90px; height: 40px"
										class="btn btn-default" type="button" onClick="showReport2()">资讯管理</button></a>
							</div>
							<div class="panel-body" align="center">
								<%
									if (user.getLevel() == 0)
									{
								%>
								<a href="<%=request.getContextPath()%>/register?forward=QUERYMANAGER" target="_self">
									<button style="width: 90px; height: 40px"
										class="btn btn-default" type="button" onClick="showReport1()">二级管理员</button>
								</a>
								<%
									}
								%>
							</div>
						</div>
					</div>
					<div class="col-md-10 column">
						<div class="container">
							<div class="row clearfix">
								<div class="col-md-10 column">
									<!-- 审核主界面 -->
									<h1 align="left" class='page-header STYLE7'>
										<span class="label label-primary"><strong>审核管理</strong></span>
									</h1>
					
									<ul class='nav nav-tabs' id="myTab">
										<li class='active STYLE5'><a href='#product' onclick="goProductReview()" class="STYLE5" data-toggle='tab'>买卖方挂牌信息</a></li>
										<li><a href='#company' onclick="goCompanyReview()" class="STYLE5" data-toggle='tab'>用户信息</a></li>
										<li><a href='#advertisement' onclick="goAdvertisementReview()" class="STYLE5" data-toggle='tab'>广告位申请</a></li>
										<li><a href='#news' onclick="goNewsReview()" class="STYLE5" data-toggle='tab'>资讯信息</a></li>
									</ul>
					
					
									<div class='tab-content'>
										<!-- 买卖方挂牌信息 选项卡-->
										<div class='tab-pane active' id='product'>
											<p align="center">
											<table class="table table-hover">
												<thead>
													<tr class="STYLE10">
														<th width="47">商品编号</th>
														<th width="40">煤种</th>
														<th width="40">产地</th>
														<th width="48">交货地</th>
														<th width="70">价格（元/吨）</th>
														<th width="70">数量（万吨）</th>
														<th width="50">发布日期</th>
														<th width="53">截至日期</th>
														<th width="51">全水分（%）</th>
														<th width="54">全硫份（%）</th>
														<th width="55">挥发份（%）</th>
														<th width="47">交货方式</th>
														<th width="63">低位发热量</th>
														<th width="47">用户名称</th>
														<th width="40">备注</th>
													</tr>
												</thead>
												<tbody>
												<%
													if (request.getAttribute("products") != null) {
														des = "productReview";
														int i = 15;
														String style = "";
														for (Product product : (List<Product>) request.getAttribute("products")) {
															int tmp = i % 5;
																i--;
																switch (tmp) {
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
													<td class="STYLE10"><%=product.getProductId()%></td>
													<td class="STYLE10"><%=product.getProductType()%></td>
													<td class="STYLE10"><%=product.getSrcAddress()%></td>
													<td class="STYLE10"><%=product.getDestAddress()%></td>
													<td class="STYLE10"><%=product.getPrice()%></td>
													<td class="STYLE10"><%=product.getQuantity()%></td>
													<td class="STYLE10"><%=product.getCreateDate()%></td>
													<td class="STYLE10"><%=product.getEndDate()%></td>
													<td class="STYLE10"><%=product.getFullMoisture()%></td>
													<td class="STYLE10"><%=product.getFullSulfur()%></td>
													<td class="STYLE10"><%=product.getVolatiles()%></td>
													<td class="STYLE10"><%=product.getTransactionMode()%></td>
													<td class="STYLE10"><%=product.getLowPower()%></td>
													<td class="STYLE10"><%=product.getUserName()%></td>
													<td class="STYLE10"><%=product.getRemark()%></td>
													<td bordercolor="#CCCCCC">
														<div>
															<div align="center">
																<button type="button" class="btn btn-default"
																	onclick="changePro(<%=product.getProductId()%>,1)">通过</button>
																<button type="button" class="btn btn-default"
																	onclick="changePro(<%=product.getProductId()%>,2)">不通过</button>
															</div>
														</div>
													</td>
												</tr>
												<%
													}
													}
												%>
												</tbody>
											</table>
										</div>
										<!-- 用户信息 选项卡-->
										<div class='tab-pane' id='company'>
											<p align="center">
											<table class="table table-hover">
												<thead>
													<tr>
														<th><span class="STYLE10">企业机构代码</span></th>
														<th><span class="STYLE10">企业名称</span></th>
														<th><span class="STYLE10">法人</span></th>
														<th><span class="STYLE10">联系方式</span></th>
														<th><span class="STYLE10">银行账户</span></th>
														<th><span class="STYLE10">营业执照</span></th>
														<th><span class="STYLE10">税务登记号</span></th>
													</tr>
												</thead>
												<tbody>
												<%
													if (request.getAttribute("companys") != null) {
														des = "companyReview";
														int i = 15;
														String style = "";
														for (Company company : (List<Company>) request.getAttribute("companys")) {
															int temp = i % 5;
															i --;
															switch(temp){
																case 0: style = "success";
																	break;
																case 1: style = "error";
																	break;
																case 2: style = "warning";
																	break;
																case 3: style = "info";
																	break;
																case 4: style = "active";
																	break;
															}
													%>
														<tr class = <%=style %>>
														<td><%=company.getCompanyId() %></td>
														<td><%=company.getCompanyName() %></td>
														<td><%=company.getLegalPerson() %></td>
														<td><%=company.getPhoneNumber() %></td>
														<td><%=company.getBankAccount() %></td>
														<td>
															<img src='<%=context%>\imgs\openLicense\222222222220180808144427.jpg' id="oImg" style='display:none' width="160px" hight="200px">
															<INPUT TYPE="button" value='查看' onclick="reP()">
														</td>
														<td><%=company.getTaxRegisterId() %></td>
														<td bordercolor="#CCCCCC">
															<div>
																<div align="center">
																	<button type="button" class="btn btn-default"
																		onclick="changeCom(<%=company.getCompanyId()%>,1)">通过</button>
																	<button type="button" class="btn btn-default"
																		onclick="changeCom(<%=company.getCompanyId()%>,2)">不通过</button>
																</div>
															</div>
														</td>
													</tr>
												<%
														}
													}
												%>
												</tbody>
											</table>
											</p>
										</div>
										
										<!-- 广告位申请 选项卡-->
										<div class='tab-pane' id='advertisement'>
											<p align="center">
											<table class="table table-hover">
												<thead>
													<tr>
														<th class="STYLE10">申请公司</th>
														<th class="STYLE10">联系方式（邮箱）</th>
														<th class="STYLE10">广告位</th>
														<th class="STYLE10">广告时间</th>
														<th class="STYLE10">广告图片</th>
													</tr>
												</thead>
												<tbody>
													<%
														if (request.getAttribute("advertisements") != null) {
															des = "advertisementReview";
															int i = 15;
															String style = "";
															for (Advertisement advertisement : (List<Advertisement>) request.getAttribute("advertisements")) {
																int temp = i % 5;
																i --;
																switch(temp){
																	case 0: style = "success";
																		break;
																	case 1: style = "error";
																		break;
																	case 2: style = "warning";
																		break;
																	case 3: style = "info";
																		break;
																	case 4: style = "active";
																		break;
																}
														%>
														<tr class = <%=style %>>
															<td><%=advertisement.getCompanyId() %></td>
															<td><%=advertisement.getEmail() %></td>
															<td><%=advertisement.getPosition() %></td>
															<td><%=advertisement.getEndDate() %></td>
															<td><%=advertisement.getAdsImgPath() %></td>
															<td bordercolor="#CCCCCC">
																<div>
																	<div align="center">
																		<button type="button" class="btn btn-default"
																			onclick="changeAdv(<%=advertisement.getId()%>,1)">通过</button>
																		<button type="button" class="btn btn-default"
																			onclick="changeAdv(<%=advertisement.getId()%>,2)">不通过</button>
																	</div>
																</div>
															</td>
														</tr>
													<%
															}
														}
													%>
												</tbody>
											</table>
											</p>
										</div>
					
										<!-- 资讯信息 选项卡-->
										<div class='tab-pane' id='news'>
											<p align="center">
											<table class="table table-hover">
												<thead>
													<tr>
														<th><span class="STYLE10">用户名称</span></th>
														<th><span class="STYLE10">标题</span></th>
														<th><span class="STYLE10">类型</span></th>
														<th><span class="STYLE10">内容</span></th>
													</tr>
												</thead>
												<tbody>
												<%
													
													if (request.getAttribute("newss") != null) {
														des = "newsReview";
														int i = 15;
														String style = "";
														for (News news : (List<News>) request.getAttribute("newss")) {
															int temp = i % 5;
															i --;
															switch(temp){
																case 0: style = "success";
																	break;
																case 1: style = "error";
																	break;
																case 2: style = "warning";
																	break;
																case 3: style = "info";
																	break;
																case 4: style = "active";
																	break;
															}
													%>
													<tr class = <%=style %>>
														<td class="STYLE10"><%=news.getName() %></td>
														<td class="STYLE10"><%=news.getTitle()%></td>
														<td class="STYLE10"><%=news.getType() %></td>
														<td class="STYLE10"><%=news.getContent()%></td>
														<td bordercolor="#CCCCCC">
															<div>
																<div align="center">
																	<button type="button" class="btn btn-default" onclick="changeNew(<%=news.getId()%>,1)">通过</button>
																	<button type="button" class="btn btn-default" onclick="changeNew(<%=news.getId()%>,2)">不通过</button>
																</div>
															</div>
														</td>
													</tr>
												<%
														}
													}
												%>
												</tbody>
											</table>
										</div>
									</div>
									<div class="col-md-12 column" align="center">
										<%
											int curPage = Integer.parseInt(request.getAttribute("page") + "");
											int totalPage = Integer.parseInt(request.getAttribute("totalPage") + "");
										%>
										<ul class="pagination">
											<li class=<%=curPage == 1 ? "disabled" : ""%>><a
												href=<%="?forward=" + des + "&page=" + (curPage - 1) + "&size=10"%>>Prev</a>
											</li>
										<%
											//System.out.println("---curPage---" + curPage);
											//System.out.println("---totalPage---" + totalPage);
											for (int i = 1; i <= totalPage; i++) {
										%>
											<li class=<%=curPage == i ? "active" : ""%>><a
												href=<%="?forward=" + des + "&page=" + (i) + "&size=10"%>><%=i%> </a>
											</li>
										<%
											}
										%>
											<li class=<%=curPage == totalPage ? "disabled" : ""%>><a
												href=<%="?forward=" + des + "&page=" + (curPage + 1) + "&size=10"%>>Next</a>
											</li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="jumbotron text-center"
		style="margin-bottom: 0; margin-top: 208px">
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