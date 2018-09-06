<%@ page pageEncoding="UTF-8" import="java.util.*" %>
<%@ include file="/jsp/header.jsp" %>
<%@page import="com.isscollege.gdce.domain.Contract"%>
<style type="text/css">

.form-horizontal {
	background: #FFFFFF;
	padding-bottom: 40px;
	padding-left: 40px;
	padding-top: 40px;
	border-radius: 15px;
	}	
.left {
        float: left;
        width: 300px;
        height: 30px;
        background-color: #D9EDF7;
        margin-right:20px;
        margin-left:40px;
        margin-bottom:20px;
        padding-left:5px;
        padding-top:5px;
        padding-right:5px;
        padding-bottom:5px;
        border-radius: 15px;
      }	
</style>
<body>
<div class="container text-right" style="margin-bottom:0">
        <%=currentUser.equals("") ? "<a href='" + context + "/jsp/user/login.jsp'>登录</a>" : currentUser %>&nbsp;&nbsp;
        <%=currentUser.equals("") ? "<a href='" + context + "/jsp/user/register.jsp'>注册</a>" : "" %>&nbsp;&nbsp;
        <a href="<%=context %>/login?forward=logout">退出</a>
    </div>   
    <div class="container">
      <div class="header clearfix">
        <nav class="navbar">
          <ul class="nav nav-pills pull-right socials">
            <li role="presentation"><a href="<%=context%>/index.jsp">首页</a></li>
            <li role="presentation"><a href="#">交易中心</a></li>
            <li role="presentation"><a href="<%=context %>/jsp/news/newsCenter.jsp">资讯中心</a></li>
            <li role="presentation"><a href="<%=context %>/jsp/trade/reportIndex.jsp">报表中心</a></li>
            <li role="presentation"  class="active"><a href="<%=context %>/jsp/user/mumberCenter.jsp">会员中心</a></li>
          </ul>
          <h3 class="text-muted"><img alt="" src="<%=context %>/imgs/logo.png"></h3>
        </nav>        
      </div>
     </div>
     <div class="container">
      <div class="header clearfix">
        <nav class="navbar">
        <div style="padding-left:40px;padding-right:60px"><div style="background-color:#D9EDF7;height:45px;padding:10px;"><p>合同信息:</p></div></div>	
				<div style="margin-top:18px"> 
					<div class=left>
						<a style="padding-left:8px;" class="form-a">甲方： ${sessionScope.contract.buyerCompanyId}</a></div>
						<div  class=left><a  style="padding-left:8px;">乙方： ${sessionScope.contract.sellerCompanyId}</a></div>
						<div  class=left><a style="padding-left:8px;">商品编号： ${sessionScope.contract.productId}</a>
					</div>
					<br>
					<div class=left><a style="padding-left:8px;">卖家状态：未确认</a>	</div>
					<div class=left><a style="padding-left:8px;">卖家状态：未确认</a>	</div><br></div>
        </nav>
        <div><a style="margin-left:50px;margin-right:30px" href = "<%=context%>/contract?forward=InsertContract"><button type="button" class="btn btn-default">确认</button></a>
					<a href = "<%=context%>/contract?forward=UpdateProductState"><button type="button" class="btn btn-default">取消</button></a></div>        
      </div>

     <div style="margin-bottom:20%;"></div>
     </div>


<div class="jumbotron text-center" style="margin-bottom:0">
  <p><h5><a href="">客服中心</a>|<a href="">联系我们</a><br><br>
     网站版权归中国国电集团公司所有 京ICP备 05053479号-2 |京公网安备110102005596号-1<br>
地址：北京市昌平区未来科技城 邮编：102209 电话：400-020-8000（非工作时间：15011089832）、010-56978755 传真： 010-56978760<br>
                                                     电子邮箱：fuel@powerec.net</h5></p>
</div>
</body>
</html>