package com.isscollege.gdce.controller;

import com.isscollege.gdce.model.impl.ProductModelImpl;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.isscollege.gdce.domain.Product;
import com.isscollege.gdce.domain.User;

@WebServlet("/index.jsp")
public class IndexPageController extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public IndexPageController()
	{
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String url = "/jsp/index.jsp";
		User user = (User) session.getAttribute("currentUser");
		if (user != null)
		{
			if (user.getLevel() == 0 || user.getLevel() == 1)
			{
				url = "/jsp/review/review.jsp";
			}
		}
		ProductModelImpl productModel = new ProductModelImpl();

		List<Product> productList = (List<Product>) productModel.getResult();
		request.setAttribute("productList", productList);
		request.getRequestDispatcher(url).forward(request, response);
	}
}
