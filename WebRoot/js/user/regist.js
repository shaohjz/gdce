$(function() {
	/*
	 * 1. 得到所有的错误信息，循环遍历之。调用一个方法来确定是否显示错误信息！
	 */
	$(".errorClass").each(function() {
		showError($(this));//遍历每个元素，使用每个元素来调用showError方法
	});
	
	/*
	 * 2. 切换注册按钮的图片
	 */
	$("#submitBtn").hover(
		function() {
			$("#submitBtn").attr("src", "<%=request.getContextPath()%>/imgs/regist2.jpg");
		},
		function() {
			$("#submitBtn").attr("src", "<%=request.getContextPath()%>/imgs/regist1.jpg");
		}
	);
	
	/*
	 * 3. 输入框得到焦点隐藏错误信息
	 */
	$(".inputClass").focus(function() {
		var labelId = $(this).attr("id") + "Error";//通过输入框找到对应的label的id
		$("#" + labelId).text("");//把label的内容清空！
		showError($("#" + labelId));//隐藏没有信息的label
	});
	
	/*
	 * 4. 输入框失去焦点进行校验
	 */
	$(".inputClass").blur(function() {
		var id = $(this).attr("id");//获取当前输入框的id
		var funName = "validate" + id.substring(0,1).toUpperCase() + id.substring(1) + "()";//得到对应的校验函数名
		eval(funName);//执行函数调用
	});
	
	/*
	 * 5. 表单提交时进行校验
	 */
	$("#registForm").submit(function() {
		var bool = true;//表示校验通过
		if(!validateLoginname()) {
			bool = false;
		}
		if(!validateLoginpass()) {
			bool = false;
		}
		if(!validateReloginpass()) {
			bool = false;
		}
		if(!validateEmail()) {
			bool = false;
		}
		if(!validateVerifyCode()) {
			bool = false;
		}
		
		return bool;
	});
});

/*
 * 登录名校验方法
 */
function validateLoginname() {
	var id = "loginname";
	var value = $("#" + id).val();//获取输入框内容
	/*
	 * 1. 非空校验
	 */
	if(!value) {
		/*
		 * 获取对应的label
		 * 添加错误信息
		 * 显示label
		 */
		$("#" + id + "Error").text("用户名不能为空！");
		showError($("#" + id + "Error"));
		return false;
	}
	/*
	 * 2. 长度校验
	 */
	if(value.length < 3 || value.length > 20) {
		/*
		 * 获取对应的label
		 * 添加错误信息
		 * 显示label
		 */
		$("#" + id + "Error").text("用户名长度必须在3 ~ 20之间！");
		showError($("#" + id + "Error"));
		false;
	}
	/*
	 * 3. 是否注册校验
	 
	$.ajax({
		url:"<%=request.getContextPath()  %>/register",//要请求的servlet
		data:{method:"ajaxValidateLoginname", loginname:value},//给服务器的参数
		type:"POST",
		dataType:"json",
		async:false,//是否异步请求，如果是异步，那么不会等服务器返回，我们这个函数就向下运行了。
		cache:false,
		success:function(result) {
			if(!result) {//如果校验失败
				$("#" + id + "Error").text("用户名已被注册！");
				showError($("#" + id + "Error"));
				return false;
			}
		}
	});
	*/
	return true;
	
}

/*
 * 登录密码校验方法
 */
function validateLoginpass() {
	var id = "loginpass";
	var value = $("#" + id).val();//获取输入框内容
	/*
	 * 1. 非空校验
	 */
	if(!value) {
		/*
		 * 获取对应的label
		 * 添加错误信息
		 * 显示label
		 */
		$("#" + id + "Error").text("密码不能为空！");
		showError($("#" + id + "Error"));
		return false;
	}
	/*
	 * 2. 长度校验
	 */
	if(value.length < 3 || value.length > 20) {
		/*
		 * 获取对应的label
		 * 添加错误信息
		 * 显示label
		 */
		$("#" + id + "Error").text("密码长度必须在3 ~ 20之间！");
		showError($("#" + id + "Error"));
		false;
	}
	return true;	
}

/*
 * 确认密码校验方法
 */
function validateReloginpass() {
	var id = "reloginpass";
	var value = $("#" + id).val();//获取输入框内容
	/*
	 * 1. 非空校验
	 */
	if(!value) {
		/*
		 * 获取对应的label
		 * 添加错误信息
		 * 显示label
		 */
		$("#" + id + "Error").text("确认密码不能为空！");
		showError($("#" + id + "Error"));
		return false;
	}
	/*
	 * 2. 两次输入是否一致校验
	 */
	if(value != $("#loginpass").val()) {
		/*
		 * 获取对应的label
		 * 添加错误信息
		 * 显示label
		 */
		$("#" + id + "Error").text("两次输入不一致！");
		showError($("#" + id + "Error"));
		false;
	}
	return true;	
}



/*
 * 企业机构代码校验
 */
function validateCompanyId() {
	var id = "companyId";
	var value = $("#" + id).val();//获取输入框内容
	/*
	 * 1. 非空校验
	 */
	if(!value) {
		/*
		 * 获取对应的label
		 * 添加错误信息
		 * 显示label
		 */
		$("#" + id + "Error").text("机构代码不能为空！");
		showError($("#" + id + "Error"));
		return false;
	}
	/*
	 * 2. 长度校验
	 */
	if(value.length != 18) {
		/*
		 * 获取对应的label
		 * 添加错误信息
		 * 显示label
		 */
		$("#" + id + "Error").text("机构代码长度必须为18位！");
		showError($("#" + id + "Error"));
		false;
	}
	return true;	
}


/*
 * 企业名称校验
 */
function validateCompanyName() {
	var id = "companyName";
	var value = $("#" + id).val();//获取输入框内容
	/*
	 * 1. 非空校验
	 */
	if(!value) {
		/*
		 * 获取对应的label
		 * 添加错误信息
		 * 显示label
		 */
		$("#" + id + "Error").text("企业名称不能为空！");
		showError($("#" + id + "Error"));
		return false;
	}
	/*
	 * 2. 长度校验
	 */
	if(value.length < 3 || value.length > 20) {
		/*
		 * 获取对应的label
		 * 添加错误信息
		 * 显示label
		 */
		$("#" + id + "Error").text("企业名称长度必须在3 ~ 20之间！");
		showError($("#" + id + "Error"));
		false;
	}
	return true;	
}

/*
 * 法人校验
 */
function validateLegalPerson() {
	var id = "legalPerson";
	var value = $("#" + id).val();//获取输入框内容
	/*
	 * 1. 非空校验
	 */
	if(!value) {
		/*
		 * 获取对应的label
		 * 添加错误信息
		 * 显示label
		 */
		$("#" + id + "Error").text("法人不能为空！");
		showError($("#" + id + "Error"));
		return false;
	}
	/*
	 * 2. 长度校验
	 */
	if(value.length < 2 || value.length > 10) {
		/*
		 * 获取对应的label
		 * 添加错误信息
		 * 显示label
		 */
		$("#" + id + "Error").text("法人长度必须在2 ~ 10之间！");
		showError($("#" + id + "Error"));
		false;
	}
	return true;	
}

/*
 * 联系方式校验
 */
function validatePhoneNumber() {
	var id = "phoneNumber";
	var value = $("#" + id).val();//获取输入框内容
	/*
	 * 1. 非空校验
	 */
	if(value) {
		/*
		 * 2. 长度校验
		 */
		if(value.length != 11) {
			/*
			 * 获取对应的label
			 * 添加错误信息
			 * 显示label
			 */
			$("#" + id + "Error").text("联系方式必须为11位手机号！");
			showError($("#" + id + "Error"));
			false;
		}
		
	}
	
	return true;	
}

/*
 * 银行账户校验
 */
function validateBankAccount() {
	var id = "bankAccount";
	var value = $("#" + id).val();//获取输入框内容
	/*
	 * 1. 非空校验
	 */
	if(value) {
		/*
		 * 2. 长度校验
		 */
		if(value.length < 18 || value.length > 21) {
			/*
			 * 获取对应的label
			 * 添加错误信息
			 * 显示label
			 */
			$("#" + id + "Error").text("银行账号长度必须在18 ~ 21之间！");
			showError($("#" + id + "Error"));
			false;
		}
		
	}
	
	return true;	
}

/*
 * 营业执照校验
 */
function validateOpenLicenseId() {
	var id = "openLicenseId";
	var value = $("#" + id).val();//获取输入框内容
	/*
	 * 1. 非空校验
	 */
	if(value) {
		/*
		 * 2. 长度校验
		 */
		if(value.length != 13) {
			/*
			 * 获取对应的label
			 * 添加错误信息
			 * 显示label
			 */
			$("#" + id + "Error").text("营业执照长度必须为13位！");
			showError($("#" + id + "Error"));
			false;
		}
		
	}
	
	return true;	
}

/*
 * 税务登记号校验
 */
function validateTaxRegisterId() {
	var id = "taxRegisterId";
	var value = $("#" + id).val();//获取输入框内容
	/*
	 * 1. 非空校验
	 */
	if(value) {
		/*
		 * 2. 长度校验
		 */
		if(value.length < 15 || value.length > 20) {
			/*
			 * 获取对应的label
			 * 添加错误信息
			 * 显示label
			 */
			$("#" + id + "Error").text("税务登记号长度长度必须在15 ~ 20之间！");
			showError($("#" + id + "Error"));
			false;
		}
		
	}
	
	return true;	
}
/*
 * Email校验方法
 */
function validateEmail() {
	var id = "email";
	var value = $("#" + id).val();//获取输入框内容
	/*
	 * 1. 非空校验
	 */
	if(!value) {
		/*
		 * 获取对应的label
		 * 添加错误信息
		 * 显示label
		 */
		$("#" + id + "Error").text("Email不能为空！");
		showError($("#" + id + "Error"));
		return false;
	}
	/*
	 * 2. Email格式校验
	 */
	if(!/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/.test(value)) {
		/*
		 * 获取对应的label
		 * 添加错误信息
		 * 显示label
		 */
		$("#" + id + "Error").text("错误的Email格式！");
		showError($("#" + id + "Error"));
		false;
	}
	/*
	 * 3. 是否注册校验
	 
	$.ajax({
		url:"<%=request.getContextPath()  %>/register",//要请求的servlet
		data:{method:"ajaxValidateEmail", email:value},//给服务器的参数
		type:"POST",
		dataType:"json",
		async:false,//是否异步请求，如果是异步，那么不会等服务器返回，我们这个函数就向下运行了。
		cache:false,
		success:function(result) {
			if(!result) {//如果校验失败
				$("#" + id + "Error").text("Email已被注册！");
				showError($("#" + id + "Error"));
				return false;
			}
		}
	});
	*/	
	return true;
		
}

/*
 * 验证码校验方法
 */
function validateVerifyCode() {
	var id = "verifyCode";
	var value = $("#" + id).val();//获取输入框内容
	/*
	 * 1. 非空校验
	 */
	if(!value) {
		/*
		 * 获取对应的label
		 * 添加错误信息
		 * 显示label
		 */
		$("#" + id + "Error").text("验证码不能为空！");
		showError($("#" + id + "Error"));
		return false;
	}
	/*
	 * 2. 长度校验
	 */
	if(value.length != 4) {
		/*
		 * 获取对应的label
		 * 添加错误信息
		 * 显示label
		 */
		$("#" + id + "Error").text("错误的验证码！");
		showError($("#" + id + "Error"));
		false;
	}
	/*
	 * 3. 是否正确
	 
	$.ajax({
		url:"<%=request.getContextPath()  %>/register",//要请求的servlet
		data:{method:"ajaxValidateVerifyCode", verifyCode:value},//给服务器的参数
		type:"POST",
		dataType:"json",
		async:false,//是否异步请求，如果是异步，那么不会等服务器返回，我们这个函数就向下运行了。
		cache:false,
		success:function(result) {
			if(!result) {//如果校验失败
				$("#" + id + "Error").text("验证码错误！");
				showError($("#" + id + "Error"));
				return false;
			}
		}
		
	});
	*/
	return true;		
}

/*
 * 判断当前元素是否存在内容，如果存在显示，不存在不显示！
 */
function showError(ele) {
	var text = ele.text();//获取元素的内容
	if(!text) {//如果没有内容
		ele.css("display", "none");//隐藏元素
	} else {//如果有内容
		ele.css("display", "");//显示元素
	}
}

/*
 * 换一张验证码
 */
function _hyz() {
	/*
	 * 1. 获取<img>元素
	 * 2. 重新设置它的src
	 * 3. 使用毫秒来添加参数
	 */
	$("#imgVerifyCode").attr("src", "/gdce/verifyCode?a=" + new Date().getTime());
}
