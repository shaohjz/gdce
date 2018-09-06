<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/jsp/header.jsp"%>
<%@page import="java.util.List" import="com.isscollege.gdce.domain.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		User cuser = null;
		cuser = (User) request.getSession().getAttribute("currentUser");
		if (cuser == null || cuser.getLevel() != 0)
		{
			response.sendRedirect(request.getContextPath() + "/jsp/review/review.jsp");
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
								<a href="<%=context%>/review?forward=productReview"
									target="_self"><button style="width: 90px; height: 40px"
										class="btn btn-default " type="button" onClick="showReport2()">审核</button></a>
							</div>
							<div class="panel-body" align="center">
								<a
									href="<%=context%>/news?forward=adminPageBean&&type=hgzc&&currentPage=1"
									target="_self"><button style="width: 90px; height: 40px"
										class="btn btn-default" type="button" onClick="showReport2()">资讯管理</button></a>
							</div>
							<div class="panel-body" align="center">
								<%
									if (cuser.getLevel() == 0)
									{
								%>
								<a
									href="<%=request.getContextPath()%>/register?forward=QUERYMANAGER"
									target="_self">
									<button style="width: 90px; height: 40px"
										class="btn btn-default btn-primary" type="button"
										onClick="showReport1()">二级管理员</button>
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
								<!-- 审核主界面 -->
								<h1 align="left" class='page-header STYLE7'>
									<span class="label label-primary"><strong>二级管理员管理</strong></span>
								</h1>

								<ul class='nav nav-tabs' id="myTab">
									<li class='active STYLE5'><a href='#query'
										onclick="goQuery()" class="STYLE5" data-toggle='tab'>所有管理员</a></li>
									<li><a href='#add' onclick="goAdd()" class="STYLE5"
										data-toggle='tab'>添加新管理员</a></li>
								</ul>
								<div class='tab-content'>
									<div class='tab-pane active' id='query'>
										<div class="container">
											<div class="row clearfix">
												<table class="table">
													<thead>
														<tr>
															<th>ID</th>
															<th>Name</th>
															<th>Password</th>
															<th>Level</th>
															<th>Permission</th>
															<th>Delete</th>
														</tr>
													</thead>
													<tbody>
														<%
															List<User> users = (List<User>) request.getAttribute("users");
															if (users != null && users.size() > 0)
															{
																for (User user : users)
																{
														%>
														<tr>
															<td><%=user.getId()%></td>
															<td><%=user.getName()%></td>
															<td><%=user.getPassword()%></td>
															<td><%=user.getLevel()%></td>
															<td><%=user.getPermission()%></td>
															<td><a
																href="<%=request.getContextPath()%>/register?id=<%=user.getId()%>&forward=DELETEMANAGER">Delete</a></td>
														</tr>
														<%
															}
															}
														%>
													</tbody>
												</table>
											</div>
										</div>
									</div>
									<div class='tab-pane' id='add'>
										<form action="<%=request.getContextPath()%>/register"
											method="post">
											<table align="center"
												style="border-collapse: separate; border-spacing: 0px 10px;">
												<tr>
													<td><input type="hidden" name="forward"
														value="ADDMANAGER"></td>
												</tr>
												<tr>
													<td>用户名：</td>
													<td><input type="text" name="name"></td>
												</tr>
												<tr>
													<td>密码：</td>
													<td><input type="text" name="password"></td>
												</tr>
												<tr>
													<td><input type="checkbox" name="permission" value="1">权限1：审核</td>
													<td><input type="checkbox" name="permission" value="5">权限2：资讯</td>
												</tr>
												<tr>
													<td><input type="submit" value="创建"></td>
												</tr>
											</table>
										</form>
									</div>
								</div>
							</div>
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