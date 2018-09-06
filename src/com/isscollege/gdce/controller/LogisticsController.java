package com.isscollege.gdce.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.isscollege.gdce.domain.LogisticsInfo;
import com.isscollege.gdce.domain.Order;
import com.isscollege.gdce.domain.Product;
import com.isscollege.gdce.domain.User;
import com.isscollege.gdce.domain.WaybillInfo;
import com.isscollege.gdce.model.ILogisticsModel;
import com.isscollege.gdce.model.impl.LogisticsModelImpl;

@WebServlet("/logistics")
public class LogisticsController extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	private static int pagesize = 9;
	private String forward = "";
	private ILogisticsModel model;

	public LogisticsController()
	{
		model = new LogisticsModelImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Map<Integer, String> orderState = new HashMap<>();
		orderState.put(0, "������");
		orderState.put(1, "������");
		orderState.put(2, "���ջ�");
		orderState.put(3, "������");
		orderState.put(4, "���");

		forward = request.getParameter("forward");
		String queryResult = "";
		User user = null;
		user = (User) request.getSession().getAttribute("currentUser");
		String userid = user.getCompanyId();

		if (forward.equals("queryorder"))
		{

			int page = Integer.parseInt(request.getParameter("page"));
			List<Order> orderList = model.queryOrderOnPage((page - 1) * pagesize, userid);
			List<Order> orderListAll = model.queryOrderAll(userid);
			int totalPages = orderListAll.size() % pagesize == 0 ? orderListAll.size() / pagesize
					: orderListAll.size() / pagesize + 1;
			String[] orderStateArray = new String[pagesize];
			boolean hasResult = false;
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
			request.setAttribute("totalPages", totalPages);
			request.setAttribute("page", page);
			request.setAttribute("orderList", orderList);
			request.setAttribute("hasResult", hasResult);
			request.setAttribute("orderStateArray", orderStateArray);
			request.getRequestDispatcher("/jsp/logistics/waybillorder.jsp").forward(request, response);
		}
		// ���forward������ֵΪquery,���붩����ѯҳ
		if (forward.equals("query"))
		{
			String state = request.getParameter("state");
			int page = Integer.parseInt(request.getParameter("page"));
			// System.out.println(state);
			// System.out.println(page);
			if (state.equals("0") || state.equals("3"))
			{
				List<WaybillInfo> waybillList = model.queryWaybillOnPage((page - 1) * pagesize, state, userid);
				List<WaybillInfo> waybillListAll = model.queryWaybillByState(state, userid);
				int totalPages = waybillListAll.size() % pagesize == 0 ? waybillListAll.size() / pagesize
						: waybillListAll.size() / pagesize + 1;
				String[] waybillStateArray = new String[pagesize];
				boolean hasResult = false;
				if (waybillList.size() > 0)
				{
					hasResult = true;
				}
				// request.setAttribute("waybillStateArray", waybillStateArray);
				request.setAttribute("totalPages", totalPages);
				request.setAttribute("page", page);
				request.setAttribute("waybillList", waybillList);
				request.setAttribute("hasResult", hasResult);
				if (state.equals("0"))
				{
					request.setAttribute("waybillstate", "������");
					request.getRequestDispatcher("/jsp/logistics/waybillConfirm.jsp").forward(request,

							response);
				} else if (state.equals("3"))
				{
					request.setAttribute("waybillstate", "��ǩ��");
					request.getRequestDispatcher("/jsp/logistics/waybillFinish.jsp").forward(request,

							response);
				}
			}

			if (state.equals("1"))
			{
				String state1 = request.getParameter("state1");
				System.out.println(state1);
				List<WaybillInfo> waybillList = model.queryWaybillOnPageByTwoState((page - 1) * pagesize, state, state1,
						userid);
				List<WaybillInfo> waybillListAll = model.queryWaybillByTwoState(state, state1, userid);
				int totalPages = waybillListAll.size() % pagesize == 0 ? waybillListAll.size() / pagesize
						: waybillListAll.size() / pagesize + 1;
				String[] waybillStateArray = new String[pagesize];
				System.out.println(waybillList);
				System.out.println(totalPages);
				boolean hasResult = false;

				if (waybillList.size() > 0)
				{
					hasResult = true;
				}
				request.setAttribute("waybillStateArray", waybillStateArray);
				request.setAttribute("totalPages", totalPages);
				request.setAttribute("page", page);
				request.setAttribute("waybillList", waybillList);
				request.setAttribute("hasResult", hasResult);
				request.getRequestDispatcher("/jsp/logistics/waybillTransport.jsp").forward(request, response);
			}
		}

		String msg = "";
		if (forward.equals("changestate"))
		{
			String waybillid = request.getParameter("waybillId");
			String state = request.getParameter("state");
			int changeState = Integer.parseInt(request.getParameter("state")) + 1;
			String Cstate = "" + changeState;
			try
			{
				boolean result = model.updateWaybillState(Cstate, waybillid);
				if (result)
				{
					msg = "�˵�ȷ�ϳɹ�";
				} else
				{
					msg = "�˵�ȷ��ʧ��";
				}
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("state:" + state);
			System.out.println("Cstate:" + Cstate);
			System.out.println(msg);

			int page = Integer.parseInt(request.getParameter("page"));
			System.out.println(page);

			List<WaybillInfo> waybillList = model.queryWaybillOnPage((page - 1) * pagesize, state, userid);
			List<WaybillInfo> waybillListAll = model.queryWaybillByState(state, userid);
			int totalPages = waybillListAll.size() % pagesize == 0 ? waybillListAll.size() / pagesize
					: waybillListAll.size() / pagesize + 1;
			String[] waybillStateArray = new String[pagesize];
			boolean hasResult = false;

			if (waybillList.size() > 0)
			{
				hasResult = true;
			}
			request.setAttribute("msg", msg);
			request.setAttribute("totalPages", totalPages);
			request.setAttribute("page", page);
			request.setAttribute("waybillList", waybillList);
			request.setAttribute("hasResult", hasResult);
			request.setAttribute("waybillstate", "������");
			request.getRequestDispatcher("/jsp/logistics/waybillConfirm.jsp").forward(request, response);

		}
		// ���forward������ֵΪfollow,�����˵�����չʾҳ
		if (forward.equals("follow"))
		{
			String waybillId = "";
			if (user.getPermission().equals("2") || user.getPermission().equals("3"))
			{
				try
				{
					waybillId = model.queryWaybillByOrderId(request.getParameter("orderId"));
					//waybillId="";
					System.out.println("�˵��ţ�" + waybillId);
				} catch (SQLException e1)
				{
					waybillId = "";
					e1.printStackTrace();
				}
			} else if (user.getPermission().equals("4"))
			{
				// ��ȡǰ�˴�����˵���
				waybillId = StringUtils.defaultString(request.getParameter("waybillId"), "null");
			}

			// ���û�ȡ������Ϣ����
			getlogisticsinfo(request, waybillId);
			try
			{
				// ���û�ȡ��Ʒ��Ϣ����
				getproductinfo(request, waybillId);
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
			// ��ת��������Ϣ����ҳ��
			request.getRequestDispatcher("/jsp/logistics/logisticsQuery.jsp").forward(request, response);

		}
		if (forward.equals("insert"))
		{
			String waybillId = request.getParameter("waybillId");
			String submitUser = request.getParameter("submituser");
			String location = request.getParameter("location");
			String content = request.getParameter("content");
			String state = request.getParameter("state");
			String state1 = request.getParameter("state1");
			int page = Integer.parseInt(request.getParameter("page"));
			String resultMessage = "";
			if (!location.equals("") && !content.equals("") && !submitUser.equals(""))
			{
				Date dateNow = new Date(System.currentTimeMillis());
				String updateDate = dateNow.toString();
				LogisticsInfo logisticsInfo = new LogisticsInfo();
				logisticsInfo.setWaybillId(waybillId);
				logisticsInfo.setSubmitUser(submitUser);
				logisticsInfo.setLocation(location);
				logisticsInfo.setContent(content);
				logisticsInfo.setUpdateDate(updateDate);
				if(model.insertLogisticsInfo(logisticsInfo)){
					resultMessage = "�ύ�ɹ�";
				}else
					resultMessage ="�ύʧ��";
			}

			// request.getRequestDispatcher("gdce/logistics?forward=query&state="
			// + state + "&page=" + page + "&state1=" + state1)
			// .forward(request, response);
			List<WaybillInfo> waybillList = model.queryWaybillOnPageByTwoState((page - 1) * pagesize, state, state1,
					userid);
			List<WaybillInfo> waybillListAll = model.queryWaybillByTwoState(state, state1, userid);
			int totalPages = waybillListAll.size() % pagesize == 0 ? waybillListAll.size() / pagesize
					: waybillListAll.size() / pagesize + 1;
			String[] waybillStateArray = new String[pagesize];
			System.out.println(waybillList);
			System.out.println(totalPages);
			boolean hasResult = false;

			if (waybillList.size() > 0)
			{
				hasResult = true;
			}
			request.setAttribute("resultMessage", resultMessage);
			request.setAttribute("waybillStateArray", waybillStateArray);
			request.setAttribute("totalPages", totalPages);
			request.setAttribute("page", page);
			request.setAttribute("waybillList", waybillList);
			request.setAttribute("hasResult", hasResult);
			request.getRequestDispatcher("/jsp/logistics/waybillTransport.jsp").forward(request, response);
		}

		if (forward.equals("changeOrderId"))
		{
			String waybillid = request.getParameter("waybillId");
			String state = request.getParameter("state");
			String state1 = request.getParameter("state1");
			String orderId = request.getParameter("orderId");
			int page = Integer.parseInt(request.getParameter("page"));
			int changeState = Integer.parseInt(request.getParameter("changestate")) + 1;
			String Cstate = "" + changeState;
			boolean result = model.updateOrderState(changeState, orderId);
			System.out.println(state);
			System.out.println(state1);
			System.out.println(orderId);
			System.out.println(page);
			try
			{
				boolean result1 = model.updateWaybillState(Cstate, waybillid);
				System.out.println(result1);
				if (result1)
				{
					msg = "�˵�ȷ�ϳɹ�";
				} else
				{
					msg = "�˵�ȷ��ʧ��";
				}
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<WaybillInfo> waybillList = model.queryWaybillOnPageByTwoState((page - 1) * pagesize, state, state1,
					userid);
			List<WaybillInfo> waybillListAll = model.queryWaybillByTwoState(state, state1, userid);
			int totalPages = waybillListAll.size() % pagesize == 0 ? waybillListAll.size() / pagesize
					: waybillListAll.size() / pagesize + 1;
			String[] waybillStateArray = new String[pagesize];
			System.out.println(waybillList);
			System.out.println(totalPages);
			boolean hasResult = false;

			if (waybillList.size() > 0)
			{
				hasResult = true;
			}
			request.setAttribute("waybillStateArray", waybillStateArray);
			request.setAttribute("totalPages", totalPages);
			request.setAttribute("page", page);
			request.setAttribute("waybillList", waybillList);
			request.setAttribute("hasResult", hasResult);
			request.getRequestDispatcher("/jsp/logistics/waybillTransport.jsp").forward(request, response);

		}

	}

	// ͨ���˵��Ż�ȡ������Ϣ����
	public HttpServletRequest getlogisticsinfo(HttpServletRequest request, String waybillId)
	{
		List<LogisticsInfo> logisticsinfo;
		try
		{
			// ͨ���˵��Ż�ȡ������Ϣ
			logisticsinfo = model.queryLogisticsInfo(waybillId);
		} catch (SQLException e)
		{
			logisticsinfo = null;
			e.printStackTrace();
		}
		// �����Ϣ��ȡ�ɹ��������ݷ��ص�ǰ��
		if (logisticsinfo != null)
		{
			request.setAttribute("logisticsinfo", logisticsinfo);
			request.setAttribute("test1", "success");
		}
		return request;
	}

	// ͨ���˵��Ż�ȡ��Ʒ�����Ϣ����
	public HttpServletRequest getproductinfo(HttpServletRequest request, String waybillId) throws SQLException
	{
		// ͨ���˵�id��ȡ��Ӧ���˵���Ϣ
		WaybillInfo waybillinfo = model.queryWaybillInfoByWaybillId(waybillId);
		// ������ص��˵����ݲ�Ϊ��
		if (waybillinfo != null)
		{
			// ��ȡ��������ҵ��������
			String waybillCompanyId = StringUtils.defaultString(waybillinfo.getWaybillCompanyId(), "--");
			// ��ȡ������
			String orderId = StringUtils.defaultString(waybillinfo.getOrderId(), "--");
			// ͨ����������ҵ���������ȡ�����̹�˾����
			String companyName = StringUtils.defaultString(model.queryCompanyInfo(waybillCompanyId).getCompanyName(),
					"--");
			// ͨ�������Ż�ȡ������Ʒ��Ϣ
			Product product = model.queryProductByOrderId(orderId);
			String waybillState = "";
			// ��ȡ�˵�״̬
			if (waybillinfo.getWaybillState().equals("0"))
				waybillState = "������";
			else if (waybillinfo.getWaybillState().equals("1"))
				waybillState = "������";
			else if (waybillinfo.getWaybillState().equals("2"))
				waybillState = "��ǩ��";
			else if (waybillinfo.getWaybillState().equals("3"))
				waybillState = "��ǩ��";
			// �������Ϣ����
			request.setAttribute("waybillId", waybillId);
			request.setAttribute("companyName", companyName);
			request.setAttribute("product", product);
			request.setAttribute("waybillState", waybillState);
			request.setAttribute("test2", "success");
		}
		return request;
	}
}
