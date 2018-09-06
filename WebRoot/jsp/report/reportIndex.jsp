<%@ page pageEncoding="UTF-8" import="java.util.*"%>
<%@ include file="../header.jsp"%>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/data.js"></script>

<style type="text/css">
.reportSize {
	width: 500px;
	height: 350px;
	border: 0px;
}

* {
	margin: 0;
	padding: 0;
}

.container.text-right {
	background-color: white;
	margin: auto;
	width: 1004px;;
	height: 50px;
}

.container {
	width: 1004px;
}

.footerP {
	background-color: #2B2B2B;
	width: 100%;
	height: 190px;
}

.main {
	margin: auto;
	width: 1004px;
	height: 570px
}

.header {
	margin: auto;
	width: 1004px;
	height: 120px;
}

.box {
	margin: auto;
	padding: 3px 5px 3px 5px;
	width: 1004px;
	height: 147px;
	border: 1px solid #848484;
}

.locationD {
	margin: auto;
	margin-top: 10px;
	width: 1004px;
	height: 47px;
	padding: 10px;
	border: 1px solid #848484;
	background: linear-gradient(to bottom, white, #DBDBDB, #B3B3B3);
}

.locationP {
	margin: auto;
	width: 1004px;
	height: 47px;
}

.tabbable {
	width: 1004px;
}

</style>

<body>
	<div class="container text-right" style="margin-bottom: 0">
		<%=currentUser.equals("") ? "<a href='" + context + "/jsp/user/login.jsp'>登录</a>" : currentUser%>&nbsp;&nbsp;
		<a href="<%=context%>/jsp/user/register.jsp">注册</a>&nbsp;&nbsp; <a
			href="<%=context%>/logout">注销</a>
	</div>
	<div class="container">
		<div class="header clearfix">
			<nav class="navbar">
				<ul class="nav nav-pills pull-right socials">
					<li role="presentation"><a href="<%=context%>/index.jsp">首页</a></li>
					<li role="presentation"><a>交易中心</a></li>
					<li role="presentation"><a
						href="<%=context%>/jsp/news/newsCenter.jsp">资讯中心</a></li>
					<li role="presentation" class="active"><a
						href="<%=context%>/jsp/report/reportIndex.jsp">报表中心</a></li>
					<li role="presentation"><a
						href="<%=context%>/jsp/user/mumberCenter.jsp">会员中心</a></li>
				</ul>
				<h3 class="text-muted">
					<img alt="logo" src="<%=context%>/imgs/logo.png">
				</h3>
			</nav>
		</div>
	</div>

	<div class="box">
		<img alt="分割图" src="<%=context%>/imgs/trade/banner004.png">
	</div>

	<div class="locationD">
		<p class="locationP">
			<span style="color: #1196EE">当前位置：</span>报表中心
		</p>
	</div>

	<div align="center" style="margin-top: 30px" class="container">
		<div class="row clearfix">
			<div class="tabbable" id="tabs-113539">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#panel-788590" data-toggle="tab">查看报表</a></li>
					<li><a href="#panel-454077" data-toggle="tab">查看柱状图</a></li>
				</ul>

				<div style="margin-top: 30px" class="tab-content">
					<div class="tab-pane active" id="panel-788590">
						<script type="text/javascript">
							function toggle(id) {
								var tb = document.getElementById(id);
								if (tb.style.display == 'none')
									tb.style.display = 'block';
								else
									tb.style.display = 'none';
							}
							function changeClassName(id) {
								var lia = document.getElementById(id);
								if (lia.className == 'active')
									lia.className = 'none';
								else
									lia.className = 'active';
							}
						</script>
						<div class="header clearfix">
							<nav class="navbar">
								<ul class="nav nav-pills socials">
									<li onClick="changeClassName('li1')" id="li1" style="padding:0 7px;"><a
										onClick="toggle('table1')">一月</a></li>
									<li onClick="changeClassName('li2')" id="li2" style="padding:0 7px;"><a
										onClick="toggle('table2')">二月</a></li>
									<li onClick="changeClassName('li3')" id="li3" style="padding:0 7px;"><a
										onClick="toggle('table3')">三月</a></li>
									<li onClick="changeClassName('li4')" id="li4" style="padding:0 7px;"><a
										onClick="toggle('table4')">四月</a></li>
									<li onClick="changeClassName('li5')" id="li5" style="padding:0 7px;"><a
										onClick="toggle('table5')">五月</a></li>
									<li onClick="changeClassName('li6')" id="li6" style="padding:0 7px;"><a
										onClick="toggle('table6')">六月</a></li>
									<li onClick="changeClassName('li7')" id="li7" style="padding:0 7px;"><a
										onClick="toggle('table7')">七月</a></li>
									<li onClick="changeClassName('li8')" id="li8" style="padding:0 7px;"><a
										onClick="toggle('table8')">八月</a></li>
									<li onClick="changeClassName('li9')" id="li9" style="padding:0 7px;"><a
										onClick="toggle('table9')">九月</a></li>
									<li onClick="changeClassName('li10')" id="li10" style="padding:0 7px;"><a
										onClick="toggle('table10')">十月</a></li>
									<li onClick="changeClassName('li11')" id="li11" style="padding:0 7px;"><a
										onClick="toggle('table11')">十一月</a></li>
									<li onClick="changeClassName('li12')" id="li12" style="padding:0 7px;"><a
										onClick="toggle('table12')">十二月</a></li>
								</ul>
							</nav>
						</div>

						<table class="table"
							style="width: 950px; display: none; margin:auto; margin-bottom:40px;"
							id="table1">
							<thead>
								<tr style="background:#CCFFEB">
									<th width="300px">煤种</th>
									<th width="300px">一月份销售量</th>
									<th width="300px">一月份销售总额</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th>混煤</th>
									<td>${sessionScope.reportone.get(0).sumPrice}</td>
									<td>${sessionScope.reportone.get(0).sumQuantity}</td>
								</tr>
								<tr>
									<th>褐煤</th>
									<td>${sessionScope.reportone.get(1).sumPrice}</td>
									<td>${sessionScope.reportone.get(1).sumQuantity}</td>
								</tr>
								<tr>
									<th>电煤</th>
									<td>${sessionScope.reportone.get(2).sumPrice}</td>
									<td>${sessionScope.reportone.get(2).sumQuantity}</td>
								</tr>
								<tr>
									<th>烟煤</th>
									<td>${sessionScope.reportone.get(3).sumPrice}</td>
									<td>${sessionScope.reportone.get(3).sumQuantity}</td>
								</tr>
								<tr>
									<th>沫煤</th>
									<td>${sessionScope.reportone.get(4).sumPrice}</td>
									<td>${sessionScope.reportone.get(4).sumQuantity}</td>
								</tr>
								<tr>
									<th>无烟煤</th>
									<td>${sessionScope.reportone.get(5).sumPrice}</td>
									<td>${sessionScope.reportone.get(5).sumQuantity}</td>
								</tr>
							</tbody>
						</table>
						<table class="table"
							style="width: 950px; display: none; margin:auto; margin-bottom:40px;"
							id="table2">
							<thead>
								<tr style="background:#CCFFEB">
									<th width="300px">煤种</th>
									<th width="300px">二月份销售量</th>
									<th width="300px">二月份销售总额</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th>混煤</th>
									<td>${sessionScope.reporttwo.get(0).sumPrice}</td>
									<td>${sessionScope.reporttwo.get(0).sumQuantity}</td>
								</tr>
								<tr>
									<th>褐煤</th>
									<td>${sessionScope.reporttwo.get(1).sumPrice}</td>
									<td>${sessionScope.reporttwo.get(1).sumQuantity}</td>
								</tr>
								<tr>
									<th>电煤</th>
									<td>${sessionScope.reporttwo.get(2).sumPrice}</td>
									<td>${sessionScope.reporttwo.get(2).sumQuantity}</td>
								</tr>
								<tr>
									<th>烟煤</th>
									<td>${sessionScope.reporttwo.get(3).sumPrice}</td>
									<td>${sessionScope.reporttwo.get(3).sumQuantity}</td>
								</tr>
								<tr>
									<th>沫煤</th>
									<td>${sessionScope.reporttwo.get(4).sumPrice}</td>
									<td>${sessionScope.reporttwo.get(4).sumQuantity}</td>
								</tr>
								<tr>
									<th>无烟煤</th>
									<td>${sessionScope.reporttwo.get(5).sumPrice}</td>
									<td>${sessionScope.reporttwo.get(5).sumQuantity}</td>
								</tr>
							</tbody>
						</table>
						<table class="table"
							style="width: 950px; display: none; margin:auto; margin-bottom:40px;"
							id="table3">
							<thead>
								<tr style="background:#CCFFEB">
									<th width="300px">煤种</th>
									<th width="300px">三月份销售量</th>
									<th width="300px">三月份销售总额</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th>混煤</th>
									<td>${sessionScope.reportthree.get(0).sumPrice}</td>
									<td>${sessionScope.reportthree.get(0).sumQuantity}</td>
								</tr>
								<tr>
									<th>褐煤</th>
									<td>${sessionScope.reportthree.get(1).sumPrice}</td>
									<td>${sessionScope.reportthree.get(1).sumQuantity}</td>
								</tr>
								<tr>
									<th>电煤</th>
									<td>${sessionScope.reportthree.get(2).sumPrice}</td>
									<td>${sessionScope.reportthree.get(2).sumQuantity}</td>
								</tr>
								<tr>
									<th>烟煤</th>
									<td>${sessionScope.reportthree.get(3).sumPrice}</td>
									<td>${sessionScope.reportthree.get(3).sumQuantity}</td>
								</tr>
								<tr>
									<th>沫煤</th>
									<td>${sessionScope.reportthree.get(4).sumPrice}</td>
									<td>${sessionScope.reportthree.get(4).sumQuantity}</td>
								</tr>
								<tr>
									<th>无烟煤</th>
									<td>${sessionScope.reportthree.get(5).sumPrice}</td>
									<td>${sessionScope.reportthree.get(5).sumQuantity}</td>
								</tr>
							</tbody>
						</table>
						<table class="table"
							style="width: 950px; display: none; margin:auto; margin-bottom:40px;"
							id="table4">
							<thead>
								<tr style="background:#CCFFEB">
									<th width="300px">煤种</th>
									<th width="300px">四月份销售量</th>
									<th width="300px">四月份销售总额</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th>混煤</th>
									<td>${sessionScope.reportfour.get(0).sumPrice}</td>
									<td>${sessionScope.reportfour.get(0).sumQuantity}</td>
								</tr>
								<tr>
									<th>褐煤</th>
									<td>${sessionScope.reportfour.get(1).sumPrice}</td>
									<td>${sessionScope.reportfour.get(1).sumQuantity}</td>
								</tr>
								<tr>
									<th>电煤</th>
									<td>${sessionScope.reportfour.get(2).sumPrice}</td>
									<td>${sessionScope.reportfour.get(2).sumQuantity}</td>
								</tr>
								<tr>
									<th>烟煤</th>
									<td>${sessionScope.reportfour.get(3).sumPrice}</td>
									<td>${sessionScope.reportfour.get(3).sumQuantity}</td>
								</tr>
								<tr>
									<th>沫煤</th>
									<td>${sessionScope.reportfour.get(4).sumPrice}</td>
									<td>${sessionScope.reportfour.get(4).sumQuantity}</td>
								</tr>
								<tr>
									<th>无烟煤</th>
									<td>${sessionScope.reportfour.get(5).sumPrice}</td>
									<td>${sessionScope.reportfour.get(5).sumQuantity}</td>
								</tr>
							</tbody>
						</table>
						<table class="table"
							style="width: 950px; display: none; margin:auto; margin-bottom:40px;"
							id="table5">
							<thead>
								<tr style="background:#CCFFEB">
									<th width="300px">煤种</th>
									<th width="300px">五月份销售量</th>
									<th width="300px">五月份销售总额</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th>混煤</th>
									<td>${sessionScope.reportfive.get(0).sumPrice}</td>
									<td>${sessionScope.reportfive.get(0).sumQuantity}</td>
								</tr>
								<tr>
									<th>褐煤</th>
									<td>${sessionScope.reportfive.get(1).sumPrice}</td>
									<td>${sessionScope.reportfive.get(1).sumQuantity}</td>
								</tr>
								<tr>
									<th>电煤</th>
									<td>${sessionScope.reportfive.get(2).sumPrice}</td>
									<td>${sessionScope.reportfive.get(2).sumQuantity}</td>
								</tr>
								<tr>
									<th>烟煤</th>
									<td>${sessionScope.reportfive.get(3).sumPrice}</td>
									<td>${sessionScope.reportfive.get(3).sumQuantity}</td>
								</tr>
								<tr>
									<th>沫煤</th>
									<td>${sessionScope.reportfive.get(4).sumPrice}</td>
									<td>${sessionScope.reportfive.get(4).sumQuantity}</td>
								</tr>
								<tr>
									<th>无烟煤</th>
									<td>${sessionScope.reportfive.get(5).sumPrice}</td>
									<td>${sessionScope.reportfive.get(5).sumQuantity}</td>
								</tr>
							</tbody>
						</table>
						<table class="table"
							style="width: 950px; display: none; margin:auto; margin-bottom:40px;"
							id="table6">
							<thead>
								<tr style="background:#CCFFEB">
									<th width="300px">煤种</th>
									<th width="300px">六月份销售量</th>
									<th width="300px">六月份销售总额</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th>混煤</th>
									<td>${sessionScope.reportsix.get(0).sumPrice}</td>
									<td>${sessionScope.reportsix.get(0).sumQuantity}</td>
								</tr>
								<tr>
									<th>褐煤</th>
									<td>${sessionScope.reportsix.get(1).sumPrice}</td>
									<td>${sessionScope.reportsix.get(1).sumQuantity}</td>
								</tr>
								<tr>
									<th>电煤</th>
									<td>${sessionScope.reportsix.get(2).sumPrice}</td>
									<td>${sessionScope.reportsix.get(2).sumQuantity}</td>
								</tr>
								<tr>
									<th>烟煤</th>
									<td>${sessionScope.reportsix.get(3).sumPrice}</td>
									<td>${sessionScope.reportsix.get(3).sumQuantity}</td>
								</tr>
								<tr>
									<th>沫煤</th>
									<td>${sessionScope.reportsix.get(4).sumPrice}</td>
									<td>${sessionScope.reportsix.get(4).sumQuantity}</td>
								</tr>
								<tr>
									<th>无烟煤</th>
									<td>${sessionScope.reportsix.get(5).sumPrice}</td>
									<td>${sessionScope.reportsix.get(5).sumQuantity}</td>
								</tr>
							</tbody>
						</table>
						<table class="table"
							style="width: 950px; display: none; margin:auto; margin-bottom:40px;"
							id="table7">
							<thead>
								<tr style="background:#CCFFEB">
									<th width="300px">煤种</th>
									<th width="300px">七月份销售量</th>
									<th width="300px">七月份销售总额</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th>混煤</th>
									<td>${sessionScope.reportseven.get(0).sumPrice}</td>
									<td>${sessionScope.reportseven.get(0).sumQuantity}</td>
								</tr>
								<tr>
									<th>褐煤</th>
									<td>${sessionScope.reportseven.get(1).sumPrice}</td>
									<td>${sessionScope.reportseven.get(1).sumQuantity}</td>
								</tr>
								<tr>
									<th>电煤</th>
									<td>${sessionScope.reportseven.get(2).sumPrice}</td>
									<td>${sessionScope.reportseven.get(2).sumQuantity}</td>
								</tr>
								<tr>
									<th>烟煤</th>
									<td>${sessionScope.reportseven.get(3).sumPrice}</td>
									<td>${sessionScope.reportseven.get(3).sumQuantity}</td>
								</tr>
								<tr>
									<th>沫煤</th>
									<td>${sessionScope.reportseven.get(4).sumPrice}</td>
									<td>${sessionScope.reportseven.get(4).sumQuantity}</td>
								</tr>
								<tr>
									<th>无烟煤</th>
									<td>${sessionScope.reportseven.get(5).sumPrice}</td>
									<td>${sessionScope.reportseven.get(5).sumQuantity}</td>
								</tr>
							</tbody>
						</table>
						<table class="table"
							style="width: 950px; display: none; margin:auto; margin-bottom:40px;"
							id="table8">
							<thead>
								<tr style="background:#CCFFEB">
									<th width="300px">煤种</th>
									<th width="300px">八月份销售量</th>
									<th width="300px">八月份销售总额</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th>混煤</th>
									<td>${sessionScope.reporteight.get(0).sumPrice}</td>
									<td>${sessionScope.reporteight.get(0).sumQuantity}</td>
								</tr>
								<tr>
									<th>褐煤</th>
									<td>${sessionScope.reporteight.get(1).sumPrice}</td>
									<td>${sessionScope.reporteight.get(1).sumQuantity}</td>
								</tr>
								<tr>
									<th>电煤</th>
									<td>${sessionScope.reporteight.get(2).sumPrice}</td>
									<td>${sessionScope.reporteight.get(2).sumQuantity}</td>
								</tr>
								<tr>
									<th>烟煤</th>
									<td>${sessionScope.reporteight.get(3).sumPrice}</td>
									<td>${sessionScope.reporteight.get(3).sumQuantity}</td>
								</tr>
								<tr>
									<th>沫煤</th>
									<td>${sessionScope.reporteight.get(4).sumPrice}</td>
									<td>${sessionScope.reporteight.get(4).sumQuantity}</td>
								</tr>
								<tr>
									<th>无烟煤</th>
									<td>${sessionScope.reporteight.get(5).sumPrice}</td>
									<td>${sessionScope.reporteight.get(5).sumQuantity}</td>
								</tr>
							</tbody>
						</table>
						<table class="table"
							style="width: 950px; display: none; margin:auto; margin-bottom:40px;"
							id="table9">
							<thead>
								<tr style="background:#CCFFEB">
									<th width="300px">煤种</th>
									<th width="300px">九月份销售量</th>
									<th width="300px">九月份销售总额</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th>混煤</th>
									<td>${sessionScope.reportnine.get(0).sumPrice}</td>
									<td>${sessionScope.reportnine.get(0).sumQuantity}</td>
								</tr>
								<tr>
									<th>褐煤</th>
									<td>${sessionScope.reportnine.get(1).sumPrice}</td>
									<td>${sessionScope.reportnine.get(1).sumQuantity}</td>
								</tr>
								<tr>
									<th>电煤</th>
									<td>${sessionScope.reportnine.get(2).sumPrice}</td>
									<td>${sessionScope.reportnine.get(2).sumQuantity}</td>
								</tr>
								<tr>
									<th>烟煤</th>
									<td>${sessionScope.reportnine.get(3).sumPrice}</td>
									<td>${sessionScope.reportnine.get(3).sumQuantity}</td>
								</tr>
								<tr>
									<th>沫煤</th>
									<td>${sessionScope.reportnine.get(4).sumPrice}</td>
									<td>${sessionScope.reportnine.get(4).sumQuantity}</td>
								</tr>
								<tr>
									<th>无烟煤</th>
									<td>${sessionScope.reportnine.get(5).sumPrice}</td>
									<td>${sessionScope.reportnine.get(5).sumQuantity}</td>
								</tr>
							</tbody>
						</table>
						<table class="table"
							style="width: 950px; display: none; margin:auto; margin-bottom:40px;"
							id="table10">
							<thead>
								<tr style="background:#CCFFEB">
									<th width="300px">煤种</th>
									<th width="300px">十月份销售量</th>
									<th width="300px">十月份销售总额</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th>混煤</th>
									<td>${sessionScope.reportten.get(0).sumPrice}</td>
									<td>${sessionScope.reportten.get(0).sumQuantity}</td>
								</tr>
								<tr>
									<th>褐煤</th>
									<td>${sessionScope.reportten.get(1).sumPrice}</td>
									<td>${sessionScope.reportten.get(1).sumQuantity}</td>
								</tr>
								<tr>
									<th>电煤</th>
									<td>${sessionScope.reportten.get(2).sumPrice}</td>
									<td>${sessionScope.reportten.get(2).sumQuantity}</td>
								</tr>
								<tr>
									<th>烟煤</th>
									<td>${sessionScope.reportten.get(3).sumPrice}</td>
									<td>${sessionScope.reportten.get(3).sumQuantity}</td>
								</tr>
								<tr>
									<th>沫煤</th>
									<td>${sessionScope.reportten.get(4).sumPrice}</td>
									<td>${sessionScope.reportten.get(4).sumQuantity}</td>
								</tr>
								<tr>
									<th>无烟煤</th>
									<td>${sessionScope.reportten.get(5).sumPrice}</td>
									<td>${sessionScope.reportten.get(5).sumQuantity}</td>
								</tr>
							</tbody>
						</table>
						<table class="table"
							style="width: 950px; display: none; margin:auto; margin-bottom:40px;"
							id="table11">
							<thead>
								<tr style="background:#CCFFEB">
									<th width="300px">煤种</th>
									<th width="300px">十一月份销售量</th>
									<th width="300px">十一月份销售总额</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th>混煤</th>
									<td>${sessionScope.reportele.get(0).sumPrice}</td>
									<td>${sessionScope.reportele.get(0).sumQuantity}</td>
								</tr>
								<tr>
									<th>褐煤</th>
									<td>${sessionScope.reportele.get(1).sumPrice}</td>
									<td>${sessionScope.reportele.get(1).sumQuantity}</td>
								</tr>
								<tr>
									<th>电煤</th>
									<td>${sessionScope.reportele.get(2).sumPrice}</td>
									<td>${sessionScope.reportele.get(2).sumQuantity}</td>
								</tr>
								<tr>
									<th>烟煤</th>
									<td>${sessionScope.reportele.get(3).sumPrice}</td>
									<td>${sessionScope.reportele.get(3).sumQuantity}</td>
								</tr>
								<tr>
									<th>沫煤</th>
									<td>${sessionScope.reportele.get(4).sumPrice}</td>
									<td>${sessionScope.reportele.get(4).sumQuantity}</td>
								</tr>
								<tr>
									<th>无烟煤</th>
									<td>${sessionScope.reportele.get(5).sumPrice}</td>
									<td>${sessionScope.reportele.get(5).sumQuantity}</td>
								</tr>
							</tbody>
						</table>
						<table class="table"
							style="width: 950px; display: none; margin:auto;"
							id="table12">
							<thead>
								<tr style="background:#CCFFEB">
									<th width="300px">煤种</th>
									<th width="300px">十二月份销售量</th>
									<th width="300px">十二月份销售总额</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th>混煤</th>
									<td>${sessionScope.reporttev.get(0).sumPrice}</td>
									<td>${sessionScope.reporttev.get(0).sumQuantity}</td>
								</tr>
								<tr>
									<th>褐煤</th>
									<td>${sessionScope.reporttev.get(1).sumPrice}</td>
									<td>${sessionScope.reporttev.get(1).sumQuantity}</td>
								</tr>
								<tr>
									<th>电煤</th>
									<td>${sessionScope.reporttev.get(2).sumPrice}</td>
									<td>${sessionScope.reporttev.get(2).sumQuantity}</td>
								</tr>
								<tr>
									<th>烟煤</th>
									<td>${sessionScope.reporttev.get(3).sumPrice}</td>
									<td>${sessionScope.reporttev.get(3).sumQuantity}</td>
								</tr>
								<tr>
									<th>沫煤</th>
									<td>${sessionScope.reporttev.get(4).sumPrice}</td>
									<td>${sessionScope.reporttev.get(4).sumQuantity}</td>
								</tr>
								<tr>
									<th>无烟煤</th>
									<td>${sessionScope.reporttev.get(5).sumPrice}</td>
									<td>${sessionScope.reporttev.get(5).sumQuantity}</td>
								</tr>
							</tbody>
						</table>

					</div>

					<div class="tab-pane" id="panel-454077">
						<div class="container">
							<div class="row clearfix">
								<div class="col-md-12 column">
									<script type="text/javascript">
										function doggle(id) {
											var ddiv = document
													.getElementById(id);
											if (ddiv.style.display == 'none')
												ddiv.style.display = 'block';
											else
												ddiv.style.display = 'none';
										}
									</script>
									<div class="header clearfix">
										<nav class="navbar">
											<ul class="nav nav-pills socials">
												<li onClick="changeClassName('li13')" id="li13" style="padding:0 7px;"><a
													onClick="doggle('container1')">一月</a></li>
												<li onClick="changeClassName('li14')" id="li14" style="padding:0 7px;"><a
													onClick="doggle('container2')">二月</a></li>
												<li onClick="changeClassName('li15')" id="li15" style="padding:0 7px;"><a
													onClick="doggle('container3')">三月</a></li>
												<li onClick="changeClassName('li16')" id="li16" style="padding:0 7px;"><a
													onClick="doggle('container4')">四月</a></li>
												<li onClick="changeClassName('li17')" id="li17" style="padding:0 7px;"><a
													onClick="doggle('container5')">五月</a></li>
												<li onClick="changeClassName('li18')" id="li18" style="padding:0 7px;"><a
													onClick="doggle('container6')">六月</a></li>
												<li onClick="changeClassName('li19')" id="li19" style="padding:0 7px;"><a
													onClick="doggle('container7')">七月</a></li>
												<li onClick="changeClassName('li20')" id="li20" style="padding:0 7px;"><a
													onClick="doggle('container8')">八月</a></li>
												<li onClick="changeClassName('li21')" id="li21" style="padding:0 7px;"><a
													onClick="doggle('container9')">九月</a></li>
												<li onClick="changeClassName('li22')" id="li22" style="padding:0 7px;"><a
													onClick="doggle('container10')">十月</a></li>
												<li onClick="changeClassName('li23')" id="li23" style="padding:0 7px;"><a
													onClick="doggle('container11')">十一月</a></li>
												<li onClick="changeClassName('li24')" id="li24" style="padding:0 7px;"><a
													onClick="doggle('container12')">十二月</a></li>
											</ul>
										</nav>
									</div>
									<div id="container1"
										style="width: 550px; height: 400px; display: none; margin: 0"></div>
									<div id="container2"
										style="width: 550px; height: 400px; display: none; margin: 0"></div>
									<div id="container3"
										style="width: 550px; height: 400px; display: none; margin: 0"></div>
									<div id="container4"
										style="width: 550px; height: 400px; display: none; margin: 0"></div>
									<div id="container5"
										style="width: 550px; height: 400px; display: none; margin: 0"></div>
									<div id="container6"
										style="width: 550px; height: 400px; display: none; margin: 0"></div>
									<div id="container7"
										style="width: 550px; height: 400px; display: none; margin: 0"></div>
									<div id="container8"
										style="width: 550px; height: 400px; display: none; margin: 0"></div>
									<div id="container9"
										style="width: 550px; height: 400px; display: none; margin: 0"></div>
									<div id="container10"
										style="width: 550px; height: 400px; display: none; margin: 0"></div>
									<div id="container11"
										style="width: 550px; height: 400px; display: none; margin: 0"></div>
									<div id="container12"
										style="width: 550px; height: 400px; display: none; margin: 0"></div>
									<script language="JavaScript">
										$(document)
												.ready(
														function() {
															var data1 = {
																table : 'table1'
															};
															var data2 = {
																table : 'table2'
															};
															var data3 = {
																table : 'table3'
															};
															var data4 = {
																table : 'table4'
															};
															var data5 = {
																table : 'table5'
															};
															var data6 = {
																table : 'table6'
															};
															var data7 = {
																table : 'table7'
															};
															var data8 = {
																table : 'table8'
															};
															var data9 = {
																table : 'table9'
															};
															var data10 = {
																table : 'table10'
															};
															var data11 = {
																table : 'table11'
															};
															var data12 = {
																table : 'table12'
															};

															var chart = {
																type : 'column'
															};

															var title1 = {
																text : '一月'
															};
															var title2 = {
																text : ' 二月 '
															};
															var title3 = {
																text : '三月'
															};
															var title4 = {
																text : '四月'
															};
															var title5 = {
																text : '五月'
															};
															var title6 = {
																text : '六月 '
															};
															var title7 = {
																text : '七月'
															};
															var title8 = {
																text : '八月'
															};
															var title9 = {
																text : '九月'
															};
															var title10 = {
																text : '十月 '
															};
															var title11 = {
																text : '十一月'
															};
															var title12 = {
																text : '十二月'
															};

															var yAxis = {
																allowDecimals : false,
																title : {
																	text : ''
																}
															};
															var tooltip = {
																formatter : function() {
																	return '<b>'
																			+ this.series.name
																			+ '</b><br/>'
																			+ this.point.y
																			+ ' '
																			+ this.point.name
																					.toLowerCase();
																}
															};
															var credits = {
																enabled : false
															};

															var json1 = {};
															json1.chart = chart;
															json1.title = title1;
															json1.data = data1;
															json1.yAxis = yAxis;
															json1.credits = credits;
															json1.tooltip = tooltip;
															$('#container1')
																	.highcharts(
																			json1);

															var json2 = {};
															json2.chart = chart;
															json2.title = title2;
															json2.data = data2;
															json2.yAxis = yAxis;
															json2.credits = credits;
															json2.tooltip = tooltip;
															$('#container2')
																	.highcharts(
																			json2);

															var json3 = {};
															json3.chart = chart;
															json3.title = title3;
															json3.data = data3;
															json3.yAxis = yAxis;
															json3.credits = credits;
															json3.tooltip = tooltip;
															$('#container3')
																	.highcharts(
																			json3);

															var json4 = {};
															json4.chart = chart;
															json4.title = title4;
															json4.data = data4;
															json4.yAxis = yAxis;
															json4.credits = credits;
															json4.tooltip = tooltip;
															$('#container4')
																	.highcharts(
																			json4);

															var json5 = {};
															json5.chart = chart;
															json5.title = title5;
															json5.data = data5;
															json5.yAxis = yAxis;
															json5.credits = credits;
															json5.tooltip = tooltip;
															$('#container5')
																	.highcharts(
																			json5);

															var json6 = {};
															json6.chart = chart;
															json6.title = title6;
															json6.data = data6;
															json6.yAxis = yAxis;
															json6.credits = credits;
															json6.tooltip = tooltip;
															$('#container6')
																	.highcharts(
																			json6);

															var json7 = {};
															json7.chart = chart;
															json7.title = title7;
															json7.data = data7;
															json7.yAxis = yAxis;
															json7.credits = credits;
															json7.tooltip = tooltip;
															$('#container7')
																	.highcharts(
																			json7);

															var json8 = {};
															json8.chart = chart;
															json8.title = title8;
															json8.data = data8;
															json8.yAxis = yAxis;
															json8.credits = credits;
															json8.tooltip = tooltip;
															$('#container8')
																	.highcharts(
																			json8);

															var json9 = {};
															json9.chart = chart;
															json9.title = title9;
															json9.data = data9;
															json9.yAxis = yAxis;
															json9.credits = credits;
															json9.tooltip = tooltip;
															$('#container9')
																	.highcharts(
																			json9);

															var json10 = {};
															json10.chart = chart;
															json10.title = title10;
															json10.data = data10;
															json10.yAxis = yAxis;
															json10.credits = credits;
															json10.tooltip = tooltip;
															$('#container10')
																	.highcharts(
																			json10);

															var json11 = {};
															json11.chart = chart;
															json11.title = title11;
															json11.data = data11;
															json11.yAxis = yAxis;
															json11.credits = credits;
															json11.tooltip = tooltip;
															$('#container11')
																	.highcharts(
																			json11);

															var json12 = {};
															json12.chart = chart;
															json12.title = title12;
															json12.data = data12;
															json12.yAxis = yAxis;
															json12.credits = credits;
															json12.tooltip = tooltip;
															$('#container12')
																	.highcharts(
																			json12);

														});
									</script>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>

		</div>

		<div style="float: right; margin-top: 30px">
			<button class="btn btn-lg btn-primary" disabled="disabled">打印</button>
		</div>
	</div>
	<div class="jumbotron text-center"
		style="margin-bottom: 0; margin-top: 100px">
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