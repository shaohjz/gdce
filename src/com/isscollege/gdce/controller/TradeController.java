package com.isscollege.gdce.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.isscollege.gdce.domain.Contract;
import com.isscollege.gdce.domain.Product;
import com.isscollege.gdce.domain.User;
import com.isscollege.gdce.model.ILoginModel;
import com.isscollege.gdce.model.ITradeModel;
import com.isscollege.gdce.model.impl.LoginModelImpl;
import com.isscollege.gdce.model.impl.TradeModelImpl;

@WebServlet("/trade")
public class TradeController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private ITradeModel model;
	// 子功能分发
	private String forward = "";

	public TradeController()
	{
		model = new TradeModelImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		forward = request.getParameter("forward");
		if (StringUtils.equalsIgnoreCase(forward, "productId"))
		{
			request.setCharacterEncoding("UTF-8");
			int productId = NumberUtils.toInt(request.getParameter("productId"));
			List<Product> productList = model.getProductInfo(productId);
			Object phoneNumber = model.getPhoneNumber(productId);
			HttpSession sessionProduct = request.getSession();
			HttpSession sessionPhoneNumber = request.getSession();
			sessionProduct.setAttribute("product", productList.get(0));
			sessionPhoneNumber.setAttribute("phoneNumber", phoneNumber);
			request.getRequestDispatcher("/jsp/trade/delist.jsp").forward(request, response);
		} else if (StringUtils.equalsIgnoreCase(forward, "productToContract"))
		{
			request.setCharacterEncoding("UTF-8");
			Contract contract = new Contract();
			HttpSession session = request.getSession();

			Product product = null;
			if (session.getAttribute("product") instanceof Product)
			{
				product = (Product) session.getAttribute("product");
			}

			model.updateProductState(product.getProductId());

			String SellerCompanyId = model.getCompanyIdByName(product.getUserName());
			contract.setSellerCompanyId(SellerCompanyId);

			User CurrentUser = (User) session.getAttribute("currentUser");
			contract.setBuyerCompanyId(CurrentUser.getCompanyId());

			contract.setProductId(product.getProductId());

			session.setAttribute("contract", contract);
			request.getRequestDispatcher("/jsp/contract/contract.jsp").forward(request, response);
		}
	}

}
