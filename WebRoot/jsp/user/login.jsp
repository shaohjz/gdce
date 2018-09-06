<%@ page pageEncoding="UTF-8" import="com.isscollege.gdce.domain.User"%>
<%@ include file="/jsp/header.jsp"%>
<script type="text/javascript" src="<%=context%>/js/user/regist.js"></script>
<style type="text/css">
body {
	background-color: #778899
}

.form-bg {
	background: #00b4ef;
}

.form-horizontal {
	background: #ffffff;
	padding-bottom: 40px;
	border-radius: 15px;
	text-align: center;
}

.form-horizontal .heading {
	display: block;
	font-size: 35px;
	font-weight: 700;
	padding: 35px 0;
	border-bottom: 1px solid #f0f0f0;
	margin-bottom: 30px;
}

.form-horizontal .form-group {
	padding: 0 40px;
	margin: 0 0 25px 0;
	position: relative;
}

.form-horizontal .form-control {
	background: #f0f0f0;
	border: none;
	border-radius: 20px;
	box-shadow: none;
	padding: 0 20px 0 45px;
	height: 40px;
	transition: all 0.3s ease 0s;
}

.form-horizontal .form-control:focus {
	background: #e0e0e0;
	box-shadow: none;
	outline: 0 none;
}

.form-horizontal .form-group i {
	position: absolute;
	top: 12px;
	left: 60px;
	font-size: 17px;
	color: #c8c8c8;
	transition: all 0.5s ease 0s;
}

.form-horizontal .form-control:focus+i {
	color: #00b4ef;
}

.form-horizontal .fa-question-circle {
	display: inline-block;
	position: absolute;
	top: 12px;
	right: 60px;
	font-size: 20px;
	color: #808080;
	transition: all 0.5s ease 0s;
}

.form-horizontal .fa-question-circle:hover {
	color: #000;
}

.form-horizontal .main-checkbox {
	float: left;
	width: 20px;
	height: 20px;
	background: #11a3fc;
	border-radius: 50%;
	position: relative;
	margin: 5px 0 0 5px;
	border: 1px solid #11a3fc;
}

.form-horizontal .main-checkbox label {
	width: 20px;
	height: 20px;
	position: absolute;
	top: 0;
	left: 0;
	cursor: pointer;
}

.form-horizontal .main-checkbox label:after {
	content: "";
	width: 10px;
	height: 5px;
	position: absolute;
	top: 5px;
	left: 4px;
	border: 3px solid #fff;
	border-top: none;
	border-right: none;
	background: transparent;
	opacity: 0;
	-webkit-transform: rotate(-45deg);
	transform: rotate(-45deg);
}

.form-horizontal .main-checkbox input[type=checkbox] {
	visibility: hidden;
}

.form-horizontal .main-checkbox input[type=checkbox]:checked+label:after
	{
	opacity: 1;
}

.form-horizontal .text {
	float: left;
	margin-left: 7px;
	line-height: 20px;
	padding-top: 5px;
	text-transform: capitalize;
}

.form-horizontal .btn {
	float: right;
	font-size: 14px;
	color: #fff;
	background: #00b4ef;
	border-radius: 30px;
	padding: 10px 25px;
	border: none;
	text-transform: capitalize;
	transition: all 0.5s ease 0s;
}

@media only screen and (max-width: 479px) {
	.form-horizontal .form-group {
		padding: 0 25px;
	}
	.form-horizontal .form-group i {
		left: 45px;
	}
	.form-horizontal .btn {
		padding: 10px 20px;
	}
}

.row {
	margin-top: 70px;
}
</style>
<%
	User user = (User) session.getAttribute("currentUser");
	boolean loginState = user != null ? user.isLoginState() : false;
%>



<body onload="checkLogin()">

	<div class="container">
		<div class="row">
			<div class="col-md-offset-3 col-md-6">
				<form class="form-horizontal" action="<%=context%>/login"
					method="post">
					<input type="hidden" name="forward" value="login" />
					<span class="heading">用户登录</span>
					<div class="form-group">
						<input type="text" class="form-control" id="name" name="name"
							placeholder="用户名" value="${loginForm.loginname}"> <i
							class="fa fa-user"></i>
					</div>

					<h5>
						<font color="red">${requestScope.errors.loginname}</font>
					</h5>

					<div class="form-group help">
						<input type="password" class="form-control" id="password"
							name="password" placeholder="密　码" value="${loginForm.loginpass}">
						<i class="fa fa-lock"></i> <a href="#"
							class="fa fa-question-circle"></a>
					</div>
					<h5>
						<font color="red">${requestScope.errors.loginpass}</font>
					</h5>
					<div style="float: right; width: 350px;">
						验证码:&nbsp;&nbsp;<input type="text"
							style="height: 30px; width: 70px; border: 1px solid #bbb; border-radius: 6px;"
							name="verifyCode" id="verifyCode" />&nbsp;&nbsp; <img
							id="imgVerifyCode" src="<%=context%>/verifyCode" />&nbsp;&nbsp;
						<a href="javascript:_hyz()">换一张</a>
					</div>
					<br> <br>
					
					
					<div class="text-left">
					
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="<%=context%>/jsp/user/register.jsp">注册&nbsp;&nbsp;
					
					<a href="<%=context%>/index.jsp">返回首页</a>&nbsp;&nbsp;
					</div>

					<div style="margin-right: 40px">
					

						<button type="submit" class="btn btn-default">登录</button>

						<h5>
							<font color="red">${requestScope.errors.verifyCode}</font>
						</h5>
					</div>
					<br>
				</form>
			</div>
		</div>
	</div>
</body>
</html>