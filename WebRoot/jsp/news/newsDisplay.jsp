<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.isscollege.gdce.domain.News"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/jsp/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

		<title>资讯显示页面</title>
		
		<style type="text/css">
			a{
				text-decoration: none;
			}
			
			a:hover{
				text-decoration: underline;
			}
			
			li:not(.special){
				float: left;
				list-style: none;
			}
			
			#father{
				border-collapse: collapse;
				border: 0px solid red;
				width: 100%;
				height: auto;
			}
			
			#guide{
				border-collapse: collapse;
				border: 0px solid blue;
				margin: 0 auto;
				width: 995px;
				height: 62px;
			}
			
			.top{
				border-collapse: collapse;
				border: 0px solid yellow;
				width: 50%;
				height: 100%;
				float: left;
			}
			
			#top{
				border-collapse: collapse;
				text-align: center;
				padding-top: 17px;
				width: 493px;
				height: 45px;
			}
			
			#picture{
				border-collapse: collapse;
				border: 0px solid black;
				margin: 0 auto;
				width: 995px;
				height: auto;
			}
			
			#biaoqian{
				border-collapse: collapse;
				border: 0px solid gray;
				width: 995px;
				height: 45px;
				margin: auto;
				margin-top: 20px;
			}
			
			#nei{
				border-collapse: collapse;
				border: 0px solid gray;
				margin-top: 15px;
				font-size: 15px;
			}
			
			#text_title{
				border-collapse: collapse;
				border: 0px solid gray;
				width: 995px;
				height: 50px;
				font-family: "微软雅黑", "黑体";
				margin: auto;
				text-align: center;
			}
			
			.msgbar {
			    line-height: 30px;
			    text-align: center;
			    color: #999;
			    font-size: 15px;
			}
			
			#text{
				border-collapse: collapse;
				border: 0px solid gray;
				width: 995px;
				height: 600px;
				margin: auto;
			}
			
			.pagebar {
    			height: 30px;
    		    line-height: 30px;
    			text-align: center;
			}
			
			#next{
				border-collapse: collapse;
				border: 0px solid black;
				width: 995px;
				font-size: 12px;
				margin: auto;
			}
			
			#lianjie{
				border-collapse: collapse;
				border: 0px solid black;
				width: 995px;
				margin-top: 30px;
				margin: auto;
			}
			
			#contact{
				border-collapse: collapse;
				border: 0px solid black;
				background-color: black;
				color: white;
				width: 995px;
				margin: auto;
			}
		</style>
</head>
<body>
	<div id="father">
		<div class="container">
			<div class="header clearfix">
	        	<nav class="navbar">
	         		<h3 class="text-muted"><img alt="" src="<%=context %>/imgs/logo.png"></h3>
	        	</nav>        
			</div>
			
			
			<div id="biaoqian">
				<div id="nei">
	        	当前位置：<a href="<%=request.getContextPath()%>/index.jsp" style="white-space: nowrap;">首页</a>  
	        	> <a href="<%=request.getContextPath()%>/news?forward=findPageBean&&type=hgzc&&currentPage=1" class="lili-a">资讯中心</a>
	        	> <a href="<%=request.getContextPath()%>/news?forward=findPageBean&&type=${news.type}&&currentPage=1" >${type}</a>
	        	> 正文
	        	</div>
       		</div>
       		
       		<div id="text_title">
       			<h1>${news.title}</h1>
       		</div>

			<div class="msgbar">
				<span>发布时间：${news.createDate}</span>
				<span>作者：${news.name}</span>
			</div>
			
			<div id="text">
				${news.content}
			</div>
			
			<div class="pagebar"></div>
			
			<div id="next">
				<ul>
					<li class="special"><strong>上一篇：</strong><a href="#">xxxxxx</a></li>
					<li class="special"><strong>下一篇：</strong><a href="#">xxxxxx</a></li>
				</ul>
			</div>
			
			<div id="lianjie">
				
				<a href="#"><p>友情链接</p></a>
				
				<a href="#"><span>中国国电集团</span></a> 
				<a href="#"><span>郑州商品交易所</span></a> 
				<a href="#"><span>中国煤炭市场网</span></a> 
				<a href="#"><span>上海煤炭交易中心</span></a> 
				<a href="#"><span>神华煤炭交易网</span></a> 
				<a href="#"><span>伊泰集团</span></a>
				<a href="#"><span>中国煤炭资源网</span></a> 
				<a href="#"><span>太原煤炭交易中心</span></a>
				<a href="#"><span>秦皇岛煤炭网</span></a> 
				<a href="#"><span>神华集团</span></a> 
				<a href="#"><span>内蒙古煤炭交易中心</span></a>
				<a href="#"><span>中煤集团</span></a> 
				<a href="#"><span>中国海事服务网</span></a> 
				<a href="#"><span>同煤集团</span></a> 
				<a href="#"><span>上海航运交易所</span></a> 

			</div>
			
			<div class="jumbotron text-center" style="margin-bottom:0">
		  <p><h5><a href="">客服中心</a>|<a href="">联系我们</a><br><br>
		     	网站版权归中国国电集团公司所有 京ICP备 05053479号-2 |京公网安备110102005596号-1<br>
			地址：北京市昌平区未来科技城 邮编：102209 电话：400-020-8000（非工作时间：15011089832）、010-56978755 传真： 010-56978760<br>
		                                                     电子邮箱：fuel@powerec.net</h5></p>
		</div>
		</div>

</body>
</html>