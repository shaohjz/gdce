<%@ page pageEncoding="UTF-8" isELIgnored="false" import="com.isscollege.gdce.domain.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <meta http-equiv="X-UA-Compatible" content="IE=edge">
     <meta name="viewport" content="width=device-width, initial-scale=1"> 
      
     <% 
         //全局寄存工程根目录
         String context = request.getContextPath();
         //其他页面通过设置title来改变页面标题
         String title = "国电煤炭交易平台";
         String currentUser = "";
         String permission  = "";
         if(request.getSession().getAttribute("currentUser") != null)
         {
        	 User user = (User)request.getSession().getAttribute("currentUser");
        	 currentUser = user.getName();
        	 permission = user.getPermission();
         }        
     %>
     <title><%=title %></title>
     
    
     <link href="<%=context %>/js/bootstrap/css/bootstrap.min1.css" rel="stylesheet"> 
     <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
     
     <script src="<%=context %>/js/bootstrap/html5shiv.min.js"></script>
     <script src="<%=context %>/js/bootstrap/respond.min.js"></script>   
    
     <script type="text/javascript" src="<%=context %>/js/jquery/jquery.min.js"></script>
     <script type="text/javascript" src="<%=context %>/js/bootstrap/bootstrap.min.js"></script>
      
     <style>
       body{
           padding-top:10px;
       }
       .socials {
           padding: 30px;
       }
     </style>   
</head>