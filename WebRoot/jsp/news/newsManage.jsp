<%@ page pageEncoding="UTF-8" import="java.util.*"
	import="com.isscollege.gdce.domain.User"
	import="java.util.List,com.isscollege.gdce.domain.News"%>
<%@ include file="/jsp/header.jsp"%>
<%@ page import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<script>
			$(function(){
				var pageNumber = '${pageShow}';
				if(pageNumber == null || pageNumber=="")
				{
					$('#myTab a:first').tab('show');	
				}
				else
				{
					if(pageNumber =="news")
					{
						$('#myTab a:last').tab('show');	
					}
					else
					{
						$('#myTab a:first').tab('show');
					}	
				}
			});
			
			function goNewsReview()
			{
				window.location.href("<%=context%>/review?forward=newsReview");
			}
			
			function successReview(newsInfoId)
			{
				window.location.href("<%=context%>/review?forward=newsAuditPass&id="+newsInfoId);
			}
			
			function failReview(newsInfoId)
			{
				window.location.href("<%=context%>/review?forward=newsFailAuditPass&id="
							+ newsInfoId);
		}
	</script>
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
										class="btn btn-default" type="button"
										onClick="showReport2()">审核</button></a>
							</div>
							<div class="panel-body" align="center">
								<a href="<%=context%>/news?forward=adminPageBean&&type=hgzc&&currentPage=1"" target="_self">
									<button style="width: 90px; height: 40px"
										class="btn btn-default btn-primary" type="button" onClick="showReport2()">资讯管理
									</button>
								</a>
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
						<a href="<%=request.getContextPath()%>/news?forward=adminPageBean&&type=hgzc&&currentPage=1"><input  type="button" value="宏观政策"></a>
						<a href="<%=request.getContextPath()%>/news?forward=adminPageBean&&type=scfx&&currentPage=1"><input  type="button" value="市场分析"></a>
						<a href="<%=request.getContextPath()%>/news?forward=adminPageBean&&type=dlhy&&currentPage=1"><input  type="button" value="电力行业"></a>
						<a href="<%=request.getContextPath()%>/news?forward=adminPageBean&&type=mtjg&&currentPage=1"><input  type="button" value="煤炭价格"></a>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="<%=context%>/jsp/news/newsEdit.jsp" align="right"><input  type="button" value="新增资讯"></a>
						 
						<table class="table" id="adminNews">
							<caption></caption>
							<thead>
								<tr class="info">
									<th>资讯编号</th>
									<th>资讯标题</th>
									<th>资讯作者</th>
									<th>创建时间</th>
									<th>审核状态</th>
									<th>编辑</th>
								</tr>
								<% int i=1;%>
							<c:forEach var="news" items="${pageBean.newsList}">
								<tr>
									<td><img src="<%=request.getContextPath() %>/imgs/news/<%=i++%>.png" alt="1" />&nbsp;&nbsp;</td>	
									<td><a href="<%=context%>/news?forward=newsDisplay&&title=${news.title}">${news.title}</a></td>
									<td>${news.name}</td>
									<td>${news.createDate}</td>
									<c:if test="${news.reviewState==0}">
										<td>待审核</td>
										<td>编辑</td>
									</c:if>
									<c:if test="${news.reviewState==2}">
										<td>未通过</td>
										<td><a href="<%=context %>/news?forward=getNewsByTitle&&title=${news.title}">编辑</a></td>
									</c:if>
									<c:if test="${news.reviewState==1}">
										<td>审核通过</td>
										<td><a href="<%=context %>/news?forward=getNewsByTitle&&title=${news.title}">编辑</a></td>
									</c:if>
								</tr>
							</c:forEach>
							
			
						</table>
							<div style="text-align: center" id="paging">
								<ul class="pagination">
									<c:if test="${pageBean.currentPage==1 }">
										 <li class="disabled"><a href="javaScript:void(0);">&laquo;</a></li>							
									</c:if>
									<c:if test="${pageBean.currentPage!=1 }">
									  <li><a href="<%=context%>/news?forward=adminPageBean&&type=<%=request.getParameter("type")%>&&currentPage=${pageBean.currentPage-1}">&laquo;</a></li>
									</c:if>
								
								<c:forEach begin="1" end="${pageBean.totalPage }" var="page">
										<!-- 判断当前页 -->
									<c:if test="${pageBean.currentPage==page }">
										<li class="active"><a href="javascript:void(0);">${page}</a></li>
									</c:if>
									<c:if test="${pageBean.currentPage!=page }">
										<li><a href="<%=context%>/news?forward=adminPageBean&&type=<%=request.getParameter("type")%>&&currentPage=${page}">${page}</a></li>
									</c:if>
								
								</c:forEach>
								
								<c:if test="${pageBean.currentPage==pageBean.totalPage}">
									<li class="disabled"><a href="javaScript:void(0);">&raquo;</a></li>				
								</c:if>
								<c:if test="${pageBean.currentPage!=pageBean.totalPage}">
								  <li><a href="<%=context%>/news?forward=adminPageBean&&type=<%=request.getParameter("type")%>&&currentPage=${pageBean.currentPage+1}">&raquo;</a></li>
								</c:if>
							</ul>
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