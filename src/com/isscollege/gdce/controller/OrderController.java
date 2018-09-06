package com.isscollege.gdce.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import javax.xml.ws.http.HTTPBinding;

import org.apache.commons.lang3.StringUtils;

import com.isscollege.gdce.domain.Company;
import com.isscollege.gdce.domain.Contract;
import com.isscollege.gdce.domain.LogisticsPrice;
import com.isscollege.gdce.domain.Order;
import com.isscollege.gdce.domain.Product;
import com.isscollege.gdce.domain.User;
import com.isscollege.gdce.domain.WaybillInfo;
import com.isscollege.gdce.model.IOrderModel;
import com.isscollege.gdce.model.impl.OrderModelImpl;
import com.isscollege.gdce.service.impl.LogisticsServiceImpl;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.ServletInputStream;

@WebServlet("/order")
public class OrderController extends HttpServlet
{

	private static final long serialVersionUID = 1L;

	// �ӹ��ַܷ�
	private String forward = "";
	private IOrderModel model;
	private static final String UPLOAD_DIR = "imgs/order/receipt/";
	private static final String ORDER_CREATE = "orderCreate";
	private static final String UPLOAD_IMG = "uploadImg";
	private String resultMessage;

	public OrderController()
	{
		model = new OrderModelImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// ������ѯ����
		Map<Integer, String> orderState = new HashMap<>();
		orderState.put(0, "������");
		orderState.put(1, "������");
		orderState.put(2, "���ջ�");
		orderState.put(3, "������");
		orderState.put(4, "���");
		forward = request.getParameter("forward");

		// ���forward������ֵΪdetail�����붩�������ѯ
		if (forward.equals("detail"))
		{
			detail(request, response, orderState);
		}
		// ���forward������ֵΪquery,���붩����ѯҳ
		if (forward.equals("query"))
		{
			query(request, response, orderState);
		}
		// ���forward����ֵΪqueryAppointedOrder�����ѯָ������
		if (forward.equals("queryAppointedOrder"))
		{
			queryAppointedOrder(request, response, orderState);
		}
		if (StringUtils.equalsIgnoreCase(forward, UPLOAD_IMG))
		{
			uploadImg(request, response);
		}
		if (StringUtils.equalsIgnoreCase(forward, ORDER_CREATE))
		{
			orderCreate(request, response);
		}
		if (forward.equals("CreateWayBill"))
		{
			wayBill(request, response);
		}
	}

	private void orderCreate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		int Random = (int) ((Math.random() * 9 + 1) * 1000);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String createDate = df.format(new Date());// ���ɶ���ʱ��
		Calendar ca = Calendar.getInstance();
		ca.add(Calendar.DATE, 15);
		String endDate = df.format(ca.getTime());// �޲���ʱ�����Զ�����ʱ��
		HttpSession session = request.getSession();
		Contract contract = (Contract) session.getAttribute("contract");// ��ȡ��ͬ�鴫���ĺ�ͬ����
		String orderId = new SimpleDateFormat("yyyyMMddHHmm").format(new Date()) + Random;// ���ɶ������
		int productId = (int) contract.getProductId(); // ��ȡ��Ʒ���
		String buyerCompanyId = contract.getBuyerCompanyId();// ��ȡ�����ҵ���
		String sellerCompanyId = contract.getSellerCompanyId();
		// //��ȡ������ҵ���
		Product product = model.queryProduct(productId);// ������Ʒ��������ݿ���ѯ��ȡ��Ӧ����Ʒ��Ϣ
		Company BuyerCompany = model.queryCompany(buyerCompanyId);// ������ұ�������ݿ���ѯ��ȡ��Ӧ�������Ϣ
		Company SellerCompany = model.queryCompany(sellerCompanyId);// �������ұ�������ݿ���ѯ��ȡ��Ӧ��������Ϣ
		float tradePrice = product.getPrice() * product.getQuantity();// ���ɽ����ܽ��

		System.out.println("Session Time: " + session.getMaxInactiveInterval() + "Is New: " + session.isNew());
		Order order = new Order();
		order.setOrderId(orderId);
		order.setTradePrice(tradePrice);
		order.setProductId(productId);
		order.setBuyerCompanyId(buyerCompanyId);
		order.setSellerCompanyId(sellerCompanyId);
		order.setOrderState(0);
		order.setReceiptPath(" ");
		order.setCreateDate(createDate);
		order.setEndDate(endDate);
		Boolean state = model.orderCreate(order);
		if (state)
		{
			session.setAttribute("order", order);
			session.setAttribute("product", product);
			session.setAttribute("buyerCompany", BuyerCompany);
			session.setAttribute("sellerCompany", SellerCompany);
			request.getRequestDispatcher("/jsp/order/orderCreation.jsp").forward(request, response);
		} else
		{
			String resultMessages = "��������ʧ��";
			request.setAttribute("result", resultMessages);
			request.getRequestDispatcher("/jsp/result.jsp").forward(request, response);
		}
	}

	// ��ѯ��ǰ�û�ȫ������
	private void query(HttpServletRequest request, HttpServletResponse response, Map<Integer, String> orderState)
			throws ServletException, IOException
	{
		User user = (User) request.getSession().getAttribute("currentUser");
		int page = Integer.parseInt(request.getParameter("page"));
		List<Order> orderList = model.queryOrderOnPage((page - 1) * 8, user.getPermission(), user.getCompanyId());
		List<Order> orderListAll = model.queryOrderAll("20", user.getPermission(), user.getCompanyId());
		int totalPages = orderListAll.size() % 8 == 0 ? orderListAll.size() / 8 : orderListAll.size() / 8 + 1;
		String[] orderStateArray = new String[8];
		boolean hasResult = false;
		boolean isAppointed = false;

		if (orderList.size() > 0)
		{
			hasResult = true;
			int i = 0;
			for (Order o : orderList)
			{
				orderStateArray[i] = orderState.get(o.getOrderState());
				i++;
			}
		}
		request.setAttribute("orderStateArray", orderStateArray);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("page", page);
		request.setAttribute("orderList", orderList);
		request.setAttribute("hasResult", hasResult);
		request.setAttribute("isAppointed", isAppointed);
		request.getRequestDispatcher("/jsp/order/orderQuery.jsp").forward(request, response);
	}

	// ��ѯ��������
	private void detail(HttpServletRequest request, HttpServletResponse response, Map<Integer, String> orderState)
			throws ServletException, IOException
	{
		Order order = model.queryOrder(request.getParameter("orderId"));
		// �����ѯ���Ϊnull���򲻽��и��ƣ�����NullPointerException
		if (order != null)
		{
			request.setAttribute("order", order);
			request.setAttribute("product", model.queryProduct(order));
			request.setAttribute("buyer", model.queryBuyer(order));
			request.setAttribute("seller", model.querySeller(order));
			request.setAttribute("orderState", orderState.get(order.getOrderState()));
		}
		request.getRequestDispatcher("/jsp/order/orderDetail.jsp").forward(request, response);
	}

	// ��ѯָ��������ģ����ѯ
	private void queryAppointedOrder(HttpServletRequest request, HttpServletResponse response,
			Map<Integer, String> orderState) throws ServletException, IOException
	{
		User user = (User) request.getSession().getAttribute("currentUser");
		int page = Integer.parseInt(request.getParameter("page"));
		boolean hasResult = false;
		boolean isAppointed = true;
		String orderId = request.getParameter("orderNumber");
		List<Order> orderList = new ArrayList<>();
		List<Order> orderListAll = model.queryOrderAll(orderId, user.getPermission(), user.getCompanyId());
		orderList = model.queryAppointedOrder(orderId, (page - 1) * 8, user.getPermission(), user.getCompanyId());
		int totalPages = orderListAll.size() % 8 == 0 ? orderListAll.size() / 8 : orderListAll.size() / 8 + 1;
		String[] orderStateArray = new String[8];
		if (orderList.size() > 0)
		{
			hasResult = true;
			int i = 0;
			for (Order o : orderList)
			{
				o.getOrderId();
				orderStateArray[i] = orderState.get(o.getOrderState());
				i++;
			}
		}
		request.setAttribute("page", page);
		request.setAttribute("orderId", orderId);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("orderList", orderList);
		request.setAttribute("orderStateArray", orderStateArray);
		request.setAttribute("hasResult", hasResult);
		request.setAttribute("isAppointed", isAppointed);
		request.getRequestDispatcher("/jsp/order/orderQuery.jsp").forward(request, response);
	}

	private void uploadImg(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		Order order = model.queryCompanyIdByOrderId(request.getParameter("orderId"));
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		ServletContext servletContext = this.getServletConfig().getServletContext();
		String realPath = servletContext.getRealPath(UPLOAD_DIR) + "/";
		String companyId = order.getBuyerCompanyId();
		String orderId = order.getOrderId();
		String ext = ".png";
		String result = companyId.substring(companyId.length() - 4);
		String fileName = result + orderId;
		String filePath = realPath + fileName + ext;
		File realPathFile = new File(realPath);
		if (!realPathFile.exists())
		{
			realPathFile.mkdirs();
		}

		FileOutputStream fos = new FileOutputStream(new File(filePath));
		ServletInputStream sis = request.getInputStream();
		byte[] b = new byte[1024];
		int len = 0;
		while ((len = sis.read(b)) != -1)
		{
			fos.write(b, 0, len);
		}

		sis.close();
		fos.close();
		order.setReceiptPath(UPLOAD_DIR + fileName);

		try
		{
			request.setAttribute("path", UPLOAD_DIR + fileName);
			resultMessage = model.updateReceiptPath(order) ? "�ϴ���ִ���ɹ�" : "�ϴ���ִ��ʧ��";
			request.setAttribute("orderId", order.getOrderId());
			request.setAttribute("result", resultMessage);
			request.getRequestDispatcher("/jsp/order/orderDetail.jsp").forward(request, response);

		} catch (ServletException e)
		{
			e.printStackTrace();
		}
	}

	private void wayBill(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		request.setCharacterEncoding("UTF-8");
		if (request.getParameter("orderId").length() == 16)
		{

			String startingplace = request.getParameter("startingplace");
			startingplace = new String(startingplace.getBytes("iso-8859-1"), "utf-8");
			String destination = request.getParameter("destination");
			destination = new String(destination.getBytes("iso-8859-1"), "utf-8");

			if (startingplace.equals("�ػʵ�") && destination.equals("��"))
			{
				Object[] options = { "��" };
				JOptionPane.showOptionDialog(null, "ѡ��ĵ�ַ�鲻���ڣ����������룡", "����", JOptionPane.DEFAULT_OPTION,
						JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				request.getRequestDispatcher("/jsp/order/waybillProduce.jsp").forward(request, response);
			} else if (startingplace.equals("���") && destination.equals("����"))
			{
				Object[] options = { "��" };
				JOptionPane.showOptionDialog(null, "ѡ��ĵ�ַ�鲻���ڣ����������룡", "����", JOptionPane.DEFAULT_OPTION,
						JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				request.getRequestDispatcher("/jsp/order/waybillProduce.jsp").forward(request, response);
			} else if (startingplace.equals("���") && destination.equals("����"))
			{
				Object[] options = { "��" };
				JOptionPane.showOptionDialog(null, "ѡ��ĵ�ַ�鲻���ڣ����������룡", "����", JOptionPane.DEFAULT_OPTION,
						JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				request.getRequestDispatcher("/jsp/order/waybillProduce.jsp").forward(request, response);
			} else if (startingplace.equals("���") && destination.equals("����"))
			{
				Object[] options = { "��" };
				JOptionPane.showOptionDialog(null, "ѡ��ĵ�ַ�鲻���ڣ����������룡", "����", JOptionPane.DEFAULT_OPTION,
						JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				request.getRequestDispatcher("/jsp/order/waybillProduce.jsp").forward(request, response);
			} else if (startingplace.equals("���") && destination.equals("�żҸ�"))
			{
				Object[] options = { "��" };
				JOptionPane.showOptionDialog(null, "ѡ��ĵ�ַ�鲻���ڣ����������룡", "����", JOptionPane.DEFAULT_OPTION,
						JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				request.getRequestDispatcher("/jsp/order/waybillProduce.jsp").forward(request, response);
			} else
			{

				LogisticsServiceImpl lsi = new LogisticsServiceImpl();
				Order order = model.queryCompanyIdByOrderId(request.getParameter("orderId"));
				WaybillInfo waybill = new WaybillInfo();
				Product product = model.queryProduct(order.getProductId());
				String productType = product.getProductType();
				float quantity = product.getQuantity();

				List<LogisticsPrice> logisticspricelist;
				List<Company> companylist = new ArrayList<>();
				List<Double> sumcostlist;

				try
				{
					logisticspricelist = lsi.priceGuide(startingplace, destination, quantity);
					for (int i = 0; i < logisticspricelist.size(); i++)
					{
						Company company = lsi.queryCompanyInfo(logisticspricelist.get(i).getWaybillCompanyId());
						companylist.add(company);
					}
					sumcostlist = lsi.sumcost(logisticspricelist, quantity);
				} catch (SQLException e)
				{
					sumcostlist = null;
					logisticspricelist = null;
					e.printStackTrace();
				}

				SimpleDateFormat dateformatContractIdTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String wayBillCreateTime = dateformatContractIdTime.format(System.currentTimeMillis());
				waybill.setCreateTime(wayBillCreateTime);
				String wayBillEndTime = dateformatContractIdTime.format(System.currentTimeMillis() + 86400000 * 15);
				waybill.setEndTime(wayBillEndTime);

				waybill.setOrderId(order.getOrderId());

				waybill.setWaybillCompanyId(logisticspricelist.get(0).getWaybillCompanyId());

				SimpleDateFormat time = new SimpleDateFormat("yyyyMMddHHmmss");
				String t = time.format(new Date());
				String l = logisticspricelist.get(0).getWaybillCompanyId();
				waybill.setWaybillId(t + l.substring(l.length() - 4, l.length()));
				waybill.setWaybillState("0");
				boolean state = model.insertWayBill(waybill);

				request.setAttribute("orderId", order.getOrderId());
				request.setAttribute("productType", productType);
				request.setAttribute("quantity", quantity);
				request.setAttribute("startingplace", startingplace);
				request.setAttribute("destination", destination);
				request.setAttribute("companynamelist", companylist.get(0));
				request.setAttribute("logisticspricelist", logisticspricelist.get(0));
				request.setAttribute("sumcostlist", sumcostlist.get(0));
				request.getRequestDispatcher("/jsp/order/confirm.jsp").forward(request, response);
			}
		} else
		{
			Object[] options = { "��" };
			JOptionPane.showOptionDialog(null, "���붩���Ŵ������������룡", "����", JOptionPane.DEFAULT_OPTION,
					JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			request.getRequestDispatcher("/jsp/order/waybillProduce.jsp").forward(request, response);
		}
	}
}
