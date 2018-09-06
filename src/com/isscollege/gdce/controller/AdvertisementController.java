package com.isscollege.gdce.controller;

import java.io.*;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.isscollege.gdce.domain.Advertisement;
import com.isscollege.gdce.model.IAdvertisementModel;
import com.isscollege.gdce.model.impl.AdvertisementModelImpl;

@WebServlet("/ads")
public class AdvertisementController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IAdvertisementModel advertisementModel = null;
    //子功能分发
    private String forward = "";

    public AdvertisementController() {
        advertisementModel = new AdvertisementModelImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        Advertisement advertisement = new Advertisement();
        
		int reviewState = 0;
		reviewState = request.getParameter("reviewState") != null ? Integer.parseInt(request.getParameter("reviewState")+"") : 0;
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
        forward = request.getParameter("forward");
        switch(forward) {
        case "getAdvertisement":
        	try
			{
				List<Advertisement> advertisements = advertisementModel.getAdvertisment(reviewState);
				if(reviewState == 0){
					request.setAttribute("unreviewAdvertisements", advertisements);
				}
				else{
					request.setAttribute("reviewedAdvertisements", advertisements);
				}
				request.getRequestDispatcher("jsp/ad/management.jsp").forward(request, response);
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	break;
        case "addAdvertisement":
        	/**
             * 接收数据
             */
            advertisement.setCompanyId(Integer.parseInt(request.getParameter("companyId")));
            advertisement.setPosition(Integer.parseInt(request.getParameter("position")));
            advertisement.setReleaseDate(request.getParameter("releaseDate"));
            advertisement.setEndDate(request.getParameter("endDate"));
            advertisement.setEmail((String) request.getParameter("email"));
            advertisement.setAdsURL((String) request.getParameter("adsURL"));
            advertisement.setNote((String) request.getParameter("note"));
            advertisement.setReviewState(0);

            advertisementModel.addAdvertisement(advertisement);
            response.sendRedirect(request.getContextPath()+"/jsp/ad/management.jsp");
        	break;
        }
		
        

    }
}
