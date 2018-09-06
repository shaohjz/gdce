package com.isscollege.gdce.common.listener;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.isscollege.gdce.domain.User;
import com.isscollege.gdce.model.ILoginModel;
import com.isscollege.gdce.model.impl.LoginModelImpl;

/**
 * Application Lifecycle Listener implementation class sesssionListener
 *
 */
@WebListener
public class SesssionListener implements HttpSessionListener {

	
	public void sessionCreated(HttpSessionEvent se) {

		HttpSession session = se.getSession();
		session.setMaxInactiveInterval(1800);
		System.out.println("listener创建！，并设置session的过期时间为，测试阶段设置为10s，实际运行中需要设置为30min");

	}

	
	public void sessionDestroyed(HttpSessionEvent se) {

		HttpSession session = se.getSession();
		System.out.println("listener销毁,sessionid ：" + session.getId());

		User user = session.getAttribute("currentUser") == null ? new User() : (User) session.getAttribute("currentUser");
		user.setLoginState(false);//
		
		System.out.println("listener 是否得到user name？" + user.getName());
		
		final ILoginModel model = new LoginModelImpl();
		
		boolean loginState = model.logout(user);

		System.out.println("listener session-name" + user.getName());
		System.out.println("listener 修改是否成功" + loginState);
		System.out.println("HttpSession 被销毁");

	}

	
}
