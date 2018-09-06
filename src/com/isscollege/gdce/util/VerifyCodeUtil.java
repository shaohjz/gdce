package com.isscollege.gdce.util;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.awt.image.BufferedImage;
/**
 * Servlet implementation class VerifyCodeController
 */
@WebServlet("/verifyCode")
public class VerifyCodeUtil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VerifyCode vc = new VerifyCode();
		BufferedImage image = vc.getImage();//��ȡһ������֤��ͼƬ
		// �÷���������getImage()����֮��������
//		System.out.println(vc.getText());//��ȡͼƬ�ϵ��ı�
		VerifyCode.output(image, response.getOutputStream());//��ͼƬд��ָ������
		
		// ���ı����浽session�У�ΪLoginServlet��֤��׼��
		request.getSession().setAttribute("vCode", vc.getText());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}