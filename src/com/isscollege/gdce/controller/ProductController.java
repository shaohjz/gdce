package com.isscollege.gdce.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.isscollege.gdce.dao.impl.ProductDaoImpl;
import com.isscollege.gdce.domain.Product;
import com.isscollege.gdce.domain.User;
import com.isscollege.gdce.model.ITradeModel;
import com.isscollege.gdce.model.impl.ProductModelImpl;
import com.isscollege.gdce.model.impl.TradeModelImpl;

@WebServlet("/product")
public class ProductController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 子功能分发
	private ProductModelImpl model;
	private ITradeModel detailModel;
	String forward = "";

	public ProductController() {
		model = new ProductModelImpl();
		detailModel = new TradeModelImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		forward = request.getParameter("forward");
		if (StringUtils.equalsIgnoreCase(forward, "query")) {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("currentUser");
			List<Product> getproductList = (List<Product>) model.getResult();
			List<Product> productList = new ArrayList<Product>();
			for (Product product : getproductList) {
				if (product.getUserName().equals(user.getName())) {
					productList.add(product);
				}
			}
			session.setAttribute("productList", productList);
			request.getRequestDispatcher("/jsp/product/managing.jsp").forward(request, response);
		} else if (StringUtils.equalsIgnoreCase(forward, "update")) {
			request.setCharacterEncoding("utf-8");
			HttpSession session = request.getSession();
			String productType = request.getParameter("productType");
			productType = new String(productType.getBytes("iso-8859-1"), "utf-8");

			String destAddress = request.getParameter("destAddress");
			destAddress = new String(destAddress.getBytes("iso-8859-1"), "utf-8");

			String srcAddress = request.getParameter("srcAddress");
			srcAddress = new String(srcAddress.getBytes("iso-8859-1"), "utf-8");

			String transactionMode = request.getParameter("transactionMode");
			transactionMode = new String(transactionMode.getBytes("iso-8859-1"), "utf-8");

			Float price = Float.valueOf(request.getParameter("price"));
			Float quantity = Float.valueOf(request.getParameter("quantity"));
			int lowPower = Integer.valueOf(request.getParameter("lowPower"));
			Float volatiles = Float.valueOf(request.getParameter("volatiles"));
			Float fullMoisture = Float.valueOf(request.getParameter("fullMoisture"));
			Float fullSulfur = Float.valueOf(request.getParameter("fullSulfur"));
			String endDate = request.getParameter("endDate");
			String remark = request.getParameter("remark");
			int id = (int) session.getAttribute("id");

			Product product = new Product();

			product.setProductState(1);
			product.setReviewState(0);
			product.setProductType(productType);
			product.setDestAddress(destAddress);
			product.setSrcAddress(srcAddress);
			product.setTransactionMode(transactionMode);
			product.setPrice(price);
			product.setQuantity(quantity);
			product.setLowPower(lowPower);
			product.setVolatiles(volatiles);
			product.setFullMoisture(fullMoisture);
			product.setFullSulfur(fullSulfur);
			product.setEndDate(endDate);
			product.setRemark(remark);
			product.setId(id);

			model.updateProduct(product);
			request.getRequestDispatcher("/jsp/user/mumberCenter.jsp").forward(request, response);

		} else if (StringUtils.equalsIgnoreCase(forward, "productId")) {

			request.setCharacterEncoding("UTF-8");
			int productId = NumberUtils.toInt(request.getParameter("productId"));

			List<Product> productList = detailModel.getProductInfo(productId);

			Object phoneNumber = detailModel.getPhoneNumber(productId);
			HttpSession sessionProduct = request.getSession();
			HttpSession sessionPhoneNumber = request.getSession();
			sessionProduct.setAttribute("product", productList.get(0));
			sessionPhoneNumber.setAttribute("phoneNumber", phoneNumber);
			request.getRequestDispatcher("/jsp/product/detailProduct.jsp").forward(request, response);
		} else if (StringUtils.equalsIgnoreCase(forward, "insert")) {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");

			Product product = new Product();
			HttpSession session = request.getSession();

			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
			String createDate = dateformat.format(System.currentTimeMillis());
			String productType = (String) request.getParameter("productType");
			productType = new String(productType.getBytes("iso-8859-1"), "utf-8");
			String srcAddress = (String) request.getParameter("srcAddress");
			srcAddress = new String(srcAddress.getBytes("iso-8859-1"), "utf-8");
			String destAddress = (String) request.getParameter("destAddress");
			destAddress = new String(destAddress.getBytes("iso-8859-1"), "utf-8");
			String endDate = (String) request.getParameter("endDate");
			String transactionMode = (String) request.getParameter("transactionMode");
			transactionMode = new String(transactionMode.getBytes("iso-8859-1"), "utf-8");
			String remark = (String) request.getParameter("remark");
			remark = new String(remark.getBytes("iso-8859-1"), "utf-8");
			float price = Float.valueOf((String) request.getParameter("price"));
			float quantity = Float.valueOf((String) request.getParameter("quantity"));
			float fullMoisture = Float.valueOf((String) request.getParameter("fullMoisture"));
			float fullSulfur = Float.valueOf((String) request.getParameter("fullSulfur"));
			float volatiles = Float.valueOf((String) request.getParameter("volatiles"));
			int lowPower = Integer.parseInt((String) request.getParameter("lowPower"));
			int reviewState = 0;
			int productState = 1;

			User CurrentUser = (User) session.getAttribute("currentUser");
			product.setUserName(CurrentUser.getName());
			product.setCreateDate(createDate);
			product.setProductId(ProductIdUtil.getProductId());
			product.setProductType(productType);
			product.setDestAddress(destAddress);
			product.setSrcAddress(srcAddress);
			product.setEndDate(endDate);
			product.setTransactionMode(transactionMode);
			product.setRemark(remark);
			product.setPrice(price);
			product.setQuantity(quantity);
			product.setFullMoisture(fullMoisture);
			product.setFullSulfur(fullSulfur);
			product.setVolatiles(volatiles);
			product.setLowPower(lowPower);
			product.setProductState(productState);
			product.setReviewState(reviewState);
			/**
			 * 存储数据入数据库
			 */
			model.insertProduct(product);
			request.getRequestDispatcher("/jsp/user/mumberCenter.jsp").forward(request, response);
		}

	}

}

class ProductIdUtil {

	private static int productId = 1;

	public static synchronized int getProductId() {

		return productId++;
	}

}
