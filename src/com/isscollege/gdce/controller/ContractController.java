package com.isscollege.gdce.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.isscollege.gdce.domain.Contract;
import com.isscollege.gdce.domain.Product;
import com.isscollege.gdce.domain.User;
import com.isscollege.gdce.model.IContractModel;
import com.isscollege.gdce.model.impl.ContractModelImpl;

@WebServlet("/contract")
public class ContractController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IContractModel model;
	private String forward = "";

	List<Contract> result = null;

	public ContractController() {
		model = new ContractModelImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		forward = request.getParameter("forward");
		if (StringUtils.equalsIgnoreCase(forward, "InsertContract")) {

			request.setCharacterEncoding("UTF-8");

			HttpSession session = request.getSession();
			Contract contract = (Contract) session.getAttribute("contract");
			
			SimpleDateFormat dateformatContractIdTime = new SimpleDateFormat("MMddHHmmss");
			String ContractIdTime = dateformatContractIdTime.format(System.currentTimeMillis());
			long ContractId = Long.parseLong(ContractIdTime);
			
			contract.setContractId(ContractId);
			contract.setBuyerContractState(true);
			contract.setSellerContractState(false);

			SimpleDateFormat dateformatContractCreateDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateformatstarttime = dateformatContractCreateDate.format(System.currentTimeMillis());
			contract.setCreateDate(dateformatstarttime);
			String dateformatendtime = dateformatContractCreateDate.format(System.currentTimeMillis() + 86400000);
			contract.setEndDate(dateformatendtime);

			boolean state = model.addContract(contract);
			if (!state) {
				request.getRequestDispatcher("/trade/delist.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/jsp/contract/success.jsp").forward(request, response);
			}
		} 
		else if (StringUtils.equalsIgnoreCase(forward, "UpdateProductState")) {

			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");

			HttpSession session = request.getSession();
			Product product = (Product) session.getAttribute("product");
			model.updateProductStatezero(product);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else if (StringUtils.equalsIgnoreCase(forward, "querylist")) {

			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");

			HttpSession session = request.getSession();

			User user = (User) session.getAttribute("currentUser");
			String companyID = user.getCompanyId();
			session.setAttribute("companyID", companyID);

			if (StringUtils.isNotEmpty(companyID)) {
				// 查询
				result = model.querConstractById(companyID);
				session.setAttribute("contracts", result);
			}

			// 跳转
			request.getRequestDispatcher("/jsp/contract/contractEnsure.jsp").forward(request, response);
		} else if (StringUtils.equalsIgnoreCase(forward, "ensurelist")) {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");

			HttpSession session = request.getSession();
			@SuppressWarnings("unchecked")
			List<Contract> contracts = (List<Contract>) session.getAttribute("contracts");

			int i = Integer.valueOf(request.getParameter("ensureID"));
			Contract contract = contracts.get(i);
			String contractID = Long.toString(contract.getContractId());
			// 传参到订单
			session.setAttribute("contract", contract);

			// 更新
			int state = model.updateState(contract, contractID);
			if (state != 0) {
				// 跳转
				request.getRequestDispatcher("/order?forward=orderCreate").forward(request,
						response);

			} else {
				request.setAttribute("message", "合同签订失败，请重新确认");
			}

		}
	}
}
