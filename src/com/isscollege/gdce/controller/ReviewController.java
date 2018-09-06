package com.isscollege.gdce.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isscollege.gdce.domain.Advertisement;
import com.isscollege.gdce.domain.Company;
import com.isscollege.gdce.domain.News;
import com.isscollege.gdce.domain.Product;
import com.isscollege.gdce.model.IReviewModel;
import com.isscollege.gdce.model.impl.ReviewModelImpl;

@WebServlet("/review")
public class ReviewController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private IReviewModel reviewModel;

	public ReviewController()
	{
		reviewModel = new ReviewModelImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String forward = request.getParameter("forward");
		int page = 1, size = 15;
		if (forward == null)
		{
			forward = "productReview";
			page = request.getAttribute("page") != null ? (Integer) request.getAttribute("page") : 1;
			size = 15;
		}

		request.setAttribute("curPage", forward);

		switch (forward)
		{
		case "productReview":
			dealProduct(forward, page, size, request, response);
			break;
		case "companyReview":
			dealCompany(forward, page, size, request, response);
			break;
		case "advertisementReview":
			dealAdvertisement(forward, page, size, request, response);
			break;
		case "newsReview":
			dealNews(forward, page, size, request, response);
			break;
		case "changePro":
			dealProduct(forward, page, size, request, response);
			break;
		case "changeCom":
			dealCompany(forward, page, size, request, response);
			break;
		case "changeAdv":
			dealAdvertisement(forward, page, size, request, response);
			break;
		case "changeNew":
			dealNews(forward, page, size, request, response);
			break;
		}
	}

	private void dealProduct(String forward, int page, int size, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		if (forward.equals("productReview"))
		{
			if (request.getParameter("page") != null)
			{
				page = Integer.parseInt(request.getParameter("page"));
			}
			request.setAttribute("page", page);
			try
			{
				List<Product> products = reviewModel.queryProductByReviewState((page - 1) * 15, size);
				if (products.size() == 0 && page != 1)
				{
					page--;
					request.setAttribute("page", page);
					products = reviewModel.queryProductByReviewState((page - 1) * 15, size);

				}
				if (request.getAttribute("totalPage") == null)
				{
					int totalSize = reviewModel.queryProductByReviewState(0, 10000).size();
					request.setAttribute("totalPage", totalSize % 15 == 0 ? totalSize / 15 : totalSize / 15 + 1);
				}
				request.setAttribute("products", products);
				request.setAttribute("pageShow", "product");
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
			request.getRequestDispatcher("jsp/review/review.jsp").forward(request, response);
		} else if (forward.equals("changePro"))
		{
			try
			{
				reviewModel.updateProductReviewState(Integer.parseInt(request.getParameter("productId")),
						Integer.parseInt(request.getParameter("state")));
				response.sendRedirect("review?forward=productReview&page=" + request.getParameter("page"));
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

	private void dealCompany(String forward, int page, int size, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		if (forward.equals("companyReview"))
		{
			if (request.getParameter("page") != null)
			{
				page = Integer.parseInt(request.getParameter("page"));
			}
			request.setAttribute("page", page);
			try
			{
				List<Company> companys = reviewModel.queryCompanyByReviewState((page - 1) * 15, size);
				if (companys.size() == 0 && page != 1)
				{
					page--;
					request.setAttribute("page", page);
					companys = reviewModel.queryCompanyByReviewState((page - 1) * 15, size);

				}
				if (request.getAttribute("totalPage") == null)
				{
					int totalSize = reviewModel.queryCompanyByReviewState(0, 10000).size();
					request.setAttribute("totalPage", totalSize % 15 == 0 ? totalSize / 15 : totalSize / 15 + 1);
				}
				request.setAttribute("companys", companys);
				request.setAttribute("pageShow", "company");
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
			request.getRequestDispatcher("jsp/review/review.jsp").forward(request, response);
		} else if (forward.equals("changeCom"))
		{
			try
			{
				reviewModel.updateCompanyReviewState(Integer.parseInt(request.getParameter("companyId")),
						Integer.parseInt(request.getParameter("state")));
				response.sendRedirect("review?forward=companyReview&page=" + request.getParameter("page"));
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

	private void dealAdvertisement(String forward, int page, int size, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		if (forward.equals("advertisementReview"))
		{
			if (request.getParameter("page") != null)
			{
				page = Integer.parseInt(request.getParameter("page"));
			}
			request.setAttribute("page", page);
			try
			{
				List<Advertisement> advertisements = reviewModel.queryAdvertisementByReviewState((page - 1) * 15, size);
				if (advertisements.size() == 0 && page != 1)
				{
					page--;
					request.setAttribute("page", page);
					advertisements = reviewModel.queryAdvertisementByReviewState((page - 1) * 15, size);

				}
				if (request.getAttribute("totalPage") == null)
				{
					int totalSize = reviewModel.queryAdvertisementByReviewState(0, 10000).size();
					request.setAttribute("totalPage", totalSize % 15 == 0 ? totalSize / 15 : totalSize / 15 + 1);
				}
				request.setAttribute("advertisements", advertisements);
				request.setAttribute("pageShow", "advertisement");
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
			request.getRequestDispatcher("jsp/review/review.jsp").forward(request, response);
		} else if (forward.equals("changeAdv"))
		{
			try
			{
				reviewModel.updateAdvertisementReviewState(Integer.parseInt(request.getParameter("adId")),
						Integer.parseInt(request.getParameter("state")));
				response.sendRedirect("review?forward=advertisementReview&page=" + request.getParameter("page"));
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

	private void dealNews(String forward, int page, int size, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		if (forward.equals("newsReview"))
		{
			if (request.getParameter("page") != null)
			{
				page = Integer.parseInt(request.getParameter("page"));
			}
			request.setAttribute("page", page);
			try
			{
				List<News> newss = reviewModel.queryNewsByReviewState((page - 1) * 15, size);
				if (newss.size() == 0 && page != 1)
				{
					page--;
					request.setAttribute("page", page);
					newss = reviewModel.queryNewsByReviewState((page - 1) * 15, size);

				}
				if (request.getAttribute("totalPage") == null)
				{
					int totalSize = reviewModel.queryNewsByReviewState(0, 10000).size();
					request.setAttribute("totalPage", totalSize % 15 == 0 ? totalSize / 15 : totalSize / 15 + 1);
				}
				request.setAttribute("newss", newss);
				request.setAttribute("pageShow", "news");
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
			request.getRequestDispatcher("jsp/review/review.jsp").forward(request, response);
		} else if (forward.equals("changeNew"))
		{
			try
			{
				reviewModel.updateNewsReviewState(Integer.parseInt(request.getParameter("newsId")),
						Integer.parseInt(request.getParameter("state")));
				response.sendRedirect("review?forward=newsReview&page=" + request.getParameter("page"));
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
}
