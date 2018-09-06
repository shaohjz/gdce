<%@ page pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/jsp/header.jsp" %>	
<script type="text/javascript" src="<%=context %>/js/user/regist.js"></script>
<link rel="stylesheet" type="text/css" href="<%=context %>/js/user/regist.css">


  <body>
  <div class="container text-right" style="margin-bottom:0">
         <%=currentUser.equals("") ? "已有账号？<a href='" + context + "/jsp/user/login.jsp'>立即登录</a>" : currentUser %>&nbsp;&nbsp;
    </div>   
    <div class="container">
      <div class="header clearfix">
        <nav class="navbar">
          <ul class="nav nav-pills pull-right socials">
          	<li role="presentation"><a href="<%=context%>/index.jsp">首页</a></li>
		  	<li role="presentation"><a href="<%=context%>/jsp/product/productsList.jsp">交易中心</a></li>
		  	<li role="presentation"><a
						href="<%=request.getContextPath()%>/news?forward=findPageBean&&type=hgzc&&currentPage=1">资讯中心</a></li>
			<li role="presentation"><a href="<%=context%>/register?forward=qualification">会员中心</a></li>
          </ul>
          <h3 class="text-muted"><img alt="" src="<%=context %>/imgs/logo.png" width="200" height="80"></h3>
        </nav>        
      </div>
     </div>
     
<div id="divMain">
  <div id="divTitle" >
    <span id="spanTitle">新用户注册</span>
  </div>
  <div id="divBody">
  	<form action="<%=context %>/register" method="post" name="registForm" >
  	 <input type="hidden" name="forward"  value="regist" />
		<table >
      <tr>
        <td class="tdText">用户名*：</td>
        <td class="tdInput">
          <input class="inputClass" type="text" name="loginname" id="loginname" value="${requestScope.form.loginname}"/>
        </td>
        <td class="tdError">
          <label class="errorClass" id="loginnameError">${requestScope.errors.loginname}</label>
        </td>
      </tr>
      
      <tr>
        <td class="tdText">登录密码*：</td>
        <td class="tdInput">
          <input class="inputClass" type="password" name="loginpass" id="loginpass" value="${requestScope.form.loginpass}"/>
        </td>
        <td class="tdError">
          <label class="errorClass" id="loginpassError">${requestScope.errors.loginpass }</label>
        </td>
      </tr>
      
      <tr>
        <td class="tdText">确认密码*：</td>
        <td class="tdInput">
          <input class="inputClass" type="password" name="reloginpass" id="reloginpass" value="${requestScope.form.reloginpass}"/>
        </td>
        <td class="tdError">
          <label class="errorClass" id="reloginpassError">${requestScope.errors.reloginpass}</label>
        </td>
      </tr>
      
      <tr>
        <td class="tdText">企业机构代码*：</td>
        <td class="tdInput">
          <input class="inputClass" type="text" name="companyId" id="companyId" value="${requestScope.form.companyId}"/>
        </td>
        <td class="tdError">
          <label class="errorClass" id="companyIdError">${requestScope.errors.companyId}</label>
        </td>
      </tr>
      
      <tr>
      <td class="tdText">用户类型*：</td>
      <td >
      	<input type="radio" name="permission" id="permission" value="2" checked="checked"/>采购方 &nbsp;&nbsp;&nbsp;
      	<input type="radio" name="permission" id="permission" value="3" />供应商&nbsp;&nbsp;&nbsp;
      	<input type="radio" name="permission" id="permission" value="4" />物流&nbsp;&nbsp;&nbsp;
      </td>
      </tr>
      
      
      <tr>
        <td class="tdText">企业名称*：</td>
        <td class="tdInput">
          <input class="inputClass" type="text" name="companyName" id="companyName" value="${requestScope.form.companyName}"/>
        </td>
        <td class="tdError">
          <label class="errorClass" id="companyNameError">${requestScope.errors.companyName}</label>
        </td>
      </tr>
      
      <tr>
        <td class="tdText">法人*：</td>
        <td class="tdInput">
          <input class="inputClass" type="text" name="legalPerson" id="legalPerson" value="${requestScope.form.legalPerson}"/>
        </td>
        <td class="tdError">
          <label class="errorClass" id="legalPersonError">${requestScope.errors.legalPerson }</label>
        </td>
      </tr>
      
      <tr>
        <td class="tdText">联系方式：</td>
        <td class="tdInput">
          <input class="inputClass" type="text" name="phoneNumber" id="phoneNumber" value="${requestScope.form.phoneNumber}"/>
        </td>
        <td class="tdError">
          <label class="errorClass" id="phoneNumberError">${requestScope.errors.phoneNumber}</label>
        </td>
      </tr>
      
      <tr>
        <td class="tdText">银行账户：</td>
        <td class="tdInput">
          <input class="inputClass" type="text" name="bankAccount" id="bankAccount" value="${requestScope.form.bankAccount}"/>
        </td>
        <td class="tdError">
          <label class="errorClass" id="bankAccountError">${requestScope.errors.bankAccount}</label>
        </td>
      </tr>
      
      <tr>
        <td class="tdText">营业执照：</td>
        <td class="tdInput">
          <input class="inputClass" type="text" name="openLicenseId" id="openLicenseId" value="${requestScope.form.openLicenseId}"/>
        </td>
        <td class="tdError">
          <label class="errorClass" id="openLicenseIdError">${requestScope.errors.openLicenseId}</label>
        </td>
      </tr>
 
      <tr>
        <td class="tdText">税务登记号：</td>
        <td class="tdInput">
          <input class="inputClass" type="text" name="taxRegisterId" id="taxRegisterId" value="${requestScope.form.taxRegisterId}"/>
        </td>
        <td class="tdError">
          <label class="errorClass" id="taxRegisterIdError">${requestScope.errors.taxRegisterId}</label>
        </td>
      </tr>
      
	  <tr>
        <td class="tdText">验证码*：</td>
        <td class="tdInput">
          <input class="inputClass" type="text" name="verifyCode" id="verifyCode" value="${requestScope.form.verifyCode }"/>
        </td >
        <td class="tdError">
          <label class="errorClass" id="verifyCodeError">${requestScope.errors.verifyCode}</label>
        </td>
      </tr>
      <tr>
        <td></td>
        <td>
          <div id="divVerifyCode"><img id="imgVerifyCode" src="<c:url value='/verifyCode'/>"/></div>
        </td>
        <td>
          <label><a href="javascript:_hyz()">换一张</a></label>
        </td>
      </tr>
  	
       <tr><td><br><br><br><br></td>
       <td>
       	<label></label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input name="sumit" type="submit" id="sumit" value="提交">
		<label></label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="reset" name="Submit" value="重置">
        <label></label>
        </td>
      </tr>
    </table>
</form>    
  </div>
</div>
  </body>
</html>
