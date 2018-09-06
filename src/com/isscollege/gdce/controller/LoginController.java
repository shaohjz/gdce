package com.isscollege.gdce.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import com.isscollege.gdce.domain.User;
import com.isscollege.gdce.model.ILoginModel;
import com.isscollege.gdce.model.impl.LoginModelImpl;

@WebServlet("/login")

public class LoginController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private static final String usestate1 = "login";
	private static final String usestate2 = "logout";
	private ILoginModel model = null;

	public LoginController()
	{
		model = new LoginModelImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String usestate = request.getParameter("forward");
		if (usestate1.equalsIgnoreCase(usestate))
		{
			doLogin(request, response);

		} else if (usestate2.equalsIgnoreCase(usestate))
		{
			doLoginout(request, response);

		}
	}

	protected void doLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		String name = StringUtils.defaultString(request.getParameter("name"));
		String password = StringUtils.defaultString(request.getParameter("password"));

		Map<String, String> loginForm = new HashMap<String, String>();
		loginForm.put("loginname", name);
		loginForm.put("loginpass", password);
		request.setAttribute("loginForm", loginForm);

		HttpSession session = request.getSession();
		// String verifyCode = request.getParameter("verifyCode");
		// String vCode = (String) session.getAttribute("vCode");
		// boolean isRemember =
		// BooleanUtils.toBoolean(request.getParameter("isRemember"));

		User user = new User();//
		user.setName(name);//
		user.setPassword(password);//
		user.setLoginState(true);//

		Map<String, String> errors = validateLogin(request, request.getSession());
		if (errors.size() > 0)
		{
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("/jsp/user/login.jsp").forward(request, response);
			return;
		}

		User loginUser = model.login(user);
		System.out.println("Session Time: " + session.getMaxInactiveInterval() + "Is New: " + session.isNew());
		session.setAttribute("currentUser", loginUser);
		if (loginUser.getLevel() == 0)
		{
			request.getRequestDispatcher("/review?forward=productReview").forward(request, response);
		} else if (loginUser.getLevel() == 1)
		{
			request.getRequestDispatcher("/review?forward=productReview").forward(request, response);
		} else
		{
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}

	}

	protected void doLoginout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		// String name =
		// StringUtils.defaultString(request.getParameter("name"));
		// String password =
		// StringUtils.defaultString(request.getParameter("password"));
		boolean isRemember = BooleanUtils.toBoolean(request.getParameter("isRemember"));

		HttpSession session = request.getSession();
		String url = request.getContextPath() + "/index.jsp";
		session.invalidate();
		response.sendRedirect(url);

	}

	private Map<String, String> validateLogin(HttpServletRequest req, HttpSession session)
			throws ServletException, IOException
	{
		Map<String, String> errors = new HashMap<String, String>();

		/*
		 * 1. 校验登录名
		 */
		String loginname = StringUtils.defaultString(req.getParameter("name"));
		if (loginname == null || loginname.trim().isEmpty())
		{
			errors.put("loginname", "户名不能为空！");
		} else if (!model.ajaxValidateLoginname(loginname))
		{
			errors.put("loginname", "用户名不存在！");
		}

		/*
		 * 2. 校验登录密码
		 */
		String loginpass = StringUtils.defaultString(req.getParameter("password"));
		if (loginpass == null || loginpass.trim().isEmpty())
		{
			errors.put("loginpass", "密码不能为空！");
		} else if (!model.ajaxValidateLoginpassword(loginname, loginpass))
		{
			errors.put("loginpass", "密码不正确！");
		}

		/*
		 * 3. 验证码校验
		 */
		String verifyCode = StringUtils.defaultString(req.getParameter("verifyCode"));
		String vcode = (String) session.getAttribute("vCode");
		if (verifyCode == null || verifyCode.trim().isEmpty())
		{
			errors.put("verifyCode", "验证码不能为空！");
		} else if (!verifyCode.equalsIgnoreCase(vcode))
		{
			errors.put("verifyCode", "验证码错误！");
		}

		System.out.println("--->");
		return errors;

	}

}
