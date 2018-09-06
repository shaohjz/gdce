<%@ page pageEncoding="UTF-8" import="java.util.*"%>
<%@ include file="/jsp/header.jsp"%>
<%@ page import="java.sql.*"%>
<meta http-equiv="refresh" content="30">
<head>
<script language="javascript" type="text/javascript">
        function showdiv() {
            document.getElementById("bg").style.display = "block";
            document.getElementById("show").style.display = "block";
        }


	function hidediv() {
		document.getElementById("bg").style.display = 'none';
		document.getElementById("show").style.display = 'none';
	}
</script>
<script language="javascript">
	function agree() {
		if (document.getElementById('cb').checked)
			document.getElementById('tj').disabled = false;
		else
			document.getElementById('tj').disabled = 'disabled';
	}
</script>
<style type="text/css">
#bg {
	display: none;
	position: absolute;
	top: 0%;
	left: 0%;
	width: 100%;
	height: 100%;
	background-color: black;
	z-index: 1001;
	-moz-opacity: 0.7;
	opacity: .70;
	filter: alpha(opacity = 70);
}

#show {
	display: none;
	position: absolute;
	top: 25%;
	left: 22%;
	width: 53%;
	height: 49%;
	padding: 8px;
	border: 8px solid #E8E9F7;
	background-color: white;
	z-index: 1002;
	overflow: auto;
}
</style>
</head>
>
<body>
	<div class="container text-right" style="margin-bottom: 0">
		<%=currentUser.equals("") ? "<a href='" + context + "/jsp/login.jsp'>登录</a>" : currentUser %>&nbsp;&nbsp;
		<a href="<%=context %>/jsp/user/register.jsp">注册</a>&nbsp;&nbsp; <a
			href="<%=context %>/login?forward=logout">注销</a>
	</div>
	<div class="container">
		<div class="header clearfix">
			<nav class="navbar">
				<ul class="nav nav-pills pull-right socials">
					<li role="presentation" ><a href="#">首页</a></li>
					<li role="presentation"><a href="#">交易中心</a></li>
					<li role="presentation"><a
						href="<%=context %>/jsp/news/newsCenter.jsp">资讯中心</a></li>
					<li role="presentation"><a
						href="<%=context %>/jsp/logistics/waybillIndex.jsp">物流中心</a></li>
					<li role="presentation"><a
						href="<%=context %>/jsp/report/reportIndex.jsp">报表中心</a></li>
					<li role="presentation" class="active"><a
						href="<%=context %>/jsp/user/mumberCenter.jsp">会员中心</a></li>
				</ul>
				<h3 class="text-muted">
					<img alt="" src="<%=context%>/imgs/logo.png">
				</h3>
			</nav>
		</div>
	</div>


	<div class="span4" align="center">
		<h2>广告位申请</h2>
		<div class="main-center">
			<form role="form" action="/gdce/ads?forward=addAdvertisement" method="post">
				<div class="form-group">
					<label for="exampleInputEmail1">
						<div align="left">
							<p>
								企业机构代码 <input name="companyId" type="text" class="form-control"
									id="name" />
							</p>
							<p>
								申请位置 <select name="position">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
								</select>
							</p>
						</div>
						<p align="left">
							投放时间 <input type="date" name="releaseDate"> 至<input
								type="date" name="endDate">
						</p>
						<p align="left">
							邮箱 <input name="email" type="email" class="form-control"
								id="email" />
						</p>
						<p align="left">
							广告内容文件 <input name="adsImgPath" type="file" id="exampleInputFile" />
						</p>
						<p align="left">
							广告链接地址 <input name="adsURL" type="text" class="form-control"
								id="lianjie" />
						</p>
						<p align="left">
							<span align="center" class="checkbox"> <input
								name="checkbox" type="checkbox" /></span>我已经仔细 <input name="button"
								type="button" id="btnshow" onclick="showdiv();" value="阅读广告收费规则" />
						</p>
						<p align="left">
							备注<input name="note" type="text" />
						<p align="left">
							<button type="submit">提交</button>
						</p>
					</label>
				</div>
			</form>
		</div>
	</div>


	<div id="bg"></div>
	<div id="show">
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span12">
					<div class="page-header">
						<h1 align="center">广告投放规则</h1>
					</div>
					<table class="table">
						<thead>
							<tr>
								<th>广告位</th>
								<th>价格（月）</th>
								<th>规格说明（px）</th>
								<th>有无空位</th>
							</tr>
						</thead>
						<tbody>

							<tr class="success">
								<td>1</td>
								<td>4000</td>
								<td>600*200</td>
								<td>有</td>
							</tr>
							<tr class="error">
								<td>2</td>
								<td>2000</td>
								<td>600*100</td>
								<td>有</td>
							</tr>
							<tr class="warning">
								<td>3</td>
								<td>2000</td>
								<td>600*100</td>
								<td>有</td>
							</tr>
							<tr class="info">
								<td>4</td>
								<td>1600</td>
								<td>1200*120</td>
								<td>有</td>
							</tr>
						</tbody>
					</table>
					<h3 class="text-muted">
						<img alt="logo" src="<%=context%>/imgs/ad/ad.PNG">
					</h3>

					<p align="left">
						1、以上每个广告位限一个链接地址，1个月(30天)起租。所有广告明码标价，谢绝还价；<br />
						2、刊登广告的网站必须同时被Baidu，Google，Yahoo.cn收录2条以上；<br />
						3、不接受违法、色情、赌博、中奖、彩票及放置木马类站点的广告；不接弹窗、插件类和捆绑类广告；<br />
						4、广告不提供试放，不承诺多少次点击；<br />
						5、所有投放广告，一律先付款后上广告，未到期不能更换广告位，每月可更换文字、图片或链接一次，广告位租出后3天内可以申请退换，扣除总金额20%运营成本费用；<br />
						6、广告文字或图片必须通过我们的审核才可投放（如文件大小以及图片质量），广告图片如为FLASH格式请勿带声音特效、鼠标移过自动弹窗特效和内嵌代码，图片颜色变化频率不能过快，以免影响浏览者视觉；<br />
						7、已经刊登的广告如有虚假，或者有人举报有欺骗等违法行为，广告商没办法做出有效答复或解释的，或者在广告期间网站无法正常访问的，本站保留立即去掉广告的权利并不给予退款；<br />
						8、广告租出期间，广告链接的目标网站不符合2、3款条件的，本站无条件拿下广告；<br />
						9、广告到期时自动删除广告链接，我们不主动追问广告投放者是否续租广告；<br /> 10、如您需要增加其它广告位可联系我们商议。<br />
					</p>

					<div align="center">
						<input id="btnclose" type="button" value="已阅读"
							onclick="hidediv();" />
					</div>
				</div>
				<div class="span4"></div>
			</div>
		</div>
	</div>
	</div>
</body>
</html>