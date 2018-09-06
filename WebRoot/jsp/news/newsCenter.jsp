<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.isscollege.gdce.domain.News"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/jsp/header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<meta charset="UTF-8">
<title>资讯中心</title>
	<script type="text/javascript">
		function judge()
		{
			var pass=<%=permission.equals("3")?1:2 %>
			if(pass==1)
				{
					window.location.href="<%=context %>/Report";
				}
			else
			{
				$('#modal-container-204152').modal();
			}
		}
	</script>

	<style type="text/css">
			a {
			text-decoration: none;
			}

			a:hover {
			text-decoration: underline;
			}

			#father {
			border-collapse: collapse;
			border: 0px solid red;
			height: auto;
			}

			#guide {
			border-collapse: collapse;
			border: 1px solid blue;
			margin: 0 auto;
			width: 995px;
			height: 62px;
			}

		.top {
			border-collapse: collapse;
			border: 1px solid yellow;
			width: 50%;
			height: 100%;
			float: left;
		}

		#top {
			border-collapse: collapse;
			text-align: center;
			padding-top: 17px;
			width: 493px;
			height: 45px;
		}

		#picture {
			border-collapse: collapse;
			border: 1px solid black;
			margin: 0 auto;
			width: 995px;
			height: auto;
		}

		#layout {
			border-collapse: collapse;
			border: 0px solid blue;
			margin: 0 auto;
			width: 995px;
			height: 500px;
		}

		.littleTitle {
			border-collapse: collapse;
			border: 0px solid black;
			float: left;
			width: 25%;
			text-align: center;
		}

		#special {
			border-collapse: collapse;
			border: 0px solid black;
			float: left;
			width: 240px;
		}

		.four {
			width: 995px;
			height: 100px text-align: center;
			background-image: s margin: auto;
		}
	</style>
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

	<div id="father">
		<div class="container">
			
			<div class="header clearfix">
				<nav class="navbar">
				<ul class="nav nav-pills pull-right socials">
					<li role="presentation"><a
						href="<%=request.getContextPath()%>/jsp/index.jsp">首页</a></li>
					<li role="presentation"><a href="#">交易中心</a></li>
					<li role="presentation" class="active"><a
						href="<%=request.getContextPath()%>/news?forward=findPageBean&&type=hgzc&&currentPage=1">资讯中心</a></li>
					<li role="presentation"><a href="javascript:judge()">报表中心</a></li>
					<li role="presentation"><a
						href="<%=context %>/jsp/user/mumberCenter.jsp">会员中心</a></li>
				</ul>
				<h3 class="text-muted">
					<img alt="" src="<%=context %>/imgs/logo.png">
				</h3>
				</nav>
			</div>

			<div id="picture">
				<img src="<%=request.getContextPath() %>/imgs/news/banner004.png"
					alt="banner004" />
			</div>

			<div id="layout">

				<div class="four">
					<nav class="navbar">
					<ul class="nav nav-pills pull-right socials">

						<li role="presentation"><a
							href="<%=request.getContextPath()%>/news?forward=findPageBean&&type=hgzc&&currentPage=1">宏观政策</a></li>
						<li role="presentation"><a
							href="<%=request.getContextPath()%>/news?forward=findPageBean&&type=scfx&&currentPage=1">市场分析</a></li>
						<li role="presentation"><a
							href="<%=request.getContextPath()%>/news?forward=findPageBean&&type=dlhy&&currentPage=1">电力行业</a></li>
						<li role="presentation"><a
							href="<%=request.getContextPath()%>/news?forward=findPageBean&&type=mtjg&&currentPage=1">煤炭价格</a></li>
						<li role="presentation"><a
							href="<%=context %>/jsp/trade/reportIndex.jsp"></a></li>
						<li role="presentation"><a
							href="<%=context %>/jsp/user/mumberCenter.jsp"></a></li>
						<li role="presentation"><a href="#"></a></li>
					</ul>
					</nav>
				</div>

				<div>
					<table class="table" id="NewsTable">
						<caption></caption>
						<thead>
							<tr class="info" >
								<th>资讯编号</th>
								<th width="60%" style="text-align: center">资讯标题</th>
								<th>资讯作者</th>
								<th>创建时间</th>
							</tr>
							<% int i=1;%>
							<c:forEach var="news" items="${pageBean.newsList}">
								<tr>
									<td><img
										src="<%=request.getContextPath() %>/imgs/news/<%=i++%>.png"
										alt="1" />&nbsp;&nbsp;</td>
									<td width="500px" align="center"><a
										href="<%=context%>/news?forward=newsDisplay&&title=${news.title}&&type=${news.type}">${news.title}</a></td>
									<td>${news.name}</td>
									<td>${news.createDate}</td>

								</tr>
							</c:forEach>
					</table>
				</div>
				<!-- 分页按钮 -->
				<div style="text-align: center" id="paging">
					<ul class="pagination">
						
						<c:if test="${pageBean.currentPage==1 }">
							<li class="disabled"><a href="javaScript:void(0);">&laquo;</a></li>
						</c:if>
						
						<c:if test="${pageBean.currentPage!=1 }">
							<li><a
								href="<%=context%>/news?forward=findPageBean&&type=<%=request.getParameter("type")%>&&currentPage=${pageBean.currentPage-1}">&laquo;</a></li>
						</c:if>

						<c:forEach begin="1" end="${pageBean.totalPage }" var="page">
							<!-- 判断当前页 -->
							<c:if test="${pageBean.currentPage==page }">
								<li class="active"><a href="javascript:void(0);">${page}</a></li>
							</c:if>
							
							<c:if test="${pageBean.currentPage!=page }">
								<li><a
									href="<%=context%>/news?forward=findPageBean&&type=<%=request.getParameter("type")%>&&currentPage=${page}">${page}</a></li>
							</c:if>

						</c:forEach>

						<c:if test="${pageBean.currentPage==pageBean.totalPage}">
							<li class="disabled"><a href="javaScript:void(0);">&raquo;</a></li>
						</c:if>
						
						<c:if test="${pageBean.currentPage!=pageBean.totalPage}">
							<li><a
								href="<%=context%>/news?forward=findPageBean&&type=<%=request.getParameter("type")%>&&currentPage=${pageBean.currentPage+1}">&raquo;</a></li>
						</c:if>
						
					</ul>
				</div>
			
				<div class="jumbotron text-center" style="margin-bottom: 0">
					<p>
					<h5>
						<a href="">客服中心</a>|<a href="">联系我们</a><br>
						<br> 网站版权归中国国电集团公司所有 京ICP备 05053479号-2 |京公网安备110102005596号-1<br>
						地址：北京市昌平区未来科技城 邮编：102209
						电话：400-020-8000（非工作时间：15011089832）、010-56978755 传真： 010-56978760<br>
						电子邮箱：fuel@powerec.net
					</h5>
					</p>
				</div>


				<div id="contact"></div>
			</div>
			<h4></h4>
</body>
</html>
