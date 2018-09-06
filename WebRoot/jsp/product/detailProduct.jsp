<%@ page pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ page import="java.sql.*"%>
<meta http-equiv="refresh" content="30">

<!-- 只有卖方能查看报表中心 -->
<script type="text/javascript">
	function judge()
	{
		var pass=<%=permission.equals("3")?1:2 %>
		if(pass==1)
			{
				window.location.href="<%=context %>/jsp/report/reportIndex.jsp";
			}
		else
		{
			$('#modal-container-204152').modal();
		}
		
	}
</script>

<style>
* {
	margin: 0;
	padding: 0;
}

body {
	background-color: white;
}

a:link.uplow {
	color: white;
}

.container.text-right {
	background-color: white;
	margin: auto;
	width: 1004px;;
	height: 50px;
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
	border: 1px solid #EAEAEA;
	background: linear-gradient(to bottom, white, #EAEAEA, #E5E5E5);
}

.locationP {
	margin: auto;
	width: 1004px;
	height: 47px;
}

.midtitle {
	margin: auto;
	margin-top: 20px;
	width: 1004px;
	height: 47px;
	line-height: 47px;
	padding-left: 30px;
	border: 1px solid #EAEAEA;
	background: linear-gradient(to bottom, white, #EAEAEA, #E5E5E5);
	padding-left: 30px;
}

.leftbotton {
	display: inline-block;
	margin-left: 0px;
}

.rightbotton {
	display: inline-block;
	float: right;
}
</style>

<body>

	<div class="modal fade" id="modal-container-204152" role="dialog" aria-hidden="true" aria-labelledby="myModalLabel">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button class="close" aria-hidden="true" type="button" data-dismiss="modal">×</button>
						<h4 class="modal-title" id="myModalLabel">
							错误
						</h4>
				</div>
				<div class="modal-body">
							该功能暂未开放
				</div>
				<div class="modal-footer">
					<button class="btn btn-default" type="button" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>

	<div class="container text-right" style="margin-bottom: 0;">
		<%=currentUser.equals("") ? "<a href='" + context + "/jsp/user/login.jsp'>登录</a>" : currentUser%>&nbsp;&nbsp;
		<a href="<%=context%>/jsp/user/register.jsp">注册</a>&nbsp;&nbsp; <a
			href="<%=context%>/login?forward=logout">注销</a>
	</div>
	<div class="container">
		<div class="header clearfix">
			<nav class="navbar">
				<ul class="nav nav-pills pull-right socials">
					<li role="presentation"><a href="<%=context%>/index.jsp">首页</a></li>
					<li role="presentation"><a>交易中心</a></li>
					<li role="presentation"><a
						href="<%=context%>/jsp/news/newsCenter.jsp">资讯中心</a></li>
					<li role="presentation"><a
						href="<%=context%>/jsp/logistics/waybillIndex.jsp">物流中心</a></li>
					<li role="presentation"><a onClick="judge()"
						href="javascript:judge()">报表中心</a></li>
					<li role="presentation"><a
						href="<%=context%>/jsp/user/mumberCenter.jsp">会员中心</a></li>
				</ul>
				<h3 class="text-muted">
					<img alt="logo" src="<%=context%>/imgs/logo.png">
				</h3>
			</nav>
		</div>
	</div>


	<div class="main">

		<!-- 这里是中间用来分割区域的图片 -->
		<div class="box">
			<img alt="分割图" src="<%=context%>/imgs/trade/banner004.png">
		</div>

		<!-- 这里是显示当前的位置 -->
		<div class="locationD">
			<p class="locationP" style="font-family:宋体">
				<span style="color: #1196EE">当前位置：</span>商品详细信息
			</p>
		</div>

		<!-- 这里显示商品信息 -->
		<div class="midtitle">
			<h4 style="margin-top: 15px; margin-left: -28px;">基本信息</h4>
		</div>

		<div>
			<table class="table" style="font-family:宋体">
				<tbody>
					<tr style="background-color: white">
						<td width="30%"><span>煤种:</span>${sessionScope.product.productType}</td>
						<td width="30%"><span>数量(万吨):</span>${sessionScope.product.quantity}</td>
						<td width="30%"><span>价格(元/吨):</span>${sessionScope.product.price}</td>
					</tr>
					<tr class="success">
						<td><span>全水分:</span>${sessionScope.product.fullMoisture}</td>
						<td><span>全硫份:</span>${sessionScope.product.fullSulfur}</td>
						<td><span>挥发份:</span>${sessionScope.product.volatiles}</td>
					</tr>
					<tr style="background-color: white">
						<td><span>低位发热量（kcal/kg）:</span>${sessionScope.product.lowPower}</td>
						<td><span>产地:</span>${sessionScope.product.srcAddress}</td>
						<td><span>交货地:</span>${sessionScope.product.destAddress}</td>
					</tr>
					<tr class="warning">
						<td><span>交货方式:</span>${sessionScope.product.transactionMode}</td>
						<td><span>联系方式:</span>${sessionScope.phoneNumber}</td>
						<td><span>发布人:</span>${sessionScope.product.userName}</td>
					</tr>
					<tr style="background-color: white">
						<td><span>发布日期:</span>${sessionScope.product.createDate}</td>
						<td><span>截止日期:</span>${sessionScope.product.endDate}</td>
						<td><span>&nbsp;</span>&nbsp;</td>
					</tr>
					<tr class="info">
						<td colspan="3"><span>备注:</span>${sessionScope.product.remark}</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="leftbotton">
			<!--  <a href="<%=context%>/trade?forward=productToContract">测试</a> -->
			
			<script type="text/javascript">
				var productstate;//接受数据库信息
				productstate = ${sessionScope.product.productState};
				var reviewstate;//接受数据库信息
				reviewstate = ${sessionScope.product.reviewState};
				function jump() 
				{
				productstate = ${sessionScope.product.productState};
					if(productstate == 0)
					{
						window.location.href = "<%=context%>/trade?forward=productToContract"
					} else 
					{
						alert("已有人摘牌");
					}

				}

				if (productstate == 0) 
				{
					document.write("<span style='vertical-align:bottom; color:red'>&nbsp;&nbsp;已上架</span>");
				} else if (productstate == 1&&reviewstate==2) 
				{
					
					document.write("<span style='vertical-align:bottom; color:red'>&nbsp;&nbsp;审核未通过</span>");
				} else if(productstate==1&&reviewstate==0)
				{
					
					document.write("<span style='vertical-align:bottom; color:red'>&nbsp;&nbsp;正在审核</span>");
				}
				 else if(productstate==1&&reviewstate==1)
					{
						
						document.write("<span style='vertical-align:bottom; color:red'>&nbsp;&nbsp;已下架</span>");
					}
			</script>
		</div>
		<div >
			<h4><a href="<%=context%>/product?forward=query"> 返回</a></h4>
		</div>
		<br> <br>
	</div>




	<!-- 页面底部 -->
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
