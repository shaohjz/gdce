<%@ page pageEncoding="UTF-8"
	import="java.util.*,com.isscollege.gdce.domain.Product"%>
<%@ include file="/jsp/header.jsp"%>

<script type="text/javascript">
	function judge()
	{
		var pass=<%=permission.equals("3") ? 1 : 2%>
		if(pass==1)
			{
				window.location.href="<%=context %>/Report";
		} else {
			$('#modal-container-204152').modal();
		}

	}
</script>

<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<style>
.table tbody
 {
	display: block;
	height: 300px;
	overflow-y: auto;
	text-align: center;
}

.table thead, tbody tr 
{
	display: table;
	width: 100%;
	table-layout: fixed;
}

.table thead
 {
	width: cacl(100% -1em);
}
.table thead th 
{
	text-align: center;
	background: #ccc;
}
</style>
</head>

<body>
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
					<li role="presentation" class="active"><a href="<%=context %>/jsp/index.jsp">首页</a></li>
					<li role="presentation"><a href="#">交易中心</a></li>
					<li role="presentation"><a
						href="<%=request.getContextPath()%>/news?forward=findPageBean&&type=hgzc&&currentPage=1">资讯中心</a></li>
					<li role="presentation"><a onClick="judge()"
						href="javascript:judge()">报表中心</a></li>
					<li role="presentation"><a
						href="<%=context%>/register?forward=qualification">会员中心</a></li>
				</ul>
				<h3 class="text-muted">
					<img alt="" src="<%=context%>/imgs/logo.png">
				</h3>
			</nav>
		</div>
	</div>

	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="carousel slide" id="carousel-536799">
					<ol class="carousel-indicators">
						<li data-slide-to="0" data-target="#carousel-536799"></li>
						<li data-slide-to="1" data-target="#carousel-536799"></li>
						<li data-slide-to="2" data-target="#carousel-536799"
							class="active"></li>
					</ol>
					<div class="carousel-inner">
						<div class="item">
							<img alt="" src="<%=context%>/imgs/1.jpg" />
							<div class="carousel-caption">
								<h4>统一平台、集中管制</h4>
							</div>
						</div>
						<div class="item">
							<img alt="" src="<%=context%>/imgs/2.png" />
							<div class="carousel-caption">
								<h4>阳光采购、竞价交易</h4>
							</div>
						</div>
						<div class="item active">
							<img alt="" src="<%=context%>/imgs/3.png" />
							<div class="carousel-caption">
								<h4>智能管理，公正验收</h4>
							</div>
						</div>
					</div>
					<a class="left carousel-control" href="#carousel-536799"
						data-slide="prev"><span
						class="glyphicon glyphicon-chevron-left"></span></a> <a
						class="right carousel-control" href="#carousel-536799"
						data-slide="next"><span
						class="glyphicon glyphicon-chevron-right"></span></a>
				</div>
			</div>
		</div>
	</div>

	<div class="cont" style="margin:30px auto; width:100%" >
		<div id="advertisement" style="border-collapse: collapse;
				border: 0px solid gray; width:1140px; margin:auto;">
			<div class="adver" style="border-collapse: collapse;
				border: 0px solid gray; border-right-width: 1px; float: left; width:33%">
				<a href="#"><img src="<%=context%>/imgs/ad/001.PNG" alt="picture" /></a>
			</div><br>
			
			<div class="adver" style="border-collapse: collapse;
				border: 0px solid gray; border-right-width: 1px; float: left; width:33%">
				<a href="#"><img src="<%=context%>/imgs/ad/002.PNG" alt="picture" /></a>
			</div><br>
			
			<div class="adver" style="float: left; width:30%" >
				<a href="#"><img src="<%=context%>/imgs/ad/003.PNG" alt="picture" /></a>
			</div><br>
		</div><br>
	</div><br>

 
	 <%
		List<Product> productList = (List<Product>) request.getAttribute("productList");
	%>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-16 column">
			    <h2><span class="label label-primary">销售信息</span></h2>
					<table class="table table-hover">
						<thead style="background: #87CEFF">
							<tr>
								<th>煤种</th>
								<th>产地</th>
								<th>交货地</th>
								<th>价格</th>
								<th>数量</th>
								<th>发布时间</th>
								<th>截止时间</th>
								<th>全水份</th>
								<th>全硫份</th>
								<th>挥发份</th>
								<th>交货方式</th>
								<th>低位发热量</th>
								<th>用户名称</th>
                                <th>     </th>
							</tr>
						</thead>
						<tbody>
							<%
								for (int i = 0; i < productList.size(); i++)
								{
									Product product = (Product) productList.get(i);
							%>
								<tr  class="success">
								<td><%=product.getProductType()%></td>
								<td><%=product.getSrcAddress()%></td>
								<td><%=product.getDestAddress()%></td>
								<td><%=product.getPrice()%></td>
								<td><%=product.getQuantity()%></td>
								<td><%=product.getCreateDate()%></td>
								<td><%=product.getEndDate()%></td>
								<td><%=product.getFullMoisture()%></td>
								<td><%=product.getFullSulfur()%></td>
								<td><%=product.getVolatiles()%></td>
								<td><%=product.getTransactionMode()%></td>
								<td><%=product.getLowPower()%></td>
								<td><%=product.getUserName()%></td>
                                <td><a href="<%=context%>/trade?forward=productId&productId=<%=product.getProductId()%>">查看</a></td>							
                                </tr>
							<%
								}
							%>
						</tbody>
					</table>
				</div>
			</div>
		</div>

	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<h2>
					<span class="label label-primary">采购信息</span>
				</h2>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>煤种</th>
							<th>低位发热量（Kcal）</th>
							<th>全水分（%）</th>
							<th>全硫份（%）</th>
							<th>挥发份（%）</th>
							<th>价格（元/吨）</th>
							<th>数量（万吨）</th>
							<th>交货方式</th>
							<th>交割地</th>
							<th>发布/截止日期</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>山西煤</td>
							<td>5000</td>
							<td>14</td>
							<td>1.8</td>
							<td>23至28</td>
							<td>--</td>
							<td>5</td>
							<td>场地交货</td>
							<td>秦曹两港</td>
							<td>2016-04-06至2016-04-30</td>
						<tr class="success">
							<td>蒙煤</td>
							<td>5000</td>
							<td>17</td>
							<td>0.5</td>
							<td>23至27</td>
							<td>--</td>
							<td>5.04</td>
							<td>场地交货</td>
							<td>秦曹两港</td>
							<td>2016-03-01至2016-03-31</td>
						<tr class="error">
							<td>山西煤</td>
							<td>5000</td>
							<td>13</td>
							<td>1.5</td>
							<td>23至27</td>
							<td>--</td>
							<td>5.04</td>
							<td>场地交货</td>
							<td>秦曹两港</td>
							<td>2016-03-01至2016-03-31</td>
						<tr class="warning">
							<td>山西煤</td>
							<td>5000</td>
							<td>13</td>
							<td>0.6</td>
							<td>23至27</td>
							<td>--</td>
							<td>5.04</td>
							<td>场地交货</td>
							<td>秦曹两港</td>
							<td>2016-03-01至2016-03-31</td>
						<tr class="info">
							<td>蒙煤</td>
							<td>5000</td>
							<td>17</td>
							<td>0.5</td>
							<td>23至27</td>
							<td>--</td>
							<td>5</td>
							<td>场地交货</td>
							<td>秦曹两港</td>
							<td>2016-02-16至2016-02-29</td>
						<tr class="success">
							<td>山西煤</td>
							<td>5000</td>
							<td>13</td>
							<td>1.5</td>
							<td>23至27</td>
							<td>--</td>
							<td>5</td>
							<td>场地交货</td>
							<td>秦曹两港</td>
							<td>2016-02-16至2016-02-29</td>
						<tr class="warning">
							<td>山西煤</td>
							<td>5000</td>
							<td>13</td>
							<td>1.5</td>
							<td>23至28</td>
							<td>--</td>
							<td>5</td>
							<td>场地交货</td>
							<td>秦曹两港</td>
							<td>2016-01-20至2016-01-31</td>
						<tr class="info">
							<td>山西煤</td>
							<td>5000</td>
							<td>12</td>
							<td>1</td>
							<td>23至28</td>
							<td>--</td>
							<td>5</td>
							<td>场地交货</td>
							<td>秦曹两港</td>
							<td>2016-01-05至2016-01-31</td>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div style="height: 120px;">
					<img src="/gdce/imgs/1.jpg" width="100%"
						style="float: left; height: 120px" />

				</div>
			</div>
		</div>
	</div>

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
</body>
</html>