package com.isscollege.gdce.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.isscollege.gdce.domain.CoalSalesReport;
import com.isscollege.gdce.model.IReportModel;
import com.isscollege.gdce.model.impl.ReportModelImpl;


@WebServlet("/Report")
public class ReportController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private String forward = "";
	private IReportModel model;

	public ReportController()
	{
		model = new ReportModelImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		request.setCharacterEncoding("UTF-8");
		HttpSession sessionReport = request.getSession();

		List<CoalSalesReport> reportone = null;
		String month1 = "2018-1-%";
		reportone = model.getReportInfo(month1);
		sessionReport.setAttribute("reportone", reportone);

		List<CoalSalesReport> reporttwo = null;
		String month2 = "2018-2-%";
		reporttwo = model.getReportInfo(month2);
		sessionReport.setAttribute("reporttwo", reporttwo);

		List<CoalSalesReport> reportthree = null;
		String month3 = "2018-3-%";
		reportthree = model.getReportInfo(month3);
		sessionReport.setAttribute("reportthree", reportthree);

		List<CoalSalesReport> reportfour = null;
		String month4 = "2018-4-%";
		reportfour = model.getReportInfo(month4);
		sessionReport.setAttribute("reportfour", reportfour);

		List<CoalSalesReport> reportfive = null;
		String month5 = "2018-5-%";
		reportfive = model.getReportInfo(month5);
		sessionReport.setAttribute("reportfive", reportfive);

		List<CoalSalesReport> reportsix = null;
		String month6 = "2018-6-%";
		reportsix = model.getReportInfo(month6);
		sessionReport.setAttribute("reportsix", reportsix);

		List<CoalSalesReport> reportseven = null;
		String month7 = "2018-7-%";
		reportseven = model.getReportInfo(month7);
		sessionReport.setAttribute("reportseven", reportseven);

		List<CoalSalesReport> reporteight = null;
		String month8 = "2018-8-%";
		reporteight = model.getReportInfo(month8);
		sessionReport.setAttribute("reporteight", reporteight);

		List<CoalSalesReport> reportnine = null;
		String month9 = "2018-9-%";
		reportnine = model.getReportInfo(month9);
		sessionReport.setAttribute("reportnine", reportnine);

		List<CoalSalesReport> reportten = null;
		String month10 = "2018-10-%";
		reportten = model.getReportInfo(month10);
		sessionReport.setAttribute("reportten", reportten);

		List<CoalSalesReport> reportele = null;
		String month11 = "2018-11-%";
		reportele = model.getReportInfo(month11);
		sessionReport.setAttribute("reportele", reportele);

		List<CoalSalesReport> reporttev = null;
		String month12 = "2018-12-%";
		reporttev = model.getReportInfo(month12);
		sessionReport.setAttribute("reporttev", reporttev);
		request.getRequestDispatcher("/jsp/report/reportIndex.jsp").forward(request, response);

	}

}
